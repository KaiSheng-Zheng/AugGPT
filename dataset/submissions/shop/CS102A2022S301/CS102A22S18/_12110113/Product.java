import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name,float price){
        this.name=name;
        this.price=price;
        cnt=cnt+1;
        this.id=cnt;
    }
    public boolean setRating(int rating){
        if (rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }
        else {return false;}
    }

    public float getAvgRating(){
        int all=0;
        if (ratings.size()==0){return 0;}
        else {for (int i=0;i<ratings.size();i++){
            all=all+ratings.get(i);
        }
        float average=Float.valueOf(all)/ratings.size();
        return average;}
    }

    public String toString(){
        String after="";
        after="Product ID "+String.valueOf(id)+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
        return after;
    }


    public float getPrice() {
        return price;
    }
}
