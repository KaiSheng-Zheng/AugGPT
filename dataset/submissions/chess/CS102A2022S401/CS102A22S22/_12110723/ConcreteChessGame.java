import java.sql.Array;
import java.util.*;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    private int test;
    private static ChessComponent[][] a;

    public static void setA(){
        a = getChessComponents();
    }

    public ChessComponent[][] getChessComponent() {
        return chessComponents;
    }

    public static ChessComponent[][] getA() {
        a = getChessComponents();
        return a;
    }

    public static ChessComponent[][] getChessComponents() {
        return a;
    }

    @Override
    public void loadChessGame(List<String> chessboard){
       for(int x=0;x<8;x++){
           for(int y=0;y<8;y++){
               char qizi = chessboard.get(x).charAt(y);
               ChessComponent use;
               switch (qizi){
                   case 'R':
                       use = new RookChessComponent(x,y,ChessColor.BLACK,qizi);
                       chessComponents[x][y] = use;
                       break;
                   case 'r':
                       use = new RookChessComponent(x,y,ChessColor.WHITE,qizi);
                       chessComponents[x][y] = use;
                       break;
                   case 'N':
                       use = new KnightChessComponent(x,y,ChessColor.BLACK,qizi);
                       chessComponents[x][y] = use;
                       break;
                   case 'n':
                       use = new KnightChessComponent(x,y,ChessColor.WHITE,qizi);
                       chessComponents[x][y] = use;
                       break;
                   case 'B':
                       use = new BishopChessComponent(x,y,ChessColor.BLACK,qizi);
                       chessComponents[x][y] = use;
                       break;
                   case 'b':
                       use = new BishopChessComponent(x,y,ChessColor.WHITE,qizi);
                       chessComponents[x][y] = use;
                       break;
                   case 'Q':
                       use = new QueenChessComponent(x,y,ChessColor.BLACK,qizi);
                       chessComponents[x][y] = use;
                       break;
                   case 'q':
                       use = new QueenChessComponent(x,y,ChessColor.WHITE,qizi);
                       chessComponents[x][y] = use;
                       break;
                   case 'K':
                       use = new KingChessComponent(x,y,ChessColor.BLACK,qizi);
                       chessComponents[x][y] = use;
                       break;
                   case 'k':
                       use = new KingChessComponent(x,y,ChessColor.WHITE,qizi);
                       chessComponents[x][y] = use;
                       break;
                   case 'P':
                       use = new PawnChessComponent(x,y,ChessColor.BLACK,qizi);
                       chessComponents[x][y] = use;
                       break;
                   case 'p':
                       use = new PawnChessComponent(x,y,ChessColor.WHITE,qizi);
                       chessComponents[x][y] = use;
                       break;
                   case '_':
                       use = new EmptySlotComponent(x,y,ChessColor.NONE,qizi);
                       chessComponents[x][y] = use;
                       break;
               }

           }
       }
       char p = chessboard.get(8).charAt(0);
       if(p == 'b'){currentPlayer = ChessColor.BLACK;test = 1;}
       if(p == 'w'){currentPlayer = ChessColor.WHITE;test = 2;}
       a = chessComponents;
    }

    @Override
    public ChessColor getCurrentPlayer(){
        if( test%2 == 0){
            currentPlayer = ChessColor.WHITE;
        }else {currentPlayer = ChessColor.BLACK;}
        return currentPlayer;
    }

    @Override
    public String getChessboardGraph(){
        StringBuilder str = new StringBuilder();
        for(int x=0;x<8;x++){
            for(int y=0;y<8;y++){
                str.insert((y+x*9),chessComponents[x][y].toString());
            }
            str.insert(str.length(),"\n");
        }
        str.replace(str.length()-1,str.length(),"");
        String STR = str.toString();
       return STR;
    }

    @Override
    public String getCapturedChess(ChessColor player){
        int king = 0;int queen = 0;int pawn = 0;int knight = 0;int bishop = 0;int rook = 0;
        StringBuilder str = new StringBuilder();
        if(player == ChessColor.WHITE){
            for(ChessComponent[] i:chessComponents){
                for (ChessComponent j:i){
                    if(j.toString().equals("k")){
                        king = king+1;
                    }
                    if(j.toString().equals("q")){
                        queen = queen+1;
                    }
                    if(j.toString().equals("p")){
                        pawn = pawn+1;
                    }
                    if(j.toString().equals("n")){
                        knight = knight+1;
                    }
                    if(j.toString().equals("b")){
                        bishop = bishop+1;
                    }
                    if(j.toString().equals("r")){
                        rook = rook+1;
                    }
                }
            }
            if(1-king!=0){
                String use = String.format("k %s\n",1-king);
                str.insert(str.length(),use);
            }
            if(1-queen!=0){
                String use = String.format("q %s\n",1-queen);
                str.insert(str.length(),use);
            }
            if(2-rook!=0){
                String use = String.format("r %s\n",2-rook);
                str.insert(str.length(),use);
            }
            if(2-bishop!=0){
                String use = String.format("b %s\n",2-bishop);
                str.insert(str.length(),use);
            }
            if(2-knight!=0){
                String use = String.format("n %s\n",2-knight);
                str.insert(str.length(),use);
            }
            if(8-pawn!=0){
                String use = String.format("p %s\n",8-pawn);
                str.insert(str.length(),use);
            }
        }
        if(player == ChessColor.BLACK){
            for(ChessComponent[] i:chessComponents){
                for (ChessComponent j:i){
                    if(j.toString().equals("K")){
                        king = king+1;
                    }
                    if(j.toString().equals("Q")){
                        queen = queen+1;
                    }
                    if(j.toString().equals("P")){
                        pawn = pawn+1;
                    }
                    if(j.toString().equals("N")){
                        knight = knight+1;
                    }
                    if(j.toString().equals("B")){
                        bishop = bishop+1;
                    }
                    if(j.toString().equals("R")){
                        rook = rook+1;
                    }
                }
            }
            if(1-king!=0){
                String use = String.format("K %s\n",1-king);
                str.insert(str.length(),use);
            }
            if(1-queen!=0){
                String use = String.format("Q %s\n",1-queen);
                str.insert(str.length(),use);
            }
            if(2-rook!=0){
                String use = String.format("R %s\n",2-rook);
                str.insert(str.length(),use);
            }if(2-bishop!=0){
                String use = String.format("B %s\n",2-bishop);
                str.insert(str.length(),use);
            }
            if(2-knight!=0){
                String use = String.format("N %s\n",2-knight);
                str.insert(str.length(),use);
            }
            if(8-pawn!=0){
                String use = String.format("P %s\n",8-pawn);
                str.insert(str.length(),use);
            }
        }
        if(player == ChessColor.NONE){
            str.append("");
        }
        String STR = str.toString();
        return STR;
    }

    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent use = getChess(source.getX(),source.getY());
        return use.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessComponent Source = getChess(sourceX,sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        if(currentPlayer == Source.getChessColor()){
            if(Source.canMoveTo().contains(target)){
                ChessComponent kong = new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                chessComponents[sourceX][sourceY] = kong;
                Source.setS(targetX,targetY);
                chessComponents[targetX][targetY] = Source;
                test = test +1;
                return true;
            }else return false;
        }else return false;
    }
}
