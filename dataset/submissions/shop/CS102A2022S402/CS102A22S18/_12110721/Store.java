import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name) {
        this.income = 0;
        this.name = name;
        cnt++;
        this.id = cnt;
    }


    public Store(String name, ArrayList<Product> productList, float income) {
        this.income = 0;
        this.name = name;
        cnt++;
        this.id = cnt;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    public boolean addProduct(Product product) {
        ArrayList<Integer> id = new ArrayList<>();
        boolean judge = true;
        for (Product pro : productList) {
            if (product.getId()==pro.getId()) {
                judge = false;
                break;
            }
        }
        if (this.productList.contains(product)|| !judge) {
            return false;
        } else {
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (this.productList.contains(product)) {
            this.productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            this.income += product.getPrice();
            removeProduct(product);
        } else if (method == 1){
            this.income -= product.getPrice();
            addProduct(product);
        }
    }


}

