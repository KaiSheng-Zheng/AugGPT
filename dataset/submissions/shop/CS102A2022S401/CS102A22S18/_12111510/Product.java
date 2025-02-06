import java.util.ArrayList;
public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private Store whichStore ;
    public Product(String name, float price){

        this.name = name;
        this.price = price;
        cnt = cnt+1;
        id = cnt;

    }

    public boolean setRating(int rating) {
        if (rating ==1||rating ==2||rating ==3||rating ==4||rating ==5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {

        int average = 0;
        int num = 0;
        for (int i = 0; i < ratings.size(); i++) {
                average += ratings.get(i);
                num +=1 ;
        }
        if (num ==0){
            return 0;
        }

        return (float)average/num;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f" ,id, name, price, getAvgRating());
    }

    public float getPrice(){
        return price;
    }

    public int getId() {
        return id;
    }

    public Store getWhichStore() {
        return whichStore;
    }

    public void setWhichStore(Store whichStore) {
        this.whichStore = whichStore;
    }
}
