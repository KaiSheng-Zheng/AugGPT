import java.util.ArrayList;


public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float income;

    public Store(String name) {
        cnt += 1;
        id = cnt;
        this.name = name;
        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt += 1;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        for (Product product1 : productList) {
            if (product1.getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (productList.size() != 0) {
            for (Product product1 : productList) {
                if (product1.getId() == product.getId()) {
                    return false;
                }
            }
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        for (Product product1 : productList) {
            if (product1.getId() == product.getId()) {
                productList.remove(product);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            income += product.getPrice();
            removeProduct(product);
        } else if (method == 1) {
            income -= product.getPrice();
            addProduct(product);
        }
    }
}
