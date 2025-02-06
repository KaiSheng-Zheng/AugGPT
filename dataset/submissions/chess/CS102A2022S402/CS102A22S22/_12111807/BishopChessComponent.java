import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> bishop = new ArrayList<>();
        ChessColor chessColor = getChessColor();
        ChessboardPoint source = getSource();
        int x = source.getX();
        int y = source.getY();

        //down-R
        for(int i = 1; i < 8 ;i++){
            if(x+i<8 && y+i<8 && x+i>=0 && y+i>=0){
                if(board[x+i][y+i].getChessColor() == ChessColor.NONE){
                    bishop.add(new ChessboardPoint(x+i,y+i));
                }
                else  if(board[x+i][y+i].getChessColor() == ChessColor.BLACK){
                    if(chessColor == ChessColor.WHITE){
                        bishop.add(new ChessboardPoint(x+i,y+i));
                    }
                    break;
                }
                else  if(board[x+i][y+i].getChessColor() == ChessColor.WHITE){
                    if(chessColor == ChessColor.BLACK){
                        bishop.add(new ChessboardPoint(x+i,y+i));
                    }
                    break;
                }
            }
            else{
                break;
            }
        }
        //down-L
        for(int i = 1; i < 8 ;i++){
            if(x-i<8 && y+i<8 && x-i>=0 && y+i>=0){
                if(board[x-i][y+i].getChessColor() == ChessColor.NONE){
                    bishop.add(new ChessboardPoint(x-i,y+i));
                }
                else  if(board[x-i][y+i].getChessColor() == ChessColor.BLACK){
                    if(chessColor == ChessColor.WHITE){
                        bishop.add(new ChessboardPoint(x-i,y+i));
                    }
                    break;
                }
                else  if(board[x-i][y+i].getChessColor() == ChessColor.WHITE){
                    if(chessColor == ChessColor.BLACK){
                        bishop.add(new ChessboardPoint(x-i,y+i));
                    }
                    break;
                }
            }
            else{
                break;
            }
        }
        //up-R
        for(int i = 1; i < 8 ;i++){
            if(x+i<8 && y-i<8 && x+i>=0 && y-i>=0){
                if(board[x+i][y-i].getChessColor() == ChessColor.NONE){
                    bishop.add(new ChessboardPoint(x+i,y-i));
                }
                else  if(board[x+i][y-i].getChessColor() == ChessColor.BLACK){
                    if(chessColor == ChessColor.WHITE){
                        bishop.add(new ChessboardPoint(x+i,y-i));
                    }
                    break;
                }
                else  if(board[x+i][y-i].getChessColor() == ChessColor.WHITE){
                    if(chessColor == ChessColor.BLACK){
                        bishop.add(new ChessboardPoint(x+i,y-i));
                    }
                    break;
                }
            }
            else{
                break;
            }
        }
        //up-L
        for(int i = 1; i < 8 ;i++){
            if(x-i<8 && y-i<8 && x-i>=0 && y-i>=0){
                if(board[x-i][y-i].getChessColor() == ChessColor.NONE){
                    bishop.add(new ChessboardPoint(x-i,y-i));
                }
                else  if(board[x-i][y-i].getChessColor() == ChessColor.BLACK){
                    if(chessColor == ChessColor.WHITE){
                        bishop.add(new ChessboardPoint(x-i,y-i));
                    }
                    break;
                }
                else  if(board[x-i][y-i].getChessColor() == ChessColor.WHITE){
                    if(chessColor == ChessColor.BLACK){
                        bishop.add(new ChessboardPoint(x-i,y-i));
                    }
                    break;
                }
            }
            else{
                break;
            }
        }

        return bishop;
    }
}
