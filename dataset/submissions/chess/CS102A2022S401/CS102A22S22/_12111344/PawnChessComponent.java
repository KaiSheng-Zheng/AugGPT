import java.util.ArrayList;
import java.util.List;
public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor chessColor,ChessboardPoint source,char name){
        super(chessColor,source,name);
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo=new ArrayList<ChessboardPoint>();
        if(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor.equals(ChessColor.BLACK)) {
            if (source.getX() == 1) {
                    if (ConcreteChessGame.chessComponent[source.getX()+1][source.getY()].chessColor.equals(ChessColor.NONE)) {
                        canMoveTo.add(new ChessboardPoint(source.getX()+1, source.getY()));
                        if (source.getX() + 1 < 8 & source.getY() + 1 < 8 & ConcreteChessGame.chessComponent[source.getX() + 1][source.getY() + 1].chessColor.equals(ChessColor.WHITE)) {
                            canMoveTo.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                        }
                        if (source.getY() -1 >= 0 & source.getX() + 1 < 8 & ConcreteChessGame.chessComponent[source.getX() + 1][source.getY()- 1].chessColor.equals(ChessColor.WHITE)) {
                            canMoveTo.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                        }
                        if (ConcreteChessGame.chessComponent[source.getX()+2][source.getY()].chessColor.equals(ChessColor.NONE)) {
                                canMoveTo.add(new ChessboardPoint(source.getX()+2, source.getY()));
                        }
                    }

            }else if (source.getX()+1<8 &ConcreteChessGame.chessComponent[source.getX()+1][source.getY()].chessColor.equals(ChessColor.NONE)) {
                canMoveTo.add(new ChessboardPoint(source.getX()+1, source.getY()));
                if (source.getX() +1 < 8 & source.getY() + 1 < 8 & ConcreteChessGame.chessComponent[source.getX() + 1][source.getY() + 1].chessColor.equals(ChessColor.WHITE)) {
                    canMoveTo.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                }
                if (source.getX() +1 >8 & source.getY() - 1 >=0 & ConcreteChessGame.chessComponent[source.getX() +1][source.getY() - 1].chessColor.equals(ChessColor.WHITE)) {
                    canMoveTo.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                }
            }

        }
        if(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor.equals(ChessColor.WHITE)) {
            if (source.getX() == 6) {
                    if (ConcreteChessGame.chessComponent[source.getX()-1][source.getY()].chessColor.equals(ChessColor.NONE)) {
                        canMoveTo.add(new ChessboardPoint(source.getX()-1, source.getY()));
                        if (source.getY()-1>=0&ConcreteChessGame.chessComponent[source.getX()- 1][source.getY()- 1].chessColor.equals(ChessColor.BLACK)) {
                            canMoveTo.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
                        }
                        if (source.getY()+1<8&ConcreteChessGame.chessComponent[source.getX() - 1][source.getY() + 1].chessColor.equals(ChessColor.BLACK)) {
                            canMoveTo.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
                        }
                        if (ConcreteChessGame.chessComponent[source.getX()-2][source.getY()].chessColor.equals(ChessColor.NONE)) {
                                canMoveTo.add(new ChessboardPoint(source.getX()-2, source.getY()));
                        }
                    }

            }else if (source.getX()-1>=0 & ConcreteChessGame.chessComponent[source.getX()-1][source.getY()].chessColor.equals(ChessColor.NONE)) {
                canMoveTo.add(new ChessboardPoint(source.getX()-1, source.getY()));
                if (source.getY() + 1 < 8 & source.getX() - 1 >=0 & ConcreteChessGame.chessComponent[source.getX() - 1][source.getY() + 1].chessColor.equals(ChessColor.BLACK)) {
                    canMoveTo.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
                }
                if (source.getX() - 1 >= 0 & source.getY() - 1 >=0 & ConcreteChessGame.chessComponent[source.getX() - 1][source.getY() - 1].chessColor.equals(ChessColor.BLACK)) {
                    canMoveTo.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
                }
            }
        }
        return canMoveTo;}
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
