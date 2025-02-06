import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint chessboardPoint,ChessColor color) {
        if (color == ChessColor.BLACK){
            this.name='Q';
        }
        if (color == ChessColor.WHITE){
            this.name='q';
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
        for (int i = 0; i < 8; i++) {
            if (King.offset(-1-i,0)!=null){
                if (this.getChessboard()[x-1-i][y].getChessColor()!=this.getChessColor()) {
                    if (this.getChessboard()[x-1-i][y].getChessColor()!=ChessColor.NONE){
                        chessboardPoints.add(King.offset(-1-i,0));
                        break;
                    }
                    else {
                        chessboardPoints.add(King.offset(-1-i,0));
                    }
                }
                else {break;}
            }
        }
        for (int i = 0; i < 8; i++) {
            if (King.offset(1+i,0)!=null){
                if (this.getChessboard()[x+1+i][y].getChessColor()!=this.getChessColor()) {
                    if (this.getChessboard()[x+1+i][y].getChessColor()!=ChessColor.NONE){
                        chessboardPoints.add(King.offset(1+i,0));
                        break;
                    }
                    else {
                        chessboardPoints.add(King.offset(1+i,0));
                    }
                }
                else {break;}
            }
        }
        for (int i = 0; i < 8; i++) {
            if (King.offset(0,-1-i)!=null){
                if (this.getChessboard()[x][y-1-i].getChessColor()!=this.getChessColor()) {
                    if (this.getChessboard()[x][y-1-i].getChessColor()!=ChessColor.NONE){
                        chessboardPoints.add(King.offset(0,-1-i));
                        break;
                    }
                    else {
                        chessboardPoints.add(King.offset(0,-1-i));
                    }
                }
                else {break;}
            }
        }
        for (int i = 0; i < 8; i++) {
            if (King.offset(0,1+i)!=null){
                if (this.getChessboard()[x][y+1+i].getChessColor()!=this.getChessColor()) {
                    if (this.getChessboard()[x][y+1+i].getChessColor()!=ChessColor.NONE){
                        chessboardPoints.add(King.offset(0,1+i));
                        break;
                    }
                    else {
                        chessboardPoints.add(King.offset(0,1+i));
                    }
                }
                else {break;}
            }
        }
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