import java.text.DecimalFormat;
import java.util.ArrayList;
public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public float getPrice() {
        return this.price;
    }
    public Product(String name, float price){
        cnt++;
        this.name=name;
        this.price=price;
        this.id=cnt;
    }
    public boolean setRating(int rating){
        if(rating<1 || rating >5){
            return false;
        }else {
            this.ratings.add(rating);
            return true;
        }
    }
    public float getAvgRating(){
        if (this.ratings.size() == 0) {
            return 0.0f;
        }
        float sum=0;
        for(int integer : this.ratings){
            sum+= integer;
        }
        float f = sum / this.ratings.size();
        return f;
    }

    public String toString(){
        DecimalFormat priceF=new DecimalFormat("0.00");
        DecimalFormat ratingF=new DecimalFormat("0.0");
        if(this.ratings.size() == 0){
            return "Product ID " + this.id + ", " + this.name + ", RMB " + priceF.format(this.price) + ", Rating " + "0.0";
        }
        return "Product ID " + this.id + ", " + this.name + ", RMB " + priceF.format(this.price) + ", Rating " + ratingF.format(this.getAvgRating());

    }

    public boolean equals(Object A) {
        if (A.getClass() != this.getClass()) {
            return false;
        } else {
            Product product = (Product) A;
            if(product.id == this.id){
                return true;
            }else{
                return false;
            }
        }
    }

}
