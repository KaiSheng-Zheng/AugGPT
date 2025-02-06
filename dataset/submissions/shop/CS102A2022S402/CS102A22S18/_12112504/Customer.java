import java.util.ArrayList;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private ArrayList<Store> shoppingStore = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }
        return false;
    }
    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        boolean haspro = false;
        for(int i = 0 ; i < store.getProductList().size() ; i ++){
            if(store.getProductList().get(i)==product){
                haspro = true;
            }
        }
        boolean hasmoney = true;
        if(product.getPrice() > wallet){
            hasmoney = false;
        }
        if(haspro&&hasmoney){
            store.transact(product,0);
            wallet-=product.getPrice();
            shoppingCart.add(product);
            shoppingStore.add(store);
            return true;
        }
        else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(shoppingCart==null){
            return;
        }
        if(sortMethod==SortBy.PurchaseTime){
            for(int i = 0 ; i < shoppingCart.size() ; i ++){
                System.out.println(shoppingCart.get(i));
            }
        }
        else if(sortMethod == SortBy.Rating){
            float[] ratings = new float[shoppingCart.size()];
            boolean alldone = false;

            for(int i = 0 ; i < shoppingCart.size() ; i ++){
                ratings[i]=shoppingCart.get(i).getAvgRating();
            }


            while(alldone == false){
                for(int i = 0 ; i < shoppingCart.size() ; i ++){
                    if(ratings[i]==1000000){
                        continue;
                    }
                    for(int t = 0 ; t < shoppingCart.size() ; t ++){
                        if(ratings[i]>ratings[t]){
                            break;
                        }
                        if(t==shoppingCart.size()-1){
                            System.out.println(shoppingCart.get(i));
                            ratings[i]=1000000;
                        }
                    }
                }
                for(int i = 0 ; i < shoppingCart.size() ; i ++){
                    if(ratings[i]==1000000){
                        if(i==shoppingCart.size()-1){
                            alldone = true;
                        }
                        continue;
                    }
                    else{
                        break;
                    }

                }
            }
        }

        else if(sortMethod == SortBy.Price){
            float[] prices = new float[shoppingCart.size()];
            boolean alldone = false;
            for(int i = 0 ; i < shoppingCart.size() ; i ++){
                prices[i]=shoppingCart.get(i).getPrice();
            }

            while(alldone == false){
                for(int i = 0 ; i < shoppingCart.size() ; i ++){
                    if(prices[i]==10000000){
                        continue;
                    }
                    for(int t = 0 ; t < shoppingCart.size() ; t ++){
                        if(prices[i]>prices[t]){
                            break;
                        }
                        if(t==shoppingCart.size()-1){
                            System.out.println(shoppingCart.get(i));
                            prices[i]=10000000;
                        }
                    }
                }
                for(int i = 0 ; i < shoppingCart.size() ; i ++){
                    if(prices[i]==10000000){
                        if(i==shoppingCart.size()-1){
                            alldone = true;
                        }
                        continue;
                    }
                    else{
                        break;
                    }

                }
            }
        }
    }
    public boolean refundProduct(Product product){
        boolean has = false;
        int listrank = 0;
        for(int i = 0 ; i < shoppingCart.size() ; i++){
            if (product == shoppingCart.get(i)){
                listrank = i;
                has = true;
                break;
            }
        }
        if(has == false){
            return false;
        }
        else{
            shoppingCart.remove(listrank);
            wallet+=product.getPrice();
            shoppingStore.get(listrank).transact(product,1);
            return true;
        }
    }
}