import java . util . ArrayList ;

public class Product {
    private static int cnt = 0 ; 
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); 
    private Store store ;


    public Product ( String name , float price ) {
        this . name = name ;
        this . price = price ;
        cnt ++ ;
        id = cnt ;
    }
    public boolean setRating ( int rating ) {
        if ( rating >= 1 && rating <= 5 ) {
            ratings.add ( rating ) ;
            return true ;
        }
        else return false ;
    }

    public float getAvgRating() {
        if ( this . ratings . size() == 0 ) return 0 ;
        int total = 0 ;
        for ( int i = 0 ; i < ratings .size() ; i ++ ) {
            total += ratings . get ( i ) ;
        }
        return  ( (float) total) / ratings . size() ;
    }
    @Override
    public String toString() {
        return String . format ( "Product ID %d, %s, RMB %.2f, Rating %.1f" , id , name , price , getAvgRating() ) ;
    }
    public String getName () {
        return name ;
    }
    public  float getPrice () {
        return price ;
    }
    public int getId () {
        return id ;
    }
    public void addStore ( Store store ) {
        this . store = store ;
    }
    public Store getStore ( ) {
        return store ;
    }
    public void setId () {
        cnt ++ ;
        this . id = cnt ;
    }
}
