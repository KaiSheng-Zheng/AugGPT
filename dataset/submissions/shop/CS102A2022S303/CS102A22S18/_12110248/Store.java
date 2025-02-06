import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    ///////new store
    public Store(String name) {
        Store.cnt++;
        this.id = Store.cnt;
        this.name = name;
        this.income = 0;
    }

    ///////existing store
    public Store(String name, ArrayList<Product> productList, float income) {
        Store.cnt++;
        this.id = Store.cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    ///////
    public boolean hasProduct(Product product) {
        if (this.productList.contains(product)) {
            return true;
        } else {
            return false;
        }
    }

    ///////
    public boolean addProduct(Product product) {
        if (!hasProduct(product)) {
            this.productList.add(product);
            return true;
        } else {
            return false;
        }
    }

    ///////
    public boolean removeProduct(Product product) {
        if (this.productList.remove(product)) {
            return true;
        } else {
            return false;
        }
    }

    ///////
    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    ///////
    private ArrayList<Product> sold = new ArrayList<>();

    public void transact(Product product, int method) {
        switch (method) {
            case 0: {
                if (removeProduct(product)) {
                    this.income += product.getPrice();
                    this.sold.add(product);
                }
                break;
            }
            case 1: {
                if (this.sold.contains(product) && addProduct(product)) {
                    this.income -= product.getPrice();
                    this.sold.remove(product);
                }
                break;
            }
        }
    }
}
