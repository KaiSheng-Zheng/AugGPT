import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        income=0;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.income=income;
        this.name=name;
        this.productList=productList;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product){
        boolean b= productList.contains(product);
        if (b==true){return true;}
        else return false;
    }
    public boolean addProduct(Product product){
        boolean b= productList.contains(product);
        if (b==false){productList.add(product);return true;}
        else return false;
    }
    public boolean removeProduct(Product product){
        boolean c=productList.contains(product);
        if (c==true){productList.remove(product);return true;}
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method==0){productList.remove(product);income+=product.getPrice();}
        else if (method==1){productList.add(product);income-=product.getPrice();}
    }
}
