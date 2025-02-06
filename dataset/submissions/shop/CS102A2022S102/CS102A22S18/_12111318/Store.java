

import java.util.ArrayList;
    public class Store {
        private static int cnt;
        private int id;
        private float income;
        private String name;
        private ArrayList<Product> productList=new ArrayList<>();


        public Store(String name) {
            this.name=name;
            this.income=0;
            cnt++;
            id=cnt;

        }
        //reload
        public Store(String name,ArrayList<Product> productList,float income) {
            this.name=name;
            this.income=income;
            this.productList=productList;
            cnt++;
            id=cnt;
        }
        public boolean removeProduct(Product product){
            for(int m=0;m<productList.size();m++) {
                if (product.getId() == productList.get(m).getId()) {
                    productList.remove(m);
                    return true;
                }
            }
            return false;
        }
        //shang
        public boolean addProduct(Product product) {
            int sizeOfPro=productList.size();
            for(int m=0;m<sizeOfPro;m++) {
                if (product.getId() == productList.get(m).getId()) {
                    return false;
                }
            }
            productList.add(product);
            return true;
        }


        public boolean hasProduct(Product product) {
            for(int m=0;m<productList.size();m++) {
                if (productList.get(m).getId() == product.getId()) {
                    return true;
                }
            }
            return false;
        }

        public ArrayList<Product> getProductList() {
            return productList;
        }

        public void transact(Product product,int method){
            if(method==1) {
                addProduct(product);
                income-=product.getPrice();
            }
            if(method==0) {
                removeProduct(product);
                income+=product.getPrice();

            }
        }

        public void printOut(){
            System.out.println(id);
            System.out.println(name);
            System.out.println(income);
        }
       //Thats has been changed
    }

