import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.


    public float getPrice(){
        return price;
    }public void setPrice(Product product){
        this.price = price;
    }
    public int getId(){
        return id;
    }public void setId(Product product){
        this.id = id;
    }
    public Product(String name, float price){
      this.name = name;
      this.price = price;
      cnt++;
      this.id = cnt;
    }

    public boolean setRating(int rating){
        boolean result;
     if(rating >= 1&&rating <= 5){
         result = true;
         ratings.add(rating);
     }else{
         result = false;
     }return result;
    }

    public float getAvgRating(){
        int sum = 0;
        int i1 = ratings.size();
        for(int i =0;i<ratings.size();i++){
            sum += ratings.get(i);
        }
        int i = 0;
        if(ratings.size() == 0){
            i1 = 1;
        }return (float)sum/i1;
    }

    public String toString(){//Return a string description of this product, in the format of Product ID id, name, RMB price, Rating average-rating, e.g., Product ID 12345, Laptop, RMB 10000.00, Rating 4.5
     StringBuilder str = new StringBuilder();
//     price = (float)(Math.round(this.price)/100.0);//keep two decimal;
     str.append("Product ID ");str.append(this.id);str.append(", ");str.append(this.name);str.append(", RMB ");
     str.append(String.format("%.2f",this.price));str.append(", Rating ");str.append(String.format("%.1f",getAvgRating()));
     return str.toString();
    }
}


