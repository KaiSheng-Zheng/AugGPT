import java.util.ArrayList;
public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

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
    }

    public void setIncome(float price, int method) {
        if (method == 0) {
            this.income += price;
        } else if (method == 1) {
            this.income -= price;
        }
    }

    public boolean hasProduct(Product product) {
        boolean flag = false;
        for (int i = 0; i < getProductList().size(); i++) {
            if (product.getId() == getProductList().get(i).getId()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean addProduct(Product product) {
        boolean flag = true;
        for (int i = 0; i < getProductList().size(); i++) {
            if (product.getId() == getProductList().get(i).getId()) {
                flag = false;
                break;
            }
        }
        if (flag) {
            getProductList().add(product);
            return flag;
        } else {
            return flag;
        }
    }

    public boolean removeProduct(Product product) {
        boolean flag = false;
        for (int i = 0; i < getProductList().size(); i++) {
            if (product.getId() == getProductList().get(i).getId()) {
                flag = true;
                break;
            }
        }
        if (flag) {
            getProductList().remove(product);
            return flag;
        } else {
            return flag;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            setIncome(product.getPrice(), method);
        } else if (method == 1) {
            addProduct(product);
            setIncome(product.getPrice(), method);
        }
    }
}
