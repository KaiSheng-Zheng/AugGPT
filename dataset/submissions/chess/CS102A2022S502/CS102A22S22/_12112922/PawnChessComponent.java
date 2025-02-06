import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,ChessComponent[][] chessComponents){
//        super(source,chessColor);
        super.setChessColor(chessColor);
        super.setSource(source);
        this.chessComponents = chessComponents;
        if(chessColor == ChessColor.BLACK){
            super.name = 'P';
        }else{
            super.name = 'p';
        }
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo = new ArrayList<ChessboardPoint>();
        if(this.getChessColor()==ChessColor.BLACK){
            ChessboardPoint n1 = super.getSource().offset(1, 0);
            if(n1 != null && chessComponents[n1.getX()][n1.getY()].getChessColor()==ChessColor.NONE){
                canMoveTo.add(n1);
            }
            ChessboardPoint n2 = super.getSource().offset(2, 0);
            if(super.getSource().getX()==1&&chessComponents[n2.getX()][n2.getY()].getChessColor()==ChessColor.NONE){
                canMoveTo.add(n2);
            }
            ChessboardPoint n3 = super.getSource().offset(1,-1);
            if(n3 != null&&chessComponents[n3.getX()][n3.getY()].getChessColor()==ChessColor.WHITE){
                canMoveTo.add(n3);
            }
            ChessboardPoint n4 = super.getSource().offset(1,1);
            if(n4 != null&&chessComponents[n4.getX()][n4.getY()].getChessColor()==ChessColor.WHITE){
                canMoveTo.add(n4);
            }
        }
        if(this.getChessColor()==ChessColor.WHITE){
            ChessboardPoint n1 = super.getSource().offset(-1, 0);
            if(n1 != null && chessComponents[n1.getX()][n1.getY()].getChessColor()==ChessColor.NONE){
                canMoveTo.add(n1);
            }
            ChessboardPoint n2 = super.getSource().offset(-2, 0);
            if (super.getSource().getX()==6&&chessComponents[n2.getX()][n2.getY()].getChessColor()==ChessColor.NONE){
                canMoveTo.add(n2);
            }
            ChessboardPoint n3 = super.getSource().offset(-1,-1);
            if(n3 != null&&chessComponents[n3.getX()][n3.getY()].getChessColor()==ChessColor.BLACK){
                canMoveTo.add(n3);
            }
            ChessboardPoint n4 = super.getSource().offset(-1,1);
            if(n4 != null&&chessComponents[n4.getX()][n4.getY()].getChessColor()==ChessColor.BLACK){
                canMoveTo.add(n4);
            }
        }
        return canMoveTo;
    }
    public void updateBoard(ChessComponent[][] newBoard){
        this.chessComponents = newBoard;
    }
}
