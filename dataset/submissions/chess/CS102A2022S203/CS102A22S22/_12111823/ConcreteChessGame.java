import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
    }

    public void loadChessGame(List<String> chessboard) {
        int row = 0;
        int col = 0;
        for (String s : chessboard) {
            if (col==8){
                if (s.charAt(0) == 'w'){
                    currentPlayer = ChessColor.WHITE;
                }
                else {
                    currentPlayer = ChessColor.BLACK;
                }
            }else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == 'Q' || s.charAt(i) == 'q') {
                        this.chessComponents[row][i] = new QueenChessComponent(s.charAt(i), row, i);
                    }
                    if (s.charAt(i) == 'B' || s.charAt(i) == 'b') {
                        this.chessComponents[row][i] = new BishopChessComponent(s.charAt(i), row, i);
                    }
                    if (s.charAt(i) == '_') {
                        this.chessComponents[row][i] = new EmptySlotComponent(s.charAt(i), row, i);
                    }
                    if (s.charAt(i) == 'K' || s.charAt(i) == 'k') {
                        this.chessComponents[row][i] = new KingChessComponent(s.charAt(i), row, i);
                    }
                    if (s.charAt(i) == 'N' || s.charAt(i) == 'n') {
                        this.chessComponents[row][i] = new KnightChessComponent(s.charAt(i), row, i);
                    }
                    if (s.charAt(i) == 'P' || s.charAt(i) == 'p') {
                        this.chessComponents[row][i] = new PawnChessComponent(s.charAt(i), row, i);
                    }
                    if (s.charAt(i) == 'R' || s.charAt(i) == 'r') {
                        this.chessComponents[row][i] = new RookChessComponent(s.charAt(i), row, i);
                    }

                    
                }
            }
            row++;
            col++;

        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    public String getChessboardGraph() {
        ArrayList<String> arr = new ArrayList();
        for (int i = 0; i < 8; i++) {
            StringBuilder s1 = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                s1.append(this.chessComponents[i][j]);
            }
            arr.add(s1.toString());
        }

        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4), arr.get(5), arr.get(6), arr.get(7));
    }

    public String getCapturedChess(ChessColor player) {
        int B = 0, K = 0, N = 0, P = 0, Q = 0, R = 0;
        StringBuilder s = new StringBuilder();
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[j][i].toString().equals("B")) {
                        B++;
                    }
                    if (chessComponents[j][i].toString().equals("K")) {
                        K++;
                    }
                    if (chessComponents[j][i].toString().equals("N")) {
                        N++;
                    }
                    if (chessComponents[j][i].toString().equals("P")) {
                        P++;
                    }
                    if (chessComponents[j][i].toString().equals("Q")) {
                        Q++;
                    }
                    if (chessComponents[j][i].toString().equals("R")) {
                        R++;
                    }
                }

            }
            if (K < 1) {
                s.append(String.format("K %d\n", 1));
            }
            if (Q < 1) {
                s.append(String.format("Q %d\n", 1));
            }
            if (R < 2) {
                s.append(String.format("R %d\n", 2 - R));
            }
            if (B < 2) {
                s.append(String.format("B %d\n", 2 - B));
            }
            if (N < 2) {
                s.append(String.format("N %d\n", 2 - N));
            }
            if (P < 8) {
                s.append(String.format("P %d", 8 - P));
            }
            return s.toString();
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[j][i].toString().equals("b")) {
                        B++;
                    }
                    if (chessComponents[j][i].toString().equals("k")) {
                        K++;
                    }
                    if (chessComponents[j][i].toString().equals("n")) {
                        N++;
                    }
                    if (chessComponents[j][i].toString().equals("p")) {
                        P++;
                    }
                    if (chessComponents[j][i].toString().equals("q")) {
                        Q++;
                    }
                    if (chessComponents[j][i].toString().equals("r")) {
                        R++;
                    }
                }

            }
            if (K < 1) {
                s.append(String.format("k %d\n", 1));
            }
            if (Q < 1) {
                s.append(String.format("q %d\n", 1));
            }
            if (R < 2) {
                s.append(String.format("r %d\n", 2 - R));
            }
            if (B < 2) {
                s.append(String.format("b %d\n", 2 - B));
            }
            if (N < 2) {
                s.append(String.format("n %d\n", 2 - N));
            }
            if (P < 8) {
                s.append(String.format("p %d", 8 - P));
            }
            return s.toString();
        }

    }

    
   public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
    if(this.getChess(sourceX,sourceY).getChessColor().equals(this.currentPlayer) && !this.getChess(sourceX,sourceY).getChessColor().equals(ChessColor.NONE)){
        ChessComponent temp = this.getChess(sourceX,sourceY);
        List<ChessboardPoint> terminations = temp.canMoveTo();
        for(ChessboardPoint point : terminations){
            if(point.equals(new ChessboardPoint(targetX,targetY))){
                //temp.setSource(targetX,targetY);
                if(temp instanceof BishopChessComponent) {
                    this.chessComponents[targetX][targetY] = new BishopChessComponent(temp.name, targetX, targetY);
                }else if(temp instanceof KingChessComponent){
                    this.chessComponents[targetX][targetY] = new KingChessComponent((temp.name),targetX,targetY);
                }else if(temp instanceof KnightChessComponent){
                    this.chessComponents[targetX][targetY] = new KnightChessComponent((temp.name),targetX,targetY);
                }else if(temp instanceof PawnChessComponent){
                    this.chessComponents[targetX][targetY] = new PawnChessComponent((temp.name),targetX,targetY);
                }else if(temp instanceof QueenChessComponent){
                    this.chessComponents[targetX][targetY] = new QueenChessComponent((temp.name),targetX,targetY);
                }else if(temp instanceof RookChessComponent){
                    this.chessComponents[targetX][targetY] = new RookChessComponent((temp.name),targetX,targetY);
                }


                this.chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',sourceX,sourceY);

                if(this.currentPlayer.equals(ChessColor.BLACK)){
                    this.currentPlayer = ChessColor.WHITE;
                }else this.currentPlayer = ChessColor.BLACK;
                return true;
            }
        }
    }
    return false;
}


    
       @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent temp = this.chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = temp.canMoveTo();
        canMovePoints.sort((o1, o2) -> {
            if(o1.getX()<o2.getX()){
                return -1;
            }else if(o1.getX() == o2.getX()){
                return o1.getY()-o2.getY();
            }else return 1;
        });
        return canMovePoints;

    }

}
