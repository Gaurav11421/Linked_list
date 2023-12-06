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
    public Node removeNthFromEnd(int n) {
        Node fast = head;
        Node slow = head;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
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
        list.removeNthFromEnd(2);
        list.print();
    }
}