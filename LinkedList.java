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

    // Node classes.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; next=null; }
    }

    private static class Node {
        private int data;
        private LinkedList.Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

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

    public ListNode copy(ListNode head){
        ListNode ans = new ListNode(0);
        ListNode dummy=ans;
        ListNode temp=head;
        while(temp!=null){
            dummy.next=new ListNode();
            dummy=dummy.next;
            dummy.val= temp.val;
            dummy.next=null;
            temp=temp.next;
        }
        return ans.next;
    }

    // Floyd's hare and turtle algorithm. Space- O(1)
    public Boolean cycle(ListNode head){
        ListNode fast=head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    // To get the starting point of cycle using above algo.
    public ListNode getHead(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        if(head==null){
            return null;
        }
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;

            if(slow==fast){
                ListNode temp=fast;
                slow=head;
                while(slow!=temp){
                    slow=slow.next;
                    temp=temp.next;
                }
                return temp;
            }
        }
        return null;
    }

    // Run the loop two times, in second iteration point the head of other list with pointer of first one.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

    public ListNode swapInPair(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev=head.next;
        ListNode next=head.next.next;
        ListNode temp=head;
        head=prev;
        head.next=temp;
        head.next.next=swapInPair(next);

        return head;
    }

    // Bring odd indices together and even indices together in O(1) space and O(n) time.
            public ListNode oddEvenList(ListNode head) {
            if(head==null||head.next==null){
                return head;}
            ListNode odd=head,even=head.next,evenHead=even;
            while(even!=null && even.next!=null){
                odd.next=even.next;
                odd=odd.next;
                even.next=odd.next;
                even=even.next;
            }
            odd.next=evenHead;
            return head;
        }

    // Removing middle index of a list using three pointers using O(1) space complexity
    public ListNode removeMiddle(ListNode head){
        ListNode ans = new ListNode(-1);
        ListNode prev=ans,slow=head,fast=head;
        prev.next=head;

        while (fast!=null && fast.next!=null ){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=slow.next;
        return ans.next;
    }



}
