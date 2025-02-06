import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class KingChessComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;
    public KingChessComponent(ChessColor chessColor,ChessboardPoint source) {
        this.chessColor=chessColor;
        this.source=source;
        switch (chessColor) {
            case BLACK:
                name = 'K';
                break;
            case WHITE:
                name = 'k';
                break;
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMovePoints=new ArrayList<>();
        ChessboardPoint origin=new ChessboardPoint(source.getX(),source.getY());
        canMovePoints.add(origin.offset(1,0));
        canMovePoints.add(origin.offset(-1,0));
        canMovePoints.add(origin.offset(0,-1));
        canMovePoints.add(origin.offset(0,1));
        canMovePoints.add(origin.offset(1,1));
        canMovePoints.add(origin.offset(1,-1));
        canMovePoints.add(origin.offset(-1,-1));
        canMovePoints.add(origin.offset(-1,1));
        canMovePoints.removeIf(Objects::isNull);
        for (int i=0;i<canMovePoints.size();i++) {
            int x = canMovePoints.get(i).getX();
            int y = canMovePoints.get(i).getY();
            if(chessComponents[x][y]!=null) {
                if (chessComponents[x][y].getChessColor() == chessColor) {
                    canMovePoints.remove(canMovePoints.get(i));
                    i--;
                }
            }
        }
        return canMovePoints;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }
}

