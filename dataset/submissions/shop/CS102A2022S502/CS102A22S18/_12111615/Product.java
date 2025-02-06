import java.util.ArrayList;

public class Product {private static int cnt; // initialized to 0, and will increase by 1 when the
//    constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default
//    is empty.
public Product(String name, float price){
    id=++cnt;
    this.name=name;
    this.price=price;
    ratings=new ArrayList<>();
}
    public boolean setRating(int rating){
if(rating<=5&&rating>=1){
    ratings.add(rating);
    return true;}
else return false;


}protected float getPrice(){
        return price;
    }
    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null||getClass()!=o.getClass()){
            return false;
        }
        Product p=(Product)o;
        return id==p.id;
    }
    public float getAvgRating(){
    double sum=0;
    if (ratings.size()==0)return 0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        return (float) (sum/ratings.size());
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public Object getID() {return id;
    }
}
