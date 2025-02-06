import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name){
        this.name = name;
        income = 0;
        Store.cnt++;
        this.id = Store.cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.income = income;
        this.name = name;
        this.productList = productList;
        Store.cnt++;
        this.id = Store.cnt;
    }

    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product){
        if(this.hasProduct(product))
            return false;
        else {
            this.productList.add(product);
        return true;
        }
    }

    public boolean removeProduct(Product product){
        if(!this.hasProduct(product))
            return false;
        else {
            this.productList.remove(product);
            return true;
        }
    }

    public ArrayList<Product> getProductList(){
        return  this.productList;
    }

    public void transact(Product product, int method){
        if(method == 0){
            this.income += product.getPrice();
            this.removeProduct(product);
        }
        if(method == 1){
            this.income -= product.getPrice();
            this.addProduct(product);
        }
    }
}
