import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private Store storeIn;

    public Store getStoreIn() {
        return storeIn;
    }

    public void setStoreIn(Store storeIn) {
        this.storeIn = storeIn;
    }

    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
        this.ratings=new ArrayList<>();
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
        return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        float sum=0;
        if (ratings.size()==0){return 0;}
        else {
            for (int i=0;i<ratings.size();i++){
                sum=sum+ratings.get(i);
            }
            float result=(float) sum/ratings.size();
            return result;
        }
    }
    @Override
    public String toString(){
        String result=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return result;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public static int getCnt() {
        return cnt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }


}
