import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private int purchaseTime=0;

    public void setPurchaseTime(int a){
        this.purchaseTime=a;
    }
    public int getPurchaseTime(){
        return purchaseTime;
    }

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
        this.ratings=new ArrayList<>();
    }

    public int getId(){
        return this.id;
    }

    public float getPrice(){
        return this.price;
    }

    public boolean setRating(int rating){
        if (rating<=5&&rating>=1) {
            this.ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        float a=0;
        if (ratings.size()==0){
            return 0;
        }else{
            for (int i = 0; i < ratings.size(); i++) {
               a=a+ratings.get(i);
            }
            a=a/ratings.size();
            return a;
        }
    }

    public String toString(){
        StringBuilder stringAll=new StringBuilder();
        stringAll.append("Product ID "+String.valueOf(this.id)+", "+name+", RMB "+String.format("%.2f",this.price)+", Rating "+String.format("%.1f",getAvgRating()));
        return stringAll.toString();
    }

    public static void main(String[] args) {
        Product pro1=new Product("pro1",300);
        pro1.setRating(80);
        pro1.setRating(77);
        String str=pro1.toString();
    }
}

