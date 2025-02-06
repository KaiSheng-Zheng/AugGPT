
    import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private ArrayList<Store> storeCart=new ArrayList<>();

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        boolean rateProduct=product.setRating(rating);
        return  rateProduct;
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }


    public boolean purchaseProduct(Store store, Product product){
        boolean purchaseProduct;

        if(this.wallet- product.getPrice()>=0&& store.hasProduct(product)){
            purchaseProduct=true;
            updateWallet(-product.getPrice());
            store.transact(product,0);
            this.shoppingCart.add(product);
            this.storeCart.add(store);
        }else {
            purchaseProduct=false;
        }
        return purchaseProduct;
    }


    public void viewShoppingCart(SortBy sortMethod){
        int l=this.shoppingCart.size();
        switch (sortMethod){
            case PurchaseTime:
                for(int i=0;i<l;i++){
                    System.out.println(this.shoppingCart.get(i));
                }
                break;
            case Rating:
                Product[] products=new Product[l];
                for(int i=0;i<l;i++){
                    products[i]=this.shoppingCart.get(i);
                }
                Product product=new Product("",0);
                for(int i=0;i<l;i++){
                    for(int j=i;j<l;j++){
                        if(products[j].getAvgRating()< products[i].getAvgRating()){
                            product=products[i];
                            products[i]=products[j];
                            products[j]=product;
                        }
                    }
                }
                for(int i=0;i<l;i++){
                    System.out.println(products[i]);
                }
                break;
            case Price:
                products=new Product[l];
                for(int i=0;i<l;i++){
                    products[i]=this.shoppingCart.get(i);
                }
                for(int i=0;i<l;i++){
                    for(int j=i+1;j<l;j++){
                        if(products[j].getPrice()< products[i].getPrice()){
                            product=products[i];
                            products[i]=products[j];
                            products[j]=product;
                        }
                    }
                }
                for(int i=0;i<l;i++){
                    System.out.println(products[i]);
                }
                break;

        }
    }


    public boolean refundProduct(Product product){
         boolean refundProduct=false;
        int n;
        for(int i=0;i<this.shoppingCart.size();i++){
            if (product.getId()==this.shoppingCart.get(i).getId()){
                n=i;
                refundProduct=true;
                this.shoppingCart.remove(n);
                this.wallet+= product.getPrice();
                this.storeCart.get(n).transact(product,1);
                this.storeCart.remove(n);
            }
        }
        return refundProduct;
    }
}
