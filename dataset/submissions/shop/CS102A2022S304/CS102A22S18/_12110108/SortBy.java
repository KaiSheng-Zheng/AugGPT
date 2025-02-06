public enum SortBy {
    PurchaseTime(1),
    Rating(2),
    Price(3);
    private final int id;
    private SortBy(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }
}