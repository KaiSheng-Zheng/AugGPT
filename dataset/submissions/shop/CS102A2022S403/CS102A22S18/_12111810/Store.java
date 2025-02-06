import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;
        this.name = name;
        this.income = 0;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.name = name;
        this.income = income;
        this.productList = productList;
        this.id = cnt;
    }

    public boolean hasProduct(Product product) {
        int a = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (product == productList.get(i)) {
                a += 1;
            }
        }
        if (a == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addProduct(Product product) {
        int a = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (product == productList.get(i)) {
                a += 1;
            }
        }
        if (a != 0) {
            return false;
        } else {
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (product == productList.get(i)) {
                a += 1;
                b = i;
            }
        }
        if (a == 0) {
            return false;
        } else {
            this.productList.remove(b);
            return true;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            int b = 0;
            for (int i = 0; i < productList.size(); i++) {
                if (product == productList.get(i)) {
                    b = i;
                }
            }
            productList.remove(b);
            this.income += product.getPrice();
        }
        if(method==1){
            productList.add(product);
            this.income -= product.getPrice();
        }

    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
