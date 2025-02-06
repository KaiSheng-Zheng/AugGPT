
import java.util.ArrayList;
import java.util.Objects;

public class Product {
        private static int cnt;
        private int id;
        private String name;
        private float price;
        private ArrayList<Integer> ratings=new ArrayList<>();
        public Product(String name, float price){
            cnt++;
            this.id=cnt;
            this.name=name;
            this.price=price;
        }
        public boolean setRating(int rating){
            if(rating>=1&&rating<=5){
                ratings.add(rating);
                return true;
            }
            else {
               return false;
            }
        }

        public float getAvgRating(){
            float total=0;float f=0;
            for (int i = 0; i < ratings.size(); i++) {
                total+=(float)ratings.get(i);
            }
            if(total!=0) {
                f=total / ratings.size();
            }
            else if(total==0||ratings.size()==0){
                f=0;
            }
            return f;
        }

        public String toString(){
            return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating() );
        }

        public int getId() {
            return id;
        }

        public float getPrice() {
            return price;
        }
}





