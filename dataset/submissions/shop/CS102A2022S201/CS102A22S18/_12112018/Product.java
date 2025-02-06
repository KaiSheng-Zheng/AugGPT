import java.util.ArrayList;
public class Product {
    private static int cnt = 1 ;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name, float price ){
        this.name = name ;
        this.price = price ;
        this.ratings = new ArrayList<>(0) ;
        this.id = cnt ;
        cnt++ ; }
    public int getId(){
        return id ; }
    public void setName(String name){
        this.name = name ; }
    public String getName(){
        return name ; }
    public float getPrice(){
        return price ; }
    public float getCnt(){
        return cnt ; }
    public boolean setRating(int rating){
        if( 1 <= rating && rating <= 5 ){
            this.ratings.add(rating ) ; return true ; }
        else{ return false ; } }
    public float getAvgRating(){
        float c = 0 ;
        float avg  ;
        for( int i = 0 ; i < ratings.size() ; i++ ){
            c = c + ratings.get(i) ; }
        if( ratings.size() == 0 ){ avg = 0 ; }
        else{ avg =  c/ratings.size() ; }
        return avg ; }
    public String toString(){
        return String.format( "Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating() ) ; }
}




