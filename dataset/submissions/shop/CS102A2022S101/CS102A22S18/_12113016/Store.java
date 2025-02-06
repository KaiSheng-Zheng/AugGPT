import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public void setIncome(float income) {
        this.income = income;
    }


    public Store(String name) {
        this.name = name;
        cnt++;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;

        for (Product product : productList) {
           product.setBelongStore(this);
        }
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    public boolean addProduct(Product product) {
        if (!hasProduct(product)) {
            productList.add(product);
            product.setBelongStore(this);
            return true;
        }
        return false;
    }

    public boolean removeProduct(Product product) {
        if (productList.contains(product)) {
            productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            productList.remove(product);
            setIncome(income += product.getPrice());
        }
        if (method == 1) {
            productList.add(product);
            setIncome(income -= product.getPrice());
        }

    }

}
