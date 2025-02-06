import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;			// What's the name
    public char name2;
    public static ChessboardPoint[][] chessboardPoints;
    public ChessColor chessColor1;
    public ChessComponent(){
        chessboardPoints=new ChessboardPoint[8][8];
        for (int i = 0; i <= 7; i++) {

            for (int p = 0; p <= 7; p++) {chessboardPoints[i][p]=new ChessboardPoint(i,p);
            }}
    };
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessColor getChessColor() {
        return chessColor1;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public void changeSource(int x,int y){
        source=new ChessboardPoint(x,y);
    }
    public char getname(){
        return name;
    }
}
