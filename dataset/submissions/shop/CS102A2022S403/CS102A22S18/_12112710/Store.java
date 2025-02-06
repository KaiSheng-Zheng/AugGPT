import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;
        this.name = name;
        this.id = cnt;
        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.name = name;
        this.productList = productList;
        this.income = income;
        this.id = cnt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getIncome() {
        return income;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public boolean hasProduct(Product product) {
        boolean has = false;
        for (Product value : this.productList) {
            if (value.checkEquality(product)) {  //?
                has = true;
            }
        }
        return has;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        } else this.productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            this.productList.remove(product);
            return true;
        } else return false;
    }

    
    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            this.income+= product.getPrice();
        }
        if (method == 1){
            addProduct(product);
            this.income-= product.getPrice();
        }
    }
}
