import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents ;
    private ChessColor currentPlayer;

    public static ChessComponent[][] chessComponent;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }
    public  ChessComponent[][] getChessComponents(){
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    public void setChessComponent(ChessComponent[][] chessComponents){
        chessComponent=chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint chessboardPoint = new ChessboardPoint(i,j);

                if(chessboard.get(i).charAt(j)=='k'||chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setSource(chessboardPoint);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    if(chessboard.get(i).charAt(j)=='k'){
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    }else{
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    }
                }else if(chessboard.get(i).charAt(j)=='q'||chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setSource(chessboardPoint);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    if(chessboard.get(i).charAt(j)=='q'){
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    }else{
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    }

                }else if(chessboard.get(i).charAt(j)=='r'||chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setSource(chessboardPoint);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    if(chessboard.get(i).charAt(j)=='r'){
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    }else{
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    }

                }else if(chessboard.get(i).charAt(j)=='b'||chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setSource(chessboardPoint);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    if(chessboard.get(i).charAt(j)=='b'){
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    }else{
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    }

                }else if(chessboard.get(i).charAt(j)=='n'||chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setSource(chessboardPoint);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    if(chessboard.get(i).charAt(j)=='n'){
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    }else{
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    }

                }else if(chessboard.get(i).charAt(j)=='p'||chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setSource(chessboardPoint);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    if(chessboard.get(i).charAt(j)=='p'){
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    }else{
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    }

                }else{
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setSource(chessboardPoint);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                }
            }
        }
     

        if(chessboard.get(8).charAt(0)=='w'){
            this.currentPlayer=ChessColor.WHITE;
        }else{
            this.currentPlayer=ChessColor.BLACK;
        }
           setChessComponents(chessComponents);
        setChessComponent(chessComponents);
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer; }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                str.append(chessComponents[i][j].name);
            }
            list.add(i, str.toString());
        }
            StringBuilder str1 = new StringBuilder();
            for (int j = 0; j < 7; j++) {
                str1.append(list.get(j));
                str1.append("\n");
            }
            str1.append(list.get(7));
        return str1.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder str = new StringBuilder();
                if(player==ChessColor.WHITE){
            int k = 1;
            int q = 1;
            int r = 2;
            int b = 2;
            int n = 2;
            int p = 8;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j].name=='k'){
                        k--;
                    }else if(chessComponents[i][j].name=='q'){
                        q--;
                    }else if(chessComponents[i][j].name=='b'){
                        b--;
                    }else if(chessComponents[i][j].name=='n'){
                        n--;
                    }else if(chessComponents[i][j].name=='r'){
                        r--;
                    }else if(chessComponents[i][j].name=='p'){
                        p--;
                    }
                }
            }

            if(k!=0){
                str.append("k 1\n");
            }if(q!=0){
                str.append("q 1\n");
            } if(r>0){
                str.append("r "+r+"\n");
            } if (b>0){
                str.append("b "+b+"\n");
            } if(n>0){
                str.append("n "+n+"\n");
            } if(p>0){
                str.append("p "+p+"\n");
            }

        }else{
            int K = 1;
            int Q = 1;
            int B = 2;
            int N = 2;
            int R = 2;
            int P = 8;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j].name=='K'){
                        K--;
                    }else if(chessComponents[i][j].name=='Q'){
                        Q--;
                    }else if(chessComponents[i][j].name=='B'){
                        B--;
                    }else if(chessComponents[i][j].name=='N'){
                        N--;
                    }else if(chessComponents[i][j].name=='R'){
                        R--;
                    }else if(chessComponents[i][j].name=='P'){
                        P--;
                    }
                }
            }

            if(K!=0){
                str.append("K 1\n");
            }if(Q!=0){
                str.append("Q 1\n");
            } if(R >0){
                str.append("R "+R+"\n");
            } if (B>0){
                str.append("B "+B+"\n");
            } if(N>0){
                str.append("N "+N+"\n");
            } if(P>0){
                str.append("P "+P+"\n");
            }

        }
        return str.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return getChess(source.getX(),source.getY()).canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        List<ChessboardPoint> list = getCanMovePoints(source);
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);

        boolean b1 = false;
        if(list.size()!=0){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getX() == target.getX() && list.get(i).getY() == target.getY()) {
                b1 = true;
                break;
            }
        }
        }

        boolean b2 = false;
        if(getCurrentPlayer()==getChess(sourceX,sourceY).getChessColor()&& b1){
            if(getChess(sourceX,sourceY).getChessColor()==ChessColor.WHITE){
                setCurrentPlayer(ChessColor.BLACK);
            }else if(getChess(sourceX,sourceY).getChessColor()==ChessColor.BLACK){
                setCurrentPlayer(ChessColor.WHITE);
            }
            b2 = true;

            ChessboardPoint point = new ChessboardPoint(targetX,targetY);
            chessComponents[targetX][targetY] = getChess(sourceX,sourceY);
            chessComponents[targetX][targetY].setSource(point);
            chessComponent[targetX][targetY] = getChess(sourceX,sourceY);
            chessComponent[targetX][targetY].setSource(point);


            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
            chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
            chessComponents[sourceX][sourceY].setName('_');

            chessComponent[sourceX][sourceY] = new EmptySlotComponent();
            chessComponent[sourceX][sourceY].setChessColor(ChessColor.NONE);
            chessComponent[sourceX][sourceY].setName('_');




        }

        return b2;
    }
}
