import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
//    KingChessComponent king;QueenChessComponent queen; RookChessComponent rooks;
//    BishopChessComponent bishops; KnightChessComponent knight; PawnChessComponent pawns;
//    EmptySlotComponent emptySlotComponent;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public void loadChessGame(List<String> chessboard) {
//        ChessComponent k = king; ChessComponent q = queen;ChessComponent r = rooks; ChessComponent b = bishops;
//        ChessComponent n = knight;ChessComponent p = pawns;ChessComponent _ = emptySlotComponent;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessComponent k = new KingChessComponent();
                ChessComponent q = new QueenChessComponent();
                ChessComponent r = new RookChessComponent();
                ChessComponent b = new BishopChessComponent();
                ChessComponent n = new KnightChessComponent();
                ChessComponent p = new PawnChessComponent();
                ChessComponent e = new EmptySlotComponent();
                ChessboardPoint cp = new ChessboardPoint(i,j);
                if(chessboard.get(i).charAt(j)=='k') {
                    chessComponents[i][j]=k;
                    k.setSource(cp);
                    k.setChessColor(ChessColor.WHITE);
                    k.setName('k');
                }
                else if(chessboard.get(i).charAt(j)=='K') {
                    chessComponents[i][j]=k;
                    k.setSource(cp);
                    k.setChessColor(ChessColor.BLACK);
                    k.setName('K');
                }
                else if(chessboard.get(i).charAt(j)=='q') {
                    chessComponents[i][j]=q;
                    q.setSource(cp);
                    q.setChessColor(ChessColor.WHITE);
                    q.setName('q');
                }
                else if(chessboard.get(i).charAt(j)=='Q') {
                    chessComponents[i][j]=q;
                    q.setSource(cp);
                    q.setChessColor(ChessColor.BLACK);
                    q.setName('Q');
                }
                else if(chessboard.get(i).charAt(j)=='r') {
                    chessComponents[i][j]=r;
                    r.setSource(cp);
                    r.setChessColor(ChessColor.WHITE);
                    r.setName('r');
                }
                else if(chessboard.get(i).charAt(j)=='R') {
                    chessComponents[i][j]=r;
                    r.setSource(cp);
                    r.setChessColor(ChessColor.BLACK);
                    r.setName('R');
                }
                else if(chessboard.get(i).charAt(j)=='b') {
                    chessComponents[i][j]=b;
                    b.setSource(cp);
                    b.setChessColor(ChessColor.WHITE);
                    b.setName('b');
                }
                else if(chessboard.get(i).charAt(j)=='B') {
                    chessComponents[i][j]=b;
                    b.setSource(cp);
                    b.setChessColor(ChessColor.BLACK);
                    b.setName('B');
                }
                else if(chessboard.get(i).charAt(j)=='n') {
                    chessComponents[i][j]=n;
                    n.setChessColor(ChessColor.WHITE);
                    n.setSource(cp);
                    n.setName('n');
                }
                else if(chessboard.get(i).charAt(j)=='N') {
                    chessComponents[i][j]=n;
                    n.setChessColor(ChessColor.BLACK);
                    n.setSource(cp);
                    n.setName('N');
                }
                else if(chessboard.get(i).charAt(j)=='p') {
                    chessComponents[i][j]=p;
                    p.setChessColor(ChessColor.WHITE);
                    p.setSource(cp);
                    p.setName('p');
                }
                else if(chessboard.get(i).charAt(j)=='P') {
                    chessComponents[i][j]=p;
                    p.setChessColor(ChessColor.BLACK);
                    p.setSource(cp);
                    p.setName('P');
                }
                else if(chessboard.get(i).charAt(j)=='_') {
                    chessComponents[i][j]=e;
                    e.setChessColor(ChessColor.NONE);
                    e.setSource(cp);
                    e.setName('_');
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='w')  currentPlayer=ChessColor.WHITE;
        else if (chessboard.get(8).charAt(0)=='b')  currentPlayer=ChessColor.BLACK;

