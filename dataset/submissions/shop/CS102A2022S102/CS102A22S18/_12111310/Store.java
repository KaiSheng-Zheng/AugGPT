import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = income;
        this.productList = productList;

    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    public boolean addProduct(Product product) {
        boolean contain = true;
        for (Product x : productList) {
            if (x == product) {
                contain = false;
                break;
            }
        }
        if (contain) productList.add(product);
        return contain;
    }

    public boolean removeProduct(Product product) {
        boolean contain = false;
        for (Product y :productList) {
            if (y == product) {
                contain = true;
                break;
            }
        }
        if (contain) productList.remove(product);
        return contain;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method==0){
            productList.remove(product);
            income+=product.getPrice();
        }
        if (method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }
}
