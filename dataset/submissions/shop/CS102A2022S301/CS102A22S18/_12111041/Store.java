import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<Product>();
    private float income;

    public Store(String name){cnt++;this.id=cnt;this.name=name;}
    public Store(String name, ArrayList<Product> productlist, float income){cnt++;this.id=cnt;this.name=name;productList=productlist;this.income=income;}

    public boolean hasProduct(Product product){
        if(productList.contains(product)){return true;}
        else return false;
    }
    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }
        else return false;
    }
    public ArrayList<Product> getProductList(){return productList;}
    public void transact(Product product,int method){
        if(method==0){
            if(removeProduct(product)){
                this.income+=product.getPrice();
            }
        }
        if(method==1){
            if(addProduct(product)){
                this.income-= product.getPrice();
            }
        }
    }
}
