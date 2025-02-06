import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();


    public Product(String name, float price){
        cnt++;
        this.id=this.cnt;
        this.name=name;
        this.price=price;
    }


    public boolean setRating(int rating){
        if ((rating==1)||(rating==2)||(rating==3)||(rating==4)||(rating==5)){
            this.ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }

    public float getAvgRating(){
        if (ratings.isEmpty() ){
            return 0;
        }
        else {
            float sum=0;
            int number=0;
            for (Integer r:ratings) {
                sum+=r;
                number++;
            }
            return sum/number;
        }
    }

    public String toString(){
        String s=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating());
        return s;
    }

    @Override
    public boolean equals(Object o){
        if (this==o){
            return true;
        }
        else if (o==null||getClass()!=o.getClass()){
            return false;
        }
        else {
            if (id==((Product) o).id){
                return true;
            }
            else {
                return false;
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }
}
