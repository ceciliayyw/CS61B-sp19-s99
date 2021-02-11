public class LinkedListDeque<T> {
    private IntNode sentinel1;
    private IntNode sentinel2;
    private int size;


    public LinkedListDeque() {
        sentinel1 = new IntNode(null, null);
        sentinel2 = new IntNode(null, null);
        sentinel1.next = sentinel2;
        sentinel2.prev = sentinel1;
        sentinel2.next = sentinel1;
        sentinel1.prev = sentinel2;
    }

    public class IntNode {
        public IntNode prev;
        public T item;
        public IntNode next;


        public IntNode(T item, IntNode y) {
            this.item = item;
            this.next = y;
        }
    }


    /**
     * should not be looping or recursion
     */
    public void addFirst(T item) {
        if (isEmpty() == true) {
            IntNode temp = new IntNode(item, sentinel2);
            sentinel1.next = temp;
            sentinel2.prev = temp;
            temp.prev = sentinel1;
            size += 1;
        } else {
            IntNode temp = new IntNode(item, sentinel1.next);
            temp.prev = sentinel1;
            sentinel1.next.prev = temp;
            sentinel1.next = temp;
            size += 1;
        }
    }

    /**
     * should not be looping or recursion
     */
    public void addLast(T item) {
        if (isEmpty() == true) {
            IntNode temp = new IntNode(item, sentinel2);
            sentinel1.next = temp;
            sentinel2.prev = temp;
            temp.prev = sentinel1;
            size += 1;
        } else {
            IntNode temp = new IntNode(item, sentinel2);
            sentinel2.prev.next = temp;
            temp.prev = sentinel2.prev;
            sentinel2.prev = temp;
            size += 1;
        }
    }

    public boolean isEmpty() {
        if (sentinel1.next == sentinel2) {
            return true;
        } else {
            return false;
        }
    }


    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode temp = sentinel1.next;
        System.out.print("Output: ");
        while (temp != sentinel2) {
            System.out.print(temp.item + ", ");
            temp = temp.next;
        }
    }

    /**
     * should not be looping or recursion
     */
    public IntNode removeFirst() {
        if (size() == 0 || size() == 1) {
            size -= 1;
            return null;
        } else {
            IntNode temp = sentinel1.next;
            sentinel1.next = temp.next;
            temp.next.prev = sentinel1;
            size -= 1;
            return sentinel1.next;
        }
    }

    /**
     * should not be looping or recursion
     */
    public T removeLast() {
        if (isEmpty() == true || size() == 1) {
            size -= 1;
            return null;
        } else {
            IntNode temp = sentinel2.prev;
            sentinel2.prev = temp.prev;
            temp.prev.next = sentinel2;
            size -= 1;
            return sentinel2.prev.item;
        }
    }

    public T get(int index) {
        if (isEmpty() == true) {
            return null;
        } else {
            IntNode temp = sentinel1.next;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            System.out.println(temp.item);
            return temp.item;
        }
    }

    public LinkedListDeque LinkedListDeque(LinkedListDeque other) {
        LinkedListDeque newCopy = new LinkedListDeque();
        if (other.isEmpty() == true) {
            return newCopy;
        } else {
            IntNode temp = other.sentinel1.next;
            while (temp != sentinel2) {
                newCopy.addLast(temp.item);
                temp = temp.next;
            }
            newCopy.printDeque();
            return newCopy;
        }
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel1.next, index);
    }

    public T getRecursiveHelper(IntNode currentNode , int index) {
        IntNode temp = currentNode;
        if (isEmpty() == true) {
            return null;
        }
        if (index == 0) {
            return temp.item;
        } else {
             return getRecursiveHelper(temp.next, index -1);
        }
    }

    public static void main(String arg[]) {
        LinkedListDeque l = new LinkedListDeque();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        l.addLast(4);
//        l.LinkedListDeque(l);

        System.out.print(l.getRecursive(1));
    }
}
