import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard){
        chessComponents=new ChessComponent[8][8];
        if(chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }else{
            currentPlayer=ChessColor.BLACK;
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                switch (chessboard.get(i).charAt(j)) {
                    case 'k' : chessComponents[i][j] = new KingChessComponent(i, j, ChessColor.WHITE);break;
                    case 'K' : chessComponents[i][j] = new KingChessComponent(i, j, ChessColor.BLACK);break;
                    case 'q' : chessComponents[i][j] = new QueenChessComponent(i, j, ChessColor.WHITE);break;
                    case 'Q' : chessComponents[i][j] = new QueenChessComponent(i, j, ChessColor.BLACK);break;
                    case 'r' : chessComponents[i][j] = new RookChessComponent(i, j, ChessColor.WHITE);break;
                    case 'R' : chessComponents[i][j] = new RookChessComponent(i, j, ChessColor.BLACK);break;
                    case 'p' : chessComponents[i][j] = new PawnChessComponent(i, j, ChessColor.WHITE);break;
                    case 'P' : chessComponents[i][j] = new PawnChessComponent(i, j, ChessColor.BLACK);break;
                    case 'b' : chessComponents[i][j] = new BishopChessComponent(i, j, ChessColor.WHITE);break;
                    case 'B' : chessComponents[i][j] = new BishopChessComponent(i, j, ChessColor.BLACK);break;
                    case 'n' : chessComponents[i][j] = new KnightChessComponent(i, j, ChessColor.WHITE);break;
                    case 'N' : chessComponents[i][j] = new KnightChessComponent(i, j, ChessColor.BLACK);break;
                    case '_' : chessComponents[i][j] = new EmptySlotComponent(i,j,ChessColor.NONE);break;
                }
                chessComponents[i][j].setChessComponent(chessComponents);
            }
        }

    }
    @Override
    public ChessColor getCurrentPlayer() {

        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder ss=new StringBuilder();
        for(int i=0;i<=7;i++) {
            for (int j = 0; j <= 7; j++) {
                ss.append(chessComponents[i][j].getName());
            }
            ss.append("\n");
        }
        return String.valueOf(ss);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder s= new StringBuilder();
        StringBuilder sk= new StringBuilder();
        StringBuilder sq= new StringBuilder();
        StringBuilder sr= new StringBuilder();
        StringBuilder sb= new StringBuilder();
        StringBuilder sn= new StringBuilder();
        StringBuilder sp= new StringBuilder();
        int countK=0;
        int countQ=0;
        int countR=0;
        int countB=0;
        int countN=0;
        int countP=0;
        if(player==ChessColor.BLACK){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='K'){
                        countK++;
                    }
                    if(chessComponents[i][j].getName()=='Q'){
                        countQ++;
                    }
                    if(chessComponents[i][j].getName()=='R'){
                        countR++;
                    }
                    if(chessComponents[i][j].getName()=='B'){
                        countB++;
                    }
                    if(chessComponents[i][j].getName()=='N'){
                        countN++;
                    }
                    if(chessComponents[i][j].getName()=='P'){
                        countP++;
                    }
                }
            }
            countK=1-countK;
            countQ=1-countQ;
            countR=2-countR;
            countB=2-countB;
            countN=2-countN;
            countP=8-countP;
            if(countK!=0){
                sk.append("K ").append(countK).append("\n");
            }
            if(countQ!=0){
                sq.append("Q ").append(countQ).append("\n");
            }
            if(countR!=0){
                sr.append("R ").append(countR).append("\n");
            }
            if(countB!=0){
                sb.append("B ").append(countB).append("\n");
            }
            if(countN!=0){
                sn.append("N ").append(countN).append("\n");
            }
            if(countP!=0){
                sp.append("P ").append(countP).append("\n");
            }
           s.append(sk).append(sq).append(sr).append(sb).append(sn).append(sp);
        }else{
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='k'){
                        countK++;
                    }
                    if(chessComponents[i][j].getName()=='q'){
                        countQ++;
                    }
                    if(chessComponents[i][j].getName()=='r'){
                        countR++;
                    }
                    if(chessComponents[i][j].getName()=='b'){
                        countB++;
                    }
                    if(chessComponents[i][j].getName()=='n'){
                        countN++;
                    }
                    if(chessComponents[i][j].getName()=='p'){
                        countP++;
                    }
                }
            }
            countK=1-countK;
            countQ=1-countQ;
            countR=2-countR;
            countB=2-countB;
            countN=2-countN;
            countP=8-countP;
            if(countK!=0){
                sk.append("k ").append(countK).append("\n");
            }
            if(countQ!=0){
                sq.append("q ").append(countQ).append("\n");
            }
            if(countR!=0){
                sr.append("r ").append(countR).append("\n");
            }
            if(countB!=0){
                sb.append("b ").append(countB).append("\n");
            }
            if(countN!=0){
                sn.append("n ").append(countN).append("\n");
            }
            if(countP!=0){
                sp.append("p ").append(countP).append("\n");
            }
            s.append(sk).append(sq).append(sr).append(sb).append(sn).append(sp);
        }
        return String.valueOf(s);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessboardPoint temp = null;
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> l = chess.canMoveTo();
        for (int i = 0; i < l.size(); i++) {
            for (int j = i + 1; j < l.size(); j++) {
                if (l.get(j).getX() < l.get(i).getX()) {
                    temp = l.get(j);
                    l.set(j, l.get(i));
                    l.set(i, temp);
                }
            }
        }
        for (int i = 0; i < l.size(); i++) {
            for (int j = i + 1; j < l.size(); j++) {
                if (l.get(j).getX() == l.get(i).getX() && l.get(j).getY() < l.get(i).getY()) {
                    temp = l.get(j);
                    l.set(j, l.get(i));
                    l.set(i, temp);
                }
            }
        }
        return l;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean judgement=false;
        List<ChessboardPoint> list=getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
        String point=new ChessboardPoint(targetX,targetY).toString();
        for(int i=0;i< list.size();i++){
            if(point.equals(list.get(i).toString())&&chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)){
               judgement=true;
               chessComponents[sourceX][sourceY].getSource().setX(targetX);
               chessComponents[sourceX][sourceY].getSource().setY(targetY);
               chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
               chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE);
               if(currentPlayer==(ChessColor.BLACK)){
                   currentPlayer=ChessColor.WHITE;
               }
               else{
                  currentPlayer=ChessColor.BLACK;
               }
            }
        }
        return judgement;
    }
}
