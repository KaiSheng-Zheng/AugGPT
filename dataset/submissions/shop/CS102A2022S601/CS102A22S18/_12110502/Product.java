import java.util.ArrayList;

class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();// ratings from different customers; default is empty.
    private int StoreId;

    public int getStoreId() {
        return StoreId;
    }

    public void setStoreId(int storeId) {
        StoreId = storeId;
    }

    public Product(String name, float price){
        cnt++;
       this.name=name;this.price=price;this.id=cnt;
    }
    public boolean setRating(int rating){
         if(rating>=1 &&rating<=5) {
             this.ratings.add(rating);
             return true;
         }else return false;
    }

    @Override
    public String toString() {
        double a;double b;
        a=Math.round(price*100)/(double)100;
        b=Math.round(this.getAvgRating()*10)/(double)10;
        return "Product ID " + id +
                ", "+ name +
                ", RMB " + String.format("%.2f",a) +
                ", Rating " + String.format("%.1f",b);
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public float getPrice() {
        return price;
    }

    public float getAvgRating(){
        int sum=0;Float sb;
        for(int x:ratings){
           sum+= x;
        }
        sb=(sum/(float)ratings.size());
        if(ratings.size()==0)return 0.0F;
        else  return  sb;
    }

}
