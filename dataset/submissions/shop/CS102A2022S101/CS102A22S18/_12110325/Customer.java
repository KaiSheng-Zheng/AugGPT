import java . util. ArrayList ;
import java . util . Collections ;
import java . util . Comparator ;


class SortByRating implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
            return product2.getAvgRating() <= product1.getAvgRating() ? 1 : -1;
    }
}
class SortByPrice implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return product2.getPrice() <= product1.getPrice() ? 1 : -1;
    }
}
public class Customer {
    private static int cnt = 0 ;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet ;

    public Customer(String name, float wallet) {
        this . name = name ;
        this . wallet = wallet ;
        cnt ++ ;
        id = cnt ;
    }
    public boolean rateProduct(Product product, int rating) {
        if ( product . setRating ( rating ) ) return true ;
        return false ;
    }
    public void updateWallet(float amount) {
        wallet += amount ;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if ( store . hasProduct ( product ) && wallet >= product . getPrice()){
            updateWallet ( - product . getPrice() );
            store . transact( product , 0  ) ;
            shoppingCart . add ( product ) ;
            return true ;
        }
        else return false ;
    }
    public void viewShoppingCart(SortBy sortMethod) {
        switch ( sortMethod ) {
            case PurchaseTime:
                printPurchaseTime() ;
                break;
            case Rating:
                printRating() ;
                break ;
            case Price:
                printPrice() ;
        }
    }
    public boolean refundProduct(Product product) {
        for ( int i = 0 ; i <  shoppingCart . size() ; i ++ ) {
            if (product . getId() == shoppingCart . get( i ) . getId()  ) {
                updateWallet( product . getPrice() ) ;
                shoppingCart . remove( i ) ;
                product . getStore () . transact ( product , 1 ) ;
                return true ;
            }
        }
        return false ;
    }
    public void printPurchaseTime () {
        for ( int i = 0 ; i < shoppingCart . size() ; i ++ ) {
            System . out . println( shoppingCart . get( i ) ) ;
        }
    }
    public void printRating () {
        ArrayList < Product > fake1 = new ArrayList<>(shoppingCart) ;
        SortByRating rating = new SortByRating() ;
        Collections . sort ( fake1 , rating ) ;
        for ( int i = 0 ; i < fake1 . size() ; i ++ ) {
            System . out . println( fake1 . get( i ) ) ;
        }

    }
    public void printPrice () {
        ArrayList < Product > fake2 = new ArrayList<>(shoppingCart) ;
        SortByPrice prices  = new SortByPrice() ;
        Collections . sort ( fake2 , prices ) ;
        for ( int i = 0 ; i < fake2 . size() ; i ++ ) {
            System . out . println( fake2 . get( i ) ) ;
        }
    }
}