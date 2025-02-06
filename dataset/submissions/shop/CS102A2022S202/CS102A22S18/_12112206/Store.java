import java.util.ArrayList;
class Store{

    private static int cnt =0 ; 
    
    private int id; 
    private String name ;
    private ArrayList<Product> productList ;
    private float income ;


    public Store (String name){       this.name = name       ;  cnt++;  id =cnt;        }
    public Store (String name, ArrayList<Product> productList, float income){
    id= cnt;
    this.name = name;
    this.productList = productList;
    this.income = income;
    cnt++;


    };




    public boolean hasProduct(Product product){
        
        if(productList.contains(product)==true)
        return true;

        else return false;
    }

    public boolean addProduct(Product product)
    {
        if(productList.contains(product)==false)
    {productList.add(product);
        return true;}
    
    else return false;
    }


    public boolean removeProduct(Product product){
    if (productList.contains(product)==true)

    {productList.remove(product);
        return true;
    }

    else return false;

    }


    public ArrayList<Product> getProductList(){
        return this.productList;
    }


    public void transact(Product product, int method)
    {
        if (method ==0)   
        {productList.remove(product);                                          
    income += product.getprice(product);}

    else 

income-= product.getprice(product);
productList.add(product);

    }


    
       



}























