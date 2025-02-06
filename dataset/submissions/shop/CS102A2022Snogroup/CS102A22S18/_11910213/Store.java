import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = new ArrayList<>();
        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product))
            return false;
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        if (!hasProduct(product))
            return false;
        productList.remove(product); //
        return true;
    }

    public boolean hasProduct(Product product) {
        for (Product value : productList) {
            if (value.getId() == product.getId())
                return true;
        }
        return false;
    }

    public void transact(Product product, int method){
        switch(method){
            case 0 : // purchase
                removeProduct(product);
                income += product.getPrice();
                break;
            case 1 : // refund
                addProduct(product);
                income -= product.getPrice();
                break;
        }
    }
}
