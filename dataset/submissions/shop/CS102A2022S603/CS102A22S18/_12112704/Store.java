import java.util.ArrayList;

public class Store {

    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.

    private int id; // unique for each store and the value is set to cnt.
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
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        for (Product p : this.productList) {
            if (p == product) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        }
        this.productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        if (!hasProduct(product)) {
            return false;
        }
        this.productList.remove(product);
//        for (int i = 0; i < this.productList.size(); i++) {
//            if (this.productList.get(i).getId() == product.getId()) {
//                this.productList.get(i).setProductStore(null);
//                this.productList.remove(i);
//            }
//        }
        return true;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
//            product.setProductStore(this);
            removeProduct(product);
            income += product.getPrice();
        } else if (method == 1) {
            addProduct(product);
            income -= product.getPrice();
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}
