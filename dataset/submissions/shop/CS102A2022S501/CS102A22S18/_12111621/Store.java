import java.util.ArrayList;

 public class Store{
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        this.name=name;
        id=cnt;
    }
     public Store(String name, ArrayList<Product> productList, float income){
         cnt++;
         id=cnt;
         this.name=name;
         this.income=income;
         this.productList=productList;
         for(int i=0;i<productList.size();i++){
             productList.get(i).setSd(this);
         }
     }

        public boolean hasProduct(Product product){
       boolean a;
       int q=0;
       for(int i=0;i<productList.size();i++){
           if(productList.get(i)==product)
               q=1;
       }       if(q==1)
           a=true;
       else
           a=false;
       return a;
        }
        public boolean addProduct(Product product){
              if(hasProduct(product)==false){
                  product.setSd(this);
                  productList.add(product);
              return true;
              }
              else
                  return false;
        }
        public boolean removeProduct(Product product){
            if(hasProduct(product)==true){
                productList.remove(product);
                return true;
            }
            else
                return false;
        }
        public ArrayList<Product> getProductList(){
        return productList;
        }
        public void transact(Product product, int method){
        if(method==0){
            productList.remove(product);
            income+=product.getPrice();
        }
            if(method==1){
                productList.add(product);
                income-=product.getPrice();
            }
        }



}
