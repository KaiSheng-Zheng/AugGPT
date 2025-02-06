import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        this.name=name;
        cnt++;
        this.id=cnt;
        this.income=0;
        this.productList=new ArrayList<Product>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        this.id=cnt;
    }
    public boolean hasProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i)==product){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if (this.hasProduct(product)){
            return false;
        }else {
            this.productList.add(product);
            return true;
        }

    }
    public boolean removeProduct(Product product){
        if (this.hasProduct(product)){
            productList.remove(product);
            return true;
        }else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;

    }
    public void transact(Product product, int method){
        if (method==0){
            this.income+=product.getPrice();
            this.removeProduct(product);
        }else {
            this.income-=product.getPrice();
            this.addProduct(product);
        }
    }

}
