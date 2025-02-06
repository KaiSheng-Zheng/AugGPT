import java.util.ArrayList;

public class Store {

    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        income=0;
        this.name=name;
        productList=new ArrayList<>();
        id=++cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        id=++cnt;
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);
    }


    public boolean addProduct(Product product){
        for (int i=0;i<productList.size();i++)
            if(productList.get(i).equals(product))
                return false;
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        return productList.remove(product);
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            if(removeProduct(product))
                income+=product.getPrice();
        }else {
            if(addProduct(product))
                income-=product.getPrice();
        }
    }

}