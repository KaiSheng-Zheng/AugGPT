import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        id = ++cnt;
        this.name = name;
        income = 0;
        productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        id = ++cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        if (productList.contains(product)) return false;
        else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)) {
            productList.remove(product);
            return true;
        }
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method == 0){
            removeProduct(product);
            income += product.getPrice();
        }
        else if (method == 1) {
            addProduct(product);
            income -= product.getPrice();
        }
    }

    private ArrayList<Integer> goods = new ArrayList<>();
    public void goodsAdd(Product product){
        goods.add(product.getOrder());
    }
}
