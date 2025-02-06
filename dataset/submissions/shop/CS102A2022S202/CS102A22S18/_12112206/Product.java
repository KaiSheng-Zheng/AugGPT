import java.util.ArrayList;
class Product{

    private static int cnt = 0; 
   
    private int id;

    private String name;

    private float price;

     private ArrayList<Integer>  ratings =new ArrayList<>();

    public float getprice(Product product){return product.price;}

    public ArrayList<Integer> getratings(Product product)
    {return product.ratings;}

    Product(String name, float price){
      
    this.name =name;
    this.price =price;
    cnt++;
    id = cnt;
    };


    public boolean setRating(int rating){
        if (rating>=1||rating<=5) {
            ratings.add(rating);
        return true;
    }
        else return false;
    }

    public float getAvgRating(){
float ratingsum=0;
int i ;
float avg = 0;
for (i=0;i<=ratings.size()-1;i++)
{

    ratingsum = ratingsum + ratings.get(i);

}
if (ratings.size()!=0) {
    
    return (float) ratingsum/ratings.size();

}
    else return avg; 
   
}


public String toString()
{
return "Product ID "+ id +", "+ name +","+" RMB "+ price +"," +" rating "+ getAvgRating() ;

        
    };



}






