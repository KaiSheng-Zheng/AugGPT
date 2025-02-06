import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name, float price){
        Product.cnt++;
        this.name=name;
        this.price=price;
        this.id=Product.cnt;
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            return this.ratings.add(rating);
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        float sumRating = 0;
        if(ratings.size()==0){
            return 0.0F;
        }
        for(int i:this.ratings){
            sumRating+=i;
        }
        return (sumRating/ratings.size());
    }
    @Override
    public String toString(){
        String output = "Test.Product ID " + this.id + ", " + this.name + ", RMB " + String.format("%.2f",this.price) + ", Rating ";
        if (this.ratings.size() == 0) {
            output= "0.0";
        } else {
            output += String.format("%.1f",this.getAvgRating());
        }
        return output;
    }
    public float getPrice(){
        return this.price;
    }
    public int getID(){
        return this.id;
    }
}
