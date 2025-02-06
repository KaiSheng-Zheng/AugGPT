


import java.util.ArrayList;

public class Product {
	private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
	private int id; // unique for each product and the value is set to cnt.
	private String name;
	private float price;
	private ArrayList<Integer> ratings=new ArrayList<>(0);// ratings from different customers; default is empty.
	public Product(String name, float price) {
		cnt++;
		this.id=cnt;
		this.name=name;
		this.price = price;
		
	}
	public boolean setRating(int rating){
		if(rating <=5&&rating>=1) {
			this.ratings.add(rating);
			return true;}
		else {
			return false;
		}
	}
	public float getAvgRating(){
		int l = ratings.size();
		
            float sum = 0;
            float avg= 0.0f;
            for (int i =0;i< l;i++) {
                sum = sum + ratings.get(i);
            }
            avg = sum / l;
           int Avg=(int)avg*100;
           float last = Avg /100;
            return last;
	}

    public String getName() {return name;}
    public int getId() {return id;}
    public float getPrice() {return price;}


    public float againgetAvgRating() {
    	int l = ratings.size();
    	
        if (l != 0) {
            float sum = 0;
            float avg = 0.0f;
            for (int i =0;i< l;i++) {
                sum = sum + ratings.get(i);
            }
            avg = sum / l;
            return avg;
        }else{
            return  0;
        }
    }

	public String toString(){
		String answer = "";
		String id2 ="Product ID "+id+", ";
		String name2 =" "+name+", ";
		String rmb2="RMB "+price+", ";
		String avg2 = "Rating "+getAvgRating();
		answer = id2+name2+rmb2+avg2;
		return answer;
	}


}

