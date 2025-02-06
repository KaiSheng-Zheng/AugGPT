import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
    }

    public ConcreteChessGame(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char name = chessboard.get(i).charAt(j);
                this.helpConstruct(name, i, j);
            }
        }
        this.helpSetColorOfPlayer(chessboard.get(8).charAt(0));
    }

    public void helpConstruct(char name, int i, int j) {
        if (name != '_') {
            char upName = Character.toUpperCase(name);
            if (upName == 'K') {
                this.chessComponents[i][j] = new KingChessComponent(i, j, name, chessComponents);
            } else if (upName == 'Q') {
                this.chessComponents[i][j] = new QueenChessComponent(i, j, name, chessComponents);
            } else if (upName == 'B') {
                this.chessComponents[i][j] = new BishopChessComponent(i, j, name, chessComponents);
            } else if (upName == 'N') {
                this.chessComponents[i][j] = new KnightChessComponent(i, j, name, chessComponents);
            } else if (upName == 'R') {
                this.chessComponents[i][j] = new RookChessComponent(i, j, name, chessComponents);
            } else if (upName == 'P') {
                this.chessComponents[i][j] = new PawnChessComponent(i, j, name, chessComponents);
            }
        } else {
            this.chessComponents[i][j] = new EmptySlotComponent(i, j, name);
        }
    }

    public void helpSetColorOfPlayer(char color) {
        if (color == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else this.currentPlayer = ChessColor.BLACK;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    /*return an 8-rows String in the same
    format with input chessboard
     */
    @Override
    public String getChessboardGraph() {
        String boardGraph = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardGraph = boardGraph.concat(String.valueOf(this.chessComponents[i][j].getName()));
            }
            boardGraph = boardGraph.concat("\n");
        }
//        if (this.currentPlayer ==ChessColor.WHITE){boardGraph = boardGraph.concat("w");}
//        else {boardGraph = boardGraph.concat("b");}
        return boardGraph;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] existChessNum = new int[6];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() == player) {
                    existChessNum[Math.abs(chessComponents[i][j].getCnt()) - 1]++;
                }
            }
        }
        return getCapturedList(existChessNum, player);
    }


    public String getCapturedList(int[] n, ChessColor player) {
        int[] capturedChessNum = getInts(n);
        String[] white = {"k", "q", "r", "b", "n", "p"};
        String[] black = {"K", "Q", "R", "B", "N", "P"};
        String[] use;
        String answer = "";
        if (player == ChessColor.WHITE) {
            use = white;
        } else {
            use = black;
        }

        for (int i = 0; i < 6; i++) {
            if (n[i] != 0 && capturedChessNum[i] != 0) {
                answer = answer.concat(use[i] + " " + n[i] + "\n");
            }
        }

        return answer;
    }

    private int[] getInts(int[] chessNum) {
        chessNum[0] = 1 - chessNum[0];
        chessNum[1] = 1 - chessNum[1];
        chessNum[2] = 2 - chessNum[2];
        chessNum[3] = 2 - chessNum[3];
        chessNum[4] = 2 - chessNum[4];
        chessNum[5] = 8 - chessNum[5];
        return chessNum;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        if (source == null) {
            return new ArrayList<>();
        }
        return this.chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> canMovePoints = getCanMovePoints(chessComponents[sourceX][sourceY].getSource());
        ChessboardPoint targetPoint = new ChessboardPoint(targetX, targetY);

        if (checkIf(targetPoint,canMovePoints) && getChess(sourceX, sourceY).getChessColor() == getCurrentPlayer()) {
            ChessComponent chess0 = getChess(sourceX, sourceY);
            helpConstruct(chess0.name, targetX, targetY);
            helpConstruct('_', sourceX, sourceY);
            changePlayer(getCurrentPlayer());
            return true;
        }
        return false;
    }
    public void changePlayer(ChessColor currentPlayer){
        if (currentPlayer == ChessColor.BLACK){this.setCurrentPlayer(ChessColor.WHITE);}
        else {this.setCurrentPlayer(ChessColor.BLACK);}
    } 

    public boolean checkIf(ChessboardPoint targetPoint, List<ChessboardPoint> canMovePoints) {
        for (ChessboardPoint a:canMovePoints){
            if (a.getX()== targetPoint.getX()&&a.getY()== targetPoint.getY()) {return true;}
            else continue;
        }return false;
    }
}
