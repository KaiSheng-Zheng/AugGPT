import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public int getId(){
        return id;
    }
    public Store(String name){
        this.name=name;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product){
        if (productList.size()==0){
            return false;
        }
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getId()==product.getId()){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product) {
        if (productList.size() == 0) {
            productList.add(product);
            return true;
        }
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                return false;
            }
        }
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        if (productList.size() == 0) {
            return false;
        }
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.remove(i);
                return true;
            }
        }
        return false;

    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            income+=product.getPrice();
        }
        if (method==1){
            addProduct(product);
            income-=product.getPrice();
        }
    }


}
