import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;
    public ConcreteChessGame(){
    }

    public void loadChessGame(List<String> chessboard){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                char name = chessboard.get(i).charAt(j);
                if (name =='B'){
                    chessComponents[i][j]=new BishopChessComponent(name,new ChessboardPoint(i,j),chessComponents);
                }else if (name=='b')
                    chessComponents[i][j]=new BishopChessComponent(name,new ChessboardPoint(i,j),chessComponents);
                else if (name=='K')
                    chessComponents[i][j]=new KingChessComponent(name, new ChessboardPoint(i, j), chessComponents);
                else if (name=='k')
                    chessComponents[i][j]=new KingChessComponent(name, new ChessboardPoint(i, j), chessComponents);
                else if (name=='_')
                    chessComponents[i][j]=new EmptySlotComponent(name,new ChessboardPoint(i,j),chessComponents);
                else if (name=='N')
                    chessComponents[i][j]=new KnightChessComponent(name,new ChessboardPoint(i,j),chessComponents);
                else if (name=='n')
                    chessComponents[i][j]=new KnightChessComponent(name,new ChessboardPoint(i,j),chessComponents);
                else if (name=='P')
                    chessComponents[i][j]=new PawnChessComponent(name,new ChessboardPoint(i,j),chessComponents);
                else if (name=='p')
                    chessComponents[i][j]=new PawnChessComponent(name,new ChessboardPoint(i,j),chessComponents);
                else if (name=='Q')
                    chessComponents[i][j]=new QueenChessComponent(name,new ChessboardPoint(i,j),chessComponents);
                else if (name=='q')
                    chessComponents[i][j]=new QueenChessComponent(name,new ChessboardPoint(i,j),chessComponents);
                else if (name=='R')
                    chessComponents[i][j]=new RookChessComponent(name,new ChessboardPoint(i,j),chessComponents);
                else if (name=='r')
                    chessComponents[i][j]=new RookChessComponent(name,new ChessboardPoint(i,j),chessComponents);
            }
        }
        if (chessboard.get(8).charAt(0)=='w')
            this.currentPlayer=ChessColor.WHITE;
        else if (chessboard.get(8).charAt(0)=='b')
            this.currentPlayer=ChessColor.BLACK;
    }
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder s=new StringBuilder();
        for (int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                s.append(chessComponents[i][j].toString());
            }
            s.append('\n');
        }
        return s.toString();
    }
    public  int countOfString(String s,String str){
        String a=str.replace(s.charAt(0),' ');
        String b=a.replaceAll(" ","");
        int c=str.length()-b.length();
        return c;
    }
    public String getCapturedChess(ChessColor player) {
        int A = countOfString("K", getChessboardGraph());
        int B = countOfString("Q", getChessboardGraph());
        int C = countOfString("R", getChessboardGraph());
        int D = countOfString("B", getChessboardGraph());
        int E = countOfString("N", getChessboardGraph());
        int F = countOfString("P", getChessboardGraph());
        int a = countOfString("k", getChessboardGraph());
        int b = countOfString("q", getChessboardGraph());
        int c = countOfString("r", getChessboardGraph());
        int d = countOfString("b", getChessboardGraph());
        int e = countOfString("n", getChessboardGraph());
        int f = countOfString("p", getChessboardGraph());
        StringBuilder s = new StringBuilder();
        if (player == ChessColor.BLACK) {
            if (A < 1) {
                int AA = 1 - A;
                s.append("K " + AA+"\n");
            }  if (B<1){
                int BB=1-B;
                s.append("Q "+BB+"\n");
            } if (C<2){
                int CC=2-C;
                s.append("R "+CC+"\n");
            }  if (D<2){
                int DD=2-D;
                s.append("B "+DD+"\n");
            } if (E<2){
                int EE=2-E;
                s.append("N "+EE+"\n");
            } if (F<8){
                int FF=8-F;
                s.append("P "+FF+"\n");
            }
        } else if (player == ChessColor.WHITE) {
            if (a < 1) {
                int aa = 1 - a;
                s.append("k " +aa+"\n");
            }  if (b<1){
                int bb=1-b;
                s.append("q "+bb+"\n");
            } if (c<2){
                int cc=2-c;
                s.append("r "+cc+"\n");
            }  if (d<2){
                int dd=2-d;
                s.append("b "+dd+"\n");
            } if (e<2){
                int ee=2-e;
                s.append("n "+ee+"\n");
            } if (f<8){
                int ff=8-f;
                s.append("p "+ff+"\n");
            }
        }
        return s.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        canMovePoints.sort((o1, o2) -> o1.getX() != o2.getX() ? o1.getX() - o2.getX() : o1.getY() - o2.getY());
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint a=new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint b=new ChessboardPoint(targetX,targetY);
        ChessComponent c=chessComponents[sourceX][sourceY];
        if (getCanMovePoints(a).contains(b)&&c.getChessColor()!=ChessColor.NONE&&currentPlayer==c.getChessColor()){
            chessComponents[targetX][targetY] = c;
            chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',a,chessComponents);
            currentPlayer = currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;
            c.moveTo(b);
            return true;
        } else {
            return false;
        }
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
}