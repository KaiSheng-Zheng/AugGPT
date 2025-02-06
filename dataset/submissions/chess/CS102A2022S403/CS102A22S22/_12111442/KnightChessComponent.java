import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class KnightChessComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    public KnightChessComponent(ChessColor chessColor,ChessboardPoint source) {
        this.chessColor=chessColor;
        this.source=source;
        switch (chessColor) {
            case BLACK:
                name = 'N';
                break;
            case WHITE:
                name = 'n';
                break;
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMovePoints=new ArrayList<>();
        ChessboardPoint origin=new ChessboardPoint(source.getX(),source.getY());
        canMovePoints.add(origin.offset(1,2));
        canMovePoints.add(origin.offset(-1,2));
        canMovePoints.add(origin.offset(2,-1));
        canMovePoints.add(origin.offset(2,1));
        canMovePoints.add(origin.offset(1,-2));
        canMovePoints.add(origin.offset(-1,-2));
        canMovePoints.add(origin.offset(-2,-1));
        canMovePoints.add(origin.offset(-2,1));
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
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}