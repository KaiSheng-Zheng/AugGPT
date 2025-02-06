import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the
    //constructor is called .
    private final  int  id; // unique for each store and the value is set to cnt.
    private final String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public static ArrayList<Store> StoreList=new ArrayList<>();

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
        StoreList.add(this);
    }

    public Store(String name) {
        this(name, new ArrayList<>(), 0);
    }

    public boolean hasProduct(Product product) {
        if (productList.size() > 0) {
            if (this.productList.contains(product)){
                return true;
            }else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean addProduct(Product product) {
        if (!productList.contains(product)) {
            productList.add(product);
            product.StoreId=this.id;
            return true;
        } else return false;
    }



    public boolean removeProduct(Product product) {
        if (productList.contains(product)) {
            productList.remove(product);
            return true;
        } else return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getIncome() {
        return income;
    }

    public void transact(Product product, int method) {
        if (method == 0 && removeProduct(product)) {
            income += product.getPrice();
        } else if (method == 1 && addProduct(product)) {
            income -= product.getPrice();
        }
    }

}
