import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        this.name = name;
        this.income = 0;
        this.id = ++cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        this.id = ++cnt;
    }
    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product){
        if ( ! hasProduct(product)){ ////
            this.productList.add(product);
            return true;
        }
        else return false;
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            this.productList.remove(product);
            return true;
        }
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void setIncome(float income){
        this.income += income;
    }
    public void transact(Product product, int method){
        if (method == 0){
            this.productList.remove(product);
            this.income += product.getPrice();
//            product.setStore(this);
        }
        if (method == 1){
            this.productList.add(product);
            this.income -= product.getPrice();

        }
    }

}
