import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    ChessComponent[][] chessComponents=new ChessComponent[8][8];

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints=new ArrayList<>();
        int x= getSource().getX();
        int y= getSource().getY();
        if (this.getChessColor()==ChessColor.WHITE){
            if (x==6){
                if (chessComponents[x-1][y].getChessColor()==ChessColor.NONE&&chessComponents[x-2][y].getChessColor()!=ChessColor.WHITE){
                    chessboardPoints.add(new ChessboardPoint(x-2,y));
                }
            }
            if (x-1>=0&&chessComponents[x-1][y].getChessColor()==ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(x-1,y));
            }
            if (x-1>=0&&y-1>=0&&chessComponents[x-1][y-1].getChessColor()==ChessColor.BLACK&&chessComponents[x-1][y-1].name!='K'){
                chessboardPoints.add(new ChessboardPoint(x-1,y-1));
            }
            if (x-1>=0&&y+1<8&&chessComponents[x-1][y+1].getChessColor()==ChessColor.BLACK&&chessComponents[x-1][y+1].name!='K'){
                chessboardPoints.add(new ChessboardPoint(x-1,y+1));
            }
        }
        if (this.getChessColor()==ChessColor.BLACK){
            if (x==1){
                if (chessComponents[x+1][y].getChessColor()==ChessColor.NONE&&chessComponents[x+2][y].getChessColor()!=ChessColor.WHITE){
                    chessboardPoints.add(new ChessboardPoint(x+2,y));
                }
            }
            if (x+1<8&&chessComponents[x+1][y].getChessColor()==ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(x+1,y));
            }
            if (x+1<8&&y-1>=0&&chessComponents[x+1][y-1].getChessColor()==ChessColor.WHITE&&chessComponents[x+1][y-1].name!='K'){
                chessboardPoints.add(new ChessboardPoint(x+1,y-1));
            }
            if (x+1<8&&y+1<8&&chessComponents[x+1][y+1].getChessColor()==ChessColor.WHITE&&chessComponents[x+1][y+1].name!='K'){
                chessboardPoints.add(new ChessboardPoint(x+1,y+1));
            }
        }
        return chessboardPoints;
    }
}
