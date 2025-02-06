import java.util.ArrayList;
import java.util.List;

public interface ChessGame {

    public void loadChessGame(List<String> chessboard);


    public ChessColor getCurrentPlayer();


    public ChessComponent getChess(int x, int y);


    public String getChessboardGraph();


    public String getCapturedChess(ChessColor player);


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);

}
// class KingChessComponent extends  ChessComponent{
//     public  KingChessComponent(int x,int y,ChessColor chessColor){
//
//         this.setSource(new ChessboardPoint(x,y));
//         this.setChessColor(chessColor);
//         if(chessColor==ChessColor.BLACK)
//             this.setName('K');
//         else this.setName('k');
//     }
//
//     @Override
//     public List<ChessboardPoint> canMoveTo() {
//
//         List<ChessboardPoint>canMoveToPoint=new ArrayList<>();
//         for(int i=0;i<8;i++){
//             for(int j=0;j<8;j++){
//                 ChessboardPoint destination=new ChessboardPoint(i,j);
//                 if(this.getChessComponents()[i][j].getChessColor()!=this.getChessColor()){
//                 if(Math.abs(i-this.getSource().getX())<1&&Math.abs(j-this.getSource().getY())<1&&!((i==this.getSource().getX())&&(j==this.getSource().getY()))){
//                     canMoveToPoint.add(destination);
//                 }}
//             }
//         }
//
//
//         return canMoveToPoint;
//     }
//
//}
// class QueenChessComponent extends  ChessComponent{
//     public  QueenChessComponent(int x,int y,ChessColor chessColor){
//
//         this.setSource(new ChessboardPoint(x,y));
//         this.setChessColor(chessColor);
//         if(chessColor==ChessColor.BLACK)
//             this.setName('Q');
//         else this.setName('q');
//     }
//
//     @Override
//     public List<ChessboardPoint> canMoveTo() {
//         List<ChessboardPoint>canMoveToPoint=new ArrayList<>();
//
//         for(int i=0;i<8;i++){
//            B: for(int j=0;j<8;j++){
//                 ChessboardPoint destination=new ChessboardPoint(i,j);
//
//                 if((i==this.getSource().getX()&&j==this.getSource().getY())||this.getChessColor()==this.getChessComponents()[i][j].getChessColor())continue B;
//                 else if(this.getSource().getX()==i){
//                     for(int z=Math.min(i,this.getSource().getX())+1;z<Math.max(i,this.getSource().getX());z++){
//                         if(!(this.getChessComponents()[z][j] instanceof  EmptySlotComponent))continue B;
//                         else canMoveToPoint.add(destination);
//                     }
//                 }
//                 else if(this.getSource().getY()==j){
//                     for(int z=Math.min(j,this.getSource().getY())+1;z<Math.max(j,this.getSource().getY());z++){
//                         if(!(this.getChessComponents()[i][z] instanceof  EmptySlotComponent))continue B;
//                         else canMoveToPoint.add(destination);
//                     }
//                 }
//
//
//
//     }
//}
//         return canMoveToPoint;
//     }
//}
//
////where to set chesscomponent
//
// class RookChessComponent extends  ChessComponent{
//
//
//
//     public  RookChessComponent(int x, int y, ChessColor chessColor){
//
//         this.setSource(new ChessboardPoint(x,y));
//         this.setChessColor(chessColor);
//         if(chessColor==ChessColor.BLACK)
//             this.setName('R');
//         else this.setName('r');
//     }
//
//     @Override
//     public List<ChessboardPoint> canMoveTo() {
//List<ChessboardPoint>canMoveToPoint=new ArrayList<>();
//A:for(int i=0;i<8;i++){
//  B:  for(int j=0;j<8;j++){
//ChessboardPoint destination=new ChessboardPoint(i,j);
//if((i==this.getSource().getX()&&j==this.getSource().getY())||this.getChessColor()==this.getChessComponents()[i][j].getChessColor())continue B;
//else if(this.getSource().getX()==i){
//for(int z=Math.min(i,this.getSource().getX())+1;z<Math.max(i,this.getSource().getX());z++){
//    if((this.getChessComponents()[z][j] instanceof EmptySlotComponent))continue B;
//    else canMoveToPoint.add(destination);
//}
//}
//else if(this.getSource().getY()==j){
//for(int z=Math.min(j,this.getSource().getY())+1;z<Math.max(j,this.getSource().getY());z++){
//    if(!(this.getChessComponents()[i][z] instanceof EmptySlotComponent))continue B;
//    else canMoveToPoint.add(destination);
//}
//}
//}
//      }
//
//
//return canMoveToPoint;
//}
//
//
//
//    }
//
//
//
//
//
//
//
//
//  class BishopChessComponent extends  ChessComponent{
//
//   public  BishopChessComponent(int x,int y,ChessColor chessColor){
//
//       this.setSource(new ChessboardPoint(x,y));
//       this.setChessColor(chessColor);
//       if(chessColor==ChessColor.BLACK)
//           this.setName('B');
//       else this.setName('b');
//   }
//
//
//      @Override
//      public List<ChessboardPoint> canMoveTo() {
//          List<ChessboardPoint>canMoveToPoint=new ArrayList<>();
//          for(int i=0;i<8;i++){
//              B:for(int j=0;j<8;j++){
//                  ChessboardPoint destination=new ChessboardPoint(i,j);
//
//                  if(this.getChessColor()!=this.getChessComponents()[i][j].getChessColor()&&Math.abs(i-this.getSource().getX())==Math.abs(j-this.getSource().getY())&&i!=this.getSource().getX()){
//
//                     if(i+j==this.getSource().getX()+this.getSource().getY()) {
//int x=Math.min(i,this.getSource().getX());
//int y=Math.max(j,this.getSource().getY());
//                         for(;x<Math.max(i,this.getSource().getX())&&y>Math.min(j,this.getSource().getY());){
//                             if(!(this.getChessComponents()[x][y] instanceof  EmptySlotComponent))continue B;
//                             else{x++;y--;}
//                         }
//canMoveToPoint.add(destination);
//                     }
//                     else{
//                          int x=Math.min(i,this.getSource().getX())+1 ;
//                          int y=Math.min(j,this.getSource().getY())+1;
//                         for(;x<this.getSource().getX()&&y<this.getSource().getY();){
//if(!(this.getChessComponents()[x][y] instanceof  EmptySlotComponent)){continue B;}
//else {x++;y++;}
//                         }
//                     canMoveToPoint.add(destination);
//                     }
//                  }
//                  }
//
//
//                  }
//          return canMoveToPoint;
//              }
//      }
//
//class KnightChessComponent extends  ChessComponent{
//    public  KnightChessComponent(int x,int y,ChessColor chessColor){
//
//        this.setSource(new ChessboardPoint(x,y));
//        this.setChessColor(chessColor);
//        if(chessColor==ChessColor.BLACK)
//            this.setName('N');
//        else this.setName('n');
//    }
//
//    @Override
//    public List<ChessboardPoint> canMoveTo() {
//        List<ChessboardPoint>canMoveToPoint=new ArrayList<>();
//        for(int i=0;i<8;i++){
//            for(int j=0;j<8;j++){
//                ChessboardPoint destination=new ChessboardPoint(i,j);
//                if(this.getChessColor()!=this.getChessComponents()[i][j].getChessColor()) {
//                    if ((Math.abs(i - this.getSource().getX()) == 2 && Math.abs(j - this.getSource().getY()) == 1) || (Math.abs(i - this.getSource().getX()) == 1 && Math.abs(j - this.getSource().getY()) == 2)) {
//                        canMoveToPoint.add(destination);
//                    }
//                }
//            }
//        }
//
//
//        return canMoveToPoint;
//    }
//}
// class PawnChessComponent extends  ChessComponent{
//     public  PawnChessComponent(int x,int y,ChessColor chessColor){
//
//         this.setSource(new ChessboardPoint(x,y));
//         this.setChessColor(chessColor);
//         if(chessColor==ChessColor.BLACK)
//             this.setName('P');
//         else this.setName('p');
//     }
//
//     @Override
//     public List<ChessboardPoint> canMoveTo() {
//         return null;
//     }
//}
// class EmptySlotComponent extends  ChessComponent{
//     public  EmptySlotComponent(int x,int y,ChessColor chessColor){
//
//         this.setSource(new ChessboardPoint(x,y));
//         this.setChessColor(chessColor);
//         this.setName(' ');
//     }
//
//     @Override
//     public List<ChessboardPoint> canMoveTo() {
//         return new ArrayList<>();
//     }
//}