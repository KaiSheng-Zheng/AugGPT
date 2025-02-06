import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    ChessComponent[][] chessComponents=new ChessComponent[8][8];

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints=new ArrayList<>();
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        if (x+2<8&&y-1>=0&&chessComponents[x+2][y-1].getChessColor()!=this.getChessColor()){
            chessboardPoints.add(new ChessboardPoint(x+2,y-1));
        }
        if (x+2<8&&y+1<8&&chessComponents[x+2][y+1].getChessColor()!=this.getChessColor()){
            chessboardPoints.add(new ChessboardPoint(x+2,y+1));
        }
        if (x+1<8&&y-2>0&&chessComponents[x+1][y-2].getChessColor()!=this.getChessColor()){
            chessboardPoints.add(new ChessboardPoint(x+1,y-2));
        }
        if (x+1<8&&y+2<8&&chessComponents[x+1][y+2].getChessColor()!=this.getChessColor()){
            chessboardPoints.add(new ChessboardPoint(x+1,y+2));
        }
        if (x-1>=0&&y-2>=0&&chessComponents[x-1][y-2].getChessColor()!=this.getChessColor()){
            chessboardPoints.add(new ChessboardPoint(x-1,y-2));
        }
        if (x-1>=0&&y+2<8&&chessComponents[x-1][y+2].getChessColor()!=this.getChessColor()){
            chessboardPoints.add(new ChessboardPoint(x-1,y+2));
        }
        if (x-2>=0&&y-1>=0&&chessComponents[x-2][y-1].getChessColor()!=this.getChessColor()){
            chessboardPoints.add(new ChessboardPoint(x-2,y-1));
        }
        if (x-2>=0&&y+1<8&&chessComponents[x-2][y+1].getChessColor()!=this.getChessColor()){
            chessboardPoints.add(new ChessboardPoint(x-2,y+1));
        }
        return chessboardPoints;
    }
}
