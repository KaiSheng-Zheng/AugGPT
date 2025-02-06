import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Pawn = new ArrayList<>();
        ChessboardPoint source = getSource();
        int targetX = source.getX();
        int targetY = source.getY();
        if (this.getChessColor()==ChessColor.WHITE){
            if (source.getX()==6){
                if (0<=targetX-1&&targetX-1<=7&&0<=targetY-1&&targetY-1<=7){
                    if (!(chessboard[targetX-1][targetY-1] instanceof EmptySlotComponent) && chessboard[targetX-1][targetY-1].getChessColor() != this.getChessColor()){
                        Pawn.add(chessboard[targetX-1][targetY-1].getSource());
                    }
                }
                if (0<=targetX-1&&targetX-1<=7&&0<=targetY&&targetY<=7){
                    if (chessboard[targetX-1][targetY] instanceof EmptySlotComponent){
                        Pawn.add(chessboard[targetX-1][targetY].getSource());
                    }
                }
                if (0<=targetX-2&&targetX-2<=7&&0<=targetY&&targetY<=7){
                    if (chessboard[targetX-2][targetY] instanceof EmptySlotComponent){
                        Pawn.add(chessboard[targetX-2][targetY].getSource());
                    }
                }
                if (0<=targetX-1&&targetX-1<=7&&0<=targetY+1&&targetY+1<=7){
                    if (!(chessboard[targetX-1][targetY+1] instanceof EmptySlotComponent) && chessboard[targetX-1][targetY+1].getChessColor() != this.getChessColor()){
                        Pawn.add(chessboard[targetX-1][targetY+1].getSource());
                    }
                }
            }
            else if (source.getX()<6){
                if (0<=targetX-1&&targetX-1<=7&&0<=targetY-1&&targetY-1<=7){
                    if (!(chessboard[targetX-1][targetY-1] instanceof EmptySlotComponent) && chessboard[targetX-1][targetY-1].getChessColor() != this.getChessColor()){
                        Pawn.add(chessboard[targetX-1][targetY-1].getSource());
                    }
                }
                if (0<=targetX-1&&targetX<=7&&0<=targetY&&targetY<=7){
                    if (chessboard[targetX-1][targetY] instanceof EmptySlotComponent){
                        Pawn.add(chessboard[targetX-1][targetY].getSource());
                    }
                }
                if (0<=targetX-1&&targetX-1<=7&&0<=targetY+1&&targetY+1<=7){
                    if (!(chessboard[targetX-1][targetY+1] instanceof EmptySlotComponent) && chessboard[targetX-1][targetY+1].getChessColor() != this.getChessColor()){
                        Pawn.add(chessboard[targetX-1][targetY+1].getSource());
                    }
                }
            }
        }
        else if (this.getChessColor()==ChessColor.BLACK){
            if (source.getX()==1){
                if (0<=targetX+1&&targetX+1<=7&&0<=targetY-1&&targetY-1<=7){
                    if (!(chessboard[targetX+1][targetY-1] instanceof EmptySlotComponent) && chessboard[targetX+1][targetY-1].getChessColor() != this.getChessColor()){
                        Pawn.add(chessboard[targetX+1][targetY-1].getSource());
                    }
                }
                if (0<=targetX+1&&targetX+1<=7&&0<=targetY&&targetY<=7){
                    if (chessboard[targetX+1][targetY] instanceof EmptySlotComponent){
                        Pawn.add(chessboard[targetX+1][targetY].getSource());
                    }
                }
                if (0<=targetX+2&&targetX+2<=7&&0<=targetY&&targetY<=7){
                    if (chessboard[targetX+2][targetY] instanceof EmptySlotComponent){
                        Pawn.add(chessboard[targetX+2][targetY].getSource());
                    }
                }
                if (0<=targetX+1&&targetX+1<=7&&0<=targetY+1&&targetY+1<=7){
                    if (!(chessboard[targetX+1][targetY+1] instanceof EmptySlotComponent) && chessboard[targetX-1][targetY+1].getChessColor() != this.getChessColor()){
                        Pawn.add(chessboard[targetX+1][targetY+1].getSource());
                    }
                }
            }
            else if (source.getX()>1){
                if (0<=targetX+1&&targetX+1<=7&&0<=targetY-1&&targetY-1<=7){
                    if (!(chessboard[targetX+1][targetY-1] instanceof EmptySlotComponent) && chessboard[targetX-1][targetY-1].getChessColor() != this.getChessColor()){
                        Pawn.add(chessboard[targetX+1][targetY-1].getSource());
                    }
                }
                if (0<=targetX+1&&targetX+1<=7&&0<=targetY&&targetY<=7){
                    if (chessboard[targetX+1][targetY] instanceof EmptySlotComponent){
                        Pawn.add(chessboard[targetX+1][targetY].getSource());
                    }
                }
               if (0<=targetX+1&&targetX+1<=7&&0<=targetY+1&&targetY+1<=7){
                    if (!(chessboard[targetX+1][targetY+1] instanceof EmptySlotComponent) && chessboard[targetX-1][targetY+1].getChessColor() != this.getChessColor()){
                        Pawn.add(chessboard[targetX+1][targetY+1].getSource());
                    }
                }
            }
        }
        return Pawn;
    }
}
