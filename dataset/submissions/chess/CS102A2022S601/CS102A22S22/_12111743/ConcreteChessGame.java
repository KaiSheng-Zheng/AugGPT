import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if(chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }
        if(chessboard.get(8).equals("b")){
            currentPlayer=ChessColor.BLACK;
        }

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (chessboard.get(i).charAt(j)=='_'){
                    ChessboardPoint cp=new ChessboardPoint(i,j);
                    EmptySlotComponent e=new EmptySlotComponent(cp,ChessColor.NONE,'_');
                    chessComponents[i][j]=e;
                    e.Board=chessComponents;
                }else if(chessboard.get(i).charAt(j)=='k') {
                    ChessboardPoint cp = new ChessboardPoint(i, j);
                    KingChessComponent e = new KingChessComponent(cp, ChessColor.WHITE, 'k');
                    chessComponents[i][j] = e;
                    e.Board = chessComponents;
                }else if(chessboard.get(i).charAt(j)=='q') {
                    ChessboardPoint cp = new ChessboardPoint(i, j);
                    QueenChessComponent e = new QueenChessComponent(cp, ChessColor.WHITE, 'q');
                    chessComponents[i][j] = e;
                    e.Board = chessComponents;
                }else if(chessboard.get(i).charAt(j)=='b') {
                    ChessboardPoint cp = new ChessboardPoint(i, j);
                    BishopChessComponent e = new BishopChessComponent(cp, ChessColor.WHITE, 'b');
                    chessComponents[i][j] = e;
                    e.Board = chessComponents;
                }else if(chessboard.get(i).charAt(j)=='n') {
                    ChessboardPoint cp = new ChessboardPoint(i, j);
                    KnightChessComponent e = new KnightChessComponent(cp, ChessColor.WHITE, 'n');
                    chessComponents[i][j] = e;
                    e.Board = chessComponents;
                }else if(chessboard.get(i).charAt(j)=='r') {
                    ChessboardPoint cp = new ChessboardPoint(i, j);
                    RookChessComponent e = new RookChessComponent(cp, ChessColor.WHITE, 'r');
                    chessComponents[i][j] = e;
                    e.Board = chessComponents;
                }else if(chessboard.get(i).charAt(j)=='p') {
                    ChessboardPoint cp = new ChessboardPoint(i, j);
                    PawnChessComponent e = new PawnChessComponent(cp, ChessColor.WHITE, 'p');
                    chessComponents[i][j] = e;
                    e.Board = chessComponents;
                }else if(chessboard.get(i).charAt(j)=='K') {
                    ChessboardPoint cp = new ChessboardPoint(i, j);
                    KingChessComponent e = new KingChessComponent(cp, ChessColor.BLACK, 'K');
                    chessComponents[i][j] = e;
                    e.Board = chessComponents;
                }else if(chessboard.get(i).charAt(j)=='Q') {
                    ChessboardPoint cp = new ChessboardPoint(i, j);
                    QueenChessComponent e = new QueenChessComponent(cp, ChessColor.BLACK, 'Q');
                    chessComponents[i][j] = e;
                    e.Board = chessComponents;
                }else if(chessboard.get(i).charAt(j)=='B') {
                    ChessboardPoint cp = new ChessboardPoint(i, j);
                    BishopChessComponent e = new BishopChessComponent(cp, ChessColor.BLACK, 'B');
                    chessComponents[i][j] = e;
                    e.Board = chessComponents;
                }else if(chessboard.get(i).charAt(j)=='N') {
                    ChessboardPoint cp = new ChessboardPoint(i, j);
                    KnightChessComponent e = new KnightChessComponent(cp, ChessColor.BLACK, 'N');
                    chessComponents[i][j] = e;
                    e.Board = chessComponents;
                }else if(chessboard.get(i).charAt(j)=='R') {
                    ChessboardPoint cp = new ChessboardPoint(i, j);
                    RookChessComponent e = new RookChessComponent(cp, ChessColor.BLACK, 'R');
                    chessComponents[i][j] = e;
                    e.Board = chessComponents;
                }else if(chessboard.get(i).charAt(j)=='P') {
                    ChessboardPoint cp = new ChessboardPoint(i, j);
                    PawnChessComponent e = new PawnChessComponent(cp, ChessColor.BLACK, 'P');
                    chessComponents[i][j] = e;
                    e.Board = chessComponents;
                }
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
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                sb.append(chessComponents[i][j].name);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder sb=new StringBuilder();
        int counterK=0;
        int counterQ=0;
        int counterB=0;
        int counterN=0;
        int counterR=0;
        int counterP=0;
        if(player==ChessColor.WHITE){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].name=='k'){
                        counterK+=1;
                    }else if(chessComponents[i][j].name=='q'){
                        counterQ+=1;
                    }else if(chessComponents[i][j].name=='b'){
                        counterB+=1;
                    }else if(chessComponents[i][j].name=='n'){
                        counterN+=1;
                    }else if(chessComponents[i][j].name=='r'){
                        counterR+=1;
                    }else if(chessComponents[i][j].name=='p'){
                        counterP+=1;
                    }
                }
            }
            if(counterK!=1){
                sb.append('k'+" "+1+"\n");
            }if(counterQ!=1){
                sb.append('q'+" "+1+"\n");
            }if(counterR!=2) {
                sb.append('r' + " " +(2-counterR)+"\n");
            }if(counterB!=2) {
                sb.append('b' + " " +(2-counterB)+"\n");
            }if(counterN!=2) {
                sb.append('n' + " " +(2-counterN)+"\n");
            }if(counterP!=8) {
                sb.append('p' + " " +(8-counterP));
            }
        }else if(player==ChessColor.BLACK){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].name=='K'){
                        counterK+=1;
                    }else if(chessComponents[i][j].name=='Q'){
                        counterQ+=1;
                    }else if(chessComponents[i][j].name=='B'){
                        counterB+=1;
                    }else if(chessComponents[i][j].name=='N'){
                        counterN+=1;
                    }else if(chessComponents[i][j].name=='R'){
                        counterR+=1;
                    }else if(chessComponents[i][j].name=='P'){
                        counterP+=1;
                    }
                }
            }
            if(counterK!=1){
                sb.append('K'+" "+1+"\n");
            }if(counterQ!=1){
                sb.append('Q'+" "+1+"\n");
            }if(counterR!=2) {
                sb.append('R' + " " +(2-counterR)+"\n");
            }if(counterB!=2) {
                sb.append('B' + " " +(2-counterB)+"\n");
            }if(counterN!=2) {
                sb.append('N' + " " +(2-counterN)+"\n");
            }if(counterP!=8) {
                sb.append('P' + " " +(8-counterP));
            }
        }
        return sb.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent cc=getChess(source.getX(),source.getY());
        if (cc.getChessColor()==ChessColor.NONE){
            return cc.canMoveTo();
        }
        List<ChessboardPoint> cp=cc.canMoveTo();
        List<ChessboardPoint> cp2=new ArrayList<>();
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                for(int a=0;a<cp.size();a++){
                    if(cp.get(a).getX()==i&cp.get(a).getY()==j){
                        cp2.add(cp.get(a));
                    }
                }
            }
        }
        return cp2;
    }

     public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent cc = getChess(sourceX, sourceY);
        if (cc.getChessColor() == ChessColor.NONE) {
            return false;
        }
        if (cc.getChessColor()==currentPlayer){
            for (int i = 0; i < cc.canMoveTo().size(); i++) {
                if (cc.canMoveTo().get(i).getX() == targetX && cc.canMoveTo().get(i).getY() == targetY) {
                    ChessboardPoint tagt=new ChessboardPoint(targetX,targetY);
                    cc.setSource(tagt);
                    chessComponents[targetX][targetY] = cc;
                    chessComponents[targetX][targetY].Board = chessComponents;
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                    chessComponents[sourceX][sourceY].Board = chessComponents;
                    if (currentPlayer==ChessColor.BLACK){
                        currentPlayer=ChessColor.WHITE;
                    }else {
                        currentPlayer=ChessColor.BLACK;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
