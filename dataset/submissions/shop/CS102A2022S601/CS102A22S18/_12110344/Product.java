import java.util.ArrayList;

public class Product {

    private static int cnt=0;
    private int id;
    public int getId(){return id;}
    private String name;
    private float price;
    public float getPrice(){return price;}
    private ArrayList<Integer> ratings;

    private Store store;
    public void setStore(Store store){this.store=store;}
    public Store getStore() {return store;}

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
        ratings=new ArrayList<>();
    }

    public boolean setRating(int rating){
        if(rating>=1&rating<=5) {
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }

    public float getAvgRating(){
        float SumRating=0;
        for(int i=0;i<ratings.size();i++){
            SumRating+=ratings.get(i);
        }
        return SumRating==0?0:(float)SumRating/ratings.size();
    }

    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }


}