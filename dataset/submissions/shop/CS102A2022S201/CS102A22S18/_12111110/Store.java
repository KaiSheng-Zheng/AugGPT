import java.util.ArrayList;
public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        setCnt(getCnt());
        this.id=getCnt();
        this.name=name;
    }
    public void setCnt(int cnt){this.cnt=cnt+1;}
    public int getCnt(){return cnt;}
    public Store(String name, ArrayList<Product> productList, float income){
        setCnt(getCnt());
        this.id=getCnt();
        this.name=name;
        this.productList=productList;
        for(Product p:productList) p.setStore(this);
        this.income=income;
    }
    public boolean hasProduct(Product product){
        if(productList.contains(product)) return true;
        else return false;
    }
    public boolean addProduct(Product product){
        if(getProductList().contains(product)==false){
            getProductList().add(product);
            product.setStore(this);
            return true;
        }
        else {
            product.setStore(this);
            return false;
        }
    }
    public boolean removeProduct(Product product){
        if(getProductList().contains(product)){
            getProductList().remove(product);
            return true;
        }
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void setIncome(float income){
        this.income=income;
    }
    public float getIncome(){
        return income;
    }
    public void transact(Product product, int method){
        if(method==0){
            if(removeProduct(product)) setIncome(getIncome()+product.getPrice());
        }
        else if(method==1){
            if(addProduct(product)) setIncome(getIncome()-product.getPrice());
        }
    }
}
