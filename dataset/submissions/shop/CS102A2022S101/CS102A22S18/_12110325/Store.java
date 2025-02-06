import java . util . ArrayList ;
public class Store {

    private static int cnt = 0 ; 
    private int id;  
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;


    public Store(String name) {
        this . name = name ;
        cnt ++ ;
        income = 0 ;
        id = cnt ;
    }
    public Store(String name, ArrayList<Product> productList , float income) {
        this . name = name ;
        this . income = income ;
        cnt ++ ;
        id = cnt ;
        this . productList = productList ;
    }
    public boolean hasProduct(Product product) {
        for ( int i = 0 ; i < productList . size() ; i ++ ) {
            if ( productList . get ( i ) . getId() == product . getId() ) return true ;
        }
        return false ;
    }
    public boolean addProduct(Product product) {
        if ( hasProduct ( product ) ) return false ;
        else {
            product . addStore ( this ) ;
            productList . add ( product ) ;
            return true ;
        }
    }
    public boolean removeProduct(Product product) {
        if ( hasProduct( product ) ){
            for ( int i = 0 ; i < productList . size() ; i ++ ) {
                if ( productList . get ( i ) . getId() ==  product .getId() ) {
                    productList . remove( i ) ;
                    return true ;
                }
            }
        }
        return false ;
    }
    public ArrayList<Product> getProductList() {
        return productList ;
    }
    public void transact(Product product, int method) {
        switch ( method ) {
            case  0 :
                if ( removeProduct(product) ) income += product. getPrice() ;
                break ;
            case 1 :
                if ( addProduct ( product ) ) income -= product . getPrice() ;
                break;
        }
    }

}
