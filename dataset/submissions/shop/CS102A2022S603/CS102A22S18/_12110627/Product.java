import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private Store store;

    public Product(String name,float price){
        this.name =name;
        this.price=price;
        cnt=cnt+1;
        id=cnt;
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        int sum=0;

        for(int i=0;i<ratings.size();i++){
            sum=sum+ratings.get(i);
        }
        if(ratings.size()==0){
            return 0;
        }else{
        float AvgRating=(float)sum/ratings.size();
        return AvgRating;
    }
    }
    public void setStore(Store store){
        this.store=store;
    }
    public  Store getStore(){
        return store;
    }

    public float getPrice(){
        return (float) price;
    }

    @Override
    public String toString(){

        return String.format("%s %d, %s, %s %.2f, %s %.1f","Product ID",id,name,"RMB",getPrice(),"Rating",getAvgRating());
    }

}
