package com.workspace.learning.datastructure.linkedlist;

public class WhyLinkedList {

    /**
     * When to Use Linked list: Dynamic collection
     *                          Elements are frequently being added or delete at a particular location.
     *                          Most imp the location of new element added to the list is Significant.
     *
     * linked lists: Used for storing collections of data.
     *               Linear Dynamic data structure.
     *               Number of Nodes in a list is not fixed and can grow or shrink on demand.
     *
     *  Operations: Insert start O(1), insertion at middle/end O(n)
     *              Delete start O(1), Deletion at middle/end O(n)
     *
     *  Pros:       Number of Nodes in a list is not fixed and can grow or shrink on demand.
     *              Insertion and deletion without the need to do any coping and relocation
     *              Dynamic storage allocation is great adv.
     *
     *  Cons:       More Access time needed to access individual element
     *              O(n)
     *              Sometimes, Waste Memory terms of extra reference pointers
     *              As last element is deleted one must traverse the list and set the pointer to null
     *
     *  Arrays:
     *      Pros:  Simple and easy to use
     *             Faster access to the element
     *             Random Access O(1)
     *             insert at start O(n) if array is full for shifting the element
     *             insertion O(1) if array is  not full
     *
     *      Cons:  Fixed Size, Static structure, can not be easily extended or reduced.
     *             Complex position based insertion,
     *             Inserting element at a given position, need to shift existing element.
     *             (To Add more element to the array when array is full,
     *             We must create a new array and copy the old array to new array.
     *             This can take a lot of time, and we might allocate more memory than we need
     *             )
     *
     *
     *
     *
     *
     *
     *
     *
     */

}
