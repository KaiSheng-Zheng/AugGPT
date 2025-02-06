import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name="";
    private float price=0;
    private ArrayList<Integer> ratings=new ArrayList<>();


    public Product(String name, float price) {
        cnt++;
        id=cnt;
        this.name=name;
        this.price=price;
    }



    public float getPrice(){
        return price;
    }



    public boolean setRating(int rating){
       if(rating<=5&rating>=1){
            ratings.add(rating);
            return true;
        }else {
           return false;

       }

    }
    public float getAvgRating(){
        float ave,he=0;
        if(ratings.size()!=0) {
            for (int i = 0; i < ratings.size(); i++) {
               he+= ratings.get(i);
            }
            ave = he / (ratings.size());
            return ave;
        }else{
            return 0;
        }

    }
    @Override
    public String toString(){
float average=getAvgRating();
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,average);
    }

}

