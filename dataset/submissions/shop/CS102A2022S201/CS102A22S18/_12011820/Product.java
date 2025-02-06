import java.util.ArrayList;
class Product{
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    Store store;


    public Product(String name, float price){
        this.name = name;
        this.price = price;
        this.id=++cnt;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5 ){
            ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating(){
        int size = ratings.size();
        int sum=0;
        for(int a : ratings){
            sum+=a;
        }
        float result = (float) sum /(float) size;
        return result;
    }
    public String toString(){
        String result = "Product ID "+id +", "+name+", RMB "+price+", Rating "+getAvgRating();
        return result;
    }
    public boolean equals(Product product){
        if(product.id == id) return true;
        else return false;
    }
}