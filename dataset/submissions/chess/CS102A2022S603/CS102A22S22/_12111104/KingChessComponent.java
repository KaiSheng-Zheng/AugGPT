import java.util.LinkedList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessboardPoint chessboardPoint;
    private ChessColor chessColor;
    private ChessComponent[][] chessComponents;

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponent) {
        this.chessColor = chessColor;
        chessboardPoint = source;
        this.name = name;
        this.chessComponents = chessComponent;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.chessboardPoint = chessboardPoint;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> point = new LinkedList<>();
        if (chessColor == ChessColor.BLACK) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (chessboardPoint.offset(i,j)!=null) {
                        if (chessComponents[chessboardPoint.getX() + i][chessboardPoint.getY() + j].getChessColor() == ChessColor.WHITE||chessComponents[chessboardPoint.getX() + i][chessboardPoint.getY() + j] instanceof EmptySlotComponent)
                            point.add(chessboardPoint.offset(i, j));
                    }
                }
            }
            return point;
        }else {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (chessboardPoint.offset(i,j)!=null) {
                        if (chessComponents[chessboardPoint.getX() + i][chessboardPoint.getY() + j].getChessColor() == ChessColor.BLACK||chessComponents[chessboardPoint.getX() + i][chessboardPoint.getY() + j] instanceof EmptySlotComponent)
                            point.add(chessboardPoint.offset(i, j));
                    }
                }
            }
            return point;
        }
    }
