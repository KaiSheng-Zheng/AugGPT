import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        super(chessboardPoint,chessColor,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer=new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        if(name=='P'){
            if(x==1){
                if(chessboard[2][y] instanceof EmptySlotComponent){
                    answer.add(new ChessboardPoint(2,y));
                    if(chessboard[3][y] instanceof EmptySlotComponent){
                        answer.add(new ChessboardPoint(3,y));
                    }
                }
                if(y-1>=0){
                    if(!(chessboard[2][y-1] instanceof EmptySlotComponent)){
                        if(chessboard[2][y-1].getChessColor()!=getChessColor()){
                            answer.add(new ChessboardPoint(2,y-1));
                        }
                    }
                }
                if(y+1<=7){
                    if(!(chessboard[2][y+1] instanceof EmptySlotComponent)){
                        if(chessboard[2][y+1].getChessColor()!=getChessColor()){
                            answer.add(new ChessboardPoint(2,y+1));
                        }
                    }
                }
            }else{
                if(x+1<=7){
                    if(chessboard[x+1][y] instanceof EmptySlotComponent){
                        answer.add(new ChessboardPoint(x+1,y));
                    }
                    if(y-1>=0){
                        if(!(chessboard[x+1][y-1] instanceof EmptySlotComponent)){
                            if(chessboard[x+1][y-1].getChessColor()!=getChessColor()){
                                answer.add(new ChessboardPoint(x+1,y-1));
                            }
                        }
                    }
                    if(y+1<=7){
                        if(!(chessboard[x+1][y+1] instanceof EmptySlotComponent)){
                            if(chessboard[x+1][y+1].getChessColor()!=getChessColor()){
                                answer.add(new ChessboardPoint(x+1,y+1));
                            }
                        }
                    }
                }
            }
        }
        if(name=='p'){
            if(x==6){
                if(chessboard[5][y] instanceof EmptySlotComponent){
                    answer.add(new ChessboardPoint(5,y));
                    if(chessboard[4][y] instanceof EmptySlotComponent){
                        answer.add(new ChessboardPoint(4,y));
                    }
                }
                if(y-1>=0){
                    if(!(chessboard[5][y-1] instanceof EmptySlotComponent)){
                        if(chessboard[5][y-1].getChessColor()!=getChessColor()){
                            answer.add(new ChessboardPoint(5,y-1));
                        }
                    }
                }
                if(y+1<=7){
                    if(!(chessboard[5][y+1] instanceof EmptySlotComponent)){
                        if(chessboard[5][y+1].getChessColor()!=getChessColor()){
                            answer.add(new ChessboardPoint(5,y+1));
                        }
                    }
                }
            }else{
                if(x-1>=0){
                    if(chessboard[x-1][y] instanceof EmptySlotComponent){
                        answer.add(new ChessboardPoint(x-1,y));
                    }
                    if(y-1>=0){
                        if(!(chessboard[x-1][y-1] instanceof EmptySlotComponent)){
                            if(chessboard[x-1][y-1].getChessColor()!=getChessColor()){
                                answer.add(new ChessboardPoint(x-1,y-1));
                            }
                        }
                    }
                    if(y+1<=7){
                        if(!(chessboard[x-1][y+1] instanceof EmptySlotComponent)){
                            if(chessboard[x-1][y+1].getChessColor()!=getChessColor()){
                                answer.add(new ChessboardPoint(x-1,y+1));
                            }
                        }
                    }
                }
            }
        }
        return answer;
//        List<ChessboardPoint> canto = new ArrayList<>();
//        int x = getSource().getX();
//        int y = getSource().getY();
//        if (getChessColor() == ChessColor.BLACK) {
//            if (x == 1) {
//                canto.add(new ChessboardPoint(2, y));
//                canto.add(new ChessboardPoint(3, y));
//                if (y - 1 >= 0) {
//                    canto.add(new ChessboardPoint(2, y - 1));
//                }
//                if (y + 1 < 7) {
//                    canto.add(new ChessboardPoint(2, y + 1));
//                }
//            }
//            if (y - 1 >= 0) {
//                canto.add(new ChessboardPoint(x, y - 1));
//            }
//            if (y + 1 < 7) {
//                canto.add(new ChessboardPoint(x, y + 1));
//            }
//        }
//        if (getChessColor() == ChessColor.WHITE) {
//            if (x == 6) {
//                canto.add(new ChessboardPoint(5, y));
//                canto.add(new ChessboardPoint(4, y));
//                if (y - 1 >= 0) {
//                    canto.add(new ChessboardPoint(5, y - 1));
//                }
//                if (y + 1 < 7) {
//                    canto.add(new ChessboardPoint(5, y + 1));
//                }
//            }
//            if (y - 1 >= 0) {
//                canto.add(new ChessboardPoint(x, y - 1));
//            }
//            if (y + 1 < 7) {
//                canto.add(new ChessboardPoint(x, y + 1));
//            }
//        }
//        return canto;
    }
}
