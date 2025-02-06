import java.util.ArrayList;

public class Store {
    //Attributes
    private static int cnt = 0;
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    //Constructors
    public Store(String name) {
        this.name = name;
        cnt++;
        id = cnt;
        income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        cnt++;
        id = cnt;
        this.income = income;
        this.productList = productList;
        int productNum = productList.size();
        for (int i = 0; i < productNum; i++) {
            this.productList.get(i).setBelongToStore(id);
        }
    }

    //Setters
    public void setIncome(float income) {
        this.income = income;
    }
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    //Getters
    public int getId() {
        return id;
    }
    public float getIncome() {
        return income;
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }

    //Methods
    public boolean hasProduct(Product product) {
        int productNum = productList.size();
        boolean has = false;
        for (int i = 0; i < productNum; i++) {
            if (product == productList.get(i)) {
                has = true;
                break;
            }
        }
        return has;
    }

    public boolean addProduct(Product product) {
        if (!hasProduct(product)) {
            productList.add(product);
            product.setBelongToStore(id);
            return true;
        }
        else
            return false;
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            productList.remove(product);
            return true;
        }
        else
            return false;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            if (removeProduct(product)) {
                income += product.getPrice();
            }
        }
        else if (method == 1) {
            if (addProduct(product)) {
                income -= product.getPrice();
            }
        }

    }





}
