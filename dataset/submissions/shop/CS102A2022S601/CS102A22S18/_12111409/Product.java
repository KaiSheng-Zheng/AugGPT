import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    public Store whichStore;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id=cnt;
    }

    public boolean setRating(int rating){
        if(rating==1||rating==2||rating==3||rating==4||rating==5) {
            this.ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }

    public void setStore(Store store){
        this.whichStore = store;
    }

    public float getAvgRating(){
        if(ratings.isEmpty()){
            return 0;
        }
        float ans;
        int sum=0;
        for(int i=0;i<ratings.size();i++){
            sum=sum+ratings.get(i);
        }
        ans=((float)sum)/ratings.size();
        return ans;
    }

    public String toString(){
        String ans="Product ID ";
        ans=ans.concat(String.valueOf(id));
        ans=ans.concat(", ");
        ans=ans.concat(name);
        ans=ans.concat(", RMB ");
        ans=ans.concat(String.format("%.2f",price));
        ans=ans.concat(", Rating ");
        ans=ans.concat(String.format("%.1f",getAvgRating()));
        return ans;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Float getPrice(){
        return this.price;
    }

    public boolean equals(Product otherProduct){
        if(otherProduct.getId()==this.id&&otherProduct.getName().equals(this.name)){
            return true;
        }
        else{
            return false;
        }
    }
}
