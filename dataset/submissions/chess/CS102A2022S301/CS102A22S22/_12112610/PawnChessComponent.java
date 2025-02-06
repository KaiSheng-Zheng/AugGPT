import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public  PawnChessComponent(char name, ChessColor chessColor, ChessboardPoint source, ChessComponent[][] chessComponents) {
        super(name, chessColor, source, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        ChessboardPoint point = this.getSource();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard[i][j].getChessColor != super.getChessColor) {
                    int R = point.getX();
                    int C = point.getY();
                    if (Math.abs(R - chessboard[i][j].getSource().getX()) + Math.abs(C - chessboard[i][j].getSource().getY()) == 3 && R != i && C != j) {
                        result.add(chessboard[i][j].getSource());

                    }
                }
            }
        }
        return result;
    }
}
//            if (point.getX()==1
//                    &&chessboard[point.getX()+2][point.getY()].getChessColor()!=this.getChessColor()
//                    && this.getChessColor()==ChessColor.BLACK
//                    &&chessboard[point.getX()+1][point.getY()].getChessColor()==ChessColor.NONE){
//                result.add(point.offset(2,0));
//            }
//            if (point.getX()==6
//                    &&chessboard[point.getX()-2][point.getY()].getChessColor()!=this.getChessColor()
//                    &&this.getChessColor()==ChessColor.WHITE&&chessboard[point.getX()-1][point.getY()].getChessColor()==ChessColor.NONE){
//                result.add(point.offset(0,-2));
//            }
//            if (this.getChessColor()==ChessColor.BLACK
//                    &&chessboard[point.getX()+1][point.getY()+1].getChessColor()==ChessColor.WHITE){
//                result.add(point.offset(1,+1));
//            }
//            if (this.getChessColor()==ChessColor.BLACK
//                    &&chessboard[point.getX()+1][point.getY()-1].getChessColor()==ChessColor.WHITE){
//                result.add(point.offset(1,-1));
//            }
//            if (this.getChessColor()==ChessColor.WHITE
//                    &&chessboard[point.getX()-1][point.getY()-1].getChessColor()==ChessColor.BLACK){
//                result.add(point.offset(-1,-1));
//            }
//            if (this.getChessColor()==ChessColor.WHITE
//                    &&chessboard[point.getX()-1][point.getY()+1].getChessColor()==ChessColor.BLACK){
//                result.add(point.offset(-1,1));
//            }
//            if (this.getChessColor()==ChessColor.WHITE
//                    &&chessboard[point.getX()-1][point.getY()].getChessColor()==ChessColor.NONE){
//                result.add(point.offset(-1,0));
//            }
//            if (this.getChessColor()==ChessColor.BLACK
//                    &&chessboard[point.getX()+1][point.getY()].getChessColor()==ChessColor.NONE){
//                result.add(point.offset(1,0));
//            }
//            for(int i=0;i<result.size();i++){
//                for(int j=i+1;j<result.size();j++){
//                    if(result.get(i).getX()>result.get(j).getX()){
//                        ChessboardPoint temp = result.get(i);
//                        result.set(i,result.get(j));
//                        result.set(j,temp);
//                    }
//                    else if(result.get(i).getX()==result.get(j).getX()){
//                        if(result.get(i).getY()>result.get(j).getY()){
//                            ChessboardPoint temp = result.get(i);
//                            result.set(i,result.get(j));
//                            result.set(j,temp);
//                        }
//                    }
//                }
//            }
//            return result;
//        }
//    }
