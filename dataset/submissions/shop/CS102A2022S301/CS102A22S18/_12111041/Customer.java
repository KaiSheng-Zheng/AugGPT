import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet;
    private ArrayList<Store> storeList=new ArrayList<Store>();

    public Customer(String name, float wallet) {
        cnt++;
        id=cnt;
        this.name = name;
        this.wallet = wallet;
    }


    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else return false;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() <= wallet) {
            store.transact(product,0);
            shoppingCart.add(product);
            storeList.add(store);
            updateWallet(-product.getPrice());
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> newProducts = new ArrayList<>(shoppingCart);
        if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < newProducts.size()-1 ; i++) {
                for (int j = 0; j < newProducts.size()-1; j++) {
                    if(newProducts.get(i).getAvgRating()>newProducts.get(i+1).getAvgRating()||(newProducts.get(i).getAvgRating()==newProducts.get(i+1).getAvgRating()&&newProducts.get(i).getId()>newProducts.get(i+1).getId())){
                        Product temp=newProducts.get(i);
                        newProducts.set(i,newProducts.get(i+1));
                        newProducts.set(i+1,temp);
                    }
                }
            }
        }
        if (sortMethod == SortBy.Price) {
            for (int i = 0; i < newProducts.size()-1 ; i++) {
                for (int j = 0; j < newProducts.size()-1; j++) {
                    if(newProducts.get(i).getPrice()>newProducts.get(i+1).getPrice()||(newProducts.get(i).getAvgRating()==newProducts.get(i+1).getAvgRating()&&newProducts.get(i).getId()>newProducts.get(i+1).getId())){
                        Product temp=newProducts.get(i);
                        newProducts.set(i,newProducts.get(i+1));
                        newProducts.set(i+1,temp);
                    }
                }
            }
        }
        for (int i = 0; i < newProducts.size(); i++) {
            System.out.println(newProducts.get(i));
        }
        }
     public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            Store store=storeList.get(shoppingCart.indexOf(product));
            storeList.remove(shoppingCart.indexOf(product));
            store.transact(product,1);
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        }
        else return false;
     }
    }
