import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = income;
        this.productList = new ArrayList<>();
        this.productList.addAll(productList);
    }

    public boolean hasProduct(Product product) {
        byte a = 0;
        for (int i = 0; i < this.productList.size(); i++) {
            if (this.productList.get(i).equals(product)) {
                a++;
                break;
            }
        }
        if (a == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addProduct(Product product) {
        byte a = 0;
        for (int i = 0; i < this.productList.size(); i++) {
            if (this.productList.get(i).getId() == product.getId()) {
                a++;
                break;
            }
        }
        if (a == 0) {
            this.productList.add(product);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeProduct(Product product) {
        byte a = 0;
        for (int i = 0; i < this.productList.size(); i++) {
            if (this.productList.get(i).getId() == product.getId()) {
                a++;
                break;
            }
        }
        if (a != 0) {
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
            if (removeProduct(product)) {
                this.income += product.getPrice();
            }
        } else if (method == 1) {
            if (addProduct(product)) {
                this.income -= product.getPrice();
            }
        }
    }
}