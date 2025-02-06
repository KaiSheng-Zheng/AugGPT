import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    boolean moved = false;//false >> haven't been moved
    public PawnChessComponent(ChessColor chessColor) {
        this.setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            setName('P');
        }else if (chessColor == ChessColor.WHITE){
            setName('p');
        }
        setChessColor(chessColor);
    }
    public PawnChessComponent(ChessColor chessColor,ChessboardPoint source) {
        this.setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            setName('P');
        }else if (chessColor == ChessColor.WHITE){
            setName('p');
        }
        setChessColor(chessColor);
        setSource(source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>(0);
        ChessboardPoint a = getChessboardPoint();
        ChessColor oppositeColor = ChessColor.NONE;
        if (this.getChessColor() == ChessColor.WHITE){
            oppositeColor = ChessColor.BLACK;
        }else if (this.getChessColor() == ChessColor.BLACK){
            oppositeColor = ChessColor.WHITE;
        }
//        if (one.offset(-i,0)==null){
//            break;
//        }
//        if (chessGame.getChess(one.offset(-i,0)).getChessColor() == this.getChessColor()){
//            break;
//        }
//        result.add(one.offset(-i,0));
//        if (chessGame.getChess(one.offset(-i,0)).getChessColor() == oppositeColor){
//            break;
//        }
        if (getChessColor() == ChessColor.WHITE){
            if (a.offset(-1,0)!=null){
                if (chessGame.getChess(a.offset(-1,0)).getChessColor() != ChessColor.BLACK && chessGame.getChess(a.offset(-1,0)).getChessColor() != ChessColor.WHITE){
                    result.add(a.offset(-1,0));
                }
            }
            if (a.offset(-2,0)!=null){
                if (chessGame.getChess(a.offset(-1,0)).getChessColor() != ChessColor.BLACK && chessGame.getChess(a.offset(-1,0)).getChessColor() != ChessColor.WHITE){
                    result.add(a.offset(-2,0));
                }
            }
            if (a.offset(-1,1)!=null){
                if (chessGame.getChess((a.offset(-1,1))).getChessColor() == oppositeColor){
                    result.add(a.offset(-1,1));
                }
            }
            if (a.offset(-1,-1)!=null){
                if (chessGame.getChess((a.offset(-1,-1))).getChessColor() == oppositeColor){
                    result.add(a.offset(-1,-1));
                }
            }
        }else if (getChessColor() == ChessColor.BLACK){
            if (a.offset(1,0)!=null){
                if (chessGame.getChess(a.offset(-1,0)).getChessColor() != ChessColor.BLACK && chessGame.getChess(a.offset(-1,0)).getChessColor() != ChessColor.WHITE){
                    result.add(a.offset(1,0));
                }
            }
            if (a.offset(2,0)!=null){
                if (chessGame.getChess(a.offset(-1,0)).getChessColor() != ChessColor.BLACK && chessGame.getChess(a.offset(-1,0)).getChessColor() != ChessColor.WHITE){
                    result.add(a.offset(2,0));
                }
            }
            if (a.offset(1,1)!=null){
                if (chessGame.getChess((a.offset(1,1))).getChessColor() == oppositeColor){
                    result.add(a.offset(1,1));
                }
            }
            if (a.offset(1,-1)!=null){
                if (chessGame.getChess((a.offset(1,-1))).getChessColor() == oppositeColor){
                    result.add(a.offset(1,-1));
                }
            }
        }
        return result;

    }
}
