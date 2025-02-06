import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Store.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        int a = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (product.equals(productList.get(i))) {
                a = 1;
                break;
            }
        }
        if (a == 1) {
            return true;
        } else return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product) == false) {
            productList.add(product);
            return true;
        } else return false;
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product) == true) {
            productList.remove(product);
            return true;
        } else return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method) {
        if (method == 0) {
            income = income + product.getPrice();
            removeProduct(product);
        }
        if (method == 1) {
            income = income - product.getPrice();
            addProduct(product);
        }
    }
}
