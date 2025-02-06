import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name, float wallet) {
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
        public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }else return false;


        }
        public void updateWallet(float amount){
        this.wallet+=amount;

        }
        public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&product.get()<=wallet){
            
            wallet-=product.get();
            shoppingCart.add(product);
            store.transact(product,0);
            product.setStore(store);
            return true;
        }else return false;

        }
        public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case Price:
                ArrayList<Product>priceProducts=new ArrayList<>();
                ArrayList<Product>copyProducts=new ArrayList<>();
                copyProducts.addAll(shoppingCart);

                int p=0;
                for(int i=0;i<shoppingCart.size();i++){
                    float max=100000000;
                    for(int g=0;g<copyProducts.size();g++){
                        if(copyProducts.get(g).get()<max){
                            p=g;
                            max=copyProducts.get(g).get();
                        }


                    }
                    priceProducts.add(copyProducts.get(p));
                    copyProducts.remove(copyProducts.get(p));
                        }
                for (int i=0;i<priceProducts.size();i++){
                    System.out.println(priceProducts.get(i).toString());
                }

                break;
            case Rating:
                ArrayList<Product>rateProducts=new ArrayList<>();
                ArrayList<Product>CopyProducts=new ArrayList<>();
                CopyProducts.addAll(shoppingCart);

                int P=0;
                for(int i=0;i<shoppingCart.size();i++){
                    float min=10;
                    for(int g=0;g<CopyProducts.size();g++){
                        if(CopyProducts.get(g).getAvgRating()<min){
                            P=g;
                            min=CopyProducts.get(g).getAvgRating();
                        }


                    }
                    rateProducts.add(CopyProducts.get(P));
                    CopyProducts.remove(CopyProducts.get(P));
                }
                for (int i=0;i<rateProducts.size();i++){
                    System.out.println(rateProducts.get(i).toString());
                }

                break;
            case PurchaseTime:
                for (int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;


        }


        }
        public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+=product.get();
            product.getStore().transact(product,1);
            return  true;
        }else return false;

        }

}
