
import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id = 1;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income = 0;

    public Store(String name) {
        this.name = name;
        cnt++;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product) {
        boolean valid = false;
        for (int i = 0; i < productList.size(); i++) {
            if (!product.equals(productList.get(i))) {
                valid = false;
            } else {
                valid = true;
                break;
            }
        }
        return valid;
    }

    public boolean addProduct(Product product) {
        boolean valid = false;
        for (int i = 0; i < productList.size(); i++) {
            if (!product.equals(productList.get(i))) {
                valid = false;
            } else {
                valid = true;
                break;
            }
        }
        if (!valid) {
            productList.add(product);
        }
        return !valid;
    }

    public boolean removeProduct(Product product) {
        boolean valid = false;
        for (int i = 0; i < productList.size(); i++) {
            if (!product.equals(productList.get(i))) {
                valid = false;
            } else {
                valid = true;
                break;
            }
        }
        if (valid) {
            productList.remove(product);
        }
        return valid;
    }


    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            productList.remove(product);
            income += product.getPrice();
        } else if (method == 1) {
            productList.add(product);
            income -= product.getPrice();
        }
    }

}
