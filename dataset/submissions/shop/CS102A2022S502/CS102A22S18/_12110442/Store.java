import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    private ArrayList<Product> list1 = new ArrayList<>();

    public Store(String name) {
        this.name = name;
        this.income = 0;
        cnt++;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product) {
        if (this.productList.contains(product)){
            return this.productList.contains(product);
        } else {return false;}
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)){
            return false;
        }
        return this.productList.add(product);
    }

    public boolean removeProduct(Product product) {
        if (this.productList.contains(product)){
            return this.productList.remove(product);
        } else {return false;}
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        if (method == 1){
            if (this.list1.contains(product)){
                this.income -= product.getPrice();
                this.productList.add(product);
                this.list1.remove(product);
            }
        } else if (method == 0){
            if (this.productList.contains(product)){
                this.income += product.getPrice();
                this.productList.remove(product);
                this.list1.add(product);
            }
        }
    }
}
