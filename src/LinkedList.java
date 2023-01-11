public class LinkedList extends Driver {
    Node head;// head of list
    Node tail;//end of list
    public void add(char c){
        Node newNode = new Node(c);
        if (this.size() == 0){
            this.head = newNode;
            this.head.next = null;
            this.tail = this.head;
        }else{
            this.tail.next = newNode;
            this.tail = this.tail.next;
            this.tail.next = null;
        }
    }
    public int size(){
        int size = 0;
        Node curr;
        curr = this.head;
        if(this.head == null){
            return 0;
        }else if (this.head.next == null){
            return 1;
        }
        while(curr.next != null){
            curr = curr.next;
            size++;
        }
        return size;
    }
    public  String toString(){
        StringBuilder returnMe = new StringBuilder();
        Node curr = this.head;
        for(int i = 0; i < this.size() ; i++ ){
            returnMe.append(curr.data);
            if (i < this.size() - 1){
                curr = curr.next;
                returnMe.append(" -> ");
            }else if(i == this.size() ){
                returnMe.append(" -> ");
                returnMe.append(curr.data);
            }
        }
        return returnMe.toString();
    }
}
