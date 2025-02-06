import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        this.name = name;
        this.income = 0;
        cnt++;
        this.id = cnt;

    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.income = income;
        this.productList = productList;
        cnt++;
        this.id = cnt;

    }
    public boolean hasProduct(Product product){
        for(Product p : productList){
            if(p.getId() == product.getId()){
                return true;
            }
            }
        return false;
    }
    public boolean addProduct(Product product){
        for(Product p : productList){
            if(p.getId() == product.getId()){
                return false;
            }
        }
        productList.add(product);
        product.setStoreid(0);
        return true;
    }
    public boolean removeProduct(Product product){
        for(Product p : productList){
            if(p.getId() == product.getId()){
                product.setStoreid(this.id);
                productList.remove(p);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            if (removeProduct(product)) {
                income += product.getPrice();
            }
        } else if (method == 1) {
            if (addProduct(product)) {
                income -= product.getPrice();
            }
        }

    }

    public int getId() {
        return id;
    }
}
