import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id=0;  // unique for each store and the value is set to cnt.
    private String name="";
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float income=0;

    public Store(String name) {
        cnt = cnt + 1;
        id = cnt;
        this.name = name;
        income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt = cnt + 1;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        int ijk = 0;
        if(productList!=null) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).equals(product)) {
                    ijk++;
                }
            }
            if (ijk ==1) {
                return true;
            } else return false;
        }else return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }

    public void getincome(float x){
        income=income+x;
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            income += product.getPrice();
        } else if (method == 1) {
            addProduct(product);
            income -= product.getPrice();
        }
    }
}
