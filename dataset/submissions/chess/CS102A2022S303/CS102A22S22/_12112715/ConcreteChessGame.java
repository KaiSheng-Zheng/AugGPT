import java.util.HashMap;
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
    private List<String> chessboard;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        for (int i = 0; i < chessboard.size() - 1; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                char name = chessboard.get(i).charAt(j);
                if (Character.toLowerCase(name) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(name, chessComponents, new ChessboardPoint(i, j));
                } else if (Character.toLowerCase(name) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(name, chessComponents, new ChessboardPoint(i, j));
                } else if (Character.toLowerCase(name) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(name, chessComponents, new ChessboardPoint(i, j));
                } else if (Character.toLowerCase(name) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(name, chessComponents, new ChessboardPoint(i, j));
                } else if (Character.toLowerCase(name) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(name, chessComponents, new ChessboardPoint(i, j));
                } else if (Character.toLowerCase(name) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(name, chessComponents, new ChessboardPoint(i, j));
                } else {
                    chessComponents[i][j] = new EmptySlotComponent(chessComponents, new ChessboardPoint(i, j));
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
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
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < chessboard.size() - 1; i++) {
            String s = chessboard.get(i);
            output.append(s).append("\n");
        }
        return output.toString();
    }

    //check the King or Queen
    private void getCapturedKQ(HashMap<Character, Integer> hashMap, StringBuilder output, char KQ) {
        if (!hashMap.containsKey(KQ)) {
            output.append(String.format("%c 1\n", KQ));
        }
    }

    //check the Rook, Bishop, Knight
    private void getCapturedRBN(HashMap<Character, Integer> hashMap, StringBuilder output, char RBN) {
        if (hashMap.containsKey(RBN)) {
            if (2 - hashMap.get(RBN) != 0) {
                output.append(String.format("%c %d\n", RBN, 2 - hashMap.get(RBN)));
            }
        } else {
            output.append(String.format("%c 2\n", RBN));
        }
    }

    //check the Pawn
    private void getCapturedPawn(HashMap<Character, Integer> hashMap, StringBuilder output, char Pawn) {
        if (hashMap.containsKey(Pawn)) {
            if (8 - hashMap.get(Pawn) != 0) {
                output.append(String.format("%c %d\n", Pawn, 8 - hashMap.get(Pawn)));
            }
        } else {
            output.append(String.format("%c 8\n", Pawn));
        }
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder output = new StringBuilder();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char temp;
        for (int i = 0; i < chessboard.size() - 1; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                temp = chessboard.get(i).charAt(j);
                if (hashMap.containsKey(temp)) {
                    hashMap.replace(temp, hashMap.get(temp) + 1);
                } else {
                    hashMap.put(temp, 1);
                }
            }
        }
        if (player == ChessColor.BLACK) {
            getCapturedKQ(hashMap, output, 'K');
            getCapturedKQ(hashMap, output, 'Q');
            getCapturedRBN(hashMap, output, 'R');
            getCapturedRBN(hashMap, output, 'B');
            getCapturedRBN(hashMap, output, 'N');
            getCapturedPawn(hashMap, output, 'P');
        } else {
            getCapturedKQ(hashMap, output, 'k');
            getCapturedKQ(hashMap, output, 'q');
            getCapturedRBN(hashMap, output, 'r');
            getCapturedRBN(hashMap, output, 'b');
            getCapturedRBN(hashMap, output, 'n');
            getCapturedPawn(hashMap, output, 'p');
        }
        return output.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        return chess.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }
}
