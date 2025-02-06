import java.util.ArrayList;
 import java.util.List;

public  abstract class ChessComponent {
    private ChessboardPoint source;

    public ChessboardPoint getSource() {
        return source;
    }

    private ChessColor chessColor;
    protected char name;
    static ChessComponent[][] chessboard ;
    public ChessComponent(){
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public char getName() {
        return name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessComponent(char name, int x, int y) {
        this.name = name;
        this.source = new ChessboardPoint(x,y);
        if (name == '_') {
            chessColor=ChessColor.NONE;
        }
        else if (Character.isUpperCase(name)){
            chessColor=ChessColor.BLACK;
        }
        else if (Character.isLowerCase(name)){
            chessColor=ChessColor.WHITE;
        }

        // code for color check
    }

    public static ChessComponent[][] getChessboard() {
        return chessboard;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString(){
        String s = String.valueOf(this.name);
        return s;
    }
}
 class KingChessComponent extends ChessComponent{
     public KingChessComponent(char name, int x, int y) {
         super(name, x, y);
     }

     @Override
     public List<ChessboardPoint> canMoveTo() {

         List<ChessboardPoint>canmove=new ArrayList<>();
         int x=getSource().getX();
         int y=getSource().getY();
         for (int i=-1;i<=1;i++){
             for (int j=-1;j<=1;j++){
                 if (i==0&&j==0){
                     continue;
                 }
                 else {
                     if (x+i>=0&&x+i<8&&y+j>=0&&y+j<8&&getChessboard()[x+i][y+j].getChessColor()!=this.getChessColor()){
                         canmove.add(new ChessboardPoint(x+i,y+j));
                     }
                 }
             }
         }
         return canmove;
     }

     @Override
     public String toString() {
         return super.toString();
     }
 }
 class QueenChessComponent extends ChessComponent{
     public QueenChessComponent(char name,int x ,int y) {
         super(name, x, y);
     }
     @Override
     public List<ChessboardPoint> canMoveTo() {
         List<ChessboardPoint> canmove = new ArrayList<>();
         int x = getSource().getX();
         int y = getSource().getY();
         for (int i = x+1; i < 8; i++) {
             if (getChessboard()[i][y].getChessColor()==ChessColor.NONE){
                 canmove.add(new ChessboardPoint(i,y));
             }
             if (getChessboard()[i][y].getChessColor()!=this.getChessColor()&&getChessboard()[i][y].getChessColor()!=ChessColor.NONE){
                 canmove.add(new ChessboardPoint(i,y));
                 break;
             }
             if (getChessboard()[i][y].getChessColor()==this.getChessColor()){
                 break;
             }
         }
         for (int i = x-1; i >=0 ; i--) {
             if (getChessboard()[i][y].getChessColor()==ChessColor.NONE){
                 canmove.add(new ChessboardPoint(i,y));
             }
             if (getChessboard()[i][y].getChessColor()!=this.getChessColor()&&getChessboard()[i][y].getChessColor()!=ChessColor.NONE){
                 canmove.add(new ChessboardPoint(i,y));
                 break;
             }
             if (getChessboard()[i][y].getChessColor()==this.getChessColor()){
                 break;
             }
         }
         for (int i = y+1; i <8; i++) {
             if (getChessboard()[x][i].getChessColor()==ChessColor.NONE){
                 canmove.add(new ChessboardPoint(x,i));
             }
             if (getChessboard()[x][i].getChessColor()!=this.getChessColor()&&getChessboard()[x][i].getChessColor()!=ChessColor.NONE){
                 canmove.add(new ChessboardPoint(x,i));
                 break;
             }
             if (getChessboard()[x][i].getChessColor()==this.getChessColor()){
                 break;
             }
         }
         for (int i = y-1; i >=0 ; i--) {
             if (getChessboard()[x][i].getChessColor()==ChessColor.NONE){
                 canmove.add(new ChessboardPoint(x,i));
             }
             if (getChessboard()[x][i].getChessColor()!=this.getChessColor()&&getChessboard()[x][i].getChessColor()!=ChessColor.NONE){
                 canmove.add(new ChessboardPoint(x,i));
                 break;
             }
             if (getChessboard()[x][i].getChessColor()==this.getChessColor()){
                 break;
             }
         }
         for (int i = x+1; i < 8 ; i++) {
             if (  y+x-i >=8 || x+1>=8 || y+x-i<0){
                 break;
             }
             else {
                 if (getChessboard()[i][y+x-i].getChessColor()==this.getChessColor()&&getChessboard()[i][y+x-i].getChessColor()!=ChessColor.NONE){
                     break;
                 }
                 else if (getChessboard()[i][y+x-i].getChessColor()!=this.getChessColor() && y+x-i<8&&y+x-i>=0&&getChessboard()[i][y+x-i].getChessColor()!=ChessColor.NONE){
                     canmove.add(new ChessboardPoint(i,y+x-i));
                     break;
                 }
                 else if (getChessboard()[i][y+x-i].getChessColor()==ChessColor.NONE &&y+x-i<8&&y+x-i>=0 ){
                     canmove.add(new ChessboardPoint(i,y+x-i));
                 }
             }

         }
         for (int i = x+1; i < 8 ; i++) {
             if ( y-x+i >=8 || x+1>=8|| y-x+i<0){
                 break;
             }
             else {
                 if (getChessboard()[i][i+y-x].getChessColor()==this.getChessColor()&&getChessboard()[i][i+y-x].getChessColor()!=ChessColor.NONE){
                     break;
                 }
                 else if (getChessboard()[i][i+y-x].getChessColor()!=this.getChessColor() && y-x+i<8&& y-x+i>=0&&getChessboard()[i][i+y-x].getChessColor()!=ChessColor.NONE){
                     canmove.add(new ChessboardPoint(i,y-x+i));
                     break;
                 }
                 else if (getChessboard()[i][i+y-x].getChessColor()==ChessColor.NONE &&y-x+i<8&& y-x+i>=0 ){
                     canmove.add(new ChessboardPoint(i,i+y-x));
                 }
             }
         }
         for (int i = x -1; i >= 0 ; i--) {
             if ( y+x-i <0||y+x-i>=8 || x-1<0){
                 break;
             }
             else {
                 if (getChessboard()[i][y+x-i].getChessColor()==this.getChessColor() &&getChessboard()[i][y+x-i].getChessColor()!=ChessColor.NONE ){
                     break;
                 }
                 else if (getChessboard()[i][y+x-i].getChessColor()!=this.getChessColor()&&getChessboard()[i][y+x-i].getChessColor()!=ChessColor.NONE && y+x-i>=0 && y+x-i <8 && x-1>=0){
                     canmove.add(new ChessboardPoint(i,y+x-i));
                     break;
                 }
                 else if (getChessboard()[i][y+x-i].getChessColor()==ChessColor.NONE&& y+x-i>=0 && y+x-i <8 && x-1>=0){
                     canmove.add(new ChessboardPoint(i,y+x-i));
                 }
             }

         }
         for (int i = x -1; i >=0 ; i--) {
             if ( y-x+i <0 || y-x+i>=8|| x-1<0){
                 break;
             }
             else {
                 if (getChessboard()[i][i+y-x].getChessColor()==this.getChessColor()&&getChessboard()[i][i+y-x].getChessColor()!=ChessColor.NONE){
                     break;
                 }
                 else if (getChessboard()[i][i+y-x].getChessColor()!=this.getChessColor() && y-x+i>=0 && y-x+i<8 && x-1>=0&&getChessboard()[i][i+y-x].getChessColor()!=ChessColor.NONE){
                     canmove.add(new ChessboardPoint(i,y-x+i));
                     break;
                 }
                 else if (getChessboard()[i][i+y-x].getChessColor()==ChessColor.NONE&& y-x+i>=0 && y-x+i<8 && x-1>=0){
                     canmove.add(new ChessboardPoint(i,i+y-x));
                 }
             }

         }
         return canmove;
     }

     @Override
     public String toString() {
         return super.toString();
     }
 }
 class RookChessComponent extends ChessComponent {
     public RookChessComponent(char name, int x, int y) {
         super(name, x, y);
     }

     @Override
     public List<ChessboardPoint> canMoveTo() {
         List<ChessboardPoint> canmove = new ArrayList<>();
         int x = getSource().getX();
         int y = getSource().getY();
         for (int i = x+1; i < 8; i++) {
             if (getChessboard()[i][y].getChessColor()==ChessColor.NONE){
                 canmove.add(new ChessboardPoint(i,y));
             }
             if (getChessboard()[i][y].getChessColor()!=this.getChessColor()&&getChessboard()[i][y].getChessColor()!=ChessColor.NONE){
                 canmove.add(new ChessboardPoint(i,y));
                 break;
             }
             if (getChessboard()[i][y].getChessColor()==this.getChessColor()){
                 break;
             }
         }
         for (int i = x-1; i >=0 ; i--) {
             if (getChessboard()[i][y].getChessColor()==ChessColor.NONE){
                 canmove.add(new ChessboardPoint(i,y));
             }
             if (getChessboard()[i][y].getChessColor()!=this.getChessColor()&&getChessboard()[i][y].getChessColor()!=ChessColor.NONE){
                 canmove.add(new ChessboardPoint(i,y));
                 break;
             }
             if (getChessboard()[i][y].getChessColor()==this.getChessColor()){
                 break;
             }
         }
         for (int i = y+1; i <8; i++) {
             if (getChessboard()[x][i].getChessColor()==ChessColor.NONE){
                 canmove.add(new ChessboardPoint(x,i));
             }
             if (getChessboard()[x][i].getChessColor()!=this.getChessColor()&&getChessboard()[x][i].getChessColor()!=ChessColor.NONE){
                 canmove.add(new ChessboardPoint(x,i));
                 break;
             }
             if (getChessboard()[x][i].getChessColor()==this.getChessColor()){
                 break;
             }
         }
         for (int i = y-1; i >=0 ; i--) {
             if (getChessboard()[x][i].getChessColor()==ChessColor.NONE){
                 canmove.add(new ChessboardPoint(x,i));
             }
             if (getChessboard()[x][i].getChessColor()!=this.getChessColor()&&getChessboard()[x][i].getChessColor()!=ChessColor.NONE){
                 canmove.add(new ChessboardPoint(x,i));
                 break;
             }
             if (getChessboard()[x][i].getChessColor()==this.getChessColor()){
                 break;
             }
         }
    return canmove;
     }
     @Override
     public String toString() {
         return super.toString();
     }
 }
 class BishopChessComponent extends ChessComponent{
     public BishopChessComponent(char name, int x ,int y) {
         super(name, x, y);
     }

     @Override
     public List<ChessboardPoint> canMoveTo() {
         List<ChessboardPoint> canmove = new ArrayList<>();
         int x = getSource().getX();
         int y = getSource().getY();
         for (int i = x+1; i < 8 ; i++) {
             if (  y+x-i >=8 || x+1>=8 || y+x-i<0){
                 break;
             }
             else {
                 if (getChessboard()[i][y+x-i].getChessColor()==this.getChessColor()&&getChessboard()[i][y+x-i].getChessColor()!=ChessColor.NONE){
                     break;
                 }
                 else if (getChessboard()[i][y+x-i].getChessColor()!=this.getChessColor() && y+x-i<8&&y+x-i>=0&&getChessboard()[i][y+x-i].getChessColor()!=ChessColor.NONE){
                     canmove.add(new ChessboardPoint(i,y+x-i));
                     break;
                 }
                 else if (getChessboard()[i][y+x-i].getChessColor()==ChessColor.NONE &&y+x-i<8&&y+x-i>=0 ){
                     canmove.add(new ChessboardPoint(i,y+x-i));
                 }
             }

         }
         for (int i = x+1; i < 8 ; i++) {
             if ( y-x+i >=8 || x+1>=8|| y-x+i<0){
                 break;
             }
             else {
                 if (getChessboard()[i][i+y-x].getChessColor()==this.getChessColor()&&getChessboard()[i][i+y-x].getChessColor()!=ChessColor.NONE){
                     break;
                 }
                 else if (getChessboard()[i][i+y-x].getChessColor()!=this.getChessColor() && y-x+i<8&& y-x+i>=0&&getChessboard()[i][i+y-x].getChessColor()!=ChessColor.NONE){
                     canmove.add(new ChessboardPoint(i,y-x+i));
                     break;
                 }
                 else if (getChessboard()[i][i+y-x].getChessColor()==ChessColor.NONE &&y-x+i<8&& y-x+i>=0 ){
                     canmove.add(new ChessboardPoint(i,i+y-x));
                 }
             }
         }
         for (int i = x -1; i >= 0 ; i--) {
             if ( y+x-i <0||y+x-i>=8 || x-1<0){
                 break;
             }
             else {
                 if (getChessboard()[i][y+x-i].getChessColor()==this.getChessColor() &&getChessboard()[i][y+x-i].getChessColor()!=ChessColor.NONE ){
                     break;
                 }
                 else if (getChessboard()[i][y+x-i].getChessColor()!=this.getChessColor()&&getChessboard()[i][y+x-i].getChessColor()!=ChessColor.NONE && y+x-i>=0 && y+x-i <8 && x-1>=0){
                     canmove.add(new ChessboardPoint(i,y+x-i));
                     break;
                 }
                 else if (getChessboard()[i][y+x-i].getChessColor()==ChessColor.NONE&& y+x-i>=0 && y+x-i <8 && x-1>=0){
                     canmove.add(new ChessboardPoint(i,y+x-i));
                 }
             }

         }
         for (int i = x -1; i >=0 ; i--) {
             if ( y-x+i <0 || y-x+i>=8|| x-1<0){
                 break;
             }
             else {
                 if (getChessboard()[i][i+y-x].getChessColor()==this.getChessColor()&&getChessboard()[i][i+y-x].getChessColor()!=ChessColor.NONE){
                     break;
                 }
                  else if (getChessboard()[i][i+y-x].getChessColor()!=this.getChessColor() && y-x+i>=0 && y-x+i<8 && x-1>=0&&getChessboard()[i][i+y-x].getChessColor()!=ChessColor.NONE){
                     canmove.add(new ChessboardPoint(i,y-x+i));
                     break;
                 }
                 else if (getChessboard()[i][i+y-x].getChessColor()==ChessColor.NONE&& y-x+i>=0 && y-x+i<8 && x-1>=0){
                     canmove.add(new ChessboardPoint(i,i+y-x));
                 }
             }

         }
         return canmove;
     }

     @Override
     public String toString() {
         return super.toString();
     }
 }
 class KnightChessComponent extends ChessComponent{
     public KnightChessComponent(char name,int x ,int y) {
         super(name, x, y);
     }

     @Override
     public List<ChessboardPoint> canMoveTo() {
         List<ChessboardPoint> canmove = new ArrayList<>();
         int x = getSource().getX();
         int y = getSource().getY();
         if (x+2 <8 && y-1>=0 && getChessboard()[x+2][y-1].getChessColor()!=this.getChessColor()){
             canmove.add(new ChessboardPoint(x+2,y-1));
         }
         if (x+1 <8 && y-2>=0 && getChessboard()[x+1][y-2].getChessColor()!=this.getChessColor()){
             canmove.add(new ChessboardPoint(x+1,y-2));
         }
         if (x+1 <8 && y+2<8 && getChessboard()[x+1][y+2].getChessColor()!=this.getChessColor()){
             canmove.add(new ChessboardPoint(x+1,y+2));
         }
         if (x+2 <8 && y+1<8 && getChessboard()[x+2][y+1].getChessColor()!=this.getChessColor()){
             canmove.add(new ChessboardPoint(x+2,y+1));
         }
         if (x-2 >=0 && y-1>=0 && getChessboard()[x-2][y-1].getChessColor()!=this.getChessColor()){
             canmove.add(new ChessboardPoint(x-2,y-1));
         }
         if (x-2 >=0 && y+1<8 && getChessboard()[x-2][y+1].getChessColor()!=this.getChessColor()){
             canmove.add(new ChessboardPoint(x-2,y+1));
         }
         if (x-1>=0 && y+2<8 && getChessboard()[x-1][y+2].getChessColor()!=this.getChessColor()){
             canmove.add(new ChessboardPoint(x-1,y+2));
         }
         if (x-1>=0 && y-2>=0 && getChessboard()[x-1][y-2].getChessColor()!=this.getChessColor()){
             canmove.add(new ChessboardPoint(x-1,y-2));
         }
         return canmove;
     }

     @Override
     public String toString() {
         return super.toString();
     }
 }
 class PawnChessComponent extends ChessComponent{
     public PawnChessComponent(char name,int x ,int y) {
         super(name, x, y);
     }

     @Override
     public List<ChessboardPoint> canMoveTo() {
         if (getChessColor()==ChessColor.BLACK){
             List<ChessboardPoint>canmove=new ArrayList<>();
             int x=getSource().getX();
             int y=getSource().getY();
             if (x==1){
                 if (getChessboard()[2][y].getChessColor()==ChessColor.NONE){
                     canmove.add(new ChessboardPoint(2,y));
                     if (getChessboard()[3][y].getChessColor()==ChessColor.NONE){
                         canmove.add(new ChessboardPoint(3,y));
                     }
                 }
                 if (y-1>=0&&getChessboard()[2][y-1].getChessColor()==ChessColor.WHITE){
                     canmove.add(new ChessboardPoint(2,y-1));
                 }
                 if (y+1<8&&getChessboard()[2][y+1].getChessColor()==ChessColor.WHITE){
                     canmove.add(new ChessboardPoint(2,y+1));
                 }
             }
             if (x>1 && x+1<8){
                 if (getChessboard()[x+1][y].getChessColor()==ChessColor.NONE){
                     canmove.add(new ChessboardPoint(x+1,y));
                 }
                 if (y-1>=0&&getChessboard()[x+1][y-1].getChessColor()==ChessColor.WHITE){
                     canmove.add(new ChessboardPoint(x+1,y-1));
                 }
                 if (y+1<8&&getChessboard()[x+1][y+1].getChessColor()==ChessColor.WHITE){
                     canmove.add(new ChessboardPoint(x+1,y+1));
                 }
             }
             return canmove;
         }
         else if (getChessColor()==ChessColor.NONE){
             return new ArrayList<>();
         }
         else if (getChessColor()==ChessColor.WHITE){
             List<ChessboardPoint>canmove=new ArrayList<>();
             int x=getSource().getX();
             int y=getSource().getY();
             if (x==6){
                 if (getChessboard()[5][y].getChessColor()==ChessColor.NONE){
                     canmove.add(new ChessboardPoint(5,y));
                     if (getChessboard()[4][y].getChessColor()==ChessColor.NONE){
                         canmove.add(new ChessboardPoint(4,y));
                     }
                 }
                 if (y-1>=0&&getChessboard()[5][y-1].getChessColor()==ChessColor.WHITE){
                     canmove.add(new ChessboardPoint(5,y-1));
                 }
                 if (y+1<8&&getChessboard()[5][y+1].getChessColor()==ChessColor.WHITE){
                     canmove.add(new ChessboardPoint(5,y+1));
                 }
             }
             if (x-1>=0 && x<6){
                 if (getChessboard()[x-1][y].getChessColor()==ChessColor.NONE){
                     canmove.add(new ChessboardPoint(x-1,y));
                 }
                 if (y-1>=0&&getChessboard()[x-1][y-1].getChessColor()==ChessColor.WHITE){
                     canmove.add(new ChessboardPoint(x-1,y-1));
                 }
                 if (y+1<8&&getChessboard()[x-1][y+1].getChessColor()==ChessColor.WHITE){
                     canmove.add(new ChessboardPoint(x-1,y+1));
                 }
             }
             return canmove;
         }
        return new ArrayList<>();
     }

     @Override
     public String toString() {
         return super.toString();
     }
 }
 class EmptySlotComponent extends ChessComponent{
     public EmptySlotComponent(char name,int x ,int y ) {
         super(name, x, y);
     }
     @Override
     public List<ChessboardPoint> canMoveTo() {
         return new ArrayList<>();
     }

     @Override
     public String toString() {
         return super.toString();
     }
 }
