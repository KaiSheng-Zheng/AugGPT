import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name) {
        ++cnt;
        income = 0;
        productList = new ArrayList<Product>();
        this.name = name;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        ++cnt;
        this.productList = productList;
        this.name = name;
        this.income = income;
        this.id = cnt;
    }



    public boolean hasProduct(Product product) {
        boolean result;
        result=productList.contains(product);
        return result;
    }

    public boolean addProduct(Product product) {
        boolean result=true;
        if(productList.contains(product))
            result=false;
        if(!result)
            return result;
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        boolean result = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) == product) {
                productList.remove(product);
                result = true;
                break;
            }
        }
        return result;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            productList.remove(product);
            income = income + product.getPrice();
        }
        if (method == 1) {
            productList.add(product);
            income = income - product.getPrice();
        }
    }
}
