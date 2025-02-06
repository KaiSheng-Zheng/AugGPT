import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    
    public int getId(){
        return id;
    }
    {
        this.id = ++cnt;
    }
    public Store(String name){
        this.income = 0;
        this.name = name;
        productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.income = income;
        this.name = name;
        this.productList = new ArrayList<>(productList);
    }
    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product){
        for(Product p : this.productList){
            if(product.getId() == p.getId()) return false;
        }
        this.productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        if(this.hasProduct(product)){
            this.productList.remove(product);
            return true;
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method == 0){
            productList.remove(product);
            income += product.getPrice();
        }else if(method == 1){
            productList.add(product);
            income -= product.getPrice();
        }
    }
}
