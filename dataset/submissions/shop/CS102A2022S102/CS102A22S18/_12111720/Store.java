import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        id = cnt;
        this.name = name;
        income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product){
        if (productList.size() == 0){
            return false;
        }else {
            boolean valid = false;
            int id = product.getId();
            for (Product i : productList) {
                if (i.getId() == id) {
                    valid = true;
                    break;
                }
            }
            return valid;
        }
    }

    public boolean addProduct(Product product){
        boolean valid = true;
        if (productList.size() == 0){
            productList.add(product);
            product.setStore(this);
            return true;
        }else {
            int[] productId = new int[productList.size()];
            for (int i = 0; i < productId.length; i++) {
                productId[i] = productList.get(i).getId();
            }
            for (int i : productId) {
                if (product.getId() == i) {
                    valid = false;
                    break;
                }
            }
            if (valid){
                productList.add(product);
                product.setStore(this);
                return true;
            }else {
                return false;
            }
        }

    }

    public boolean removeProduct(Product product){
        boolean valid = false;
        int id = product.getId();
        for (Product i : productList){
            if (i.getId() == id){
                productList.remove(i);
                valid = true;
                break;
            }
        }
        return valid;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        switch (method){
            case 0 :
                int id = product.getId();
                for (Product i : productList) {
                    if (i.getId() == id) {
                        removeProduct(product);
                        income += product.getPrice();
                        break;
                    }
                }
                break;
            case 1 :
                boolean valid = true;
                for (Product i : productList){
                    if (i.getId() == product.getId()){
                        valid = false;
                        break;
                    }
                }
                if (valid){
                    addProduct(product);
                    income -= product.getPrice();
                }
                break;

        }
    }
}
