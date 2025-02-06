import java.util.ArrayList;

public class Store{
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name){
        Store.cnt = Store.cnt + 1;
        this.id = Store.cnt;
        this.name = name;
        this.income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        Store.cnt = Store.cnt + 1;
        this.id = Store.cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }
    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product){
        return !hasProduct(product) && this.productList.add(product);
    }
    public boolean removeProduct(Product product){
        return this.productList.remove(product);
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    private ArrayList<Product> sell = new ArrayList<>();
    public void transact(Product product, int method){
        if(method == 0){
            if(removeProduct(product)){
                this.income = this.income + product.getPrice();
                this.sell.add(product);
            }
        }if(method == 1){
            if (addProduct(product)&& this.sell.contains(product)){
                this.income = this.income - product.getPrice();
                this.sell.remove(product);
            }
        }
    }
}