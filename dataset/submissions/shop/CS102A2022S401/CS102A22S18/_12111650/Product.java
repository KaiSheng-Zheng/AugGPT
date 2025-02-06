import java.text.DecimalFormat;
import java.util.ArrayList;

class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        }
        else return false;
    }

    public float getAvgRating() {
        if (this.ratings.isEmpty()) {
            return 0;
        }
        else {
            float number = 0;
            float sum = 0;
            for (int i : this.ratings) {
                number++;
                sum += i;
            }
            return  (float) sum/number;
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPrice() {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(price);
    }

    public int getAllRating(){
        int sum = 0;
        if (this.ratings.isEmpty()){
            return 0;
        }
        else {
            for(int m : this.ratings){
                sum += m;
            }
            return sum;
        }
    }

    public int getRatingNumber(){
        int number = 0;
        if(this.ratings.isEmpty()){
            return 0;
        }
        else {
            for (int m : this.ratings){
                number++;
            }
            return number;
        }
    }

    public String toString() {
        float rr = Math.round(getAvgRating()*10)/10f;
        return "Product" + " ID " + getId() + ", " + getName() + ", RMB " + getPrice() + ", Rating " + rr;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return (product.getAvgRating() == this.getAvgRating() && product.getName().equals(this.getName()) && product.getPrice().equals(this.getPrice()));
    }
}
