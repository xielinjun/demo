package com.xlj.chapter28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class AppTest {

    public static void main(String[] args) {

        java.util.List<?> list = null;
        java.util.List<String> list1 = (java.util.List<String>)list;
        list = list1;

        java.util.List<Integer> listNumbers =
                new ArrayList<>();
        Stack<Number> numberStack = null;

        AppTest.<Number>reduce(listNumbers, numberStack, null);
    }

    public static void testPushAll()
    {

        Stack<Number> numberStack = new StackImpl<>();
        java.util.List<Number> listNumbers = new ArrayList<>();
        listNumbers.add(1F);
        listNumbers.add(2D);
        listNumbers.add(3);
        listNumbers.add(4L);

        java.util.List<Integer> listNumbers1 = new ArrayList<>();
        listNumbers1.add(5);
        listNumbers1.add(6);

        for (int i = 0; i < 10000; i++)
        {
            numberStack.push(i);
        }

        numberStack.pushAll(listNumbers);
        numberStack.pushAll(listNumbers1);

        //execption
        //numberStack.pushAll1(listNumbers1);

        for (int i = 0; i < 10000; i++)
        {
            System.out.println(numberStack.pop());
        }
    }

    public static void testPopAll()
    {

        Stack<Number> numberStack = new StackImpl<>();
        java.util.List<Number> listNumbers = new ArrayList<>();
        listNumbers.add(1F);
        listNumbers.add(2D);
        listNumbers.add(3);
        listNumbers.add(4L);

        java.util.List<Integer> listNumbers1 = new ArrayList<>();
        listNumbers1.add(5);
        listNumbers1.add(6);

        for (int i = 0; i < 10000; i++)
        {
            numberStack.push(i);
        }

        numberStack.pushAll(listNumbers);
        numberStack.pushAll(listNumbers1);

//        java.util.List<Number> listDst = new ArrayList<>();
//        numberStack.popAll(listDst);

        java.util.List<Object> listDst1 = new ArrayList<>();
        numberStack.popAll(listDst1);

        for (int i = 0; i < listDst1.size(); i++)
        {
            System.out.println(listDst1.get(i));
        }
    }

    public static <T> void reduce(java.util.List<? extends T> src, Stack<T> stack, T value)
    {

    }

    interface Stack<E>
    {
        int size();
        boolean isEmpty();
        void push(E e);
        E pop();

        void pushAll(Iterable<? extends E> src);

        void popAll(Collection<? super E> dst);

        void pushAll1(Iterable<E> src);
    }

    public static class StackImpl<E> implements Stack<E>
    {

        private static final int DEFAULTSIZE = 16;
        E[] elements;
        int size = 0;

        @SuppressWarnings("unchecked")
        public StackImpl()
        {
            this.elements = (E[])new Object[StackImpl.DEFAULTSIZE];
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean isEmpty() {
            return this.size == 0;
        }

        @Override
        public void push(E e) {
            this.ensureCapacity();
            this.elements[size++] = e;
        }

        @Override
        public void popAll(Collection<? super E> dst) {
            while (!this.isEmpty())
            {
                dst.add(this.pop());
            }
        }

        @Override
        public E pop() {

            E resuntl = this.elements[--this.size];
            this.elements[this.size] = null;

            return resuntl;
        }

        @Override
        public void pushAll(Iterable<? extends E> src) {
            for (E element:src) {
                this.push(element);
            }
        }

        @Override
        public void pushAll1(Iterable<E> src) {
            for (E element:src) {
                this.push(element);
            }
        }

        private void ensureCapacity()
        {
            if(this.elements.length == this.size)
            {
                this.elements = Arrays.copyOf(this.elements, this.size * 2 + 1);
            }
        }
    }
}
