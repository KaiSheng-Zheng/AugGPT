import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    private ArrayList<Store> storeList=new ArrayList<>();

    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.income=0;
        this.productList=new ArrayList<>();
        storeList.add(this);
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        id=cnt;
        storeList.add(this);
    }

    public boolean hasProduct(Product product){
        boolean t=false;
            if(productList.contains(product))t=true;
        return t;
    }

    public boolean addProduct(Product product){
        boolean t=true;
        if(productList.contains(product))t=false;
        if(t)productList.add(product);
        return t;
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }else return false;
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void transact(Product product, int method){
        if(method==0){
                income+=product.getPrice();
                removeProduct(product);
            }
        else{
                income-= product.getPrice();
                productList.add(product);
            }

    }
}
