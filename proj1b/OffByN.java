public class OffByN implements CharacterComparator {
    private int difference;

    @Override
    public boolean equalChars(char x, char y) {
        return x - y == difference || y - x == difference;
    }

    public OffByN(int N) {
        difference = N;
    }
}
