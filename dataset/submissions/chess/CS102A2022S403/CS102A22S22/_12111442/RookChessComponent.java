import java.util.ArrayList;
import java.util.List;

class RookChessComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color

    public RookChessComponent(ChessColor chessColor,ChessboardPoint source) {
        this.chessColor=chessColor;
        this.source=source;
        switch (chessColor) {
            case BLACK:
                name = 'R';
                break;
            case WHITE:
                name = 'r';
                break;
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        ChessboardPoint origin = new ChessboardPoint(source.getX(),source.getY());
        for (int i=1;i<8;i++){
            canMovePoints.add(origin.offset(i,0));
            canMovePoints.add(origin.offset(-i,0));
            canMovePoints.add(origin.offset(0,-i));
            canMovePoints.add(origin.offset(0,i));}
        for(int i=0;i<canMovePoints.size();i++){
            if(canMovePoints.get(i)==source){
                canMovePoints.remove(i);
            }
        }
        return canMovePoints;
    }


    public ChessColor getChessColor() {
        return chessColor;
    }
}