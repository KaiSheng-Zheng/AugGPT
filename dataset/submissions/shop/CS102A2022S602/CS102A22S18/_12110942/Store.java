import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name)
    {
        productList=new ArrayList<>();
        id=++cnt;
        this.name=name;
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        id=++cnt;
        this.name=name;
        this.income=income;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        int size=productList.size();
        for(int i=0;i<size;i++) {
//            if(product.equals(productList.get(i))) return true;
            if(product.getId()==productList.get(i).getId()) return true;
        }
        return false;
    }
    public boolean addProduct(Product product) {
        if(hasProduct(product)) return false;
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product) {
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method) {
        if(method==0){
            productList.remove(product);
            income+=product.getPrice();
        }
        if(method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }
}
