package com.company;
import java.util.*;
import java.util.LinkedList;

public class Queue_class {
    // Array implementation of queue has T.C. of O(1) for add while O(n) for deque and peek.
    // But circular queue implementation has O(1) for all three methods.
    // In circular queue all T.C. is equal to O(1).
    // In circular queue if rear+1=front, that means queue is full.


    // Array implementation of Queue.
    // For circular implementation comments are there.
    static class Queue_array{
        static int[] arr;
        static int size;
        static int rear=-1;
        //static int front=-1;
        Queue_array(int n){
            arr=new int[n];
            size=n;
        }
        public static boolean isEmpty(){
            return rear==-1;
          // return rear==-1 && front==-1;
        }
        /*
          public static boolean isFull(){
          return (rear+1) % size == front;
          }
         */

        // Enqueue - O(1)
        public static void add(int data){
            if(rear==size-1){
                System.out.println("full queue");
            }
            /*
                 if(isFull()){
                System.out.println("full queue");
            }
            if(front==1){
               front=0;
            }
             */
            rear++;
            //rear= (rear+1) % size;
            arr[rear]=data;
        }

        // Dequeue - O(n)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
            }
            /*
            int result=arr[front];
            if(front==front){
              rear=front=-1;
            }
            else{
               front=(front+1)%size;
            }
             */
            int front=arr[0];
            for(int i=0;i<rear;i++){
                 arr[i]=arr[i+1];
            }
            rear--;
            // return result;
            return front;
        }

        // Peek - O(n)
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
            }
            //return arr[front];
            return arr[0];
        }
    }

    // LinkedList implementation of queue.

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    static class Queue_list{
        static Node head=null;
        static Node tail=null;

        public static boolean isEmpty(){
            return head == null && tail == null;
        }

        // Enqueue - O(1)
        public static void add(int data){
            Node newNode = new Node(data);
            if(tail==null){
                tail=head=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }

        // Dequeue
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
            }
            int front= head.data;
            if(head==tail){
                tail=null;
            }
            head=head.next;
            return front;
        }

        // Peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
            }
            return head.data;
        }
    }

    // Collection framework implementation.

    static class Queue_Coll{
        /*
      Linked structures are possibly the worst structure to iterate with a cache miss on each element.
      On top of it they consume way more memory.
      If you need add/remove of the both ends, ArrayDeque is significantly better than a linked list.
      Random access each element is also O(1) for a cyclic queue.
      The only better operation of a linked list is removing the current element during iteration.
         */

        public static void main(String[] args) {
            Queue<Integer> q = new LinkedList<>();
            Queue<Integer> a = new ArrayDeque<>();
            a.add(4);
            q.add(5);
        }
    }

    // Two stack implementation of Queue.
    static class Queue_stack{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
                return s1.isEmpty();
            }

        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }}

        public static int remove(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }
            return s1.pop();
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }
            return s1.peek();
        }
    }



}
