import java.util.ArrayList;
public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name =  name;
        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        if(productList.indexOf(product)==-1) return false;
        else return true;
    }
    public boolean addProduct(Product product) {
        if(hasProduct(product)==true) return false;
        else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product) {
        if(productList.indexOf(product)!=-1) {
            productList.remove(product);
            return true;
        }
        else return false;
    }
    public ArrayList<Product> getProductList() {
        return this.productList;
    }
    public void transact(Product product, int method) {
        if(method==0) {
            income+=product.getPrice();
            productList.remove(product);
        }
        else if(method==1) {
            income-=product.getPrice();
            productList.add(product);
        }
    }
}
