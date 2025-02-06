import java.util.List;
public class ConcreteChessGame implements ChessGame{
    private  ChessComponent[][] chessComponents;
           // =  new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];

        this.currentPlayer = ChessColor.WHITE;
    }
    public void loadChessGame(List<String> chessboard) {
        //ChessComponent[][] newChessComponents = new ChessComponent[8][8];
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char TiQu = chessboard.get(i).charAt(j);
                ChessboardPoint newSource =new ChessboardPoint(i,j);
                if (TiQu=='R'){
                    chessComponents[i][j]=new RookChessComponent(newSource,ChessColor.BLACK,'R',chessComponents);
                    //ChessComponent.setTarget(chessComponents);
                }
                if (TiQu=='r'){
                    chessComponents[i][j]=new RookChessComponent(newSource,ChessColor.WHITE,'r',chessComponents);
                }
                if (TiQu=='N'){
                    chessComponents[i][j]=new KnightChessComponent(newSource,ChessColor.BLACK,'N',chessComponents);
                }
                if (TiQu=='n'){
                    chessComponents[i][j]=new KnightChessComponent(newSource,ChessColor.WHITE,'n',chessComponents);
                }
                if (TiQu=='B'){
                    chessComponents[i][j]=new BishopChessComponent(newSource,ChessColor.BLACK,'B',chessComponents);
                }
                if (TiQu=='b'){
                    chessComponents[i][j]=new BishopChessComponent(newSource,ChessColor.WHITE,'b',chessComponents);
                }
                if (TiQu=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(newSource,ChessColor.BLACK,'Q',chessComponents);
                }
                if (TiQu=='q'){
                    chessComponents[i][j]=new QueenChessComponent(newSource,ChessColor.WHITE,'q',chessComponents);
                }
                if (TiQu=='K'){
                    chessComponents[i][j]=new KingChessComponent(newSource,ChessColor.BLACK,'K',chessComponents);
                }
                if (TiQu=='k'){
                    chessComponents[i][j]=new KingChessComponent(newSource,ChessColor.WHITE,'k',chessComponents);
                }
                if (TiQu=='P'){
                    chessComponents[i][j]=new PawnChessComponent(newSource,ChessColor.BLACK,'P',chessComponents);
                }
                if (TiQu=='p'){
                    chessComponents[i][j]=new PawnChessComponent(newSource,ChessColor.WHITE,'p',chessComponents);
                }
                if (TiQu=='_'){
                    chessComponents[i][j]=new EmptySlotComponent(newSource,ChessColor.NONE,'_',chessComponents);
                }
            }
        }
          if (chessboard.get(8).charAt(0)=='w'){
            currentPlayer =ChessColor.WHITE;
        }
        if (chessboard.get(8).charAt(0)=='b'){
            currentPlayer =ChessColor.BLACK;
        }

       /*for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                newChessComponents[i][j]=chessComponents[i][j];
            }
        }
*/


    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph() {
        StringBuilder ChessboardGraph = new StringBuilder();
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++) {
                ChessboardGraph.append(chessComponents[i][j].name);
                if ( j == 7){
                    ChessboardGraph.append("\n");
                }
            }
        }
        return String.valueOf(ChessboardGraph);
    }
    public String getCapturedChess(ChessColor player){
        int countK = 0;int countQ = 0;int countR = 0;int countB = 0;int countN = 0;int countP = 0;
        if (player==ChessColor.BLACK){
            for (int i=0;i<8;i++){
                for(int j=0;j<8;j++) {
                    if (chessComponents[i][j].name=='K'){
                        countK++;
                    }
                    if (chessComponents[i][j].name=='Q'){
                        countQ++;
                    }
                    if (chessComponents[i][j].name=='R'){
                        countR++;
                    }
                    if (chessComponents[i][j].name=='B'){
                        countB++;
                    }
                    if (chessComponents[i][j].name=='N'){
                        countN++;
                    }
                    if (chessComponents[i][j].name=='P'){
                        countP++;
                    }
                }
            }
        }
        if (player==ChessColor.WHITE){
            for (int i=0;i<8;i++){
                for(int j=0;j<8;j++) {
                    if (chessComponents[i][j].name=='k'){
                        countK++;
                    }
                    if (chessComponents[i][j].name=='q'){
                        countQ++;
                    }
                    if (chessComponents[i][j].name=='r'){
                        countR++;
                    }
                    if (chessComponents[i][j].name=='b'){
                        countB++;
                    }
                    if (chessComponents[i][j].name=='n'){
                        countN++;
                    }
                    if (chessComponents[i][j].name=='p'){
                        countP++;
                    }
                }
            }
        }
        int resultK = 1-countK;int resultQ = 1-countQ;int resultR = 2-countR;int resultB = 2-countB;
        int resultN = 2-countN;int resultP = 8-countP;
        StringBuilder result = new StringBuilder();
        if (player==ChessColor.BLACK) {
            if (resultK != 0) {
                result.append("K ");
                result.append(resultK);
                result.append("\n");
            }
            if (resultQ != 0) {
                result.append("Q ");
                result.append(resultQ);
                result.append("\n");
            }
            if (resultR != 0) {
                result.append("R ");
                result.append(resultR);
                result.append("\n");
            }
            if (resultB != 0) {
                result.append("B ");
                result.append(resultB);
                result.append("\n");
            }
            if (resultN != 0) {
                result.append("N ");
                result.append(resultN);
                result.append("\n");
            }
            if (resultP != 0) {
                result.append("P ");
                result.append(resultP);
                result.append("\n");
            }
        }
        if (player==ChessColor.WHITE) {
            if (resultK != 0) {
                result.append("k ");
                result.append(resultK);
                result.append("\n");
            }
            if (resultQ != 0) {
                result.append("q ");
                result.append(resultQ);
                result.append("\n");
            }
            if (resultR != 0) {
                result.append("r ");
                result.append(resultR);
                result.append("\n");
            }
            if (resultB != 0) {
                result.append("b ");
                result.append(resultB);
                result.append("\n");
            }
            if (resultN != 0) {
                result.append("n ");
                result.append(resultN);
                result.append("\n");
            }
            if (resultP != 0) {
                result.append("p ");
                result.append(resultP);
                result.append("\n");
            }
        }
        return String.valueOf(result);
    }






    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        List<ChessboardPoint> canMovePoints=getChess(x,y).canMoveTo();
        for (int j = 0; j < canMovePoints.size(); j++) {
            for (int k = canMovePoints.size() - 1; k > j; k--) {
                if (canMovePoints.get(k).getX() < canMovePoints.get(k - 1).getX()) {
                    ChessboardPoint temp = canMovePoints.get(k - 1);
                    canMovePoints.set(k - 1, canMovePoints.get(k));
                    canMovePoints.set(k, temp);
                }
            }

            //
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {






        return false;
    }

    public ChessComponent getChess(int x, int y){
        return this.chessComponents[x][y];
    }


}
