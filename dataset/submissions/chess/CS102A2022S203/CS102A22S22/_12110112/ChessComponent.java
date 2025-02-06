import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent[][] chessComponents;
    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();
   public ConcreteChessGame game;
   private ChessComponent[][] chessboard;



    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ChessComponent[][] chessboard){
        this.name = name;
        this.chessColor=chessColor;
        this.source = source;
        this.chessboard=chessboard;
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.name = name;
        this.chessColor=chessColor;
        this.source = source;
    }

    public ChessComponent NextPoint(ChessboardPoint p,int x,int y,ConcreteChessGame game){
        int m=p.getX()+x;
        int n=p.getY()+y;
        return game.getChess(m,n);
    }
    public ChessComponent ThisPoint(ChessboardPoint p,ConcreteChessGame game){
        int m=p.getX();
        int n=p.getY();
        //return chessComponents[m][n];
        return game.getChess(m,n);
    }
    public int GetDistance(ChessboardPoint p,int x,int y,ConcreteChessGame game){
        int i=x,j=y;
        while(p.offset(i,j)!=null){
            if(NextPoint(p,i,j,game).getChessColor()==ChessColor.NONE){
                    i+=x;
                    j+=y;
                }else if(NextPoint(p,i,j,game).getChessColor()==ThisPoint(p,game).getChessColor()){

                    return Math.abs(i-x);
                }else if(NextPoint(p,i,j,game).getChessColor()!=ThisPoint(p,game).getChessColor()){
                    return Math.abs(i);
                }
            }
            return Math.abs(i-x);
    }
    public int GetDistanceY(ChessboardPoint p,int x,int y,ConcreteChessGame game){
        int i=x,j=y;
        while(p.offset(i,j)!=null){
            if(NextPoint(p,i,j,game).getChessColor()==ChessColor.NONE){
                i+=x;
                j+=y;
            }else if(NextPoint(p,i,j,game).getChessColor()==ThisPoint(p,game).getChessColor()){

                return Math.abs(j-y);
            }else if(NextPoint(p,i,j,game).getChessColor()!=ThisPoint(p,game).getChessColor()){
                return Math.abs(j);
            }
        }
        return Math.abs(j-y);
    }


    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    //public void InitialBoard() {
//        ConcreteChessGame a = new ConcreteChessGame();
//        ArrayList<String> chessboard = new ArrayList();
//        chessboard.add("RNBQKBNR");
//        chessboard.add("PPPPPPPP");
//        chessboard.add("________");
//        chessboard.add("________");
//        chessboard.add("________");
//        chessboard.add("________");
//        chessboard.add("pppppppp");
//        chessboard.add("rnbqkbnr");
//        a.loadChessGame(chessboard);
//    }


}


