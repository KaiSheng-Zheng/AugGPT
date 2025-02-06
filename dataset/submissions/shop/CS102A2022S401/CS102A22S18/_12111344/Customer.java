import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
    public class Customer {
        private static int cnt;
        private int id;
        private String name;
        private ArrayList<Product> shoppingCart=new ArrayList<>();
        private float wallet;
        public Customer(String name, float wallet){
            cnt+=1;
            id=cnt;
            this.name = name;
            this.wallet = wallet;
        }
        public boolean rateProduct(Product product, int rating){
            if(rating==1||rating==2||rating==3||rating==4||rating==5){
                product.setRating(rating);
            return true;
            }else{
                return false;}
        }
        public void updateWallet(float amount){
            this.wallet = wallet+amount;
        }
        public boolean purchaseProduct(Store store, Product product){
            if(store.hasProduct(product)& wallet>= product.getPrice()){
                float price=-product.getPrice();
                store.getProductList().remove(product);
                updateWallet(price);
                shoppingCart.add(product);
                store.transact(product,0);
                return true;
            }else {
                return false;
            }
        }
        public void viewShoppingCart(SortBy sortMethod){
            if(sortMethod.equals(SortBy.PurchaseTime)){
                for(int i=0; i<shoppingCart.size(); i++)
                    System.out.println(shoppingCart.get(i).toString());
            }
            if(sortMethod.equals(SortBy.Price)) {
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getPrice()>o2.getPrice()){
                        return 1;
                    }
                    if(o1.getPrice()< o2.getPrice()){return -1;}
                    else{return 0;}
                }

            });
            for(int i=0; i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
            }
            if(sortMethod.equals(SortBy.Rating)) {
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getAvgRating()>o2.getAvgRating()){
                        return 1;
                    }
                    if(o1.getAvgRating()< o2.getAvgRating()){return -1;}
                    else{return 0;}
                }
            });
            for(int i=0; i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
            }
        }
        public boolean refundProduct(Store store,Product product){
            if(shoppingCart.contains(product)){
                updateWallet(product.getPrice());
                shoppingCart.remove(product);
                store.transact(product,1);
                return true;}
            else{return false;}

        }

    }
