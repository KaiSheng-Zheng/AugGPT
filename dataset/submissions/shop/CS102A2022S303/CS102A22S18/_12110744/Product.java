import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name,float price){
        Product.cnt++;
        this.id=Product.cnt;
        this.name=name;
        this.price= price;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }else return false;
    }

    public float getAvgRating(){
        if (ratings.size()==0)
            return 0.0f;
        float allsum=0;
        float average=0;
        for (int i:this.ratings) {
            allsum +=i;
        }average=allsum/ this.ratings.size();
        return average;
        }

    @Override
    public String toString(){
        String output;
        output = "Product ID " + this.id + ", " + this.name + ", RMB " + String.format("%.2f",this.price) + ", Rating ";
        if (ratings.size()==0){
            output+="0.0";
        }else {
            output+=String.format("%.1f",getAvgRating());
        }return output;
    }
    //equals means ,String format means ,Decimal means

    public int getId() {
        return id;
    }

}


