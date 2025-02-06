import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private List<String>chessboard;

    public ConcreteChessGame() {
        this.chessComponents =new ChessComponent[8][8] ;
        this.currentPlayer=ChessColor.WHITE;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void loadChessGame(List<String> chessboard){
        this.chessboard=chessboard;
        if(chessboard.get(8).equals("b")){
            currentPlayer=ChessColor.BLACK;
        }
        else if(chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent();
                    chessComponents[i][j].setName('_');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                else if(chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setName('K');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                else if(chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setName('k');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                else if(chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setName('Q');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                else if(chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setName('q');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                else if(chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setName('B');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                else if(chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setName('b');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                else if(chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setName('N');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                else if(chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setName('n');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                else if(chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setName('R');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                else if(chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setName('r');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                else if(chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setName('P');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                else if(chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setName('p');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));

                }
            }
        }
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        String str="";
        int i=0;
        for(;i<7;i++){
            str=str.concat(chessboard.get(i)).concat("\n");
        }
        str=str.concat(chessboard.get(i));
        return str;
    }
    public String getCapturedChess(ChessColor player){
        String str="";
        int K=0,Q=0,B=0,N=0,R=0,P=0,k=0,q=0,b=0,n=0,r=0,p=0;
        if(player==ChessColor.BLACK){
            for(int i=0;i<8;i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j]instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        K++;
                    }
                    else if(chessComponents[i][j]instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        Q++;
                    }
                    else if(chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        B++;
                    }
                    else if(chessComponents[i][j]instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        N++;
                    }
                    else if(chessComponents[i][j]instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        R++;
                    }
                    else if(chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        P++;
                    }
                }
            }
            if(K<1){
                str=str.concat("K 1\n");
            }
            if(Q<1){
                str=str.concat("Q 1\n");
            }
            if(R<2){
                str=str.concat("R "+(2-R)+"\n");
            }
            if(B<2){
                str=str.concat("B "+(2-B)+"\n");
            }
            if(N<2){
                str=str.concat("N "+(2-N)+"\n");
            }
            if(P<8){
                str=str.concat("P "+(8-P)+"\n");
            }
            return str;
        }
        else{
            for(int i=0;i<8;i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j]instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        k++;
                    }
                    else if(chessComponents[i][j]instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        q++;
                    }
                    else if(chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        b++;
                    }
                    else if(chessComponents[i][j]instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        n++;
                    }
                    else if(chessComponents[i][j]instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        r++;
                    }
                    else if(chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        p++;
                    }
                }
            }
            if(k<1){
                str=str.concat("k 1\n");
            }
            if(q<1){
                str=str.concat("q 1\n");
            }
            if(r<2){
                str=str.concat("r "+(2-r)+"\n");
            }
            if(b<2){
                str=str.concat("b "+(2-b)+"\n");
            }
            if(n<2){
                str=str.concat("n "+(2-n)+"\n");
            }
            if(p<8){
                str=str.concat("p "+(8-p)+"\n");
            }
            return str;
        }
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
            for(int i=0;i<chessComponents[sourceX][sourceY].canMoveTo().size();i++){
                if(chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==targetX&&chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==targetY){
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                    for(int k=0;k<8;k++) {
                        for (int j = 0; j < 8; j++) {
                            chessComponents[k][j].setChessComponents(chessComponents);
                        }
                    }
                    if(chessComponents[targetX][targetY]instanceof PawnChessComponent){
                        chessComponents[targetX][targetY].setCnt(chessComponents[targetX][targetY].getCnt()+1);
                    }
                    if(currentPlayer.equals(ChessColor.BLACK)){
                        setCurrentPlayer(ChessColor.WHITE);
                    }
                    else {
                        setCurrentPlayer(ChessColor.BLACK);
                    }
                    return true;
                }
            }
            return false;
        }
        else {
            return false;
        }
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
            return chessComponents[source.getX()][source.getY()].canMoveTo();
    }
}
