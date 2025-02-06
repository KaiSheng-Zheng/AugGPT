import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
        this.chessComponents = new ChessComponent[8][8];

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                this.chessComponents[i-1][j-1] = chessComponents[i-1][j-1];
            }
        }
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents) {
         this(chessComponents,ChessColor.WHITE);
    }

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i=1;i<=8;i++){
            for (int j=1;j<=8;j++){

                char current= chessboard.get(i-1).charAt(j-1);
                char origin0 = chessboard.get(i-1).charAt(j-1);

                ChessColor color;
                if (current<=90 && current>=65) color=ChessColor.BLACK;
                else if(current<=122 && current>=97){
                    color=ChessColor.WHITE;
                    current= (char) (current-32);
                }else{
                    color=ChessColor.NONE;
                }

                ChessComponent chess;
                switch (current){
                    case 'R':
                        chess=new RookChessComponent(new ChessboardPoint(i,j),color,origin0);
                        break;
                    case 'N':
                        chess=new KnightChessComponent(new ChessboardPoint(i,j),color,origin0);
                        break;
                    case 'B':
                        chess=new BishopChessComponent(new ChessboardPoint(i,j),color,origin0);
                        break;
                    case 'Q':
                        chess=new QueenChessComponent(new ChessboardPoint(i,j),color,origin0);
                        break;
                    case 'K':
                        chess=new KingChessComponent(new ChessboardPoint(i,j),color,origin0);
                        break;
                    case 'P':
                        chess=new PawnChessComponent(new ChessboardPoint(i,j),color,origin0);
                        break;
                    default:
                        chess=new EmptyChessComponent(new ChessboardPoint(i,j),color,origin0);
                        break;
                }
                chessComponents[i-1][j-1]=chess;

            }
        }

        char player= chessboard.get(8).charAt(0);
        if(player=='b') this.currentPlayer=ChessColor.BLACK;
        else this.currentPlayer=ChessColor.WHITE;
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
        StringBuilder re= new StringBuilder();
        for (int i=1;i<=8;i++){
            for (int j=1;j<=8;j++) {
                boolean black=true;
                if(chessComponents[i-1][j-1].getChessColor().equals(ChessColor.WHITE)) black=false;

                if(chessComponents[i-1][j-1] instanceof RookChessComponent){
                    if(black) re.append("R");
                    else re.append("r");
                }else if(chessComponents[i-1][j-1] instanceof KnightChessComponent){
                    if(black) re.append("N");
                    else re.append("n");
                }else if(chessComponents[i-1][j-1] instanceof BishopChessComponent){
                    if(black) re.append("B");
                    else re.append("b");
                }else if(chessComponents[i-1][j-1] instanceof QueenChessComponent){
                    if(black) re.append("Q");
                    else re.append("q");
                }else if(chessComponents[i-1][j-1] instanceof KingChessComponent){
                    if(black) re.append("K");
                    else re.append("k");
                }else if(chessComponents[i-1][j-1] instanceof PawnChessComponent){
                    if(black) re.append("P");
                    else re.append("p");
                }else if(chessComponents[i-1][j-1] instanceof EmptyChessComponent){
                   re.append("_");
                }
            }
            if(i!=8) re.append("\n");
        }

        return re.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
         int role[]=new int[6];

         for (int i=1;i<=8;i++){
            for (int j=1;j<=8;j++){
                if(chessComponents[i-1][j-1].getChessColor().equals(player)){
                    char who = chessComponents[i-1][j-1].getName();
                    if(who>90) who= (char) (who-32);
                    switch (who){
                        case 'K':
                            role[0]++;
                            break;
                        case 'Q':
                            role[1]++;
                            break;
                        case 'R':
                            role[2]++;
                            break;
                        case 'B':
                            role[3]++;
                            break;
                        case 'N':
                            role[4]++;
                            break;
                        case 'P':
                            role[5]++;
                            break;
                    }
                }
             }
         }

         String re="";
         if(role[0]<1) re+="K 1\n";
         if(role[1]<1) re+="Q 1\n";
         if(role[2]<2) re+=String.format("R %d\n",2-role[2]);
         if(role[3]<2) re+=String.format("B %d\n",2-role[3]);
         if(role[4]<2) re+=String.format("N %d\n",2-role[4]);
         if(role[5]<8) re+=String.format("P %d\n",8-role[5]);

         if(player.equals(ChessColor.WHITE)) re=re.toLowerCase();
        return re;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();

        canMovePoints.sort(new SortByXY());
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(!getChess(sourceX,sourceY).getChessColor().equals(getCurrentPlayer()))return false;

        int index = getChess(sourceX,sourceY).canMoveTo().indexOf(new ChessboardPoint(targetX,targetY));
        if(index==-1)return false;

        getChess(sourceX,sourceY).setSource(new ChessboardPoint(targetX,targetY));
        getChess(targetX,targetY).setSource(new ChessboardPoint(sourceX,sourceY));

        ChessComponent swap1 = chessComponents[sourceX][sourceY];
        ChessComponent swap2 = chessComponents[targetX][targetY];
        chessComponents[sourceX][sourceY]=swap2;
        chessComponents[targetX][targetY]=swap1;

        chessComponents[sourceX][sourceY]=new EmptyChessComponent
                (new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
        return true;
    }



    public class SortByXY implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint o1, ChessboardPoint o2){
            return (o1.getX()!=o2.getX())? (o1.getX()-o2.getX()):(o1.getY()-o2.getY());
        }

    }



}
