import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float income = 0;
    public void setIncome(float harga){
        income+= harga;
    }
    public Store(String name) {
        id = ++cnt;
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        id = ++cnt;
        this.name = name;
        this.productList.addAll(productList);
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        for (Product val : productList) {
            if (val.getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }


    public boolean addProduct(Product product) {
        if (!hasProduct(product)) {
            productList.add(product);
            return true;
        }
        return false;
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {

        if (method == 0 && hasProduct(product)) {
            this.income += product.getPrice();
            removeProduct(product);
        } else if (method == 1 && !hasProduct(product)) {
            this.income -= product.getPrice();
            addProduct(product);
        }
    }
}
