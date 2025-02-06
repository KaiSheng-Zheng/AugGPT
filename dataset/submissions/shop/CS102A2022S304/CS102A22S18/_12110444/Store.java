import java.util.ArrayList;

public class Store {
        private static int cnt=0;
        private int id;
        private String name;
        private ArrayList<Product> productList=new ArrayList<>();
        private float income;

        public Store(String name){
            this.name=name;
            this.income=0;
            cnt=cnt+1;
            this.id=cnt;
        }
        public Store(String name,ArrayList<Product> productList,float income){
            this.name=name;
            this.income=income;
            this.productList=productList;
            Store.cnt++;
            this.id= Store.cnt;
        }
        public boolean hasProduct(Product product){
            if(this.productList.contains(product)){
                return true;
            }
            else return false;
        }
        public boolean addProduct(Product product) {
            if (this.productList.contains(product)) {
                return false;
            } else {
                this.productList.add(product);
                return true;
            }
        }

        public boolean removeProduct(Product product) {
                return productList.remove(product);
            }
        public ArrayList<Product> getProductList(){
            return productList;
        }
        public void transact(Product product, int method){
            switch(method){
                case 0:
                    if(productList.contains(product)&&this.productList.remove(product)){
                    this.income=this.income+product.getPrice();
                    }
                    break;
                case 1:
                    this.productList.add(product);
                    this.income=this.income-product.getPrice();
                    break;
            }
        }

    }

