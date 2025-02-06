import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    private ArrayList<Integer> ID = new ArrayList<>();

    public int getId() {
        return id;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Store.cnt = cnt;
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
        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = income;
        this.productList = productList;
        for (Product product : productList) {
            ID.add(product.getId());
        }
    }

    public boolean hasProduct(Product product) {
        boolean p = false;
        if (!productList.isEmpty()) {
            for (Product value : productList) {
                if (value.getId() == product.getId()) {
                    p = true;
                    break;
                }
            }
        }
        return p;
    }

    public int hasProductNumber(Product product) {
        int k = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                k = i;
                break;
            }
        }
        return k;
    }

    public ArrayList<Integer> getID() {
        return ID;
    }

    public boolean addProduct(Product product) {
        boolean p = hasProduct(product);
        if (!p) {
            this.productList.add(product);
            this.ID.add(product.getId());
        }
        return !p;
    }

    public boolean removeProduct(Product product) {
        boolean p = hasProduct(product);
        if (p) {
            this.productList.remove(hasProductNumber(product));
        }
        return p;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            this.income += product.getPrice();
        } else {
            addProduct(product);
            this.income -= product.getPrice();
        }
    }
}
