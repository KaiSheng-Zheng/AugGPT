import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the
    //    constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        id=++cnt;
        this.name=name;
        income = 0;
        productList=new ArrayList<>();

    }
    public Store(String name, ArrayList<Product> productList, float income){
        id=++cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        for (int i = 0; i < productList.size() ; i++) {
            if(productList.get(i).equals(product)) {
                return true;

            }
        }

        return false;

    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else{productList.add(product);
            return true;

        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){productList.remove(product);
            return true;}
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            if(removeProduct(product)){
                income+=product.getPrice();
            }
        }
        else{
            if(addProduct(product)){
                income-=product.getPrice();
            }
        }
    }
}
