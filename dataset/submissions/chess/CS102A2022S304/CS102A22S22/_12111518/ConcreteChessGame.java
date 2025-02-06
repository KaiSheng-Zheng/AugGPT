import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size() - 1; i++) {
            String line = chessboard.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'Q') {
                    this.chessComponents[i][j] = new QueenChessComponent(i, j, ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (line.charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(i, j, ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (line.charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(i, j, ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (line.charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(i, j, ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (line.charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(i, j, ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (line.charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(i, j, ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (line.charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(i, j, ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (line.charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(i, j, ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (line.charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(i, j, ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (line.charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(i, j, ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (line.charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(i, j, ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (line.charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(i, j, ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (line.charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(i, j, ChessColor.NONE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
            }
        }
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
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
        ArrayList<String> chessboard = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                str.append(chessComponents[i][j]);
            }
            chessboard.add(str.toString());
        }
        String out = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", chessboard.get(0), chessboard.get(1), chessboard.get(2)
                , chessboard.get(3), chessboard.get(4), chessboard.get(5), chessboard.get(6), chessboard.get(7));
        return out;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if (player == ChessColor.BLACK) {
            int queen = 1;
            int king = 1;
            int knight = 2;
            int rook = 2;
            int bishops = 2;
            int pawns = 8;
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (queen != 0 && chessComponents[i][j].toString().equals("Q")) {
                        queen--;
                    }
                    if (king != 0 && chessComponents[i][j].toString().equals("K")) {
                        king--;
                    }
                    if (rook != 0 && chessComponents[i][j].toString().equals("R")) {
                        rook--;
                    }
                    if (knight != 0 && chessComponents[i][j].toString().equals("N")) {
                        knight--;
                    }
                    if (bishops != 0 && chessComponents[i][j].toString().equals("B")) {
                        bishops--;
                    }
                    if (pawns != 0 && chessComponents[i][j].toString().equals("P")) {
                        pawns--;
                    }
                }
            }
            if (king != 0) {
                String t = String.format("K %d\n", king);
                str.append(t);
            }
            if (queen != 0) {
                String t = String.format("Q %d\n", queen);
                str.append(t);
            }
            if (rook != 0) {
                String t = String.format("R %d\n", rook);
                str.append(t);
            }
            if (bishops != 0) {
                String t = String.format("B %d\n", bishops);
                str.append(t);
            }
            if (knight != 0) {
                String t = String.format("N %d\n", knight);
                str.append(t);
            }
            if (pawns != 0) {
                String t = String.format("P %d\n", pawns);
                str.append(t);
            }
            return str.toString();
        } else {
            int queen = 1;
            int king = 1;
            int knight = 2;
            int rook = 2;
            int bishops = 2;
            int pawns = 8;
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (queen != 0 && chessComponents[i][j].toString().equals("q")) {
                        queen--;
                    }
                    if (king != 0 && chessComponents[i][j].toString().equals("k")) {
                        king--;
                    }
                    if (rook != 0 && chessComponents[i][j].toString().equals("r")) {
                        rook--;
                    }
                    if (knight != 0 && chessComponents[i][j].toString().equals("n")) {
                        knight--;
                    }
                    if (bishops != 0 && chessComponents[i][j].toString().equals("b")) {
                        bishops--;
                    }
                    if (pawns != 0 && chessComponents[i][j].toString().equals("p")) {
                        pawns--;
                    }
                }
            }
            if (king != 0) {
                String t = String.format("k %d\n", king);
                str.append(t);
            }
            if (queen != 0) {
                String t = String.format("q %d\n", queen);
                str.append(t);
            }

            if (rook != 0) {
                String t = String.format("r %d\n", rook);
                str.append(t);
            }
            if (bishops != 0) {
                String t = String.format("b %d\n", bishops);
                str.append(t);
            }
            if (knight != 0) {
                String t = String.format("n %d\n", knight);
                str.append(t);
            }
            if (pawns != 0) {
                String t = String.format("p %d\n", pawns);
                str.append(t);
            }
            return str.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
       
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
     
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean r = false;
        if (targetX > 7 || targetX < 0 || targetY > 7 || targetY < 0) {
            return r;
        } else {
            ChessComponent q1 = chessComponents[sourceX][sourceY];
            ChessComponent q2 = chessComponents[targetX][targetY];

            if ((currentPlayer == ChessColor.BLACK && q1.getChessColor() == ChessColor.BLACK) ||
                    (currentPlayer == ChessColor.WHITE && q1.getChessColor() == ChessColor.WHITE)) {
                for (ChessboardPoint chess : q1.canMoveTo()) {
                    if (chess.getX() == targetX && chess.getY() == targetY) {
                        q1.setSource(new ChessboardPoint(targetX, targetY));
                        chessComponents[targetX][targetY] = q1;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, ChessColor.NONE);
                        this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                        this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                        if (currentPlayer == ChessColor.BLACK) {
                            currentPlayer = ChessColor.WHITE;
                        } else {
                            currentPlayer = ChessColor.BLACK;
                        }
                        r = true;
                        break;
                    }
                }
            }
            return r;
        }
    }
}