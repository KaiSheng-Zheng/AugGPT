import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.income = 0;
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public void updateIncome(float income) {
        this.income += income;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public boolean hasProduct(Product product) {
        boolean hasPro = false;
        for (Product product1 : getProductList()) {
            if (product.getId() == product1.getId()) {
                hasPro = true;
                break;
            }
        }
        return hasPro;
    }

    public boolean addProduct(Product product) {
        boolean CanAdd = !hasProduct(product);
        if (CanAdd) this.productList.add(product);
        return CanAdd;
    }

    public boolean removeProduct(Product product) {
        boolean ProductExist = hasProduct(product);
        if (ProductExist) productList.remove(product);
        return ProductExist;
    }

    public void transact(Product product, int method) {
        switch (method) {
            case 0 :
                if (!hasProduct(product)) break;
                updateIncome(product.getPrice());
                removeProduct(product);
                break;
            case 1 :
                if (hasProduct(product)) break;
                addProduct(product);
                updateIncome(-1*product.getPrice());
                break;
            default :
                break;
        }
    }

    public int getId() {
        return id;
    }
}