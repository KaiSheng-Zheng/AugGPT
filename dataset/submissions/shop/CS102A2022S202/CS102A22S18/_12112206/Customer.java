import java.util.ArrayList;

class Customer{

    private static int cnt=0; 
    
    private int id ; 
    private String name;
    private ArrayList<Product> shoppingCart; 
    
    private float wallet;

   
       
       



    public Customer(String name, float wallet)
    {this.name = name;this.wallet=wallet;cnt++;id = cnt;}


    public boolean rateProduct(Product product, int rating){
    
        if (rating>5&&rating<1) return false;
    else return true; 
    

    }

    public void updateWallet(float amount){
    
        wallet+=amount;

    }

    public boolean purchaseProduct(Store store, Product product){
if (wallet>=product.getprice(product)&&store.hasProduct(product)==true)
 
 wallet-=product.getprice(product);  shoppingCart.add(product) ;
 return true;
 

  
    };

    public void viewShoppingCart(SortBy sortMethod){


    };

   
    public boolean refundProduct(Product product){return true; }





}