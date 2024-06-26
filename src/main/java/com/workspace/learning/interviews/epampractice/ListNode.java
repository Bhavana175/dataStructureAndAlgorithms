package com.workspace.learning.interviews.epampractice;

import lombok.Data;

@Data
public class ListNode {

    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

}
