import  java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private  ArrayList<Store> stores;

    public Customer(String name, float wallet){
        cnt ++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        stores = new ArrayList<>();
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            shoppingCart.add(product);
            wallet -= product.getPrice();
            stores.add(store);
            store.transact(product,0);
            return true;
        }else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            case Price:
                ArrayList<Product> productsPrice = shoppingCart;
                for (int i = 0; i < shoppingCart.size()-1; i++) {
                    for (int j = 0; j < shoppingCart.size()- 1- i; j++) {
                        if(productsPrice.get(j).getPrice() > productsPrice.get(j+1).getPrice()){
                            Product n1 = productsPrice.get(j+1);
                            Product n2 = productsPrice.get(j);
                            productsPrice.set(j,n1);
                            productsPrice.set(j+1,n2);
                        }
                    }
                }
                for (int i = 0; i < productsPrice.size(); i++) {
                    System.out.println(productsPrice.get(i));
                }
                break;
            case Rating:
                ArrayList<Product> productsRating = shoppingCart;
                for (int i = 0; i < shoppingCart.size()-1; i++) {
                    for (int j = 0; j < shoppingCart.size() -1 -i; j++) {
                        if(productsRating.get(j).getAvgRating() > productsRating.get(j+1).getAvgRating()){
                            Product n1 = productsRating.get(j+1);
                            Product n2 = productsRating.get(j);
                            productsRating.set(j,n1);
                            productsRating.set(j+1,n2);
                        }
                    }
                }
                for (int i = 0; i < productsRating.size(); i++) {
                    System.out.println(productsRating.get(i));
                }
        }
    }

    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            int n = shoppingCart.indexOf(product);
            shoppingCart.remove(product);
            wallet += product.getPrice();
            stores.get(n).transact(product,1);
            stores.remove(n);
            return true;
        }else{
            return false;
        }
    }
}