//        chessboard.add("RNBQKBNR");chessboard.add("PPPPPPPP");chessboard.add("________");
//        chessboard.add("________");chessboard.add("________");chessboard.add("________");
//        chessboard.add( "pppppppp");chessboard.add("rnbqkbnr");chessboard.add("w");
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }


    public String getChessboardGraph(){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<9;j++){
                if (j<8)  sb.append(chessComponents[i][j].getName());
                if (j==8)  sb.append("\n");
//                System.out.println(chessComponents[i][j].getName());
            }
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int k=1;int q=1;int r=2;int b=2;int n=2;int p=8;
        int ck=0;int cq=0; int cr=0;int cb=0;int cn=0;int cp=0;
        int cK=0;int cQ=0; int cR=0;int cB=0;int cN=0;int cP=0;

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessComponents[i][j].getName()=='k')  ck++;
                if (chessComponents[i][j].getName()=='K')  cK++;
                if (chessComponents[i][j].getName()=='q')  cq++;
                if (chessComponents[i][j].getName()=='Q')  cQ++;
                if (chessComponents[i][j].getName()=='r')  cr++;
                if (chessComponents[i][j].getName()=='R')  cR++;
                if (chessComponents[i][j].getName()=='b')  cb++;
                if (chessComponents[i][j].getName()=='B')  cB++;
                if (chessComponents[i][j].getName()=='n')  cn++;
                if (chessComponents[i][j].getName()=='N')  cN++;
                if (chessComponents[i][j].getName()=='p')  cp++;
                if (chessComponents[i][j].getName()=='P')  cP++;

            }
        }
        if (player == ChessColor.BLACK){
            if (k-cK!=0)  {sb.append("K ");sb.append(k-cK);sb.append("\n");}
            if (q-cQ!=0)  {sb.append("Q ");sb.append(q-cQ);sb.append("\n");}
            if (r-cR!=0)  {sb.append("R ");sb.append(r-cR);sb.append("\n");}
            if (b-cB!=0)  {sb.append("B ");sb.append(b-cB);sb.append("\n");}
            if (n-cN!=0)  {sb.append("N ");sb.append(n-cN);sb.append("\n");}
            if (p-cP!=0)  {sb.append("P ");sb.append(p-cP);sb.append("\n");}

        }
        else if (player == ChessColor.WHITE){
            if (k-ck!=0)  {sb.append("k ");sb.append(k-ck);sb.append("\n");}
            if (q-cq!=0)  {sb.append("q ");sb.append(q-cq);sb.append("\n");}
            if (r-cr!=0)  {sb.append("r ");sb.append(r-cr);sb.append("\n");}
            if (b-cb!=0)  {sb.append("b ");sb.append(b-cb);sb.append("\n");}
            if (n-cn!=0)  {sb.append("n ");sb.append(n-cn);sb.append("\n");}
            if (p-cp!=0)  {sb.append("p ");sb.append(p-cp);sb.append("\n");}
        }

        return sb.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        chessComponents[sourceX][sourceY].setChessComponents(this.chessComponents);
        boolean contains = true;
        if (chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
            if (currentPlayer == ChessColor.BLACK){
                if (chessComponents[sourceX][sourceY].getName()=='K'){
                    if (chessComponents[sourceX][sourceY].canMoveTo().contains(target)){
                        setCurrentPlayer(ChessColor.WHITE);
                        chessComponents[targetX][targetY] = new KnightChessComponent();
                        chessComponents[targetX][targetY].setName('K');
                        chessComponents[targetX][targetY].setSource(target);
                        chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[sourceX][sourceY].setSource(source);
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        return true;
                    }
                    else return false;
                }
                if (chessComponents[sourceX][sourceY].getName()=='Q'){
                    if (chessComponents[sourceX][sourceY].canMoveTo().contains(target)){
                        setCurrentPlayer(ChessColor.WHITE);
                        chessComponents[targetX][targetY] = new QueenChessComponent();
                        chessComponents[targetX][targetY].setName('Q');
                        chessComponents[targetX][targetY].setSource(target);
                        chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[sourceX][sourceY].setSource(source);
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        return true;
                    }
                    else return false;

                }
                if (chessComponents[sourceX][sourceY].getName()=='R'){
                    if (chessComponents[sourceX][sourceY].canMoveTo().contains(target)){
                        setCurrentPlayer(ChessColor.WHITE);
                        chessComponents[targetX][targetY] = new RookChessComponent();
                        chessComponents[targetX][targetY].setName('R');
                        chessComponents[targetX][targetY].setSource(target);
                        chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[sourceX][sourceY].setSource(source);
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        return true;
                    }
                    else return false;
                }
                if (chessComponents[sourceX][sourceY].getName()=='B'){
                    if (chessComponents[sourceX][sourceY].canMoveTo().contains(target)){
                        setCurrentPlayer(ChessColor.WHITE);
                        chessComponents[targetX][targetY] = new BishopChessComponent();
                        chessComponents[targetX][targetY].setName('B');
                        chessComponents[targetX][targetY].setSource(target);
                        chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[sourceX][sourceY].setSource(source);
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        return true;
                    }
                    else return false;
                }
                if (chessComponents[sourceX][sourceY].getName()=='N'){
                    if (chessComponents[sourceX][sourceY].canMoveTo().contains(target)){
                        setCurrentPlayer(ChessColor.WHITE);
                        chessComponents[targetX][targetY] = new KnightChessComponent();
                        chessComponents[targetX][targetY].setName('N');
                        chessComponents[targetX][targetY].setSource(target);
                        chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[sourceX][sourceY].setSource(source);
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        return true;
                    }
                    else return false;
                }
                if (chessComponents[sourceX][sourceY].getName()=='P'){
                    if (chessComponents[sourceX][sourceY].canMoveTo().contains(target)){
                        setCurrentPlayer(ChessColor.WHITE);
                        chessComponents[targetX][targetY] = new PawnChessComponent();
                        chessComponents[targetX][targetY].setName('P');
                        chessComponents[targetX][targetY].setSource(target);
                        chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[sourceX][sourceY].setSource(source);
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        return true;
                    }
                    else return false;
                }
            }
            else if (currentPlayer == ChessColor.WHITE){
                if (chessComponents[sourceX][sourceY].getName()=='k'){
                    if (chessComponents[sourceX][sourceY].canMoveTo().contains(target)){
                        setCurrentPlayer(ChessColor.BLACK);
                        chessComponents[targetX][targetY] = new KingChessComponent();
                        chessComponents[targetX][targetY].setName('k');
                        chessComponents[targetX][targetY].setSource(target);
                        chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[sourceX][sourceY].setSource(source);
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        return true;
                    }
                    else return false;
                }
                if (chessComponents[sourceX][sourceY].getName()=='q'){
                    if (chessComponents[sourceX][sourceY].canMoveTo().contains(target)){
                        setCurrentPlayer(ChessColor.BLACK);
                        chessComponents[targetX][targetY] = new QueenChessComponent();
                        chessComponents[targetX][targetY].setName('q');
                        chessComponents[targetX][targetY].setSource(target);
                        chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[sourceX][sourceY].setSource(source);
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        return true;
                    }
                    else return false;
                }
                if (chessComponents[sourceX][sourceY].getName()=='r'){
                    if (chessComponents[sourceX][sourceY].canMoveTo().contains(target)){
                        setCurrentPlayer(ChessColor.BLACK);
                        chessComponents[targetX][targetY] = new RookChessComponent();
                        chessComponents[targetX][targetY].setName('r');
                        chessComponents[targetX][targetY].setSource(target);
                        chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[sourceX][sourceY].setSource(source);
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        return true;
                    }
                    else return false;
                }
                if (chessComponents[sourceX][sourceY].getName()=='b'){
                    if (chessComponents[sourceX][sourceY].canMoveTo().contains(target)){
                        setCurrentPlayer(ChessColor.BLACK);
                        chessComponents[targetX][targetY] = new BishopChessComponent();
                        chessComponents[targetX][targetY].setName('b');
                        chessComponents[targetX][targetY].setSource(target);
                        chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[sourceX][sourceY].setSource(source);
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        return true;
                    }
                    else return false;

                }
                if (chessComponents[sourceX][sourceY].getName()=='n'){
                    if (chessComponents[sourceX][sourceY].canMoveTo().contains(target)){
                        setCurrentPlayer(ChessColor.BLACK);
                        chessComponents[targetX][targetY] = new KnightChessComponent();
                        chessComponents[targetX][targetY].setName('n');
                        chessComponents[targetX][targetY].setSource(target);
                        chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[sourceX][sourceY].setSource(source);
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        return true;
                    }
                    else return false;
                }
                if (chessComponents[sourceX][sourceY].getName()=='p'){
                    if (chessComponents[sourceX][sourceY].canMoveTo().contains(target)){
                        setCurrentPlayer(ChessColor.BLACK);
                        chessComponents[targetX][targetY] = new PawnChessComponent();
                        chessComponents[targetX][targetY].setName('p');
                        chessComponents[targetX][targetY].setSource(target);
                        chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[sourceX][sourceY].setSource(source);
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        return true;
                    }
                    else return false;
                }
                else return false;
            }
        }
        else return false;

        return true;
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        chessComponents[source.getX()][source.getY()].setChessComponents(this.chessComponents);
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        // 3.sort canMovePoints by x - y ascending order
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
//                for (int k=0;k<chess.canMoveTo().size();k++){
//                    System.out.println(chess.canMoveTo().get(k));
//                }
                if (chess.canMoveTo().contains(new ChessboardPoint(i,j))){
                    canMovePoints.add(new ChessboardPoint(i,j));
                }
            }
        }
        if (canMovePoints.size()>0)   return canMovePoints;
        else return new ArrayList<>();

    }
}
