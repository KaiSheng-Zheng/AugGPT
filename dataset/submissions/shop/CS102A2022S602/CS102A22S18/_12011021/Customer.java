import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();

    private ArrayList<Store> storeCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt=cnt+1;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public float getWallet() {
        return wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet=wallet+amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if((store.hasProduct(product))&(this.getWallet()>=product.getPrice())){
            store.transact(product,0);
            this.shoppingCart.add(product);
            this.storeCart.add(store);
            this.updateWallet(-product.getPrice());
            return true;
        }else {
            return false;
        }
    }

    public boolean ownProduct(Product product){
        boolean own=false;
        for(int i=0;i<shoppingCart.size();i++){
            if(product.getId()==this.shoppingCart.get(i).getId()){
                own=true;
                break;
            }
        }
        return own;
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for(int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i));
                }
                break;
            case Rating:
                ArrayList<Product> Ratinglist=new ArrayList<>();
                Ratinglist.addAll(shoppingCart);
                boolean disorder1=true;
                while (disorder1) {
                    for (int i = 0; i < Ratinglist.size() - 1; i++) {
                        if (Ratinglist.get(i).getAvgRating() > Ratinglist.get(i + 1).getAvgRating()) {
                            Product middler = Ratinglist.get(i);
                            Ratinglist.remove(i);
                            Ratinglist.add(i + 1, middler);
                        }
                    }
                    int counter=0;
                    for(int i=0;i<Ratinglist.size()-1;i++){
                        if(Ratinglist.get(i).getAvgRating() > Ratinglist.get(i + 1).getAvgRating()){
                            counter++;
                        }
                    }
                    if(counter==0){
                        disorder1=false;
                    }
                }
                for(int i=0;i<Ratinglist.size();i++){
                    System.out.println(Ratinglist.get(i));
                }
                break;
            case Price:
                ArrayList<Product> Pricelist=new ArrayList<>();
                Pricelist.addAll(shoppingCart);
                boolean disorder2=true;
                while (disorder2) {
                    for (int i = 0; i < Pricelist.size() - 1; i++) {
                        if (Pricelist.get(i).getAvgRating() > Pricelist.get(i + 1).getAvgRating()) {
                            Product middler = Pricelist.get(i);
                            Pricelist.remove(i);
                            Pricelist.add(i + 1, middler);
                        }
                    }
                    int counter=0;
                    for(int i=0;i<Pricelist.size()-1;i++){
                        if(Pricelist.get(i).getAvgRating() > Pricelist.get(i + 1).getAvgRating()){
                            counter++;
                        }
                    }
                    if(counter==0){
                        disorder2=false;
                    }
                }
                for(int i=0;i<Pricelist.size();i++){
                    System.out.println(Pricelist.get(i));
                }
                break;
        }
    }

    public boolean refundProduct(Product product){
        if(this.ownProduct(product)){
            int location=0;
            for(int i=0;i<shoppingCart.size();i++){
                if(product.getId()==this.shoppingCart.get(i).getId()){
                    location=i;
                    break;
                }
            }
            this.storeCart.get(location).transact(product,1);
            shoppingCart.remove(location);
            storeCart.remove(location);
            this.updateWallet(product.getPrice());
            return true;
        }else {
            return false;
        }
    }
}