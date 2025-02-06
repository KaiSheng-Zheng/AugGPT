import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.price=price;
        this.name=name;
    }
    public boolean setRating(int rating){
        boolean setRating;
        if(rating>=1&&rating<=5){
            setRating=true;
            this.ratings.add(rating);
        }else {
            setRating=false;
        }
        return setRating;
    }

    public int getId() {
        return this.id;
    }
    public float getPrice() {
        return this.price;
    }

    public float getAvgRating(){
        int l=this.ratings.size();
        int sum=0;
        if(l!=0){
        for(int i=0;i<l;i++){
            sum+=this.ratings.get(i);
        }
       return (float)sum/l;}else {
            return 0;
        }
    }
    public String toString() {
        return "Product ID "+ this.id+", "+this.name+", RMB "+String.format("%.2f",this.price)+", Rating "+String.format("%.1f",this.getAvgRating());
    }
}
