import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R': {
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                        break;
                    }
                    case 'r': {
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                        break;
                    }
                    case 'N': {
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                        break;
                    }
                    case 'n': {
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                        break;
                    }
                    case 'B': {
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                        break;
                    }
                    case 'b': {
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                        break;
                    }
                    case 'Q': {
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                        break;
                    }
                    case 'q': {
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                        break;
                    }
                    case 'K': {
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                        break;
                    }
                    case 'k': {
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                        break;
                    }
                    case 'P': {
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                        break;
                    }
                    case 'p': {
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                        break;
                    }
                    case '_': {
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                        break;
                    }
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "b")) {
            setCurrentPlayer(ChessColor.BLACK);
        }
        else if (Objects.equals(chessboard.get(8), "w")) {
            setCurrentPlayer(ChessColor.WHITE);
        }

    }

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
        StringBuilder str1 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            str1.append(chessComponents[0][i].name);
        }
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            str2.append(chessComponents[1][i].name);
        }
        StringBuilder str3 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            str3.append(chessComponents[2][i].name);
        }
        StringBuilder str4 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            str4.append(chessComponents[3][i].name);
        }
        StringBuilder str5 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            str5.append(chessComponents[4][i].name);
        }
        StringBuilder str6 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            str6.append(chessComponents[5][i].name);
        }
        StringBuilder str7 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            str7.append(chessComponents[6][i].name);
        }
        StringBuilder str8 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            str8.append(chessComponents[7][i].name);
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", str1, str2, str3, str4, str5, str6, str7, str8);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder str = new StringBuilder();
        if (player == ChessColor.BLACK) {
            int[] count = new int[6];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'K': {
                            count[0]++;
                            break;
                        }
                        case 'Q': {
                            count[1]++;
                            break;
                        }
                        case 'R': {
                            count[2]++;
                            break;
                        }
                        case 'B': {
                            count[3]++;
                            break;
                        }
                        case 'N': {
                            count[4]++;
                            break;
                        }
                        case 'P': {
                            count[5]++;
                            break;
                        }
                    }
                }
            }
            if (count[0] < 1) {
                str.append(String.format("%s %d\n", "K", 1));
            }
            if (count[1] < 1) {
                str.append(String.format("%s %d\n", "Q", 1));
            }
            if (count[2] < 2) {
                str.append(String.format("%s %d\n", "R", 2 - count[2]));
            }
            if (count[3] < 2) {
                str.append(String.format("%s %d\n", "B", 2 - count[3]));
            }
            if (count[4] < 2) {
                str.append(String.format("%s %d\n", "N", 2 - count[4]));
            }
            if (count[5] < 8) {
                str.append(String.format("%s %d\n", "P", 8 - count[5]));
            }
            return str.toString();
        }
        int[] count = new int[6];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].name) {
                    case 'k': {
                        count[0]++;
                        break;
                    }
                    case 'q': {
                        count[1]++;
                        break;
                    }
                    case 'r': {
                        count[2]++;
                        break;
                    }
                    case 'b': {
                        count[3]++;
                        break;
                    }
                    case 'n': {
                        count[4]++;
                        break;
                    }
                    case 'p': {
                        count[5]++;
                        break;
                    }
                }
            }
        }
        if (count[0] < 1) {
            str.append(String.format("%s %d\n", "k", 1));
        }
        if (count[1] < 1) {
            str.append(String.format("%s %d\n", "q", 1));
        }
        if (count[2] < 2) {
            str.append(String.format("%s %d\n", "r", 2 - count[2]));
        }
        if (count[3] < 2) {
            str.append(String.format("%s %d\n", "b", 2 - count[3]));
        }
        if (count[4] < 2) {
            str.append(String.format("%s %d\n", "n", 2 - count[4]));
        }
        if (count[5] < 8) {
            str.append(String.format("%s %d\n", "p", 8 - count[5]));
        }
        return str.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = getChess(source.getX(), source.getY()).canMoveTo();
        canMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess=getChess(sourceX,sourceY);
        if (chess.getChessColor() !=getCurrentPlayer()) {
        return false;}
        List<ChessboardPoint> a = getCanMovePoints(chess.getSource());
        for (ChessboardPoint che : a) {
                if (targetX == che.getX() && targetY == che.getY()) {
                    ChessboardPoint target=new ChessboardPoint(targetX,targetY);
                    chess.setSource(target);chess.add(chess.getSource(),chess.name);
                    chessComponents[targetX][targetY] = chess;
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                    if (currentPlayer == ChessColor.BLACK) {
                        setCurrentPlayer(ChessColor.WHITE);
                    } else if (currentPlayer == ChessColor.WHITE) {
                        setCurrentPlayer(ChessColor.BLACK);
                    }
                    return true;
                }
            }
        return false;
    }
}

