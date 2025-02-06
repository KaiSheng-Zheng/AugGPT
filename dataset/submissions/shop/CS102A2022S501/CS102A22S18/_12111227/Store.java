import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        this.name = name;
        income = 0;
        id = ++cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.income = income;
        this.productList.addAll(productList);
        id = ++cnt;
    }

    public boolean hasProduct(Product product){
        boolean has = false;
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == product.getId()){
                has = true;
            }
        }
        return has;
    }

    public boolean addProduct(Product product){
        if(!hasProduct(product)){
            productList.add(product);
            return true;
        }else {
            return false;
        }
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method){
        if(method == 0){
            if (hasProduct(product)) {
                removeProduct(product);
                income += product.getPrice();
            }
        }

        if(method == 1){
            addProduct(product);
            income -= product.getPrice();
        }
    }
}
