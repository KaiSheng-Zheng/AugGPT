import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList= new ArrayList<>();
    private float income;

    public float getIncome() {
        return income;
    }

    public Store(String name) {
        this.name = name;
        this.income = 0;
        cnt += 1;
        this.id = cnt;
        this.productList = new ArrayList<>();

    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt += 1;
        this.name = name;
        this.income = income;
        this.productList = productList;
        this.id = cnt;
        for (Product product : productList) {
            product.setWhichStore(this);
        }
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);

    }

    public boolean addProduct(Product product) {
        if (!hasProduct(product)) {
            this.productList.add(product);
            product.whichStore = this;
            return true;
        }
        else return false;

    }

    public boolean removeProduct(Product product) {
        if(!productList.contains(product)){
            return false;
        } else{
            productList.remove(product);
            return true;
        }

    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        if(method == 0){
            removeProduct(product);
            this.income += product.getPrice();
        }
        if(method == 1){
            this.income -= product.getPrice();
            addProduct(product);
        }

    }
}
