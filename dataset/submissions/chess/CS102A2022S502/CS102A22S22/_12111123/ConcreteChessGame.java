import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer =  ChessColor.WHITE;

    public ConcreteChessGame (){
        chessComponents = new ChessComponent[8][8];
        currentPlayer = getCurrentPlayer();
    }



    public void loadChessGame(List<String> chessboard){
    for (int i = 0; i < 8; i++){
        for (int j = 0; j < 8; j++) {
            switch (chessboard.get(i).charAt(j)){
                case 'k': chessComponents[i][j] = new KingChessComponent
                        (new ChessboardPoint(i,j),ChessColor.WHITE,'k',this.chessComponents );
                    break;
                case 'K': chessComponents[i][j] = new KingChessComponent
                        (new ChessboardPoint(i,j),ChessColor.BLACK,'K',this.chessComponents );
                    break;
                case 'r': chessComponents[i][j] = new RookChessComponent
                        (new ChessboardPoint(i,j),ChessColor.WHITE,'r',this.chessComponents );
                    break;
                case 'R': chessComponents[i][j] = new RookChessComponent
                        (new ChessboardPoint(i,j),ChessColor.BLACK,'R',this.chessComponents );
                    break;
                case 'q': chessComponents[i][j] = new QueenChessComponent
                        (new ChessboardPoint(i,j),ChessColor.WHITE,'q',this.chessComponents );
                    break;
                case 'Q': chessComponents[i][j] = new QueenChessComponent
                        (new ChessboardPoint(i,j),ChessColor.BLACK ,'Q',this.chessComponents );
                    break;
                case 'n': chessComponents[i][j] = new KnightChessComponent
                        (new ChessboardPoint(i,j),ChessColor.WHITE,'n',this.chessComponents );
                    break;
                case 'N': chessComponents[i][j] = new KnightChessComponent
                        (new ChessboardPoint(i,j),ChessColor.BLACK,'N',this.chessComponents );
                    break;
                case 'p': chessComponents[i][j] = new PawnChessComponent
                        (new ChessboardPoint(i,j),ChessColor.WHITE,'p',this.chessComponents );
                    break;
                case 'P': chessComponents[i][j] = new PawnChessComponent
                        (new ChessboardPoint(i,j),ChessColor.BLACK,'P',this.chessComponents );
                    break;
                case 'b': chessComponents[i][j] = new BishopChessComponent
                        (new ChessboardPoint(i,j),ChessColor.WHITE,'b',this.chessComponents );
                    break;
                case 'B': chessComponents[i][j] = new BishopChessComponent
                        (new ChessboardPoint(i,j),ChessColor.BLACK ,'B',this.chessComponents );
                    break;
                case '_': chessComponents[i][j] = new EmptySlotChessComponent
                        (new ChessboardPoint(i,j),ChessColor.NONE,'_',this.chessComponents );
                    break;
            }
    }
}
        if(chessboard.get(8).equals("w") ){
            ChessColor currentPlayer =  ChessColor.WHITE;
            this.currentPlayer = currentPlayer ;
        }
        if(chessboard.get(8).equals("b")){
            ChessColor currentPlayer =  ChessColor.BLACK;
            this.currentPlayer = currentPlayer ;
        }
    }


    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }


    public String getChessboardGraph(){
        String []A = new String[8];
        for (int i = 0; i < 8; i++) {
            A[i] = "";
            for (int j = 0; j < 8; j++) {
                A[i] = A[i] + chessComponents[i][j].name;
            }
        }
        return String.format
                ("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",A[0],A[1],A[2],A[3],A[4],A[5],A[6],A[7]) ;
    }


    public String getCapturedChess(ChessColor player){
        int K = 1;int k = 1;int Q = 1;int q = 1;int P = 8;int p = 8;
        int B = 2;int b = 2;int R = 2;int r = 2;int N = 2;int n = 2;
        String C = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch(chessComponents[i][j].name){
                    case 'K':K = K - 1;
                        break;
                    case 'k':k = k - 1;
                        break;
                    case 'Q':Q = Q - 1;
                        break;
                    case 'q':q = q - 1;
                        break;
                    case 'P':P = P - 1;
                        break;
                    case 'p':p = p - 1;
                        break;
                    case 'B':B = B - 1;
                        break;
                    case 'b':b = b - 1;
                        break;
                    case 'R':R = R - 1;
                        break;
                    case 'r':r = r - 1;
                        break;
                    case 'N':N = N - 1;
                        break;
                    case 'n':n = n - 1;
                        break;
                }
            }
        }
        if(player == ChessColor.WHITE){
            if(k!=0){
                C = C + "k" + " " + k + "\n";
            }
            if(q!=0){
                C = C + "q" + " " + q + "\n";
            }
            if(r!=0){
                C = C + "r" + " " + r + "\n";
            }
            if(b!=0){
                C = C + "b" + " " + b + "\n";
            }
            if(n!=0){
                C = C + "n" + " " + n + "\n";
            }
            if(p!=0){
                C = C + "p" + " " + p + "\n";
            }
        }

        if(player == ChessColor.BLACK){
            if(K!=0){
                C = C + "K" + " " + K + "\n";
            }
            if(Q!=0){
                C = C + "Q" + " " + Q + "\n";
            }
            if(R!=0){
                C = C + "R" + " " + R + "\n";
            }
            if(B!=0){
                C = C + "B" + " " + B + "\n";
            }

            if(N!=0){
                C = C + "N" + " " + N + "\n";
            }
            if(P!=0){
                C = C + "P" + " " + P + "\n";
            }
        }
        return C;
    }


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int a = source.getX();int b = source.getY();
        ChessComponent  fuker = this.chessComponents[a][b];
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint  lover = new ChessboardPoint(i,j) ;
                for (int k = 0; k < fuker.canMoveTo().size() ; k++) {
                    if(i == fuker.canMoveTo().get(k).getX() &&
                    j == fuker.canMoveTo().get(k).getY() ){
                        canMovePoints.add(lover);
                    }
                }
            }
        }
        return canMovePoints;
    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean a = false;
        if (getChess(sourceX, sourceY).getChessColor() == getCurrentPlayer()) {
            if ((sourceX > -1 && sourceX < 8) && (sourceY > -1 && sourceY < 8)) {
                if (this.chessComponents[sourceX][sourceY].canMoveTo().size() != 0) {
                    for (int i = 0; i < this.chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
                        if (this.chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == targetX
                                && this.chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == targetY) {
                            chessComponents[targetX][targetY] = this.chessComponents[sourceX][sourceY];
                            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                            this.chessComponents[sourceX][sourceY] = new EmptySlotChessComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_', this.chessComponents);
                            a = true;
                            if (this.currentPlayer == ChessColor.WHITE) {
                                this.currentPlayer = ChessColor.BLACK;
                            } else if (this.currentPlayer == ChessColor.BLACK) {
                                this.currentPlayer = ChessColor.WHITE;
                            }
                        }
                    }
                }
            }
        }
        return a;
    }
}
