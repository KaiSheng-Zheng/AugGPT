import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {
    }

    public void loadChessGame(List<String> chessboard) {
        if(chessboard.get(8).charAt(0)=='w'){
            currentPlayer = ChessColor.WHITE;
        }
        else{
            currentPlayer = ChessColor.BLACK;
        }
        char[][] name = new char[8][8];
        for(int i = 0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                name[i][j]=chessboard.get(i).charAt(j);
                switch (name[i][j]){
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK,name[i][j],new ChessboardPoint(i,j));
                        chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK,name[i][j],new ChessboardPoint(i,j));
                        chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK,name[i][j],new ChessboardPoint(i,j));
                        chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK,name[i][j],new ChessboardPoint(i,j));
                        chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK,name[i][j],new ChessboardPoint(i,j));
                        chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK,name[i][j],new ChessboardPoint(i,j));
                        chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE,name[i][j],new ChessboardPoint(i,j));
                        chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE,name[i][j],new ChessboardPoint(i,j));
                        chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE,name[i][j],new ChessboardPoint(i,j));
                        chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE,name[i][j],new ChessboardPoint(i,j));
                        chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE,name[i][j],new ChessboardPoint(i,j));
                        chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE,name[i][j],new ChessboardPoint(i,j));
                        chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    default:
                        chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE,name[i][j],new ChessboardPoint(i,j));
                        chessComponents[i][j].setChessBoard(this.chessComponents);
                }
            }
        }
    }

    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        String[] graph= new String[8];
        for(int i = 0;i<8;i++){
            graph[i] = "";
            for(int j = 0;j<8;j++){
                graph[i] += String.valueOf(chessComponents[i][j].name);
            }
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",graph[0],graph[1],graph[2],graph[3],
                graph[4],graph[5],graph[6],graph[7]);
    }

    public String getNumber(String o, char d,int cnt){
        int i;
        for(i = 0;i<o.length();i++){
            if(d==o.charAt(i)){
                cnt--;
            }
        }
        return String.valueOf(cnt);
    }
    public String getCapturedChess(ChessColor player){
        if(player == ChessColor.BLACK) {
            String str = "";
            String[] cnt = new String[6];
            String[] letter = {"K","Q","R","B","N","P"};
            cnt[2] = getNumber(getChessboardGraph(), 'R', 2);
            cnt[4] = getNumber(getChessboardGraph(), 'N', 2);
            cnt[3] = getNumber(getChessboardGraph(), 'B', 2);
            cnt[1] = getNumber(getChessboardGraph(), 'Q', 1);
            cnt[0] = getNumber(getChessboardGraph(), 'K', 1);
            cnt[5] = getNumber(getChessboardGraph(), 'P', 8);
            for (int i = 0; i < 6; i++) {
                if (!cnt[i].equals("0")) {
                    str += letter[i] + " " +cnt[i] + "\n";
                }
            }
            return str;
        }
        else{
            String str = "";
            String[] cnt = new String[6];
            String[] letter = {"k","q","r","b","n","p"};
            cnt[2] = getNumber(getChessboardGraph(), 'r', 2);
            cnt[4] = getNumber(getChessboardGraph(), 'n', 2);
            cnt[3] = getNumber(getChessboardGraph(), 'b', 2);
            cnt[1] = getNumber(getChessboardGraph(), 'q', 1);
            cnt[0] = getNumber(getChessboardGraph(), 'k', 1);
            cnt[5] = getNumber(getChessboardGraph(), 'p', 8);
            for (int i = 0; i < 6; i++) {
                if (!cnt[i].equals("0")) {
                    str += letter[i] + " "+cnt[i] + "\n";
                }
            }
            return str;
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int a = 0;
        ChessComponent chessComponent = chessComponents[sourceX][sourceY];
            if (chessComponent.getChessColor() == this.currentPlayer) {
                for (int i = 0; i < chessComponent.canMoveTo().size(); i++) {
                    if (chessComponent.canMoveTo().get(i).getX() == targetX && chessComponent.canMoveTo().get(i).getY() == targetY) {
                        chessComponents[targetX][targetY] = chessComponent;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, '_', new ChessboardPoint(sourceX, sourceY));
                        chessComponent.setSource(new ChessboardPoint(targetX, targetY));
                        currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
                        a = 1;
                        break;
                    }
                    else{
                        a = 0;
                    }
                }
                if(a == 1){
                    return true;
                }
                else{
                    return false;
                }
            }
            else {
                return false;
            }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chessComponent = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chessComponent.canMoveTo();
        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX() > o2.getX()){
                    return 1;
                }
                else if(o1.getX() < o2.getX()){
                    return -1;
                }
                else{
                    if(o1.getY() > o2.getY()){
                        return 1;
                    }
                    else if(o1.getY() < o2.getY()){
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            }
        });
        return canMovePoints;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

}
