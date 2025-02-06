import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;


    //constructor
    public Store(String name){
        this.name=name;
        cnt++;
        this.id=cnt;
        this.income=0;
        this.productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.income=income;
        this.productList=productList;
        cnt++;
        this.id=cnt;
    }


    //methods
    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product){
        if(this.productList.contains(product)){
            return false;
        }
        else{
            this.productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            this.productList.remove(product);
            return true;
        }
        else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            this.removeProduct(product);
            this.income+=product.getPrice();
        }
        if(method==1){
            addProduct(product);
            this.income-=product.getPrice();
        }
    }
}

