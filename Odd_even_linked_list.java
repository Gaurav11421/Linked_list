// leetcode 328
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
    public Node oddEvenList() {
        if (head == null || head.next == null) {
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
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
        list.oddEvenList();
        list.print();
    }
}

