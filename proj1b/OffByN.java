public class OffByN implements CharacterComparator {
    int difference;

    @Override
    public boolean equalChars(char x, char y) {
        int a = x;
        int b = y;
        int result = a - b;
        return result == Math.abs(difference);
    }

    private OffByN(int N) {
        difference = N;
    }
}
