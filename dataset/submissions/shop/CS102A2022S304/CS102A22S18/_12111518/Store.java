import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        cnt++;
        this.id = cnt;
        this.income = 0.0F;
        this.productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        cnt++;
        this.id = cnt;
        this.income = income;
        this.productList = productList;
    }

    public boolean hasProduct(Product product) {
        boolean out = false;
        if (productList.size() != 0) {
            for (Product value : productList) {
                if (value == product) {
                    out = true;
                    break;
                }
            }
        }
        return out;
    }

    public boolean addProduct(Product product) {
        boolean result = true;
        for (Product value : productList) {
            if (value == product) {
                result = false;
                break;
            }
        }
        if (result) {
            productList.add(product);
        }
        return result;
    }

    public boolean removeProduct(Product product) {
        boolean result = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) == product) {
                productList.remove(product);
                result = true;
                break;
            }
        }
        return result;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            productList.remove(product);
            income = income + product.getPrice();
        } else {
            productList.add(product);
            income = income - product.getPrice();
        }
    }
}
