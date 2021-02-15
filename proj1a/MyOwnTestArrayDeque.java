public class MyOwnTestArrayDeque {

    public static void main(String arg[]) {
        ArrayDeque l = new ArrayDeque();
        l.addFirst(0);
        l.addFirst(1);
        l.removeLast();
        l.addFirst(3);
        l.addFirst(4);
        l.addFirst(5);
        l.addFirst(6);
        l.removeLast();

//        l.addLast(16);
//        l.addLast(17);
//        l.addLast(18);
        l.printDeque();
    }
}
