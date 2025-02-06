import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            income+=product.getPrice();
        }
        if (method==1){
            addProduct(product);
            income-=product.getPrice();
        }
    }
}