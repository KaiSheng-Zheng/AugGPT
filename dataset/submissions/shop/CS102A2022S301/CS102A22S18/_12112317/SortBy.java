public enum SortBy{
    PurchaseTime(1),Rating(2),Price(3);
    private int shu;
    private SortBy(int shu){
        this.shu = shu;
    }

    public int getShu(){
        return shu;
    }
}