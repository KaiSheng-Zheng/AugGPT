import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name = name;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name = name;
        this.productList=productList;
        this.income=income;
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if(!productList.contains(product)){
            productList.add(product);
            return true;
        }
        else return false;
    }

    public boolean removeProduct(Product product){
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }
        else return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        switch(method){
            case 0:if(removeProduct(product)) income+=product.getPrice();break;
            case 1:if(addProduct(product)) income-=product.getPrice();break;
        }
    }
}
