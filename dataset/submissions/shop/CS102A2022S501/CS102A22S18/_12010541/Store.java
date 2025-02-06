import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;    // ?????????????????????????????????????
        id = cnt;
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public void updateIncome(float amount) {
        income += amount;
    }

    public boolean hasProduct(Product product) {
//        if (isContain(product, this)) {
        if (productList.contains(product)) {
            return true;
        }else {
            return false;
        }
     }

    public boolean addProduct(Product product) {
//        if (isContain(product, this)) {
        if (productList.contains(product)) {
            return false;
        }else {
            productList.add(product);
            product.store = this;
            return true;
        }
    }

    public boolean removeProduct(Product product) {
//        if (isContain(product, this)) {
        if (productList.contains(product)) {
            productList.remove(product);
//            product.store = null;
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            income += product.getPrice();
            removeProduct(product);    // ??????????????????????
        }else if (method == 1) {
            income -= product.getPrice();
            addProduct(product);
        }
    }

    public boolean isContain(Product product, Store store) {
        if (store.productList == null) {
            return false;
        }
        for (int i = 0; i < store.productList.size(); i++) {
            if (store.productList.get(i).getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }
}
