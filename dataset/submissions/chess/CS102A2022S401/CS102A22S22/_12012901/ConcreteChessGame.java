import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.currentPlayer = ChessColor.WHITE;
        this.chessComponents = new ChessComponent[8][8];
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R' -> {
                        chessComponents[i][j] = new RookChessComponent(chessComponents);
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setName('R');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    }
                    case 'N' -> {
                        chessComponents[i][j] = new KnightChessComponent(chessComponents);
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setName('N');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    }
                    case 'B' -> {
                        chessComponents[i][j] = new BishopChessComponent(chessComponents);
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setName('B');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    }
                    case 'Q' -> {
                        chessComponents[i][j] = new QueenChessComponent(chessComponents);
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setName('Q');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    }
                    case 'K' -> {
                        chessComponents[i][j] = new KingChessComponent(chessComponents);
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setName('K');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    }
                    case 'P' -> {
                        chessComponents[i][j] = new PawnChessComponent(chessComponents);
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setName('P');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    }
                    case '_' -> {
                        chessComponents[i][j] = new EmptySlotComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setName('_');
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                    }
                    case 'r' -> {
                        chessComponents[i][j] = new RookChessComponent(chessComponents);
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setName('r');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    }
                    case 'n' -> {
                        chessComponents[i][j] = new KnightChessComponent(chessComponents);
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setName('n');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    }
                    case 'b' -> {
                        chessComponents[i][j] = new BishopChessComponent(chessComponents);
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setName('b');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    }
                    case 'q' -> {
                        chessComponents[i][j] = new QueenChessComponent(chessComponents);
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setName('q');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    }
                    case 'k' -> {
                        chessComponents[i][j] = new KingChessComponent(chessComponents);
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setName('k');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    }
                    case 'p' -> {
                        chessComponents[i][j] = new PawnChessComponent(chessComponents);
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setName('p');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    }


                }
            }
        }
        switch (chessboard.get(8)) {
            case "w" -> {
                currentPlayer = ChessColor.WHITE;
            }
            case "b" -> {
                currentPlayer = ChessColor.BLACK;
            }
        }

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                str.append(chessComponents[i][j].name);
                if (j == 7 && i != 7) {
                    str.append("\n");
                }
            }
        }
        return str.toString();
    }

    ArrayList<Integer> BchessLossNum = new ArrayList<>();
    ArrayList<Integer> WchessLossNum = new ArrayList<>();
    ArrayList<Character> upOrder = new ArrayList<Character>(Arrays.asList('K', 'Q', 'R', 'B', 'N', 'P'));
    ArrayList<Character> lowOrder = new ArrayList<Character>(Arrays.asList('k', 'q', 'r', 'b', 'n', 'p'));

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder str = new StringBuilder();
        if (player == ChessColor.BLACK) {
            countBlackChessLoss();
            for (int i = 0; i < 6; i++) {
                if (BchessLossNum.get(i) != 0) {
                    str.append(String.format("%c %d\n", upOrder.get(i), BchessLossNum.get(i)));
                }
            }
        } else {
            countWhiteChessLoss();
            for (int i = 0; i < 6; i++) {
                if (WchessLossNum.get(i) != 0) {
                    str.append(String.format("%c %d\n", lowOrder.get(i), WchessLossNum.get(i)));
                }
            }
        }
        return str.toString();
    }

    public void countBlackChessLoss() {
        int restK = 0;
        int restQ = 0;
        int restR = 0;
        int restB = 0;
        int restN = 0;
        int restP = 0;
        BchessLossNum.clear();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].name) {
                    case 'K' -> {
                        restK += 1;
                    }
                    case 'Q' -> {
                        restQ += 1;
                    }
                    case 'R' -> {
                        restR += 1;
                    }
                    case 'N' -> {
                        restN += 1;
                    }
                    case 'B' -> {
                        restB += 1;
                    }
                    case 'P' -> {
                        restP += 1;
                    }
                }

            }
        }
        BchessLossNum.add(1 - restK);
        BchessLossNum.add(1 - restQ);
        BchessLossNum.add(2 - restR);
        BchessLossNum.add(2 - restB);
        BchessLossNum.add(2 - restN);
        BchessLossNum.add(8 - restP);
    }

    public void countWhiteChessLoss() {
        int restk = 0;
        int restq = 0;
        int restr = 0;
        int restb = 0;
        int restn = 0;
        int restp = 0;
        WchessLossNum.clear();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].name) {
                    case 'k' -> {
                        restk += 1;
                    }
                    case 'q' -> {
                        restq += 1;
                    }
                    case 'r' -> {
                        restr += 1;
                    }
                    case 'n' -> {
                        restn += 1;
                    }
                    case 'b' -> {
                        restb += 1;
                    }
                    case 'p' -> {
                        restp += 1;
                    }
                }

            }
        }
        WchessLossNum.add(1 - restk);
        WchessLossNum.add(1 - restq);
        WchessLossNum.add(2 - restr);
        WchessLossNum.add(2 - restb);
        WchessLossNum.add(2 - restn);
        WchessLossNum.add(8 - restp);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX, sourceY).getChessColor() == getCurrentPlayer()) {
            if (getChess(sourceX, sourceY).canMoveTo().contains(getChess(targetX, targetY).getSource())) {
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX, sourceY));
                chessComponents[sourceX][sourceY].setName('_');
                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                if (getCurrentPlayer() == ChessColor.WHITE) {
                    setCurrentPlayer(ChessColor.BLACK);
                } else {
                    setCurrentPlayer(ChessColor.WHITE);
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}
