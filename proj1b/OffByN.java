public class OffByN implements CharacterComparator {
    private int difference;

    @Override
    public boolean equalChars(char x, char y) {
        int a = x;
        int b = y;
        int result = a - b;
        if (result<0){
            result = result * -1;
        }
        return result == difference;
    }

    public OffByN(int N) {
        difference = N;
    }
}
