// leetcode 83
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
    // This is function only add first element is you
    // want add element in last please view implementation of linked'list
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
    public Node deleteDuplicates() {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head; 
        }
        Node slow = head;
        Node fast = head.next;
        while(fast != null){
            if(slow.data == fast.data){
                fast = fast.next;
                slow.next = fast;
            }
            else{
                slow = slow.next;
                fast = fast.next;
            }
        }
        return head;
    }
}
class Main{
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(1);
        list.print();
        list.deleteDuplicates();
        list.print();
    }
}

