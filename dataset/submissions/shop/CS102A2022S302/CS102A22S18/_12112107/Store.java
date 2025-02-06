import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        productList = new ArrayList<>();
        income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public boolean hasProduct(Product product) {
        int n = getProductList().size();
        boolean has = false;
        for (int i = 0; i < n; i++) {
            if(getProductList().get(i)==product)
                has = true;
        }
        return has;
    }

    public boolean addProduct(Product product) {
        boolean add = false;
        if (hasProduct(product)==false) {
            productList.add(product);
            add = true;
        }
        else {
            add = false;
        }
        return add;
    }

    public boolean removeProduct(Product product) {
        if (!hasProduct(product)) {
            return false;
        }
        productList.remove(product);
        return true;
    }

    public int getId(){
        return this.id;
    }

    public void getStore(int id){
        if(id==this.id) {
            Store store = new Store(this.name,this.productList,this.income);
        }
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            income+=product.getPrice();
        }
        if (method == 1) {
            addProduct(product);
            income-=product.getPrice();
        }
    }
}

