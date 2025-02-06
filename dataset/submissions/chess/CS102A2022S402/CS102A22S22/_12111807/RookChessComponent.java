import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> rook = new ArrayList<>();
        ChessColor chessColor = getChessColor();
        ChessboardPoint source = getSource();
        int x = source.getX();
        int y = source.getY();
        //up
        for(int i = y-1;i >= 0;i--){
            if(board[x][i].getChessColor() == ChessColor.NONE){
                rook.add(new ChessboardPoint(x,i));
            }
            else  if(board[x][i].getChessColor() == ChessColor.BLACK){
                if(chessColor == ChessColor.WHITE){
                    rook.add(new ChessboardPoint(x,i));
                }
                break;
            }
            else  if(board[x][i].getChessColor() == ChessColor.WHITE){
                if(chessColor == ChessColor.BLACK){
                    rook.add(new ChessboardPoint(x,i));
                }
                break;
            }
        }
        //down
        for(int i = y+1;i <8 ;i++){
            if(board[x][i].getChessColor() == ChessColor.NONE){
                rook.add(new ChessboardPoint(x,i));
            }
            else  if(board[x][i].getChessColor() == ChessColor.BLACK){
                if(chessColor == ChessColor.WHITE){
                    rook.add(new ChessboardPoint(x,i));
                }
                break;
            }
            else  if(board[x][i].getChessColor() == ChessColor.WHITE){
                if(chessColor == ChessColor.BLACK){
                    rook.add(new ChessboardPoint(x,i));
                }
                break;
            }
        }
        //left
        for(int i = x-1;i >= 0;i--){
            if(board[i][y].getChessColor() == ChessColor.NONE){
                rook.add(new ChessboardPoint(i,y));
            }
            else  if(board[i][y].getChessColor() == ChessColor.BLACK){
                if(chessColor == ChessColor.WHITE){
                    rook.add(new ChessboardPoint(i,y));
                }
                break;
            }
            else  if(board[i][y].getChessColor() == ChessColor.WHITE){
                if(chessColor == ChessColor.BLACK){
                    rook.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }
        //right
        for(int i = x+1;i < 8;i++){
            if(board[i][y].getChessColor() == ChessColor.NONE){
                rook.add(new ChessboardPoint(i,y));
            }
            else  if(board[i][y].getChessColor() == ChessColor.BLACK){
                if(chessColor == ChessColor.WHITE){
                    rook.add(new ChessboardPoint(i,y));
                }
                break;
            }
            else  if(board[i][y].getChessColor() == ChessColor.WHITE){
                if(chessColor == ChessColor.BLACK){
                    rook.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }
        return rook;
    }
}
