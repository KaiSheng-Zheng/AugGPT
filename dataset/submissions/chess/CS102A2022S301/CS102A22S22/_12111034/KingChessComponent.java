import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveToPoint = new ArrayList<>();
        ConcreteChessGame king = new ConcreteChessGame();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i== getSource().getX()){
                    if (j== getSource().getY()+1 &&
                            king.getChess(i,j).getChessColor()!=king.getChess(getSource().getX(), getSource().getY()).getChessColor()){
                        canMoveToPoint.add(new ChessboardPoint(i, j));
                    }else if (j== getSource().getY()-1 &&
                            king.getChess(i,j).getChessColor()!=king.getChess(getSource().getX(), getSource().getY()).getChessColor()){
                        canMoveToPoint.add(new ChessboardPoint(i,j));
                    }
                }else if (i== getSource().getX()+1){
                    if (j== getSource().getY()+1 &&
                            king.getChess(i,j).getChessColor()!=king.getChess(getSource().getX(), getSource().getY()).getChessColor()){
                        canMoveToPoint.add(new ChessboardPoint(i, j));
                    }else if (j== getSource().getY()-1 &&
                            king.getChess(i,j).getChessColor()!=king.getChess(getSource().getX(), getSource().getY()).getChessColor()){
                        canMoveToPoint.add(new ChessboardPoint(i,j));
                    }else if (j== getSource().getY()&&king.getChess(i,j).getChessColor()!=king.getChess(getSource().getX(), getSource().getY()).getChessColor()

                    ){
                        canMoveToPoint.add(new ChessboardPoint(i, j));
                    }
                }else if (i== getSource().getX()-1){
                    if (j== getSource().getY()+1 &&
                            king.getChess(i,j).getChessColor()!=king.getChess(getSource().getX(), getSource().getY()).getChessColor()){
                        canMoveToPoint.add(new ChessboardPoint(i, j));
                    }else if (j== getSource().getY()-1 &&
                            king.getChess(i,j).getChessColor()!=king.getChess(getSource().getX(), getSource().getY()).getChessColor()){
                        canMoveToPoint.add(new ChessboardPoint(i,j));
                    }else if (j== getSource().getY()&&king.getChess(i,j).getChessColor()!=king.getChess(getSource().getX(), getSource().getY()).getChessColor()){
                        canMoveToPoint.add(new ChessboardPoint(i, j));
                    }
                }

            }
        }
            return canMoveToPoint;
    }
}
