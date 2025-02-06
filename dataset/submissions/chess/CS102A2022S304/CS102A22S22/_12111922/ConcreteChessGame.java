import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.chessComponents[i][j]=chessComponents[i][j];
            }
        }
        if (currentPlayer != ChessColor.NONE){
            this.currentPlayer = currentPlayer;
        }
        else {
            this.currentPlayer = ChessColor.WHITE;
        }
    }

    public ConcreteChessGame(ChessColor currentPlayer){
        this.chessComponents = new ChessComponent[8][8];
        if (currentPlayer != ChessColor.NONE){
            this.currentPlayer = currentPlayer;
        }
        else {
            this.currentPlayer = ChessColor.WHITE;
        }
    }

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint position = new ChessboardPoint(i,j);
                if (chessboard.get(i).charAt(j) == 'K'){
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].name = 'K';
                }
                if (chessboard.get(i).charAt(j) == 'Q'){
                    this.chessComponents[i][j] = new QueenChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].name = 'Q';
                }
                if (chessboard.get(i).charAt(j) == 'R'){
                    this.chessComponents[i][j] = new RookChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].name = 'R';
                }
                if (chessboard.get(i).charAt(j) == 'B'){
                    this.chessComponents[i][j] = new BishopChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].name = 'B';
                }
                if (chessboard.get(i).charAt(j) == 'N'){
                    this.chessComponents[i][j] = new KnightChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].name = 'N';
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    this.chessComponents[i][j] = new PawnChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].name = 'P';
                }
                if (chessboard.get(i).charAt(j) == 'k'){
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].name = 'k';
                }
                if (chessboard.get(i).charAt(j) == 'q'){
                    this.chessComponents[i][j] = new QueenChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].name = 'q';
                }
                if (chessboard.get(i).charAt(j) == 'r'){
                    this.chessComponents[i][j] = new RookChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].name = 'r';
                }
                if (chessboard.get(i).charAt(j) == 'b'){
                    this.chessComponents[i][j] = new BishopChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].name = 'b';
                }
                if (chessboard.get(i).charAt(j) == 'n'){
                    this.chessComponents[i][j] = new KnightChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].name = 'n';
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    this.chessComponents[i][j] = new PawnChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].name = 'p';
                }
                if (chessboard.get(i).charAt(j) == '_'){
                    this.chessComponents[i][j] = new EmptySlotComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.NONE);
                    this.chessComponents[i][j].name = '_';
                }
                chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                chessComponents[i][j].setChessComponents(this.chessComponents);
            }
            if (chessboard.get(8).charAt(0) == 'w'){
                this.currentPlayer = ChessColor.WHITE;
            }
            else {
                this.currentPlayer = ChessColor.BLACK;
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String[] chessboard = new String[9];
        for (int i = 0; i < 8; i++) {
            chessboard[i] = "";
            for (int j = 0; j < 8; j++) {
                if (this.chessComponents[i][j] instanceof KingChessComponent) {
                    chessboard[i] = chessboard[i] + this.chessComponents[i][j].name;
                }
                if (this.chessComponents[i][j] instanceof QueenChessComponent) {
                    chessboard[i] = chessboard[i] + this.chessComponents[i][j].name;
                }
                if (this.chessComponents[i][j] instanceof RookChessComponent) {
                    chessboard[i] = chessboard[i] + this.chessComponents[i][j].name;
                }
                if (this.chessComponents[i][j] instanceof BishopChessComponent) {
                    chessboard[i] = chessboard[i] + this.chessComponents[i][j].name;
                }
                if (this.chessComponents[i][j] instanceof KnightChessComponent) {
                    chessboard[i] = chessboard[i] + this.chessComponents[i][j].name;
                }
                if (this.chessComponents[i][j] instanceof PawnChessComponent) {
                    chessboard[i] = chessboard[i] + this.chessComponents[i][j].name;
                }
                if (this.chessComponents[i][j] instanceof EmptySlotComponent){
                    chessboard[i] = chessboard[i] + this.chessComponents[i][j].name;
                }
            }
        }
        if (this.currentPlayer == ChessColor.WHITE){
            chessboard[8] = "w";
        }
        else {
            chessboard[8] = "b";
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",chessboard[0],chessboard[1],chessboard[2],chessboard[3],chessboard[4],chessboard[5],chessboard[6],chessboard[7]);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if(player == ChessColor.BLACK){
            int K = 0;
            int Q = 0;
            int R = 0;
            int B = 0;
            int N = 0;
            int P = 0;
            StringBuilder Black = new StringBuilder();
            Black.setLength(0);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(this.chessComponents[i][j].name == 'K'){
                        K++;
                    }
                    if(this.chessComponents[i][j].name == 'Q'){
                        Q++;
                    }
                    if(this.chessComponents[i][j].name == 'R'){
                        R++;
                    }
                    if(this.chessComponents[i][j].name == 'B'){
                        B++;
                    }
                    if(this.chessComponents[i][j].name == 'N'){
                        N++;
                    }
                    if(this.chessComponents[i][j].name == 'P'){
                        P++;
                    }
                }
            }
            if (K != 1){
                Black.append("K 1\n");
            }
            if (Q != 1){
                Black.append("Q 1\n");
            }
            if (R != 2){
                Black.append(String.format("R %d\n",2-R));
            }
            if (B != 2){
                Black.append(String.format("B %d\n",2-B));
            }
            if (N != 2){
                Black.append(String.format("N %d\n",2-N));
            }
            if (P != 8){
                Black.append(String.format("P %d\n",8-P));
            }
            return Black.toString();
        }
        else {
            int k = 0;
            int q = 0;
            int r = 0;
            int b = 0;
            int n = 0;
            int p = 0;
            StringBuilder White = new StringBuilder();
            White.setLength(0);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(this.chessComponents[i][j].name == 'k'){
                        k++;
                    }
                    if(this.chessComponents[i][j].name == 'q'){
                        q++;
                    }
                    if(this.chessComponents[i][j].name == 'r'){
                        r++;
                    }
                    if(this.chessComponents[i][j].name == 'b'){
                        b++;
                    }
                    if(this.chessComponents[i][j].name == 'n'){
                        n++;
                    }
                    if(this.chessComponents[i][j].name == 'p'){
                        p++;
                    }
                }
            }
            if (k != 1){
                White.append("k 1\n");
            }
            if (q != 1){
                White.append("q 1\n");
            }
            if (r != 2){
                White.append(String.format("r %d\n",2-r));
            }
            if (b != 2){
                White.append(String.format("b %d\n",2-b));
            }
            if (n != 2){
                White.append(String.format("n %d\n",2-n));
            }
            if (p != 8){
                White.append(String.format("p %d\n",8-p));
            }
            return White.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(),source.getY());
        return chess.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (this.chessComponents[sourceX][sourceY].getChessColor() == this.currentPlayer) {
            if (sourceX <= 7 && sourceY <= 7 && targetX <= 7 && targetX >= 0 && targetY <= 7 && targetY >= 0){
                ChessboardPoint past = new ChessboardPoint(sourceX,sourceY);
                ChessboardPoint now = new ChessboardPoint(targetX,targetY);
                if (getCanMovePoints(past).size() == 0) {
                    return false;
                }
                else {
                    ArrayList<ChessboardPoint> points = new ArrayList<>(getCanMovePoints(past));
                        if (now.contain(points)) {
                            this.chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
                            this.chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            this.chessComponents[sourceX][sourceY].name = '_';
                            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                            chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX, sourceY));
                            chessComponents[targetX][targetY].setChessComponents(this.chessComponents);
                            chessComponents[sourceX][sourceY].setChessComponents(this.chessComponents);
                            chessComponents[targetX][targetY].setChessComponents(this.chessComponents);
                            if (currentPlayer == ChessColor.BLACK) {
                                this.currentPlayer = ChessColor.WHITE;
                            } else {
                                this.currentPlayer = ChessColor.BLACK;
                            }
                            getCapturedChess(this.currentPlayer);
                            return true;
                        } else {
                            return false;
                    }
                }
            }
        }
        return false;
    }

}
