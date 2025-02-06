import java.util.ArrayList;

public class Store {

    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = 0;
        this.productList = new ArrayList<Product>(){};
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).setStore(this);
        }
    }


    public boolean hasProduct(Product product) {
        if (productList.contains(product)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addProduct(Product product) {
        boolean AddContain;
        if (!hasProduct(product)) {
            productList.add(product);
            AddContain = true;
        } else {
            AddContain = false;
        }
        return AddContain;
    }

    public boolean removeProduct(Product product) {
        boolean ReContain;
        if (!hasProduct(product)) {
            ReContain = false;
        } else {
            productList.remove(product);
            ReContain = true;
        }
        return ReContain;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            productList.remove(product);
            income += product.getPrice();
        } else if (method == 1) {
            if (!hasProduct(product)) {
                income -= product.getPrice();
                addProduct(product);
            }
        }
    }
}
