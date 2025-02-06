import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(char name) {
        super(name);
    }
    public PawnChessComponent(char name, ChessboardPoint source) {
        super(name, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int row = getSource().getX();
        int col = getSource().getY();
        ArrayList<ChessboardPoint> pawnDest = new ArrayList<>();
        switch (getChessColor()){
            case WHITE -> whiteMove(row,col,pawnDest);
            case BLACK -> blackMove(row,col,pawnDest);
       }

       return pawnDest;
    }

    private void whiteMove(int row,int col,ArrayList<ChessboardPoint> pawnDest){
        if (row == 6){
            if (getChessBoard()[row-1][col].getName()=='_'){
                pawnDest.add(new ChessboardPoint(row-1,col));
                if (getChessBoard()[row-2][col].getName()=='_') {pawnDest.add(new ChessboardPoint(row-2, col));}
            }
            if (col-1>=0){
                if (getChessBoard()[row-1][col-1].getName()!='_' && getChessBoard()[row-1][col-1].getChessColor().equals(ChessColor.BLACK)){
                    pawnDest.add(new ChessboardPoint(row-1,col-1));
                }
            }
            if (col+1<=7){
                if (getChessBoard()[row-1][col+1].getName()!='_' && getChessBoard()[row-1][col+1].getChessColor().equals(ChessColor.BLACK)){
                    pawnDest.add(new ChessboardPoint(row-1,col+1));
                }
            }
        }else if (row<6 && row>0){
            if (getChessBoard()[row-1][col].getName()=='_'){pawnDest.add(new ChessboardPoint(row-1,col));}
            if (col-1>=0){
                if (getChessBoard()[row-1][col-1].getName()!='_' && getChessBoard()[row-1][col-1].getChessColor().equals(ChessColor.BLACK)){
                    pawnDest.add(new ChessboardPoint(row-1,col-1));
                }
            }
            if (col+1<=7){
                if (getChessBoard()[row-1][col+1].getName()!='_' && getChessBoard()[row-1][col+1].getChessColor().equals(ChessColor.BLACK)){
                    pawnDest.add(new ChessboardPoint(row-1,col+1));
                }
            }
        }
    }

    private void blackMove(int row,int col,ArrayList<ChessboardPoint> pawnDest){
        if (row == 1){
            if (getChessBoard()[row+1][col].getName() == '_'){
                pawnDest.add(new ChessboardPoint(row+1,col));
                if (getChessBoard()[row+2][col].getName() == '_'){pawnDest.add(new ChessboardPoint(row+2,col));}
            }
            if (col-1>=0){
                if (getChessBoard()[row+1][col-1].getName()!='_' && getChessBoard()[row+1][col-1].getChessColor().equals(ChessColor.WHITE)){
                    pawnDest.add(new ChessboardPoint(row+1,col-1));
                }
            }
            if (col+1<=7){
                if (getChessBoard()[row+1][col+1].getName()!='_' && getChessBoard()[row+1][col+1].getChessColor().equals(ChessColor.WHITE)){
                    pawnDest.add(new ChessboardPoint(row+1,col+1));
                }
            }
        }else if (row>1 && row<7){
            if (getChessBoard()[row+1][col].getName()=='_'){pawnDest.add(new ChessboardPoint(row+1,col));}
            if (col-1>=0){
                if (getChessBoard()[row+1][col-1].getName()!='_' && getChessBoard()[row+1][col-1].getChessColor().equals(ChessColor.WHITE)){
                    pawnDest.add(new ChessboardPoint(row+1,col-1));
                }
            }
            if (col+1<=7){
                if (getChessBoard()[row+1][col+1].getName()!='_' && getChessBoard()[row+1][col+1].getChessColor().equals(ChessColor.WHITE)){
                    pawnDest.add(new ChessboardPoint(row+1,col+1));
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
