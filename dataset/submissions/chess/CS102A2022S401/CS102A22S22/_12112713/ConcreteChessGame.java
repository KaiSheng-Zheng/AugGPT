
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }
    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char m = chessboard.get(i).charAt(j);
               switch (m){
                   case 'K':
                       chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), 'K');
                       break;
                   case 'B':
                       chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), 'B');
                       break;
                   case 'Q':
                       chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), 'Q');
                       break;
                   case 'P':
                       chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), 'P');
                       break;
                   case 'R':
                       chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), 'R');
                       break;
                   case 'N':
                       chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), 'N');
                       break;
                   case 'k':
                       chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), 'k');
                       break;
                   case 'b':
                       chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), 'b');
                       break;
                   case 'q':
                       chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), 'q');
                       break;
                   case 'p':
                       chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), 'p');
                       break;
                   case 'r':
                       chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), 'r');
                       break;
                   case 'n':
                       chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), 'n');
                       break;
                   case '_':
                       chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(i, j), '_');
                       break;
               }
            }
        }
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                chessComponents[j][k].setChessboard(this.chessComponents);
            }
        }
        if(chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }else if(chessboard.get(8).equals("b")){
            currentPlayer = ChessColor.BLACK;
        }
    }
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder line0 = new StringBuilder();
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        StringBuilder line3 = new StringBuilder();
        StringBuilder line4 = new StringBuilder();
        StringBuilder line5 = new StringBuilder();
        StringBuilder line6 = new StringBuilder();
        StringBuilder line7 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            line0.append(chessComponents[0][i]);
        }
        for (int i = 0; i < 8; i++) {
            line1.append(chessComponents[1][i]);
        }
        for (int i = 0; i < 8; i++) {
            line2.append(chessComponents[2][i]);
        }
        for (int i = 0; i < 8; i++) {
            line3.append(chessComponents[3][i]);
        }
        for (int i = 0; i < 8; i++) {
            line4.append(chessComponents[4][i]);
        }
        for (int i = 0; i < 8; i++) {
            line5.append(chessComponents[5][i]);
        }
        for (int i = 0; i < 8; i++) {
            line6.append(chessComponents[6][i]);
        }
        for (int i = 0; i < 8; i++) {
            line7.append(chessComponents[7][i]);
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", line0.toString(), line1.toString(), line2.toString(), line3.toString(), line4.toString(), line5.toString(), line6.toString(), line7.toString());
    }
    public String getCapturedChess(ChessColor player){
        int numOfK = 0, numOfQ = 0, numOfN = 0, numOfR = 0, numOfP = 0, numOfB = 0, numOfk = 0, numOfq = 0, numOfn = 0, numOfr = 0, numOfp = 0, numOfb = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].name){
                    case 'K':
                        numOfK++;
                        break;
                    case 'Q':
                        numOfQ++;
                        break;
                    case 'N':
                        numOfN++;
                        break;
                    case 'R':
                        numOfR++;
                        break;
                    case 'P':
                        numOfP++;
                        break;
                    case 'B':
                        numOfB++;
                        break;
                    case 'k':
                        numOfk++;
                        break;
                    case 'q':
                        numOfq++;
                        break;
                    case 'n':
                        numOfn++;
                        break;
                    case 'r':
                        numOfr++;
                        break;
                    case 'p':
                        numOfp++;
                        break;
                    case 'b':
                        numOfb++;
                        break;
                }
            }
        }
        StringBuilder a = new StringBuilder();
        if(player == ChessColor.WHITE){
            if(numOfk == 0){
                a.append("k 1\n");
            }
            if(numOfq == 0){
                a.append("q 1\n");
            }
            if(numOfr != 2){
                a.append("r" + " ").append(2 - numOfr).append("\n");
            }
            if(numOfb != 2){
                a.append("b" + " ").append(2 - numOfb).append("\n");
            }
            if(numOfn != 2){
                a.append("n" + " ").append(2 - numOfn).append("\n");
            }
            if(numOfp != 8){
                a.append("p" + " ").append(8 - numOfp).append("\n");
            }
        }else if(player == ChessColor.BLACK){
            if(numOfK == 0){
                a.append("K 1\n");
            }
            if(numOfQ == 0){
                a.append("Q 1\n");
            }
            if(numOfR != 2){
                a.append("R" + " ").append(2 - numOfR).append("\n");
            }
            if(numOfB != 2){
                a.append("B" + " ").append(2 - numOfB).append("\n");
            }
            if(numOfN != 2){
                a.append("N" + " ").append(2 - numOfN).append("\n");
            }
            if(numOfP != 8){
                a.append("P" + " ").append(8 - numOfP).append("\n");
            }
        }
        return a.toString();
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> canMovePoints = getChess(source.getX(), source.getY()).canMoveTo();
        if(canMovePoints.size() == 0){
            return new ArrayList<>();
        }else{
            int[] number = new int[canMovePoints.size()];
            for (int i = 0; i < canMovePoints.size(); i++) {
                number[i] = canMovePoints.get(i).getX() * 10 + canMovePoints.get(i).getY();
            }
            Arrays.sort(number);
            List<ChessboardPoint> a = new ArrayList<>();
            for (int i = 0; i < canMovePoints.size(); i++) {
                canMovePoints.set(i, new ChessboardPoint(number[i] / 10, number[i] % 10));
            }
            return canMovePoints;
        }
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        List<ChessboardPoint> list1 = chessComponents[sourceX][sourceY].canMoveTo();
            if(currentPlayer == getChess(sourceX, sourceY).getChessColor()){
                int m = 0;
                if(chessComponents[sourceX][sourceY].canMoveTo().size() == 0){
                    return false;
                }else{
                    for (ChessboardPoint chessboardPoint : list1) {
                        if (targetX == chessboardPoint.getX() & targetY == chessboardPoint.getY()) {
                            m++;
                        }
                    }
                    if(m == 1){
                        if (currentPlayer == ChessColor.BLACK){
                            currentPlayer = ChessColor.WHITE;
                            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, getChess(sourceX, sourceY).getSource(), '_');
                            return true;
                        }else if(currentPlayer == ChessColor.WHITE){
                            currentPlayer = ChessColor.BLACK;
                            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, getChess(sourceX, sourceY).getSource(), '_');
                            return true;
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
            }else{
                return false;
            }
    }
}
