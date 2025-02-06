import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends  ChessComponent{
    public PawnChessComponent(ChessColor chessColor) {
        super(chessColor);
    }

    public PawnChessComponent(ChessboardPoint source) {
        super(source);
    }

    public PawnChessComponent() {
    }

    public PawnChessComponent(ChessComponent[][] chessboard) {
        super(chessboard);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        int row = this.getSource().getX();
        int col = this.getSource().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint destination=chessboard[i][j].getSource();
                if(this.getChessColor()==ChessColor.WHITE&&this.getChessColor()!=chessboard[i][j].getChessColor()){
                    if(i == -1 + row  && j==col&&chessboard[i][j] instanceof EmptySlotComponent){a.add(destination);}
                    else if(i == -2 + row && j==col&&row==6&&chessboard[i][j] instanceof EmptySlotComponent&&chessboard[row-1][col] instanceof EmptySlotComponent){a.add(destination);}
                    else if(!(chessboard[i][j] instanceof EmptySlotComponent)&&i==row-1&&j==col-1){a.add(destination);}
                    else if(!(chessboard[i][j] instanceof EmptySlotComponent)&&i==row-1&&j==col+1){a.add(destination);}
            }
                else if(this.getChessColor()==ChessColor.BLACK&&this.getChessColor()!=chessboard[i][j].getChessColor()){
                    if(i == 1 + row  && j==col&&chessboard[i][col] instanceof EmptySlotComponent){a.add(destination);}
                    else if(i == 2 + row && j==col&&row==1&&chessboard[row+2][col] instanceof EmptySlotComponent&&chessboard[row+2][col] instanceof EmptySlotComponent){a.add(destination);}
                    else if(!(chessboard[i][j] instanceof EmptySlotComponent)&&i==row+1&&j==col-1){a.add(destination);}
                    else if(!(chessboard[i][j] instanceof EmptySlotComponent)&&i==row+1&&j==col+1){a.add(destination);}
                }
        }
    }
        return a;
    }
    @Override
    public String toString() {
        if(super.getChessColor()==ChessColor.WHITE){
            return "p";
        }
        else{
            return"P";
        }
    }
}
