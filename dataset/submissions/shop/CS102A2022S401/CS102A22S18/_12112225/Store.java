import java.util.ArrayList;

public class Store {
    private static int cnt = 1; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name = name;
        this.income = 0;
        productList = new ArrayList<>();
        this.id = cnt;
        cnt ++;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        this.id = cnt;
        cnt++;
    }

    public boolean hasProduct(Product product){
        if (productList.size() == 0) return false;
        else {
            for (int i = 0; i < productList.size(); i++) {
                if (product.equals(productList.get(i))){
                    return true;
                }
            }
            return false;
        }
    }
    public boolean addProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (product.equals(productList.get(i)))
                return false;
        }
        productList.add(product);
        product.setStore(this);
        return true;
    }
    public boolean removeProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (product.equals(productList.get(i))) {
                productList.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method == 0){
            removeProduct(product);
            income += product.getPrice();
        } else {
            productList.add(product);
            income -= product.getPrice();
        }
    }
}
