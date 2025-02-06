import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{


    public RookChessComponent(ChessboardPoint chessboardPoint, ChessColor color, char name) {
        super(chessboardPoint, color, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination = ConcreteChessGame.getChessComponents()[i][j].getSource();
                boolean determination = true;
                if (ConcreteChessGame.ChessComponents[i][j].getChessColor()!=getChessColor()){
                    if (source.getX() == destination.getX()) {
                        int row = source.getX();
                        for (int col = Math.min(source.getY(), destination.getY()) + 1;
                             col < Math.max(source.getY(), destination.getY()); col++) {
                            if (!(ConcreteChessGame.getChessComponents()[row][col] instanceof EmptySlotComponent)) {
                                determination = false;
                            }

                        }
                        if (determination)
                            list.add(destination);
                    } else if (source.getY() == destination.getY()) {
                        int col = source.getY();
                        for (int row = Math.min(source.getX(), destination.getX()) + 1;
                             row < Math.max(source.getX(), destination.getX()); row++) {
                            if (!(ConcreteChessGame.getChessComponents()[row][col] instanceof EmptySlotComponent)) {
                                determination = false;
                            }
                        }
                        if (determination)
                            list.add(destination);
                    }

                }
            }
        }
        return list;
    }
}
