import java.util.ArrayList;
public class Store {
    private static int cnt=0;
    // initialized to 0, and will increase by 1 when the constructor is called.
private int id;
// unique for each store and the value is set to cnt.
private String name;
private ArrayList<Product> productList = new ArrayList<>();
private float income;

public Store(String name){
        Store.cnt++;
        this.id=Store.cnt;
        this.name=name;
        this.income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        Store.cnt++;
        this.id=Store.cnt;
        this.name=name;
        this.income=income;
this.productList=productList;
    }

    public boolean hasProduct(Product product){
        if(this.productList.contains(product)){
            return true;
        }else return false;
    }

    public boolean addProduct(Product product){
        boolean has = this.productList.contains(product);
        return !has && this.productList.add(product);
    }

    public boolean removeProduct(Product product){
        Boolean newProductList = this.productList.remove(product);
        return newProductList;
    }

    public ArrayList<Product> getProductList(){
return productList;
    }

    public void transact(Product product, int method){
        if(method==0 && this.productList.remove(product)){
income=income+product.getPrice();
        }
    }
}
//wrong productlist
//wrong purchase