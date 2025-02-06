import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];      //
    private String[] chessBoard = new String[8];       //
    private ChessColor currentPlayer;           //
    private int[][] chessCount = new int[2][6];         //
    private int[][] chessDueCount= new int[2][6];

    private ConcreteChessGame concreteChessGame;

    public ConcreteChessGame() {
        chessDueCount[0][0] = 8;
        chessDueCount[0][1] = 2;
        chessDueCount[0][2] = 2;
        chessDueCount[0][3] = 2;
        chessDueCount[0][4] = 1;
        chessDueCount[0][5] = 1;

        chessDueCount[1][0] = 8;
        chessDueCount[1][1] = 2;
        chessDueCount[1][2] = 2;
        chessDueCount[1][3] = 2;
        chessDueCount[1][4] = 1;
        chessDueCount[1][5] = 1;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i<8 ; i++){
            chessBoard[i] = chessboard.get(i);
            for (int j = 0; j<8 ; j++){
                ChessboardPoint point = new ChessboardPoint(i,j);
                String chess = chessboard.get(i).substring(j,j+1);

                switch (chess.toLowerCase(Locale.ROOT)){
                    case "k":
                        if (chess.equals("K")){
                            chessComponents[i][j] = new KingChessComponent(point,ChessColor.BLACK,this);
                            chessCount[0][5]++;
                        }else {
                            chessComponents[i][j] = new KingChessComponent(point,ChessColor.WHITE,this);
                            chessCount[1][5]++;
                        }
                        break;
                    case "q":
                        if (chess.equals("Q")){
                            chessComponents[i][j] = new QueenChessComponent(point,ChessColor.BLACK, this);
                            chessCount[0][4]++;
                        }else {
                            chessComponents[i][j] =new QueenChessComponent(point,ChessColor.WHITE, this);
                            chessCount[1][4]++;
                        }
                        break;
                    case "b":
                        if (chess.equals("B")){
                            chessComponents[i][j] = new BishopChessComponent(point,ChessColor.BLACK, this);
                            chessCount[0][2]++;
                        }else {
                            chessComponents[i][j] = new BishopChessComponent(point,ChessColor.WHITE, this);
                            chessCount[1][2]++;
                        }
                        break;
                    case "n":
                        if (chess.equals("N")){
                            chessComponents[i][j] = new KnightChessComponent(point,ChessColor.BLACK, this);
                            chessCount[0][1]++;
                        }else {
                            chessComponents[i][j] = new KnightChessComponent(point,ChessColor.BLACK, this);
                            chessCount[1][1]++;
                        }
                        break;
                    case "r":
                        if (chess.equals("R")){
                            chessComponents[i][j] = new RookChessComponent(point,ChessColor.BLACK, this);
                            chessCount[0][3]++;
                        }else {
                            chessComponents[i][j] = new RookChessComponent(point,ChessColor.WHITE, this);
                            chessCount[1][3]++;
                        }
                        break;
                    case "p":
                        if (chess.equals("P")){
                            chessComponents[i][j] = new PawnChessComponent(point,ChessColor.BLACK, this);
                            chessCount[0][0]++;
                        }else {
                            chessComponents[i][j] = new PawnChessComponent(point,ChessColor.WHITE, this);
                            chessCount[1][0]++;
                        }
                        break;
                    case "_":
                        chessComponents[i][j] = new EmptySlotComponent(point,ChessColor.NONE, this);
                        break;
                }//switch finish
            }//for j finish
        }//for i finish
        if (chessboard.get(8).equals("b"))currentPlayer = ChessColor.BLACK;
        else currentPlayer = ChessColor.WHITE;
    }//loadChessGame finish

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        String out = new String();
        for (int i = 0 ; i<8 ; i++){
            out += chessBoard[i] + "\n";

        }//for i finish

        return out;
    }//getChessboardGraph finish

    public String getCapturedChess(ChessColor player){
        String out = new String();
        if (player == ChessColor.BLACK) {
            if (chessCount[0][5] < chessDueCount[0][5]) out += "K " + (chessDueCount[0][5] - chessCount[0][5]) + "\n";
            if (chessCount[0][4] < chessDueCount[0][4]) out += "Q " + (chessDueCount[0][4] - chessCount[0][4]) + "\n";
            if (chessCount[0][3] < chessDueCount[0][3]) out += "R " + (chessDueCount[0][3] - chessCount[0][3]) + "\n";
            if (chessCount[0][2] < chessDueCount[0][2]) out += "B " + (chessDueCount[0][2] - chessCount[0][2]) + "\n";
            if (chessCount[0][1] < chessDueCount[0][1]) out += "N " + (chessDueCount[0][1] - chessCount[0][1]) + "\n";
            if (chessCount[0][0] < chessDueCount[0][0]) out += "P " + (chessDueCount[0][0] - chessCount[0][0]) + "\n";
        }
        else
        {
            if (chessCount[1][5] < chessDueCount[1][5]) out += "k " + (chessDueCount[1][5] - chessCount[1][5]) + "\n";
            if (chessCount[1][4] < chessDueCount[1][4]) out += "q " + (chessDueCount[1][4] - chessCount[1][4]) + "\n";
            if (chessCount[1][3] < chessDueCount[1][3]) out += "r " + (chessDueCount[1][3] - chessCount[1][3]) + "\n";
            if (chessCount[1][2] < chessDueCount[1][2]) out += "b " + (chessDueCount[1][2] - chessCount[1][2]) + "\n";
            if (chessCount[1][1] < chessDueCount[1][1]) out += "n " + (chessDueCount[1][1] - chessCount[1][1]) + "\n";
            if (chessCount[1][0] < chessDueCount[1][0]) out += "p " + (chessDueCount[1][0] - chessCount[1][0]) + "\n";
        }

        return out;
    }//getCapturedChess finish

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();

        return Rank(getChess(x,y).canMoveTo());
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean flag = false;
        ChessboardPoint point1 = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint point2 = new ChessboardPoint(targetX,targetY);
        flag = getChess(sourceX,sourceY).canMoveTo().contains(point2);
        for (int i = 0; i < getChess(sourceX,sourceY).canMoveTo().size() ; i++){
            if (targetX == getChess(sourceX,sourceY).canMoveTo().get(i).getX() &&
            targetY == getChess(sourceX,sourceY).canMoveTo().get(i).getY()){
                flag = true;
                break;
            }
        }
        if (flag){
            if (chessComponents[targetX][targetY].getName() != '_'){
                switch (chessComponents[targetX][targetY].getName()){
                    case 'K':
                        chessCount[0][5]--;
                        break;
                    case 'Q':
                        chessCount[0][4]--;
                        break;
                    case 'R':
                        chessCount[0][3]--;
                        break;
                    case 'B':
                        chessCount[0][2]--;
                        break;
                    case 'N':
                        chessCount[0][1]--;
                        break;
                    case 'P':
                        chessCount[0][0]--;
                        break;
                    case 'k':
                        chessCount[1][5]--;
                        break;
                    case 'q':
                        chessCount[1][4]--;
                        break;
                    case 'r':
                        chessCount[1][3]--;
                        break;
                    case 'b':
                        chessCount[1][2]--;
                        break;
                    case 'n':
                        chessCount[1][1]--;
                        break;
                    case 'p':
                        chessCount[1][0]--;
                        break;
                }
            }
            chessComponents[targetX][targetY] = getChess(sourceX,sourceY);
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(point1,ChessColor.NONE,concreteChessGame);
            if (currentPlayer == ChessColor.BLACK)currentPlayer = ChessColor.WHITE;
            else if (currentPlayer == ChessColor.WHITE)currentPlayer = ChessColor.BLACK;
            renew();
        }

        return flag;
    }

    public void renew(){
        String a = new String();
        for (int i = 0 ; i<8 ; i++){
            for (int j = 0 ; j<8 ; j++){
                a += getChess(i,j).name;
            }
            chessBoard[i] = a;
        }
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }


    public String getChessBoard(int x) {
        return chessBoard[x];
    }

    public List<ChessboardPoint> Rank(List<ChessboardPoint> input){
        List<ChessboardPoint> out = new ArrayList<>();
        if (input != null){
            int length = input.size();
            int x1 = 0;
            int x2 = 0;
            int y1 = 0;
            int y2 = 0;
            boolean flag = true;
            out.add(input.get(0));
            for (int i = 1 ; i < length ; i++){
                x1 = input.get(i).getX();
                y1 = input.get(i).getY();
                for (int j = 0; j < out.size() ; j++){
                    x2 = out.get(j).getX();
                    y2 = out.get(j).getY();
                    if (x1 < x2 || (x1 == x2 && y1 < y2)) {
                        out.add(j, input.get(i));
                        flag = false;
                        break;
                    }
                }
                if (flag)out.add(input.get(i));
                flag = true;
            }

        }
        return out;
    }
}
