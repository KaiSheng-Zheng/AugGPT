 import java.util.ArrayList;

    public class Store {

        private static int cnt = 0;
        private int id;
        private String name;
        private ArrayList<Product> productList = new ArrayList<>();
        private float income;

        private ArrayList<Product> list = new ArrayList<>();

        public Store(String name) {
            cnt++;
            this.id = Store.cnt;
            this.name = name;
            this.income = 0;
        }

        public Store(String name, ArrayList<Product> productList, float income) {
            cnt++;
            this.id = Store.cnt;
            this.name = name;
            this.productList = productList;
            this.income = income;
        }

        public boolean hasProduct(Product product) {
            return this.productList.contains(product);
        }

        public boolean addProduct(Product product) {
            if (hasProduct(product)){return false;}
            this.productList.add(product);
            return true;
        }

        public boolean removeProduct(Product product) {
            if (!hasProduct(product)){return false;}
            this.productList.remove(product);
            return true;
        }

        public ArrayList<Product> getProductList() {
            return this.productList;
        }

        public void transact(Product product, int method) {
            if (method == 0) {
                if (removeProduct(product)) {
                    this.income += product.getPrice();
                    this.list.add(product);
                }
            } else if (method == 1) {
                if ( addProduct(product)&&this.list.contains(product)) {
                    this.income -= product.getPrice();
                    this.list.remove(product);
                }
            }
        }

    }
