import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = new ArrayList<>();
        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        boolean xoaBoThanhCong = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                xoaBoThanhCong = true;
                productList.remove(i);
                i--;
            }
        }
        return xoaBoThanhCong;
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method) {
        if (method != 1) {
            if (removeProduct(product)) {
                income += product.getPrice();
            }
        } else {
            if (addProduct(product)) {
                income -= product.getPrice();
            }
        }
    }

}
