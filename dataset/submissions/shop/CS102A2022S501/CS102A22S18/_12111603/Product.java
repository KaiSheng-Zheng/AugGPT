

import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public int getID(){
        return id;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        boolean flag = false;
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            flag = true;
            ratings.add(rating);
        }
        return flag;
    }

    public float getAvgRating() {
        if(ratings.size()==0){
            return 0;
        } else {
            float sum = 0;
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            float avgRating = sum / ratings.size();
            return avgRating;
        }
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}






