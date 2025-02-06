import java.util.ArrayList;
public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private ArrayList<Integer> ratings= new ArrayList<Integer>(); // ratings from different customers; default is empty.
    private float price;
    private int purchasetinme;
    public Product(String name, float price){
        this.name=name;this.price=price;
        cnt++;id=cnt;}
    public int getPurchasetinme() {
        return purchasetinme;
    }
    public void setPurchasetinme(int purchasetinme) {
        this.purchasetinme = purchasetinme;
    }
    public float getPrice() {
        return price;
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5) {
            ratings.add(rating);
            return true;}
        else return false;
        }
    public float getAvgRating(){
        float a=0;
        for(int i=0;i<ratings.size();i++){
            a+=ratings.get(i);}
        if(a!=0)return a/ratings.size();
        else return 0;
        }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
