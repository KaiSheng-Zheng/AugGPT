import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private List<String> chessboard = new ArrayList<>() ;


    public void loadChessGame(List<String> chessboard){
        this.chessboard = chessboard;
        chessComponents = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ( chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if ( chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if ( chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if ( chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }

                if (chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }

                if (chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }

                if (chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }

                if (chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }

                if (chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }

                if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j] = new EmptySlotComponent('_');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'b'){
            this.currentPlayer = ChessColor.BLACK;
        }
        else {
            this.currentPlayer = ChessColor.WHITE;
        }

    }

    public ChessColor getCurrentPlayer (){
        return  this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            value.append(chessboard.get(i));
            value.append("\n");
        }
        return value.toString();
    }

    public String getCapturedChess(ChessColor player){
        int countR = 0;
        int countr = 0;
        int countN = 0;
        int countn = 0;
        int countB = 0;
        int countb = 0;
        int countQ = 0;
        int countq = 0;
        int countK = 0;
        int countk = 0;
        int countP = 0;
        int countp = 0;
        StringBuilder blackCapture = new StringBuilder();
        StringBuilder whiteCapture = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (this.chessComponents[i][j].name) {
                    case 'R' -> countR++;
                    case 'r' -> countr++;
                    case 'N' -> countN++;
                    case 'n' -> countn++;
                    case 'B' -> countB++;
                    case 'b' -> countb++;
                    case 'Q' -> countQ++;
                    case 'q' -> countq++;
                    case 'K' -> countK++;
                    case 'k' -> countk++;
                    case 'P' -> countP++;
                    case 'p' -> countp++;
                }
            }
        }

        if (countK != 1){
            blackCapture.append("K 1");
            blackCapture.append("\n");
        }
        if (countQ != 1){
            blackCapture.append("Q 1");
            blackCapture.append("\n");
        }
        if(countR != 2){
            int a = 2 - countR;
            blackCapture.append("R ").append(a);
            blackCapture.append("\n");
        }
        if (countB != 2){
            int a = 2 - countB;
            blackCapture.append("B ").append(a);
            blackCapture.append("\n");
        }
        if (countN != 2){
            int a = 2 - countN;
            blackCapture.append("N ").append(a);
            blackCapture.append("\n");
        }
        if (countP != 8){
            int a = 8 - countP;
            blackCapture.append("P ").append(a);
        }

        if (countk != 1){
            whiteCapture.append("k 1");
            whiteCapture.append("\n");
        }
        if (countq != 1){
            whiteCapture.append("q 1");
            whiteCapture.append("\n");
        }
        if (countr != 2){
            int a = 2 - countr;
            whiteCapture.append("r ").append(a);
            whiteCapture.append("\n");
        }
        if (countb != 2){
            int a = 2 - countb;
            whiteCapture.append("b ").append(a);
            whiteCapture.append("\n");
        }
        if (countn != 2){
            int a = 2 - countn;
            whiteCapture.append("n ").append(a);
            whiteCapture.append("\n");
        }
        if (countp != 8){
            int a = 8 - countp;
            whiteCapture.append("p ").append(a);
        }
        if (player == ChessColor.BLACK){
            return blackCapture.toString();
        }
        else return whiteCapture.toString();



    }

    public ChessComponent getChess (int x,int y){
        return this.chessComponents[x][y];
    }


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessboardPoint[] canMovePoints = new ChessboardPoint[chessComponents[source.getX()][source.getY()].canMoveTo().size()];
        for (int i = 0; i < canMovePoints.length; i++) {
            canMovePoints[i] = chessComponents[source.getX()][source.getY()].canMoveTo().get(i);
        }
        ChessboardPoint temp = null;
        for (int i = 0; i < canMovePoints.length-1; i++) {

            for (int j= 0; j < canMovePoints.length-1-i; j++) {

                if (canMovePoints[j].getX()>canMovePoints[j+1].getX()){
                    temp = canMovePoints [j];
                    canMovePoints [j] = canMovePoints[j+1];
                    canMovePoints [j+1] = temp;
                }
            if (canMovePoints[j].getX() == canMovePoints[j+1].getX()){
                if (canMovePoints[j].getY()>canMovePoints[j+1].getY()){
                    temp = canMovePoints [j];
                    canMovePoints [j] = canMovePoints[j+1];
                    canMovePoints [j+1] = temp;
                }
            }
            }
        }
       return new ArrayList<>(Arrays.asList(canMovePoints));
       
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if (chessComponents[sourceX][sourceY].getChessColor() ==currentPlayer){
          for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
            if (targetX == chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()&&targetY == chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()){
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent('_');
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
//                chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
//                chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 8; k++) {
                        chessComponents[j][k].setChessboard(this.chessComponents);
                    }
                }
                swapPlayer();
                return true;
            }}
        }
        return false;
    }
    public void swapPlayer(){
        currentPlayer = currentPlayer == ChessColor.BLACK? ChessColor.WHITE:ChessColor.BLACK;
    }
}
