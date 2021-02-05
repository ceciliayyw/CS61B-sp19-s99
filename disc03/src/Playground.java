public class Playground {

    public PlaygroundNode first;

    public class PlaygroundNode {
        int item;
        PlaygroundNode rest;

        public PlaygroundNode(int a, PlaygroundNode b) {
            this.item = a;
            this.rest = b;
        }
    }

    public PlaygroundNode reverseRecurNode(PlaygroundNode cur) {
        if (cur == null || cur.rest == null) {
            return cur;
        } else {
            PlaygroundNode endOfReversed = cur.rest;
            PlaygroundNode reversed = reverseRecurNode(cur.rest);
            endOfReversed.rest = cur;
            cur.rest = null;
            return reversed;
        }
    }

    public void reverseRecur() {
        first = reverseRecurNode(first);
    }

//    public void insertNode (int x, int position){
//        if (this.first == null){
//            addFirst(x);
//            return;
//        }
//        if ()
//    }

    public void addFirst(int x) {
        PlaygroundNode newNode = new PlaygroundNode(x, this.first);
        this.first = newNode;
    }

    public void addNode(int x) {
        PlaygroundNode temp = this.first;
        while (temp.rest != null) {
            temp = temp.rest;
        }
        temp.rest = new PlaygroundNode(x, null);
    }

    private void printList() {
        PlaygroundNode temp = this.first;
        System.out.print("Output: ");
        while (temp.rest != null) {
            System.out.print(temp.item + ", ");
            temp = temp.rest;
        }
        System.out.print(temp.item);
    }

    public static void main(String arg[]) {
        Playground L = new Playground();
        L.addFirst(1);
        L.addNode(2);
        L.addNode(3);
        L.addNode(4);
        L.reverseRecur();

        L.printList();
    }
}
