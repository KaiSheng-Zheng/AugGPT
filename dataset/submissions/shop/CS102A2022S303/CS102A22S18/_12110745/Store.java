import java.util.ArrayList;

public class Store {

    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        this.name = name;
        id = cnt;
        productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name = name;
        this.income = income;
        this.productList = productList;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }else{
            return false;
        }
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else{
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method == 0){
            removeProduct(product);
            income += product.getPrice();
        }else if (method == 1){
            addProduct(product);
            income -= product.getPrice();
        }
    }

    public String getName() {
        return name;
    }
}
