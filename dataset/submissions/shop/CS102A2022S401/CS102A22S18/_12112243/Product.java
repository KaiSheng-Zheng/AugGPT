import java.text.DecimalFormat;
import java.util.ArrayList;
public class Product {
        private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
        private int id; // unique for each product and the value is set to cnt.
        private String name;
        private float price;
        private Store location;
        private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
        public Product(String name, float price){
                this.name = name;
                this.price = price;
                cnt += 1;
                id = cnt;
        }
        public boolean setRating(int rating){
                if(rating>=1 && rating<=5 ){
                        ratings.add(rating);
                        return true;
                }else {
                        return false;
                }
        }
        public float getAvgRating(){
                float sum = 0 ;
                for(int i = 0 ; i<ratings.size() ; i++){
                        sum = sum + ratings.get(i);
                }
                if( ratings.size() == 0 ) return 0;
                else return sum/ratings.size();
        }

        public void setStore(Store location) {
                this.location = location;
        }
        public Store getLocation(){
                return location;
        }


        public float getPrice(){
                return price;
        }
        public String toString(){
                DecimalFormat priceAfter = new DecimalFormat("0.00");
                DecimalFormat ratingsAfter = new DecimalFormat("0.0");
                String str= "Product ID "+ this.id + ", "+ this.name + ", RMB " + priceAfter.format(this.price) + ", Rating "+ ratingsAfter.format(this.getAvgRating());
                return str;
        }
}

