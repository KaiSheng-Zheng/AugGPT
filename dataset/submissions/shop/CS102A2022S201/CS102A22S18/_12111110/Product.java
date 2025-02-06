import java.util.ArrayList;
public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private Store store;
    private int num;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name,float price){
        setCnt(getCnt());
        this.id=getCnt();
        this.name=name;
        this.price=price;
    }
    public void setStore(Store store){
        this.store=store;
    }
    public Store getStore(){return store;}
    public void setCnt(int cnt){this.cnt=cnt+1;}
    public int getCnt(){return cnt;}
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public float getPrice(){
        return price;
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else return false;
    }
    public void setNum(int num){
        this.num=num;
    }
    public int getNum(){return num;}
    public float getAvgRating(){
        int sum=0;
        for(int i=0;i<ratings.size();i++) sum+=ratings.get(i);
        if(ratings.size()!=0) return (float)sum/(float)ratings.size();
        else return 0;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", getId(),getName(),getPrice(),getAvgRating());
    }
}
