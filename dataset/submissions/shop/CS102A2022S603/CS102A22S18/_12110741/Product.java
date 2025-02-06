import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private float avgRating;
    private Store store;
    private ArrayList<Integer> ratings= new ArrayList<>();
    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }
    public Store getStore(){
        return store;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        int n = ratings.size();
        float sum=0;
        if (ratings.size()==0){
            return avgRating=0;
        }else{
        for (int i=0; i<n; i++){
            sum=sum+ratings.get(i);
        }

        return avgRating=sum/n;}
    }
    public String toString(){
        return String.format("Product ID %s, %s, RMB %.2f, Rating %.1f",id,name,price,avgRating);
    }

}
