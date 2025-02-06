import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        this.income=0;
        cnt++;
        this.id=cnt;
        this.productList=new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id=cnt;
    }
    public boolean hasProduct(Product product){
        boolean has=false;
        for (Product value : productList) {
            if (product.getId()==(value.getId())) {
                has = true;
                break;
            }
        }
        return has;
    }
    public boolean addProduct(Product product){
        boolean add=true;
        for (Product value : productList) {
            if (product.getId()==(value.getId())) {
                add=false;
                break;
            }
        }
        if (add){
            productList.add(product);
        }
        return add;
    }
    public boolean removeProduct(Product product) {
        boolean remove = false;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId() == productList.get(i).getId()) {
                this.productList.remove(i);
                remove = true;
                break;
            }
        }
        return remove;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income+=product.getPrice();
        }
        if (method==1){
            productList.add(product);
            income-= product.getPrice();
        }
    }
}