
import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name) {
        this.name = name;
        ++cnt;
        id = cnt;
        productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        ++cnt;
        id = cnt;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        return productList.remove(product);
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method){
        switch (method){
            case 0:
                removeProduct(product);
                income += product.getPrice();
                break;
            case 1:
                income -= product.getPrice();
                addProduct(product);
                break;
        }
    }
}
