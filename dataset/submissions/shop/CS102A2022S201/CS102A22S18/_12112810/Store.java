import java.util.ArrayList;

public class Store {
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

    public ArrayList<Product> getProductList() {
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

    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;


    public Store( String name ) {
        id = cnt + 1;
        this.name = name;
        income = 0;
        productList = new ArrayList<>();
        cnt ++;
    }

    public Store ( String name, ArrayList<Product>productList, float income ){
        id = cnt + 1;
        this.name = name;
        this.income = income;
        this.productList = productList;
        cnt ++;
    }

    public boolean hasProduct(Product product){
        if(productList.contains(product))
            return true;
        return false;
    }

    public boolean addProduct(Product product){
        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i).getId() == product.getId())
                return false;
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }

    public void transact(Product product, int method){
        if(method == 0){
            if(removeProduct(product)){
                setIncome(this.income + product.getPrice());
            }
        }
        if(method == 1){
            if(addProduct(product)){
                setIncome(this.income - product.getPrice());
            }
        }
    }

}
