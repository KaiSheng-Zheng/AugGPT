import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt += 1;
        id = cnt;
        income = 0;
        this.name = name;
        productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt += 1;
        id = cnt;
        this.income = income;
        this.productList = new ArrayList<>();
        if (productList != null)
            for (Product product : productList)
                addProduct(product);
        this.name = name;
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    public boolean addProduct(Product product) {
        if (productList.contains(product)) {
            return false;
        } else {
            productList.add(product);
            product.setSellFrom(this);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (productList.contains(product)) {
            productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            if (productList.contains(product)) {
                productList.remove(product);
                income += product.getPrice();
            }

        } else {
            System.out.println(product.getSellFrom());
            if (product.getSellFrom() == this) {
                productList.add(product);
                income -= product.getPrice();
            }
        }

    }


}
