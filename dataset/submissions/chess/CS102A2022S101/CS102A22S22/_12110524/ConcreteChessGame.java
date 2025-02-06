import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private int[][] cnt;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
        this.cnt = new int[2][6];
    }

    private int chessIdx(char ch) {
        switch (Character.toUpperCase(ch)) {
            case 'K': return 0;
            case 'Q': return 1;
            case 'R': return 2;
            case 'B': return 3;
            case 'N': return 4;
            case 'P': return 5;
        }
        return -1;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        this.currentPlayer = chessboard.get(8).charAt(0) == 'w' ? ChessColor.WHITE : ChessColor.BLACK;
        char ch;
        for (int i = 0; i <= 7; i++)
            for (int j = 0; j <= 7; j++){
                ch = chessboard.get(i).charAt(j);
                if (ch != '_') cnt[Character.isUpperCase(ch) ? 1 : 0][chessIdx(ch)]++;
                switch(Character.toUpperCase(ch)) {
                    case 'K': this.chessComponents[i][j] = new KingChessComponent(Character.isUpperCase(ch), i, j);break;
                    case 'Q': this.chessComponents[i][j] = new QueenChessComponent(Character.isUpperCase(ch), i, j);break;
                    case 'R': this.chessComponents[i][j] = new RookChessComponent(Character.isUpperCase(ch), i, j);break;
                    case 'B': this.chessComponents[i][j] = new BishopChessComponent(Character.isUpperCase(ch), i, j);break;
                    case 'N': this.chessComponents[i][j] = new KnightChessComponent(Character.isUpperCase(ch), i, j);break;
                    case 'P': this.chessComponents[i][j] = new PawnChessComponent(Character.isUpperCase(ch), i, j);break;
                    case '_': this.chessComponents[i][j] = new EmptySlotComponent();break;
                }
            }
        ChessComponent.setBoard(chessComponents);
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder stringBuilder = new StringBuilder(78);
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 7; j++)
                stringBuilder.append(this.chessComponents[i][j].toString());
            stringBuilder.append('\n');
        }
        for (int i = 0; i <= 7; i++) stringBuilder.append(this.chessComponents[7][i].toString());
        return stringBuilder.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder stringBuilder = new StringBuilder();
        if (player == ChessColor.WHITE) {
            if (this.cnt[0][0] != 1) stringBuilder.append("k 1\n");
            if (this.cnt[0][1] != 1) stringBuilder.append("q 1\n");
            if (this.cnt[0][2] != 2) stringBuilder.append("r "+String.valueOf(2-this.cnt[0][2])+"\n");
            if (this.cnt[0][3] != 2) stringBuilder.append("b "+String.valueOf(2-this.cnt[0][3])+"\n");
            if (this.cnt[0][4] != 2) stringBuilder.append("n " +String.valueOf(2-this.cnt[0][4])+"\n");
            if (this.cnt[0][5] != 8) stringBuilder.append("p " +String.valueOf(8-this.cnt[0][5])+"\n");
        }
        else {
            if (this.cnt[1][0] != 1) stringBuilder.append("K 1\n");
            if (this.cnt[1][1] != 1) stringBuilder.append("Q 1\n");
            if (this.cnt[1][2] != 2) stringBuilder.append("R "+String.valueOf(2-this.cnt[1][2])+"\n");
            if (this.cnt[1][3] != 2) stringBuilder.append("B "+String.valueOf(2-this.cnt[1][3])+"\n");
            if (this.cnt[1][4] != 2) stringBuilder.append("N " +String.valueOf(2-this.cnt[1][4])+"\n");
            if (this.cnt[1][5] != 8) stringBuilder.append("P " +String.valueOf(8-this.cnt[1][5])+"\n");
        }
        return stringBuilder.toString();
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint chessboardPoint) {
        List list = chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].canMoveTo();
        list.sort(new CompareRule());
        return list;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX < 0 || sourceX > 7 || sourceY < 0 || sourceY > 7) return false;
        if (targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7) return false;
        ChessComponent source = chessComponents[sourceX][sourceY];
        ChessComponent target = chessComponents[targetX][targetY];
        if (Character.isUpperCase(source.name) == (currentPlayer == ChessColor.BLACK) && source.name != '_') {
            List<ChessboardPoint> list = source.canMoveTo();
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getX() == targetX && list.get(i).getY() == targetY) {
                    source.setSource(new ChessboardPoint(targetX, targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    chessComponents[targetX][targetY] = source;
                    if (target.name != '_') this.cnt[Character.isUpperCase(target.name) ? 1 : 0][chessIdx(target.name)]--;
                    this.currentPlayer = this.currentPlayer == ChessColor.WHITE? ChessColor.BLACK : ChessColor.WHITE;
                    return true;
                }
        }
        return false;
    }
}

class CompareRule implements Comparator<ChessboardPoint> {

    @Override
    public int compare(ChessboardPoint p1, ChessboardPoint p2) {
        if (p1.getX() > p2.getX() || (p1.getX() == p2.getX() && p1.getY() > p2.getY())) return 1;
        return -1;
    }
}