package com.xlj.telnetexcuted;

import java.util.ArrayList;
import java.util.List;

public class TestClass
{

	private final int fi = 123;	
	protected final int fi2 = 1234;
	public final int fi3 = 12345;
	
	public static int s1 = 123456;
	public static final int s2 = 123457;	

	private int m;

	private String str = "nihaonihaonihaonihaonihaonihaonihaonihaonihaonihaonihaonihaonihaonihaonihao";

	List<Integer> list = new ArrayList<Integer>();

//	public Integer paradigm(List<Integer> list)
//	{
//		return 100;
//	}
//
//	public String paradigm(List<String> list)
//	{
//		return "dddddddd";
//	}

	public int inc()
	{
		list.add(123);
		return m + 1 + list.get(0);	
	}

	public String getStr()
	{
		return str;	
	}

	public String getStr1()
	{
		String str1 = str + "aaaa";
		return "sss";	
	}

	public int calc()
	{
		int sum = 1 + 100 + 500;		
		
		int a = 100;
		int b = 200;
		int c = 300;

		return (a + b) * c;
	}

	public int calc1()
	{
		int a = calc();
		int c = 100 + calc();

		return calc();
	}

	public final int calc2()
	{
		int a = calc();
		int c = 100 + calc();

		return calc();
	}

	private final int calc3()
	{
		return calc2() + 1000000000;
	}

	private final int calc4()
	{
		return calc3() + 100;
	}

	public final int calc5()
	{
		return calc4();	
	}

	public void calc6()
	{
		long l1 = 10000;
		long l2 = 10000;

	}

	public int calc7(int arg1, int arg2, int arg3, int arg4, int arg5)
	{
		long l1 = 10000;
		long l2 = 10000;

		long lsum = l1 + l2;			
	
		return 10;
	}

	public int calc8()
	{
		int arg1 = 1;
		int arg2 = 2;
		int arg3 = 3;
		int arg4 = 4;
		int arg5 = 5;
		int arg6 = 6;
		int arg7 = 7;

		calc7(arg1, arg2, arg3, arg4, arg5);

		return 10;
	}

	public void calc9()
	{
		StringBuilder sb = new StringBuilder();
	}

	public void calc10()
	{
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		
		sb.append("aaaa");
		sb.toString();
	}

	public static int calc11(int arg1)
	{
		return arg1;
	}

	public static void calc12()
	{
		calc11(1);
		calc11(100);	
		calc11(1000000000);	
	}

	public void calc13()
	{
		calc11(1);
		calc11(100);	
	}

	public TestClass calc14()
	{
		return this;	
	}

	public TestClass calc15()
	{
		return calc14();	
	}
}
