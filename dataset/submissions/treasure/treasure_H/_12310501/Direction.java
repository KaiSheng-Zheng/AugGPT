enum Direction {
   RIGHT(0,1),
   LEFT(0,-1),
   UP(-1,0),
   DOWN(1,0); 
   
   private final int rowChange;
   private final int colChange;

   Direction(int rowChange, int colChange){
      this.rowChange = rowChange;
      this.colChange = colChange;
   }

   public int getRowChange(){ return this.rowChange; }
   public int getColChange(){ return this.colChange; }
}
