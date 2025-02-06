import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

    @Override
    public void loadChessGame(List<String> chessboard) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j)=='R'||chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent();
                    chessComponents[i][j].name=chessboard.get(i).charAt(j);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    if ((int)chessboard.get(i).charAt(j)<96){
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);}
                    else chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j)=='N'||chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].name=chessboard.get(i).charAt(j);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    if ((int)chessboard.get(i).charAt(j)<96){
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);}
                    else chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j)=='B'||chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent();
                    chessComponents[i][j].name=chessboard.get(i).charAt(j);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    if ((int)chessboard.get(i).charAt(j)<96){
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);}
                    else chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j)=='Q'||chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent();
                    chessComponents[i][j].name=chessboard.get(i).charAt(j);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    if ((int)chessboard.get(i).charAt(j)<96){
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);}
                    else chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j)=='K'||chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent();
                    chessComponents[i][j].name=chessboard.get(i).charAt(j);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    if ((int)chessboard.get(i).charAt(j)<96){
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);}
                    else chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j)=='P'||chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent();
                    chessComponents[i][j].name=chessboard.get(i).charAt(j);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    if ((int)chessboard.get(i).charAt(j)<96){
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);}
                    else chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                    chessComponents[i][j].name='_';
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                }            }
        }
        if (chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }
        if (chessboard.get(8).equals("b")){
            currentPlayer=ChessColor.BLACK;
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
        StringBuilder s=new StringBuilder();
        for (int i = 0; i < chessComponents.length; i++) {
            s.append("\n");
            for (int j = 0; j < chessComponents[i].length; j++) {
                s.append(chessComponents[i][j]);
            }
        }
        return s.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if (player.equals(ChessColor.WHITE)){
            StringBuilder str = new StringBuilder();
            int r=2;int n=2;int b=2;int q=1;int k=1;int p=8;
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    if (chessComponents[i][j].name=='r'){
                        r--;
                    }
                    if (chessComponents[i][j].name=='n'){
                        n--;
                    }
                    if (chessComponents[i][j].name=='b'){
                        b--;
                    }
                    if (chessComponents[i][j].name=='q'){
                        q--;
                    }
                    if (chessComponents[i][j].name=='k'){
                        k--;
                    }
                    if (chessComponents[i][j].name=='p'){
                        p--;
                    }
                }
            }
            if (k!=0){
               str.append("k "+k+"\n");
            }
            if (q!=0){
                str.append("q "+q+"\n");
            }
            if (r!=0){
                str.append("r "+r+"\n");
            }
            if (b!=0){
                str.append("b "+b+"\n");
            }
            if (n!=0){
                str.append("n "+n+"\n");
            }
            if (p!=0){
                str.append("p "+p+"\n");
            }
            return str.toString();
        }
        StringBuilder str=new StringBuilder();
        int K=1; int Q=1; int R=2; int B=2; int N=2; int P=8;
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                if (chessComponents[i][j].name=='R'){
                    R--;
                }
                if (chessComponents[i][j].name=='N'){
                    N--;
                }
                if (chessComponents[i][j].name=='B'){
                    B--;
                }
                if (chessComponents[i][j].name=='Q'){
                    Q--;
                }
                if (chessComponents[i][j].name=='K'){
                    K--;
                }
                if (chessComponents[i][j].name=='P'){
                    P--;
                }
            }
        }
        if (K!=0){
            str.append("K "+K+"\n");
        }
        if (Q!=0){
            str.append("Q "+Q+"\n");
        }
        if (R!=0){
            str.append("R "+R+"\n");
        }
        if (B!=0){
            str.append("B "+B+"\n");
        }
        if (N!=0){
            str.append("N "+N+"\n");
        }
        if (P!=0){
            str.append("P "+P+"\n");
        }
        return str.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessComponents(this.chessComponents);
        List<ChessboardPoint> list=new ArrayList<>();
        int[] a=new int[chessComponents[source.getX()][source.getY()].canMoveTo().size()];
        for (int i = 0; i < chessComponents[source.getX()][source.getY()].canMoveTo().size(); i++) {
            a[i]=chessComponents[source.getX()][source.getY()].canMoveTo().get(i).getValue();
        }
        Arrays.sort(a);
        for (int i = 0; i < chessComponents[source.getX()][source.getY()].canMoveTo().size(); i++) {
            list.add(new ChessboardPoint(a[i]/10,a[i]%10));
        }
        return list;

    }

     @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
          List<ChessboardPoint> l =new ArrayList<>(getCanMovePoints(new ChessboardPoint(sourceX,sourceY)));
if(l.size()==0){return false;}
      if(getChess(sourceX,sourceY).getChessColor()!=currentPlayer){return false;}
       int count =0;
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i).getX()==targetX&&l.get(i).getY()==targetY){count++;}
        }
     if(count==0){return false;}
           chessComponents[targetX][targetY]= getChess(sourceX,sourceY);
           chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
           getChess(targetX,targetY).setSource(new ChessboardPoint(targetX,targetY));
if(currentPlayer==ChessColor.WHITE){currentPlayer=ChessColor.BLACK;}else {currentPlayer = ChessColor.WHITE;}
       return true;
    }
//    public static void main(String[] args) {
//        List<String> chessBoard= Arrays.asList("RNBQKBNR","PPPPPPPP","________","________","________","________","pppppppp","rnbqkbnr","w");
//
//        ConcreteChessGame concreteChessGame=new ConcreteChessGame();
//        concreteChessGame.loadChessGame(chessBoard);
//        System.out.println(chessBoard.get(0).charAt(0));
//        System.out.println(concreteChessGame.getChessboardGraph());
//        System.out.println(concreteChessGame.getCapturedChess(ChessColor.WHITE));
//    }
}
