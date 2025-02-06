import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        cnt = cnt +1;
        this.name = name;
        this.id = cnt;
        this.productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        cnt = cnt +1;
        this.id = cnt;
        this.name = name;
        this.income = income;
        this.productList = productList;
    }
        public boolean hasProduct(Product product) {
            int k = 0;
            for (int i = 0; i <= productList.size() - 1; i++) {
                if (product == productList.get(i)) {
                    k = 1;
                    break;
                }
            }
                if (k == 1) {
                    return true;
                } else {
                    return false;
                }

        }
        public boolean addProduct(Product product){
                int k = 0;
                for (int i = 0; i <= productList.size() - 1; i++) {
                    if (product == productList.get(i)) {
                        k = 1;
                        break;
                    }
                }
                    if(k == 1){
                        return false;
                    }
                    else{
                        productList.add(product);
                        return true;
                    }
            }
        public boolean removeProduct(Product product){
            int k = 0;
            for (int i = 0; i <= productList.size() - 1; i++) {
                if (product == productList.get(i)) {
                    k = 1;
                    productList.remove(product);
                    break;
                }
            }
            if(k == 1){
                return true;
            }
            else {
                return false;
            }

        }
        public ArrayList<Product> getProductList(){
        return productList;

        }
        public void transact(Product product, int method){
        if(method == 0){
            this.income = income + product.getPrice();
            productList.remove(product);
        }
        if(method == 1){
            this.income = income - product.getPrice();
            productList.add(product);
        }

        }








}
