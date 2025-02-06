import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;
    private ChessColor getComponentColor(char component){
        if (component=='_'){
            return ChessColor.NONE;
        }
        if ((int)component>=66&&(int)component<=82){
            return ChessColor.BLACK;
        }
        else{
            return ChessColor.WHITE;
        }
    }
    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
    }
    @Override
    public void loadChessGame(List<String> chessboard){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i, j),ChessColor.BLACK);
                    continue;
                }
                if (chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i, j),ChessColor.BLACK);
                    continue;
                }
                if (chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i, j),ChessColor.BLACK);
                    continue;
                }
                if (chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i, j),ChessColor.BLACK);
                    continue;
                }
                if (chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i, j),ChessColor.BLACK);
                    continue;
                }
                if (chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i, j),ChessColor.BLACK);
                    continue;
                }
                if (chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i, j),ChessColor.NONE);
                    continue;
                }
                if (chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE);
                    continue;
                }
                if (chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE);
                    continue;
                }
                if (chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE);
                    continue;
                }
                if (chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE);
                    continue;
                }
                if (chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE);
                    continue;
                }
                if (chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE);

                }


            }
        }
        currentPlayer=chessboard.get(8).charAt(0)=='b'?ChessColor.BLACK:ChessColor.WHITE;
    }


    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {

        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        int number=0;
        StringBuilder HeiHei=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                HeiHei.append(chessComponents[i][j]);
            }
            if (number<7){
                HeiHei.append("\n");
                number++;
            }
        }
        return HeiHei.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] natureNumber = {1, 1, 2, 2, 2, 8};// King, Queen, Rooks,Bishops, Knights, Pawns
        int[] nowNumber = new int[6];// King, Queen, Rooks,Bishops, Knights, Pawns
        if (player==ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        nowNumber[0]++;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        nowNumber[1]++;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        nowNumber[2]++;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        nowNumber[3]++;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        nowNumber[4]++;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        nowNumber[5]++;
                    }
                }
            }
            StringBuilder hoHO = new StringBuilder();
            if (nowNumber[0] != natureNumber[0]) {
                int capturedNumber = natureNumber[0] - nowNumber[0];
                hoHO.append("K ").append(capturedNumber).append("\n");
            }
            if (nowNumber[1] != natureNumber[1]) {
                int capturedNumber = natureNumber[1] - nowNumber[1];
                hoHO.append("Q ").append(capturedNumber).append("\n");
            }
            if (nowNumber[2] != natureNumber[2]) {
                int capturedNumber = natureNumber[2] - nowNumber[2];
                hoHO.append("R ").append(capturedNumber).append("\n");
            }
            if (nowNumber[3] != natureNumber[3]) {
                int capturedNumber = natureNumber[3] - nowNumber[3];
                hoHO.append("B ").append(capturedNumber).append("\n");
            }
            if (nowNumber[4] != natureNumber[4]) {
                int capturedNumber = natureNumber[4] - nowNumber[4];
                hoHO.append("N ").append(capturedNumber).append("\n");
            }
            if (nowNumber[5] != natureNumber[5]) {
                int capturedNumber = natureNumber[5] - nowNumber[5];
                hoHO.append("P ").append(capturedNumber).append("\n");
            }
            return hoHO.toString();
        }else{
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name=='k'){
                        nowNumber[0]++;continue;
                    }
                    if (chessComponents[i][j].name=='q'){
                        nowNumber[1]++;continue;
                    }
                    if (chessComponents[i][j].name=='r'){
                        nowNumber[2]++;continue;
                    }
                    if (chessComponents[i][j].name=='b'){
                        nowNumber[3]++;continue;
                    }
                    if (chessComponents[i][j].name=='n'){
                        nowNumber[4]++;continue;
                    }
                    if (chessComponents[i][j].name=='p'){
                        nowNumber[5]++;
                    }
                }
            }
            StringBuilder hoHO=new StringBuilder();
            if (nowNumber[0]!=natureNumber[0]){
                int capturedNumber=natureNumber[0]-nowNumber[0];
                hoHO.append("k ").append(capturedNumber).append("\n");
            }
            if (nowNumber[1]!=natureNumber[1]){
                int capturedNumber=natureNumber[1]-nowNumber[1];
                hoHO.append("q ").append(capturedNumber).append("\n");
            }
            if (nowNumber[2]!=natureNumber[2]){
                int capturedNumber=natureNumber[2]-nowNumber[2];
                hoHO.append("r ").append(capturedNumber).append("\n");
            }
            if (nowNumber[3]!=natureNumber[3]){
                int capturedNumber=natureNumber[3]-nowNumber[3];
                hoHO.append("b ").append(capturedNumber).append("\n");
            }
            if (nowNumber[4]!=natureNumber[4]){
                int capturedNumber=natureNumber[4]-nowNumber[4];
                hoHO.append("n ").append(capturedNumber).append("\n");
            }
            if (nowNumber[5]!=natureNumber[5]){
                int capturedNumber=natureNumber[5]-nowNumber[5];
                hoHO.append("p ").append(capturedNumber).append("\n");
            }return hoHO.toString();

        }

    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        chessComponents[source.getX()][source.getY()].loadCurrentChessboard(chessComponents);
        ArrayList<ChessboardPoint> haha=(ArrayList<ChessboardPoint>)chessComponents[source.getX()][source.getY()].canMoveTo();
        haha.sort(new Sort());
        return haha;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].chessBoard=chessComponents;
        ChessColor j=getComponentColor(chessComponents[sourceX][sourceY].name);
        if (currentPlayer!=j){
            return false;
        }
        ArrayList<ChessboardPoint> ChessMoveTo=(ArrayList<ChessboardPoint>)chessComponents[sourceX][sourceY].canMoveTo();
        if (ChessMoveTo.contains(new ChessboardPoint(targetX,targetY))){
        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].source=new ChessboardPoint(targetX,targetY);
        chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
        currentPlayer=(currentPlayer==ChessColor.WHITE?ChessColor.BLACK:ChessColor.WHITE);
        return true;}
        else{
            return false;
        }
    }
    private static class Sort implements Comparator<ChessboardPoint>{
        @Override
        public int compare(ChessboardPoint p1,ChessboardPoint p2){
            if (p1.getX()> p2.getX()){
                return p1.getX()-p2.getX();
            }
            if (p1.getX()<p2.getX()){
                return p1.getX()- p2.getX();
            }
            if (p1.getX()==p2.getX()){
                return p1.getY()- p2.getY();
            }
            return 0;
        }
    }
}
