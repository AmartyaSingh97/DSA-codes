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

    public LinkedList.Node reverseIterative(LinkedList.Node node){
        Node prev=null;
        Node curr=node;
        Node next = null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        node=prev;
        return node;
    }

    public LinkedList.Node reverseRecursive(LinkedList.Node node){
        if(node==null || node.next==null){return node;}
        LinkedList.Node newNode = reverseRecursive(node.next);
        node.next.next=node;
        node.next=null;
        return newNode;
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp=head;
        if(head==null||head.next==null){return head;}
        int count=1;
        while(temp.next!=null){
            temp=temp.next;
            count++;}
        k=k%count;
        temp.next=head;
        temp=head;
        for(int i =0;i<count-k-1;i++){
            temp=temp.next;
        }
        head=temp.next;
        temp.next=null;
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
