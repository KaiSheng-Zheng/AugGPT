import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0) == 'w') this.currentPlayer = ChessColor.WHITE;
        else if (chessboard.get(8).charAt(0) == 'b') this.currentPlayer = ChessColor.BLACK;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                else if (chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                else if (chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                else if (chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                else if (chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                else if (chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                else if (chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                else if (chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                else if (chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                else if (chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                else if (chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                else if (chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                else if (chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                }
                chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                chessComponents[i][j].setChessBoard(chessComponents);
                chessComponents[i][j].setName(chessboard.get(i).charAt(j));
            }
        }

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
        String boardGraph = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String ans = chessComponents[i][j].toString();
                boardGraph = boardGraph.concat(ans);
            }
            boardGraph = boardGraph.concat("\n");
        }
        return boardGraph;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if (player == ChessColor.WHITE){
            int King = 0;
            int Queen = 0;
            int Rooks = 0;
            int Bishops = 0;
            int Knights = 0;
            int Pawns = 0;
            String answer = "";
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("k")) King++;
                    else if (chessComponents[i][j].toString().equals("q")) Queen++;
                    else if (chessComponents[i][j].toString().equals("r")) Rooks++;
                    else if (chessComponents[i][j].toString().equals("b")) Bishops++;
                    else if (chessComponents[i][j].toString().equals("n")) Knights++;
                    else if (chessComponents[i][j].toString().equals("p")) Pawns++;
                }
            }
            if (King != 1) answer = answer.concat("k 1\n");
            if (Queen != 1) answer = answer.concat("q 1\n");
            if (Rooks == 1) answer = answer.concat("r 1\n");
            else if (Rooks == 0) answer = answer.concat("r 2\n");
            if (Bishops == 1) answer = answer.concat("b 1\n");
            else if (Bishops == 0) answer = answer.concat("b 2\n");
            if (Knights == 1) answer = answer.concat("n 1\n");
            else if (Knights == 0) answer = answer.concat("n 2\n");
            if (Pawns != 8) {
                int pNum = 8 - Pawns;
                answer = answer.concat("p " + pNum +"\n");
            }
            return answer;
        }
        if (player == ChessColor.BLACK){
            int King = 0;
            int Queen = 0;
            int Rooks = 0;
            int Bishops = 0;
            int Knights = 0;
            int Pawns = 0;
            String answer = "";
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("K")) King++;
                    else if (chessComponents[i][j].toString().equals("Q")) Queen++;
                    else if (chessComponents[i][j].toString().equals("R")) Rooks++;
                    else if (chessComponents[i][j].toString().equals("B")) Bishops++;
                    else if (chessComponents[i][j].toString().equals("N")) Knights++;
                    else if (chessComponents[i][j].toString().equals("P")) Pawns++;
                }
            }
            if (King != 1) answer = answer.concat("K 1\n");
            if (Queen != 1) answer = answer.concat("Q 1\n");
            if (Rooks == 1) answer = answer.concat("R 1\n");
            else if (Rooks == 0) answer = answer.concat("R 2\n");
            if (Bishops == 1) answer = answer.concat("B 1\n");
            else if (Bishops == 0) answer = answer.concat("B 2\n");
            if (Knights == 1) answer = answer.concat("N 1\n");
            else if (Knights == 0) answer = answer.concat("N 2\n");
            if (Pawns != 8) {
                int pNum = 8 - Pawns;
                answer = answer.concat("P " + pNum +"\n");
            }
            return answer;
        }
        else return "";
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(),source.getY());
        return chess.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (this.chessComponents[sourceX][sourceY].getChessColor() == this.currentPlayer) {
            if (sourceX <= 7 && sourceX >= 0 && sourceY <= 7 && sourceY >=0 && targetX <= 7 && targetX >= 0 && targetY <= 7 && targetY >= 0){
                ChessboardPoint front = new ChessboardPoint(sourceX,sourceY);
                ChessboardPoint behind = new ChessboardPoint(targetX,targetY);
                ChessComponent chess = chessComponents[sourceX][sourceY];
                if (getCanMovePoints(front).size() == 0)
                    return false;
                else {
                    ArrayList<ChessboardPoint> points = new ArrayList<>(getCanMovePoints(front));
                    if (behind.contain(points)){
                       this.chessComponents[behind.getX()][behind.getY()] = chess;
                        this.chessComponents[front.getX()][front.getY()] = new EmptySlotComponent();
                        this.chessComponents[front.getX()][front.getY()].setChessColor(ChessColor.NONE);
                        this.chessComponents[front.getX()][front.getY()].setSource(new ChessboardPoint(front.getX(), front.getY()));
                        this.chessComponents[front.getX()][front.getY()].setName('_');
                        this.chessComponents[front.getX()][front.getY()].setChessBoard(chessComponents);
                        this.chessComponents[behind.getX()][behind.getY()].setSource(new ChessboardPoint(behind.getX(), behind.getY()));
                        this.chessComponents[behind.getX()][behind.getY()].setChessBoard(chessComponents);
                        if (currentPlayer == ChessColor.BLACK) currentPlayer = ChessColor.WHITE;
                        else currentPlayer = ChessColor.BLACK;
                        getCapturedChess(this.currentPlayer);
                        return true;
                    }
                    else return false;
                }
            }
        }
        return false;
    }
}
