import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income=0;

    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
        for(int pp=0;pp<productList.size();pp++){
            productList.get(pp).setStore(this);
        }
    }

    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product){
        for (Product a :productList){
            if (a.getId()==product.getId()){
                return false;
            }
        }
        this.productList.add(product);
        product.setStore(this);
        return true;
    }

    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        } else return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income+=product.getPrice();
        } else if (method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }


}
