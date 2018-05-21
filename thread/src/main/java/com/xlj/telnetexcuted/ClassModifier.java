package com.xlj.telnetexcuted;

import com.xlj.classtest.ClassA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassModifier {

    /**
     * class文件中常量池的其实偏移位
     */
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    /**
     * CONSTANT_Utf8_info常量的tag标志
     */
    private static final int CONSTANT_Utf8_info = 1;
    private static final int CONSTANT_Class_info = 7;
    private static final int CONSTANT_Fieldref_info = 9;
    private static final int CONSTANT_Methodref_info = 10;
    private static final int CONSTANT_NameAndType_info = 12;

    private Map<Integer, String> constantMap = new HashMap<>();
    private Map<Integer, List<Integer>> classMap =
            new HashMap<>();
    private Map<Integer, List<Integer>> methodMap =
            new HashMap<>();
    private Map<Integer, List<Integer>> fieldMap =
            new HashMap<>();
    private Map<Integer, List<Integer>> nameAndTypeMap =
            new HashMap<>();

    /**
     * 11种常量所占的长度, CONSTANT_Utf8_info 除外, 因为它不是定长的
     */
    private static final int[] CONSTANT_ITEM_LENGTH =
            {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};

    private static final int u1 = 1;

    private static final int u2 = 2;

    private byte[] classByte;

    public  ClassModifier(byte[] classByte)
    {
        this.classByte = classByte;
    }

    private int getConstantPoolCount()
    {
        return ByteUtils.bytes2Int(this.classByte,
                ClassModifier.CONSTANT_POOL_COUNT_INDEX,
                u2);
    }


    private int getConstantEndOffsetByIndex(int index)
    {
        int resultOffset = 0;

        int cpc = this.getConstantPoolCount();

        int offset = ClassModifier.CONSTANT_POOL_COUNT_INDEX + u2;

        //index begin 1, last is 0
        for(int i = 1; i < cpc + 1; i++)
        {
            int tag = ByteUtils.bytes2Int(this.classByte, offset, u1);

            if(tag == ClassModifier.CONSTANT_Utf8_info)
            {
                int length = ByteUtils.bytes2Int(
                        this.classByte, offset + u1, u2);
                offset += u1 + u2 + length;
            }
            else {
                offset += ClassModifier.CONSTANT_ITEM_LENGTH[tag];
            }

            if(i == index)
            {
                resultOffset = offset;
                break;
            }
        }

        return resultOffset;
    }

    private int getConstantStartOffsetByIndex(int index)
    {
        int resultOffset = 0;

        int cpc = this.getConstantPoolCount();

        int offset = ClassModifier.CONSTANT_POOL_COUNT_INDEX + u2;

        //index begin 1, last is 0
        for(int i = 1; i < cpc + 1; i++)
        {

            if(i == index)
            {
                resultOffset = offset;
                break;
            }

            int tag = ByteUtils.bytes2Int(this.classByte, offset, u1);

            if(tag == ClassModifier.CONSTANT_Utf8_info)
            {
                int length = ByteUtils.bytes2Int(
                        this.classByte, offset + u1, u2);
                offset += u1 + u2 + length;
            }
            else {
                offset += ClassModifier.CONSTANT_ITEM_LENGTH[tag];
            }

        }

        return resultOffset;
    }

    private int getConstantTagByIndex(int index)
    {
        int resultTag = 0;

        int cpc = this.getConstantPoolCount();

        int offset = ClassModifier.CONSTANT_POOL_COUNT_INDEX + u2;

        for(int i = 1; i < cpc + 1; i++)
        {
            int tag = ByteUtils.bytes2Int(this.classByte, offset, u1);
            if(i == index)
            {
                resultTag = tag;
                break;
            }

            if(tag == ClassModifier.CONSTANT_Utf8_info)
            {
                int length = ByteUtils.bytes2Int(
                        this.classByte, offset + u1, u2);
                offset += u1 + u2 + length;
            }
            else {
                offset += ClassModifier.CONSTANT_ITEM_LENGTH[tag];
            }
        }

        return resultTag;
    }


    private int getConstantUtfIndexByString(String str)
    {
        int resultIndex = 0;
        int cpc = this.getConstantPoolCount();

        int offset = ClassModifier.CONSTANT_POOL_COUNT_INDEX + u2;

        for(int i = 1; i < cpc + 1; i++)
        {
            int tag = ByteUtils.bytes2Int(this.classByte, offset, u1);

            if(tag == ClassModifier.CONSTANT_Utf8_info)
            {
                int length = ByteUtils.bytes2Int(
                        this.classByte, offset + u1, u2);

                String strValue = ByteUtils.bytes2String(
                        this.classByte, offset + u1 + u2, length);

                if(strValue.equalsIgnoreCase(str))
                {
                    resultIndex = i;
                    break;
                }

                offset += u1 + u2 + length;
            }
            else {
                offset += ClassModifier.CONSTANT_ITEM_LENGTH[tag];
            }
        }

        return resultIndex;
    }


    private int getConstantUtf8LengthByIndex(int index)
    {
        int len = 0;

        int cpc = this.getConstantPoolCount();

        int offset = ClassModifier.CONSTANT_POOL_COUNT_INDEX + u2;

        for(int i = 1; i < cpc + 1; i++)
        {
            int tag = ByteUtils.bytes2Int(this.classByte, offset, u1);

            if(tag == ClassModifier.CONSTANT_Utf8_info)
            {
                int length = ByteUtils.bytes2Int(
                        this.classByte, offset + u1, u2);
                offset += u1 + u2 + length;

                if(i == index)
                {
                    len = length;
                    break;
                }
            }
            else {
                offset += ClassModifier.CONSTANT_ITEM_LENGTH[tag];
            }
        }

        return len;
    }

    private void initConstantMaps()
    {
        this.methodMap.clear();
        this.nameAndTypeMap.clear();
        this.classMap.clear();
        this.constantMap.clear();

        int cpc = this.getConstantPoolCount();
        int offset = ClassModifier.CONSTANT_POOL_COUNT_INDEX +
                ClassModifier.u2;

        for(int i = 1; i < cpc + 1; i++)
        {
            int constantIndex = i;
            int tag = ByteUtils.bytes2Int(this.classByte, offset, u1);

            if(tag == ClassModifier.CONSTANT_NameAndType_info)
            {
                this.nameAndTypeMap.putIfAbsent(constantIndex, new ArrayList<>());

                this.nameAndTypeMap.get(constantIndex).add(
                        ByteUtils.bytes2Int(this.classByte,
                                offset + this.u1,
                                this.u2));

                this.nameAndTypeMap.get(constantIndex).add(
                        ByteUtils.bytes2Int(this.classByte,
                                offset + this.u1 + u2,
                                this.u2));
            }

            if(tag == ClassModifier.CONSTANT_Class_info)
            {
                this.classMap.putIfAbsent(constantIndex, new ArrayList<>());

                this.classMap.get(constantIndex).add(
                        ByteUtils.bytes2Int(this.classByte,
                                offset + this.u1,
                                this.u2));
            }

            if(tag == ClassModifier.CONSTANT_Fieldref_info)
            {
                this.fieldMap.putIfAbsent(constantIndex, new ArrayList<>());

                this.fieldMap.get(constantIndex).add(
                        ByteUtils.bytes2Int(this.classByte,
                                offset + this.u1,
                                this.u2));

                this.fieldMap.get(constantIndex).add(
                        ByteUtils.bytes2Int(this.classByte,
                                offset + this.u1 + u2,
                                this.u2));
            }

            if(tag == ClassModifier.CONSTANT_Methodref_info)
            {
                this.methodMap.putIfAbsent(constantIndex, new ArrayList<>());

                this.methodMap.get(constantIndex).add(
                        ByteUtils.bytes2Int(this.classByte,
                                offset + this.u1,
                                this.u2));

                this.methodMap.get(constantIndex).add(
                        ByteUtils.bytes2Int(this.classByte,
                                offset + this.u1 + u2,
                                this.u2));
            }

            if(tag == ClassModifier.CONSTANT_Utf8_info)
            {
                int len = ByteUtils.bytes2Int(this.classByte, offset + u1, u2);
                offset += (u1 + u2);
                String str = ByteUtils.bytes2String(this.classByte, offset, len);
                offset += len;
                this.constantMap.put(constantIndex, str);
            }
            else
            {
                offset += ClassModifier.CONSTANT_ITEM_LENGTH[tag];
            }
        }
    }

    public byte[] constantPoolUtf8Replace(String strOld, String strNew)
    {
        int offset = ClassModifier.CONSTANT_POOL_COUNT_INDEX;
        int cpc = this.getConstantPoolCount();
        offset += u2;

        for (int i = 1; i < offset + 1; i++ )
        {
            int tag = this.getConstantTagByIndex(i);
            if(tag == ClassModifier.CONSTANT_Utf8_info)
            {
                int len = ByteUtils.bytes2Int(
                        this.classByte, offset + u1, u2);
                String constantValue =
                        ByteUtils.bytes2String(
                                this.classByte,
                                offset + u1 + u2,
                                len);

                if(constantValue.equalsIgnoreCase(strOld))
                {
                    byte[] b = ByteUtils.string2Bytes(strNew);
                    byte[] bLength = ByteUtils.int2Bytes(b.length, u2);

                    this.classByte =
                            ByteUtils.bytesReplace(
                                    this.classByte,
                                    offset + u1 + u2,
                                    len,
                                    b);

                    this.classByte =
                            ByteUtils.bytesReplace(
                                    this.classByte,
                                    offset + u1,
                                    u2,
                                    bLength);

                    offset += u1 + u2 + b.length;
                }
                else {
                    offset += u1 + u2 + len;
                }
            }
            else
            {
                offset += ClassModifier.CONSTANT_ITEM_LENGTH[tag];
            }
        }

        return this.classByte;
    }

    public byte[] addConstantPoolUtf8(String newConstant) {

        int offset = ClassModifier.CONSTANT_POOL_COUNT_INDEX;
        int cpc = this.getConstantPoolCount();

        //last is 0
        int constantOffset = this.getConstantEndOffsetByIndex(cpc - 1);
        int tag = this.getConstantTagByIndex(cpc - 1);
        int len = this.getConstantUtf8LengthByIndex(cpc - 1);

        cpc += 1;
        byte[] bCpc = ByteUtils.int2Bytes(cpc, u2);
        this.classByte = ByteUtils.bytesReplace(this.classByte, offset, u2, bCpc);
        offset += u2;

        byte[] bTag = ByteUtils.int2Bytes(ClassModifier.CONSTANT_Utf8_info, u1);
        byte[] bConstant = ByteUtils.string2Bytes(newConstant);
        byte[] bLength = ByteUtils.int2Bytes(bConstant.length, u2);

        this.classByte = ByteUtils.addBytes(classByte, constantOffset, bTag);
        constantOffset += bTag.length;
        this.classByte = ByteUtils.addBytes(classByte, constantOffset, bLength);
        constantOffset += bLength.length;
        this.classByte = ByteUtils.addBytes(classByte, constantOffset, bConstant);
        constantOffset += bConstant.length;

        return this.classByte;
    }

    public byte[] addConstantPoolClass(String newConstant) {

        int offset = ClassModifier.CONSTANT_POOL_COUNT_INDEX;
        int cpc = this.getConstantPoolCount();

        //last is 0
        int constantOffset = this.getConstantEndOffsetByIndex(cpc - 1);
        int tag = this.getConstantTagByIndex(cpc - 1);
        int len = this.getConstantUtf8LengthByIndex(cpc - 1);

        byte[] bTag = ByteUtils.int2Bytes(ClassModifier.CONSTANT_Class_info, u1);
        byte[] bIndex = ByteUtils.int2Bytes(
                this.getConstantUtfIndexByString(newConstant), u2);

        this.classByte = ByteUtils.addBytes(classByte, constantOffset, bTag);
        constantOffset += bTag.length;
        this.classByte = ByteUtils.addBytes(classByte, constantOffset, bIndex);
        constantOffset += bIndex.length;

        cpc += 1;
        byte[] bCpc = ByteUtils.int2Bytes(cpc, u2);
        this.classByte = ByteUtils.bytesReplace(this.classByte, offset, u2, bCpc);
        offset += u2;

        return this.classByte;
    }

    public byte[] methodClassReplace(String strOldClass,
                                     String strNewClass,
                                     String field)
    {
        this.initConstantMaps();

        int indexOldClass = 0;
        int indexNewClass = 0;

        for(int index : this.classMap.keySet())
        {
            if(this.constantMap.get(
                    this.classMap.get(index).get(0)
            ).equalsIgnoreCase(strOldClass))
            {
                indexOldClass = index;
            }

            if(this.constantMap.get(
                    this.classMap.get(index).get(0)
            ).equalsIgnoreCase(strNewClass))
            {
                indexNewClass = index;
            }
        }

        int cpc = this.getConstantPoolCount();
        int offset = ClassModifier.CONSTANT_POOL_COUNT_INDEX + u2;

        for(int i = 1; i < cpc + 1; i++)
        {
            int tag = this.getConstantTagByIndex(i);
            if(tag == ClassModifier.CONSTANT_Utf8_info)
            {
                int len = ByteUtils.bytes2Int(
                        this.classByte, offset + u1, u2);
                offset += u1 + u2 + len;
            }
            else if(tag == ClassModifier.CONSTANT_Methodref_info)
            {

                int indexClass = ByteUtils.bytes2Int(
                        this.classByte, offset + u1, u2);
                if(indexClass == indexOldClass) {
                    int indexNameAndTypeIndex = ByteUtils.bytes2Int(
                            this.classByte, offset + u1 + u2, u2);
                    int indexNameAndTypeIndexOffset =
                            this.getConstantStartOffsetByIndex(
                                    indexNameAndTypeIndex);
                    int indexNameAndTypeUtf8Index =
                            ByteUtils.bytes2Int(this.classByte,
                                    indexNameAndTypeIndexOffset + u1, u2);
                    String constantValue = this.constantMap.get(indexNameAndTypeUtf8Index);

                    if (constantValue.equalsIgnoreCase(field)) {
                        indexClass = indexNewClass;
                        byte[] b = ByteUtils.int2Bytes(indexClass, u2);
                        this.classByte = ByteUtils.bytesReplace(
                                this.classByte, offset + u1, b.length, b);
                    }
                }

                offset += ClassModifier.CONSTANT_ITEM_LENGTH[tag];
            }
            else
            {
                offset += ClassModifier.CONSTANT_ITEM_LENGTH[tag];
            }

        }

        this.initConstantMaps();

        return this.classByte;
    }

    public byte[] fieldClassReplace(String strOldClass,
                                    String strNewClass,
                                    String field)
    {
        this.initConstantMaps();

        int indexOldClass = 0;
        int indexNewClass = 0;

        for(int index : this.classMap.keySet())
        {
            if(this.constantMap.get(
                    this.classMap.get(index).get(0)
            ).equalsIgnoreCase(strOldClass))
            {
                indexOldClass = index;
            }

            if(this.constantMap.get(
                    this.classMap.get(index).get(0)
            ).equalsIgnoreCase(strNewClass))
            {
                indexNewClass = index;
            }
        }

        int cpc = this.getConstantPoolCount();
        int offset = ClassModifier.CONSTANT_POOL_COUNT_INDEX + u2;

        for(int i = 1; i < cpc + 1; i++)
        {
            int tag = this.getConstantTagByIndex(i);
            if(tag == ClassModifier.CONSTANT_Utf8_info)
            {
                int len = ByteUtils.bytes2Int(
                        this.classByte, offset + u1, u2);
                offset += u1 + u2 + len;
            }
            else if(tag == ClassModifier.CONSTANT_Fieldref_info)
            {

                int indexClass = ByteUtils.bytes2Int(
                        this.classByte, offset + u1, u2);
                if(indexClass == indexOldClass) {
                    int indexNameAndTypeIndex = ByteUtils.bytes2Int(
                            this.classByte, offset + u1 + u2, u2);
                    int indexNameAndTypeIndexOffset =
                            this.getConstantStartOffsetByIndex(
                                    indexNameAndTypeIndex);
                    int indexNameAndTypeUtf8Index =
                            ByteUtils.bytes2Int(this.classByte,
                                    indexNameAndTypeIndexOffset + u1, u2);
                    String constantValue = this.constantMap.get(indexNameAndTypeUtf8Index);

                    if (constantValue.equalsIgnoreCase(field)) {
                        indexClass = indexNewClass;
                        byte[] b = ByteUtils.int2Bytes(indexClass, u2);
                        this.classByte = ByteUtils.bytesReplace(
                                this.classByte, offset + u1, b.length, b);
                    }
                }

                offset += ClassModifier.CONSTANT_ITEM_LENGTH[tag];
            }
            else
            {
                offset += ClassModifier.CONSTANT_ITEM_LENGTH[tag];
            }

        }

        this.initConstantMaps();

        /**
         * 输出组装后的方法
         */
        for(int key : this.methodMap.keySet())
        {
            String strMethod = "";

            List<Integer> listDescription = this.methodMap.get(key);
            int classIndex = listDescription.get(0);
            int nameAndTypeIndex = listDescription.get(1);
            List<Integer> listNameAndType =
                    this.nameAndTypeMap.get(nameAndTypeIndex);
            int nameIndex = listNameAndType.get(0);
            int typeIndex = listNameAndType.get(1);

            strMethod += this.constantMap.get(
                    this.classMap.get(classIndex).get(0)) + "->";

            strMethod += this.constantMap.get(nameIndex) + ":";

            strMethod += this.constantMap.get(typeIndex);

            System.out.println(strMethod);
        }

        System.out.println("------------------");

        /**
         * 字段
         */
        for(int key : this.fieldMap.keySet())
        {
            String strMethod = "";

            List<Integer> listDescription = this.fieldMap.get(key);
            int classIndex = listDescription.get(0);
            int nameAndTypeIndex = listDescription.get(1);
            List<Integer> listNameAndType =
                    this.nameAndTypeMap.get(nameAndTypeIndex);
            int nameIndex = listNameAndType.get(0);
            int typeIndex = listNameAndType.get(1);

            strMethod += this.constantMap.get(
                    this.classMap.get(classIndex).get(0)) + "->";

            strMethod += this.constantMap.get(nameIndex) + ":";

            strMethod += this.constantMap.get(typeIndex);

            System.out.println(strMethod);
        }


        return this.classByte;
    }

}