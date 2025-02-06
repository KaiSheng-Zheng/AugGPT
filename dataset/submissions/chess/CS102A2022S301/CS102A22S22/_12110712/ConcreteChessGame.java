import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public void judgeColor(char color) {
        if (color == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else this.currentPlayer = ChessColor.BLACK;}

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                char name = chessboard.get(i).charAt(j);
                this.reload(name, i, j);}}
        this.judgeColor(chessboard.get(8).charAt(0));}

    public void reload(char name, int i, int j) {
        if (name != '_') {
            char upName = Character.toUpperCase(name);
            if (upName == 'K') {this.chessComponents[i][j] = new KingChessComponent(i, j, name, chessComponents);
            } else if (upName == 'Q') {this.chessComponents[i][j] = new QueenChessComponent(i, j, name, chessComponents);
            } else if (upName == 'B') {this.chessComponents[i][j] = new BishopChessComponent(i, j, name, chessComponents);
            } else if (upName == 'N') {this.chessComponents[i][j] = new KnightChessComponent(i, j, name, chessComponents);
            } else if (upName == 'R') {this.chessComponents[i][j] = new RookChessComponent(i, j, name, chessComponents);
            } else if (upName == 'P') {this.chessComponents[i][j] = new PawnChessComponent(i, j, name, chessComponents);}
        } else {this.chessComponents[i][j] = new EmptySlotComponent(i, j, name);}}

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
        String chessBoardGraph = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoardGraph = chessBoardGraph.concat(String.valueOf(this.chessComponents[i][j].getName()));}
            chessBoardGraph = chessBoardGraph.concat("\n");}
        return chessBoardGraph;}

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] existChessNum = new int[6];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() == player) {
                    existChessNum[Math.abs(chessComponents[i][j].getPower())-1]++;}}}
        return getCapturedList(existChessNum, player);}


    public String getCapturedList(int[] n, ChessColor player) {
        int[] capturedChessNum = getPowers(n);
        String[] white = {"k", "q", "r", "b", "n", "p"};
        String[] black = {"K", "Q", "R", "B", "N", "P"};
        String[] current;
        String list = "";
        if (player == ChessColor.WHITE) {current = white;}
        else {current = black;}
        for (int i = 0; i < 6; i++) {
            if (n[i] != 0 && capturedChessNum[i] != 0) {
                list = list.concat(current[i] + " " + n[i] + "\n");}}
        return list;}

    private int[] getPowers(int[] chessPower) {
        chessPower[0] = 1 - chessPower[0];chessPower[1] = 1 - chessPower[1];
        chessPower[2] = 2 - chessPower[2];chessPower[3] = 2 - chessPower[3];
        chessPower[4] = 2 - chessPower[4];chessPower[5] = 8 - chessPower[5];
        return chessPower;}

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        if (source == null) {return new ArrayList<>();}
        return this.chessComponents[source.getX()][source.getY()].canMoveTo();}

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> canMovePoints = getCanMovePoints(chessComponents[sourceX][sourceY].getSource());
        ChessboardPoint targetPoint = new ChessboardPoint(targetX, targetY);

        if (checkIf(targetPoint,canMovePoints) && getChess(sourceX, sourceY).getChessColor() == getCurrentPlayer()) {
            ChessComponent chess0 = getChess(sourceX, sourceY);
            reload(chess0.name, targetX, targetY);
            reload('_', sourceX, sourceY);
            swapColor();
            return true;}
        else return false;}

    public void swapColor() {
        this.currentPlayer = this.currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;}

    public boolean checkIf(ChessboardPoint targetPoint, List<ChessboardPoint> canMovePoints) {
        for (ChessboardPoint a:canMovePoints){
            if (a.getX()== targetPoint.getX()&&a.getY()== targetPoint.getY()) {return true;}
            else continue;
        }return false;}
}
