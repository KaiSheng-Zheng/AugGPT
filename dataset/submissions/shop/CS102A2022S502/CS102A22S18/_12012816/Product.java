import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    private Store source;

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            this.ratings.add(rating);
            return true;
        }

        else
            return false;
    }
    public float getAvgRating(){
        float sum =0;
        for (int i = 0; i < this.ratings.size(); i++) {
            sum+=this.ratings.get(i);
        }
        if (this.ratings.size()!=0){
            sum=sum/(float) this.ratings.size();
            return sum;
        }else
            return 0;

    }
    public String toString(){
        String output = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.getPrice(),this.getAvgRating());
        return output;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public Store getSource() {
        return source;
    }

    public void setSource(Store source) {
        this.source = source;
    }
}
