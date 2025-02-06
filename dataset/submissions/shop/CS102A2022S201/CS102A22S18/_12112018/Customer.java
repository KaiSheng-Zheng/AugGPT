import java.util.ArrayList;
import java.util.Collections;

public class Customer{
    private static int cnt = 1 ;
    private int id ;
    private String name ;
    private ArrayList<Product> shoppingCart ;
    private float wallet ;
    public Customer(String name, float wallet){
        this.name = name ;
        this.wallet = wallet ;
        this.id = cnt ; cnt++ ;
        this.shoppingCart = new ArrayList<>(0) ; }
    public boolean rateProduct(Product product, int rating){
        if( product.setRating(rating) ){ return true ; }
        else{ return false ; } }
    public void updateWallet(float amount){
        this.wallet = wallet + amount ; }
    public boolean purchaseProduct(Store store, Product product){
        if( store.hasProduct(product) && wallet >= product.getPrice() ){
            this.wallet -= product.getPrice() ;
            this.shoppingCart.add(product) ;
            store.transact(product , 0) ;
            return true ;  }
        else{ return false ; } }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCart = this.shoppingCart ;
        if( sortMethod == SortBy.PurchaseTime ) {
            for (int i = 0; i < shoppingCart.size() ; i++) {
                for (int j = 0; j < shoppingCart.size() - i; j++) {
                    if (shoppingCart.indexOf(shoppingCart.get(j)) > shoppingCart.indexOf(shoppingCart.get(j + 1) ) ) {
                        Collections.swap(shoppingCart,j,j+1 ); } } }
            for( int t = 0 ; t < shoppingCart.size() ; t++ ){
                System.out.println(shoppingCart.get(t).toString() ) ;}
            this.shoppingCart = shoppingCart ; }
        if( sortMethod == SortBy.Price ){
            for (int i = 0; i < shoppingCart.size() ; i++) {
                for (int j = 0; j < shoppingCart.size() - i; j++) {
                    if ( shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice() ) {
                        Collections.swap(shoppingCart,j,j+1 ); }
                    if( shoppingCart.get(j).getPrice() == shoppingCart.get(j + 1).getPrice() ){
                        if( shoppingCart.indexOf(shoppingCart.get(j)) > shoppingCart.indexOf(shoppingCart.get(j + 1)) ){
                            Collections.swap(shoppingCart,j,j+1) ; } } }
                for( int t = 0 ; t < shoppingCart.size() ; t++ ){
                    System.out.println(shoppingCart.get(t).toString() ) ;}
            
            }
            this.shoppingCart = shoppingCart ; }
        if( sortMethod == SortBy.Rating ){
            for (int i = 0; i < shoppingCart.size() ; i++) {
                for (int j = 0; j < shoppingCart.size() - i; j++) {
                    if ( shoppingCart.get(j).getAvgRating() > shoppingCart.get(j + 1).getAvgRating() ) {
                        Collections.swap(shoppingCart,j,j+1 ); }
                    if( shoppingCart.get(j).getAvgRating() == shoppingCart.get(j + 1).getAvgRating() ){
                        if( shoppingCart.indexOf(shoppingCart.get(j)) > shoppingCart.indexOf(shoppingCart.get(j + 1)) ){
                            Collections.swap(shoppingCart,j,j+1) ; } } }
                for( int t = 0 ; t < shoppingCart.size() ; t++ ){
                    System.out.println(shoppingCart.get(t).toString() ) ;}
            
            }
            this.shoppingCart = shoppingCart ; }
        }
    public boolean refundProduct(Product product){
        Store store = new Store(product.getName()) ;
        if( shoppingCart.contains(product) ){
            shoppingCart.remove(product) ; wallet = wallet + product.getPrice() ;
            store.transact( product ,1) ;
            return true ; }
        else { return false ; } } }