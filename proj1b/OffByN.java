public class OffByN implements CharacterComparator {
    int difference;

    @Override
    public boolean equalChars(char x, char y) {
        int a = x;
        int b = y;
        int result = a - b;
        return result == Math.abs(difference);
    }

    public OffByN(int N) {
        difference = N;
    }
}
