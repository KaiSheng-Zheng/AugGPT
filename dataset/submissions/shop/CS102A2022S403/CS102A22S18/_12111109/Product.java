import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>();

    private static String gpf(float ff) {
        int x = (int)(ff*100f);
        if(x%10>=5) {
            x+=10;
        }
        x/=10;
       int z=x/10;
       int f=x%10;
       String s1 = Integer.toString(z);
       String s2 = Integer.toString(f);
        return s1+"."+s2;
    }

    private static String gPrice(float ff) {
        int x = (int)(ff*1000f);
        if(x%10>=5) {
            x+=10;
        }
        x/=10;
        int z=x/100;
        int f=x%100;
        String s1 = Integer.toString(z);
        String s2 = Integer.toString(f);
        if(f==0) s2+="0";
        return s1+"."+s2;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id=cnt;
    }

    public boolean setRating(int rating) {
        if (rating <= 5 && rating >= 1) {
            this.ratings.add(rating);
            return true;
        } else return false;
    }

    public float getAvgRating() {
        float avg = 0;
        if(ratings.size()==0) return 0;
        for (int i = 0; i < ratings.size(); i++) {
            avg += (float)ratings.get(i);
        }
        avg = avg / (float) ratings.size();
        return avg;
    }

    public String toString() {
        return "Product ID "+Integer.toString(id)+", "+name+", "+"RMB "+gPrice(price)+", "+"Rating "+gpf(getAvgRating());
    }
    public float getPrice(){
        return price;
    }
}
