    import java.util.ArrayList;

    public class Store {
        private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
        private int id;  // unique for each store and the value is set to cnt.
        private String name;
        private ArrayList<Product> productList = new ArrayList<>();
        private float income;
        public Store(String name){
            cnt++;
            this.name=name;
            id=cnt;
            income =0;
           // One for constructing a new store, with income = 0 and nothing in the productList.
           // The id of the first store is 1. The given income and productListare always valid.
        }
        public Store(String name, ArrayList<Product> productList, float income){
            this.name=name;
            cnt++;
            id=cnt;
            this.income=income;
            this.productList=productList;
            //The other constructs an existing store with given income and productList.
        }
        public boolean hasProduct(Product product){
            if(productList.contains(product)){return true;}
            else{ return false;}
        }
        public boolean addProduct(Product product){
            if(productList.contains(product)){return false;}
            else{ productList.add(product);return true;}
        }

        public static int getCnt() {
            return cnt;
        }

        public static void setCnt(int cnt) {
            Store.cnt = cnt;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setProductList(ArrayList<Product> productList) {
            this.productList = productList;
        }

        public float getIncome() {
            return income;
        }

        public void setIncome(float income) {
            this.income = income;
        }

        public boolean removeProduct(Product product){
            if(productList.contains(product)){productList.remove(product); return true;}
            else{return false;}
        }
        public ArrayList<Product> getProductList(){
            return productList;
        }
        public void transact(Product product, int method){
            if(method==0){
                productList.remove(product);
                income+=product.getPrice();
            }
            if(method==1){
                productList.add(product);
                income-=product.getPrice();
            }
        }
    }
