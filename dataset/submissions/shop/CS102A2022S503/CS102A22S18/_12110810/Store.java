import java.util.*;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private HashMap<Integer,Boolean> productHashMap;
    private float income;
    public Store(String name){
        id=cnt++;
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
    public static boolean trick1(boolean right){
        if(right){
            return trick(true);
        }
        return true;
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
    public static boolean trick2(boolean right){
        if(right){
            return trick(true);
        }
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
    public static boolean trick(boolean right){
        if(right){
            return false;
        }
        return true;
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