//        if (chessColor == ChessColor.WHITE) {
//            if (chessboardPoint.getX()==0&&chessboardPoint.getY()!=0&&chessboardPoint.getY()!=7){
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() + 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX()+1, chessboardPoint.getY()+1 ));
//                }
//                return point;
//            }
//            if (chessboardPoint.getY()==0&&chessboardPoint.getX()!=0&&chessboardPoint.getX()!=7){
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()].getChessColor() != ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX() - 1][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() + 1));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() + 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX()+1, chessboardPoint.getY()+1 ));
//                }
//                return point;
//            }
//            if (chessboardPoint.getX()==7&&chessboardPoint.getY()!=0&&chessboardPoint.getY()!=7){
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()-1].getChessColor() != ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() - 1));
//                }
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()].getChessColor() != ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX() - 1][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() + 1));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() + 1));
//                }
//                return point;
//            }
//            if (chessboardPoint.getY()==7&&chessboardPoint.getX()!=0&&chessboardPoint.getX()!=7){
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()-1].getChessColor() != ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() - 1));
//                }
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()].getChessColor() != ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY()));
//                }
//                return point;
//            }
//            if (chessboardPoint.getX()==0&&chessboardPoint.getY()==0){
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() + 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX()+1, chessboardPoint.getY()+1 ));
//                }
//                return point;
//            }
//            if (chessboardPoint.getX()==0&&chessboardPoint.getY()==7){
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY()));
//                }
//                return point;
//            }
//            if (chessboardPoint.getX()==7&&chessboardPoint.getY()==0){
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()].getChessColor() != ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX() - 1][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() + 1));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() + 1));
//                }
//                return point;
//            }
//            if (chessboardPoint.getX()==7&&chessboardPoint.getY()==7){
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()-1].getChessColor() != ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() - 1));
//                }
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()].getChessColor() != ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1].getChessColor() == ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() - 1));
//                }
//                return point;
//            }
//            if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()-1].getChessColor() != ChessColor.WHITE) {
//                point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() - 1));
//            }
//             if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()].getChessColor() != ChessColor.WHITE) {
//                 point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY()));
//             }
//             if (chessComponents[chessboardPoint.getX() - 1][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                 point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() + 1));
//             }
//             if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1].getChessColor() == ChessColor.BLACK) {
//                 point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() - 1));
//             }
//             if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                 point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() + 1));
//             }
//             if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1].getChessColor() == ChessColor.BLACK) {
//                 point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY() - 1));
//             }
//             if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()].getChessColor() == ChessColor.BLACK) {
//                 point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY()));
//             }
//             if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1].getChessColor() == ChessColor.BLACK) {
//                point.add(new ChessboardPoint(chessboardPoint.getX()+1, chessboardPoint.getY()+1 ));
//            }
//        }else {
//            if (chessboardPoint.getX()==0&&chessboardPoint.getY()!=0&&chessboardPoint.getY()!=7){
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() + 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX()+1, chessboardPoint.getY()+1 ));
//                }
//                return point;
//            }
//            if (chessboardPoint.getY()==0&&chessboardPoint.getX()!=0&&chessboardPoint.getX()!=7){
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()].getChessColor() != ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX() - 1][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()+1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() + 1));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() + 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX()+1, chessboardPoint.getY()+1 ));
//                }
//                return point;
//            }
//            if (chessboardPoint.getX()==7&&chessboardPoint.getY()!=0&&chessboardPoint.getY()!=7){
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()-1].getChessColor() != ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() - 1));
//                }
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()].getChessColor() != ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX() - 1][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()+1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() + 1));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() + 1));
//                }
//                return point;
//            }
//            if (chessboardPoint.getY()==7&&chessboardPoint.getX()!=0&&chessboardPoint.getX()!=7){
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()-1].getChessColor() != ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() - 1));
//                }
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()].getChessColor() != ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY()));
//                }
//                return point;
//            }
//            if (chessboardPoint.getX()==0&&chessboardPoint.getY()==0){
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() + 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()+1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX()+1, chessboardPoint.getY()+1 ));
//                }
//                return point;
//            }
//            if (chessboardPoint.getX()==0&&chessboardPoint.getY()==7){
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()-1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY() - 1));
//                }
//                if (chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()+1 ][chessboardPoint.getY()].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY()));
//                }
//                return point;
//            }
//            if (chessboardPoint.getX()==7&&chessboardPoint.getY()==0){
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()].getChessColor() != ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX() - 1][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()+1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() + 1));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()+1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() + 1));
//                }
//                return point;
//            }
//            if (chessboardPoint.getX()==7&&chessboardPoint.getY()==7){
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()-1].getChessColor() != ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() - 1));
//                }
//                if ( chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()].getChessColor() != ChessColor.BLACK) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY()));
//                }
//                if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1].getChessColor() == ChessColor.WHITE) {
//                    point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() - 1));
//                }
//                return point;
//            }
//            if (chessComponents[chessboardPoint.getX() - 1][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()-1].getChessColor() == ChessColor.WHITE) {
//                point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() - 1));
//            }
//             if (chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()].getChessColor() != ChessColor.BLACK) {
//                 point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY()));
//             }
//             if (chessComponents[chessboardPoint.getX() - 1][chessboardPoint.getY()+1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() -1][chessboardPoint.getY()+1].getChessColor() == ChessColor.WHITE) {
//                 point.add(new ChessboardPoint(chessboardPoint.getX() - 1, chessboardPoint.getY() + 1));
//             }
//             if (chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() ][chessboardPoint.getY()-1].getChessColor() == ChessColor.WHITE) {
//                 point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() - 1));
//             }
//                 if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY() + 1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX()][chessboardPoint.getY() + 1].getChessColor() == ChessColor.WHITE) {
//                     point.add(new ChessboardPoint(chessboardPoint.getX(), chessboardPoint.getY() + 1));
//                 }
//                     if (chessComponents[chessboardPoint.getX() + 1][chessboardPoint.getY() - 1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() + 1][chessboardPoint.getY() - 1].getChessColor() == ChessColor.WHITE) {
//                         point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY() - 1));
//                     }
//                         if (chessComponents[chessboardPoint.getX() + 1][chessboardPoint.getY()] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() + 1][chessboardPoint.getY()].getChessColor() == ChessColor.WHITE) {
//                             point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY()));
//                         }
//                             if (chessComponents[chessboardPoint.getX() + 1][chessboardPoint.getY() + 1] instanceof EmptySlotComponent || chessComponents[chessboardPoint.getX() + 1][chessboardPoint.getY() + 1].getChessColor() == ChessColor.WHITE) {
//                                 point.add(new ChessboardPoint(chessboardPoint.getX() + 1, chessboardPoint.getY() + 1));
//                             }
//                         }
//                         return point;

    public void setSource(ChessboardPoint source) {
        this.chessboardPoint = source;
    }
}