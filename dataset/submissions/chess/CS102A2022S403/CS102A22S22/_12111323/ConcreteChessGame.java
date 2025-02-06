import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private   ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;
    private  static ChessComponent[][] c;

    public static ChessComponent[][] getC() {
        return c;
    }

    public  void setC() {
c=chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        switch (chessboard.get(8)) {
            case ("w"):
                this.currentPlayer = ChessColor.WHITE;
                break;
            case ("b"):
                this.currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case ('R'):
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                        break;
                    case('N'):
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');break;

                    case('B'):
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');break;
                    case('Q'):
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');break;
                    case('K'):
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');break;
                    case('P'):
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');break;
                    case ('r'):
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');break;
                    case('n'):
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');break;
                    case('b'):
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');break;
                    case('q'):
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');break;
                    case('k'):
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');break;
                    case('p'):
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');break;
                    default:
                        this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');break;

                }
            }


        }
setC();
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {

        return  chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String x="";
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                x=x+chessComponents[i][j].name;
            }
            if(i==7){
                break;
            }
            x=x+"\n";
        }
        return x;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String x="";

        int k=0;
        int q=0;
        int r=0;
        int b=0;
        int n=0;
        int p=0;
        int K=0;
        int Q=0;
        int R=0;
        int B=0;
        int N=0;
        int P=0;

        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].name) {
                    case ('R'):
                        R++;
                        break;
                    case ('N'):
                        N++;
                        break;

                    case ('B'):
                        B++;
                        break;
                    case ('Q'):
                        Q++;
                        break;
                    case ('K'):
                        K++;
                        break;
                    case ('P'):
                        P++;
                        break;
                    case ('r'):
                        r++;
                        break;
                    case ('n'):
                        n++;
                        break;
                    case ('b'):
                        b++;
                        break;
                    case ('q'):
                        q++;
                        break;
                    case ('k'):
                        k++;
                        break;
                    case ('p'):
                        p++;
                        break;

                }
            }
        }
        if(player==ChessColor.BLACK) {
            if (1 - K != 0) {
                x = x + "K " + String.valueOf(1 - K) + "\n";
            }
            if (1 - Q != 0) {
                x = x + "Q " + String.valueOf(1 - Q) + "\n";
            }
            if (2 - R != 0) {
                x = x + "R " + String.valueOf(2 - R) + "\n";
            }
            if (2 - B != 0) {
                x = x + "B " + String.valueOf(2 - B) + "\n";
            }
            if (2 - N != 0) {
                x = x + "N " + String.valueOf(2 - N) + "\n";
            }
            if (8 - P != 0) {
                x = x + "P " + String.valueOf(8 - P) + "\n";
            }
        }
        else {
            if (1 - k != 0) {
                x = x + "k " + String.valueOf(1 - k) + "\n";
            }
            if (1 - q != 0) {
                x = x + "q " + String.valueOf(1 - q) + "\n";
            }
            if (2 - r != 0) {
                x = x + "r " + String.valueOf(2 - r) + "\n";
            }
            if (2 - b != 0) {
                x = x + "b " + String.valueOf(2 - b) + "\n";
            }
            if (2 - n != 0) {
                x = x + "n " + String.valueOf(2 - n) + "\n";
            }
            if (8 - p != 0) {
                x = x + "p " + String.valueOf(8 - p) + "\n";
            }
        }
return x;

        }




    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (currentPlayer == chessComponents[sourceX][sourceY].getChessColor()) {
            boolean x = chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY));
            if (x) {
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                setC();
                if(currentPlayer==ChessColor.BLACK)
                {
                    currentPlayer=ChessColor.WHITE;
                }
                else
                {
                    currentPlayer=ChessColor.BLACK;
                }
            }

            return x;
        } else {
            return false;
        }

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source

        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
     for(int j=1;j<canMovePoints.size();j++){   // 3.sort canMovePoints by x - y ascending order
for(int i=0;i<canMovePoints.size()-1;i++)
{
    if(canMovePoints.get(i).getX()>canMovePoints.get(i+1).getX())
    {
        ChessboardPoint temp =canMovePoints.get(i);
        canMovePoints.remove(i);
        canMovePoints.add(i+1,temp);
    }
    if(canMovePoints.get(i).getX()==canMovePoints.get(i+1).getX()&&canMovePoints.get(i).getY()>canMovePoints.get(i+1).getY())
    {
        ChessboardPoint temp =canMovePoints.get(i);
        canMovePoints.remove(i);
        canMovePoints.add(i+1,temp);
    }
}}

        return canMovePoints;
    }

    public static void main(String[] args) {
        ConcreteChessGame x=new ConcreteChessGame();
        List<String> chessboard1=new ArrayList<>();
        chessboard1.add("R_BQK__R");
        chessboard1.add("PPPP_PPP");
        chessboard1.add("__N_P___");
        chessboard1.add("___Np___");
        chessboard1.add("_B_p____");
        chessboard1.add("___q_n__");
        chessboard1.add("ppp__ppp");
        chessboard1.add("rnb_kb_r");
        chessboard1.add("w");


        List<String> chessboard2=new ArrayList<>();
        chessboard2.add("R_BQK___");
        chessboard2.add("PPP__PP_");
        chessboard2.add("__NPP_n_");
        chessboard2.add("___Np___");
        chessboard2.add("___p____");
        chessboard2.add("__p_____");
        chessboard2.add("pp___pp_");
        chessboard2.add("rnb_kb_R");
        chessboard2.add("w");
        x.loadChessGame(chessboard2);
        x.getCanMovePoints(new ChessboardPoint(7,4));




    }


}
