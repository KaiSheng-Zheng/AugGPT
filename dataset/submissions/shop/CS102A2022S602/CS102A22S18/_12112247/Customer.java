import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private ArrayList<Store>  productFromStore = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt+=1;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
          for(int i=0; i<store.getProductList().size() ; i++){
              if(store.hasProduct(product) && wallet>=product.getPrice()){
                  shoppingCart.add(product);
                  wallet-=product.getPrice();

                  store.transact(product,0);

                  productFromStore.add(store);
                  return true;
              }
          }
          return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for(int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Rating:
                Product[] sort1=new Product[shoppingCart.size()];
                for(int k=0 ; k<shoppingCart.size() ;k++){
                    sort1[k]=shoppingCart.get(k);
                }
                Product temp1;
                for(int i=0 ; i<sort1.length ; i++){
                    for(int j=i ; j< sort1.length-1 ; j++){
                        if(sort1[i].getAvgRating()>sort1[j+1].getAvgRating()){
                            temp1=sort1[j+1];
                            sort1[j+1]=sort1[i];
                            sort1[i]=temp1;
                        }
                    }
                }
                for (int k=0 ; k<sort1.length ; k++){
                    System.out.println(sort1[k].toString());
                }
                break;

            case Price:
                Product[] sort2=new Product[shoppingCart.size()];
                for(int k=0 ; k<shoppingCart.size() ;k++){
                    sort2[k]=shoppingCart.get(k);
                }
                Product temp2;
                for(int i=0 ; i<sort2.length ; i++){
                    for(int j=i ; j< sort2.length-1 ; j++){
                        if(sort2[i].getPrice()>sort2[j+1].getPrice()){
                            temp2=sort2[j+1];
                            sort2[j+1]=sort2[i];
                            sort2[i]=temp2;
                        }
                    }
                }
                for (int k=0 ; k<sort2.length ; k++){
                    System.out.println(sort2[k].toString());
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        for(int i=0 ; i<shoppingCart.size() ; i++){
            if(product.equals(shoppingCart.get(i))){
                shoppingCart.remove(i);
                wallet+=product.getPrice();

                productFromStore.get(i).transact(product,1);

                productFromStore.remove(i);
                return true;
            }
        }
        return false;
    }

}
