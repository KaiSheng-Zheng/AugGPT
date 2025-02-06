import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float income;
    private long count = 0;

    public Store(String name) {
        this.name = name;
        this.income = 0;
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

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        boolean flag = false;
        for (int i=0;i<this.productList.size();i++) {
            if (this.productList.get(i).getId() == product.getId()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean addProduct(Product product) {
        boolean flag = false;
        if (!this.hasProduct(product)) {
            productList.add(product);
            flag = true;
        }
        this.count++;
        return flag;
    }

    public boolean removeProduct(Product product) {
        boolean flag = false;
        for (int i=0;i<this.productList.size();i++) {
            if (this.productList.get(i).getId() == product.getId()) {
                this.productList.remove(i);
                flag = true;
                break;
            }
        }
        return flag;
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            this.income += product.getPrice();
        } else if (method == 1) {
            addProduct(product);
            this.income = this.income - product.getPrice();
        }
    }
}
