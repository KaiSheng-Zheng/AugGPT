import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;cnt++;id=cnt;income=0;
    };
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;cnt++;id=cnt;this.income=income;
        for (int i = 0; i < productList.size(); i++) {
            this.productList.add(productList.get(i));
        }
    };
    public boolean hasProduct(Product product){
        boolean e=false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==product.getId()){e=true;break;}
        }
        return e;
    };
    public boolean addProduct(Product product){
        boolean e=true;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==product.getId()){e=false;break;}
        }
        if (e){productList.add(product);}
        return e;
    };
    public boolean removeProduct(Product product){
        boolean e=false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==product.getId()) {
                productList.remove(i);e=true;break;
            }
        }
      return e;
    };
    public ArrayList<Product> getProductList(){
        return productList;
    };
    public void transact(Product product, int method){
        switch (method){
            case 0:{
                if (hasProduct(product)){removeProduct(product);income+=product.getPrice();}break;
            }
            case 1:{
                if (!hasProduct(product)){productList.add(product);income-= product.getPrice();}break;
            }
        }
    };
}
