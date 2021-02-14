public class ArrayDeque<T> {
    int size;
    T[] items;
    int front;
    int rear;
    int refactor;

    //e.g.   0 1 2 3 4 5
    //item: [4 5 3 2 8......]
    //size: 5

    /*Invariants: (things that are always true)
    addLast: the next item we want to add, its position = size;
    size: it is the number of items in the list. The size variable should be shared with all methods in the class;
     */


    /**
     * creates an empty list
     */
    // (T[]) new Object <- source from Google
    // when the list is empty, front = rear at index -1. When the first element is inserted, front = rear with index at 0.
    // When second element is added, the rear index will add 1, i.e. rear = rear +1
    public ArrayDeque() {
        items = (T[]) new Object[4];
        front = rear = -1;
        size = 0;
        refactor = 2;
    }

    public void addFirst(T item) {
        if (size == 0 && size < items.length) {
            front = rear = 0;
            items[front] = item;
            size += 1;

        } else if (size != 0 && size < items.length) {
            items[items.length - size] = item;
            front = items.length - size;
            size += 1;
        }
//        else if (size == items.length){
////            /*resizing */
//            T[] newArr = (T[])new Object [size*refactor];
//            newArr [0] = item;
//            for (int i = 0;  i<items.length; i++){
//                newArr [i+1] = items [i];
//            }
//            items = newArr;
//            rear += 1;
//        }
    }

    /* need resizing */
    public void addLast(T item) {
        if (size == 0 && size < items.length) {
            front = rear = 0;
            items[rear] = item;
            size += 1;

        } else if (size != 0 && size < items.length) {
            items[rear + 1] = item;
            rear += 1;
            size += 1;
        }
//        else{  /* resizing
//            T[] temp = new T [size +1];
//            for (int i = 0; i<items.length; i++){
//                temp [i] = items [i];
//            }
//            temp [size] = item;
//            items = temp;
//            size += 1;

//        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }

    }

    public int size() {
        return size;
    }

    public void printDeque() {
        System.out.print("Output: ");
        if (front == rear){
            System.out.println(items[front]);
        }
        else if (front > rear) {
            /* front to the end of array*/
            for (int i = front; i <items.length; i++) {
                System.out.print(items[i] + ", ");
            }
            /* beginning to rear */
            for (int i = 0; i <= rear; i++) {
                System.out.print(items[i] + ", ");
            }
        }else{
            /* from front to rear*/
            for (int i = front; i <= rear; i++) {
                System.out.print(items[i] + ", ");
            }
        }
    }

    /* no resizing is needed */
    public T removeFirst() {
        T removedItem = items[front];
        if (front == rear) {
            return null;
        } else if (front == items.length) {
            items[front] = null;
            front = rear;
        } else {
            items[front] = null;
            front += 1;
        }
        size -= 1;
        return removedItem;
    }

    public T removeLast() {
        T removedItem = items[rear];
        if (front == rear) {
            return null;
        } else {
            items[rear] = null;
            rear -= 1;
        }
        size -= 1;
        return removedItem;
    }

    public T get(int index) {
        return items[index];
    }

//    public ArrayDeque(ArrayDeque other) {
//
//    }

    public static void main(String arg[]) {
        ArrayDeque l = new ArrayDeque();
        l.addFirst(10);
        l.addFirst(11);
        l.addFirst(12);
        l.addFirst(13);
        l.addFirst(14);
//        l.addLast(15);
//        l.addLast(16);
//        l.addLast(17);
//        l.addLast(18);
        l.printDeque();
    }
}
