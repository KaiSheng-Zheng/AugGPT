import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name = name;
        id = ++ cnt;
        income = 0;
        productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        id = ++ cnt;
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
            if (productList.contains(product)){
                return false;
            }
            else {
                productList.add(product);
                return true;
            }
    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }
        else{
            return false;
        }
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
