import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id=1;
    private String name;
    private float price;
    private ArrayList<Integer>ratings=new ArrayList<>();

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice() {
        this.price = price;
    }

    public boolean setRating(int rating){

        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;

        }
        else {
            return false;
        }

    }

    public float getAvgRating(){
        float sum=0;
        if (ratings.size() != 0) {

            for(int i=0;i<ratings.size();i++){
                sum+=ratings.get(i);
            }
            return sum/ratings.size();
        }
        else {
            return 0;
        }

    }
    public String toString(){
        return String.format("Product ID %d, "+"%s, "+"RMB %.2f, "+"Rating %.1f",id,name,price,getAvgRating());
    }


}
