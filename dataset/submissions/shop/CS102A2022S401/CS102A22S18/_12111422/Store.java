import java.util.ArrayList;

class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        this.income = 0;
        this.productList = new ArrayList<>();
        cnt++;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.income = income;
        this.productList = productList;
        cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product) {
        int a = 0;
        for (Product value : productList) {
            if (value == product) {
                a++;
                break;
            }
        }
        return a != 0;
    }

    public boolean addProduct(Product product) {
        boolean p;
        p = this.hasProduct(product);
        if (p) {
            return false;
        } else {
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        boolean p1;
        p1 = this.hasProduct(product);
        if (p1) {
            this.productList.remove(product);
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
            this.productList.remove(product);
            this.income += product.getPrice();
        }
        if (method == 1) {
            this.productList.add(product);
            this.income -= product.getPrice();
        }
    }
}