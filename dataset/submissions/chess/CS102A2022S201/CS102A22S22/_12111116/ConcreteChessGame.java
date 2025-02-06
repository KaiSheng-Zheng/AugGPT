import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++) {
                if (chessboard.get(i).charAt(j)=='_'){
                    this.chessComponents[i][j]=new EmptySlotComponent(i,j);
                    this.chessComponents[i][j].setChessboard(this.chessComponents, ChessColor.NONE,'_');
                }
                if (chessboard.get(i).charAt(j)=='k'){
                    this.chessComponents[i][j]=new KingChessComponent(i,j,ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents, ChessColor.WHITE, 'k');
                }
                if (chessboard.get(i).charAt(j)=='K'){
                    this.chessComponents[i][j]=new KingChessComponent(i,j,ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents, ChessColor.BLACK, 'K');
                }
                if (chessboard.get(i).charAt(j)=='q'){
                    this.chessComponents[i][j]=new QueenChessComponent(i,j,ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents, ChessColor.WHITE, 'q');
                }
                if (chessboard.get(i).charAt(j)=='Q'){
                    this.chessComponents[i][j]=new QueenChessComponent(i,j,ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents, ChessColor.BLACK, 'Q');
                }
                if (chessboard.get(i).charAt(j)=='r'){
                    this.chessComponents[i][j]=new RookChessComponent(i,j,ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents, ChessColor.WHITE, 'r');
                }
                if (chessboard.get(i).charAt(j)=='R'){
                    this.chessComponents[i][j]=new RookChessComponent(i,j,ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents, ChessColor.BLACK, 'R');
                }
                if (chessboard.get(i).charAt(j)=='b'){
                    this.chessComponents[i][j]=new BishopChessComponent(i,j,ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents, ChessColor.WHITE, 'b');
                }
                if (chessboard.get(i).charAt(j)=='B'){
                    this.chessComponents[i][j]=new BishopChessComponent(i,j,ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents, ChessColor.BLACK, 'B');
                }
                if (chessboard.get(i).charAt(j)=='n'){
                    this.chessComponents[i][j]=new KnightChessComponent(i,j,ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents, ChessColor.WHITE, 'n');
                }
                if (chessboard.get(i).charAt(j)=='N'){
                    this.chessComponents[i][j]=new KnightChessComponent(i,j,ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents, ChessColor.BLACK, 'N');
                }
                if (chessboard.get(i).charAt(j)=='p'){
                    this.chessComponents[i][j]=new PawnChessComponent(i,j,ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents, ChessColor.WHITE, 'p');
                }
                if (chessboard.get(i).charAt(j)=='P'){
                    this.chessComponents[i][j]=new PawnChessComponent(i,j,ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents,ChessColor.BLACK, 'P');
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='w'){
            this.currentPlayer = ChessColor.WHITE;
        }else {
            this.currentPlayer = ChessColor.BLACK;
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
        StringBuilder a = new StringBuilder();
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                a.append(component.toString());
            }
            a.append("\n");
        }
        return a.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder str = new StringBuilder();
        if (player.toString().equals(ChessColor.WHITE.toString())) {
            int[] a = new int[6];
            String[] b = new String[6];
            b[0] = "k";
            b[1] = "q";
            b[2] = "r";
            b[3] = "b";
            b[4] = "n";
            b[5] = "p";
            a[0] = getChessNumber('k', 1);
            a[1] = getChessNumber('q', 1);
            a[2] = getChessNumber('r', 2);
            a[3] = getChessNumber('b', 2);
            a[4] = getChessNumber('n', 2);
            a[5] = getChessNumber('p', 8);
            for (int i = 0; i < 6; i++) {
                if (a[i] != 0) {
                    str.append(b[i]).append(" ").append(a[i]).append("\n");
                }
            }

        } else {
            int[] a = new int[6];
            String[] b = new String[6];
            b[0] = "K";
            b[1] = "Q";
            b[2] = "R";
            b[3] = "B";
            b[4] = "N";
            b[5] = "P";
            a[0] = getChessNumber('K', 1);
            a[1] = getChessNumber('Q', 1);
            a[2] = getChessNumber('R', 2);
            a[3] = getChessNumber('B', 2);
            a[4] = getChessNumber('N', 2);
            a[5] = getChessNumber('P', 8);
            for (int i = 0; i < 6; i++) {
                if (a[i] != 0) {
                    str.append(b[i]).append(" ").append(a[i]).append("\n");
                }
            }

        }
        return str.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX>=0 && sourceX<8 && sourceY>=0 && sourceY<8 && targetX>=0 && targetX<8 && targetY>=0 && targetY<8){
            int c=0;
            int f=0;
            ChessComponent a = getChess(sourceX,sourceY);
            ChessComponent b = getChess(targetX,targetY);
            ChessboardPoint d=new ChessboardPoint(sourceX,sourceY);
            ChessboardPoint e=new ChessboardPoint(targetX,targetY);
            if (a.getChessColor()!=this.currentPlayer)  c=1;
            if (a.getChessColor()==b.getChessColor())   c=1;
            for (ChessboardPoint tempPoint : getCanMovePoints(d)){
                if (e.getX() == tempPoint.getX() && e.getY() == tempPoint.getY()) {
                    f = 1;
                    break;
                }
            }
            if (f==0) {
                c=1;
            }
            if (c==1) {
                return false;
            }
            else {
                if (a.getName()=='p'||a.getName()=='P') {
                    ((PawnChessComponent) a).moveTimes++;
                }
                a.getSource().setX(targetX);
                a.getSource().setY(targetY);
                a.x = targetX;
                a.y = targetY;
                chessComponents[targetX][targetY] = a;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX,sourceY);
                chessComponents[sourceX][sourceY].setChessboard(this.chessComponents, ChessColor.NONE,'_');
                this.currentPlayer = (currentPlayer==ChessColor.WHITE) ? ChessColor.BLACK : ChessColor.WHITE;
                return true;}
        }
        else {return false;}
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess =this.getChess(source.getX(),source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order 1.Comparable 2.Comparator
        return comparable(canMovePoints);
    }

    public int getChessNumber(char a, int c) {
        int b = 0;
        int d;
        for (int i = 0; i < getChessboardGraph().length(); i++) {
            if (a==getChessboardGraph().charAt(i)) {
                b++;
            }
        }
        d = c - b;
        return d;
    }
    public List<ChessboardPoint> comparable(List<ChessboardPoint> canMovePoints){
        List<ChessboardPoint> canMovePoint = new ArrayList<>();
        List<Integer> a;
        if (canMovePoints!=null){
            while (canMovePoints.size()!=0){
                a= new ArrayList<>();
                for (ChessboardPoint movePoint : canMovePoints) {
                    if (movePoint != null) {
                        int xa = movePoint.getX();
                        int ya = movePoint.getY();
                        a.add(xa * 8 + ya);
                    }
                }
                int position1 = a.indexOf(Collections.min(a));
                canMovePoint.add(canMovePoints.get(position1));
                canMovePoints.remove(position1);}}
        return canMovePoint;
    }
    public boolean equals1(ChessboardPoint d,ChessboardPoint e){
        int xd=d.getX();
        int yd=d.getY();
        int ex=e.getX();
        int ey=e.getY();
        if (xd==ex&&yd==ey){return true;}
        else {return false;}
    }
}
