import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
        this.income = 0;
        cnt++;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product) {
        if (this.productList.contains(product)) return true;
        else return false;
    }
    public boolean addProduct(Product product) {
        if (this.hasProduct(product)) return false;
        else {
            this.productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product) {
        if (this.hasProduct(product)) {
            for (int i = 0; i < productList.size(); i++) {
                if(productList.get(i).equals(product)){
                    productList.remove(i);
                    break;
                }
            }
            return true;
        }else return false;
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method) {
        if (method==0) {
            this.income += product.getPrice();
            this.removeProduct(product);
        }
        if (method==1) {
            this.income -= product.getPrice();
            this.addProduct(product);
        }
    }














}
