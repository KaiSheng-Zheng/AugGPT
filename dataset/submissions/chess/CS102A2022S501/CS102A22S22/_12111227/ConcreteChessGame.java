import java.util.ArrayList;
import java.util.List;


public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if(chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
            }
        }
        if(chessboard.get(8).equals("w")){
            setCurrentPlayer(ChessColor.WHITE);
        }
        if(chessboard.get(8).equals("b")){
            setCurrentPlayer(ChessColor.BLACK);
        }
    }

    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8 ; i++) {
            int j;
            for (j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    if (chessComponents[i][j] instanceof KingChessComponent) {
                        sb.append("K");
                    }
                    if (chessComponents[i][j] instanceof QueenChessComponent) {
                        sb.append("Q");
                    }
                    if (chessComponents[i][j] instanceof RookChessComponent) {
                        sb.append("R");
                    }
                    if (chessComponents[i][j] instanceof BishopChessComponent) {
                        sb.append("B");
                    }
                    if (chessComponents[i][j] instanceof KnightChessComponent) {
                        sb.append("N");
                    }
                    if (chessComponents[i][j] instanceof PawnChessComponent) {
                        sb.append("P");
                    }
                }
                if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    if (chessComponents[i][j] instanceof KingChessComponent) {
                        sb.append("k");
                    }
                    if (chessComponents[i][j] instanceof QueenChessComponent) {
                        sb.append("q");
                    }
                    if (chessComponents[i][j] instanceof RookChessComponent) {
                        sb.append("r");
                    }
                    if (chessComponents[i][j] instanceof BishopChessComponent) {
                        sb.append("b");
                    }
                    if (chessComponents[i][j] instanceof KnightChessComponent) {
                        sb.append("n");
                    }
                    if (chessComponents[i][j] instanceof PawnChessComponent) {
                        sb.append("p");
                    }
                }
                if (chessComponents[i][j].getChessColor() == ChessColor.NONE) {
                    sb.append("_");
                }
            }
            if (!(i == 7 && j == 7)){
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String getCapturedChess(ChessColor player){
        StringBuilder sb = new StringBuilder();
        StringBuilder sw = new StringBuilder();
        ArrayList<Integer> numb = new ArrayList<>();
        numb.add(1);
        numb.add(1);
        numb.add(2);
        numb.add(2);
        numb.add(2);
        numb.add(8);
        ArrayList<Integer> numw = new ArrayList<>();
        numw.add(1);
        numw.add(1);
        numw.add(2);
        numw.add(2);
        numw.add(2);
        numw.add(8);
        String[] chessb = new String[]{"K","Q","R","B","N","P"};
        String[] chessw = new String[]{"k","q","r","b","n","p"};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                    if(chessComponents[i][j] instanceof KingChessComponent){
                        numb.set(0,numb.get(0)-1);
                    }
                    if(chessComponents[i][j] instanceof QueenChessComponent){
                        numb.set(1,numb.get(1)-1);
                    }
                    if(chessComponents[i][j] instanceof RookChessComponent){
                        numb.set(2,numb.get(2)-1);
                    }
                    if(chessComponents[i][j] instanceof BishopChessComponent){
                        numb.set(3,numb.get(3)-1);
                    }
                    if(chessComponents[i][j] instanceof KnightChessComponent){
                        numb.set(4,numb.get(4)-1);
                    }
                    if(chessComponents[i][j] instanceof PawnChessComponent){
                        numb.set(5,numb.get(5)-1);
                    }
                }
                if(chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                    if(chessComponents[i][j] instanceof KingChessComponent){
                        numw.set(0,numw.get(0)-1);
                    }
                    if(chessComponents[i][j] instanceof QueenChessComponent){
                        numw.set(1,numw.get(1)-1);
                    }
                    if(chessComponents[i][j] instanceof RookChessComponent){
                        numw.set(2,numw.get(2)-1);
                    }
                    if(chessComponents[i][j] instanceof BishopChessComponent){
                        numw.set(3,numw.get(3)-1);
                    }
                    if(chessComponents[i][j] instanceof KnightChessComponent){
                        numw.set(4,numw.get(4)-1);
                    }
                    if(chessComponents[i][j] instanceof PawnChessComponent){
                        numw.set(5,numw.get(5)-1);
                    }
                }
            }
        }
        if(player == ChessColor.BLACK) {
            for (int i = 0; i < 6 ; i++) {
                if(numb.get(i) != 0){
                    sb.append(String.format("%s %d\n",chessb[i],numb.get(i)));
                }
            }
            return sb.toString();
        }
        else {
            for (int i = 0; i < 6 ; i++) {
                if(numw.get(i) != 0){
                    sw.append(String.format("%s %d\n",chessw[i],numw.get(i)));
                }
            }
            return sw.toString();
        }
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(chessComponents[sourceX][sourceY].getChessColor() != getCurrentPlayer()){
            return false;
        }else {
            boolean canMove = false;
            for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
                if(chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == targetX && chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == targetY){
                    canMove = true;
                }
            }
            if(canMove){
                if(getCurrentPlayer() == ChessColor.BLACK){
                    setCurrentPlayer(ChessColor.WHITE);
                }else {
                    setCurrentPlayer(ChessColor.BLACK);
                }
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(chessComponents[targetX][targetY].getSource().getX(), chessComponents[targetX][targetY].getSource().getY()),ChessColor.NONE,'_');
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                return true;
            }else {
                return false;
            }
        }
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        for (int i = 0; i < canMovePoints.size() - 1; i++) {
            for (int j = 0; j < canMovePoints.size() - i - 1; j++) {
                if(canMovePoints.get(j).getY() > canMovePoints.get(j+1).getY()){
                    ChessboardPoint chess = canMovePoints.get(j);
                    canMovePoints.set(j,canMovePoints.get(j+1));
                    canMovePoints.set(j+1,chess);
                }
            }
        }
        for (int i = 0; i < canMovePoints.size() - 1; i++) {
            for (int j = 0; j < canMovePoints.size() - i - 1; j++) {
                if(canMovePoints.get(j).getX() > canMovePoints.get(j+1).getX()){
                    ChessboardPoint chess = canMovePoints.get(j);
                    canMovePoints.set(j,canMovePoints.get(j+1));
                    canMovePoints.set(j+1,chess);
                }
            }
        }
        return canMovePoints;
    }
}
