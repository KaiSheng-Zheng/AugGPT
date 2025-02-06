import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        this.name=name;
        cnt++;
        id=cnt;
        this.productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;

        this.productList=productList;
        this.income=income;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }else return false;
    }
    public boolean addProduct(Product product){
        if (productList.contains(product)){
            return  false;
        }else {
            productList.add(product);
            return true;
        }

    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }else return false;

    }
    public ArrayList<Product> getProductList(){
        return productList;

    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income+=product.getPrice();
        }else{
            productList.add(product);
            income-=product.getPrice();
        }

    }
}