import java.util.ArrayList;


public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt = cnt + 1;
        this.income = 0;
        this.id = cnt;
        this.name=name;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt = cnt + 1;
        this.id = cnt;
        this.productList = productList;
        this.name = name;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==product.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method==0){
            productList.remove(product);
            income+=product.getPrice();
        }else if (method==1){
            income-=product.getPrice();
            productList.add(product);
        }
    }
}