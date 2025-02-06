import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product){
        for (Product Pro : productList){
            if (product.getId() == Pro.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)) {
            productList.remove(product);
            return true;
        }else {
            return false;
        }
    }

    public void transact(Product product, int method){
        if (method == 0){
            removeProduct(product);
            income += product.getPrice();
        }else if (method == 1){
            addProduct(product);
            income -= product.getPrice();
        }
    }

    public static int getCnt() {
        return cnt;
    }
    public static void setCnt(int cnt) {
        Store.cnt = cnt;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    public float getIncome() {
        return income;
    }
    public void setIncome(float income) {
        this.income = income;
    }
}
