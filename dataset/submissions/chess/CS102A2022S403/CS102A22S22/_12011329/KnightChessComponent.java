import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint,ChessColor color) {
        if (color == ChessColor.BLACK){
            this.name='N';
        }
        if (color == ChessColor.WHITE){
            this.name='n';
        }
        ChessComponent[][] components=new ChessComponent[8][8];
        this.setSource(chessboardPoint);
        this.setChessColor(color);
        this.setChessboard(components);
    }

    public List<ChessboardPoint> canMoveTo(){
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        ChessboardPoint King=new ChessboardPoint(x,y);
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            if (King.offset(-2,-1+2*i)!=null){
                if (this.getChessboard()[x-2][y-1+2*i].getChessColor()!=this.getChessColor()) {
                    chessboardPoints.add(King.offset(-2,-1+2*i));
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            if (King.offset(-1,-2+4*i)!=null){
                if (this.getChessboard()[x-1][y-2+4*i].getChessColor()!=this.getChessColor()) {
                    chessboardPoints.add(King.offset(-1,-2+4*i));
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            if (King.offset(1,-2+4*i)!=null){
                if (this.getChessboard()[x+1][y-2+4*i].getChessColor()!=this.getChessColor()) {
                    chessboardPoints.add(King.offset(1,-2+4*i));
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            if (King.offset(2,-1+2*i)!=null){
                if (this.getChessboard()[x+2][y-1+2*i].getChessColor()!=this.getChessColor()) {
                    chessboardPoints.add(King.offset(2,-1+2*i));
                }
            }
        }
        return chessboardPoints;
    }
}