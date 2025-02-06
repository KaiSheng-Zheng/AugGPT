import java.util.ArrayList;
public class Product {
        private static int cnt = 0;
        private int id;
        private String name;
        private float price;
        private ArrayList<Integer> ratings = new ArrayList<Integer>();
    public Product(String name, float price){
        cnt+=cnt;
        this.name=name;
        this.price=price;
        id=cnt;
    }
    public boolean setRating(int rating) {
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else{return false;}
    }
    public float getAvgRating(){
        float a = 0;
        for(int i=1;i<=ratings.size();i++) {
            a = a+ratings.get(i);
        }
        return  a/ratings.size();
    }

    public String toString(int rating){
        String toString=String.format("Product ID id "+id+","+name+",RMB "+"%.2f"+",Rate "+"%.1f",price,rating);
        return toString;
    }
    public float getPrice(){return price;}
    public int getId(){return id;}
}
