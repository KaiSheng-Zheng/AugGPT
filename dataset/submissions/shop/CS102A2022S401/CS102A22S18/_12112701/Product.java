import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private ArrayList<Store> store=new ArrayList<>();


    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
    }

    public boolean setRating(int rating){
        if(checkRating(rating)){
            this.ratings.add(rating);
            return true;
        }
        else return false;
    }

    public float getAvgRating(){
        float average=0;
        if (this.ratings.size()>0){
            for (int i=0;i<this.ratings.size();i++) {
                average += this.ratings.get(i);
            }
            average/=this.ratings.size();
            return average;
        }
        else return average;
    }

    public String toString(){
        String str=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,this.getAvgRating());
        return str;
    }

    public float getPrice(){
        return this.price;
    }

    public boolean checkRating(int rating){
        return 1 <= rating && 5 >= rating;
    }



    public ArrayList<Store> getStore(){
        return this.store;
    }
}
