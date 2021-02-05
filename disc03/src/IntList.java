public class IntList {
    public int first;
    public IntList rest;
    public IntList (int f, IntList r){
        this.first = f;
        this.rest = r;
    }
    public void skippifyA(){
        IntList p = this;
        int n = 1;
        if ( p == null || p.rest == null){
            return;
        }

        while(p != null){
            IntList next = p.rest;
            for (int i = 0 ; i<n; i++){
                if(next == null){
                    p.rest = next;
                    return;
                }
                next = next.rest;
            }
            p.rest = next;
            p = next;
            next = next.rest;
            n+=1;
        }
    }











    public void skippify(){
        IntList p = this;
        /** n is the indicator of how many numbers to be skipped*/
        int n = 1;
        /** a loop will iterate until p is null*/
        while (p != null){
            /** create another pointer "next"*/
            IntList next = p.rest;

            /** i is the number of loops. Inside the for loop, the next and p pointer will loop to the next element until i = n; */
            for (int i = 0; i<n; i++ ){
                // if the next pointer loops to the end of the list, the loop will end
                if(next == null){
                    p.rest = next;
                    return;
                }
                next = next.rest;
            }
            // when n = i, i,e, the next pointer is at the element which should be kept.
            p.rest = next;
            p = next;
            next = next.rest;
            n += 1;
        }
    }
    /** Non-destructively creates a copy of x tht contains no occurences of y*/
    public static IntList ilsans(IntList x, int y){
        if ( x == null){
            return null;
        }
        if (x.first == y){
            return ilsans(x.rest,y);
        }
        else {
            return new IntList(x.first, ilsans(x.rest,y) );
        }
    }
    /** Destructively modify and return x to contain no occurences of y, without using the keyword "new". */
    public static IntList dilsans (IntList x, int y){
        if( x == null){
            return null;
        }
        x.rest = dilsans(x.rest,y);
        if(x.first == y){
            return x.rest;
        }
        return x;
    }
    public static void main (String arg[]){

    }
}
