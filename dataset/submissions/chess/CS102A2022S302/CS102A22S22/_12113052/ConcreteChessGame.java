import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {
    }

    public void loadChessGame(List<String> chessboard){
        this.chessComponents=new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j)=='R'){
                    RookChessComponent rookChessComponent= new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    chessComponents[i][j]=rookChessComponent;
                }else if (chessboard.get(i).charAt(j)=='N'){
                    KnightChessComponent knightChessComponent=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    chessComponents[i][j]=knightChessComponent;
                }else if (chessboard.get(i).charAt(j)=='B'){
                    BishopChessComponent bishopChessComponent=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    chessComponents[i][j]=bishopChessComponent;
                }else if (chessboard.get(i).charAt(j)=='Q'){
                    QueenChessComponent queenChessComponent=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    chessComponents[i][j]=queenChessComponent;
                }else if (chessboard.get(i).charAt(j)=='K'){
                    KingChessComponent kingChessComponent=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    chessComponents[i][j]=kingChessComponent;
                }else if (chessboard.get(i).charAt(j)=='P'){
                    PawnChessComponent pawnChessComponent=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    chessComponents[i][j]=pawnChessComponent;
                }else if (chessboard.get(i).charAt(j)=='_'){
                    EmptySlotComponent emptySlotComponent=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE);
                    chessComponents[i][j]= emptySlotComponent;
                }else if (chessboard.get(i).charAt(j)=='r'){
                    RookChessComponent rookChessComponent= new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    chessComponents[i][j]=rookChessComponent;
                }else if (chessboard.get(i).charAt(j)=='n'){
                    KnightChessComponent knightChessComponent=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    chessComponents[i][j]=knightChessComponent;
                }else if (chessboard.get(i).charAt(j)=='b'){
                    BishopChessComponent bishopChessComponent=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    chessComponents[i][j]=bishopChessComponent;
                }else if (chessboard.get(i).charAt(j)=='q'){
                    QueenChessComponent queenChessComponent=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    chessComponents[i][j]=queenChessComponent;
                }else if (chessboard.get(i).charAt(j)=='k'){
                    KingChessComponent kingChessComponent=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    chessComponents[i][j]=kingChessComponent;
                }else if (chessboard.get(i).charAt(j)=='p'){
                    PawnChessComponent pawnChessComponent=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    chessComponents[i][j]=pawnChessComponent;
                }
            }

        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
        if (chessboard.get(8).charAt(0)=='b'){
            currentPlayer=ChessColor.BLACK;
        }else if (chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }
    }

    @Override
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph(){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                stringBuilder.append(chessComponents[i][j].name);
                if (j==7&&i!=7){
                    stringBuilder.append("\n");
                }
            }
        }
        return stringBuilder.toString();//save chessboard as string
    }

    public List<ChessboardPoint>getCanMovePoints(ChessboardPoint source){
        /*ChessComponent chess=this.getChess(source.getX(),source.getY());
        List<ChessboardPoint>canMovePoints=chess.canMoveTo();
        //sort by up*/
        List<ChessboardPoint> chessboardPointList=chessComponents[source.getX()][source.getY()].canMoveTo();
        if (chessboardPointList!=null){
            for (int i = 0; i < chessboardPointList.size()-1; i++) {
                for (int j = 0; j < chessboardPointList.size()-i-1; j++) {
                    if (chessboardPointList.get(j).getX()>chessboardPointList.get(j+1).getX()){
                        ChessboardPoint swap=chessboardPointList.get(j);
                        chessboardPointList.set(j,chessboardPointList.get(j+1));
                        chessboardPointList.set(j+1,swap);
                    }
                }
            }
            for (int i = 0; i < chessboardPointList.size()-1; i++) {
                for (int j = 0; j < chessboardPointList.size()-i-1; j++) {
                    if (chessboardPointList.get(j).getX()==chessboardPointList.get(j+1).getX()){
                        if (chessboardPointList.get(j).getY()>chessboardPointList.get(j+1).getY()){
                            ChessboardPoint swap=chessboardPointList.get(j);
                            chessboardPointList.set(j,chessboardPointList.get(j+1));
                            chessboardPointList.set(j+1,swap);
                        }
                    }
                }
            }
        }


        return chessboardPointList;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> move=chessComponents[sourceX][sourceY].canMoveTo();
        if (move!=null){
            if (chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
                if (chessComponents[targetX][targetY].getChessColor()!=currentPlayer){
                    for (int i = 0; i < move.size(); i++) {
                        if (move.get(i) != null) {
                            if (targetX==move.get(i).getX()&&targetY==move.get(i).getY()){
                                ChessComponent swap=chessComponents[sourceX][sourceY];
                                if (currentPlayer==ChessColor.WHITE){
                                    currentPlayer=ChessColor.BLACK;
                                }else {
                                    currentPlayer=ChessColor.WHITE;
                                }
                                chessComponents[targetX][targetY].setSource(new ChessboardPoint(sourceX,sourceY));
                                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
                                chessComponents[targetX][targetY]= chessComponents[sourceX][sourceY];
                                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
                                return true;
                            }
                        }
                        
                    }
                }
            }
        }
        /*for (int i = 0; i < move.size(); i++) {
            if (targetX==move.get(i).getX()||targetY==move.get(i).getY()){
                return true;
            }else return false;
        }*/

        return false;


    }

    //ChessComponent chess=new ChessComponent() {
        public List<ChessboardPoint> canMoveTo(ChessboardPoint source) {
            List<ChessboardPoint>chessboardPointList=new ArrayList<>();
            chessboardPointList=chessComponents[source.getX()][source.getY()].canMoveTo();
    return chessboardPointList;
    }


    @Override
    public String getCapturedChess(ChessColor player){
        if (player==ChessColor.BLACK){
            int r = 0;
            int n=0;
            int b=0;
            int q=0;
            int k=0;
            int p=0;//counters for the remaining chess on the board
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name=='R'){
                        r++;
                    }else if (chessComponents[i][j].name=='N'){
                        n++;
                    }else if (chessComponents[i][j].name=='B'){
                        b++;
                    }else if (chessComponents[i][j].name=='Q'){
                        q++;
                    }else if (chessComponents[i][j].name=='K'){
                        k++;
                    }else if (chessComponents[i][j].name=='P'){
                        p++;
                    }
                }
            }
            StringBuilder stringBuilder=new StringBuilder();
            if (k==1){
                stringBuilder.append(""); //if k==1, not losing king chess
            }else stringBuilder.append(String.format("K 1\n"));
            if (q==1){
                stringBuilder.append("");
            }else stringBuilder.append(String.format("Q 1\n"));
            if (r==2){
                stringBuilder.append("");
            }else stringBuilder.append(String.format("R %d\n",2-r));
            if (b==2){
                stringBuilder.append("");
            }else stringBuilder.append(String.format("B %d\n",2-b));
            if (n==2){
                stringBuilder.append("");
            }else stringBuilder.append(String.format("N %d\n",2-n));
            if (p==8){
                stringBuilder.append("");
            }else stringBuilder.append(String.format("P %d\n",8-p));
            return stringBuilder.toString();
        }else if (player==ChessColor.WHITE){ //similar to BLACK
            int r = 0;
            int n=0;
            int b=0;
            int q=0;
            int k=0;
            int p=0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name=='r'){
                        r++;
                    }else if (chessComponents[i][j].name=='n'){
                        n++;
                    }else if (chessComponents[i][j].name=='b'){
                        b++;
                    }else if (chessComponents[i][j].name=='q'){
                        q++;
                    }else if (chessComponents[i][j].name=='k'){
                        k++;
                    }else if (chessComponents[i][j].name=='p'){
                        p++;
                    }
                }
            }//King>Queen>Rooks>Bishops>Knights>Pawns
            StringBuilder stringBuilder=new StringBuilder();
            if (k==1){
                stringBuilder.append("");
            }else stringBuilder.append("k 1\n");
            if (q==1){
                stringBuilder.append("");
            }else stringBuilder.append("q 1\n");
            if (r==2){
                stringBuilder.append("");
            }else stringBuilder.append(String.format("r %d\n",2-r));
            if (b==2){
                stringBuilder.append("");
            }else stringBuilder.append(String.format("b %d\n",2-b));
            if (n==2){
                stringBuilder.append("");
            }else stringBuilder.append(String.format("n %d\n",2-n));
            if (p==8){
                stringBuilder.append("");
            }else stringBuilder.append(String.format("p %d\n",8-p));
            return stringBuilder.toString();
        }
        else return null;
    }

}
