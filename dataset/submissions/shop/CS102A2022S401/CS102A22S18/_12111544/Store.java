import java.util.ArrayList;
public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name){
        this.name = name;
        income = 0;
        cnt++;
        id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product) {
        int t = 0;
        for (Product i : productList) {
            if (i.equals(product))
                t = 1;
        }if(t == 0)
            return false;
        else
            return true;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product))
            return false;
        else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }else
            return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method == 0){
            removeProduct(product);
            income += product.getPrice();
            product.setStore(this);
        }if(method == 1){
            addProduct(product);
            income -= product.getPrice();
        }
    }
}