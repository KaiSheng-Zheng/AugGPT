import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
       cnt++;
       id=cnt;
       this.name=name;
       income=0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        id=cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public float getIncome() {
        return income;
    }

    public boolean hasProduct(Product product){
        for (Product I:productList){
            if (I==product){return true;}
        }
        return false;
    }

    public boolean addProduct(Product product){
          if (!hasProduct(product)){
              productList.add(product);
              return true;
          }else {return false;}
    }

    public boolean removeProduct(Product product){
            for (int i=0;i<productList.size();i++){
                if (productList.get(i)==product){
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
        if (method==0){
            if(removeProduct(product)){
            income += product.getPrice();
            }
        }
        if (method==1){
            if (addProduct(product)){
            income -= product.getPrice();
            }
        }
    }
}
