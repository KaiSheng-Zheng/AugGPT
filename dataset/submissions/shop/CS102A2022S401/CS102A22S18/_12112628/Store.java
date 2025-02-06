import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private final int id;
    private final String name;
    private final ArrayList<Product> productList;
    private float income;
    private final ArrayList<Product> historySell = new ArrayList<>();

    public Store(String name) {
        this.name = name;
        productList = new ArrayList<>();
        income = 0;
        ++cnt;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        ++cnt;
        id = cnt;
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }


    public boolean addProduct(Product product) {
        if (hasProduct(product))
            return false;
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        return productList.remove(product);
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            if (!removeProduct(product))
                return;
            income += product.getPrice();
            historySell.add(product);
        }
        else if (method == 1) {
            if (historySell.contains(product) && addProduct(product)) {
                income -= product.getPrice();
                historySell.remove(product);
            }
        }
    }
}
