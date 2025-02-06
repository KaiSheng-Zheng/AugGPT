
import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    private boolean firstMove = false;

    private ArrayList<ChessboardPoint> origin = new ArrayList<>();

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if(chessColor==ChessColor.WHITE){
            this.name='p';
        }else{
            this.name='P';
        }
    }

    public PawnChessComponent(ChessColor chessColor) {
        super(chessColor);
        if(chessColor==ChessColor.WHITE){
            this.name='p';
        }else{
            this.name='P';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        if(getChessColor()==ChessColor.WHITE){
            for (int i = 0; i < 8; i++) {
                ChessboardPoint originpoint = new ChessboardPoint(6,i);
                origin.add(originpoint);
            }
        }
        if(getChessColor()==ChessColor.BLACK){
            for (int i = 0; i < 8; i++) {
                ChessboardPoint originpoint = new ChessboardPoint(1,i);
                origin.add(originpoint);
            }
        }

        //pawn cannot move back, so it is ok here.
//        if(!(getSource().getX()== origin.getX()&&getSource().getY()== origin.getY())){
//            firstMove=false;
//        }

        ChessColor chessColor = getChessColor();
        ChessComponent[][] chessComponents = getChessComponents();
        ChessboardPoint source = getSource();
        ArrayList<ChessboardPoint> legalpoints = new ArrayList<>();
        ChessboardPoint legalpoint = new ChessboardPoint(0,0);

//        System.out.println("first evoke: "+firstMove);

        int row = source.getX();
        int col = source.getY();

        for (int i = 0; i < origin.size(); i++) {
            if(row==origin.get(i).getX()&&col==origin.get(i).getY()){
                firstMove=true;
            }
        }

        if(chessColor== ChessColor.WHITE){
            if(row-1<=7&&(chessComponents[row-1][col] instanceof EmptySlotComponent)){
                legalpoint= new ChessboardPoint(row-1,col);
                legalpoints.add(legalpoint);
            }
            if(firstMove&&(chessComponents[row-2][col] instanceof EmptySlotComponent)){
                legalpoint = new ChessboardPoint(row-2,col);
                legalpoints.add(legalpoint);
            }
            if(row-1>=0&&col-1>=0&&(! (chessComponents[row-1][col-1] instanceof EmptySlotComponent)||chessComponents[row][col-1] instanceof PawnChessComponent)){
                if(! (chessComponents[row-1][col-1] instanceof EmptySlotComponent)){
                    legalpoint = new ChessboardPoint(row-1,col-1);
                    legalpoints.add(legalpoint);
                }


            }
            if(row-1>=0&&col+1<=7&&(!(chessComponents[row-1][col+1] instanceof EmptySlotComponent)||chessComponents[row][col+1] instanceof PawnChessComponent)) {
                if (! (chessComponents[row - 1][col + 1] instanceof EmptySlotComponent)) {
                    legalpoint = new ChessboardPoint(row - 1, col + 1);
                    legalpoints.add(legalpoint);
                }

            }
        }

        if(chessColor==ChessColor.BLACK){
            if(row+1<=7&&(chessComponents[row+1][col] instanceof EmptySlotComponent)){
                legalpoint= new ChessboardPoint(row+1,col);
                legalpoints.add(legalpoint);
            }
            if(firstMove&&(chessComponents[row+2][col] instanceof EmptySlotComponent)){
                legalpoint = new ChessboardPoint(row+2, col);
                legalpoints.add(legalpoint);
            }
            if(row+1<=7&&col+1<=7&&(!(chessComponents[row+1][col+1] instanceof EmptySlotComponent)||chessComponents[row][col+1] instanceof PawnChessComponent)){
                if(! (chessComponents[row+1][col+1] instanceof EmptySlotComponent)){
                    legalpoint = new ChessboardPoint(row+1,col+1);
                    legalpoints.add(legalpoint);
                }
                }
            }
            if(row+1<=7&&col-1>=0&&(!(chessComponents[row+1][col-1] instanceof EmptySlotComponent)||chessComponents[row][col-1] instanceof PawnChessComponent)){
                if(! (chessComponents[row+1][col-1] instanceof EmptySlotComponent)){
                    legalpoint = new ChessboardPoint(row+1,col-1);
                    legalpoints.add(legalpoint);
                }
            }

        for (int i = 0; i < legalpoints.size(); i++) {
            if(chessComponents[legalpoints.get(i).getX()][legalpoints.get(i).getY()].getChessColor()==chessColor){
                legalpoints.remove(i);
                i--;
            }
        }

        return legalpoints;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

}
