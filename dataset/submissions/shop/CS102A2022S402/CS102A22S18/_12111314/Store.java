import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income = 0;

    public Store(String name) {
        cnt++;
        id = cnt;
        this.name = name;
        income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    public boolean addProduct(Product product) {
        if (productList.contains(product)) return false;
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        if (productList.contains(product)) {
            productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        switch (method) {
            case 0:
                if (this.removeProduct(product)) income += product.getPrice();
                break;
            case 1:
                if (this.addProduct(product)) this.income -= product.getPrice();
                break;
        }
    }
}
