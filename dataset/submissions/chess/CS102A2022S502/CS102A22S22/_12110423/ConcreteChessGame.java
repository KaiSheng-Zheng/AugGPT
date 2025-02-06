import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i <8; i++) {
            for (int j = 0; j <8; j++) {
                if (chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }else if (chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE);
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w'){
            currentPlayer = ChessColor.WHITE;
        }else if (chessboard.get(8).charAt(0) == 'b'){
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder A = new StringBuilder();
        for (int i = 0; i <8; i++) {
            for (int j = 0; j <8; j++) {
                A.append(chessComponents[i][j]);
            }
            A.append("\n");
        }
        return A.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int countK = 0,countQ = 0,countR = 0,countB = 0,countN = 0,countP = 0;
        StringBuilder B = new StringBuilder();
        if (player == ChessColor.WHITE){
            for (int i = 0; i <8; i++) {
                for (int j = 0; j <8; j++) {
                    if (chessComponents[i][j].name == 'k'){
                        countK++;
                    }
                    if (chessComponents[i][j].name == 'q'){
                        countQ++;
                    }
                    if (chessComponents[i][j].name == 'r'){
                        countR++;
                    }
                    if (chessComponents[i][j].name == 'b'){
                        countB++;
                    }if(chessComponents[i][j].name == 'n'){
                        countN++;
                    }
                    if (chessComponents[i][j].name == 'p'){
                        countP++;
                    }
                }
            }
            if (countK<1){
                B.append("k ");
                B.append(1-countK);
                B.append("\n");
            }
            if (countQ<1){
                B.append("q ");
                B.append(1-countQ);
                B.append("\n");
            }
            if (countR<2){
                B.append("r ");
                B.append(2-countR);
                B.append("\n");
            }
            if (countB<2){
                B.append("b ");
                B.append(2-countB);
                B.append("\n");
            }
            if (countN<2){
                B.append("n ");
                B.append(2-countN);
                B.append("\n");
            }
            if (countP<8){
                B.append("p ");
                B.append(8-countP);
                B.append("\n");
            }
            return B.toString();
        }else {
            for (int i = 0; i <8; i++) {
                for (int j = 0; j <8; j++) {
                    if (chessComponents[i][j].name == 'K'){
                        countK++;
                    }
                    if (chessComponents[i][j].name == 'Q'){
                        countQ++;
                    }
                    if (chessComponents[i][j].name == 'R'){
                        countR++;
                    }
                    if (chessComponents[i][j].name == 'B'){
                        countB++;
                    }if(chessComponents[i][j].name == 'N'){
                        countN++;
                    }
                    if (chessComponents[i][j].name == 'P'){
                        countP++;
                    }
                }
            }
            if (countK<1){
                B.append("K ");
                B.append(1-countK);
                B.append("\n");
            }
            if (countQ<1){
                B.append("Q ");
                B.append(1-countQ);
                B.append("\n");
            }
            if (countR<2){
                B.append("R ");
                B.append(2-countR);
                B.append("\n");
            }
            if (countB<2){
                B.append("B ");
                B.append(2-countB);
                B.append("\n");
            }
            if (countN<2){
                B.append("N ");
                B.append(2-countN);
                B.append("\n");
            }
            if (countP<8){
                B.append("P ");
                B.append(8-countP);
                B.append("\n");
            }
            return B.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessComponents(chessComponents);
        ArrayList<ChessboardPoint> canMoveTo = new ArrayList<ChessboardPoint>(chessComponents[source.getX()][source.getY()].canMoveTo());
        canMoveTo.sort(new SortChessboardPoint());
        return canMoveTo;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[targetX][targetY].getChessColor() != currentPlayer){
            chessComponents[targetX][targetY] = new EmptySlotComponent(chessComponents[targetX][targetY].getSource(),ChessColor.NONE);
            return true;
        }else{
            return false;
        }
    }

    private static class SortChessboardPoint implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint chessboardPoint1,ChessboardPoint chessboardPoint2){
            if (chessboardPoint1.getX() != chessboardPoint2.getX()){
                return chessboardPoint1.getX() - chessboardPoint2.getX();
            }else {
                return chessboardPoint1.getY() - chessboardPoint2.getY();
            }
        }
    }
}
