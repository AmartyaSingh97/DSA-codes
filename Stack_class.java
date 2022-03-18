package com.company;

import java.util.*;

public class Stack_class {
    /*
    Push- O(1); Pop- O(1); Peek- O(1)
   */

    // LinkedList Implementation of stack.
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next=null; }}

    static class stack{
        public static ListNode head;
        public static boolean isEmpty(){
            return head==null;
        }

        public static void push(int data){
            ListNode node = new ListNode(data);
            if(isEmpty()){
                head=node;
                return;
            }
            head.next=node;
            head=node;
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top=head.val;
            head=head.next;
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.val;
        }
        public static void print(){
            while(!isEmpty()){
                System.out.println(peek());
            }
            pop();
        }

    }

    // Arraylist Implementation of stack.
    static class stack2{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size()==0;
        }
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;}
            return list.get(list.size()-1);
        }
    }

    // Implementation using collection framework.
    static class stack3{
        Stack<Integer> s = new Stack<>();
    }

    // Push at Bottom
    public static void push_bottom(int data,Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        push_bottom(data,s);
        s.push(top);}

   // Reverse a stack
    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reverse(s);
        push_bottom(top,s);
    }





}
