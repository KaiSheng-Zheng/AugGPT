import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
        income=0;}
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.income=income;
        this.name=name;
        this.productList=productList;
        for (int i=0;i<productList.size();i++){
            productList.get(i).setStore(id);
        }
    }
    public boolean addProduct(Product product){
        boolean result=true;
        for (int i=0;i<productList.size();i++){
            if (product.getId()==productList.get(i).getId()){
                result=false;
            }
        }
        if (result){
            productList.add(product);
        }
        product.setStore(id);
        return result;
    }
    public boolean hasProduct(Product product){
        boolean result=false;
        for (int i=0;i<productList.size();i++){
            if (product.getId()==productList.get(i).getId()){
                result=true;
            }
        }return result;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public boolean removeProduct(Product product){
        boolean result=false;
        for (int i=0;i<productList.size();i++){
            if (product.getId()==productList.get(i).getId()){
                productList.remove(i);
                result=true;
                break;
            }
        }
        return result;
    }
    public void transact(Product product, int method){
        if (method==0){
            if (hasProduct(product)){
                productList.remove(product);
                income+= product.getPrice();
            }
        }
        if (method==1){
            if(productList.add(product))
                income=income- product.getPrice();
        }
    }
    public void setIncome(float income){
        this.income-=income;
    }
    public int getId(){
        return id;
    }
}
