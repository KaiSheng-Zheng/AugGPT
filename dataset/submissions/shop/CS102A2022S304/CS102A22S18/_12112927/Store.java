import java.util.ArrayList;

public class Store {
        private static int cnt;
        private int id;
        private String name;
        private ArrayList<Product> productList;
        private float income;

        public Store(String name) {
            cnt++;
            id = cnt;
            income = 0;
            productList = new ArrayList<>();
            this.name = name;
        }

        public Store(String name, ArrayList<Product> productList, float income) {
            cnt++;
            id = cnt;
            this.name = name;
            this.income = income;
            this.productList = productList;
            for (int i = 0; i < productList.size(); i++) {
                productList.get(i).setStore(this);
            }
        }

        public boolean hasProduct(Product product) {
            if (productList.indexOf(product) == -1) {
                return false;
            } else {
                return true;
            }
        }

        public boolean addProduct(Product product) {
            if (productList.indexOf(product) == -1) {
                product.setStore(this);
                productList.add(product);
                return true;
            } else {
                return false;
            }
        }

        public boolean removeProduct(Product product) {
            return productList.remove(product);
        }

        public ArrayList<Product> getProductList() {
            return productList;
        }

        public void transact(Product product, int method) {
            if (method == 0) {
                income += product.getPrice();
                removeProduct(product);
            } else if (method == 1){
                income -= product.getPrice();
                addProduct(product);
            }
        }

        public void Storerefund(Product product){
            transact(product,1);
        }
}
