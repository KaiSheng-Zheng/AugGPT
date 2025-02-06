import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    ChessComponent[][] chessComponents;
    int x; int y;
    public PawnChessComponent(int x, int y, char name) {
        super(x,y,name);
        this.name = 'P';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i <7 ; i++) {
            for (int j = 0; j < 7; j++) {
                ChessboardPoint destination = new ChessboardPoint(i, j);
                if (getChessColor() == ChessColor.BLACK) {
                    if (source.getX() == 1 && source.getX() + 1 == destination.getX() && source.getY() == destination.getY()) {
                        int row = source.getX() + 1;
                        int col = source.getY();
                        if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                            canMoveTo.add(destination);
                        }
                    }
                    if (source.getX() == 1 && source.getX() + 2 == destination.getX() && source.getY() == destination.getY()) {
                        int row = source.getX() + 2;
                        int col = source.getY();
                        if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                            canMoveTo.add(destination);
                        }

                    }
                    if (source.getX() >= 1 && source.getX() <= 6 && source.getX() + 1 == destination.getX() && source.getY() == destination.getY()) {
                        int row = source.getX() + 1;
                        int col = source.getY();
                        if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                            canMoveTo.add(destination);
                        }

                    }
                    if (source.getX() >= 1 && source.getX() <= 6 && source.getX() + 1 == destination.getX() && (source.getY() + 1 == destination.getY())) {
                        int row = source.getX() + 1;
                        int col1 = source.getY() + 1;
                        if ((chessboard[row][col1] instanceof EmptySlotComponent)) {
                            canMoveTo.add(destination);
                        }

                    }
                    if (source.getX() >= 1 && source.getX() <= 6 && source.getX() + 1 == destination.getX() && (source.getY() - 1 == destination.getY())){
                        int row = source.getX() + 1;
                        int col2 = source.getY() - 1;
                        if ((chessboard[row][col2] instanceof EmptySlotComponent)) {
                            canMoveTo.add(destination);
                        }

                    }
                }
                if (getChessColor() == ChessColor.WHITE) {
                    if (source.getX() == 6 && source.getX() - 1 == destination.getX() && source.getY() == destination.getY()) {
                        int row = source.getX() - 1;
                        int col = source.getY();
                        if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                            canMoveTo.add(destination);
                        }

                    }
                    if (source.getX() == 6 && source.getX() - 2 == destination.getX() && source.getY() == destination.getY()) {
                        int row = source.getX() - 2;
                        int col = source.getY();
                        if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                            canMoveTo.add(destination);
                        }

                    }
                    if (source.getX() <= 6 && source.getX() >= 1 && source.getX() - 1 == destination.getX() && source.getY() == destination.getY()) {
                        int row = source.getX() - 1;
                        int col = source.getY();
                        if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                            canMoveTo.add(destination);
                        }

                    }
                    if (source.getX() >= 1 && source.getX() <=6 && source.getX() - 1 == destination.getX() && (source.getY() + 1 == destination.getY())) {
                        int row = source.getX() - 1;
                        int col1 = source.getY() + 1;
                        if ((chessboard[row][col1] instanceof EmptySlotComponent)) {
                            canMoveTo.add(destination);
                        }

                    }
                    if (source.getX() >= 1 && source.getX() <= 6 && source.getX() - 1 == destination.getX() && (source.getY() - 1 == destination.getY())){
                        int row = source.getX() - 1;
                        int col2 = source.getY() - 1;
                        if ((chessboard[row][col2] instanceof EmptySlotComponent)) {
                            canMoveTo.add(destination);
                        }

                    }
                }
                }
        }
        return canMoveTo;
        }

    }

