import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public int getId() {
        return id;
    }

    public Store(String name){
        this.name = name;
        income = 0;
        id = ++cnt;
        productList = new ArrayList<Product>();
    }
    public Store(String name,ArrayList<Product> productList,float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        id = ++cnt;
    }

    public boolean hasProduct(Product product){
        boolean result = false;
        for (int i = 0; i < productList.size(); i++) {
            if (product.toString().equals(productList.get(i).toString())){
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean addProduct(Product product){
        boolean result = true;
        if (hasProduct(product)){
            result = false;
        }else{
            productList.add(product);
        }
        return result;
    }

    public boolean removeProduct(Product product){
        boolean result = true;
        if (hasProduct(product)){
            productList.remove(product);
        }else{
            result = false;
        }
        return result;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product,int method){
        if (method == 0){
            removeProduct(product);
            income += product.getPrice();
        }else if (method == 1){
            addProduct(product);
            income -= product.getPrice();
        }
    }
}