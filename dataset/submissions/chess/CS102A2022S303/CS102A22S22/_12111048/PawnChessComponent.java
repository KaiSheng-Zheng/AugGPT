

import java.util.List;
import java.util.ArrayList;

public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = source;
        this.chessColor = chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();

        int x = this.getSource().getX();
        int y = this.getSource().getY();

        if ("WHITE".equalsIgnoreCase(this.chessColor.name()) && x == 6) {
            ChessComponent chessComponent = ChessComponent.chessComponents[x - 1][y];
            if (chessComponent instanceof EmptySlotComponent) {
                addGoPoint(chessboardPointList, x, y, 2);
            }
            addGoPoint(chessboardPointList, x, y, 1);
            addEatPoint(chessboardPointList, x, y, "BLACK");
        } else if ("WHITE".equalsIgnoreCase(this.chessColor.name()) && x != 6) {
            addGoPoint(chessboardPointList, x, y, 1);
            addEatPoint(chessboardPointList, x, y, "BLACK");
        }

        if ("BLACK".equalsIgnoreCase(this.chessColor.name()) && x == 1) {
            ChessComponent chessComponent = ChessComponent.chessComponents[x + 1][y];
            if (chessComponent instanceof EmptySlotComponent) {
                addGoPoint(chessboardPointList, x, y, -2);
            }
            addGoPoint(chessboardPointList, x, y, -1);
            addEatPoint(chessboardPointList, x, y, "WHITE");
        } else if ("BLACK".equalsIgnoreCase(this.chessColor.name()) && x != 1) {
            addGoPoint(chessboardPointList, x, y, -1);
            addEatPoint(chessboardPointList, x, y, "WHITE");
        }


        return chessboardPointList;
    }

    private void addGoPoint(List<ChessboardPoint> chessboardPointList, int x, int y, int num) {
        //go
        ChessComponent chessComponent = ChessComponent.chessComponents[x - num][y];
        if (chessComponent instanceof EmptySlotComponent) {
            ChessboardPoint firstPoint = this.getSource().offset(-num, 0);
            if (firstPoint != null) {
                chessboardPointList.add(firstPoint);
            }
        }
    }

    private void addEatPoint(List<ChessboardPoint> chessboardPointList, int x, int y, String opponentColor) {
        //eat
        for (int dx = -1; dx < 2; dx++) {
            for (int dy = dx; dy < 2; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }
                ChessComponent chessComponent1 = ChessComponent.chessComponents[x + dx][y + dx];
                if (chessComponent1.getChessColor() != null
                        && opponentColor.equalsIgnoreCase(chessComponent1.getChessColor().name())) {
                    ChessboardPoint eatPoint = this.getSource().offset(dx, dy);
                    if (eatPoint != null) {
                        chessboardPointList.add(eatPoint);
                    }
                }
            }
        }
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}
