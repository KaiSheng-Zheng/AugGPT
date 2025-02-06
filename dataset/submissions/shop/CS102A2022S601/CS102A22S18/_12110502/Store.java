import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    private static ArrayList<Store> storeList=new ArrayList<>();
    public ArrayList<Store> getStoreList() {
        return storeList;
    }
    public Store(String name){
        cnt++;
        this.name=name;this.income=0;
        this.id=cnt;storeList.add(this);
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name=name;this.productList=productList;this.income=income;
        this.id=cnt;storeList.add(this);
        for(Product a:productList){
            a.setStoreId(id);
        }
    }
    public boolean hasProduct(Product product){
         return this.productList.contains(product);
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }else{ this.productList.add(product);product.setStoreId(id);return true;}
    }
    public boolean removeProduct(Product product){
        if(!hasProduct(product)){
            return false;
        }else{ this.productList.remove(product);return true;}
    }
    public ArrayList<Product> getProductList(){
         return productList;
    }
    public void transact(Product product, int method){
       switch (method){
           case 0:removeProduct(product);this.income+=product.getPrice();break;
           case 1:addProduct(product);this.income-=product.getPrice();break;
       }
    }


    public static Store getStoreById (int id){
         return storeList.get(id-1);
    }


    public static Store getStore (Product product){
        return getStoreById(product.getStoreId());
    }
}
