

import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = source;
        this.chessColor = chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();

        int x = this.source.getX();
        int y = this.source.getY();

//1
        for (int i = 1; x - i >= 0 && y + i < 8; i++) {
            ChessComponent chessComponent = ChessComponent.chessComponents[x - i][y + i];
            if (chessComponent instanceof EmptySlotComponent) {
                ChessboardPoint point = this.getSource().offset(-i, i);
                if (point != null) {
                    chessboardPointList.add(point);
                }
            }else {
                if (chessComponent.getChessColor().name().equalsIgnoreCase(this.chessColor.name())) {
                    //same
                    break;
                } else {
                    //difference
                    ChessboardPoint point = this.getSource().offset(-i, i);
                    if (point != null) {
                        chessboardPointList.add(point);
                    }
                    break;
                }
            }
        }

        //2
        for (int i = 1; x - i >= 0 && y - i >= 0; i++) {
            ChessComponent chessComponent = ChessComponent.chessComponents[x - i][y - i];
            if (chessComponent instanceof EmptySlotComponent) {
                ChessboardPoint point = this.getSource().offset(-i, -i);
                if (point != null) {
                    chessboardPointList.add(point);
                }
            }else {
                if (chessComponent.getChessColor().name().equalsIgnoreCase(this.chessColor.name())) {
                    //same
                    break;
                } else {
                    //difference
                    ChessboardPoint point = this.getSource().offset(-i, -i);
                    if (point != null) {
                        chessboardPointList.add(point);
                    }
                    break;
                }
            }
        }

        //3
        for (int i = 1; x + i < 8 && y - i >= 0; i++) {
            ChessComponent chessComponent = ChessComponent.chessComponents[x + i][y - i];
            if (chessComponent instanceof EmptySlotComponent) {
                ChessboardPoint point = this.getSource().offset(i, -i);
                if (point != null) {
                    chessboardPointList.add(point);
                }
            }else {
                if (chessComponent.getChessColor().name().equalsIgnoreCase(this.chessColor.name())) {
                    //same
                    break;
                } else {
                    //difference
                    ChessboardPoint point = this.getSource().offset(i, -i);
                    if (point != null) {
                        chessboardPointList.add(point);
                    }
                    break;
                }
            }
        }

        //4
        for (int i = 1; x + i < 8 && y + i < 8; i++) {
            ChessComponent chessComponent = ChessComponent.chessComponents[x + i][y + i];
            if (chessComponent instanceof EmptySlotComponent) {
                ChessboardPoint point = this.getSource().offset(i, i);
                if (point != null) {
                    chessboardPointList.add(point);
                }
            }else {
                if (chessComponent.getChessColor().name().equalsIgnoreCase(this.chessColor.name())) {
                    //same
                    break;
                } else {
                    //difference
                    ChessboardPoint point = this.getSource().offset(i, i);
                    if (point != null) {
                        chessboardPointList.add(point);
                    }
                    break;
                }
            }
        }

        return chessboardPointList;
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
