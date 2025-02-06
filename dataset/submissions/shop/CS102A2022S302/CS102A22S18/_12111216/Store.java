import java.util.ArrayList;
public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the
    //constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float income;

    public Store(String name){
        cnt++;
        this.name = name;
        this.id = cnt;
        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name = name;
        this.id = cnt;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product){
        if (productList.contains(product))return  true;
        else return false;
    }

    public boolean addProduct(Product product){
        if(this.hasProduct(product))return false;
        else {productList.add(product);
        return true;}

    }

    public boolean removeProduct(Product product){
        if(this.hasProduct(product)){productList.remove(product);
        return true;}
        else return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method == 0){
            if(this.hasProduct(product)){
                this.removeProduct(product);
                income+=product.getPrice();
            }
        }
        if (method == 1){
            if (!this.hasProduct(product)){
                addProduct(product);
                income-=product.getPrice();
            }
        }
    }
}
