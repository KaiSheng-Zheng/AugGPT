import java.util.ArrayList;
public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings= new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
        Product.cnt++;
        this.id=Product.cnt;
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating){
        if (rating!=1&&rating!=2&&rating!=3&&rating!=4&&rating!=5)
            return false;
        else
            return this.ratings.add(rating);
    }

    public float getPrice() {
        return this.price;
    }

    public float getAvgRating(){
        if (this.ratings.size() == 0) return 0.0f;
        float b=0;
        for (int a:this.ratings)
            b+=a;
        return  b/this.ratings.size();
    }
    @Override
    public String toString(){String a="Product ID "+this.id+", "+this.name+", RMB"+String.format("%.2f",this.price)+", Rating ";
        if (this.ratings.size() == 0) {
            a += "0.0";
        } else {
            a += String.format("%.1f",this.getAvgRating());
        }
        return a;
    }
}