import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private static ChessGame instance;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;

        this.instance = this;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int m = 0; m < chessboard.size() - 1; m++) {
            String line = chessboard.get(m);
            for (int n = 0; n < line.length(); n++) {
                char chessChar = line.charAt(n);
                ChessColor chessColor = Character.isUpperCase(chessChar) ? ChessColor.BLACK : ChessColor.WHITE;
                ChessComponent chessComponent;
                switch (Character.toLowerCase(chessChar)) {
                    case 'r':
                        chessComponent = new RookChessComponent(m, n, chessColor);
                        break;

                    case 'n':
                        chessComponent = new KnightChessComponent(m, n, chessColor);
                        break;

                    case 'q':
                        chessComponent = new QueenChessComponent(m, n, chessColor);
                        break;

                    case 'k':
                        chessComponent = new KingChessComponent(m, n, chessColor);
                        break;
                    case 'p':
                        chessComponent = new PawnChessComponent(m, n, chessColor);
                        break;

                    case 'b':
                        chessComponent = new BishopChessComponent(m, n, chessColor);
                        break;

                    default:
                        chessComponent = new EmptySlotComponent(m, n);
                }

                chessComponents[m][n] = chessComponent;
            }
        }

        String color = chessboard.get(chessboard.size() - 1);
        currentPlayer = color.equals("w") ? ChessColor.WHITE : ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        if (!isValidPoint(x, y)) return null;

        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String[] chessOutputs = new String[8];
        for (int i = 0; i < chessOutputs.length; i++) {
            chessOutputs[i] = "";
        }

        for (int m = 0; m < chessComponents.length; m++) {
            for (int n = 0; n < chessComponents[m].length; n++) {
                chessOutputs[m] += chessComponents[m][n].toString();
            }
        }

        return String.join("\n", chessOutputs);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] currentChessCount = {1, 1, 2, 2, 2, 8};
        String chessAbbreviations = "kqrbnp";


        for (int m = 0; m < chessComponents.length; m++) {
            for (int n = 0; n < chessComponents[m].length; n++) {
                ChessComponent chessComponent = chessComponents[m][n];
                if (chessComponent.getChessColor() == player && !(chessComponent instanceof EmptySlotComponent)) {
                    String chessString = Character.toString(chessComponent.name).toLowerCase(Locale.ROOT);
                    currentChessCount[chessAbbreviations.indexOf(chessString)]--;
                }
            }
        }
        if (player == ChessColor.BLACK) {
            chessAbbreviations = chessAbbreviations.toUpperCase(Locale.ROOT);
        }

        ArrayList<String> output = new ArrayList<String>();

        for (int m = 0; m < chessAbbreviations.length(); m++) {
            if (currentChessCount[m] > 0) {
                output.add(String.format("%c %d", chessAbbreviations.charAt(m), currentChessCount[m]));
            }
        }

        return String.join("\n", output);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        Collections.sort(canMovePoints);
        return canMovePoints;
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (!isValidPoint(sourceX, sourceY) || !isValidPoint(targetX, targetY))
            return false;

        ChessComponent sourceChess = getChess(sourceX, sourceY);
        ChessComponent targetChess = getChess(targetX, targetY);

        if (sourceChess.getChessColor() != getCurrentPlayer())
            return false;

        if (!sourceChess.canMoveTo(targetX, targetY))
            return false;
        sourceChess.setSource(new ChessboardPoint(targetX, targetY));
        targetChess.setSource(new ChessboardPoint(sourceX, sourceY));
        chessComponents[targetX][targetY] = sourceChess;

        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY);


        switchPlayer();
        return true;
    }

    @Override
    public boolean isValidPoint(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7)
            return false;

        return true;
    }

    public static ChessGame getInstance() {
        return instance;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;
    }

}
