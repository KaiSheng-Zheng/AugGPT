import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    private ArrayList<Product> listOut = new ArrayList<>();

    public Store(String name){
        id=++cnt;
        this.name = name;
        this.income=0;
        productList = new ArrayList<>();

    }
    public Store(String name, ArrayList<Product> productList, float income){
        id=++cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;


    }

    public ArrayList<Product> getProductList(){return this.productList;}

    public boolean removeProduct(Product product){return this.productList.remove(product);}
    public boolean addProduct(Product product){return !hasProduct(product) && this.productList.add(product);}
    public boolean hasProduct(Product product){return this.productList.contains(product);}

    public void transact(Product product, int method){
        if (method == 0) {
            if (removeProduct(product)) {
              this.income += product.getPrice();
              this.listOut.add(product);
            }
        }
        else if (method == 1) {
            if (addProduct(product) && this.listOut.contains(product)) {
              this.income -= product.getPrice();
              this.listOut.remove(product);
            }
        }
    }

}


