import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price){
        cnt = cnt + 1;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    int num = 0;
    public boolean setRating(int rating){
        if(rating<1||rating>5){
            return false;
        }else {
            ratings.add(rating);
            num = num+1;
            return true;
        }
    }

    public float getAvgRating(){
        int he = 0;
        for(int i = 0;i<ratings.size();i++){
            he = he + ratings.get(i);
        }
        float avg = 0.0F;
        if(num>0){
            avg = ((float) he)/num;
        }
        return avg;
    }

    public String toString(){
        String out = String.format("Product ID %s, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,getAvgRating());
        return out;
    }

    public boolean equals(Product obj) {
        if(this.id == obj.id){
            return true;
        }
        if(obj == null){return false;}
        if(obj instanceof Product){
            Product p = (Product) obj;
            if(id==p.id){
                return true;
            }
        }
        return false;
    }

    public int getCnt(){return cnt;}
    public float getPrice(){return price;}
}
