import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings =new ArrayList<>();

    public Product(String name,int id,float price,ArrayList<Integer> ratings){
        this.name=name;
        this.id=id;
        this.price=price;
        this.ratings=ratings;
    }

    public Product(String name,float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating==1||rating==2||rating==3||rating==4||rating==5){
            ratings.add(rating);
            return true;
        }
        return false;
    }
    public float getAvgRating(){
        double ratingSum=0;
        for (int i = 0; i < ratings.size(); i++) {
            ratingSum+=ratings.get(i);
        }
        double result=0;
        if (ratings.size()==0){
            return 0f;
        }
        result= ratingSum/ratings.size();
        return (float) result;
    }
    public String toString(){
        float averageRating =getAvgRating();
        String SOUT=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,averageRating);
        return SOUT;
    }
    public String toStringTest(){
        float averageRating =getAvgRating();
        String SOUT=String.format("%s, RMB %.2f, Rating %.1f",name,price,averageRating);
        return SOUT;
    }



}
