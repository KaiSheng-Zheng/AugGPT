import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    private HashMap<Integer,Boolean> map;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        income = 0;
        productList = new ArrayList<>();
        map = new HashMap<Integer,Boolean>();
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
        map = new HashMap<Integer,Boolean>();
        for (int i = 0; i < productList.size(); i++) {
            map.put(productList.get(i).getId(),true);
        }
    }
    public boolean hasProduct(Product product){
        if (map.containsKey(product.getId())){
            return true;
        }else return false;
    }
    public boolean addProduct(Product product) {
        if (hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            map.put(product.getId(),true);
            return true;
        }
    }
    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            productList.remove(productList.indexOf(product));
            map.remove(product.getId());
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method) {
        if (method == 0){
            productList.remove(productList.indexOf(product));
            map.remove(product.getId());
            income += product.getPrice();
        }
        if (method == 1){
            productList.add(product);
            map.put(product.getId(),true);
            income -= product.getPrice();
        }

    }
}
