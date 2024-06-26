package com.kar.practice.exercise.DataStructure.src.LinkedList;

import java.util.Objects;

import static com.kar.practice.exercise.DataStructure.src.LinkedList.LinkedList.createLinkedList;
import static com.kar.practice.exercise.DataStructure.src.LinkedList.LinkedList.printLinkedList;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        LinkedList.ListNode<Integer> LL = createLinkedList();
        System.out.print("Initial Linked List: ");
        printLinkedList(LL);

        
        removeDuplicates(LL);
    }

    private static void removeDuplicates(LinkedList.ListNode<Integer> head) {
        if (head == null || head.next == null){
            System.out.println(head);
        }
        LinkedList.ListNode<Integer> current = head;

        while (current != null && current.next != null) {
            if (Objects.equals(current.data, current.next.data)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }





    }
}
