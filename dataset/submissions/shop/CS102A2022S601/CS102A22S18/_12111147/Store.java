import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>(0);
    private float income;

    public Store(String name) {
        this.income = 0;
        this.id = ++cnt;
        this.name = name;
        this.productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.income = income;
        this.productList = productList;
        cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product) {
        for(int i=0; i<productList.size(); i++){
            if(product.equals(productList.get(i))){
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if(!hasProduct(product)){
            productList.add(product);
            return true;
        }
        return false;
    }

    public boolean removeProduct(Product product) {
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if(method == 0){
            removeProduct(product);
            this.income += product.getPrice();///////////////////////////////////////
        }
        if(method == 1){
            addProduct(product);
            this.income -= product.getPrice();///////////////////////////////////////

        }
    }
}