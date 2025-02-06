import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private Map<String,Integer> b_lost;
    private Map<String,Integer> w_lost;
    private String[] b_name = {"K","Q","R","B","N","P"};
    private String[] w_name = {"k","q","r","b","n","p"};
    private char empty = '_';

    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
        for (String a:b_name){
            b_lost.put(a,0);
        }
        for (String a:w_name){
            w_lost.put(a,0);
        }
    }

    public void loadChessGame(List<String> chessboard){
        for(int i = 0; i <8;i++){
            for(int j = 0;j <8;j++){
                char temp = chessboard.get(i).charAt(j);

                switch (temp){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(i,j,ChessColor.BALCK,temp);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(i,j,ChessColor.BALCK,temp);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(i,j,ChessColor.BALCK,temp);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(i,j,ChessColor.BALCK,temp);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(i,j,ChessColor.BALCK,temp);
                        break;
                    case 'P':
                        chessComponents[i][j] = new KingChessComponent(i,j,ChessColor.BALCK,temp);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(i,j,ChessColor.WHITE,temp);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(i,j,ChessColor.WHITE,temp);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(i,j,ChessColor.WHITE,temp);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(i,j,ChessColor.WHITE,temp);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(i,j,ChessColor.WHITE,temp);
                        break;
                    case 'p':
                        chessComponents[i][j] = new KingChessComponent(i,j,ChessColor.WHITE,temp);
                        break;
                    default:
                        chessComponents[i][j] = new EmptySlotComponent(i,j,ChessColor.NONE,temp);
                        break;
                }

            }
        }

        String player = chessboard.get(8);
        if(player=="w"){
            this.currentPlayer = ChessColor.WHITE;
        }
        else if (player == "b"){
            this.currentPlayer = ChessColor.BALCK;
        }
        else {
            System.out.println("wrong color");
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        String s = "";
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                s += this.chessComponents[i][j].name;
            }
            if(i!=7){
                s += "\n";
            }
        }
        return s;
    }
    public String getCapturedChess(ChessColor player){
        String s = "";
        if (player == ChessColor.BALCK){
            for (String a :b_name){
                int w =b_lost.get(a);
                if(w>0) {
                    s += a + " " + w + "\n";
                }
            }

        }
        else {
            for (String a :w_name){
                int w =w_lost.get(a);
                if(w>0) {
                    s += a + " " + w + "\n";
                }
            }

        }
        return s;
    }
    public ChessComponent getChess(int x, int y){
        if(x>7||x<0||y>7||y<0){
            System.out.println("index error!");
            return null;
        }
        return this.chessComponents[x][y];
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        boolean flag = true;
        if(chessComponents[sourceX][sourceY].name == '_'){
            return false;
        }
        if(chessComponents[sourceX][sourceY].getChessColor() == chessComponents[targetX][targetY].getChessColor()){
            return false;
        }
        if(!(chessComponents[sourceX][sourceY] instanceof KnightChessComponent)&&((Math.abs(sourceX-targetX) != Math.abs(targetY-sourceY))||((sourceX-targetX)==0||(sourceY-targetY) == 0))){
            return false;
        }
        if (chessComponents[sourceX][sourceY] instanceof KingChessComponent){
            if(Math.pow(sourceX-targetX,2)+Math.pow(sourceY-targetY,2)<=2){
                changechess(sourceX,sourceY,targetX,targetY);
                return true;
            }
            else {
                return false;
            }
        }
        if(chessComponents[sourceX][sourceY] instanceof KnightChessComponent) {
            if (Math.pow(sourceX - targetX, 2) + Math.pow(sourceY - targetY, 2) == 5) {
                changechess(sourceX, sourceY, targetX, targetY);
                return true;
            } else {
                return false;
            }
        }
        if(sourceX-targetX == 0 || sourceY - targetY == 0){
            if(chessComponents[sourceX][sourceY] instanceof BishopChessComponent){
                return false;
            }
            else {
                changechess(sourceX, sourceY, targetX, targetY);
                return true;
            }
        }
        changechess(sourceX, sourceY, targetX, targetY);
        return true;

    }

    public void changechess(int sourceX, int sourceY, int targetX, int targetY){
        chessComponents[sourceX][sourceY].changeindex(new ChessboardPoint(targetX,targetY));
        chessComponents[targetX][targetX] = chessComponents[sourceX][sourceY];
        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
        if (currentPlayer == ChessColor.WHITE){
            currentPlayer = ChessColor.BALCK;
        }
        else {
            currentPlayer = ChessColor.WHITE;
        }

    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> temp = chessComponents[source.getX()][source.getY()].canMoveTo();
        Collections.sort(temp,new Comparator<ChessboardPoint>() {

            @Override
            public int compare(ChessboardPoint s1, ChessboardPoint s2) {
                int flag;
                flag = s1.getX()-s2.getX();
                if(flag==0){
                    flag = s1.getY()-s2.getY();
                }
                return flag;
            }
        });
        return temp;

    }

}
