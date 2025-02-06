public enum SortBy {
    PurchaseTime("1"),
    Rating("2"),
    Price("3");

    private String number;
    SortBy(String number){
        this.number = number;
    }
    public String getNumber(){
        return number;
    }

}