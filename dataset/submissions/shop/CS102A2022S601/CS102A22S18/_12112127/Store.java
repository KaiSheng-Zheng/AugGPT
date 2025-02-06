import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public float setIncome() {
        this.income = income;
         return income;
    }

    public float getIncome() {
        return income;
    }

    public static int getCnt() {
        return cnt;
    }

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.income = income;
        this.name = name;
        this.productList = productList;
    }

    public boolean hasProduct(Product product) {
        boolean yesorno = true;
        yesorno = productList.contains(product);
        return yesorno;
    }

    public boolean addProduct(Product product) {
        boolean optionSuced = false;
        if (productList.contains(product)) {
            optionSuced = false;
        } else {
            productList.add(product);
            optionSuced = true;
        }
        return optionSuced;
    }

    public boolean removeProduct(Product product) {
        boolean optionSucedofremoving = false;
        if (productList.contains(product)) {
            productList.remove(product);
            optionSucedofremoving = true;
        } else {
            optionSucedofremoving = false;
        }
        return optionSucedofremoving;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            this.income += product.getPrice();
        }
        if (method == 1) {
            addProduct(product);
            this.income -= product.getPrice();
        }
    }
}
