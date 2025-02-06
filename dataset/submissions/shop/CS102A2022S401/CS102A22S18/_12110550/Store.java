import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    private ArrayList<Product>sold=new ArrayList<>();

    public Store(String name){
        Store.cnt++;
        this.id=Store.cnt;
        this.income=0;
        this.name=name;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        Store.cnt++;
        this.id=Store.cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }

    public boolean hasProduct(Product product){
        if(productList.contains(product)){
            return true;
        }else {
            return false;
        }
    }
    public boolean addProduct(Product product){
        if(!hasProduct(product)){
            this.productList.add(product);
            return true;
        }else{
            return false;
        }
    }
    public boolean removeProduct(Product product){
        if(productList.contains(product)){
            this.productList.remove(product);
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            if(this.productList.contains(product)){
                this.productList.remove(product);
                this.sold.add(product);
                this.income+=product.getPrice();
            }
        }
        if(method==1){
            if(this.sold.contains(product)  && addProduct(product)){
                this.income-=product.getPrice();
                this.sold.remove(product);
            }

        }
    }
}
