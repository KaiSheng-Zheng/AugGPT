import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        int row = source.getX();
        int column = source.getY();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        if(row==1 && chessComponents[row][column].getChessColor()==ChessColor.BLACK){
            if(chessComponents[row+1][column]instanceof EmptySlotComponent){
                canMoveTo.add(new ChessboardPoint(row+1,column));
            }
            if(chessComponents[row+2][column]instanceof EmptySlotComponent){
                canMoveTo.add(new ChessboardPoint(row+2,column));
            }
            if(chessComponents[row+1][column+1].getChessColor()==ChessColor.WHITE){
                canMoveTo.add(new ChessboardPoint(row+1,column+1));
            }
            if(row+1<8 && row+1>-1 && column-1<8 && column-1>-1){
                if(chessComponents[row+1][column-1].getChessColor()==ChessColor.WHITE){
                    canMoveTo.add(new ChessboardPoint(row+1,column-1));
                }
            }
        }
        else if(row==6 && chessComponents[row][column].getChessColor()==ChessColor.WHITE){
            if(chessComponents[row-1][column]instanceof EmptySlotComponent){
                canMoveTo.add(new ChessboardPoint(row-1,column));
            }
            if(chessComponents[row-2][column]instanceof EmptySlotComponent){
                canMoveTo.add(new ChessboardPoint(row-2,column));
            }
            if(row-1<8 && row-1>-1 && column+1<8 && column+1>-1){
                if(chessComponents[row-1][column+1].getChessColor()==ChessColor.BLACK){
                    canMoveTo.add(new ChessboardPoint(row-1,column+1));
                }
            }
            if(row-1<8 && row-1>-1 && column-1<8 && column-1>-1){
                if(chessComponents[row-1][column-1].getChessColor()==ChessColor.BLACK){
                    canMoveTo.add(new ChessboardPoint(row-1,column-1));
                }
            }
        }else
        {
            if(chessComponents[row][column].getChessColor()==ChessColor.BLACK){
                if(row+1<8 && row+1>-1 && column+1<8 && column+1>-1){
                    if(chessComponents[row+1][column+1].getChessColor()==ChessColor.WHITE){
                        canMoveTo.add(new ChessboardPoint(row+1,column+1));
                    }
                }
                if(row+1<8 && row+1>-1 && column<8 && column>-1){
                    if(chessComponents[row+1][column] instanceof EmptySlotComponent){
                        canMoveTo.add(new ChessboardPoint(row+1,column));
                    }
                }
                if(row+1<8 && row+1>-1 && column-1<8 && column-1>-1){
                    if(chessComponents[row+1][column-1].getChessColor()==ChessColor.WHITE){
                        canMoveTo.add(new ChessboardPoint(row+1,column-1));
                    }
                }
            }
            if(chessComponents[row][column].getChessColor()==ChessColor.WHITE){
                if(row-1<8 && row-1>-1 && column+1<8 && column+1>-1){
                    if(chessComponents[row-1][column+1].getChessColor()==ChessColor.BLACK){
                        canMoveTo.add(new ChessboardPoint(row-1,column+1));
                    }
                }
                if(row-1<8 && row-1>-1 && column<8 && column>-1){
                    if(chessComponents[row-1][column] instanceof EmptySlotComponent){
                        canMoveTo.add(new ChessboardPoint(row-1,column));
                    }
                }
                if(row-1<8 && row-1>-1 && column-1<8 && column-1>-1){
                    if(chessComponents[row-1][column-1].getChessColor()==ChessColor.BLACK){
                        canMoveTo.add(new ChessboardPoint(row-1,column-1));
                    }
                }
            }
        }
        return canMoveTo;
    }
    public PawnChessComponent(ChessColor chessColor,ChessboardPoint source){
        this.setChessColor(chessColor);
        this.setSource(source);
        if (this.getChessColor()==chessColor.WHITE){
            this.setName('p');
        }else{
            this.setName('P');
        }
    }
}
