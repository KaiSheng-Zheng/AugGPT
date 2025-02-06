import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    private HashMap<Integer,Boolean> HashMap;


    public Store(String name){
        id=++cnt;
        this.name=name;
        income=0;
        productList=new ArrayList<>();
        HashMap=new HashMap<>();

    }
    public Store(String name, ArrayList<Product> productList, float income){
        id=++cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
        HashMap=new HashMap<>();
        int i = 0;
        while (i < productList.size()) {
            Product product;
            product = productList.get(i);
            Boolean put = HashMap.put(product.getId(), true);
            i++;
        }
    }

    public boolean hasProduct(Product product){
        return HashMap.containsKey(product.getId());
    }
    public boolean addProduct(Product product){
        if(HashMap.containsKey(product.getId())){
            return false;
        }else {
            Boolean put;
            put = HashMap.put(product.getId(), true);
            boolean add;
            add = productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(HashMap.containsKey(product.getId())){
            Boolean remove1;
            remove1 = HashMap.remove(product.getId());
            boolean remove;
            remove = productList.remove(product);
            return true;
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;

    }
    public void transact(Product product, int method){
        switch (method) {
            case 0:
                removeProduct(product); income += product.getPrice();
                break;
            case 1:
                addProduct(product);income -= product.getPrice();
                break;
        }

    }

}
