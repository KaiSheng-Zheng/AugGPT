import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private static ChessColor currentPlayer;

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int a = chessboard.get(i).charAt(j);
                ChessboardPoint source = new ChessboardPoint(i, j);
                if (a == 'Q' || a == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(source, ChessColor.NONE, 'Q');
                } else if (a == 'P' || a == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(source, ChessColor.NONE, 'P');
                } else if (a == 'N' || a == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(source, ChessColor.NONE, 'N');
                } else if (a == 'B' || a == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(source, ChessColor.NONE, 'b');
                } else if (a == 'K' || a == 'k') {
                    chessComponents[i][j] = new KingChessComponent(source, ChessColor.NONE, 'k');
                } else if (a == 'R' || a == 'r') {
                    chessComponents[i][j] = new RookChessComponent(source, ChessColor.NONE, 'r');
                } else {
                    chessComponents[i][j] = new EmptySlotComponent(source, ChessColor.NONE, '_');
                }
                if (a >= 65 && a <= 90) {
                    chessComponents[i][j].name = (chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                } else if (a <= 122 && a >= 97) {
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                } else {
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "w")) {
            setCurrentPlayer(ChessColor.WHITE);
        } else {
            setCurrentPlayer(ChessColor.BLACK);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].chessComponents = chessComponents;
            }
        }
    }


    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                str.append(chessComponents[i][j].name);
            }
            str.append("\n");
        }
        String substring = str.substring(0, str.length() - 2);
        return String.valueOf(substring);
    }

    public String getCapturedChess(ChessColor player) {
        int r, n, b, q, k, p;
        r = n = b = q = k = p = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() == player) {
                    if ('r' == chessComponents[i][j].name || 'R' == chessComponents[i][j].name) {
                        r++;
                    }
                    if ('n' == chessComponents[i][j].name || 'N' == chessComponents[i][j].name) {
                        n++;
                    }
                    if ('b' == chessComponents[i][j].name || 'B' == chessComponents[i][j].name) {
                        b++;
                    }
                    if ('q' == chessComponents[i][j].name || 'Q' == chessComponents[i][j].name) {
                        q++;
                    }
                    if ('k' == chessComponents[i][j].name || 'K' == chessComponents[i][j].name) {
                        k++;
                    }
                    if ('p' == chessComponents[i][j].name || 'P' == chessComponents[i][j].name) {
                        p++;
                    }
                }
            }
        }
        r = 2 - r;
        n = 2 - n;
        b = 2 - b;
        q = 1 - q;
        k = 1 - k;
        p = 8 - p;
        StringBuilder capturedChess = new StringBuilder();
        if (player == ChessColor.BLACK) {
            if (k != 0) {
                capturedChess.append("K ");
                capturedChess.append(k);
                capturedChess.append("\n");
            }
            if (q != 0) {
                capturedChess.append("Q ");
                capturedChess.append(q);
                capturedChess.append("\n");
            }
            if (r != 0) {
                capturedChess.append("R ");
                capturedChess.append(r);
                capturedChess.append("\n");
            }
            if (b != 0) {
                capturedChess.append("B ");
                capturedChess.append(b);
                capturedChess.append("\n");
            }
            if (n != 0) {
                capturedChess.append("N ");
                capturedChess.append(n);
                capturedChess.append("\n");
            }
            if (p != 0) {
                capturedChess.append("P ");
                capturedChess.append(p);
                capturedChess.append("\n");
            }
        }
        if (player == ChessColor.WHITE) {
            if (k != 0) {
                capturedChess.append("k ");
                capturedChess.append(k);
                capturedChess.append("\n");
            }
            if (q != 0) {
                capturedChess.append("q ");
                capturedChess.append(q);
                capturedChess.append("\n");
            }
            if (r != 0) {
                capturedChess.append("r ");
                capturedChess.append(r);
                capturedChess.append("\n");
            }
            if (b != 0) {
                capturedChess.append("b ");
                capturedChess.append(b);
                capturedChess.append("\n");
            }
            if (n != 0) {
                capturedChess.append("n ");
                capturedChess.append(n);
                capturedChess.append("\n");
            }
            if (p != 0) {
                capturedChess.append("p ");
                capturedChess.append(p);
                capturedChess.append("\n");
            }
        }
        return String.valueOf(capturedChess);
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int i = source.getX();
        int j = source.getY();

        
        return chessComponents[i][j].canMoveTo();
    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(!chessComponents[sourceX][sourceY].getChessColor().equals(getCurrentPlayer())){
            return false;
        }
        if((sourceX<8&&sourceX>=0&&sourceY<8&&sourceY>=0&&targetX>=0&&targetX<8&&targetY>=0&&targetY<8)){
            return false;
        }
        List<ChessboardPoint> canMove = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
        int num = canMove.size();
        boolean moveChess = false;
        if (num != 0) {
            for (int i = 0; i < num; i++) {
                if (canMove.get(i).getX() == targetX && canMove.get(i).getY() == targetY) {
                    moveChess = true;
                    break;
                }
            }
        }

        if (moveChess) {
               

            ChessComponent chess1 = chessComponents[sourceX][sourceY];
           
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            
            chessComponents[targetX][targetY] = chess1;
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    int a = chessComponents[i][j].toString().charAt(0);
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    if (a == 'Q' || a == 'q') {
                        chessComponents[i][j] = new QueenChessComponent(source, ChessColor.NONE, 'Q');
                    } else if (a == 'P' || a == 'p') {
                        chessComponents[i][j] = new PawnChessComponent(source, ChessColor.NONE, 'P');
                    } else if (a == 'N' || a == 'n') {
                        chessComponents[i][j] = new KnightChessComponent(source, ChessColor.NONE, 'N');
                    } else if (a == 'B' || a == 'b') {
                        chessComponents[i][j] = new BishopChessComponent(source, ChessColor.NONE, 'b');
                    } else if (a == 'K' || a == 'k') {
                        chessComponents[i][j] = new KingChessComponent(source, ChessColor.NONE, 'k');
                    } else if (a == 'R' || a == 'r') {
                        chessComponents[i][j] = new RookChessComponent(source, ChessColor.NONE, 'r');
                    } else {
                        chessComponents[i][j] = new EmptySlotComponent(source, ChessColor.NONE, '_');
                    }
                    if (a >= 65 && a <= 90) {
                        chessComponents[i][j].name = chessComponents[i][j].toString().charAt(0);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    } else if (a <= 122 && a >= 97) {
                        chessComponents[i][j].name = chessComponents[i][j].toString().charAt(0);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    } else {
                        chessComponents[i][j].name = chessComponents[i][j].toString().charAt(0);
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                    }
                }
            }
            if (this.currentPlayer.equals(ChessColor.BLACK)) {
                this.currentPlayer = ChessColor.WHITE;
            } else {
                this.currentPlayer = ChessColor.BLACK;
            }
            return true;
        }
        return false;
    }

}


