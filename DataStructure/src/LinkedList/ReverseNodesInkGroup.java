package com.kar.practice.exercise.DataStructure.src.LinkedList;

import java.util.Scanner;

import static com.kar.practice.exercise.DataStructure.src.LinkedList.LinkedList.createLinkedList;
import static com.kar.practice.exercise.DataStructure.src.LinkedList.LinkedList.printLinkedList;



//// Didn't Complete , Yet In progress...

public class ReverseNodesInkGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList.ListNode<Integer> LL = createLinkedList();
        System.out.print("Enter The value of K to Reverse: ");
        int k = sc.nextInt();

        System.out.print("Initial Linked List: ");
        printLinkedList(LL);

        System.out.println();

        System.out.print("The value of K to Reverse is: ");
        System.out.println(k);

        reverseNodesInkGroup(LL,k);
    }

    private static void reverseNodesInkGroup(LinkedList.ListNode<Integer> head, int k) {
        if(head == null){
            return;
        }

        if (head.next == null) {
            printLinkedList(head);
            return;
        }
        LinkedList.ListNode<Integer> current = head;
        LinkedList.ListNode<Integer> after = current;
        LinkedList.ListNode<Integer> before = current ;
        LinkedList.ListNode<Integer> start = current;

        int count = 0;
        while ( after != null ){

            if (count != k){

            before = current;
            current = after;
            after = after.next;
            current.next = before;
            count ++;
            }
            if (count == k && after != null) {
                current.next = start.next;
                start.next = before;
                start = start.next;
                current = after;
                after = after.next;

                count = 0;
            }

        }

        System.out.print("Final Linked List: ");
        printLinkedList(head);
    }
}
