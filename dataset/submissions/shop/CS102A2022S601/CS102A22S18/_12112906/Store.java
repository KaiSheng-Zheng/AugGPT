import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;


    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
        this.income=0f;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }



    public boolean hasProduct(Product product){
        for(Product i:productList){
            if(i==product)
                return true;
        }
        return false;
    }

    public boolean addProduct(Product product){
        for(Product i:productList){
            if(i.getId()==product.getId())
                return false;
        }
        this.productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        for(Product i:productList){
            if(i==product){
                productList.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){ //purchase
            income+=product.getPrice();
            removeProduct(product);
        }
        else if(method==1){
            income-=product.getPrice();
            productList.add(product);
        }
    }
}
