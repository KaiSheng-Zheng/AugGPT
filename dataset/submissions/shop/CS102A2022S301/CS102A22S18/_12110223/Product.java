import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id=0;  // unique for each product and the value is set to cnt.
    private String name="";
    private float price=0;
    private ArrayList<Integer> ratings=new ArrayList<Integer>(); // ratings from different customers; default is empty.

    public Product(String name, float price) {
        cnt = cnt + 1;
        id = cnt;
        this.name = name;
        this.price = price;
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

    public boolean setRating (int rating) {
            if (rating <=5 && rating>=1) {
                ratings.add(rating);
                return true;
            } else {
                return false;
            }
        }

        public float getAvgRating () {
            float he = 0;
            int x=0;
            if (ratings != null) {
                x= ratings.size();
                for (int i = 0; i < x; i++) {
                    he = he + ratings.get(i);
                }
                he = (float) he / x;
            }
            return he;
        }

        public String toString () {
           return "Product ID "+id+", "+name+", "+"RMB "+String.format("%.2f",price)+", "+"Rating "+ String.format("%.1f",getAvgRating());
        }
    }