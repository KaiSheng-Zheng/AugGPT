import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        this.name = name;
        this.income = 0;
        this.id = cnt;
        productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name = name;
        this.income = income;
        this.id = cnt;
        this.productList = productList;
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }
        else{
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method){
        if(method == 0)
            if(this.removeProduct(product))
                this.income += product.getPrice();
        if(method == 1){
            this.addProduct(product);
            this.income -= product.getPrice();
        }
    }
}
