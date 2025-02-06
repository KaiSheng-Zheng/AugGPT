import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {

    ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessBoard;
    final int[][] move=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};


    public ChessboardPoint getSource() {
        return getSource();
    }
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public ChessColor getChessColor() {return chessColor;}
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessComponent(){}
    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    ChessColor getComponentColor(char component){
        if (component == '_'){
            return ChessColor.NONE;
        }else if (component>='a'&&component<='z'){
            return ChessColor.WHITE;
        }else{
            return ChessColor.BLACK;
        }
    }
    void loadCurrentChessboard(ChessComponent[][] chessBoard){
        this.chessBoard=chessBoard;
    }
    // should design
    public abstract List<ChessboardPoint> canMoveTo();
}




class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name='_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}
class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source, chessColor);
        if (chessColor == ChessColor.BLACK) {name = 'K';}
        else {name = 'k';}
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> moveTo = new ArrayList<>();
        for(int count = 0; count < 8; count++) {
            ChessboardPoint c1 = source.offset(move[count][0], move[count][1]);
            if(c1 != null && getComponentColor(chessBoard[c1.getX()][c1.getY()].toString().charAt(0)) != getChessColor()){
                moveTo.add(c1);
            }
        }
        return moveTo;
    }
}
class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source, chessColor);
        if (chessColor == ChessColor.BLACK) {name = 'R';}
        else {name = 'r';}
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> c1 = new ArrayList<>();
        for(int count=1; count <= 7; count += 2){
            int x = source.getX();
            int y = source.getY();
            x += move[count][0];
            y += move[count][1];
            while (x>=0 && x<=7 && y>=0 && y<=7){
                if (getComponentColor(chessBoard[x][y].toString().charAt(0)) == getChessColor()) {break;}
                c1.add(new ChessboardPoint(x,y));
                if (getComponentColor(chessBoard[x][y].toString().charAt(0)) != ChessColor.NONE) {break;}
                x += move[count][0];
                y += move[count][1];
            }
        }
        return c1;
    }


}
class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source, chessColor);
        if (chessColor == ChessColor.BLACK) {name = 'B';}
        else {name = 'b';}
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> moveTo = new ArrayList<>();
        for(int count = 0; count < 8; count += 2){
            int x = source.getX();
            int y = source.getY();

            x += move[count][0];
            y += move[count][1];

            while(x>=0 && x<8 && y>=0 && y<8) {
                if (getComponentColor(chessBoard[x][y].toString().charAt(0)) == getChessColor()){break;}
                moveTo.add(new ChessboardPoint(x,y));
                if (getComponentColor(chessBoard[x][y].toString().charAt(0)) != ChessColor.NONE){break;}

                x += move[count][0];
                y += move[count][1];
            }
        }
        return moveTo;
    }

}
class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source, chessColor);
        if (chessColor == ChessColor.WHITE) {name = 'q';}
        else {name = 'Q';}
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        for(int count = 0; count < 8; count++){
            int x = source.getX();
            int y = source.getY();

            x += move[count][0];
            y += move[count][1];

            while (x >= 0 && x<8 && y>=0 && y<8){
                if(getComponentColor(chessBoard[x][y].toString().charAt(0)) == getChessColor()){break;}
                moveTo.add(new ChessboardPoint(x,y));
                if (getComponentColor(chessBoard[x][y].toString().charAt(0)) != ChessColor.NONE){break;}

                x += move[count][0];
                y += move[count][1];
            }
        }
        return moveTo;
    }

}

class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source, chessColor);
        if (chessColor == ChessColor.BLACK) {name = 'N';}
        else {name = 'n';}
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int[][] knightMove = new int[][]{{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
        List<ChessboardPoint> moveTo = new ArrayList<>();

        for(int count = 0; count < 8; count++){
            ChessboardPoint c1 = source.offset(knightMove[count][0], knightMove[count][1]);
            if(c1 != null &&
                    getComponentColor(chessBoard[c1.getX()][c1.getY()].toString().charAt(0)) != getChessColor()){
                moveTo.add(c1);
            }
        }
        return moveTo;
    }

}
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source, chessColor);
        if (chessColor == chessColor.WHITE) {
            name = 'p';
        }
        else {
            name = 'P';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> moveTo = new ArrayList<>();

        int x = source.getX();
        int y = source.getY();

        if (getChessColor() == ChessColor.WHITE){

            if (y >= 1 && getComponentColor(chessBoard[x-1][y-1].toString().charAt(0)) == ChessColor.BLACK){
                moveTo.add(new ChessboardPoint(x-1,y-1));
            }
            if (y < 7 && getComponentColor(chessBoard[x-1][y+1].toString().charAt(0)) == ChessColor.BLACK){
                moveTo.add(new ChessboardPoint(x-1,y+1));
            }

            if (x >= 1 && getComponentColor(chessBoard[x-1][y].toString().charAt(0)) == ChessColor.NONE){
                moveTo.add(new ChessboardPoint(x-1,y));
                if( x==6 && getComponentColor(chessBoard[x-2][y].toString().charAt(0)) == ChessColor.NONE){
                    moveTo.add(new ChessboardPoint(x-2,y));
                }
            }
        }
        else {

            if(y >= 1 && getComponentColor (chessBoard[x+1][y-1].toString().charAt(0)) == ChessColor.WHITE){
                moveTo.add(new ChessboardPoint(x+1, y-1));
            }
            if(y < 7 && getComponentColor (chessBoard[x+1][y+1].toString().charAt(0)) == ChessColor.WHITE){
                moveTo.add(new ChessboardPoint(x+1, y+1));
            }

            if(x < 7 && getComponentColor (chessBoard[x+1][y].toString().charAt(0)) == ChessColor.NONE){
                moveTo.add(new ChessboardPoint(x+1, y));
                if(x == 1 && getComponentColor (chessBoard[x+2][y].toString().charAt(0)) == ChessColor.NONE){
                    moveTo.add(new ChessboardPoint(x+2, y));
                }
            }
        }
        return moveTo;
    }

}






