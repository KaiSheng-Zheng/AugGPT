import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        this.income = 0;
        this.productList = new ArrayList<>();
        cnt++;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product) {
        if(productList.contains(product)){
            return true;
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if(productList.contains(product)){
            return false;
        }
        else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            this.income += product.getPrice();
        } else if (method == 1) {
            addProduct(product);
            this.income -= product.getPrice();
        }
    }
}
