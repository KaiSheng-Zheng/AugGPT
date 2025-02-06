import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);this.source=source;this.name=name;this.chessColor=chessColor;this.chessComponents=chessComponents;

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(moveChess(source.getX(),source.getY(),i,j)){
                    result.add(new ChessboardPoint(i,j));
                }
            }
        }
        return result;
    }
    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int cases = 0;
        ChessColor chessColor1 = chessComponents[targetX][targetY].getChessColor();
        ChessColor chessColor2 = chessComponents[sourceX][sourceY].getChessColor();
        if (chessColor1 != chessColor2) {
            if (sourceX != targetX && sourceY != targetY) {
                if ((Math.abs(sourceX - targetX) == 2 && Math.abs(source.getY() - targetY) == 1) ||
                        (Math.abs(sourceY - targetY) == 2 && Math.abs(sourceX - targetX) == 1)) {
                    cases = 1;
                }

            }

        }switch (cases) {
            case 0 -> {
                return false;
            }
            case 1 -> {
                return true;
            }
        }
        return false;
    }}