import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
        super(chessboardPoint, chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
            ChessComponent[][] chessComponents = chessboard;
            ChessboardPoint source = getSource();
            int x = source.getX();
            int y = source.getY();
            int count = 0;
            List<ChessboardPoint> output = new ArrayList<>();
            if (x==1&&getChessColor()==ChessColor.BLACK){
                if (chessComponents[2][y] instanceof EmptySlotComponent){
                    count++;
                    ChessboardPoint e=new ChessboardPoint(2,y);
                    output.add(e);
                }
                if (chessComponents[3][y]instanceof EmptySlotComponent
                        &&chessComponents[2][y] instanceof EmptySlotComponent ){
                    count++;
                    ChessboardPoint e=new ChessboardPoint(3,y);
                    output.add(e);
                }
                if (y+1<=7&&chessComponents[2][y+1].getChessColor()==ChessColor.WHITE){
                    ChessboardPoint e=new ChessboardPoint(2,y+1);
                    count++;
                    output.add(e);
                }
                if (y-1>=0&&chessComponents[2][y-1].getChessColor()==ChessColor.WHITE){
                    ChessboardPoint e=new ChessboardPoint(2,y-1);
                    count++;
                    output.add(e);
                }
            }else if (getChessColor()==ChessColor.BLACK){
                if (x+1<=7&&chessComponents[x+1][y] instanceof EmptySlotComponent){
                    count++;
                    ChessboardPoint e=new ChessboardPoint(x+1,y);
                    output.add(e);
                }
                if (x+1<=7&&y+1<=7&&chessComponents[x+1][y+1].getChessColor()==ChessColor.WHITE){
                    count++;
                    ChessboardPoint e=new ChessboardPoint(x+1,y+1);
                    output.add(e);
                }
                if (x+1<=7&&y-1>=0&&chessComponents[x+1][y-1].getChessColor()==ChessColor.WHITE){
                    count++;
                    ChessboardPoint e=new ChessboardPoint(x+1,y-1);
                    output.add(e);
                }
            }else if (x==6&&getChessColor()==ChessColor.WHITE) {
                if (chessComponents[5][y] instanceof EmptySlotComponent) {
                    count++;
                    ChessboardPoint e = new ChessboardPoint(5, y);
                    output.add(e);
                }
                if (chessComponents[4][y] instanceof EmptySlotComponent
                        && chessComponents[5][y] instanceof EmptySlotComponent) {
                    count++;
                    ChessboardPoint e = new ChessboardPoint(4, y);
                    output.add(e);
                }
                if (y + 1 <= 7 && chessComponents[5][y + 1].getChessColor() == ChessColor.BLACK) {
                    ChessboardPoint e = new ChessboardPoint(5, y + 1);
                    count++;
                    output.add(e);
                }
                if (y - 1 >= 0 && chessComponents[5][y - 1].getChessColor() == ChessColor.BLACK) {
                    ChessboardPoint e = new ChessboardPoint(5, y - 1);
                    count++;
                    output.add(e);
                }
            }
                else if (getChessColor()==ChessColor.WHITE){
                    if (x-1>=0&&chessComponents[x-1][y] instanceof EmptySlotComponent){
                        count++;
                        ChessboardPoint e=new ChessboardPoint(x-1,y);
                        output.add(e);
                    }
                    if (x-1>=0&&y+1<=7&&chessComponents[x-1][y+1].getChessColor()==ChessColor.BLACK){
                        count++;
                        ChessboardPoint e=new ChessboardPoint(x-1,y+1);
                        output.add(e);
                    }
                    if (x-1>=0&&y-1>=0&&chessComponents[x-1][y-1].getChessColor()==ChessColor.BLACK){
                        count++;
                        ChessboardPoint e=new ChessboardPoint(x-1,y-1);
                        output.add(e);
                    }
                }
            
            if (count>0){
                return output;
            }else {
                return new ArrayList<>();
            }
    }
}


