public class SLList {
    public void printSize() {
    }

    private static class IntNode {
        public int item;
        public IntNode next;
        public String head = "h";

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    private static int size = 0;


    public void addFirst(int x) {
        this.first = new IntNode(x, this.first);
        size += 1;
    }

    public int getSize() {
        IntNode temp = first;
        while (temp.next != null) {
            size += 1;
            temp = temp.next;
        }
        return size;
    }

    public void insert(int item, int position) {
        //this.getSize();
        IntNode temp = first;
        if (position == 0) {
            addFirst(item);
            return;
        }

        if (position < size) {
            for (int i = 1; i < position; i++) {
                temp = temp.next;
            }
            IntNode newInsert = new IntNode(item, null);
            newInsert.next = temp.next;
            temp.next = newInsert;
            size += 1;
            return;
        }
        if (position >= size) {
            while (temp.next != null) {
                temp = temp.next;
            }
            IntNode newInsert = new IntNode(item, null);
            temp.next = newInsert;
            size += 1;
            return;
        }
    }

    public IntNode reverseRecurHelper(IntNode cur) {

        if (cur == null || cur.next == null) {
            return cur;
        }
        else {
            IntNode endOfRecurReversed = cur.next;
            IntNode reversed = reverseRecurHelper(cur.next);
            endOfRecurReversed.next = cur;
            cur.next = null;
            return reversed;
        }
    }



    public void reverseRecur() {
        first = reverseRecurHelper(first);

    }

    public void reverse(){
        if (first == null || first.next == null) {
            return;
        }
        IntNode temp = first.next;
        IntNode rest = temp.next;
        first.next = null;
        while(rest.next!= null){
           temp.next = first;
           first = temp;
           temp = rest;
           rest = rest.next;
        }
//        temp.next = first;
//        first = temp;
    }



    public void printInput() {
        IntNode temp = this.first;
        System.out.print("Input: ");
        while (temp != null) {
            System.out.print(temp.item + ", ");
            temp = temp.next;
        }
    }

    public void printOutput() {
        IntNode temp = this.first;
        System.out.print("Output: ");
        while (temp != null) {
            System.out.print(temp.item + ", ");
            temp = temp.next;
        }
    }

    public static void main(String arg[]) {
        SLList L = new SLList();

        SLList l2 = new SLList();
        L.addFirst(2);
        l2.addFirst(6);
        L.addFirst(5);
        L.insert(10, 0);
//        L.insert(11, 1);
//        L.insert(12, 2);
//        L.insert(13, 10);
        L.printInput();
        L.reverse();
        L.printOutput();

    }
}
