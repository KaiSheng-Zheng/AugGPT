import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name,float price){
        this.name=name;
        this.price=price;
        cnt=cnt+1;
        id=cnt;

    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if(rating<=5&&1<=rating){
            ratings.add(rating);
            return true;
        }
        else{
            return false;
        }

    }
    public float getAvgRating(){
        float sum=0;
        float ave=0;
        if(ratings==null){
            return 0;
        }else{
            for(int i=0;i<ratings.size();i++){
                sum=ratings.get(i)+sum;
            }
            ave=sum/ratings.size();
        }
        return ave;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        String p=String.format("%.2f",price);
        String r=String.format("%.1f",getAvgRating());
        String des="Product ID "+String.valueOf(id)+", "+name+", RMB "+p+", Rating "+r;




        return des="Product ID "+String.valueOf(id)+", "+name+", RMB "+p+", Rating "+r;



    }

}

