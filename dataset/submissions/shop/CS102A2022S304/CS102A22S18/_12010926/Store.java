import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }
    public boolean hasProduct(Product product){
        boolean same = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId())same = true;
        }
        return same;
    }
    public boolean addProduct(Product product){
        if (hasProduct(product) == false){
            productList.add(product);
            return true;}
        else return false;
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product) == true){
            productList.remove(product);
            return true;
        }else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method == 0){
            productList.remove(product);
            income += product.getPrice();
        }
        if (method == 1){
            productList.add(product);
            income -= product.getPrice();
        }
    }
}
