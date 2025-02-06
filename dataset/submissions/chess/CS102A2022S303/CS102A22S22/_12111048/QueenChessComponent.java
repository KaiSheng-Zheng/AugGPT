

import java.util.List;
import java.util.ArrayList;

public class QueenChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = source;
        this.chessColor = chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();

        //up
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        for (int x1 = x-1; x1 >= 0; x1--) {
            ChessboardPoint point = this.getSource().offset(x1-x, 0);
            if (point != null) {
                ChessComponent chessComponent = ChessComponent.chessComponents[x1][y];
                if ('_' == chessComponent.name) {
                    chessboardPointList.add(point);
                    continue;
                }

                if (chessComponent.getChessColor().name().equalsIgnoreCase(this.chessColor.name())) {
                    //same
                    break;
                } else {
                    //difference
                    chessboardPointList.add(point);
                    break;
                }
            }
        }

        //down
        for (int x2 = x+1; x2 < 8; x2++) {
            ChessboardPoint point = this.getSource().offset(x2-x, 0);
            if (point != null) {
                ChessComponent chessComponent = ChessComponent.chessComponents[x2][y];
                if ('_' == chessComponent.name) {
                    chessboardPointList.add(point);
                    continue;
                }

                if (chessComponent.getChessColor().name().equalsIgnoreCase(this.chessColor.name())) {
                    //same
                    break;
                } else {
                    //difference
                    chessboardPointList.add(point);
                    break;
                }
            }
        }

        //left
        for (int y1 = y-1; y1 >= 0; y1--) {
            ChessboardPoint point = this.getSource().offset(0, y1-y);
            if (point != null) {
                ChessComponent chessComponent = ChessComponent.chessComponents[x][y1];
                if ('_' == chessComponent.name) {
                    chessboardPointList.add(point);
                    continue;
                }

                if (chessComponent.getChessColor().name().equalsIgnoreCase(this.chessColor.name())) {
                    //same
                    break;
                } else {
                    //difference
                    chessboardPointList.add(point);
                    break;
                }
            }
        }

        //right
        for (int y2 = y+1; y2 < 8; y2++) {
            ChessboardPoint point = this.getSource().offset(0, y2-y);
            if (point != null) {
                ChessComponent chessComponent = ChessComponent.chessComponents[x][y2];
                if ('_' == chessComponent.name) {
                    chessboardPointList.add(point);
                    continue;
                }

                if (chessComponent.getChessColor().name().equalsIgnoreCase(this.chessColor.name())) {
                    //same
                    break;
                } else {
                    //difference
                    chessboardPointList.add(point);
                    break;
                }
            }
        }

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
