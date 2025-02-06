import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
        id = ++cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        for(Product aProduct : productList) {
            aProduct.setBelongStore(this);
            this.productList.add(aProduct);
        }
        this.income = income;
        id = ++cnt;
    }

    public boolean hasProduct(Product product) {
        for(Product aProduct : productList) {
            if(aProduct.equals(product)) return true;
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if(hasProduct(product)) return false;

        product.setBelongStore(this);
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
        switch (method) {
            case 0: income += product.getPrice(); removeProduct(product); break;
            case 1: income -= product.getPrice(); addProduct(product); break;
            default: break;
        }
    }
}
