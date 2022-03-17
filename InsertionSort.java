package com.company;

public class InsertionSort {

    // Node Class;
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val =val;
        }}

    // Insertion sort for LinkedList.
    public ListNode sortLinkedList(ListNode head){
        if(head==null){
            return null;
        }
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        ListNode curr=head,next=null;
        while(curr!=null){
            next=curr.next;
            while(temp.next!=null && temp.next.val< curr.val){
                temp=temp.next;
            }
            curr.next=temp.next;
            temp.next=curr;
            temp=ans;
            curr=next;
        }
        return ans.next;
    }

    // Insertion sort for Array.

//    static int[] sort(int[] array) {
//        int n = array.length;
//
//        for(int i = 1; i < n; ++i) {
//            int j = i - 1;
//
//            int temp;
//            for(temp = array[i]; j >= 0 && temp < array[j]; --j) {
//                array[j + 1] = array[j];
//            }
//
//            array[j + 1] = temp;
//        }
//
//        return array;
//    }

}
