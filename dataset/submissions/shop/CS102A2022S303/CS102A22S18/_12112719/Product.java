import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private int formalposition;

    public Product(String name,float price){
        cnt++;
        id=cnt;
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating){
        if (rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }

    public float getAvgRating(){
        float Avgrating=0;
        float Avg=0;
        for (int i = 0; i < ratings.size(); i++) {
            Avgrating+=ratings.get(i);
        }
        if (ratings.size()!=0){
            Avg = Avgrating / ratings.size();
        }
        return Avg;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",getId(),getName(),getPrice(),getAvgRating());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getFormalposition() {
        return formalposition;
    }

    public void setFormalposition(int formalposition) {
        this.formalposition = formalposition;
    }
}
