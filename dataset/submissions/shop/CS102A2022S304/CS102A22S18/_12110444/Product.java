import java.util.ArrayList;
import java.lang.Math;
public class Product {
        private static int cnt=0;
        private int id;
        private String name;

    public float getPrice() {
        return price;
    }

    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name,float price){
            this.name=name;
            this.price=price;
            cnt= cnt+1;
            this.id= cnt;

        }
        public boolean setRating(int rating){
            if(rating<=5&&rating>=1){
                ratings.add(rating);
                return true;
            }
            else{return false;}
        }

        public float getAvgRating(){
            float n=0;
        if(ratings.size()>0){
                long sum=0;
            for (int i = 0; i < ratings.size(); i++) {
                sum=sum+ratings.get(i);
            }
           n=(float)sum/ratings.size();
        }else if(ratings.size()==0){
                n=(float) 0.00;
            }
    return n;}

        @Override
        public String toString(){
            String s=new String();
            return  s.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,price,(float)Math.round(this.getAvgRating()*10)/10);
        }

    }

