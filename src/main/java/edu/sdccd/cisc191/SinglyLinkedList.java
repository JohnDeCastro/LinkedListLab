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
      if(k == 0){
          return head.next; //if k is first node, return next node
      }
      head.next = remove(head.next, k- 1); //use recursion to pass through nodes until base case is met and connection is replaced
      return head; //returns new linked list via head
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
        if (head == null){
            return ""; //if head is empty, return empty string
        }
        return head.data + " " + toString(head.next); //uses recursion to return value at head, then head.next, until base case of
                                                    //head == null is reached.
    }
}