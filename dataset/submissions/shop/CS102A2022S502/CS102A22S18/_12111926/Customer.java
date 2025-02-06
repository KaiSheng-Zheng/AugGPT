import java.util.ArrayList;

import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Product> storess;
    public Customer(String name, float wallet){
        this.name=name; this.wallet=wallet;
        cnt++;
        this.id=cnt;
        this.shoppingCart=new ArrayList<>();
        this.storess=new ArrayList<Product>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet>=product.getPrice()){
          this.wallet-= product.getPrice();
            this.shoppingCart.add(product);
            store.removeProduct(product);
            float b=store.getIncome()+ product.getPrice();
            store.setIncome(b);

            return true;
        }else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
  if (sortMethod == SortBy.Price){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice()-o2.getPrice());
                }
            });
            for (Product product:shoppingCart){
                System.out.println(product);
            }
        }

        else if (sortMethod == SortBy.PurchaseTime){
            for (Product product:shoppingCart){
                System.out.println(product);
            }
        }

        else if (sortMethod == SortBy.Rating){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice()-o2.getPrice());
                }
            });
            for (Product product:shoppingCart){
                System.out.println(product);
            }
        }
       }
    public boolean refundProduct(Product product) {
        int j =0;
        for(int i=0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i).equals(product)){
                j++;
            }
        }
        if(j>=1){
            this.wallet+= product.getPrice();
            this.shoppingCart.remove(product);


            return true;

        }else {
            return false;
        }
    }

}