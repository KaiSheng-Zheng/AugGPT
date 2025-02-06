import java.util.ArrayList;

public class Product {
    private static int cnt = 0 ;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer>ratings = new ArrayList<>();
    public Store whichStore;




    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt ++;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if(rating == 1 | rating == 2 | rating== 3 | rating==4 | rating==5){
            this.ratings.add(rating);
            return true;
        }

        else {
            return false;
        }
    }
    public float getAvgRating(){
        float sum = 0;
        float avg;
        if (ratings.isEmpty()){
            return 0;
        }
        for (Integer rating : ratings) {
            sum += rating;
        }
        avg = sum /ratings.size();
        return avg;

    }


    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setWhichStore(Store whichStore) {
        this.whichStore = whichStore;
    }

    public boolean order(Product product1){
        return product1.getId() == this.id && product1.getName().equals(this.name);
    }

    public String toString(){

        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());

    }



}
