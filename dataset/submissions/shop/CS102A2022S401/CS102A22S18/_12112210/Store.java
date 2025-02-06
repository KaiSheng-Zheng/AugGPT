import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float income;

    public static ArrayList<Store> storeNamess = new ArrayList<Store>();{
        //storeNamess.add(new Store(""));
    }
    public Store(String name) {
        cnt++;
        id = cnt;
        this.name = name;

        storeNamess.add(this);
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        id = cnt;
        this.name = name;
        this.income = income;
        for (Product pro : productList) {
            addProduct(pro);
        }

        storeNamess.add(this);
    }

    public boolean hasProduct(Product product) {
        if(productList.size() == 0){
            return false;
        }
        for (Product pro : productList) {
            if (pro.getId() == product.getId())                  //??compare id?
                return true;
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        }
        productList.add(product);
        product.setStoreId(this.id);
        return true;

    }

    public boolean removeProduct(Product product) {
        if (!hasProduct(product)) {
            return false;
        }
        productList.remove(product);
        return true;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method){
        if(method == 0 ){
            removeProduct(product);
            income += product.getPrice();
        }
        if(method == 1){
            addProduct(product);
            income -= product.getPrice();
        }
    }
}
