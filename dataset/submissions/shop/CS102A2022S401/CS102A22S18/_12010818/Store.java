import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id = 1; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income = 0;


    public Store(String name){
        cnt++;
        setId(cnt);
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        setId(cnt);
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public void setId(int cnt){
        this.id = cnt;
    }

    public boolean hasProduct(Product product){
        for (Product value : productList) {
            if (value == product) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) == product) {
                productList.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method == 0){
            removeProduct(product);
            income = income + product.getPrice();

        }
        else if (method == 1){
            addProduct(product);
            income = income - product.getPrice();
        }
    }
}
