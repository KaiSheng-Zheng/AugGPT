import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private int storeID=0;

    public Product(String name, float price){
        cnt++;
        this.name=name;
        this.price=price;
        this.id=cnt;
    }

    public int getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public float getPrice(){
        return this.price;
    }

    public void setStoreID(int storeID){
        this.storeID=storeID;
    }
    public int getStoreID(){
        return this.storeID;
    }

    public boolean setRating(int rating){
        if (rating==1||rating==2||rating==3||rating==4||rating==5) {
            this.ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        float all=0;
        if (this.ratings.size()==0) return 0f;
        if (this.ratings.size()==1) return this.ratings.get(0);
        for (int i=0;i<this.ratings.size();i++){
            all=all+this.ratings.get(i);
        }
        return all/(this.ratings.size());
    }

    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating());
    }
}