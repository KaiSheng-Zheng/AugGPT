
public enum SortBy {
    PurchaseTime("PurchaseTime"),
    Rating("Rating"),
    Price("Price");
    private String method;
    private SortBy(String method){
        this.method=method;
    }

    public String getMethod() {
        return method;
    }
}
