public enum SortBy {
    PurchaseTime(1), Rating(2), Price(3);
    private final int m;

    private SortBy(int m) {
        this.m = m;
    }

    public int getM() {
        return m;
    }
}