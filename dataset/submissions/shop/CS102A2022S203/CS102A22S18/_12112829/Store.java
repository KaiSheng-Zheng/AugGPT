import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        this.name=name;
        cnt++;
        id = cnt;
    }


    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList.addAll(productList);
        this.income=income;
        cnt++;
        id = cnt;
    }


    public boolean hasProduct(Product product){
        boolean test =false;
        for (Product value : productList) {
            if (value.getName().equals(product.getName())) {
                test = true;
                break;
            }
        }
        return test;
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
        switch (method){
            case 0:
                if (removeProduct(product)){
                    income += product.getPrice();
                }
                break;
            case 1:
                if (addProduct(product)){
                    income -= product.getPrice();
                }
                break;
        }
    }

}
