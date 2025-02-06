import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id ;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    public ArrayList<Product> boughtProduct=new ArrayList<>();
    private float income;
    public Store (String name) {
        this.name = name;
        cnt++;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }
    public boolean hasProduct(Product product){
        int a = 0;
        if(productList.size()!=0) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() == product.getId())
                    a = 1;
            }
        }
        if(a==1)
            return true;
        else
            return false;
    }
    public boolean addProduct(Product product){
        if(hasProduct(product))
            return false;
         else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }else
            return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method == 0){
            productList.remove(product);
            income += product.getPrice();
            boughtProduct.add(product);
        }
        if(method == 1){
            productList.add(product);
            income -= product.getPrice();
        }
    }

}
