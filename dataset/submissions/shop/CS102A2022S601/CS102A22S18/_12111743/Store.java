import java.util.ArrayList;

public class Store {
    
    private static int cnt=0;
    private int id;
    private String name;
    private float income;
    private ArrayList<Product> productList=new ArrayList<>();

    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getIncome() {
        return income;
    }
    public void setIncome(float income) {
        this.income = income;
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
   
    public Store(String name){
        this.name=name;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product>productList, float income){
        this.name=name;
        this.income=income;
        this.productList=productList;
        cnt++;
        id=cnt;
    }
 
    public boolean hasProduct(Product product){
        for(int i=0;i< getProductList().size();i++){
            if(product.getId()==productList.get(i).getId()){
                return true;
            }
        }return false;
    }
    public boolean addProduct(Product product){
        if(this.hasProduct(product)==false){
            productList.add(product);
            return true;
        }return false;
    }
    public boolean removeProduct(Product product){
        if(this.hasProduct(product)==true){
            productList.remove(product);
            return true;
        }return false;
    }
    public void transact(Product product, int method){
        if(method==0){
            productList.remove(product);
            setIncome(getIncome()+product.getPrice());
        }else{
            productList.add(product);
            setIncome(getIncome()-product.getPrice());
        }
    }
}

