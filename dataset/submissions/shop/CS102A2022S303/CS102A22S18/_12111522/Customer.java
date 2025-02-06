import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;

    private ArrayList<Product> shoppingCart;
    private ArrayList<Store> shoppingStore;
    private float wallet;

    public Customer(String name,float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
        this.shoppingStore=new ArrayList<>();
    }
   
    public boolean rateProduct(Product product,int rating){
        if (product.setRating(rating) )return true;
        else return false;
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){

        int index = store.getProductList().indexOf(product);

        if(index>=0  &&  product.getPrice() <= this.wallet){
            this.wallet-=product.getPrice();
            this.shoppingCart.add(product);
            this.shoppingStore.add(store);

            store.transact(product,0);

            return true;
        }else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
      switch (sortMethod){
          case Price:
            ArrayList<Product> newProduct = new ArrayList<>(this.shoppingCart);
              newProduct.sort(new SortByPrice());

              for (Product p:newProduct) {
                  System.out.println(p);
              }
              break;

          case Rating:
              ArrayList<Product> newProduct1 = new ArrayList<>(this.shoppingCart);
              newProduct1.sort(new SortByRating());

              for (Product p:newProduct1) {
                  System.out.println(p);
              }
              break;

          case PurchaseTime:
              for (Product p:shoppingCart) {
                  System.out.println(p);
              }
              break;
      }


    }

    public boolean refundProduct(Product product){
        int i = this.shoppingCart.indexOf(product);
        if(i>=0){
            wallet+=product.getPrice();
            shoppingStore.get(i).transact(product,1);
            shoppingCart.remove(product);
            shoppingStore.remove(shoppingStore.get(i));
            return true;
        }else{
            return false;
        }

    }

    public int compareID(Product O1,Product O2){
        int a=shoppingCart.indexOf(O1);
        int b=shoppingCart.indexOf(O2);
        return( a-b<0 ? 1 : -1);
    }


    public class SortByPrice implements Comparator<Product>{
        @Override
        public int compare(Product o1, Product o2){
            return (int)(100*( o1.getPrice()-o2.getPrice()));
        }

    }
    public class SortByRating implements Comparator<Product>{
        @Override
        public int compare(Product o1, Product o2){
            int out= (int)(1000*(o1.getAvgRating()-o2.getAvgRating()));
            if(out==0) out=compareID(o1, o2);
            return out ;
        }
    }

}



