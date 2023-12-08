import java.util.Arrays;
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
    int  size;
    LinkedList(){
        this.size = 0;
        
    }
    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data+" -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public int[] convArray(){
        Node current = head;
        if(current == null){
            return new int[]{};
        }
        int[] arr = new int[size];
        int i = 0;
        while(current != null){
            arr[i] = current.data;
            current = current.next;
            i++;
        }
        return arr;
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    public void addLast(int data){
        Node newNode  = new Node(data);
        Node current = head;
        if(current == null){
            addFirst(data);
            return;
        }
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        size++;
    }
    public void addPos(int data, int idx){
        if(idx > size || idx < 0){
            System.out.println("Error");
            return;
        }
        // if we want to inset at last position we simply call fun addLast().
        if(idx == size){
            addLast(data);
            return;
        }
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        Node temp = head;
        // here we choose 1 based indexing
        // if we need 0 based indexing here we change 1 insted of 0.
        int i = 0;
       while(current.next != null){
           if(i == idx){
                newNode.next = current;
                temp.next = newNode;
                size++;
                return;
            }
            i++;
            temp = current;
            current = current.next;
       }
    }
    public void deleteFirst(){
        Node current = head;
        head = current.next;
        size--;
    }
    public void deleteLast(){
        Node current = head;
        Node temp = head;
        while(current.next != null){
            temp = current;
            current = current.next;
        }
        temp.next = null;
        size--;
    }
    public void deletePos(int idx){
        if(idx == 0){
            deleteFirst();
            return;
        }
        Node current = head;
        Node temp = head;
        int i = 0;
        while(current.next != null){
            if(i == idx){
                temp.next = current.next.next;
                size--;
                return;
            }
            i++;
            temp = current;
            current = current.next;
        }
    }
}
class Main{
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.addFirst(8);
        list.addFirst(1);
        list.addFirst(4);
        list.addFirst(5);
        list.addLast(9);
        list.addLast(10);
        list.addPos(7,2);
        list.addPos(9,0);
        System.out.println(Arrays.toString(list.convArray()));
        list.deleteFirst();
        System.out.println(Arrays.toString(list.convArray()));
        list.deleteLast();
        System.out.println(Arrays.toString(list.convArray()));
        list.deletePos(4);
        
        list.printList();
        System.out.println(Arrays.toString(list.convArray()));
    }
}