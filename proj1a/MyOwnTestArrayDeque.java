public class MyOwnTestArrayDeque {

    public static void main(String arg[]) {
        ArrayDeque l = new ArrayDeque();
//    l.addLast(0);
//    l.removeLast();
//    l.addLast(2);
//    l.addLast(3);
//    l.removeLast();
//    l.removeFirst();
//    l.addFirst(6);
//    l.addLast(7);
//    l.addFirst(8);
//    l.removeFirst();
//    l.addLast(10);
//    l.removeFirst();
//        l.printDeque();

//
//        l.addFirst(0);
//        l.addFirst(1);
//        l.addFirst(2);
//        l.addFirst(3);
//        l.removeLast();
//        l.addFirst(5);
//        l.addFirst(6);
//        l.isEmpty();
//        System.out.println (l.removeLast());
  /*Get */
//        l.addFirst(0);
//        l.addLast(1);
//        l.addLast(2);
//        l.removeFirst();
//        l.addFirst(4);
//        l.addLast(5);
//        l.removeLast();
//        l.removeLast();
//        l.addFirst(8);
//        l.removeLast();
//        l.addFirst(10);
//        l.addLast(11);
//        System.out.print(l.get(2));
//        l.printDeque();


        /* Get */
        l.addFirst(0);
        l.removeLast();
        l.addLast(2);
        l.get(0);
        l.addLast(4);
        l.get(0);
        l.addLast(6);
        l.get(2);
        l.removeLast();
        l.get(0);
        l.removeLast();
        l.removeFirst();
        l.addFirst(12);
        l.removeFirst();
        l.addFirst(14);
        l.addLast(15);
        l.addLast(16);
        l.get(2);
        l.removeFirst();
        l.removeFirst();
        System.out.print(l.removeLast());


    }
}
