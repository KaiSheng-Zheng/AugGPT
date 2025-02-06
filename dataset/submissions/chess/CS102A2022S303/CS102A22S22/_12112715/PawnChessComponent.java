import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source) {
        this.chessComponents = chessComponents;
        setSource(source);
        if (name == 'P') {
            this.name = 'P';
            setChessColor(ChessColor.BLACK);
        } else if (name == 'p') {
            this.name = 'p';
            setChessColor(ChessColor.WHITE);
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> output = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                ChessComponent chess = chessComponents[i][j];
                //if two chess components have the same color, refuse to move
                if (getChessColor() == chess.getChessColor()) {
                    continue;
                }
                ChessboardPoint destination = new ChessboardPoint(i, j);
                if (getChessColor() == ChessColor.WHITE) {
                    if (source.getY() == destination.getY() && source.getX() - destination.getX() == 1) {
                        if (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent) {
                            output.add(new ChessboardPoint(i, j));
                        }
                    } else if (Math.abs(source.getY() - destination.getY()) == 1 && source.getX() - destination.getX() == 1) {
                        if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                            output.add(new ChessboardPoint(i, j));
                        }
                    } else if (source.getY() == destination.getY() && source.getX() - destination.getX() == 2 && source.getX() == 6) {
                        if (chessComponents[destination.getX() - 1][destination.getY()] instanceof EmptySlotComponent) {
                            if (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent) {
                                output.add(new ChessboardPoint(i, j));
                            }
                        }
                    }
                }
                if (getChessColor() == ChessColor.BLACK) {
                    if (source.getY() == destination.getY() && source.getX() - destination.getX() == -1) {
                        if (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent) {
                            output.add(new ChessboardPoint(i, j));
                        }
                    } else if (Math.abs(source.getY() - destination.getY()) == 1 && source.getX() - destination.getX() == -1) {
                        if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                            output.add(new ChessboardPoint(i, j));
                        }
                    } else if (source.getY() == destination.getY() && source.getX() - destination.getX() == -2 && source.getX() == 1) {
                        if (chessComponents[destination.getX() + 1][destination.getY()] instanceof EmptySlotComponent) {
                            if (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent) {
                                output.add(new ChessboardPoint(i, j));
                            }
                        }
                    }
                }
            }
        }
        return output;
    }
}
