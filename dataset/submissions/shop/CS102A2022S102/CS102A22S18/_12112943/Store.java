import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        Store.cnt++;
        this.id = cnt;
        this.income = 0;
        this.name = name;

    }

    public Store(String name, ArrayList<Product> productList, float income) {
        Store.cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product) {
        if (this.hasProduct(product)) {
            return false;
        } else {
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (this.hasProduct(product)) {
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
            if (this.removeProduct(product)) {
                this.income += product.getPrice();
            }
        }
        if (method == 1) {
                if(this.productList.add(product)){
                    this.income -= product.getPrice();
            }
        }
    }

}
