import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    ArrayList<Product>refund=new ArrayList<>();

    public Store(String name) {
        this.name = name;
        income = 0;
        Store.cnt++;
        this.id=cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        Store.cnt++;
        this.id=cnt;

    }

    public boolean hasProduct(Product product) {
        for (int i = 0; i < this.productList.size(); i++) {
            if (this.productList.get(i) == product) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        } else {
           this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            this.productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            income = income + product.getPrice();

        }
       else if(method==1){
            addProduct(product);
            refund.add(product);
            income = income - product.getPrice();

        }
    }

}
