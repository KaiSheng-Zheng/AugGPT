import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        cnt+=1;
        id=cnt;
        this.name=name;
        this.income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt+=1;
        id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }

    public int getId() {
        return id;
    }

    public boolean hasProduct(Product product){
        for (Product v:productList){
            if (v==product){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }
        else {
            productList.add(product);
            product.setStoreId(id);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (!hasProduct(product)){
            return false;
        }
        else {
            productList.remove(product);
            return true;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            product.setStoreId(id);
            productList.remove(product);
            this.income += product.getPrice();
        }
        if (method==1){
            productList.add(product);
            this.income -= product.getPrice();
        }
    }
}