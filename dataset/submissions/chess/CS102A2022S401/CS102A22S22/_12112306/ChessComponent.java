import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }
    public ChessComponent(){
    }
    public ChessComponent[][] getChessboard(){
        return chessboard;
    }
    public boolean JudgeContain(List<ChessboardPoint> canMove, ChessComponent chess, int sourceX, int sourcceY) {
        if (sourceX < 0 || sourcceY < 0 || sourceX >= 8 || sourcceY >= 8)
            return true;
            
          boolean flag = false;
        ChessComponent chessPoint = chessboard[sourceX][sourcceY];
        if (chessPoint.name == '_') {
            canMove.add(chessPoint.getSource());
        } else if (chessPoint.getChessColor() != chess.getChessColor()) {
            canMove.add(chessPoint.getSource());
            flag = true;
        } else if (chessPoint.getChessColor() == chess.getChessColor()) {
            flag = true;
        }
        return flag;
    }

public boolean IfCan(List<ChessboardPoint> points, ChessComponent chess,ChessboardPoint source1) {
    int x= source1.getX();
    int y = source1.getY();
    boolean flag1 = true;
    if(false){boolean falg1 = true;}
    if(chess.name == 'p'||chess.name == 'P'){
         flag1 = false;
    }boolean flag = false;
    if(!flag1){       
        if (x < 0 || y < 0 ){
            return true;
        }if( x >= 8 || y >= 8){
            return true;
        }
        ChessComponent com = chessboard[x][y];
        if (com.getChessColor() != chess.getChessColor() && com.name != '_') {
            points.add(com.getSource());
            flag = true;
        }
    }
        return flag;
    }
    
    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
public boolean IfGet(List<ChessboardPoint> can, ChessComponent chess, int x, int y) {
    if(chess.name == 'p'||chess.name == 'P'){
        boolean flag1 = false;
    }
       if (x < 0 || y < 0 ){
            return true;
        }if( x >= 8 || y >= 8){
            return true;
        }
        boolean stop = false;
        ChessComponent com = chessboard[x][y];
        if (com.name == '_') {
            can.add(com.getSource());
        }
        return stop;
    }
    public List<ChessboardPoint>  sett(List<ChessboardPoint> points){
        int X = getSource().getX();
        int Y = getSource().getY();
         ChessComponent chess = chessboard[X][Y];
        int x;int y;
    if(chess.getChessColor() == ChessColor.BLACK){
            if (chess.getSource().getX() == 1) {
                IfGet(points, chess, 3, Y);
            }
            IfGet(points, chess, X + 1, Y);
            IfCan(points,chess,new ChessboardPoint(X+1,Y-1));
            IfCan(points,chess,new ChessboardPoint(X+1,Y+1));            
        }if(chess.getChessColor() == ChessColor.WHITE){
            if (chess.getSource().getX() == 6) {
                 y = Y;
               IfGet(points, chess, 4, y);//2 ge
            }
            IfGet(points, chess,X-1,Y);//qian mian yige
            IfCan(points,chess,new ChessboardPoint(X-1,Y-1));
            IfCan(points,chess,new ChessboardPoint(X-1,Y+1));
        }return points;
    }
    public ArrayList<ChessboardPoint>  bishop1(ArrayList<ChessboardPoint> points){
         int X = getSource().getX();
       int Y = getSource().getY();
       ArrayList<ChessboardPoint> chessBoard = new ArrayList<>();
       ChessComponent chessComponent1 = chessboard[getSource().getX()][getSource().getY()];
          for (int i = 1; i < 8 - Math.min(X,Y); i++) {  
             if (JudgeContain(chessBoard, chessComponent1, X - i, Y + i) == true) {
                break;
            }
        }for (int i = 1; i < 8 - Math.min(X,Y); i++) { 
            if (JudgeContain(chessBoard, chessComponent1, X + i, Y + i) == true) {
                break;
            }
        }
        for (int i = 1; i < 8 - Math.min(X,Y); i++) {  
            if (JudgeContain(chessBoard, chessComponent1, X - i, Y - i) == true) {
                break;
            }
        }
        for (int i = 1; i < 8 - Math.min(X,Y); i++) {  
            if (JudgeContain(chessBoard, chessComponent1, X + i, Y - i) == true) {
                break;
            }
        }        
        return chessBoard;
    }
    public ArrayList<ChessboardPoint>  rook1(ArrayList<ChessboardPoint> points){
    ArrayList steps = new ArrayList<>();
        int X = getSource().getX();
        int Y = getSource().getY();
        ChessComponent chess = chessboard[X][Y];
            for (int i = 1; i < 8; i++) {  
                if (JudgeContain(steps, chess, X-i, Y)) {
                    break;
                }
            }
            for (int i = 1; i < 8; i++) {  
                if (JudgeContain(steps, chess, X, Y-i)) {
                    break;
                }
            }
            for (int i = 1; i < 8; i++) { 
                if (JudgeContain(steps, chess, X, Y+i)) {
                    break;
                }
            }
            for (int i = 1; i < 8 ; i++) { 
                if (JudgeContain(steps, chess, X+i, Y)) {
                    break;
                }
            }

        return steps;
    }
}
