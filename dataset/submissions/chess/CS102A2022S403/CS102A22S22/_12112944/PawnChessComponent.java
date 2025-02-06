import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(char name, ChessboardPoint source, ChessColor chessColor) {
        setName(name);
        setChessColor(chessColor);
        setSource(source);
    }

    @Override

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        ChessboardPoint source = getSource();

        if (source != null) {
            ChessColor chessColor = getChessColor();
            if ("BLACK".equals(chessColor.name())) {
                if (source.getX() == 1) {
                    if (CommonUtils.addWedigRook(chessColor.name(), source.getX() + 1, source.getY()) == 0) {
                        chessboardPointList.add(new ChessboardPoint(source.getX() + 1, source.getY()));
                        if (CommonUtils.addWedigRook(chessColor.name(), source.getX() + 2, source.getY()) == 0) {
                            chessboardPointList.add(new ChessboardPoint(source.getX() + 2, source.getY()));
                        }
                    }
                    if (source.getY() - 1 >= 0) {
                        if (CommonUtils.addWedigRook(chessColor.name(), source.getX() + 1, source.getY() - 1) == 1) {
                            chessboardPointList.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                        }
                    }
                    if (source.getY() + 1 < 8) {
                        if (CommonUtils.addWedigRook(chessColor.name(), source.getX() + 1, source.getY() + 1) == 1) {
                            chessboardPointList.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                        }
                    }
                } else {
                    if (source.getX() + 1 < 8) {
                        if (CommonUtils.addWedigRook(chessColor.name(), source.getX() + 1, source.getY()) == 0) {
                            chessboardPointList.add(new ChessboardPoint(source.getX() + 1, source.getY()));
                        }
                    }
                    if (source.getY() - 1 >= 0 && source.getX() + 1 < 8) {
                        if (CommonUtils.addWedigRook(chessColor.name(), source.getX() + 1, source.getY() - 1) == 1) {
                            chessboardPointList.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                        }
                    }
                    if (source.getY() + 1 < 8 && source.getX() + 1 < 8) {
                        if (CommonUtils.addWedigRook(chessColor.name(), source.getX() + 1, source.getY() + 1) == 1) {
                            chessboardPointList.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                        }
                    }
                }
            } else if ("WHITE".equals(chessColor.name())) {
                if (source.getX() == 6) {
                    if (CommonUtils.addWedigRook(chessColor.name(), source.getX() - 1, source.getY()) == 0) {
                        chessboardPointList.add(new ChessboardPoint(source.getX() - 1, source.getY()));
                        if (CommonUtils.addWedigRook(chessColor.name(), source.getX() - 2, source.getY()) == 0) {
                            chessboardPointList.add(new ChessboardPoint(source.getX() - 2, source.getY()));
                        }
                    }
                    if (CommonUtils.addWedigRook(chessColor.name(), source.getX() - 1, source.getY() - 1) == 1) {
                        chessboardPointList.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
                    }
                    if (CommonUtils.addWedigRook(chessColor.name(), source.getX() - 1, source.getY() + 1) == 1) {
                        chessboardPointList.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
                    }
                } else {
                    if (source.getX() - 1 >=0) {
                    if (CommonUtils.addWedigRook(chessColor.name(), source.getX() - 1, source.getY()) == 0) {
                        chessboardPointList.add(new ChessboardPoint(source.getX() - 1, source.getY()));
                    }
                }
                    if (source.getY() - 1 >= 0 && source.getX() - 1 >=0) {
                        if (CommonUtils.addWedigRook(chessColor.name(), source.getX() - 1, source.getY() - 1) == 1) {
                            chessboardPointList.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
                        }
                    }
                    if (source.getY() + 1 < 8 && source.getX() - 1 >=0) {
                        if (CommonUtils.addWedigRook(chessColor.name(), source.getX() + 1, source.getY() + 1) == 1) {
                            chessboardPointList.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                        }
                    }
                }
            }

        }
        return CommonUtils.sort(chessboardPointList);
    }
}