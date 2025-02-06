import java.util.ArrayList;

public class Product implements Comparable<Product>{
    private static int cnt=0;//initial is 0 increase by 1 when the constructor is called
    private int id;//unique for each product and the value is set to cnt
    private String name;
    private float price;
    private ArrayList<Integer> ratings;//rating from different customers default is empty


    public Product(String name, float price) {
        cnt++;
        this.id=cnt;
        this.name = name;
        this.price = price;
        this.ratings =new ArrayList<>();
    }


    public int getId() {
        return id;
    }


    public boolean setRating(int rating){
        if (rating<1||rating>5){
            return false;
        }else {
            this.ratings.add(rating);
            return true;
        }
    }

    public float getAvgRating(){
        int sum=0;
        float avg;
        if(this.ratings.size() == 0){
            return (float) 0;
        }
        for (int i = 0; i < this.ratings.size(); i++) {
            sum+=this.ratings.get(i);
        }
        avg = (float) sum/this.ratings.size();
        return avg;
    }

    @Override
    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product o) {
        if(this.price>o.getPrice())
        {
            return 1;
        }else if (this.price<o.getPrice()){
            return -1;
        }else
        return 0;
    }
}
