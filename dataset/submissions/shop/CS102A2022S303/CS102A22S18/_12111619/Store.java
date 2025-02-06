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
        this.income = 0;
        this.productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product) {
        if (this.productList.contains(product)) {
            return false;
        } else {
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (this.productList.contains(product)) {
            this.productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            this.productList.remove(product);
            income += product.getPrice();
        }
        if (method == 1) {
            this.productList.add(product);
            income -= product.getPrice();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}