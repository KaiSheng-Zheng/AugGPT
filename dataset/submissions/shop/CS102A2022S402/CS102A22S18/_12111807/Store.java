import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public String getName() {
        return name;
    }

    public float getIncome() {
        return income;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public Store(String name){
        this.name = name;
        this.income = 0;
        this.productList = new ArrayList<>();
        cnt++;
        id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.income = income;
        this.productList = productList;
        cnt++;
        id = cnt;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        if(productList.contains(product)){
            return false;
        }
        else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }
        else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void transact(Product product, int method){
        if(method == 0){
            this.income = this.income + product.getPrice();
            removeProduct(product);
        }
        else if(method == 1){
            this.income = this.income - product.getPrice();
            addProduct(product);
        }
    }
}
