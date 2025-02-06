
import java.text.DecimalFormat;
import java.util.ArrayList;


public class Product {
    private DecimalFormat df=new DecimalFormat("0.00");
    private DecimalFormat df2=new DecimalFormat("0.0");
    private static int cnt=0;
    private int id;
    private String name;
    private float price=0;
    protected Store  home;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return  true;
        }
        else {
            return false;
        }
    }

    public float getPrice() {
        return price;
    }

    public float getAvgRating(){
        float all=0f;
        for(int i=0;i<ratings.size();i++){
            all+=ratings.get(i);
        }
        return all/ratings.size();
    }

    @Override
    public String toString() {
    String priceI=String.format("%.2f",getPrice());
    String Rating=String.format("%.1f",getAvgRating());
    return "Product ID " + id + ", " + name + ", " + "RMB " + priceI + ", " + "Rating " + Rating;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id  && name.equals(product.name);
    }
}
