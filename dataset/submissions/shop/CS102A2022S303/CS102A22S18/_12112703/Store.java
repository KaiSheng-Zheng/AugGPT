import java.util.ArrayList;

public class Store {
    private static int cnt =0; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private ArrayList<Product> allProductList;
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = 0;
        this.productList = new ArrayList<>();
        this.allProductList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = income;
        this.productList = productList;
        this.allProductList = new ArrayList<>();
    }

    public boolean hasProduct(Product product){
        for (int i =0; i<productList.size();i++){
            if (product.getId() == productList.get(i).getId()){
                return true;
            }
        }
        return false;
    }

    public boolean allhasProduct(Product product){
        for (int i =0; i<allProductList.size();i++){
            if (product.getId() == allProductList.get(i).getId()){
                return true;
            }
        }
        return false;
    }


    public boolean addProduct(Product product){
        for (int i =0; i<productList.size();i++){
            if (productList.get(i).getId() == product.getId()){
                return false;
            }
        }
        productList.add(product);

        return true;
    }

    public boolean removeProduct(Product product){
        for (int i =0; i<productList.size();i++){
            if (product.getId() == productList.get(i).getId()){
                productList.remove(i);
                return true;
            }
        }
        return false;
    }

    public static int getCnt() {
        return cnt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public float getIncome() {
        return income;
    }

    public void transact(Product product, int method){
        if (method == 0){
            if (removeProduct(product)==true){
                allProductList.add(product);///////////
                this.income = this.income + product.getPrice();
            }


        }
        if (method == 1){
            productList.add(product);
            this.income = this.income - product.getPrice();
        }
    }

}
