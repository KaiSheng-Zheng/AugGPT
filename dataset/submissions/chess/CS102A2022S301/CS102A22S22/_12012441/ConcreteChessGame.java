import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer=ChessColor.NONE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char chess = chessboard.get(i).charAt(j);
                if (chess == 'R') {
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chess);
                } else if (chess == 'r') {
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chess);
                } else if (chess == 'N') {
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chess);
                } else if (chess == 'n') {
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chess);
                } else if (chess == 'B') {
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chess);
                } else if (chess == 'b') {
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chess);
                } else if (chess == 'Q') {
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chess);
                } else if (chess == 'q') {
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chess);
                } else if (chess == 'K') {
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chess);
                } else if (chess == 'k') {
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chess);
                } else if (chess == 'P') {
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chess);
                } else if (chess == 'p') {
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chess);
                } else if (chess == '_') {
                    this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, chess);
                }
                this.chessComponents[i][j].setCnt(true);
                this.chessComponents[i][j].setChessboard(this.chessComponents);
            }
        }

        if(chessboard.get(8).equals("w")){
            this.currentPlayer=ChessColor.WHITE;
        }else if(chessboard.get(8).equals("b")){
            this.currentPlayer=ChessColor.BLACK;
        }else{
            this.currentPlayer=ChessColor.NONE;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder s = new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                s.append(this.chessComponents[i][j]);
            }
            if(i!=7){
                s.append("\n");
            }
        }
        return s.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String s= "";
        int[] a = new int[6];
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    String toString = this.chessComponents[i][j].toString();
                    if ("K".equals(toString)) {
                        a[0]++;
                    } else if ("Q".equals(toString)) {
                        a[1]++;
                    } else if ("R".equals(toString)) {
                        a[2]++;
                    } else if ("B".equals(toString)) {
                        a[3]++;
                    } else if ("N".equals(toString)) {
                        a[4]++;
                    } else if ("P".equals(toString)) {
                        a[5]++;
                    }
                }
            }
            if (a[0] != 1) s += "K " + String.valueOf(1 - a[0]) + "\n";
            if (a[1] != 1) s += "Q " + String.valueOf(1 - a[1]) + "\n";
            if (a[2] != 2) s += "R " + String.valueOf(2 - a[2]) + "\n";
            if (a[3] != 2) s += "B " + String.valueOf(2 - a[3]) + "\n";
            if (a[4] != 2) s += "N " + String.valueOf(2 - a[4]) + "\n";
            if (a[5] != 8) s += "P " + String.valueOf(8 - a[5]) + "\n";
        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    String toString = this.chessComponents[i][j].toString();
                    if ("k".equals(toString)) {
                        a[0]++;
                    } else if ("q".equals(toString)) {
                        a[1]++;
                    } else if ("r".equals(toString)) {
                        a[2]++;
                    } else if ("b".equals(toString)) {
                        a[3]++;
                    } else if ("n".equals(toString)) {
                        a[4]++;
                    } else if ("p".equals(toString)) {
                        a[5]++;
                    }
                }
            }
            if (a[0] != 1) s += "k " + String.valueOf(1 - a[0]) + "\n";
            if (a[1] != 1) s += "q " + String.valueOf(1 - a[1]) + "\n";
            if (a[2] != 2) s += "r " + String.valueOf(2 - a[2]) + "\n";
            if (a[3] != 2) s += "b " + String.valueOf(2 - a[3]) + "\n";
            if (a[4] != 2) s += "n " + String.valueOf(2 - a[4]) + "\n";
            if (a[5] != 8) s += "p " + String.valueOf(8 - a[5]) + "\n";
        }
        return s;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        for (int i = 0; i < canMovePoints.size()-1; i++) {
            for (int j = 0; j < canMovePoints.size()-1-i; j++) {
                int x1 = canMovePoints.get(j).getX();
                int y1 = canMovePoints.get(j).getY();
                int x2 = canMovePoints.get(j+1).getX();
                int y2 = canMovePoints.get(j+1).getY();
                if ((x1>x2) || (x1==x2 && y1>y2)) {
                    Collections.swap(canMovePoints,j,j+1);
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(sourceX<0 ||sourceX>7 || sourceY<0 ||sourceY>7 || targetX<0 || targetX>7 || targetY<0 || targetY>7){
            return false;
        }else{
            ChessComponent sourceChess = this.getChess(sourceX, sourceY);
            ChessComponent targetChess = this.getChess(targetX, targetY);
            if(sourceChess.getChessColor()!=this.currentPlayer){
                return false;
            }else{
                for(int i=0;i<this.getCanMovePoints(sourceChess.getSource()).size();i++){
                    ChessboardPoint tempChess = this.getCanMovePoints(sourceChess.getSource()).get(i);
                    if((tempChess.getX() == targetChess.getSource().getX()) && (tempChess.getY() == targetChess.getSource().getY())){
                        if (sourceChess.toString().equals("R") || sourceChess.toString().equals("r")) {
                            this.chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX,targetY), sourceChess.getChessColor(), sourceChess.toString().charAt(0));
                        }else if (sourceChess.toString().equals("N") || sourceChess.toString().equals("n")) {
                            this.chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX,targetY), sourceChess.getChessColor(), sourceChess.toString().charAt(0));
                        }else if (sourceChess.toString().equals("B") || sourceChess.toString().equals("b")) {
                            this.chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX,targetY), sourceChess.getChessColor(), sourceChess.toString().charAt(0));
                        }else if (sourceChess.toString().equals("Q") || sourceChess.toString().equals("q")) {
                            this.chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX,targetY), sourceChess.getChessColor(), sourceChess.toString().charAt(0));
                        } else if (sourceChess.toString().equals("K") || sourceChess.toString().equals("k")) {
                            this.chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX,targetY), sourceChess.getChessColor(), sourceChess.toString().charAt(0));
                        }else if (sourceChess.toString().equals("P") || sourceChess.toString().equals("p")) {
                            this.chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX,targetY), sourceChess.getChessColor(), sourceChess.toString().charAt(0));
                            this.chessComponents[targetX][targetY].setCnt(false);
                            this.chessComponents[sourceX][sourceY].setCnt(true);
                        }else if (sourceChess.toString().equals("_")) {
                            this.chessComponents[targetX][targetY] = new EmptySlotComponent(new ChessboardPoint(targetX,targetY), sourceChess.getChessColor(), sourceChess.toString().charAt(0));
                        }
                        this.chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY), ChessColor.NONE, '_');
                        if(this.currentPlayer==ChessColor.BLACK){
                            this.currentPlayer = ChessColor.WHITE;
                        }else{
                            this.currentPlayer = ChessColor.BLACK;
                        }
                        for(int j=0;j<8;j++){
                            for(int k=0;k<8;k++){
                                this.chessComponents[j][k].setChessboard(this.chessComponents);
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
        }
    }
}