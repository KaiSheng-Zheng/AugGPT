

import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        
        if (rating>=1&&rating<=5){ shoppingCart.add(product);product.setRating(rating);return true;
        }else return false;

    }

    public void updateWallet(float amount){
        this.wallet+=amount;

    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)==true&&(this.wallet-product.getPrice()>=0)){
            wallet-=product.getPrice();shoppingCart.remove(product);
            return true;
        }else {boolean purchaseProduct=false;
            return purchaseProduct;
        }

    }
    public void viewShoppingCart(SortBy sortMethod){
        Product[] array=new Product[shoppingCart.size()];
        for (int i=0;i<shoppingCart.size();i++){

        }
        if (sortMethod==SortBy.PurchaseTime){
            int i ;
            for(i=0;i<shoppingCart.size();i++){
            System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod==SortBy.Rating){
            System.out.println();
        }

    }

}
