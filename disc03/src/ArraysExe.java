import java.util.Arrays;

public class ArraysExe {

    public static int[] insert(int[] arr, int item, int position) {
        int arrLength = arr.length;
        int[] newArr = new int[arrLength + 1];
        if (arrLength == 0) {
            newArr[0] = item;
            return newArr;
        }
        if (position == 0) {
            newArr[0] = item;
            for (int i = 0; i < arrLength; i++) {
                newArr[i + 1] = arr[i];
            }
        } else {
            for (int i = 0; i < position; i++) {
                newArr[i] = arr[i];
            }
            newArr[position] = item;
            for (int i = position; i < arr.length; i++) {
                newArr[i + 1] = arr[i];
            }
        }
        return newArr;
    }

    public static void reverse(int[] arr) {
        int arrLength = arr.length;
        if (arrLength == 0 || arrLength == 1) {
            return;
        } else {
            if (arrLength % 2 != 0) {
                for (int i = 0; i < (arrLength - 1) / 2; i++) {
                    int temp = arr[i];
                    arr[i] = arr[arrLength - i - 1];
                    arr[arrLength - i - 1] = temp;
                }
                return;
            } else {
                for (int i = 0; i < ((arrLength - 1) / 2) + 1; i++) {
                    int temp = arr[i];
                    arr[i] = arr[arrLength - i - 1];
                    arr[arrLength - i - 1] = temp;

                }
                return;

            }
        }
    }

    public static int[] replicate(int[] arr) {
        int total = 0;
        for (int item : arr){
            total += item;
        }
        int[] newArr = new int[total];
        int index = 0;

        for (int item : arr){
            int i = 0;
            while( i <item){
                newArr[index] = item;
                index ++;
                i++;
            }
        }
        return newArr;


}

    public static int[] flatten (int [][] input ){
        int totalLength = 0;
        // for each subarray inside input
        for (int[] subArr : input){
            //for each item inside a subarray, I would...
            for (int item : subArr){
                totalLength += 1;
            }
        }
        int [] newArr = new int [totalLength];
        int ptr = 0 ;
        for (int [] index : input){
            for (int item :index){
                    newArr[ptr] = item;
                    ptr += 1;
            }
        }
        return newArr;
    }


    public static void printArr(int[] arr) {
        int arrLength = arr.length;
        int i = 0;
        System.out.print("[ ");
        while (i < arrLength) {
            System.out.print(arr[i] + ", ");
            i++;
        }
        System.out.print("] ");
    }

    public static void main(String arg[]) {
        int[] []L = new int[][]{{3,2,1},{6,7,8,9,0}};
        int [] Y = new int[10];
//      L = insert(L, 8, 1);
//        reverse(L);
         Y =  flatten(L);
        printArr(Y);


    }
}
