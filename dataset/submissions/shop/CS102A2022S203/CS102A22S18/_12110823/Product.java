import java.util.ArrayList;


public class Product implements Comparable<Product> {
    private static int cnt = 0;
    // initialized to 0, and will increase by 1 when the
    private int time;
    private int id = 0; // unique for each product and the value is set to cnt.
    private String name;
    private float price;

    private ArrayList<Integer> ratings=new ArrayList<>();


    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<Integer>();
    }

    public boolean setRating(int rating) {
        if (rating==1||rating==2||rating==3||rating==4||rating==5) {
            this.ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public float getAvgRating() {
         int all = 0;
         int rateNum = 0;
        if (ratings.size() == 0) {
            return 0;
        } else {
            for (int i = 0; i < ratings.size(); i++) {
                all+=ratings.get(i);
            }
            float avg=(float) all/ratings.size();
            return avg;
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product ID ");
        sb.append(id);
        sb.append(", ");
        sb.append(name);
        sb.append(", ");
        sb.append("RMB ");
        sb.append(String.format("%.2f",price));
        sb.append(", ");
        sb.append("Rating ");
        sb.append(getAvgRating());
        return sb.toString();
    }

    @Override
    public int compareTo(Product o) {
        if (o.price == this.price) {
            return this.name.compareTo(o.name);
        }
        return (int) (o.price - this.price);
    }

}