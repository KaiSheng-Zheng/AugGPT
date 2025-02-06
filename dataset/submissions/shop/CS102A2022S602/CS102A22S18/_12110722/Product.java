import java.util.ArrayList;
public class Product{
    //BTW, cnt is an abbr. for count(counter).
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<Integer>(1); // ratings from different customers; default is empty.
    private int purchaseTime;
    private Store tag;//you shall NEVER change this variables!!!

    public Product(String name, float price){
        cnt++;
        this.name=name;
        this.price=price;
        this.id = cnt;
    }

    public int getId() {
        return id;
    }

    public int getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(int purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if(rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        if(ratings.size()==0||ratings==null){
            return 0.0F;            
        }
        float addnum=0;
        for (int i = 0; i < ratings.size(); i++) {
            addnum+=ratings.get(i);
        }
        float result = 0;
        result = addnum/ratings.size();
        return result;
    }

    @Override
    public String toString(){
        String output = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",getId(),getName(),getPrice(),getAvgRating());
        return output;
    }

    public void setTag(Store store) {
        this.tag=store;
    }

    public Store getTag() {
        return tag;
    }
}