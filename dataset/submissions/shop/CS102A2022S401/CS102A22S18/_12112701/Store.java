import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(){cnt++;}

    public Store(String name){
        this.name=name;
        this.income=0;
        cnt++;
        this.id=cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.income=income;
        this.productList=productList;
        cnt++;
        this.id=cnt;
    }

    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product){
        boolean check=this.hasProduct(product);
        if(!check){this.productList.add(product);}
        return !check;
    }

    public boolean removeProduct(Product product){
        boolean check=this.hasProduct(product);
        if(check){this.productList.remove(product);}
        return check;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            product.getStore().add(this);
            this.productList.remove(product);
            this.income+=product.getPrice();
        }
        if(method==1){
            this.productList.add(product);
            this.income-=product.getPrice();
        }
    }
}
