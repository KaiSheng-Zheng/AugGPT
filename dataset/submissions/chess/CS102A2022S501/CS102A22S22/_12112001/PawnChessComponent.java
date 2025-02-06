import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint,ChessColor chesscolor,char name){
        super(chessboardPoint,chesscolor,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> h=new ArrayList<>();
        ChessboardPoint source=getChessboardPoint();

        int x = source.getX();
        int y = source.getY();
        if (getChessColor().equals(ChessColor.WHITE)){
            for(int i=0;i<8;i++) {
                for (int j = 0; j < 8; j++) {
                    ChessboardPoint dest = ConcreteChessGame.getChessComponents()[i][j].getChessboardPoint();
                    if (x == 6) {
                        if (dest.getX() == x - 1 && dest.getY() == y && ConcreteChessGame.getChessComponents()[x - 1][y] instanceof EmptySlotComponent) {
                            h.add(dest);
                        } else if (dest.getX() == x - 2 && dest.getY() == y && ConcreteChessGame.getChessComponents()[x - 2][y] instanceof EmptySlotComponent&&ConcreteChessGame.getChessComponents()[x - 1][y] instanceof EmptySlotComponent) {
                            h.add(dest);
                        } else if (dest.getY() == y - 1 && dest.getX() == x - 1) {
                            if (ConcreteChessGame.getChessComponents()[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                                h.add(dest);
                            }
                        } else if (dest.getY() == y + 1 && dest.getX() == x - 1) {
                            if (ConcreteChessGame.getChessComponents()[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                                h.add(dest);
                            }
                        }
                    }
                    if (x != 6) {
                        if (dest.getX() == x - 1 && dest.getY() == y && (ConcreteChessGame.getChessComponents()[x - 1][y] instanceof EmptySlotComponent)) {
                            h.add(dest);
                        } else if (dest.getY() == y - 1 && dest.getX() == x - 1) {
                            if (ConcreteChessGame.getChessComponents()[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                                h.add(dest);
                            }
                        } else if (dest.getY() == y + 1 && dest.getX() == x - 1) {
                            if (ConcreteChessGame.getChessComponents()[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                                h.add(dest);
                            }
                        }
                    }
                }
            }
        }
        if(getChessColor().equals(ChessColor.BLACK)){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint dest = ConcreteChessGame.getChessComponents()[i][j].getChessboardPoint();
                if (x == 1) {
                    if (dest.getX() == x + 1 && dest.getY() == y && (ConcreteChessGame.getChessComponents()[x + 1][y] instanceof EmptySlotComponent)) {
                        h.add(dest);
                    } else if (dest.getX() == x + 2 && dest.getY() == y && (ConcreteChessGame.getChessComponents()[x + 2][y] instanceof EmptySlotComponent)&&ConcreteChessGame.getChessComponents()[x + 1][y] instanceof EmptySlotComponent) {
                        h.add(dest);
                    } else if (dest.getY() == y + 1 && dest.getX() == x + 1) {
                        if (ConcreteChessGame.getChessComponents()[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                            h.add(dest);
                        }
                    } else if (dest.getY() == y - 1 && dest.getX() == x + 1) {
                        if (ConcreteChessGame.getChessComponents()[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                            h.add(dest);
                        }
                    }
                }
                if (x != 1) {
                    if (dest.getX() == x + 1 && dest.getY() == y && (ConcreteChessGame.getChessComponents()[x + 1][y] instanceof EmptySlotComponent)) {
                        h.add(dest);
                    } else if (dest.getY() == y + 1 && dest.getX() == x + 1) {
                        if (ConcreteChessGame.getChessComponents()[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                            h.add(dest);
                        }
                    } else if (dest.getY() == y - 1 && dest.getX() == x + 1) {
                        if (ConcreteChessGame.getChessComponents()[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                            h.add(dest);
                        }
                    }
                }
            }
        }


            }


        return h;
        }

}
