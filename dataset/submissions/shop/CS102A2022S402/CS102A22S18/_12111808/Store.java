import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income=0;
    public Store(String name){
        this.name=name;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product){

        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        if(hasProduct(product))return false;
        else productList.add(product);
        //product.setStoreId(id);
        return true;
    }

    public float getIncome() {
        return income;
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product))productList.remove(product);
        else return false;
        return true;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            productList.remove(product);
            removeProduct(product);
            income+= product.getPrice();
        }
        else{
            addProduct(product);
            income-= product.getPrice();
        }
    }
}
