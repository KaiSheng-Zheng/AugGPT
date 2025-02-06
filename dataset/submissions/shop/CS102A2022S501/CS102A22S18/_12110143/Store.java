import java.util.ArrayList;

public class Store {
    private static int cnt=0; //let cnt be a number that reflects id
    private int id; // unique
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

//define store(in two ways)
    public Store(String name){
        this.name=name;
        this.income=0;
        cnt++;
        this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        this.id=cnt;
    }

//if store has product
    public boolean hasProduct(Product product){
        if(productList.contains(product)){
            return true;
        }
        else{
            return false;
        }
    }
//Add product
    public boolean addProduct(Product product){
        if(hasProduct(product)==false){
            productList.add(product);
            return true;
        }
        else{
            return false;
        }
    }
//remove
    public boolean removeProduct(Product product){
        if(hasProduct(product)==true){
            productList.remove(product);
            return true;
        }
        else{
            return false;
        }
    }
//get productlist
    public ArrayList<Product> getProductList(){
        return productList;
    }

    ArrayList<Product> sold=new ArrayList<>();
    public void transact(Product product, int method){
        if(method==1&&hasProduct(product)==false&&sold.contains(product)){
            addProduct(product);
            income-=product.getPrice();
        }
        if(method==0&&hasProduct(product)==true){
            removeProduct(product);
            income+=product.getPrice();
            sold.add(product);
        }
    }
}
