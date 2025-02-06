import java.util.ArrayList;
import java.util.List;


public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        ChessColor w = ChessColor.WHITE;
        ChessColor b = ChessColor.BLACK;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint cp = new ChessboardPoint(i, j);
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(b, cp, 'R');
                    chessComponents[i][j].setChessComponent(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(w, cp, 'r');
                    chessComponents[i][j].setChessComponent(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(b, cp, 'B');
                    chessComponents[i][j].setChessComponent(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(w, cp, 'b');
                    chessComponents[i][j].setChessComponent(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(b, cp, 'Q');
                    chessComponents[i][j].setChessComponent(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(w, cp, 'q');
                    chessComponents[i][j].setChessComponent(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(b, cp, 'N');
                    chessComponents[i][j].setChessComponent(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(w, cp, 'n');
                    chessComponents[i][j].setChessComponent(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(b, cp, 'P');
                    chessComponents[i][j].setChessComponent(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(w, cp, 'p');
                    chessComponents[i][j].setChessComponent(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(b, cp, 'K');
                    chessComponents[i][j].setChessComponent(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(w, cp, 'k');
                    chessComponents[i][j].setChessComponent(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE,cp,'_');
                    chessComponents[i][j].setChessComponent(this.chessComponents);
                }

            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = w;
        }
        if (chessboard.get(8).charAt(0) == 'b') {
            currentPlayer = b;
        }
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i != 0 && j == 0) {
                    graph.append("\n");
                }
                graph.append(chessComponents[i][j].toString());
            }
        }
        return graph.toString();
    }


    public String getCapturedChess(ChessColor player) {
        StringBuilder str = new StringBuilder();
        int count_R = 0;
        int count_B = 0;
        int count_Q = 0;
        int count_K = 0;
        int count_N = 0;
        int count_P = 0;
        int count_r = 0;
        int count_b = 0;
        int count_q = 0;
        int count_k = 0;
        int count_n = 0;
        int count_p = 0;
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k') {
                        count_k++;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        count_q++;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        count_r++;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        count_b++;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        count_n++;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        count_p++;
                    }

                }
            }
            if (1 - count_k != 0) {
                str.append("k ").append(1 - count_k).append("\n");
            }
            if (1 - count_q != 0) {
                str.append("q ").append(1 - count_q).append("\n");
            }
            if (2 - count_r != 0) {
                str.append("r ").append(2 - count_r).append("\n");
            }
            if (2 - count_b != 0) {
                str.append("b ").append(2 - count_b).append("\n");
            }
            if (2 - count_n != 0) {
                str.append("n ").append(2 - count_n).append("\n");
            }
            if (8 - count_p != 0) {
                str.append("p ").append(8 - count_p).append("\n");

            }
        }
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        count_K++;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        count_Q++;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        count_R++;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        count_B++;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        count_N++;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        count_P++;
                    }

                }
            }
            if (1 - count_K != 0) {
                str.append("K ").append(1 - count_K).append("\n");
            }
            if (1 - count_Q != 0) {
                str.append("Q ").append(1 - count_Q).append("\n");
            }
            if (2 - count_R != 0) {
                str.append("R ").append(2 - count_R).append("\n");
            }
            if (2 - count_B != 0) {
                str.append("B ").append(2 - count_B).append("\n");
            }
            if (2 - count_N != 0) {
                str.append("N ").append(2 - count_N).append("\n");
            }
            if (8 - count_P != 0) {
                str.append("P ").append(8 - count_P).append("\n");
            }
        }
        return str.toString();
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < chessComponents[source.getX()][source.getY()].canMoveTo().size(); k++) {
                    if (chessComponents[source.getX()][source.getY()].canMoveTo().get(k).getX() == i && chessComponents[source.getX()][source.getY()].canMoveTo().get(k).getY() == j) {
                        canMovePoints.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean result = false;
        for (ChessboardPoint chessboardPoint : chessComponents[sourceX][sourceY].canMoveTo()) {
            if (targetX == chessboardPoint.getX() && targetY == chessboardPoint.getY()){
                result = true;
            }
        }
        if (currentPlayer != chessComponents[sourceX][sourceY].getChessColor()) {
            return false;
        }
        if (sourceX == targetX && targetX == targetY) {
            return false;
        }
        if (chessComponents[sourceX][sourceY].getChessColor() == chessComponents[targetX][targetY].getChessColor()){
            return false;
        }
        if (result == true){
                ChessboardPoint target = new ChessboardPoint(targetX,targetY);
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(target);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(sourceX,sourceY),'_');

                if (currentPlayer == ChessColor.WHITE) {
                    currentPlayer = ChessColor.BLACK;
                } else if (currentPlayer == ChessColor.BLACK){
                    currentPlayer = ChessColor.WHITE;
                }

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        chessComponents[i][j].setChessComponent(this.chessComponents);
                    }
                }
            return true;
        }
        return true;
    }

}
