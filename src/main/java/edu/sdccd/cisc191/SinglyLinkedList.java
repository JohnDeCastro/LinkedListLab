package edu.sdccd.cisc191;

class SinglyLinkedList<T>
{
    class Node
    {
        T data;
        Node next;
    };

    /**
     * recursively finds k-th node, deletes, and returns new head
     *
     * @param head the node to start at
     * @param k the kth element to remove (first element at 0)
     * @return the new head node with the kth element removed
     */
    public Node remove(Node head, int k)
    {
      Node returnNode = head; //places head node into temp variable
      
      if(k == 0){ //checks if we want to remove first node aka head
          head = head.next; //places next node from head as current node
                            // removed node will delete @ garbage collection
      } else {
          Node previous = head; //head node will be labeled as previous
          int count = 0; //start the count from 0

          while(count < k - 1){ //while the count is one less than the given position in param
              previous = previous.next; //places next node from previous as current previous
              count++; //iterate count so 'previous' can go through linked list until before param position
          } //completes when 'count' = the previous position before node intended to be deleted
          Node current = previous.next; //places node to be deleted as 'current'
          previous.next = current.next; //makes connection between previous node and node after current node
      } //this will result in 'current' to be deleted when garage collection occurs since no node points to it
      return returnNode; //returns updated head node with removed node
    }

    /**
     *  inserts node at the beginning of the list
     * @param head the node to start at
     * @param new_data data to insert into the list
     * @return the new head node containing new_data followed with the rest of the linked list
     */
    public Node push(Node head, T new_data)
    {
        Node newNode = new Node(); //initialize and declare new node "newNode"
        newNode.data = new_data; // places new_data param into newNode

        if(head == null){ //checks if current head is null / empty
            return newNode; //if null, returns newNode as list was empty and newNode is now new head
        } else {
            newNode.next = head; //updates point of newNode to now point to head
            head = newNode; //updates head point to now point to newNode
        }
        return head; //returns new head, which holds the newest stored data
    }

    /**
     * recursively prints list starting from head
     * @param head the node to start at
     * @return a space separated string containing the data of each node starting from the head to the tail, end with a trailing space
     */
    public String toString(Node head)
    {
        Node current = head; //places param into node variable names current
        String tempString = ""; //initializes string holder as empty

        while(current != null){ //while loop to traverse through linked list
            tempString += current.data + " "; //adds current node value + a space to tempString
            current = current.next; //progress to next node and place as current node
        }
        return tempString; //should return string nodes in singly linked list
    }
}