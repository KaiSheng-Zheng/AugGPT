import java.util.List;
import java.util.Locale;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.currentPlayer = ChessColor.WHITE;
        this.chessComponents = new ChessComponent[8][8];
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        if(chessComponents.length==8){
            this.chessComponents = chessComponents;
        }else {
            this.chessComponents = new ChessComponent[8][8];
        }
        if(currentPlayer.equals(ChessColor.BLACK)||currentPlayer.equals(ChessColor.WHITE)){
            this.currentPlayer = currentPlayer;
        }else {
            this.currentPlayer = ChessColor.WHITE;
        }
            for(int a=0; a<chessComponents.length;a++){
            for(int b=0;b<chessComponents[a].length;b++){
                chessComponents[a][b].CB= this;
                }
            }
        }

        public void loadChessGame(List<String> chessboard){
        this.chessComponents = new ChessComponent[8][8];
        for(int a=0; a<chessComponents.length;a++){
            for(int b=0;b<chessComponents[a].length;b++){
                switch (chessboard.get(a).charAt(b)){
                    case '_':
                        chessComponents[a][b] = new EmptySlotComponent();
                        break;
                    case 'K':
                        chessComponents[a][b] = new KingChessComponent(new ChessboardPoint(a,b),ChessColor.BLACK);
                        break;
                    case 'k':
                        chessComponents[a][b] = new KingChessComponent(new ChessboardPoint(a,b),ChessColor.WHITE);
                        break;
                    case 'Q':
                        chessComponents[a][b] = new QueenChessComponent(new ChessboardPoint(a,b),ChessColor.BLACK);
                        break;
                    case 'q':
                        chessComponents[a][b] = new QueenChessComponent(new ChessboardPoint(a,b),ChessColor.WHITE);
                        break;
                    case 'R':
                        chessComponents[a][b] = new RookChessComponent(new ChessboardPoint(a,b),ChessColor.BLACK);
                        break;
                    case 'r':
                        chessComponents[a][b] = new RookChessComponent(new ChessboardPoint(a,b),ChessColor.WHITE);
                        break;
                    case 'B':
                        chessComponents[a][b] = new BishopChessComponent(new ChessboardPoint(a,b),ChessColor.BLACK);
                        break;
                    case 'b':
                        chessComponents[a][b] = new BishopChessComponent(new ChessboardPoint(a,b),ChessColor.WHITE);
                        break;
                    case 'N':
                        chessComponents[a][b] = new KnightChessComponent(new ChessboardPoint(a,b),ChessColor.BLACK);
                        break;
                    case 'n':
                        chessComponents[a][b] = new KnightChessComponent(new ChessboardPoint(a,b),ChessColor.WHITE);
                        break;
                    case 'P':
                        chessComponents[a][b] = new PawnChessComponent(new ChessboardPoint(a,b),ChessColor.BLACK);
                        break;
                    case 'p':
                        chessComponents[a][b] = new PawnChessComponent(new ChessboardPoint(a,b),ChessColor.WHITE);
                        break;
                }
            }
        }
        if(chessboard.get(8).equals("w")){
            this.currentPlayer = ChessColor.WHITE;
        }else if(chessboard.get(8).equals("b")){
            this.currentPlayer = ChessColor.BLACK;
        }

            for(int a=0; a<chessComponents.length;a++){
                for(int b=0;b<chessComponents[a].length;b++){
                    chessComponents[a][b].CB= this;
                }
            }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        boolean contain = false;
        if(chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer){
            return false;
        }
        List<ChessboardPoint> canMove = getCanMovePoints(source);
        for(int i=0;i<canMove.size();i++){
            if(canMove.get(i).getX()==targetX&&canMove.get(i).getY()==targetY){
                contain = true;
                break;
            }
        }
        if(contain){
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            for(int a=0; a<chessComponents.length;a++){
            for(int b=0;b<chessComponents[a].length;b++){
                chessComponents[a][b].CB= this;
                }
        }
            if(currentPlayer.equals(ChessColor.BLACK)){
                currentPlayer = ChessColor.WHITE;
            }else {
                currentPlayer = ChessColor.BLACK;
            }
            return true;
        }else {
            return false;
        }
    }

    public String getChessboardGraph(){
        StringBuilder result = new StringBuilder();
        for(int a=0; a<chessComponents.length;a++){
            for(int b=0;b<chessComponents[a].length;b++){
                result.append(chessComponents[a][b].toString());
            }
            if(a!=7){
                result.append("\n");
            }
        }
        return result.toString();
    }

    public String getCapturedChess(ChessColor player){
        StringBuilder result = new StringBuilder();
        String CB = getChessboardGraph();
        int K=0,k=0,Q=0,q=0,R=0,r=0,B=0,b=0,N=0,n=0,P=0,p=0;

        for(int i=0;i<CB.length();i++){
            if(CB.charAt(i)=='K')K++;
            if(CB.charAt(i)=='k')k++;
            if(CB.charAt(i)=='Q')Q++;
            if(CB.charAt(i)=='q')q++;
            if(CB.charAt(i)=='R')R++;
            if(CB.charAt(i)=='r')r++;
            if(CB.charAt(i)=='B')B++;
            if(CB.charAt(i)=='b')b++;
            if(CB.charAt(i)=='N')N++;
            if(CB.charAt(i)=='n')n++;
            if(CB.charAt(i)=='P')P++;
            if(CB.charAt(i)=='p')p++;
        }
        if(player.equals(ChessColor.BLACK)){
            if(K!=1)result.append(String.format("K %d\n",1-K));
            if(Q!=1)result.append(String.format("Q %d\n",1-Q));
            if(R!=2)result.append(String.format("R %d\n",2-R));
            if(B!=2)result.append(String.format("B %d\n",2-B));
            if(N!=2)result.append(String.format("N %d\n",2-N));
            if(P!=8)result.append(String.format("P %d\n",8-P));
        }else {
            if(k!=1)result.append(String.format("k %d\n",1-k));
            if(q!=1)result.append(String.format("q %d\n",1-q));
            if(r!=2)result.append(String.format("r %d\n",2-r));
            if(b!=2)result.append(String.format("b %d\n",2-b));
            if(n!=2)result.append(String.format("n %d\n",2-n));
            if(p!=8)result.append(String.format("p %d\n",8-p));
        }

        return result.toString();
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

}
