import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
        this.income = 0f;
        cnt++;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if(!hasProduct(product)){
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
        switch(method){
            case 0:{
                if(this.removeProduct(product)) {
                    this.income += product.getPrice();
                }
                break;
            }
            case 1:{
                this.addProduct(product);
                this.income -= product.getPrice();
                break;
            }
            default: break;
        }
    }

    public static void main(String[] args) {
        Product producta = new Product("a",100f);
        Product productb = new Product("a", 100f);
        Store a = new Store("a");
        a.addProduct(producta);
        a.transact(productb,0);
        System.out.println(a.income);
        a.transact(producta,0);
        System.out.println(a.income);
    }
}
