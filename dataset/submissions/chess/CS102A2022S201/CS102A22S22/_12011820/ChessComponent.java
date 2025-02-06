import java.util.List;

public abstract class ChessComponent {
    private   ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;			// What's the name

    private ChessComponent[][] chessComponents;

    public ChessComponent(){
    }

    public ChessComponent(char name ,ChessColor a,ChessboardPoint b,ChessComponent[][] chessComponents){
        this.name = name ;
        chessColor = a;
        source = b;
        this.chessComponents = chessComponents;
    }
    public void setSource(ChessboardPoint a){
        this.source = a;
    }
    public  char getName() {
        return  ' ';
    }

    public void setCount(){
    }

    public  ChessColor getChessColor(){
        return null;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    public void printAllCanMoveTo(){
        System.out.println(-1);
    }
    /***Method to Implement: canMoveTo
     This abstract method tells where this chess piece can move to.
     If no ChessboardPoint can be moved to, return an reference of empty List instead of null.
     ***/


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public int getCount(){
        return -1;
    }


}
