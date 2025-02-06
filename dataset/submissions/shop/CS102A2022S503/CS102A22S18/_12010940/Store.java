import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        income = 0;
        id = cnt;
        this.name = name;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id = cnt;
        this.name = name;
        this.income = income;
        for(int i = 0; i < productList.size(); i++){
            this.productList.add(productList.get(i));
        }

    }
    public boolean hasProduct(Product product){
        boolean has = false;
        for(int i = 0; i < productList.size(); i++){
            if(this.productList.get(i).equal(product)){
                has = true;
            }
        }
        return has;
    }

    public boolean addProduct(Product product){
        boolean succeed = true;
        if(productList.size() == 0){
            productList.add(product);
        } else{
            if(this.hasProduct(product)){
                succeed = false;
            } else {
                productList.add(product);
            }
        }
        return succeed;
    }

    public boolean removeProduct(Product product){
        boolean remove = false;
        if (hasProduct(product)) {
            productList.remove(product);
            remove = true;
        }
        return remove;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        switch (method){
            case 0:
                productList.remove(product);
                income += product.getPrice();
                break;
            case 1:
                productList.add(product);
                income -= product.getPrice();
        }
    }
}
