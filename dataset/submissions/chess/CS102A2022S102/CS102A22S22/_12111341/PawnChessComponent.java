import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessColor color, ChessboardPoint chessboardPoint){
        if (color.equals(ChessColor.BLACK)){
            this.name='P';
        }else {
            this.name='p';
        }
        this.setSource(chessboardPoint);
        this.setChessColor(color);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if (chessboard[x][y].name=='P'){
            if (x==1){
                if (chessboard[x+1][y].getChessColor()==ChessColor.NONE){
                    arrayList.add(chessboard[x+1][y].getSource());
                    if (chessboard[x+2][y].getChessColor()==ChessColor.NONE){
                        arrayList.add(chessboard[x+2][y].getSource());
                    }
                }if (getSource().offset(1, 1) != null &&
                        chessboard[x+1][y+1].getChessColor()==ChessColor.WHITE){
                    arrayList.add(chessboard[x+1][y+1].getSource());
                }if (getSource().offset(1, -1) != null &&
                        chessboard[x+1][y-1].getChessColor()==ChessColor.WHITE){
                    arrayList.add(chessboard[x+1][y-1].getSource());
                }
            }else if (x!=7){
                if (getSource().offset(1, 1) != null &&
                        chessboard[x+1][y+1].getChessColor()==ChessColor.WHITE){
                    arrayList.add(chessboard[x+1][y+1].getSource());
                }if (getSource().offset(1, -1) != null &&
                        chessboard[x+1][y-1].getChessColor()==ChessColor.WHITE){
                    arrayList.add(chessboard[x+1][y-1].getSource());
                }if (chessboard[x+1][y].getChessColor()==ChessColor.NONE){
                    arrayList.add(chessboard[x+1][y].getSource());
                }
            }
        }else if (chessboard[x][y].name=='p'){
            if (x==6){
                if (chessboard[x-1][y].getChessColor()==ChessColor.NONE){
                    arrayList.add(chessboard[x-1][y].getSource());
                    if (chessboard[x-2][y].getChessColor()==ChessColor.NONE){
                        arrayList.add(chessboard[x-2][y].getSource());
                    }
                }if (getSource().offset(-1, 1) != null &&
                        chessboard[x-1][y+1].getChessColor()==ChessColor.BLACK){
                    arrayList.add(chessboard[x+1][y+1].getSource());
                }if (getSource().offset(-1, -1) != null &&
                        chessboard[x-1][y-1].getChessColor()==ChessColor.BLACK){
                    arrayList.add(chessboard[x+1][y-1].getSource());
                }
            }else if (x!=0){
                if (getSource().offset(-1, -1) != null &&
                        chessboard[x-1][y-1].getChessColor()==ChessColor.BLACK){
                    arrayList.add(chessboard[x-1][y-1].getSource());
                }if (getSource().offset(-1, 1) != null &&
                        chessboard[x-1][y+1].getChessColor()==ChessColor.BLACK){
                    arrayList.add(chessboard[x-1][y+1].getSource());
                }if (chessboard[x-1][y].getChessColor()==ChessColor.NONE){
                    arrayList.add(chessboard[x-1][y].getSource());
                }
            }
        }
        return arrayList;
    }
}
