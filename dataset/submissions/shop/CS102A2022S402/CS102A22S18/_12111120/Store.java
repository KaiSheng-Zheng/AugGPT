import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        this.name = name;
        this.income = 0f;
        cnt ++;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList , float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt ++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product){
        boolean b = false;
        for (Product value : this.productList) {
            if (product.equals(value)) {
                b = true;
                break;
            }
        }
        if (b){
            return false;
        }else {
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        boolean b = false;
        for (Product value : this.productList){
            if (hasProduct(product)) {
                b = true;
                break;
            }
        }
        if (b){
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
            productList.remove(product);
            this.income += product.getPrice();
        }
        if (method == 1){
            productList.add(product);
            income -= product.getPrice();
        }
    }

}
