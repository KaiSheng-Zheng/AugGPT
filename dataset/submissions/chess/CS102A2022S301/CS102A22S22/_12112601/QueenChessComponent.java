import java.util.List;

public class QueenChessComponent extends ChessComponent{


    public QueenChessComponent(char c, int i, int j, ChessComponent[][] chessComponents) {
        super(c,i,j,chessComponents);
    }

    public boolean thisCanMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (destination.getY()-source.getY() == destination.getX()-source.getX()) {
            for (int i=1;i<Math.abs(destination.getY()-source.getY());i++) {
                if(destination.getY()>source.getY()){
                    if (!(chessComponents[source.getX()+i][source.getY()+i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                } else {
                    if (!(chessComponents[source.getX()-i][source.getY()-i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
        } else if (destination.getY()-source.getY() == -destination.getX()+source.getX()) {
            for (int i=1;i<Math.abs(destination.getY()-source.getY());i++) {
                if(destination.getY()>source.getY()){
                    if (!(chessComponents[source.getX()-i][source.getY()+i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                } else {
                    if (!(chessComponents[source.getX()+i][source.getY()-i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
        } else { // Not on the same row or the same column.
            return false;
        }
        return true;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        cmt.clear();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (thisCanMoveTo(chessComponents,new ChessboardPoint(i,j))){
                    cmt.add(new ChessboardPoint(i,j));
                }
            }
        }
        cmt.removeIf(chessboardPoint -> getChessComponent(chessboardPoint).getChessColor()==getChessColor());
        return cmt;
    }
}
