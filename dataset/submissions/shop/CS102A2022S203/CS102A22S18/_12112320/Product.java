import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();


    public Product(String name, float price){
        this.name=name;this.price=price;
        cnt++;
        id=cnt;
    }
    public boolean setRating(int rating){
        if (rating<1||rating>5){return false;}
        this.ratings.add(rating);
return true;
    }
    public float getAvgRating(){
       int sum=0;
       int a=ratings.size();
       for (int i=0;i<ratings.size();i++){
           sum+=ratings.get(i);
       }
       if (ratings.size()==0){a=1;}
       return (float)sum/a;
    }
    public String toString(){
        String a=String.format("%.2f",price);
        String b=String.format("%.1f",getAvgRating());
        return "Product ID "+id+", "+name+", RMB "+a+", Rating "+b;
    }
    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null||getClass()!=o.getClass()){
            return false;
        }
        Product p=(Product)o;
        return id==p.id;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
