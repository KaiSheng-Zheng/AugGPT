import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        ++cnt;
        this.id=cnt;
        this.ratings=new ArrayList<>();
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public float getPrice() {return price;}

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        if(this.ratings.size()==0){
            return 0;
        }else{
            float average = 0;
            for(int i = 0;i<ratings.size();i++){
                average=average+ratings.get(i);
            }
            average=average/ratings.size();
            return average;
        }
    }
    @Override
    public String toString(){
        return String.format("Product ID %s, %s, RMB %.2f, Rating %.1f",getId(),getName(),getPrice(),getAvgRating());
    }
//    public static void main(String[] args){
//        Product p1 = new Product("abc",123);
//        Product p2 = new Product("abcd",1234);
//        System.out.println(p1.getId());
//        System.out.println(p2.getId());
//        System.out.println(p1.getId());
//    }
}
