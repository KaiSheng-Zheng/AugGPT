import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        this.name=name;
        income=0;
        cnt++;
        id=Integer.valueOf(cnt);
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        id=Integer.valueOf(cnt);
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)) {
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }
    public boolean hasProduct(Product product){
        if(productList.contains(product)){
            return true;
        }else {
            return false;
        }
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }else {

            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            income+=product.getPrice();
            productList.remove(product);
        }else if (method==1){
            income-=product.getPrice();
            productList.add(product);

        }
    }
}
