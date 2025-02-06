import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        int id = product.getId();
        for (Product p : productList
        ) {
            if (p.getId() == id)
                return true;
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (!hasProduct(product)) {
            productList.add(product);
            return true;
        }
        return false;
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void transact(Product product, int method){
        switch (method){
            case 0:
                if(hasProduct(product)){
                    income += product.getPrice();
                    removeProduct(product);
                }
                break;
            case 1:
                addProduct(product);
                income -= product.getPrice();
                break;
        }
    }

}
