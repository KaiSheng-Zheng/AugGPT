import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product>productList = new ArrayList<>();
    private float income = 0;

    public Store(String name){
        this.id = ++cnt ;
        this.name = name ;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.id = ++cnt ;
        this.name = name ;
        this.productList = productList ;
        this.income = income ;
    }

    public boolean hasProduct(Product product){
        boolean j = false;
            if( productList.contains(product) ){
                j = true ;
        }
        return j ;
    }

    public boolean addProduct(Product product){
        boolean j = false;
        if(hasProduct(product)){
            j = false ;
        }
        else{
            productList.add(product);
            j = true ;
        }
        return j;
    }

    public boolean removeProduct(Product product){
        boolean j = false;
        if(hasProduct(product)){
            productList.remove(product);
            j = true;
        }
        return j;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            productList.remove(product) ;
            income = income + product.getPrice() ;
        }
        if(method==1){
            productList.add(product);
            income = income - product.getPrice() ;
        }
    }
}
