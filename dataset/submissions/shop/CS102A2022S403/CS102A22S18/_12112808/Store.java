import java.util.ArrayList;

public class Store {private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name) {
        id=++cnt;
        this.name=name;
        income=0;
        productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        id=++cnt;
        this.name=name;
        this.income=income;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        for(int i=0;i<productList.size();i++){}
        return true;
    }
    public boolean addProduct(Product product){return true;}
    public boolean removeProduct(Product product){return true;}
    public ArrayList<Product> getProductList(){return null;}
    public void transact(Product product, int method){}
}