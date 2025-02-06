import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        if (productList.contains(product)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addProduct(Product product) {
        boolean contain = productList.contains(product);
        if (contain) {
            return false;
        } else {
            productList.add(product);
            return true;
        }

    }

    public boolean removeProduct(Product product) {
        boolean exist = productList.contains(product);
        if (exist) {
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
            removeProduct(product);
            income += product.getPrice();
        }

        if (method == 1) {
            addProduct(product);
            income -= product.getPrice();
        }
    }
}
