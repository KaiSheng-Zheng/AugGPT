import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name=name;
        productList=new ArrayList<>();
        cnt++;
        this.id=cnt;
    }

    public Store(String name,ArrayList<Product> productList,float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        this.id=cnt;
    }

    public boolean hasProduct(Product product){
        int has=0;
        for (int i=0;i<productList.size();i++){
            if (product==productList.get(i)){has++;}
        }
        if (has==0){return false;}
        else {return true;}
    }

    public boolean addProduct(Product product){
     if (hasProduct(product)){
         return false;
     }
      else {
          productList.add(product);
          return true;
      }
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }
        else return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product,int method){
        if (method==0){
            productList.remove(product);
            income=income+product.getPrice();
        }
        else if (method==1){
            productList.add(product);
            income=income-product.getPrice();
        }
    }
}
