import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> queen = new ArrayList<>();
        ChessColor chessColor = getChessColor();
        ChessboardPoint source = getSource();
        int x = source.getX();
        int y = source.getY();

        //up
        for(int i = y-1;i >= 0;i--){
            if(board[x][i].getChessColor() == ChessColor.NONE){
                queen.add(new ChessboardPoint(x,i));
            }
            else  if(board[x][i].getChessColor() == ChessColor.BLACK){
                if(chessColor == ChessColor.WHITE){
                    queen.add(new ChessboardPoint(x,i));
                }
                break;
            }
            else  if(board[x][i].getChessColor() == ChessColor.WHITE){
                if(chessColor == ChessColor.BLACK){
                    queen.add(new ChessboardPoint(x,i));
                }
                break;
            }
        }
        //down
        for(int i = y+1;i <8 ;i++){
            if(board[x][i].getChessColor() == ChessColor.NONE){
                queen.add(new ChessboardPoint(x,i));
            }
            else  if(board[x][i].getChessColor() == ChessColor.BLACK){
                if(chessColor == ChessColor.WHITE){
                    queen.add(new ChessboardPoint(x,i));
                }
                break;
            }
            else  if(board[x][i].getChessColor() == ChessColor.WHITE){
                if(chessColor == ChessColor.BLACK){
                    queen.add(new ChessboardPoint(x,i));
                }
                break;
            }
        }
        //left
        for(int i = x-1;i >= 0;i--){
            if(board[i][y].getChessColor() == ChessColor.NONE){
                queen.add(new ChessboardPoint(i,y));
            }
            else  if(board[i][y].getChessColor() == ChessColor.BLACK){
                if(chessColor == ChessColor.WHITE){
                    queen.add(new ChessboardPoint(i,y));
                }
                break;
            }
            else  if(board[i][y].getChessColor() == ChessColor.WHITE){
                if(chessColor == ChessColor.BLACK){
                    queen.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }
        //right
        for(int i = x+1;i < 8;i++){
            if(board[i][y].getChessColor() == ChessColor.NONE){
                queen.add(new ChessboardPoint(i,y));
            }
            else  if(board[i][y].getChessColor() == ChessColor.BLACK){
                if(chessColor == ChessColor.WHITE){
                    queen.add(new ChessboardPoint(i,y));
                }
                break;
            }
            else  if(board[i][y].getChessColor() == ChessColor.WHITE){
                if(chessColor == ChessColor.BLACK){
                    queen.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }
        //down-R
        for(int i = 1; i < 8 ;i++){
            if(x+i<8 && y+i<8 && x+i>=0 && y+i>=0){
                if(board[x+i][y+i].getChessColor() == ChessColor.NONE){
                    queen.add(new ChessboardPoint(x+i,y+i));
                }
                else  if(board[x+i][y+i].getChessColor() == ChessColor.BLACK){
                    if(chessColor == ChessColor.WHITE){
                        queen.add(new ChessboardPoint(x+i,y+i));
                    }
                    break;
                }
                else  if(board[x+i][y+i].getChessColor() == ChessColor.WHITE){
                    if(chessColor == ChessColor.BLACK){
                        queen.add(new ChessboardPoint(x+i,y+i));
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
                    queen.add(new ChessboardPoint(x-i,y+i));
                }
                else  if(board[x-i][y+i].getChessColor() == ChessColor.BLACK){
                    if(chessColor == ChessColor.WHITE){
                        queen.add(new ChessboardPoint(x-i,y+i));
                    }
                    break;
                }
                else  if(board[x-i][y+i].getChessColor() == ChessColor.WHITE){
                    if(chessColor == ChessColor.BLACK){
                        queen.add(new ChessboardPoint(x-i,y+i));
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
                    queen.add(new ChessboardPoint(x+i,y-i));
                }
                else  if(board[x+i][y-i].getChessColor() == ChessColor.BLACK){
                    if(chessColor == ChessColor.WHITE){
                        queen.add(new ChessboardPoint(x+i,y-i));
                    }
                    break;
                }
                else  if(board[x+i][y-i].getChessColor() == ChessColor.WHITE){
                    if(chessColor == ChessColor.BLACK){
                        queen.add(new ChessboardPoint(x+i,y-i));
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
                    queen.add(new ChessboardPoint(x-i,y-i));
                }
                else  if(board[x-i][y-i].getChessColor() == ChessColor.BLACK){
                    if(chessColor == ChessColor.WHITE){
                        queen.add(new ChessboardPoint(x-i,y-i));
                    }
                    break;
                }
                else  if(board[x-i][y-i].getChessColor() == ChessColor.WHITE){
                    if(chessColor == ChessColor.BLACK){
                        queen.add(new ChessboardPoint(x-i,y-i));
                    }
                    break;
                }
            }
            else{
                break;
            }
        }

        return queen;
    }
}
