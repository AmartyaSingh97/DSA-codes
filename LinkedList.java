package com.company;

public class LinkedList {
    /*
    static class Node{
    int val;
    Node next;
    public Node(int val){
    this.val=val;}
     */
    private LinkedList.Node head;

    public void display() {
        for(LinkedList.Node temp = this.head; temp != null; temp = temp.next) {
            System.out.print(temp.data + "-->");
        }

        System.out.println("null");
    }

    public void insert_first(int data) {
        LinkedList.Node new_node = new LinkedList.Node(data);
        if (this.head == null) {
            this.head = new_node;
        }

        new_node.next = this.head;
        this.head = new_node;
    }

    public void insert_last(int data) {
        LinkedList.Node new_node = new LinkedList.Node(data);
        LinkedList.Node temp = this.head;
        if (this.head == null) {
            this.head = new_node;
        }

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = new_node;
    }

    public void insert(int position, int data) {
        LinkedList.Node new_node = new LinkedList.Node(data);
        LinkedList.Node temp = this.head;
        int n = 0;
        if (this.head == null) {
            this.head = new_node;
        }

        if (position == 1) {
            new_node.next = this.head;
            this.head = new_node;
        }

        while(n < position - 1) {
            temp = temp.next;
            ++n;
        }

        LinkedList.Node prev = temp.next;
        prev.next = new_node;
        new_node.next = temp;
    }

    public LinkedList.Node delete_first() {
        if (this.head != null && this.head.next != null) {
            LinkedList.Node temp = this.head;
            this.head = this.head.next;
            temp.next = null;
            return temp;
        } else {
            return this.head;
        }
    }

    public LinkedList.Node delete_last() {
        if (this.head != null && this.head.next != null) {
            LinkedList.Node temp = this.head;

            LinkedList.Node prev;
            for(prev = null; temp.next != null; temp = temp.next) {
                prev = temp;
            }

            prev.next = null;
            return temp;
        } else {
            return this.head;
        }
    }

    public LinkedList.Node delete(int position) {
        if (this.head != null && this.head.next != null) {
            LinkedList.Node previous = this.head;

            for(int n = 1; n < position - 1; ++n) {
                previous = previous.next;
            }

            LinkedList.Node temp = previous.next;
            temp.next = previous.next;
            return previous;
        } else {
            return this.head;
        }
    }

    private static class Node {
        private int data;
        private LinkedList.Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
