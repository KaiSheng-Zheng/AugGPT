import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint chessboardPoint,ChessColor color) {
        if (color == ChessColor.BLACK){
            this.name='K';
        }
        if (color == ChessColor.WHITE){
            this.name='k';
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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (King.offset(-1+i,-1+j)!=null){
                    if (this.getChessboard()[x-1+i][y-1+j].getChessColor()!=this.getChessColor()) {
                        chessboardPoints.add(King.offset(-1+i,-1+j));
                    }
                }
            }
        }
        return chessboardPoints;
    }
}
