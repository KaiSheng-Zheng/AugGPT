import java.util.ArrayList;
public class Store {
    private static int cnt = 0;
    private int id =cnt+1;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    //Constructor
    public Store(String name){
        cnt++;
        this.name = name;
        this.income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product){
        if (productList.indexOf(product)==-1){
            return false;
        }else {
            return true;
        }
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            product.store = this;//bonus
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method == 0){
            income += product.getPrice();
            removeProduct(product);
            product.Sold = true;
        }else if (method == 1){
            income -= product.getPrice();
            addProduct(product);
            product.Sold = false;
        }
    }


}
