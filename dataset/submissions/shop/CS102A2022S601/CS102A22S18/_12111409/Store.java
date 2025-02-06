import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    private float income;

    public Store(String name){
        cnt++;
        this.name = name;
        this.productList=new ArrayList<>();
        this.income = 0;
        this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name = name;
        this.productList = productList;
        for(int i=0;i<productList.size();i++){
            productList.get(i).setStore(this);
        }
        this.income = income;
        this.id=cnt;
    }

    public boolean hasProduct(Product product){
        if (this.productList.contains(product)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addProduct(Product product){
        if(productList.contains(product)){
            return false;
        }
        this.productList.add(product);
        product.whichStore=this;
        return true;
    }

    public boolean removeProduct(Product product){
        if(productList.contains(product)==false){
            return false;
        }
        else{
            productList.remove(product);
            return true;
        }
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            this.income=this.income+product.getPrice();
            removeProduct(product);
        }
        if(method==1){
            this.income=this.income-product.getPrice();
            addProduct(product);
        }
    }

}
