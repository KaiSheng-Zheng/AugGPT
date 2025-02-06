import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public  class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    
    private List<String> chesslist;

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {}

    public void loadChessGame(List<String> chessboard) {
        this.chesslist=chessboard;
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
        }else {setCurrentPlayer(ChessColor.NONE);}
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (chessboard.get(i).charAt(j)=='R'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                            chessComponents[i][j]=new RookChessComponent(chessboardPoint,ChessColor.BLACK,'R',chessboard);
                        }
                        else if (chessboard.get(i).charAt(j)=='N'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                            chessComponents[i][j]=new KnightChessComponent(chessboardPoint,ChessColor.BLACK,'N',chessboard);}
                        else if (chessboard.get(i).charAt(j)=='K'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                            chessComponents[i][j]=new KingChessComponent(chessboardPoint,ChessColor.BLACK,'K',chessboard);}
                        else if (chessboard.get(i).charAt(j)=='Q'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                            chessComponents[i][j]=new QueenChessComponent(chessboardPoint,ChessColor.BLACK,'Q',chessboard);}
                        else if (chessboard.get(i).charAt(j)=='B'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                            chessComponents[i][j]=new BishopChessComponent(chessboardPoint,ChessColor.BLACK,'B',chessboard);}
                        else if (chessboard.get(i).charAt(j)=='P'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                            chessComponents[i][j]=new PawnChessComponent(chessboardPoint,ChessColor.BLACK,'P',chessboard);}
                        else if (chessboard.get(i).charAt(j)=='r'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                            chessComponents[i][j]=new RookChessComponent(chessboardPoint,ChessColor.WHITE,'r',chessboard);}
                        else if (chessboard.get(i).charAt(j)=='n'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                            chessComponents[i][j]=new KnightChessComponent(chessboardPoint,ChessColor.WHITE,'n',chessboard);}
                        else if (chessboard.get(i).charAt(j)=='k'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                            chessComponents[i][j]=new KingChessComponent(chessboardPoint,ChessColor.WHITE,'k',chessboard);}
                        else if (chessboard.get(i).charAt(j)=='q'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                            chessComponents[i][j]=new QueenChessComponent(chessboardPoint,ChessColor.WHITE,'q',chessboard);}
                        else if (chessboard.get(i).charAt(j)=='b'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                            chessComponents[i][j]=new BishopChessComponent(chessboardPoint,ChessColor.WHITE,'b',chessboard);}
                        else if (chessboard.get(i).charAt(j)=='p'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                            chessComponents[i][j]=new PawnChessComponent(chessboardPoint,ChessColor.WHITE,'p',chessboard);}
                        else {ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                            chessComponents[i][j]=new EmptySlotComponent(chessboardPoint,ChessColor.NONE,'_',chessboard);}
            }
        }
                ChessComponent.chessComponents=chessComponents.clone();
       
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override

    public String getChessboardGraph() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < chesslist.size()-1; i++) {
            b.append(chesslist.get(i));
            b.append("\n");
        }
        return b.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int K = 0;
        int Q = 0;
        int R = 0;
        int B = 0;
        int N = 0;
        int P = 0;
        int k = 0;
        int q = 0;
        int r = 0;
        int b = 0;
        int n = 0;
        int p = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'K') {
                    K++;
                }
                if (chessComponents[i][j].name == 'Q') {
                    Q++;
                }
                if (chessComponents[i][j].name == 'R') {
                    R++;
                }
                if (chessComponents[i][j].name == 'B') {
                    B++;
                }
                if (chessComponents[i][j].name == 'N') {
                    N++;
                }
                if (chessComponents[i][j].name == 'P') {
                    P++;
                }
            }
        }
        String blackstate = "";
        if (player == ChessColor.BLACK) {
            int kk = 1 - K;
            int qq = 1 - Q;
            int rr = 2 - R;
            int bb = 2 - B;
            int nn = 2 - N;
            int pp = 8 - P;
            if (kk != 0) {
                blackstate = blackstate + "K 1";
            }
            if (qq != 0) {
                blackstate = blackstate + "\nQ 1";
            }
            if (rr != 0) {
                blackstate = blackstate+ "\n" + "R " + rr;
            }
            if (bb != 0) {
                blackstate = blackstate + "\n" + "B " + bb;
            }
            if (nn != 0) {
                blackstate = blackstate + "\n" + "N " + nn;
            }
            if (pp != 0) {
                blackstate = blackstate + "\n" + "P " + pp;
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'k') {
                    k++;
                }
                if (chessComponents[i][j].name == 'q') {
                    q++;
                }
                if (chessComponents[i][j].name == 'r') {
                    r++;
                }
                if (chessComponents[i][j].name == 'b') {
                    b++;
                }
                if (chessComponents[i][j].name == 'n') {
                    n++;
                }
                if (chessComponents[i][j].name == 'p') {
                    p++;
                }
            }
        }
        String whitestate = "";
        if (player == ChessColor.WHITE) {
int kkk = 1 - k;
            int qqq = 1 - q;
            int rrr = 2 - r;
            int bbb = 2 - b;
            int nnn = 2 - n;
            int ppp = 8 - p;
            if (kkk != 0) {
                whitestate = whitestate + "k 1";
            }
            if (qqq != 0) {
                whitestate = whitestate + "\nq 1";
            }
            if (rrr != 0) {
                whitestate = whitestate + "\nr " + rrr;
            }
            if (bbb != 0) {
                whitestate = whitestate + "\nb " + bbb;
            }
            if (nnn != 0) {
               whitestate = whitestate + "\nn " + nnn;
            }
            if (ppp != 0) {
                whitestate= whitestate + "\np " + ppp;
            }
        }
        if (player == ChessColor.BLACK)
            return blackstate;
        else {
            return whitestate;
        }
    }
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
    boolean move = false;

    for (int i = 0; i <= chessComponents[sourceX][sourceY].canMoveTo().size() - 1; i++) {

        if (targetX==chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()&&targetY==chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()) {
            move = true;
            break;
        }
    }
    if (this.getChess(sourceX, sourceY).getChessColor() != this.currentPlayer) {
        move = false;
    }
    if (move) {
        this.chessComponents[targetX][targetY] = this.getChess(sourceX, sourceY);
        this.chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
        this.chessComponents[sourceX][sourceY] = new EmptySlotComponent();
        if (this.currentPlayer == ChessColor.BLACK) {
            this.setCurrentPlayer(ChessColor.WHITE);
        } else {
            this.setCurrentPlayer(ChessColor.BLACK);
        }
        ChessComponent.setChessComponents(this.chessComponents);
    }
    return move;
}

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int row = source.getX();
        int col = source.getY();
        List<ChessboardPoint> canMovePoints = chessComponents[row][col].canMoveTo();
        for (int i = 0; i < canMovePoints.size()-1; i++) {
            if (canMovePoints.get(i).getX() > canMovePoints.get(i + 1).getX()) {
                ChessboardPoint tem = canMovePoints.get(i + 1);
                canMovePoints.set(i + 1, canMovePoints.get(i));
                canMovePoints.set(i, tem);
            }
            if (canMovePoints.get(i).getX() == canMovePoints.get(i + 1).getX()) {
                if (canMovePoints.get(i).getY() > canMovePoints.get(i + 1).getY()) {
                    ChessboardPoint tem = canMovePoints.get(i + 1);
                    canMovePoints.set(i + 1, canMovePoints.get(i));
                    canMovePoints.set(i, tem);
                }
            }
        }
        return canMovePoints;
    }
}