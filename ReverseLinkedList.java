// leetcode 206
import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    Node head;
    public void add(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ->");
            temp = temp.next;
        }
        System.out.println("null");
        
    }
    public Node reverseList() {
        Stack<Integer> stack = new Stack<Integer>();
        Node temp1 = head;
        while(temp1 != null){
            stack.push(temp1.data);
            temp1 = temp1.next;
        }
        Node temp2 = head;
        while(temp2 != null){
            temp2.data = stack.pop();
            temp2 = temp2.next;
        }
        return head;
    }
}
class Main{
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.add(9);
        list.add(7);
        list.add(4);
        list.add(2);
        list.add(7);
        list.print();
        list.reverseList();
        list.print();
    }
}