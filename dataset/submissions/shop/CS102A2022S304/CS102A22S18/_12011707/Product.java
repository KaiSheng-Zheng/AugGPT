import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name,float price){
        this.name=name;
        this.price=price;
        cnt+=1;
        this.id=cnt;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public boolean setRating(int rating){
        if(rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public float getAvgRating(){
        float t=0;
        float v=0;
        for (Integer rating : ratings) {
            t += rating;
            v+=1;
        }
        if (v == 0) {
            return 0;
        }else {
            return t/v;
        }
    }
    public String toString(){
        StringBuilder sc=new StringBuilder();
        sc.append("Product ID ");
        sc.append(this.id);
        sc.append(", ");
        sc.append(this.name);
        sc.append(", RMB ");
        sc.append(String.format("%.2f",this.price));
        sc.append(", Rating ");
        sc.append(String.format("%.1f",getAvgRating()));
        return sc.toString();
    }
    public static boolean equals(Product p1,Product p2){
        return p1.name.equals(p2.name)&&p1.getId()==p2.getId();
    }
}
