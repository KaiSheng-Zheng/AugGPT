import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Character.isLowerCase(chessboard.get(i).charAt(j))) {
                    if(chessboard.get(i).charAt(j)=='k'){
                        chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                    }else if(chessboard.get(i).charAt(j)=='q'){
                        chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                    }else if(chessboard.get(i).charAt(j)=='b'){
                        chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                    }else if(chessboard.get(i).charAt(j)=='n'){
                        chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                    }else if(chessboard.get(i).charAt(j)=='r'){
                        chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                    }else if (chessboard.get(i).charAt(j) == 'p') {
                        chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                    }
                } else if (Character.isUpperCase(chessboard.get(i).charAt(j))) {

                    if(chessboard.get(i).charAt(j)=='K'){
                        chessComponents[i][j]=new KingChessComponent( new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                    }else if(chessboard.get(i).charAt(j)=='Q'){
                        chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                    }else if(chessboard.get(i).charAt(j)=='B'){
                        chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                    }else if(chessboard.get(i).charAt(j)=='N'){
                        chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                    }else if(chessboard.get(i).charAt(j)=='R'){
                        chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                    }else if (chessboard.get(i).charAt(j)== 'P') {
                        chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                    }
                } else {
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }

            }

        }
        if (chessboard.get(8).equals("w")) {
            setCurrentPlayer(ChessColor.WHITE);
        } else if (chessboard.get(8).equals("b")) {
            setCurrentPlayer(ChessColor.BLACK);
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder sb=new StringBuilder();
        String[] graph = new String[8];

        for(int i=0;i<8;i++){
            sb.append(chessComponents[0][i].name);
        }
        graph[0]=sb.toString();
        sb.delete(0,8);
        for(int i=0;i<8;i++){
            sb.append(chessComponents[1][i].name);
        }
        graph[1]=sb.toString();
        sb.delete(0,8);

        for(int i=0;i<8;i++){
            sb.append(chessComponents[2][i].name);
        }
        graph[2]=sb.toString();
        sb.delete(0,8);

        for(int i=0;i<8;i++){
            sb.append(chessComponents[3][i].name);
        }
        graph[3]=sb.toString();
        sb.delete(0,8);

        for(int i=0;i<8;i++){
            sb.append(chessComponents[4][i].name);
        }
        graph[4]=sb.toString();
        sb.delete(0,8);

        for(int i=0;i<8;i++){
            sb.append(chessComponents[5][i].name);
        }
        graph[5]=sb.toString();
        sb.delete(0,8);

        for(int i=0;i<8;i++){
            sb.append(chessComponents[6][i].name);
        }
        graph[6]=sb.toString();
        sb.delete(0,8);

        for(int i=0;i<8;i++){
            sb.append(chessComponents[7][i].name);
        }
        graph[7]=sb.toString();
        sb.delete(0,8);

        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", graph[0], graph[1], graph[2], graph[3], graph[4], graph[5], graph[6], graph[7]);
    }

    @Override
    public String getCapturedChess(ChessColor player) {

        int numberK = 1, numberQ = 1, numberR = 2, numberB = 2, numberN = 2, numberP = 8;

        if (player.equals(ChessColor.WHITE)) {
            StringBuilder sb=new StringBuilder();
            int counterK = 0, counterQ = 0, counterR = 0, counterB = 0, counterN = 0, counterP = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                 if(chessComponents[i][j].name=='k'){
                     counterK++;
                 }else if(chessComponents[i][j].name=='q'){
                     counterQ++;
                 }else if(chessComponents[i][j].name=='r'){
                     counterR++;
                 }else if(chessComponents[i][j].name=='b'){
                     counterB++;
                 }else if(chessComponents[i][j].name=='n'){
                     counterN++;
                 }else if(chessComponents[i][j].name=='p'){
                     counterP++;
                 }
                }
            }
            int diffK=numberK-counterK,diffQ=numberQ-counterQ,diffR=numberR-counterR,diffB=numberB-counterB,diffN=numberN-counterN,diffP=numberP-counterP;
            if(diffK!=0){
                sb.append("k ");
                sb.append(diffK);
                sb.append("\n");
            }
            if(diffQ!=0){
                sb.append("q ");
                sb.append(diffQ);
                sb.append("\n");
            }
            if(diffR!=0){
                sb.append("r ");
                sb.append(diffR);
                sb.append("\n");
            }
            if(diffB!=0){
                sb.append("b ");
                sb.append(diffB);
                sb.append("\n");
            }
            if(diffN!=0){
                sb.append("n ");
                sb.append(diffN);
                sb.append("\n");
            }
            if(diffP!=0){
                sb.append("p ");
                sb.append(diffP);
                sb.append("\n");
            }

            return sb.toString();
        } else {
            StringBuilder sb=new StringBuilder();
            int counterK = 0, counterQ = 0, counterR = 0, counterB = 0, counterN = 0, counterP = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j].name=='K'){
                        counterK++;
                    }else if(chessComponents[i][j].name=='Q'){
                        counterQ++;
                    }else if(chessComponents[i][j].name=='R'){
                        counterR++;
                    }else if(chessComponents[i][j].name=='B'){
                        counterB++;
                    }else if(chessComponents[i][j].name=='N'){
                        counterN++;
                    }else if(chessComponents[i][j].name=='P'){
                        counterP++;
                    }
                }
            }
            int diffK=numberK-counterK,diffQ=numberQ-counterQ,diffR=numberR-counterR,diffB=numberB-counterB,diffN=numberN-counterN,diffP=numberP-counterP;
            if(diffK!=0){
                sb.append("K ");
                sb.append(diffK);
                sb.append("\n");
            }
            if(diffQ!=0){
                sb.append("Q ");
                sb.append(diffQ);
                sb.append("\n");
            }
            if(diffR!=0){
                sb.append("R ");
                sb.append(diffR);
                sb.append("\n");
            }
            if(diffB!=0){
                sb.append("B ");
                sb.append(diffB);
                sb.append("\n");
            }
            if(diffN!=0){
                sb.append("N ");
                sb.append(diffN);
                sb.append("\n");
            }
            if(diffP!=0){
                sb.append("P ");
                sb.append(diffP);
                sb.append("\n");
            }
            return sb.toString();
        }
    }
    public ChessComponent[][] getChessComponent(){
        return chessComponents;
    }

    public void switchChess(int iX,int iY,int fX,int fY){
        ChessboardPoint chessboardPoint=new ChessboardPoint(fX,fY);

    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> CanMovePoints;
        return null;
    }

    public void switchPlayer(ChessColor chessColor){
        if(getCurrentPlayer().equals(ChessColor.BLACK)){
           setCurrentPlayer(ChessColor.WHITE);
        }else if(getCurrentPlayer().equals(ChessColor.WHITE)){
           setCurrentPlayer(ChessColor.BLACK);
        }
    }
    @Override
    public ChessComponent getChess ( int x, int y){
        return chessComponents[x][y];
    }
    @Override
    public boolean moveChess(int sourceX,int sourceY,int targetX,int targetY){
        ChessComponent[][] chessComponent=getChessComponent();
        boolean can=false;
       /* for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(getCurrentPlayer()!=chessComponent[i][j].getChessColor()){
                    can=false;
                    break;
                }else{
                   can=true;
                }
            }
        }*/


        switchPlayer(getCurrentPlayer());
        return can;
    }
}
