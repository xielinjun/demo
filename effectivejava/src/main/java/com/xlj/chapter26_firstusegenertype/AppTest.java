package com.xlj.chapter26_firstusegenertype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTest {

    public static void main(String[] args) {

        Stack stack = new Stack();

        for (int i=0; i < 10000; i++)
        {
            stack.push(i);
        }

        for (int i=0; i < 10000; i++)
        {
            try {
                System.out.println(stack.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Stack<int[]> stack2 = new Stack<>();
        Stack<List<String>> stack1 = new Stack<>();
        Stack<List<String>[]> stack3 = new Stack<>();
        Stack<Integer>[] stacks = new Stack[10];

    }

    public static <T> T getT(T g)
    {
        Object ob =(Object)g;

        @SuppressWarnings("unchecked") T re = (T) ob;

        return re;
    }

    public static class Stack<E> {
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        private E[] elements;
        private int size;

        @SuppressWarnings("unchecked")
        public Stack()
        {
            this.elements = (E[]) new Object[Stack.DEFAULT_INITIAL_CAPACITY];
        }

        public void push(E object) {
            this.ensureCapacity();
            this.elements[this.size++] = object;
        }

        public E pop() throws Exception {
            if(size == 0)
            {
                throw new Exception("stack is empty.");
            }

            size--;
            E result = this.elements[this.size];
            this.elements[this.size] = null;

            return result;
        }

        public boolean isEmpty()
        {
            return this.size == 0;
        }

        private void ensureCapacity() {
            if (this.elements.length == this.size) {
                this.elements = Arrays.copyOf(
                        this.elements,
                        this.size * 2 + 1);
            }
        }

    }
}
