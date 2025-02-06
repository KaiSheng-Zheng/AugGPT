import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessComponent[][] chesscomponent;
    private char name;
    private ChessboardPoint source;

    public PawnChessComponent(char name,ChessboardPoint point,ChessColor color){
        super.name = name;
        super.setSource(point);
        super.setChessColor(color);
    }
    
    
    public boolean isIntervalChess(ChessComponent[][] chessComponents, int x1, int y1, int x2, int y2) {
        boolean result =false;
        //RNBQKBNR 0
        //PPPPPPPP 1
        //________
        //________
        //________
        //________
        //pppppppp 6
        //rnbqkbnr 7
        PawnChessComponent pawn = (PawnChessComponent) chessComponents[x1][y1];//judge if chess can move

        if(pawn.getChessColor() == ChessColor.BLACK){
//            canMoveTo().remove(getSource().offset(0, -1));
            if (y1>=0&&y1<=6&&x1>=1&&x1<=6 && x2 == x1 + 1 && y2 == y1 + 1){
                if (chessComponents[x1 + 1][y1 + 1].getChessColor() == ChessColor.WHITE){
                    result = true;
                }
            }//chiZi
            else if (y1>=1&&y1<=7&&x1>=1&&x1<=6 && x2 == x1 + 1 && y2 == y1 - 1) {
                if (chessComponents[x1 + 1][y1 - 1].getChessColor() == ChessColor.WHITE) {
                    result = true;
                }
            }//chiZi
            else if (x2 == x1+1 && y2 == y1 ) {
                if (chessComponents[x2][y2].name == '_') {
                    result = true;
                }
            } else if (x2 == x1+2 && y2 == y1 && x1 == 1) {
                if (chessComponents[x1+2][y2].name == '_'&&chessComponents[x1+1][y2].name=='_') {
                    result = true;
                }
            } else {
                result = false;
            }
        }else{
//            canMoveTo().remove(getSource().offset(0,1));
            if (y1>=1&&y1<=7&&x1<=6&&x1>=1 && x2 == x1 - 1 && y2 == y1 - 1) {
                if (chessComponents[x1 - 1][y1 - 1].getChessColor() == ChessColor.BLACK) {
                    result = true;
                }
            }//chiZi
            else if (y1 - 1 >= 0 && y1 - 1 <= 6 && x1  <= 6 && x1 - 1 >= 0 && x2 == x1 - 1 && y2 == y1 + 1) {
                if (chessComponents[x1 - 1][y1 + 1].getChessColor() == ChessColor.BLACK) {
//                    canMoveTo().add(new ChessboardPoint(x2, y2));
                    result = true;
                }
            }//chiZi
            else if (x1-1 == x2 && y2 == y1  && x1 == 6) {
                if (chessComponents[x2][y2].name == '_') {
                    result = true;
//                    canMoveTo().add(new ChessboardPoint(x2, y2));
                }
            } else if (x1-2 == x2 && y2 == y1 && x1 == 6) {
                if (chessComponents[x2][y2].name == '_'&&chessComponents[x2+1][y2].name=='_') {
                    result = true;
//                    canMoveTo().add(new ChessboardPoint(x2, y2));
                }
            } else {
                result = false;
            }
        }
        return result;
    }

    public List<ChessboardPoint> canMoveTo1(){
        List<ChessboardPoint> can = new ArrayList<>();
        ChessColor a = chessboard[getSource().getX()][getSource().getY()].getChessColor();
        if(a == ChessColor.BLACK){
        can.add(getSource().offset(1,0));
        can.add(getSource().offset(2,0));
        can.add(getSource().offset(-1,0));
        can.add(getSource().offset(-2,0));
        }else{
        can.add(getSource().offset(1,1));
        can.add(getSource().offset(1,-1));
        can.add(getSource().offset(-1,-1));
        can.add(getSource().offset(-1,1));
        }
        return can;
    }//this is the most complex one
     public List<ChessboardPoint> RemoveNull(List<ChessboardPoint> arr){
        List<ChessboardPoint> arr1 = new ArrayList<>();
        
            int a = arr.size();
            for (int i = 0; i < a; i++) {
                if (!(arr.get(i) == null)) {
                    arr1.add(arr.get(i));
                }
            
        }
        return arr1;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
         List<ChessboardPoint> arr1 = canMoveTo1();
          List<ChessboardPoint> points =new ArrayList();
          List<ChessboardPoint> points1 =new ArrayList();
          if(arr1 == null){
              return new ArrayList();
          }       
        for(int i = 0;i < arr1.size();i++){           
        }
        sett(points);
        return points;
    }
}
