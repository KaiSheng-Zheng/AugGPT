import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.id = ++cnt;
        this.name = name;
        this.productList = new ArrayList<>();
        this.income = 0f;
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.id = ++cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        for (Product p : this.productList) {
            if (p.getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) return false;
        else {
            this.productList.add(product);
            product.setStore(this);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        int removeIndex = -1;
        for (int i = 0; i < this.productList.size(); i++) {
            if (this.productList.get(i).getId() == product.getId()) {
                removeIndex = i;
                break;
            }
        }
        if (removeIndex == -1) return false;
        else {
            this.productList.remove(removeIndex);
            product.setStore(null);
            return true;
        }
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
            this.income -= product.getPrice();
        }
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Store.cnt = cnt;
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
