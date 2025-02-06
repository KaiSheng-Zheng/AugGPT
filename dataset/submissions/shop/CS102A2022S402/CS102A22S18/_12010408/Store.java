import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        ++cnt;
        this.name = name;
        this.productList = new ArrayList<Product>();
        this.income = 0;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        ++cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
        this.id = cnt;
    }

    public boolean hasProduct(Product product){
        int n = this.productList.size();
        if (n == 0) return false;
        for (Product value : this.productList) {
            if (value.getId() == product.getId()) return true;
        }
        return false;
    }

    public boolean addProduct(Product product){
        int n = this.productList.size();
        if (n == 0){
            this.productList.add(product);
            return true;
        }
        for (Product value : this.productList) if (value.getId() == product.getId()) return false;
        this.productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        int n = this.productList.size();
        if (n == 0) return false;
        for (int i = 0; i < n; i++){
            if (this.productList.get(i).getId() == product.getId()){
                this.productList.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method){
        if (method == 0){
            if (removeProduct(product)) {
                this.income += product.getPrice();
            }
        }
        if (method == 1){
            if (addProduct(product)) {
                this.income -= product.getPrice();
            }
        }
    }

    public int getId() {
        return id;
    }
}
