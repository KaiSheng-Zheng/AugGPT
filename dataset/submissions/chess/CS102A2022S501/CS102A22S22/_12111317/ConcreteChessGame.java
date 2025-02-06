import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    private List<String> chessboard;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessboard.get(i).charAt(j) == 'R') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new RookChessComponent(getChessComponents(), chessboardPoint);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].name = 'R';
                    } else if (chessboard.get(i).charAt(j) == 'r') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new RookChessComponent(getChessComponents(), chessboardPoint);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].name = 'r';
                    } else if (chessboard.get(i).charAt(j) == 'N') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new KnightChessComponent(getChessComponents(), chessboardPoint);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].name = 'N';
                    } else if (chessboard.get(i).charAt(j) == 'n') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new KnightChessComponent(getChessComponents(), chessboardPoint);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].name = 'n';
                    } else if (chessboard.get(i).charAt(j) == 'B') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new BishopChessComponent(getChessComponents(), chessboardPoint);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].name = 'B';
                    } else if (chessboard.get(i).charAt(j) == 'b') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new BishopChessComponent(getChessComponents(), chessboardPoint);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].name = 'b';
                    } else if (chessboard.get(i).charAt(j) == 'Q') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new QueenChessComponent(getChessComponents(), chessboardPoint);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].name = 'Q';
                    } else if (chessboard.get(i).charAt(j) == 'q') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new QueenChessComponent(getChessComponents(), chessboardPoint);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].name = 'q';
                    } else if (chessboard.get(i).charAt(j) == 'K') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new KingChessComponent(getChessComponents(), chessboardPoint);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].name = 'K';
                    } else if (chessboard.get(i).charAt(j) == 'k') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new KingChessComponent(getChessComponents(), chessboardPoint);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].name = 'k';
                    } else if (chessboard.get(i).charAt(j) == 'P') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new PawnChessComponent(getChessComponents(), chessboardPoint);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].name = 'P';
                    } else if (chessboard.get(i).charAt(j) == 'p') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new PawnChessComponent(getChessComponents(), chessboardPoint);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].name = 'p';
                    } else if (chessboard.get(i).charAt(j) == '_') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new EmptySlotComponent(getChessComponents(), chessboardPoint);
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                        chessComponents[i][j].name = '_';
                    }
                }
            }
            if (chessboard.get(8).charAt(0) == 'w') {
                currentPlayer = ChessColor.WHITE;
            } else if (chessboard.get(8).charAt(0) == 'b') {
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
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                str.append(chessComponents[i][j].name);
            }
            str.append("\n");
        }
        return String.valueOf(str);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder stringBuilder = new StringBuilder();
        if (player == ChessColor.BLACK){
            int K = 0, Q = 0, R = 0, N = 0, P = 0, B = 0;
            for (int i = 0; i <= 7; i++){
                for (int j = 0; j <= 7; j++){
                    if (chessComponents[i][j].name == 'K'){
                        K = 1;
                    }
                    if (chessComponents[i][j].name == 'Q'){
                        Q = 1;
                    }
                    if (chessComponents[i][j].name == 'R'){
                        R += 1;
                    }
                    if (chessComponents[i][j].name == 'B'){
                        B += 1;
                    }
                    if (chessComponents[i][j].name == 'N'){
                        N += 1;
                    }
                    if (chessComponents[i][j].name == 'P'){
                        P += 1;
                    }
                }
            }
            if (K == 0){
                stringBuilder.append("K 1\n");
            }
            if (Q == 0){
                stringBuilder.append("Q 1\n");
            }
            if (R != 2){
                stringBuilder.append("R ").append(2-R).append("\n");
            }
            if (B != 2){
                stringBuilder.append("B ").append(2-B).append("\n");
            }
            if (N != 2){
                stringBuilder.append("N ").append(2-N).append("\n");
            }
            if (P != 8){
                stringBuilder.append("P ").append(8-P).append("\n");
            }
        }else {
            int k = 0, q = 0, r = 0, b = 0, n = 0, p = 0;
            for (int i = 0; i <= 7; i++){
                for (int j = 0; j <= 7; j++){
                    if (chessComponents[i][j].name == 'k'){
                        k = 1;
                    }
                    if (chessComponents[i][j].name == 'q'){
                        q = 1;
                    }
                    if (chessComponents[i][j].name == 'r'){
                        r += 1;
                    }
                    if (chessComponents[i][j].name =='b' ){
                        b += 1;
                    }
                    if (chessComponents[i][j].name == 'n'){
                        n += 1;
                    }
                    if (chessComponents[i][j].name == 'p'){
                        p += 1;
                    }
                }
            }
            if (k == 0){
                stringBuilder.append("k 1\n");
            }
            if (q == 0){
                stringBuilder.append("q 1\n");
            }
            if (r != 2){
                stringBuilder.append("r ").append(2-r).append("\n");
            }
            if (b != 2){
                stringBuilder.append("b ").append(2-b).append("\n");
            }
            if (n != 2){
                stringBuilder.append("n ").append(2-n).append("\n");
            }
            if (p != 8){
                stringBuilder.append("p ").append(8-p).append("\n");
            }
        }
        return String.valueOf(stringBuilder);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        List<ChessboardPoint> newCanMovePoints = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    for (int x = 0; x < canMovePoints.size(); x++) {
                        if (canMovePoints.get(x).getX() == i && canMovePoints.get(x).getY() == j) {
                            newCanMovePoints.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }
        return newCanMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int count = 0;
        if (currentPlayer == ChessColor.WHITE) {
            if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer) {
                if (chessComponents[sourceX][sourceY].canMoveTo() != null) {
                    for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++){
                        if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == targetX && chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == targetY){
                            count++;
                        }
                    }
                    if (count != 0){
                        ChessComponent chessComponent = chessComponents[sourceX][sourceY];
                        chessComponents[targetX][targetY] = chessComponent;
                        chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                        ChessboardPoint chessboardPoint = new ChessboardPoint(sourceX, sourceY);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(chessComponents, chessboardPoint);
                        chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX, sourceY));
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        currentPlayer = ChessColor.BLACK;
                    return true;
                    } else {
                        return false;
                    }
                }else {
                    return false;
                }
            }else {
                return false;
            }
        } else if (currentPlayer == ChessColor.BLACK){
            if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer){
                if (chessComponents[sourceX][sourceY].canMoveTo() != null){
                    for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++){
                        if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == targetX && chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == targetY){
                            count++;
                        }
                    }
                    if (count != 0){
                        ChessComponent chessComponent = chessComponents[sourceX][sourceY];
                        chessComponents[targetX][targetY] = chessComponent;
                        chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                        ChessboardPoint chessboardPoint = new ChessboardPoint(sourceX, sourceY);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(chessComponents, chessboardPoint);
                        chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX, sourceY));
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        currentPlayer =ChessColor.WHITE;
                    return true;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }else {
                return false;
            }
        } else {
            return false;
        }
    }
    }