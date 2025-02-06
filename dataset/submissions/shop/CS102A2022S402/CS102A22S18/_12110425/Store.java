import java.util.ArrayList;


public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt = cnt + 1;
        this.name = name;
        this.income = 0;
        this.id = cnt;
        productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt = cnt + 1;
        this.id = cnt;
        this.name = name;
        this.income = income;
        this.productList = productList;
    }

    public boolean hasProduct(Product product) {
        int i = 0;
        for (Product e : this.productList) {
            if (e.getId()==product.getId()) {
                i = 1;
                break;
            }
        }
        return i==1;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        } else {
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            productList.remove(product);
            return true;
        } else return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            this.productList.remove(product);
            income = income + product.getPrice();
        }
        if (method == 1&&!hasProduct(product)){
            this.addProduct(product);
            System.out.println(income);
            income = income - product.getPrice();
            System.out.println(income);
        }
    }
}
