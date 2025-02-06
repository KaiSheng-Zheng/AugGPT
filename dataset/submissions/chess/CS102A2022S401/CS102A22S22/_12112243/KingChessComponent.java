import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint  source ,ChessColor chessColor, char name,ChessComponent[][] chessComponents ){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents = chessComponents;
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> validPoint = new ArrayList<>();
        if (chessColor == ChessColor.BLACK) {
                    if (!(source.offset(-1, 0) == null)) {
                        if(chessComponents[source.offset(-1, 0).getX()][source.offset(-1, 0).getY()].chessColor != ChessColor.BLACK)
                        validPoint.add(source.offset(-1, 0));
                    }
                    if (!(source.offset(-1, 1) == null)) {
                        if(chessComponents[source.offset(-1, 1).getX()][source.offset(-1, 1).getY()].chessColor != ChessColor.BLACK)
                            validPoint.add(source.offset(-1, 1));
                    }
                    if (!(source.offset(0, 1) == null)) {
                        if(chessComponents[source.offset(0, 1).getX()][source.offset(0, 1).getY()].chessColor != ChessColor.BLACK)
                            validPoint.add(source.offset(0, 1));
                    }
                    if (!(source.offset(1, 1) == null)) {
                        if(chessComponents[source.offset(1, 1).getX()][source.offset(1, 1).getY()].chessColor != ChessColor.BLACK)
                            validPoint.add(source.offset(1, 1));
                    }
                    if (!(source.offset(1, 0) == null)) {
                        if(chessComponents[source.offset(1, 0).getX()][source.offset(1, 0).getY()].chessColor != ChessColor.BLACK)
                            validPoint.add(source.offset(1, 0));
                    }
                    if (!(source.offset(1, -1) == null)) {
                        if(chessComponents[source.offset(1, -1).getX()][source.offset(1, -1).getY()].chessColor != ChessColor.BLACK)
                            validPoint.add(source.offset(1, -1));
                    }
                    if (!(source.offset(0, -1) == null)) {
                        if(chessComponents[source.offset(0, -1).getX()][source.offset(0, -1).getY()].chessColor != ChessColor.BLACK)
                            validPoint.add(source.offset(0, -1));
                    }
                    if (!(source.offset(-1, -1) == null)) {
                        if(chessComponents[source.offset(-1, -1).getX()][source.offset(-1, -1).getY()].chessColor != ChessColor.BLACK)
                            validPoint.add(source.offset(-1, -1));
                    }
                } else {
                    if (!(source.offset(-1, 0) == null)) {
                        if(chessComponents[source.offset(-1, 0).getX()][source.offset(-1, 0).getY()].chessColor != ChessColor.WHITE)
                            validPoint.add(source.offset(-1, 0));
                    }
                    if (!(source.offset(-1, 1) == null)) {
                        if(chessComponents[source.offset(-1, 1).getX()][source.offset(-1, 1).getY()].chessColor != ChessColor.WHITE)
                            validPoint.add(source.offset(-1, 1));
                    }
                    if (!(source.offset(0, 1) == null)) {
                        if(chessComponents[source.offset(0, 1).getX()][source.offset(0, 1).getY()].chessColor != ChessColor.WHITE)
                            validPoint.add(source.offset(0, 1));
                    }
                    if (!(source.offset(1, 1) == null)) {
                        if(chessComponents[source.offset(1, 1).getX()][source.offset(1, 1).getY()].chessColor != ChessColor.WHITE)
                            validPoint.add(source.offset(1, 1));
                    }
                    if (!(source.offset(1, 0) == null)) {
                        if(chessComponents[source.offset(1, 0).getX()][source.offset(1, 0).getY()].chessColor != ChessColor.WHITE)
                            validPoint.add(source.offset(1, 0));
                    }
                    if (!(source.offset(1, -1) == null)) {
                        if(chessComponents[source.offset(1, -1).getX()][source.offset(1, -1).getY()].chessColor != ChessColor.WHITE)
                            validPoint.add(source.offset(1, -1));
                    }
                    if (!(source.offset(0, -1) == null)) {
                        if(chessComponents[source.offset(0, -1).getX()][source.offset(0, -1).getY()].chessColor != ChessColor.WHITE)
                            validPoint.add(source.offset(0, -1));
                    }
                    if (!(source.offset(-1, -1) == null)) {
                        if(chessComponents[source.offset(-1, -1).getX()][source.offset(-1, -1).getY()].chessColor != ChessColor.WHITE)
                            validPoint.add(source.offset(-1, -1));
                    }
                }
        if (validPoint.size() == 0) {
            return new ArrayList<>();
        } else {
            return validPoint;
        }
        }
    }
