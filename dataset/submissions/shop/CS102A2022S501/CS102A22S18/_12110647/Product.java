import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    int sum=0;//to get avg
    static int x=0;
    private ArrayList<Integer> ratings;

    public float getPrice() {
        return price;
    }

    public Product(String name, float price){
        this.id=ratings.get(id);
        return;//get id
    }
    public boolean setRating(int rating){
       if(rating<=5||rating>=1){
           ratings.add(rating);//add rating to ratings
           return true;
       }else {
           return false;
       }
    }

    public ArrayList<Integer> getRatings() {//ratings
        return ratings;
    }

    public float getAvgRating(){
        for(int i=0;i<ratings.size();i++){
            sum+= ratings.get(i);//get sum of ratings
        }
        x=sum/ratings.size();
        return x;//avg rating
    }
    public String toString(){
        float p=(float) (Math.round(price*100))/100;//round
        float r =(float) (Math.round(x*10))/10;
        return "Product ID"+id+","+name+",RMB"+p+",Rating"+r;//output string
    }//round

    public String getProductArrayList() {
        return getProductArrayList();
    }
}