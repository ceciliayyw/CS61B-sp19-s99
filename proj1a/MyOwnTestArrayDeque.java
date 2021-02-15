public class MyOwnTestArrayDeque {

    public static void main(String arg[]) {
        ArrayDeque l = new ArrayDeque();
        l.addLast(1);
        l.addFirst(10);
        l.addFirst(12);
        l.addLast(2);
        l.addLast(3);

//        l.addLast(16);
//        l.addLast(17);
//        l.addLast(18);
        l.printDeque();
    }
}
