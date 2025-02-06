import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name="";
    private ArrayList<Product> productList=new ArrayList<>();
    private float income=0;
    public Store(String name){
        cnt++;
        this.name=name;
        id=cnt;
        income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
         this.productList=productList;
         this.income=income;
         this.name=name;
    }



    public boolean hasProduct(Product product){
         boolean flag=false;
     if (productList.contains(product)){
         flag = true;
     }
     return flag;
    }

    public boolean addProduct(Product product){
      if (!hasProduct(product)){
          productList.add(product);
          return true;
      }else{
          return false;
      }

    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
       return productList;
    }
    public void transact(Product product, int method){
       if(method==0){
          removeProduct(product);
          income=income+ product.getPrice();
       }
       if(method==1){
           addProduct(product);
           income=income-product.getPrice();
       }
    }
}
