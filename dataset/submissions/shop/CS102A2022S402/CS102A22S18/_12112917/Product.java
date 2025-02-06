import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private final int id;
    private final String name;
    private final float price;
    private ArrayList<Integer> ratings;
    private Store ps;
    public Product(String name, float price){
        cnt++;
        this.name = name;
        this.price = price;
        id = cnt;
        ratings = new ArrayList<>();
    }
    public boolean setRating(int rating){
        if(rating==1||rating==2||rating==3||rating==4||rating==5){
            ratings.add(rating);
            return true;
        }else return false;
    }
    public float getAvgRating(){
        if(ratings.size()>0){float h = 0;
        for(int i = 0;i<ratings.size();i++){
            h+=ratings.get(i);
        }
        return h/ratings.size();}
        else
            return 0;
    }
    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public Store getPs() {
        return ps;
    }

    public void setPs(Store ps) {
        this.ps = ps;
    }
}
