import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
        this.id = cnt + 1;
        this.income = 0;
        cnt++;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        this.id = cnt + 1;
        cnt++;
    }

    public boolean hasProduct(Product product) {
        if (this.productList.contains(product))
            return true;
        else
            return false;
    }

    public boolean addProduct(Product product) {
        if (this.productList.contains(product))
            return false;
        else
            this.productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        if (this.productList.contains(product)) {
            this.productList.remove(product);
            return true;
        } else
            return false;
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }


    public void transact(Product product, int method) {
        if (method == 0) {
            this.productList.remove(product);
            this.income += product.getPrice();
        }
        if (method == 1) {
            this.productList.add(product);
            this.income -= product.getPrice();
        }
    }


}