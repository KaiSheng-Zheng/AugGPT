import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList = new ArrayList<>();
        this.income = 0 ;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList =productList;
        this.income = income;
    }
    public boolean hasProduct(Product product){
        for (int i = 0;i<productList.size();i++){
            if (product.getId()==productList.get(i).getId()){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        for (int i = 0;i<productList.size();i++){
            if (product.getId()==productList.get(i).getId()){
                return false;
            }
        }
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        for (int i = 0;i<productList.size();i++){
            if (product.getId()==productList.get(i).getId()){
                productList.remove(product);
                return true;
            }
        }
        productList.add(product);
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income = income+product.getPrice();
        }else{
            productList.add(product);
            income = income-product.getPrice();
        }
    }
}