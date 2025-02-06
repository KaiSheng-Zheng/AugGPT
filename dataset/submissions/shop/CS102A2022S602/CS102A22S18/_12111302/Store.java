import java.util.ArrayList;
public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name)
    {
        this.name=name;
        this.income=0;
        this.productList=new ArrayList<>();
        cnt++;
        this.id=cnt;

    }
    public Store(String name, ArrayList<Product> productList, float income)
    {
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        this.id=cnt;
    }
    public boolean hasProduct(Product product)
    {
//        int counter=0;
//         for(int i=1;i< productList.size();i++){
//             if(product==productList.get(i)){counter=1;}
//         }
         if(productList.contains(product)==true)  return true;
         else return false;
    }
    public boolean addProduct(Product product)
    {

        if(productList.contains(product)==false)
    {productList.add(product);  return true;}
        else return false;
    }
    public boolean removeProduct(Product product)
    {
        if(productList.contains(product)==true)
    {productList.remove(product);  return true;}
    else return false;
    }
    public ArrayList<Product> getProductList()
    {
              return productList;
    }
    public void transact(Product product, int method)
    {
              if(method==0){
                  this.income+=product.getPrice();
                  productList.remove(product);
              }
              if(method==1){
                  productList.add(product);
                  this.income-= product.getPrice();
              }
    }

}
