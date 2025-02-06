import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name){
        this.name = name;
        this.income = 0;
        cnt++;
        this.id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }
    public boolean hasProduct(Product product){
        for (int i = 0; i< productList.size(); i++){
            if (product.getID() == productList.get(i).getID()){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        for (int i = 0; i< productList.size(); i++){
            if (product.getID() == productList.get(i).getID()){
                return false;
            }
        }
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        for (int i = 0; i< productList.size(); i++){
            if (product.equals(productList.get(i))){
                productList.remove(product);
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
            productList.remove(product);
            this.income = this.income + product.getPrice();
        }
        if (method == 1){
            productList.add(product);
            this.income = this.income - product.getPrice();
        }
    }
}
