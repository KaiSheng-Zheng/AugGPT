import java.text.DecimalFormat;
import java.util.ArrayList;


class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();


    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt = cnt + 1;
        id = cnt;
    }

    public boolean setRating(int rating){
        if(rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }else return false;
    }

    public float getAvgRating(){
        float tempResult = 0;
        if(ratings.isEmpty()){
            return tempResult;
        }else{
            for (Integer rating : ratings) {
                tempResult = tempResult + rating;
            }
            tempResult /= (float)ratings.size();
            return tempResult;
        }
    }

    @Override
    public String toString(){
        int ID = id;
        String NAME = name;

        DecimalFormat controller1 = new DecimalFormat("0.00");
        DecimalFormat controller2 = new DecimalFormat("0.0");
        float PRICE = price;
        float aveRATING = this.getAvgRating();

        return "Product ID "+ID+", "+NAME+", RMB "+controller1.format(PRICE)+", Rating "+controller2.format(aveRATING);
    }

    public int getId(){
        return id;
    }

    public float getPrice(){
        return price;
    }

}

