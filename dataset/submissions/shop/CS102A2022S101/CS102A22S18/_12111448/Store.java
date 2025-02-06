import java.util.ArrayList;

public class Store{
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();  // arraylist called "productList" to store product class
    private float income;

    public Store(String name) {
        this.name = name;
        this.income=0;
        ++cnt;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        //The other constructs an existing(!) store with given income and productList.
        //??????????????
        this.name = name;
        this.income+=income;
        this.productList = productList;
        ++cnt;
        this.id=cnt;
    }
    
    public boolean hasProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId()==productList.get(i).getId()){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if (!hasProduct(product) ){
            productList.add(product);
            return true;
        }
        return false;
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income+=product.getPrice();
            product.soldStore=this;
        }
        else if (method==1){
            //bonus
            //refund
            productList.add(product);
            income-=product.getPrice();
        }
    }
}