import java.util.ArrayList;

public class Store {
    // initialized to 0, and will increase by 1 when the constructor is called.
    private static int cnt = 0;
    // unique for each store and the value is set to cnt.
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.id = ++cnt;
        this.name = name;
        this.productList = new ArrayList<>();
        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.id = ++cnt;
        this.name = name;
        this.productList = productList;
        for (Product product : productList) {
            product.setStore(this);
        }
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        for (Product item : productList) {
            if (item.getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        } else {
            product.setStore(this);
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.remove(i);
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
            removeProduct(product);
            income += product.getPrice();
        } else if (method == 1) {
            addProduct(product);
            income -= product.getPrice();
        }
    }
}