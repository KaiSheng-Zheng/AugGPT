import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private Store store;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.


    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
    }

    public float getPrice() {
        return price;
    }

    public Store getStore(){
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public boolean setRating(int rating){
        if (rating>5||rating<1){
            return false;
        }else {
            ratings.add(rating);
            return true;
        }
    }
    public float getAvgRating(){

        float avg=0;
        float sum=0;
        if(ratings.size()==0){
            return  0;
        }
        else {
            for (int i = 0; i < ratings.size(); i++) {
               sum+= ratings.get(i);
            }
            avg=sum/ratings.size();
            return avg;
        }
    }

    public String toString() {
        String str1=String.format("%.2f", price);
        String str2=String.format("%.1f", getAvgRating());
        String str3="Product ID "+id+", "+name+", RMB "+ str1 +
                ", Rating " +str2;
        return str3;
    }
}
