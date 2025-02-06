import java.util.ArrayList;
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

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
        ChessColor black = ChessColor.BLACK, white = ChessColor.WHITE;
        // EmptySlot;
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_', chessComponents);
            }
        }

        // Pawn
        for (int i = 0; i < 8; i++) {
            chessComponents[1][i] = new PawnChessComponent(new ChessboardPoint(1, i), black, 'P', chessComponents);
            chessComponents[6][i] = new PawnChessComponent(new ChessboardPoint(6, i), white, 'p', chessComponents);
        }

        //Rook
        chessComponents[0][0] = new RookChessComponent(new ChessboardPoint(0, 0), black, 'R', chessComponents);
        chessComponents[0][7] = new RookChessComponent(new ChessboardPoint(0, 7), black, 'R', chessComponents);
        chessComponents[7][0] = new RookChessComponent(new ChessboardPoint(7, 0), white, 'r', chessComponents);
        chessComponents[7][7] = new RookChessComponent(new ChessboardPoint(7, 7), white, 'r', chessComponents);

        //Knight
        chessComponents[0][1] = new KnightChessComponent(new ChessboardPoint(0, 1), black, 'N', chessComponents);
        chessComponents[0][6] = new KnightChessComponent(new ChessboardPoint(0, 6), black, 'N', chessComponents);
        chessComponents[7][1] = new KnightChessComponent(new ChessboardPoint(7, 1), white, 'n', chessComponents);
        chessComponents[7][6] = new KnightChessComponent(new ChessboardPoint(7, 6), white, 'n', chessComponents);

        //Bishop
        chessComponents[0][2] = new BishopChessComponent(new ChessboardPoint(0, 2), black, 'B', chessComponents);
        chessComponents[0][5] = new BishopChessComponent(new ChessboardPoint(0, 5), black, 'B', chessComponents);
        chessComponents[7][2] = new BishopChessComponent(new ChessboardPoint(7, 2), white, 'b', chessComponents);
        chessComponents[7][5] = new BishopChessComponent(new ChessboardPoint(7, 5), white, 'b', chessComponents);

        //King && Queen
        chessComponents[0][3] = new QueenChessComponent(new ChessboardPoint(0, 3), black, 'Q', chessComponents);
        chessComponents[7][3] = new QueenChessComponent(new ChessboardPoint(7, 3), white, 'q', chessComponents);
        chessComponents[0][4] = new KingChessComponent(new ChessboardPoint(0, 4), black, 'K', chessComponents);
        chessComponents[7][4] = new KingChessComponent(new ChessboardPoint(7, 4), white, 'k', chessComponents);
    }

    public void loadChessGame(List<String> chessboard) {
        chessComponents = new ChessComponent[8][8];//clear Chessboard
        ChessColor black = ChessColor.BLACK, white = ChessColor.WHITE;
        for (int i = 0; i < 8; i++) {
            String s = chessboard.get(i);
            for (int j = 0; j < s.length(); j++) {
                ChessboardPoint point = new ChessboardPoint(i, j);
                char c = s.charAt(j);
                switch (c) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(point, black, c, chessComponents);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(point, white, c, chessComponents);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(point, black, c, chessComponents);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(point, white, c, chessComponents);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(point, black, c, chessComponents);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(point, white, c, chessComponents);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(point, black, c, chessComponents);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(point, white, c, chessComponents);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(point, black, c, chessComponents);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(point, white, c, chessComponents);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(point, black, c, chessComponents);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(point, white, c, chessComponents);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(point, ChessColor.NONE, c, chessComponents);
                        break;
                    default:
                        break;
                }
            }
        }
        String player = chessboard.get(8);
        if (player.equals("w"))
            currentPlayer = white;
        if (player.equals("b"))
            currentPlayer = black;
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder buf = new StringBuilder();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                buf.append(getChess(row, col).toString());
            }
            buf.append("\n");
        }
        return buf.toString();
    }

    public String getCapturedChess(ChessColor player) {
        String allComponent = getChessboardGraph();
        StringBuilder buf = new StringBuilder();
        if (player == ChessColor.BLACK) {
            if (!allComponent.contains("K"))
                buf.append("K 1\n");
            if (!allComponent.contains("Q"))
                buf.append("Q 1\n");
            if (countStr(allComponent, "R") != 2)
                buf.append(String.format("R %d\n", 2 - countStr(allComponent, "R")));
            if (countStr(allComponent, "B") != 2)
                buf.append(String.format("B %d\n", 2 - countStr(allComponent, "B")));
            if (countStr(allComponent, "N") != 2)
                buf.append(String.format("N %d\n", 2 - countStr(allComponent, "N")));
            if (countStr(allComponent, "P") != 8)
                buf.append(String.format("P %d\n", 8 - countStr(allComponent, "P")));
            return buf.toString();
        }
        if (player == ChessColor.WHITE) {
            if (!allComponent.contains("k"))
                buf.append("k 1\n");
            if (!allComponent.contains("q"))
                buf.append("q 1\n");
            if (countStr(allComponent, "r") != 2)
                buf.append(String.format("r %d\n", 2 - countStr(allComponent, "r")));
            if (countStr(allComponent, "b") != 2)
                buf.append(String.format("b %d\n", 2 - countStr(allComponent, "b")));
            if (countStr(allComponent, "n") != 2)
                buf.append(String.format("n %d\n", 2 - countStr(allComponent, "n")));
            if (countStr(allComponent, "p") != 8)
                buf.append(String.format("p %d\n", 8 - countStr(allComponent, "p")));
            return buf.toString();
        }
        return buf.toString();
    }


    public static int countStr(String longStr, String mixStr) {
        if (longStr == null || mixStr == null || "".equals(longStr.trim()) || "".equals(mixStr.trim())) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = longStr.indexOf(mixStr, index)) != -1) {
            index = index + mixStr.length();
            count++;
        }
        return count;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // TODO Auto-generated method stub
        int row = source.getX();
        int col = source.getY();
        ChessComponent component = chessComponents[row][col];
        return component.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent component = chessComponents[sourceX][sourceY];
        ChessboardPoint sourcePoint = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint targetPoint = new ChessboardPoint(targetX, targetY);

        if (component.getChessColor() == currentPlayer)
//            if (getCanMovePoints(sourcePoint).contains(targetPoint))
            for (ChessboardPoint chessboardPoint : getCanMovePoints(sourcePoint)) {
                if (chessboardPoint.toString().equals(targetPoint.toString())) {
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourcePoint, ChessColor.NONE, '_', chessComponents);
                    component.setChessboardPoint(targetPoint);
                    chessComponents[targetX][targetY] = component;
                    currentPlayer = (currentPlayer == ChessColor.WHITE) ? ChessColor.BLACK : ChessColor.WHITE;
                    return true;
                }
            }
//         TODO Auto-generated method stub
        return false;
    }

    public static void main(String[] args) {
        List<String> chessboard = new ArrayList<>();
        chessboard.add("R_BQK___");
        chessboard.add("PPP__PP_");
        chessboard.add("__NPP_n_");
        chessboard.add("___Np___");
        chessboard.add("___p____");
        chessboard.add("__p_____");
        chessboard.add("pp___pp_");
        chessboard.add("rnb_kb_R");
        chessboard.add("w");
        ConcreteChessGame game = new ConcreteChessGame();
        game.loadChessGame(chessboard);
        ChessComponent component = game.getChess(7, 4);
        System.out.println(component.canMoveTo());

    }
}


