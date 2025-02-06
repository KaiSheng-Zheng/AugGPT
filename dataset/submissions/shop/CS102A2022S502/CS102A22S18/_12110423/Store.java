import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;


    public Store(String name) {
        Store.cnt++;
        this.id = Store.cnt;
        this.name = name;
        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        Store.cnt++;
        this.id = Store.cnt;
        this.name = name;
        this.productList = productList;
        this.income = 0;
    }

    public boolean hasProduct(Product product) {
        if (this.productList.contains(product)){
            return true;
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (!this.productList.contains(product)){
            this.productList.add(product);
            return true;
        }
        return false;
    }

    public boolean removeProduct(Product product) {
        if (this.productList.contains(product)){
            this.productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0){
            this.productList.remove(product);
            this.income += product.getPrice();
        }else if (method == 1){
            this.productList.add(product);
            this.income -= product.getPrice();
        }
    }
}
