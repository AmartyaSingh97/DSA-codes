package com.company;

public class MergeSort {

    // For LinkedList: -
    ListNode head = null;
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val =val;
        }}
    // For sorting two nodes
    static class Solution {
        public ListNode sortList(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode prev = null, slow = head, fast = head;

            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            prev.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(slow);
            return sortedMerge(left,right);
        }
        public static ListNode sortedMerge(ListNode list1, ListNode list2){
            ListNode answer = new ListNode(0);
            ListNode newNode = answer;

            while(list1!=null && list2!=null){
                if(list1.val<=list2.val){
                    newNode.next=list1;
                    list1=list1.next;
                }
                else{
                    newNode.next=list2;
                    list2=list2.next;
                }
                newNode=newNode.next;
            }
            if(list1!=null){
                newNode.next=list1;
            }
            if(list2!=null){
                newNode.next=list2;
            }
            return answer.next;
        }
    }
   //  For Array: -
//    public static void mergesort(int[] arr,int l,int r){
//        if(l>=r){
//            return;
//        }
//        int mid = l+(r-l)/2;
//        mergesort(arr,l,mid);
//        mergesort(arr,mid+1,r);
//        Merge(arr,l,mid,r);
//        }
//
//    public static void Merge(int[] arr,int l,int mid,int r ){
//        int[] B = new int[r-l+1];
//        int i=l;
//        int j=mid+1;
//        int k=0;
//        while(i<=mid && j<=r){
//            if(arr[i]<=arr[j]){
//                B[k++]=arr[i++];
//            }
//            else{
//                B[k++]=arr[j++];
//            }}
//            while(i<=mid){
//                B[k++]=arr[i++];
//            }
//             while(j<=r){
//                 B[k++]=arr[j++];
//            }
//
//            for(int i1=0,j1=l;i1<B.length;i1++,j1++){
//                arr[j1]=B[i1];
//            }}


}

