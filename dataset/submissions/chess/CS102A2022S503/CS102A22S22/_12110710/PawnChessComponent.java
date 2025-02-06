import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][]wholeChessGame;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor,char name) {
        super(source,chessColor,name);
    }

    public void setWholeChessGame(ChessComponent[][] wholeChessGame){
        this.wholeChessGame=wholeChessGame;
    }
    
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> preAnswer = new ArrayList<>();
        if (chessColor == ChessColor.BLACK) {
            if (source.getX() == 1) {//no move
                if (wholeChessGame[source.getX() + 1][source.getY()] instanceof EmptySlotComponent) {
                    preAnswer.add(new ChessboardPoint(source.getX() + 1, source.getY()));
                }
                if (wholeChessGame[source.getX() + 2][source.getY()] instanceof EmptySlotComponent) {
                    preAnswer.add(new ChessboardPoint(source.getX() + 2, source.getY()));
                }
                if (source.getY() > 0&&source.getY()<=7) {
                    if (wholeChessGame[source.getX() + 1][source.getY() - 1].getChessColor() == ChessColor.WHITE) {
                        preAnswer.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                    }
                }
                if(source.getY()<7&&source.getY()>=0) {
                    if (wholeChessGame[source.getX() + 1][source.getY() + 1].getChessColor() == ChessColor.WHITE) {
                        preAnswer.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                    }
                }
            } else {
                if (source.getX() < 7&&source.getX()>=1) {
                    if (wholeChessGame[source.getX() + 1][source.getY()] instanceof EmptySlotComponent) {
                        preAnswer.add(new ChessboardPoint(source.getX() + 1, source.getY()));
                    }
                    if (source.getY() > 0) {
                        if (wholeChessGame[source.getX() + 1][source.getY() - 1].getChessColor() == ChessColor.WHITE) {
                            preAnswer.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                        }
                    }
                    if (source.getY() < 7) {
                        if (wholeChessGame[source.getX() + 1][source.getY() + 1].getChessColor() == ChessColor.WHITE) {
                            preAnswer.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                        }
                    }
                }
            }
        }
        return preAnswer;
    }
}
