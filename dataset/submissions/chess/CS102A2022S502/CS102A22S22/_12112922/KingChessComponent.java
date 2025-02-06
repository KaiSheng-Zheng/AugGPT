import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,ChessComponent[][] chessComponents){
//        super(source,chessColor);
        super.setChessColor(chessColor);
        super.setSource(source);
        this.chessComponents = chessComponents;
        if(chessColor == ChessColor.BLACK){
            super.name = 'K';
        }else {
            super.name = 'k';
        }
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo = new ArrayList<ChessboardPoint>();
        ChessboardPoint n1 = super.getSource().offset(-1,-1);
        //if newPoint is on the board
        //if newPoint is occupied by the same color pieces
        if (n1 != null&&chessComponents[n1.getX()][n1.getY()].getChessColor()!=super.getChessColor()) {
            canMoveTo.add(n1);
        }
        ChessboardPoint n2 = super.getSource().offset(-1,0);
        if (n2 != null&&chessComponents[n2.getX()][n2.getY()].getChessColor()!=super.getChessColor()) {
            canMoveTo.add(n2);
        }
        ChessboardPoint n3 = super.getSource().offset(-1,1);
        if (n3 != null&&chessComponents[n3.getX()][n3.getY()].getChessColor()!=super.getChessColor()) {
            canMoveTo.add(n3);
        }
        ChessboardPoint n4 = super.getSource().offset(0,-1);
        if (n4 != null&&chessComponents[n4.getX()][n4.getY()].getChessColor()!=super.getChessColor()) {
            canMoveTo.add(n4);
        }
        ChessboardPoint n5 = super.getSource().offset(0,1);
        if (n5 != null&&chessComponents[n5.getX()][n5.getY()].getChessColor()!=super.getChessColor()) {
            canMoveTo.add(n5);
        }
        ChessboardPoint n6 = super.getSource().offset(1,-1);
        if (n6 != null&&chessComponents[n6.getX()][n6.getY()].getChessColor()!=super.getChessColor()) {
            canMoveTo.add(n6);
        }
        ChessboardPoint n7 = super.getSource().offset(1,0);
        if (n7 != null&&chessComponents[n7.getX()][n7.getY()].getChessColor()!=super.getChessColor()) {
            canMoveTo.add(n7);
        }
        ChessboardPoint n8 = super.getSource().offset(1,1);
        if (n8 != null&&chessComponents[n8.getX()][n8.getY()].getChessColor()!=super.getChessColor()) {
            canMoveTo.add(n8);
        }
        return canMoveTo;
    }
    public void updateBoard(ChessComponent[][] newBoard){
        this.chessComponents = newBoard;
    }
}
