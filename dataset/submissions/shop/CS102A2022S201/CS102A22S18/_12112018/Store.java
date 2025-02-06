import java.util.ArrayList;
public class Store{
    private static int cnt = 1 ;
    private int id ;
    private String name ;
    private ArrayList<Product> productList ;
    private ArrayList<Product> storeList ;
    private float income ;
    public Store(String name){
        this.id = cnt ; cnt++ ;
        this.name = name ;
        this.income = 0 ;
        this.productList = new ArrayList<>(0) ; }
    public Store(String name, ArrayList<Product> productList, float income){
        this.id = cnt ;
        cnt++ ;
        this.name = name ;
        this.income = income ;
        this.productList = productList ; }
    public boolean hasProduct(Product product){
        int a = 0 ;
        for( int i = 0 ; i < productList.size() ; i++ ){
            if( product == productList.get(i) ){ a = 1 ; } }
        if( a == 1 ){ return true ; }
        else { return false ; } }
    public boolean addProduct(Product product){
        if( hasProduct(product) ){ return false ; }
        else { productList.add(product) ; return true ; } }
    public boolean removeProduct(Product product){
        if( !hasProduct(product) ){ return false ; }
        else{ productList.remove( product ) ; return true ; } }
    public void setIncome( float income ){
        this.income = income ; }
    public float getIncome(){
        return income ; }
    public ArrayList<Product> getProductList(){
        return productList ; }
    public void transact(Product product, int method){
        if( method == 0 ){
            productList.remove(product) ;
            this.income = income + product.getPrice() ; }
        if( method == 1 ){
            productList.add(product) ;
            this.income = income - product.getPrice() ; } } }
