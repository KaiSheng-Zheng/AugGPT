public enum SortBy {
    PurchaseTime(1),
    Rating(0),
    Price(0);

    private final int time;

    private SortBy(int time){
        time++;
        this.time = time;
    }
    public int getTime() {
        return time;
    }
}