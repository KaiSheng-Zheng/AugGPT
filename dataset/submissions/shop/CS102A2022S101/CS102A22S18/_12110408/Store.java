import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public Store(String name) {
        this(name, new ArrayList<Product>(), 0f);
    }

    public boolean hasProduct(Product product) {
        boolean hasProduct = false;
        for (Product item : productList) {
            if (item.equals(product)) {
                hasProduct = true;
                break;
            }
        }

        return hasProduct;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product))
            return false;

        product.setSoldFrom(null);
        productList.add(product);
        return true;
    }


    public boolean removeProduct(Product product) {
        boolean deleted = false;

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).equals(product)) {
                productList.remove(i);
                deleted = true;
                break;
            }
        }

        return deleted;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        switch (method) {
            case 0:
                this.income += product.getPrice();
                product.setSoldFrom(this);
                this.removeProduct(product);
                break;

            case 1:
                this.addProduct(product);
                this.income -= product.getPrice();
        }
    }
}

