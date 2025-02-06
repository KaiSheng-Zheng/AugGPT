import java.text.DecimalFormat;
import java.util.Scanner;import java.util.Arrays;
import java.lang.Math;import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private ArrayList<Store> stores=new ArrayList<>();
    private int buytime;
    private String storename;
    public boolean hasstore(Store store){
        if (stores.contains(store)){
            return true;
        }
        else return false;
    }
    public void addstores(Store store){
        this.stores.add(store);
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;id=cnt;
    }

    public void setBuytime(int a){
        this .buytime=a;
    }
    public int getBuytime(){
        return buytime;
    }
    public boolean setRating(int rating){
        if(rating<1||rating>5){
            return false;
        }
        else return this.ratings.add(rating);
    }
    public float getPrice(){
        return price;
    }

    public float getAvgRating(){
        float total=0;
        if(ratings.size()!=0){
            for (int i=0;i<ratings.size();i++){
                total=total+ratings.get(i);
            }
            total=total/ratings.size();

        }
        return total;
    }
    public String toString(){
        StringBuilder s=new StringBuilder();
        DecimalFormat f1 = new DecimalFormat("0.00");
        DecimalFormat f2 = new DecimalFormat("0.0");
        s.append("Product ID ");
        s.append(id);
        s.append(", ");
        s.append(name);
        s.append(", RMB ");
        s.append(f1.format(price));
        s.append(", Rating ");
        s.append(f2.format(getAvgRating()));
        String s1=s.toString();
        return s1;
    }
}
