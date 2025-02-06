import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7 ; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),'_');
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                        break;
                }

            }
        }
        String str = chessboard.get(8);
        if(str.equals("w")){
            setCurrentPlayer(ChessColor.WHITE);
        }
        if(str.equals("b")){
            setCurrentPlayer(ChessColor.BLACK);
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                temp.append(chessComponents[i][j].name);
            }
            temp.append("\n");
        }
        return temp.toString();
    }
    public String getCapturedChess(ChessColor player){
        int[] num = new int[6];
        StringBuilder temp = new StringBuilder();
        if(player == ChessColor.BLACK){
            String[] name = new String[]{"K","Q","R","B","N","P"};
            for (int i = 0; i <= 7 ; i++) {
                for (int j = 0; j <= 7; j++) {
                    if(chessComponents[i][j].name == 'K'){
                        num[0]++;
                    }
                    if(chessComponents[i][j].name == 'Q'){
                        num[1]++;
                    }
                    if(chessComponents[i][j].name == 'R'){
                        num[2]++;
                    }
                    if(chessComponents[i][j].name == 'B'){
                        num[3]++;
                    }
                    if(chessComponents[i][j].name == 'N'){
                        num[4]++;
                    }
                    if(chessComponents[i][j].name == 'P'){
                        num[5]++;
                    }
                }
            }
            for (int i = 0; i <= 1 ; i++) {
                if(num[i] != 1){
                    temp.append(name[i]+" 1\n");
                }
            }
            for (int i = 2; i <= 4; i++) {
                if(num[i] != 2){
                    temp.append(name[i]+" "+(2-num[i])+"\n");
                }
            }
            if(num[5] != 8){
                temp.append(name[5]+" "+(8-num[5])+"\n");
            }
        }if(player == ChessColor.WHITE){
            String[] name = new String[]{"k","q","r","b","n","p"};
            for (int i = 0; i <= 7 ; i++) {
                for (int j = 0; j <= 7; j++) {
                    if(chessComponents[i][j].name == 'k'){
                        num[0]++;
                    }
                    if(chessComponents[i][j].name == 'q'){
                        num[1]++;
                    }
                    if(chessComponents[i][j].name == 'r'){
                        num[2]++;
                    }
                    if(chessComponents[i][j].name == 'b'){
                        num[3]++;
                    }
                    if(chessComponents[i][j].name == 'n'){
                        num[4]++;
                    }
                    if(chessComponents[i][j].name == 'p'){
                        num[5]++;
                    }
                }
            }
            for (int i = 0; i <= 1 ; i++) {
                if(num[i] != 1){
                    temp.append(name[i]+" 1\n");
                }
            }
            for (int i = 2; i <= 4; i++) {
                if(num[i] != 2){
                    temp.append(name[i]+" "+(2-num[i])+"\n");
                }
            }
            if(num[5] != 8){
                temp.append(name[5]+" "+(8-num[5])+"\n");
            }
        }
        return temp.toString();
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        Collections.sort(canMovePoints);
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(chessComponents[sourceX][sourceY].getChessColor() != this.getCurrentPlayer()){
            return false;
        }else {
            if(chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX,targetY))){
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(sourceX,sourceY));
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),'_');
                if(this.currentPlayer == ChessColor.BLACK){
                    setCurrentPlayer(ChessColor.WHITE);
                }else {
                    setCurrentPlayer(ChessColor.BLACK);
                }
                return true;
            }else {
                return false;
            }
        }
    }
}
