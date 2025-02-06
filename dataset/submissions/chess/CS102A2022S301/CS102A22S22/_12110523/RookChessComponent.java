import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;


    public RookChessComponent(ChessboardPoint source, ChessColor chessColor,char name) {
        super(source,chessColor,name);
        this.source = source;
        this.chessColor = chessColor;

    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l=new ArrayList<>() ;

        int x=source.getX();
        int y=source.getY();
        for (int i = y+1; i < 8; i++) {
            if (chessboard[x][i].getChessColor()==chessColor) {
                break;}
            else if (chessboard[x][i].getChessColor()==ChessColor.NONE){
                ChessboardPoint cbp=new ChessboardPoint(x,i);
                l.add(cbp);
            }else {
                ChessboardPoint cbp=new ChessboardPoint(x,i);
                l.add(cbp);
                break;
            }

        }
        for (int i = y-1; i >= 0; i--) {
            if (chessboard[x][i].getChessColor()==chessColor) {
                break;}
            else if (chessboard[x][i].getChessColor()==ChessColor.NONE){
                ChessboardPoint cbp=new ChessboardPoint(x,i);
                l.add(cbp);
            }else {
                ChessboardPoint cbp=new ChessboardPoint(x,i);
                l.add(cbp);
                break;
            }

        }
        for (int i = x+1; i < 8; i++) {
            if (chessboard[i][y].getChessColor()==chessColor) {
                break;}
            else if (chessboard[i][y].getChessColor()==ChessColor.NONE){
                ChessboardPoint cbp=new ChessboardPoint(i,y);
                l.add(cbp);
            }else {
                ChessboardPoint cbp=new ChessboardPoint(i,y);
                l.add(cbp);
                break;
            }

        }
        for (int i = x-1; i >= 0; i--) {
            if (chessboard[i][y].getChessColor()==chessColor) {
                break;}
            else if (chessboard[i][y].getChessColor()==ChessColor.NONE){
                ChessboardPoint cbp=new ChessboardPoint(i,y);
                l.add(cbp);
            }else {
                ChessboardPoint cbp=new ChessboardPoint(i,y);
                l.add(cbp);
                break;
            }

        }

        return l;
    }
}
