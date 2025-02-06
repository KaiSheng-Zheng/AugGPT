import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        this.name=name;
        income=0;
        cnt++;
        id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        if (getProductList().contains(product)){
            return true;}
        else {
            return false;}}

    public boolean addProduct(Product product){
        if (getProductList().contains(product)){
            return false;}
        else {
            getProductList().add(product);
            return true;}}

    public boolean removeProduct(Product product){
        if (getProductList().contains(product)){
            getProductList().remove(product);
            return true;}
        else {
            return false;}}

    public ArrayList<Product> getProductList(){
        return productList;}

    public void transact(Product product, int method){
        if (method==1){
            income-=product.getPrice();
            getProductList().add(product);}
        if (method==0){
            income+=product.getPrice();
            getProductList().remove(product);
        }
    }

    public float getIncome(){
        return income;
    }
}
