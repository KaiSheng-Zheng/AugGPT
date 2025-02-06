        import java.lang.reflect.Array;
        import java.util.ArrayList;

        public class Store {
            private static int cnt=0;
            private int id;
            private String name;
            private ArrayList<Product>productList;
            private float income;

            public Store(String name)
            {this.name=name;
                cnt++;
                id=cnt;
                this.productList=new ArrayList<Product>();
                income=0;
            }

            public Store(String name, ArrayList<Product>productList, float income){
                this.name=name;
                this.productList=productList;
                this.income=income;
                cnt++;
                this.id=cnt;
            }
            public boolean hasProduct(Product product){
                int counter=0;
                for (int i=0;i<productList.size();i++){
                    if (product.getId()==productList.get(i).getId()){
                        counter++;
                    }
                    else {
                        counter=counter;
                    }
                }
                if (counter!=0){
                    return true;
                }
                else {
                    return false;
                }
            }
            public boolean addProduct(Product product){
                int counter=0;
                for (int i=0;i<productList.size();i++){
                    if (product.getId()==productList.get(i).getId()){
                        counter++;
                    }
                }
                if (counter!=0){
                    return false;
                }
                else {
                    productList.add(product);
                    return true;
                }
            }
            public boolean removeProduct(Product product){
                int counter=0;

                for (int i=0;i<productList.size();i++){
                    if (product.getId()==productList.get(i).getId()){
                        counter++;
                    }
                }
                if (counter!=0){
                    productList.remove(product);
                    return true;
                }
                else {
                    return false;
                }
            }

            public ArrayList<Product> getProductList(){
                return productList;
            }
            public void transact(Product product,int method){
                if (method==0){
                    this.productList.remove(product);
                    this.income+=product.getPrice();
                }
                else if (method==1){
                    this.productList.add(product);
                    this.income-=product.getPrice();
                }
            }

        }
