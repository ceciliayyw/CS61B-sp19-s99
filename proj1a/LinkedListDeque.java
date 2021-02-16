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

    private class IntNode {
        private IntNode prev;
        private T item;
        private IntNode next;


        IntNode(T item, IntNode y) {
            this.item = item;
            this.next = y;
        }
    }


    /**
     * should not be looping or recursion
     */
    public void addFirst(T item) {
        if (isEmpty()) {
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
        if (isEmpty()) {
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
        return sentinel1.next == sentinel2 && sentinel2.prev == sentinel1;
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
    public T removeFirst() {
        T removedItem = sentinel1.next.item;
        if (isEmpty() || size() == 1) {
            size = 0;
            sentinel1.next = sentinel2;
            sentinel2.prev = sentinel1;
        } else {
            IntNode temp = sentinel1.next;
            sentinel1.next = temp.next;
            temp.next.prev = sentinel1;
            size -= 1;
        }
        return removedItem;
    }

    /**
     * should not be looping or recursion
     */
    public T removeLast() {
        T removedItem;
        if (isEmpty() || size() == 1) {
            removedItem = sentinel1.next.item;
            size = 0;
            sentinel1.next = sentinel2;
            sentinel2.prev = sentinel1;
        } else {
            removedItem = sentinel2.prev.item;
            IntNode temp = sentinel2.prev;
            sentinel2.prev = temp.prev;
            temp.prev.next = sentinel2;
            size -= 1;
        }
        return removedItem;
    }

    public T get(int index) {
        if (isEmpty()) {
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

    private LinkedListDeque linkedListDeque(LinkedListDeque other) {
        LinkedListDeque newCopy = new LinkedListDeque();
        if (other.isEmpty()) {
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

    private T getRecursiveHelper(IntNode currentNode, int index) {
        IntNode temp = currentNode;
        if (isEmpty()) {
            return null;
        }
        if (index == 0) {
            return temp.item;
        } else {
            return getRecursiveHelper(temp.next, index - 1);
        }
    }
}
