
import java.util.ArrayList;
import java.util.Objects;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    public int shoppingTime;
    Store boughtFrom=null;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name,float price){
        id=++cnt;
        this.name=name;this.price=price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Float.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(ratings, product.ratings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, ratings);
    }

    public boolean setRating(int rating){
        if(rating<1||rating>5)return false;
        ratings.add(rating);
        return true;
    }
    public float getAvgRating(){
        int totRating=0;
        for(int r:ratings)totRating+=r;
        if(ratings.size()==0)return 0f;
        return (float)totRating/ratings.size();
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Product ID " + id +
                ", " + name +
                ", RMB %.2f"+
                ", Rating %.1f",price,getAvgRating());
    }
}
