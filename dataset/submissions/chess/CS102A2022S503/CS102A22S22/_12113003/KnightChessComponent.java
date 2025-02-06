import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessColor color) {
        if (color == ChessColor.BLACK) {
            name = 'N';
        }
        if (color == ChessColor.WHITE) {
            name = 'n';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMove = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        if(x-2>=0&&x-2<=7&&y-1>=0&&y-1<=7&&chessComponents[x-2][y-1].getChessColor()!=super.getChessColor()){
            canMove.add(new ChessboardPoint(x-2,y-1));
        }
        if(x-2>=0&&x-2<=7&&y+1>=0&&y+1<=7&&chessComponents[x-2][y+1].getChessColor()!=super.getChessColor()){
            canMove.add(new ChessboardPoint(x-2,y+1));
        }
        if(x-1>=0&&x-1<=7&&y-2>=0&&y-2<=7&&chessComponents[x-1][y-2].getChessColor()!=super.getChessColor()){
            canMove.add(new ChessboardPoint(x-1,y-2));
        }
        if(x-1>=0&&x-1<=7&&y+2>=0&&y+2<=7&&chessComponents[x-1][y+2].getChessColor()!=super.getChessColor()){
            canMove.add(new ChessboardPoint(x-1,y+2));
        }
        if(x+1>=0&&x+1<=7&&y-2>=0&&y-2<=7&&chessComponents[x+1][y-2].getChessColor()!=super.getChessColor()){
            canMove.add(new ChessboardPoint(x+1,y-2));
        }
        if(x+1>=0&&x+1<=7&&y+2>=0&&y+2<=7&&chessComponents[x+1][y+2].getChessColor()!=super.getChessColor()){
            canMove.add(new ChessboardPoint(x+1,y+2));
        }
        if(x+2>=0&&x+2<=7&&y-1>=0&&y-1<=7&&chessComponents[x+2][y-1].getChessColor()!=super.getChessColor()){
            canMove.add(new ChessboardPoint(x+2,y-1));
        }
        if(x+2>=0&&x+2<=7&&y+1>=0&&y+1<=7&&chessComponents[x+2][y+1].getChessColor()!=super.getChessColor()){
            canMove.add(new ChessboardPoint(x+2,y+1));
        }




        return canMove;
    }

}
