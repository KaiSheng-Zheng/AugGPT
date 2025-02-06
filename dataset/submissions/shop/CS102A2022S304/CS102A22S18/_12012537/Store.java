import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.cnt++;
        this.id = this.cnt;
        this.name = name;
        this.income = 0;
        productList=new ArrayList<>();
        productList.clear();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.cnt++;
        this.id = this.cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;


    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);

    }

    public boolean addProduct(Product product) {
        if (productList.contains(product)) {
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (productList.contains(product)) {
            productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
return  productList;
    }

    public void transact(Product product, int method) {
        //method = 0 means purchasing the product from this store. The product
        // should be removed from the productList and the income of this store
        // should increase by an amount equal to the price of the product.
        //(Bonus) method = 1 means refunding the product to the store. The
        // productList and income of the store should also be updated accordingly
        // (suppose that the store adds this product back to its productList
        // and could re-sell this product).
        if(method==0){
            productList.remove(product);
            income+=product.getPrice();
        }else if(method==1){
            productList.add(product);
            income-= product.getPrice();
        }
    }
}

