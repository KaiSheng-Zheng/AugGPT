    import java.util.ArrayList;

    public class Product{
        private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
        private int id;  // unique for each product and the value is set to cnt.
        private String name;
        private float price;
        private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
        public int order;
        public Store belongedTo;

        public Product(String name, float price){
            cnt++;
            this.id=cnt;
            this.name=name;
            this.price=price;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public float getPrice() {
            return price;
        }

        public boolean setRating(int rating){
            if(rating>5||rating<1) return false;
            ratings.add(rating);
            return true;
        }


        public float getAvgRating(){
            if(ratings.size()==0)
                return 0.00f;
            float tot=0.00f;
            for (Integer rating : ratings) {
                tot += rating;
            }
            return tot/ratings.size();
        }


        public String toString(){
            return "Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
        }

    }
