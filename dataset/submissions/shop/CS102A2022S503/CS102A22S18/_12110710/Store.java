import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name=name;
        income=0;
        cnt++;
        id=cnt;
        productList=new ArrayList<>();

    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        id=cnt;
    }

    public boolean hasProduct(Product product){
        int cou=0;
        for(int k=0;k<productList.size();k++){
            if(product.getId()==productList.get(k).getId()){
                cou++;break;
            }
        }
        if(cou==0){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean addProduct(Product product){
        int cou=0;
        for(int k=0;k<productList.size();k++){
            if(product.getId()==productList.get(k).getId()){
                cou++;break;
            }
        }
        if(cou==0){
            productList.add(product);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean removeProduct(Product product){
        int cou=0;
        for(int k=0;k<productList.size();k++){
            if(product.getId()==productList.get(k).getId()){
                cou++;break;
            }
        }
        if(cou==0){
            return false;
        }
        else {
            productList.remove(product);
            return true;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            if(hasProduct(product)){
                removeProduct(product);
                income+= product.getPrice();
            }
        }
        else if(method==1){
            income-=product.getPrice();
            productList.add(product);
        }
    }

}
