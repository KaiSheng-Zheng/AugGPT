import java.util.ArrayList;

public class Product {

    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }


    public Product(String name, float price){
        this.id=cnt+1;
        cnt++;
        this.name=name;
        this.price=price;

    }


public boolean setRating(int rating){
if (rating<1||rating>5){
    return false;
}else {this.ratings.add(0,rating);return true;}
}



public float getAvgRating(){
        float sum=0;
        float avg;
        if(this.ratings.size()==0){return 0;}
        else {for (int a:ratings){sum=sum+a;}
           return avg=sum/this.ratings.size();}
}


public String toString(){
    float avg=getAvgRating();
    String sprice=String.format("%.2f",price);
    String savg=String.format("%.1f",avg);
String List="Product ID "+id+", "+name+", RMB "+sprice+", Rating "+savg;
    return List;
}

}
