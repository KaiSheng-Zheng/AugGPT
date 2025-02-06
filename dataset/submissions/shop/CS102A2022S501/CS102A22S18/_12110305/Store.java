import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList ;
    private float income;
    private HashMap<Product,Boolean> productHashMap;

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public Store(String name){
        income = 0;
        ++cnt;
        id = cnt;
        this.name = name;
        productList = new ArrayList<>();
        productHashMap=new HashMap<>();
    }

    public Store(String name, ArrayList<Product> productList, float income){
        id = ++cnt ;
        this.name = name;
        this.productList = productList;
        this.income = income;
        productHashMap=new HashMap<>();
        for (Product product : productList) {
            productHashMap.put(product, true);
        }
    }

    public boolean hasProduct(Product product) {
        return productHashMap.containsKey(product);
    }

    public boolean addProduct(Product product) {
        if(hasProduct(product)){
            return false;
        }else
        productHashMap.put(product,true);
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        if(hasProduct(product)){
            productHashMap.remove(product);
            productList.remove(product);
            return true;
        }
        return false;
    }

    public void transact(Product product, int method){
        if(method==0){
            if(removeProduct(product)){
                income += product.getPrice();
            }
        }
        else {
            if(addProduct(product)){
                income -= product.getPrice();
            }
        }
    }
}