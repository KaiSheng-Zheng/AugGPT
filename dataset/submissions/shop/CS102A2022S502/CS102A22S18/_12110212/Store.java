import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
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
        int cnt = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId()==productList.get(i).getId()) {
                cnt++;
            }
        }
        if (cnt == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addProduct(Product product) {
        int cnt = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                cnt++;
            }
        }
        if (cnt == 0) {
            productList.add(product);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeProduct(Product product) {
        int cnt = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId() == productList.get(i).getId()) {
                productList.remove(i);
                cnt++;
                break;
            }
        }
        if (cnt == 0) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            for (int i = 0; i < productList.size(); i++) {
                if (product.getId() == productList.get(i).getId()) {
                    productList.remove(i);
                    income += product.getPrice();
                }
            }
        }
    }
}
