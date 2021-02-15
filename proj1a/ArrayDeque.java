public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int front;
    private int rear;
    private int refactor;

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
        items = (T[]) new Object[1];
        front = rear = -1;
        size = 0;
        refactor = 2;
    }

    public void addFirst(T item) {
        if (size == 0 && size < items.length) {
            front = rear = 0;
            items[front] = item;


        } else if (front == 0 && size != 0 && size < items.length) {
            items[items.length - 1] = item;
            front = items.length - 1;

        } else if (size != 0 && size < items.length) {
            items[front - 1] = item;
            front -= 1;

        } else if (size + 1 > items.length) {    /*resizing */
            T[] newArr = (T[]) new Object[items.length * refactor];
            int numOfFront = 0;
            int numOfRear = 0;
            if (front == rear) {
                newArr[newArr.length - 1] = item;
                front += 1;

            }
            if (front < rear) {   /* front is at the index 0, while rear is at items[length -1] */
                numOfFront = items.length - 1;
                numOfRear = 1;
                newArr[newArr.length - 1] = item;  /* the new item is being inserted at the back of the arr */
                /* looping from the front to the end of arr */
                for (int i = 0; i < items.length; i++) {
                    newArr[i] = items[i];
                }
                items = newArr;
                front = newArr.length - 1;  /* update the index of front */

            } else if (rear < front) {  /* front is at the back while rear is at the front */
                numOfFront = items.length - front;
                numOfRear = rear + 1;
                int temp = newArr.length - numOfFront - 1; /* to locate the index of front in the new arr with the same number of front */
                newArr[temp] = item;    /* insert the new item at the front index of the new arr */
                temp = temp + 1;
                /* looping from items[front] to the end of the arr */
                for (int i = front; i < items.length; i++) {
                    newArr[temp] = items[i];
                    temp += 1;

                } /* looping from the beginning to rear of the old arr */
                for (int i = 0; i <= rear; i++) {
                    newArr[i] = items[i];
                }
                items = newArr;
                front = newArr.length - numOfFront -1;  /* update the new index of front */

            }

        }
        size += 1;
    }


    /* need resizing */
    public void addLast(T item) {
        if (size == 0 && size < items.length) {
            front = rear = 0;
            items[rear] = item;


        } else if (size != 0 && size < items.length) {
            items[rear + 1] = item;
            rear += 1;

        } else { /* resizing */
            T[] newArr = (T[]) new Object[items.length * refactor];
            if (front <= rear) {
                rear += 1;
                for (int i = 0; i < items.length; i++) {
                    newArr[i] = items[i];
                }
                newArr[rear] = item;
                items = newArr;

            } else {
                /* looping from front to the end of the arr */
                int numOfFront = items.length - rear - 1;
                int ptr = newArr.length - numOfFront;
                for (int i = front; i < items.length; i++) {
                    newArr[ptr] = items[i];
                    ptr += 1;
                }
                /* looping from the beginning to rear*/
                int curser = 0;
                for (int i = 0; i <= rear; i++) {
                    newArr[i] = items[i];
                    curser += 1;
                }
                items = newArr;
                newArr[curser] = item;
                rear = curser;
                front = newArr.length - numOfFront;

            }
        }
        size += 1;
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
        if (front == rear) {
            System.out.println(items[front]);
        } else if (front > rear) {
            /* front to the end of array*/
            for (int i = front; i < items.length; i++) {
                System.out.print(items[i] + ", ");
            }
            /* beginning to rear */
            for (int i = 0; i <= rear; i++) {
                System.out.print(items[i] + ", ");
            }
        } else {
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
        if ( index < 0 || index > size){
            return null;
        }else {
            return items[index];
        }
    }

    private  ArrayDeque ArrayDeque(ArrayDeque other) {
        ArrayDeque newArr =  new ArrayDeque();
        if (other.isEmpty() == true){
            return newArr;
        }else{
            for ( int i = 0 ; i < other.items.length; i ++){
                newArr.items [i] = other.items[i];
            }
            return newArr;
        }
    }

}
