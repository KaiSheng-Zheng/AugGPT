import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        cnt++;
        this.id = cnt;
        this.productList = new ArrayList<>();
        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product) {
        if (productList.size() != 0) {
            for (Product value : productList) {
                if (product.getName().equals(value.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        for (Product value : productList) {
            if (product.getName().equals(value.getName())) {
                return false;
            }
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        for (Product value : productList) {
            if (product.getName().equals(value.getName())) {
                productList.remove(product);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            if (removeProduct(product)) {
                income += product.getPrice();
            }
        }
        if (method == 1) {
            if (addProduct(product)) {
                income -= product.getPrice();
            }
        }
    }
}
