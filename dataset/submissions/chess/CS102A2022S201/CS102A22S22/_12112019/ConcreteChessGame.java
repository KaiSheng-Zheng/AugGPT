import java.util.List;
import java.util.Objects;

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
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer =ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point = new ChessboardPoint(i, j);
                if (chessboard.get(i).charAt(j) == 'P') {
                    this.chessComponents[i][j] = new PawnChessComponent(point, ChessColor.BLACK, 'P', chessComponents);
                    this.chessComponents[i][j].name = 'P';
                    this.chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    this.chessComponents[i][j] = new PawnChessComponent(point, ChessColor.WHITE, 'p', chessComponents);
                    this.chessComponents[i][j].name = 'p';
                    this.chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    this.chessComponents[i][j] = new KnightChessComponent(point, ChessColor.BLACK, 'N', chessComponents);
                    this.chessComponents[i][j].name = 'N';
                    this.chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    this.chessComponents[i][j] = new KnightChessComponent(point, ChessColor.WHITE, 'n', chessComponents);
                    this.chessComponents[i][j].name = 'n';
                    this.chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    this.chessComponents[i][j] = new BishopChessComponent(point, ChessColor.BLACK, 'B', chessComponents);
                    this.chessComponents[i][j].name = 'B';
                    this.chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    this.chessComponents[i][j] = new BishopChessComponent(point, ChessColor.WHITE, 'b', chessComponents);
                    this.chessComponents[i][j].name = 'b';
                    this.chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    this.chessComponents[i][j] = new QueenChessComponent(point, ChessColor.BLACK, 'Q', chessComponents);
                    this.chessComponents[i][j].name = 'Q';
                    this.chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    this.chessComponents[i][j] = new QueenChessComponent(point, ChessColor.WHITE, 'n', chessComponents);
                    this.chessComponents[i][j].name = 'q';
                    this.chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    this.chessComponents[i][j] = new KingChessComponent(point, ChessColor.BLACK, 'K', chessComponents);
                    this.chessComponents[i][j].name = 'K';
                    this.chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    this.chessComponents[i][j] = new KingChessComponent(point, ChessColor.WHITE, 'k', chessComponents);
                    this.chessComponents[i][j].name = 'k';
                    this.chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'R') {
                    this.chessComponents[i][j] = new RookChessComponent(point, ChessColor.BLACK, 'R', chessComponents);
                    this.chessComponents[i][j].name = 'R';
                    this.chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    this.chessComponents[i][j] = new RookChessComponent(point, ChessColor.WHITE, 'r', chessComponents);
                    this.chessComponents[i][j].name = 'r';
                    this.chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    this.chessComponents[i][j] = new EmptySlotComponent(point, ChessColor.NONE, '_', chessComponents);
                    this.chessComponents[i][j].name = '_';
                    this.chessComponents[i][j].setSource(i, j);
                }
                if ((Objects.equals(chessboard.get(8), "w"))) {
                    this.currentPlayer = ChessColor.WHITE;

                } else if (Objects.equals(chessboard.get(8), "b")) {
                    this.currentPlayer = ChessColor.BLACK;
                }
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder();
        StringBuilder s4 = new StringBuilder();
        StringBuilder s5 = new StringBuilder();
        StringBuilder s6 = new StringBuilder();
        StringBuilder s7 = new StringBuilder();
        StringBuilder s8 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s1.append(chessComponents[0][i].name);
            s2.append(chessComponents[1][i].name);
            s3.append(chessComponents[2][i].name);
            s4.append(chessComponents[3][i].name);
            s5.append(chessComponents[4][i].name);
            s6.append(chessComponents[5][i].name);
            s7.append(chessComponents[6][i].name);
            s8.append(chessComponents[7][i].name);

        }
        return s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n" + s5 + "\n" + s6 + "\n" + s7 + "\n" + s8;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int P = 0;
        int K = 0;
        int Q = 0;
        int N = 0;
        int R = 0;
        int B = 0;
        //black
        int p = 0;
        int k = 0;
        int q = 0;
        int n = 0;
        int r = 0;
        int b = 0;
        //white
        StringBuilder Bl = new StringBuilder();
        StringBuilder Wh = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'R') {
                    R = R + 1;
                } else if (chessComponents[i][j].name == 'r') {
                    r = r + 1;
                } else if (chessComponents[i][j].name == 'N') {
                    N = N + 1;
                } else if (chessComponents[i][j].name == 'n') {
                    n = n + 1;
                } else if (chessComponents[i][j].name == 'B') {
                    B++;
                } else if (chessComponents[i][j].name == 'b') {
                    b++;
                } else if (chessComponents[i][j].name == 'K') {
                    K++;
                } else if (chessComponents[i][j].name == 'k') {
                    k++;
                } else if (chessComponents[i][j].name == 'Q') {
                    Q++;
                } else if (chessComponents[i][j].name == 'q') {
                    q++;
                } else if (chessComponents[i][j].name == 'P') {
                    P++;
                } else if (chessComponents[i][j].name == 'p') {
                    p++;
                }
            }
        }
        if (k < 1) {
            Wh.append("k ").append(1).append("\n");
        }
        if (q < 1) {
            Wh.append("q ").append(1).append("\n");
        }
        if (r < 2) {
            Wh.append("r ").append(2 - r).append("\n");
        }
        if (b < 2) {
            Wh.append("b ").append(2 - b).append("\n");
        }
        if (n < 2) {
            Wh.append("n ").append(2 - n).append("\n");
        }
        if (p < 8) {
            Wh.append("p ").append(8 - p).append("\n");
        }

        if (K < 1) {
            Bl.append("K ").append(1).append("\n");
        }
        if (Q < 1) {
            Bl.append("Q ").append(1).append("\n");
        }
        if (R < 2) {
            Bl.append("R ").append(2 - R).append("\n");
        }
        if (B < 2) {
            Bl.append("B ").append(2 - B).append("\n");
        }
        if (N < 2) {
            Bl.append("N ").append(2 - N).append("\n");
        }
        if (P < 8) {
            Bl.append("P ").append(8 - P).append("\n");
        }

        if (player == ChessColor.BLACK) {
            return Bl.toString();
        } else if (player == ChessColor.WHITE) {
            return Wh.toString();
        }
        return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        List<ChessboardPoint> canMovePoints = getChess(x, y).canMoveTo();
        for (int i = 0; i < canMovePoints.size()-1; i++) {
            for (int j = 0; j < canMovePoints.size()-1-i; j++) {
                if (canMovePoints.get(j).getX() > canMovePoints.get(j + 1).getX()) {
                    ChessboardPoint original = canMovePoints.get(j);
                    canMovePoints.set(j, canMovePoints.get(j + 1));
                    canMovePoints.set(j + 1, original);
                }
                if (canMovePoints.get(j).getX() == canMovePoints.get(j + 1).getX()) {
                    for (int k = 0; k < canMovePoints.size() - 1; k++) {
                        for (int l = 0; l < canMovePoints.size() - 1 - i; l++) {
                            if (canMovePoints.get(j).getY() > canMovePoints.get(j + 1).getY()) {
                                ChessboardPoint original = canMovePoints.get(j);
                                canMovePoints.set(j, canMovePoints.get(j + 1));
                                canMovePoints.set(j + 1, original);
                            }

                        }

                    }
                }
            }}
        return canMovePoints;
    }

    public ChessComponent addchess(char name, int X, int Y) {
        ChessboardPoint targets = new ChessboardPoint(X, Y);
        if (name == 'R') {
            chessComponents[X][Y] = new RookChessComponent(targets, ChessColor.BLACK, 'R', chessComponents);
        }
        if (name == 'r') {
            chessComponents[X][Y] = new RookChessComponent(targets, ChessColor.WHITE, 'r', chessComponents);
        }
        if (name == 'Q') {
            chessComponents[X][Y] = new QueenChessComponent(targets, ChessColor.BLACK, 'Q', chessComponents);
        }
        if (name == 'q') {
            chessComponents[X][Y] = new QueenChessComponent(targets, ChessColor.WHITE, 'q', chessComponents);
        }
        if (name == 'P') {
            chessComponents[X][Y] = new PawnChessComponent(targets, ChessColor.BLACK, 'P', chessComponents);
        }
        if (name == 'p') {
            chessComponents[X][Y] = new PawnChessComponent(targets, ChessColor.WHITE, 'p', chessComponents);
        }
        if (name == 'B') {
            chessComponents[X][Y] = new BishopChessComponent(targets, ChessColor.BLACK, 'B', chessComponents);
        }
        if (name == 'b') {
            chessComponents[X][Y] = new BishopChessComponent(targets, ChessColor.WHITE, 'b', chessComponents);
        }
        if (name == 'K') {
            chessComponents[X][Y] = new KingChessComponent(targets, ChessColor.BLACK, 'K', chessComponents);
        }
        if (name == 'k') {
            chessComponents[X][Y] = new KingChessComponent(targets, ChessColor.WHITE, 'k', chessComponents);
        }
        if (name == 'N') {
            chessComponents[X][Y] = new KnightChessComponent(targets, ChessColor.BLACK, 'N', chessComponents);
        }
        if (name == 'n') {
            chessComponents[X][Y] = new KnightChessComponent(targets, ChessColor.WHITE, 'n', chessComponents);
        }
        return chessComponents[X][Y];
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        List<ChessboardPoint> points = getCanMovePoints(source);


        if( targetX >= 0 && targetX <= 7 && targetY >= 0 && targetY <= 7) {
            if (currentPlayer != chessComponents[sourceX][sourceY].getChessColor()){
                return false;
            }
            else {
                for (int i = 0; i < points.size(); i++) {
                    if(points.get(i).getX() == targetX && points.get(i).getY() == targetY){
                        char name = chessComponents[sourceX][sourceY].getName();
                        chessComponents[targetX][targetY] = addchess(name,targetX,targetY);
                        chessComponents[sourceX][sourceY] =new  EmptySlotComponent(source,ChessColor.NONE,'_',chessComponents);



                        if(getCurrentPlayer() == ChessColor.BLACK){
                            currentPlayer = ChessColor.WHITE;
                        }
                        else if (getCurrentPlayer() == ChessColor.WHITE){
                             currentPlayer=ChessColor.BLACK;
                        }
return true;
                    }
                }return true;
            }
        }
        return true;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

}
