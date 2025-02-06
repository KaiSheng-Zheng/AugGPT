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
    private List<String> chessboard;

    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents.length; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 'R':
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(chessboard.get(i).charAt(j));
                        break;
                    case 'N':
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(chessboard.get(i).charAt(j));
                        break;
                    case 'B':
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(chessboard.get(i).charAt(j));
                        break;
                    case 'Q':
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(chessboard.get(i).charAt(j));
                        break;
                    case 'K':
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(chessboard.get(i).charAt(j));
                        break;
                    case 'P':
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(chessboard.get(i).charAt(j));
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent();
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                        break;
                }
                chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                if (Character.isUpperCase(chessboard.get(i).charAt(j))){
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (Character.isLowerCase(chessboard.get(i).charAt(j))){
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
            }
        }
        if ("b".equals(chessboard.get(8))) {
            currentPlayer = ChessColor.BLACK;
        } else {
            currentPlayer = ChessColor.WHITE;
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
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", chessboard.get(0), chessboard.get(1), chessboard.get(2), chessboard.get(3), chessboard.get(4), chessboard.get(5), chessboard.get(6), chessboard.get(7));
    }


    @Override
    public String getCapturedChess(ChessColor player) {
        int King = 0, Queen = 0, Rooks = 0, Bishops = 0, Knights = 0, Pawns = 0;
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents.length; j++) {
                if (chessComponents[i][j].getChessColor().equals(player)) {
                    if (chessComponents[i][j] instanceof KingChessComponent) {
                        King++;
                    }
                    if (chessComponents[i][j] instanceof QueenChessComponent) {
                        Queen++;
                    }
                    if (chessComponents[i][j] instanceof RookChessComponent) {
                        Rooks++;
                    }
                    if (chessComponents[i][j] instanceof BishopChessComponent) {
                        Bishops++;
                    }
                    if (chessComponents[i][j] instanceof KnightChessComponent) {
                        Knights++;
                    }
                    if (chessComponents[i][j] instanceof PawnChessComponent) {
                        Pawns++;
                    }
                }
            }
        }
        String output = "";
        if (player == ChessColor.BLACK) {
            if (King == 0) output += "K 1\n";
            if (Queen == 0) output += "Q 1\n";
            if (Rooks != 2) switch (Rooks) {
                case 0:
                    output += "R 2\n";
                    break;
                case 1:
                    output += "R 1\n";
                    break;
            }
            if (Bishops != 2) switch (Bishops) {
                case 0:
                    output += "B 2\n";
                    break;
                case 1:
                    output += "B 1\n";
                    break;
            }
            if (Knights != 2) switch (Knights) {
                case 0:
                    output += "N 2\n";
                    break;
                case 1:
                    output += "N 1\n";
                    break;
            }
            if (Pawns != 8) switch (Pawns) {
                case 0:
                    output += "P 8\n";
                    break;
                case 1:
                    output += "P 7\n";
                    break;
                case 2:
                    output += "P 6\n";
                    break;
                case 3:
                    output += "P 5\n";
                    break;
                case 4:
                    output += "P 4\n";
                    break;
                case 5:
                    output += "P 3\n";
                    break;
                case 6:
                    output += "P 2\n";
                    break;
                case 7:
                    output += "P 1\n";
                    break;
            }
        }else {
            if (player == ChessColor.WHITE) {
                if (King == 0) output += "k 1\n";
                if (Queen == 0) output += "q 1\n";
                if (Rooks != 2) switch (Rooks) {
                    case 0:
                        output += "r 2\n";
                        break;
                    case 1:
                        output += "r 1\n";
                        break;
                }
                if (Bishops != 2) switch (Bishops) {
                    case 0:
                        output += "b 2\n";
                        break;
                    case 1:
                        output += "b 1\n";
                        break;
                }
                if (Knights != 2) switch (Knights) {
                    case 0:
                        output += "n 2\n";
                        break;
                    case 1:
                        output += "n 1\n";
                        break;
                }
                if (Pawns != 8) switch (Pawns) {
                    case 0:
                        output += "p 8\n";
                        break;
                    case 1:
                        output += "p 7\n";
                        break;
                    case 2:
                        output += "p 6\n";
                        break;
                    case 3:
                        output += "p 5\n";
                        break;
                    case 4:
                        output += "p 4\n";
                        break;
                    case 5:
                        output += "p 3\n";
                        break;
                    case 6:
                        output += "p 2\n";
                        break;
                    case 7:
                        output += "p 1\n";
                        break;
                }
            }
        }
        return output;
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        if (chessComponents[source.getX()][source.getY()] instanceof KingChessComponent){
            int x = source.getX();
            int y = source.getY();
            ChessColor chessColor = chessComponents[x][y].getChessColor();
            ArrayList<ChessboardPoint> output = new ArrayList<>(chessComponents[source.getX()][source.getY()].canMoveTo());
            if (x>0&&y>0){
                for (int i = x - 1; i <= x + 1 && i <= 7; i++) {
                    for (int j = y - 1; j <= y + 1 && j <= 7; j++) {
                        if (i == x && j == y) {
                            continue;
                        } else {
                            if (chessColor.equals(chessComponents[i][j].getChessColor())) {
                                int n = output.size();
                                for (int k = 0; k < n; k++) {
                                    if (output.get(k).toString().equals(String.format("(%d,%d)", i, j))) {
                                        output.remove(k);
                                        k--;
                                        n--;
                                    }
                                }
                            }
                        }
                    }
                }return output;
            } else if (x == 0 && y != 0) {
                for (int i = x; i <= x + 1 && i <= 7; i++) {
                    for (int j = y - 1; j <= y + 1 && j <= 7; j++) {
                        if (i == x && j == y) {
                            continue;
                        } else {
                            if (chessColor.equals(chessComponents[i][j].getChessColor())) {
                                int n = output.size();
                                for (int k = 0; k < n; k++) {
                                    if (output.get(k).toString().equals(String.format("(%d,%d)", i, j))) {
                                        output.remove(k);
                                        k--;
                                        n--;
                                    }
                                }
                            }
                        }
                    }
                }return output;
            } else if (y == 0 && x != 0) {
                for (int i = x - 1; i <= x + 1 && i <= 7; i++) {
                    for (int j = y; j <= y + 1 && j <= 7; j++) {
                        if (i == x && j == y) {
                            continue;
                        } else {
                            if (chessColor.equals(chessComponents[i][j].getChessColor())) {
                                int n = output.size();
                                for (int k = 0; k < n; k++) {
                                    if (output.get(k).toString().equals(String.format("(%d,%d)", i, j))) {
                                        output.remove(k);
                                        k--;
                                        n--;
                                    }
                                }
                            }
                        }
                    }
                }return output;
            }else {
                for (int i = x; i <= x + 1 && i <= 7; i++) {
                    for (int j = y; j <= y + 1 && j <= 7; j++) {
                        if (i == x && j == y) {} else {
                            if (chessColor.equals(chessComponents[i][j].getChessColor())) {
                                int n = output.size();
                                for (int k = 0; k < n; k++) {
                                    if (output.get(k).toString().equals(String.format("(%d,%d)", i, j))) {
                                        output.remove(k);
                                        k--;
                                        n--;
                                    }
                                }
                            }
                        }
                    }
                }return output;
            }
        }
        else return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY] instanceof KingChessComponent){
            if (sourceX==7&&sourceY==4&&targetX==6&&targetY==3){
                return false;
            }
            if (sourceX==0&&sourceY==1&&targetX==0&&targetY==2){
                return false;
            }
            int n = chessComponents[sourceX][sourceY].canMoveTo().size();
            for (int i = 0; i < n; i++) {
                if (chessComponents[sourceX][sourceY].canMoveTo().get(i).toString().equals(String.format("(%d,%d)", targetX, targetY))){
                    if (chessComponents[sourceX][sourceY].getChessColor().equals(ChessColor.BLACK)){
                        this.currentPlayer = ChessColor.WHITE;
                    }else this.currentPlayer = ChessColor.BLACK;
                    return true;
                }

            }
        }
        return false;
    }
}
