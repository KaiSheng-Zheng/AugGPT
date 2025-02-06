import java.util.ArrayList;
public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Product> shoppingCartR = new ArrayList<>();
    private ArrayList<Product> shoppingCartP = new ArrayList<>();
    private ArrayList<Store> stores = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }else{
            return false;
        }
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet>= product.getPrice()){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            stores.add(store);
            store.transact(product,0);
            return true;
        }else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> cartCopy = new ArrayList<>();
        for(Product product:shoppingCart){
            cartCopy.add(product);
        }
        switch(sortMethod){
            case PurchaseTime:{
                for(Product product : shoppingCart){
                    System.out.println(product);
                }
                break;
            }
            case Rating:{
//                for(Product product:shoppingCart){
//                    getR(product);
//                }
//                for(Product product : shoppingCartR){
//                    System.out.println(product);
//                }
                ArrayList<Product> cartRating = new ArrayList<>();
                while(cartCopy.size()>0){
                    Product minRating = new Product("min",0f);
                    minRating.setRating(5);
                    for(int i = cartCopy.size() - 1; i >= 0; i--){
                        Product product = cartCopy.get(i);
                        if(product.getAvgRating() <= minRating.getAvgRating()){
                            minRating = product;
                        }
                    }
                    cartCopy.remove(minRating);
                    cartRating.add(minRating);
                }
                for(Product product : cartRating){
                    System.out.println(product);
                }
                break;
            }
            case Price:{
//                for(Product product:shoppingCart){
//                    getP(product);
//                }
//                for(Product product : shoppingCartP){
//                    System.out.println(product);
//                }
                ArrayList<Product> cartPrice = new ArrayList<>();
                while(cartCopy.size()>0){
                    Product maxPrize = new Product("max",0f);
                    for(Product product : cartCopy){
                        if(product.getPrice() >= maxPrize.getPrice()){
                            maxPrize = product;
                        }
                    }
                    cartCopy.remove(maxPrize);
                    cartPrice.add(maxPrize);
                }

                for(int i = cartPrice.size()-1; i>=0; i--){
                    Product product = cartPrice.get(i);
                    System.out.println(product);
                }
                break;
            }
            default: break;
        }
    }

    public boolean hasProduct(Product product){
        return shoppingCart.contains(product);
    }

    public boolean refundProduct(Product product){
        if(hasProduct(product)){
            int index = shoppingCart.indexOf(product);
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            stores.get(index).transact(product,1);
            stores.remove(index);
            return true;
        }else{
            return false;
        }
    }

}

