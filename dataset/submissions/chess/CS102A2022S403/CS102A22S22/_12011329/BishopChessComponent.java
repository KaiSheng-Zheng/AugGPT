import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint chessboardPoint,ChessColor color) {
        if (color == ChessColor.BLACK){
            this.name='B';
        }
        if (color == ChessColor.WHITE){
            this.name='b';
        }
//        ChessComponent[][] components=new ChessComponent[8][8];
        this.setSource(chessboardPoint);
        this.setChessColor(color);
        this.setChessboard(this.getChessboard());
    }

    public List<ChessboardPoint> canMoveTo(){
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        ChessboardPoint King=new ChessboardPoint(x,y);
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (King.offset(-1-i,-1-i)!=null){
                if (this.getChessboard()[x-1-i][y-1-i].getChessColor()!=this.getChessColor()) {
                    if (this.getChessboard()[x-1-i][y-1-i].getChessColor()!=ChessColor.NONE){
                        chessboardPoints.add(King.offset(-1-i,-1-i));
                        break;
                    }
                    else {
                        chessboardPoints.add(King.offset(-1-i,-1-i));
                    }
                }
                else {break;}
            }
        }
        for (int i = 0; i < 8; i++) {
            if (King.offset(-1-i,1+i)!=null){
                if (this.getChessboard()[x-1-i][y+1+i].getChessColor()!=this.getChessColor()) {
                    if (this.getChessboard()[x-1-i][y+1+i].getChessColor()!=ChessColor.NONE){
                        chessboardPoints.add(King.offset(-1-i,1+i));
                        break;
                    }
                    else {
                        chessboardPoints.add(King.offset(-1-i,1+i));
                    }
                }
                else {break;}
            }
        }
        for (int i = 0; i < 8; i++) {
            if (King.offset(1+i,-1-i)!=null){
                if (this.getChessboard()[x+1+i][y-1-i].getChessColor()!=this.getChessColor()) {
                    if (this.getChessboard()[x+1+i][y-1-i].getChessColor()!=ChessColor.NONE){
                        chessboardPoints.add(King.offset(1+i,-1-i));
                        break;
                    }
                    else {
                        chessboardPoints.add(King.offset(1+i,-1-i));
                    }
                }
                else {break;}
            }
        }
        for (int i = 0; i < 8; i++) {
            if (King.offset(1+i,1+i)!=null){
                if (this.getChessboard()[x+1+i][y+1+i].getChessColor()!=this.getChessColor()) {
                    if (this.getChessboard()[x+1+i][y+1+i].getChessColor()!=ChessColor.NONE){
                        chessboardPoints.add(King.offset(1+i,1+i));
                        break;
                    }
                    else {
                        chessboardPoints.add(King.offset(1+i,1+i));
                    }
                }
                else {break;}
            }
        }
        return chessboardPoints;
    }
}