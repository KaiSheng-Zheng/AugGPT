import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    @Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
        this.source=source;
        this.chessColor=chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l=new ArrayList<>() ;
        int x=source.getX();
        int y=source.getY();
        for (int i= 1; x+i>=0&&x+i<=7&&y+i>=0&&y+i<=7 ; i++) {
            if (chessboard[x+i][y+i].getChessColor()==chessColor) {
                break;}
            else if (chessboard[x+i][y+i].getChessColor()==ChessColor.NONE){
                ChessboardPoint cbp=new ChessboardPoint(x+i,y+i);
                l.add(cbp);
            }else {
                ChessboardPoint cbp=new ChessboardPoint(x+i,y+i);
                l.add(cbp);
                break;
            }

        }


        for (int i= 1; x-i>=0&&x-i<=7&&y+i>=0&&y+i<=7 ; i++) {
            if (chessboard[x-i][y+i].getChessColor()==chessColor) {
                break;}
            else if (chessboard[x-i][y+i].getChessColor()==ChessColor.NONE){
                ChessboardPoint cbp=new ChessboardPoint(x-i,y+i);
                l.add(cbp);
            }else {
                ChessboardPoint cbp=new ChessboardPoint(x-i,y+i);
                l.add(cbp);
                break;
            }

        }


        for (int i= 1; x+i>=0&&x+i<=7&&y-i>=0&&y-i<=7 ; i++) {
            if (chessboard[x+i][y-i].getChessColor()==chessColor) {
                break;}
            else if (chessboard[x+i][y-i].getChessColor()==ChessColor.NONE){
                ChessboardPoint cbp=new ChessboardPoint(x+i,y-i);
                l.add(cbp);
            }else {
                ChessboardPoint cbp=new ChessboardPoint(x+i,y-i);
                l.add(cbp);
                break;
            }

        }


        for (int i= 1; x-i>=0&&x-i<=7&&y-i>=0&&y-i<=7 ; i++) {
            if (chessboard[x-i][y-i].getChessColor()==chessColor) {
                break;}
            else if (chessboard[x-i][y-i].getChessColor()==ChessColor.NONE){
                ChessboardPoint cbp=new ChessboardPoint(x-i,y-i);
                l.add(cbp);
            }else {
                ChessboardPoint cbp=new ChessboardPoint(x-i,y-i);
                l.add(cbp);
                break;
            }

        }

        return l;

    }
}
