import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public ConcreteChessGame concreteChessGame;


    public BishopChessComponent(ConcreteChessGame concreteChessGame) {
        this.concreteChessGame = concreteChessGame;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<String> chessboard = concreteChessGame.getCurrentchessboard();

        List<ChessboardPoint> rightLocation = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(i - super.source.getX()) == Math.abs(j - super.source.getY()) && i - super.source.getX() != 0) {
                    boolean can = true;

                    int dx = i - super.source.getX();
                    int dy = j - super.source.getY();
                    if (dx * dy > 0) {
                        int beginX = Math.min(i, super.source.getX());
                        int beginY = Math.min(j, super.source.getY());
                        for (int col = 1; col < Math.abs(i - super.source.getX()); col++) {
                            if (chessboard.get(beginX + col).charAt(beginY + col) != '_') {
                                can = false;
                            }
                        }
                    }
                    if (dx * dy < 0) {
                        if (dx < 0) {
                            for (int col = 1; col < Math.abs(i - super.source.getX()); col++) {
                                int x0=source.getX();
                                int y0=source.getY();
                                if (chessboard.get(i + col).charAt(j - col) != '_') {
                                    can = false;

                                }
                            }
                        }
                        if (dy < 0) {
                            for (int col = 1; col < Math.abs(i - super.source.getX()); col++) {
                                if (chessboard.get(i - col).charAt(j + col) != '_') {
                                    can = false;

                                }

                            }
                        }}
                    if (super.chessColor==ChessColor.WHITE&&Character.isLowerCase(chessboard.get(i).charAt(j))){
                        can=false;
                    }
                    if (super.chessColor==ChessColor.BLACK&&Character.isUpperCase(chessboard.get(i).charAt(j))){
                        can=false;
                    }
                    if (can) {
                            rightLocation.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }


            return rightLocation;
        }
    }

