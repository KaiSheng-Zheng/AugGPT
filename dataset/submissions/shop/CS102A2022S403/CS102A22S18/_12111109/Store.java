import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float income;

    public Store(String name) {
        this.name = name;
        cnt++;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name=name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product) {
        boolean f = false;
        for (int i = 0; i < this.productList.size(); i++) {
            if (this.productList.get(i) == product) f = true;
        }
        return f;
    }

    public boolean addProduct(Product product) {
        boolean f = true;
        for (int i = 0; i < this.productList.size(); i++) {
            if (productList.get(i) == product) f = false;
        }
        if (f == true) {
            productList.add(product);
            return f;
        } else return f;
    }

    public boolean removeProduct(Product product) {
        boolean f = false;
        for (int i = 0; i < this.productList.size(); i++) {
            if (productList.get(i) == product) {
                f = true;
                productList.remove(i);
                break;
            }
        }
        return f;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i) == product) {
                    income += product.getPrice();
                    productList.remove(i);
                    break;
                }
            }
        } else {
            productList.add(product);
            income -= product.getPrice();
        }
    }
}
