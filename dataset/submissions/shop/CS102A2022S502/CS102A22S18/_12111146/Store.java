import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.income = 0;
        this.name = name;
        cnt++;
        this.id = cnt;
        this.productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product){
        boolean has = false;
        for (Product value : productList) {
            if (product.equals(value)) {
                has = true;
                break;
            }
        }
        return has;
    }

    public boolean addProduct(Product product){

        if (!hasProduct(product)){

            productList.add(product);
            return true;
        }else {
            return false;
        }
    }


    public boolean removeProduct(Product product){

        if (hasProduct(product)){

            productList.remove(product);
            return true;
        }else {
            return false;
        }
    }




    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method == 0){
            productList.remove(product);
            income = income + product.getPrice();
        }else if (method == 1){
            productList.add(product);
            income = income - product.getPrice();
        }
    }

}
