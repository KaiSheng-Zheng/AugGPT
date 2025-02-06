import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.id = ++cnt;
        this.name = name;
        this.productList = new ArrayList<>();
        this.income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.id = ++cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product) {
        if (this.hasProduct(product)) return false;

        return this.productList.add(product);
    }
    public boolean removeProduct(Product product) {
        return this.productList.remove(product);
    }
    public ArrayList<Product> getProductList() {
        return this.productList;
    }
    public void transact(Product product, int method) {
        if(method==0) {
            if(this.removeProduct(product))
                income += product.getPrice();
        }

        if(method==1) {
            if(this.addProduct(product)) {
                income -= product.getPrice();
            }
        }
    }
}
