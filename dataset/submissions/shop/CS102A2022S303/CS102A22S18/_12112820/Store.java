import java.util.*;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private HashMap<Integer,Boolean> productHashMap;
    private float income;
    public Store(String name){
        id=++cnt;
        this.name=name;
        income=0;
        productList=new ArrayList<>();
        productHashMap=new HashMap<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        id=++cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
        productHashMap=new HashMap<>();
        for(int i=0;i<productList.size();i++){
            productHashMap.put(productList.get(i).getID(),true);
        }
    }
    public boolean hasProduct(Product product){
        return productHashMap.containsKey(product.getID());
    }
    public boolean addProduct(Product product){
        if(productHashMap.containsKey(product.getID())){
            return false;
        }
        productHashMap.put(product.getID(),true);
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        if(productHashMap.containsKey(product.getID())){
            productHashMap.remove(product.getID());
            productList.remove(productList.indexOf(product));
            return true;
        }
        return false;
    }   
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            if(removeProduct(product)){
                income+=product.getPrice();
            }
        }
        else{
            if(addProduct(product)){
                income-=product.getPrice();
            }
        }
    }
}
