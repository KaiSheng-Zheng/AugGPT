import java.util.*;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private String judgeForCurrentColor;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }



    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){

        ChessComponent chess=this.getChess(source.getX(),source.getY());

        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX()==o2.getX()){
                    return o1.getY()-o2.getY();
                }
                else
                    return o1.getX()-o2.getX();
            }
        });
        return canMovePoints;
    }

    

    @Override
    public void loadChessGame(List<String> chessboard){
        this.judgeForCurrentColor=chessboard.get(chessboard.size()-1);
        if(this.judgeForCurrentColor.equals("w")){
            this.currentPlayer=ChessColor.WHITE;
        }
        else if(this.judgeForCurrentColor.equals("b")){
            this.currentPlayer=ChessColor.BLACK;
        }
        String[] chessboards=new String[8];
        for(int i=0;i<8;i++){
            chessboards[i]=chessboard.get(i);
        }
        char[][] chessComponentss=new char[8][8];
        for(int i =0;i<8;i++){
            for(int j=0;j<8;j++){
                chessComponentss[i][j]=(chessboards[i].toCharArray())[j];
                ChessboardPoint source=new ChessboardPoint(i,j);
                if(chessComponentss[i][j]=='p'){
                    PawnChessComponent p=new PawnChessComponent(source, ChessColor.WHITE,'p',chessComponents);
                    this.chessComponents[i][j]=p;
                }
                else if(chessComponentss[i][j]=='P'){
                    PawnChessComponent P=new PawnChessComponent(source, ChessColor.BLACK,'P',chessComponents);
                    this.chessComponents[i][j]=P;
                }
                else if(chessComponentss[i][j]=='n'){
                    KnightChessComponent n=new KnightChessComponent(source, ChessColor.WHITE,'n',chessComponents);
                    this.chessComponents[i][j]=n;
                }
                else if(chessComponentss[i][j]=='N'){
                    KnightChessComponent N=new KnightChessComponent(source, ChessColor.BLACK,'N',chessComponents);
                    this.chessComponents[i][j]=N;
                }
                else if(chessComponentss[i][j]=='k'){
                    KingChessComponent k=new KingChessComponent(source, ChessColor.WHITE,'k',chessComponents);
                    this.chessComponents[i][j]=k;
                }
                else if(chessComponentss[i][j]=='K'){
                    KingChessComponent K=new KingChessComponent(source, ChessColor.BLACK,'K',chessComponents);
                    this.chessComponents[i][j]=K;
                }
                else if(chessComponentss[i][j]=='q'){
                    QueenChessComponent q=new QueenChessComponent(source, ChessColor.WHITE,'q',chessComponents);
                    this.chessComponents[i][j]=q;
                }
                else if(chessComponentss[i][j]=='Q'){
                    QueenChessComponent Q=new QueenChessComponent(source, ChessColor.BLACK,'Q',chessComponents);
                    this.chessComponents[i][j]=Q;
                }
                else if(chessComponentss[i][j]=='r'){
                    RookChessComponent r=new RookChessComponent(source, ChessColor.WHITE,'r',chessComponents);
                    this.chessComponents[i][j]=r;
                }
                else if(chessComponentss[i][j]=='R'){
                    RookChessComponent R=new RookChessComponent(source, ChessColor.BLACK,'R',chessComponents);
                    this.chessComponents[i][j]=R;
                }
                else if(chessComponentss[i][j]=='b'){
                    BishopChessComponent b=new BishopChessComponent(source, ChessColor.WHITE,'b',chessComponents);
                    this.chessComponents[i][j]=b;
                }
                else if(chessComponentss[i][j]=='B'){
                    BishopChessComponent B=new BishopChessComponent(source, ChessColor.BLACK,'B',chessComponents);
                    this.chessComponents[i][j]=B;
                }
                else if(chessComponentss[i][j]=='_'){
                    EmptySlotComponent E=new EmptySlotComponent(source, ChessColor.NONE,'_');
                    this.chessComponents[i][j]=E;
                }

            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph(){
        char[][] name=new char[8][8];
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        StringBuilder s3=new StringBuilder();
        StringBuilder s4=new StringBuilder();
        StringBuilder s5=new StringBuilder();
        StringBuilder s6=new StringBuilder();
        StringBuilder s7=new StringBuilder();
        StringBuilder s8=new StringBuilder();
        for(int i = 0;i<8;i++){
            for(int j=0;j<8;j++){
                name[i][j]= this.chessComponents[i][j].getName();
            }
        }
        for(int i =0;i<8;i++){
            s1.append(name[0][i]);
            s2.append(name[1][i]);
            s3.append(name[2][i]);
            s4.append(name[3][i]);
            s5.append(name[4][i]);
            s6.append(name[5][i]);
            s7.append(name[6][i]);
            s8.append(name[7][i]);
        }
        String s11=s1.toString();
        String s22=s2.toString();
        String s33=s3.toString();
        String s44=s4.toString();
        String s55=s5.toString();
        String s66=s6.toString();
        String s77=s7.toString();
        String s88=s8.toString();
        //returns the chessboard status
        return s11+"\n"+s22+"\n"+s33+"\n"+s44+"\n"+s55+"\n"+s66+"\n"+s77+"\n"+s88+"\n";
    }
    
    public String getCapturedChess(ChessColor player){
        //returns all the chess pieces that are already captured
        StringBuilder total=new StringBuilder();
        int K=0;
        int k=0;
        int Q=0;
        int q=0;
        int R=0;
        int r=0;
        int B=0;
        int b=0;
        int N=0;
        int n=0;
        int P=0;
        int p=0;
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if (this.chessComponents[i][j].toString().equals("K")) {
                    K++;
                }
                if (this.chessComponents[i][j].toString().equals("k")) {
                    k++;
                }
                if (this.chessComponents[i][j].toString().equals("Q")) {
                    Q++;
                }
                if (this.chessComponents[i][j].toString().equals("q")) {
                    q++;
                }
                if (this.chessComponents[i][j].toString().equals("R")) {
                    R++;
                }
                if (this.chessComponents[i][j].toString().equals("r")) {
                    r++;
                }
                if (this.chessComponents[i][j].toString().equals("B")) {
                    B++;
                }
                if (this.chessComponents[i][j].toString().equals("b")) {
                    b++;
                }
                if (this.chessComponents[i][j].toString().equals("N")) {
                    N++;
                }
                if (this.chessComponents[i][j].toString().equals("n")) {
                    n++;
                }
                if (this.chessComponents[i][j].toString().equals("P")) {
                    P++;
                }
                if (this.chessComponents[i][j].toString().equals("p")) {
                    p++;
                }
            }
        }
        if(player.equals(ChessColor.BLACK)){
            if(K!=1){
                total.append("K 1\n");
            }
            if(Q!=1){
                total.append("Q 1\n");
            }
            if(R!=2){
                int difference1=2-R;
                total.append("R "+difference1+"\n");
            }
            if(B!=2){
                int difference3=2-B;
                total.append("B "+difference3+"\n");
            }
            if(N!=2){
                int difference5=2-N;
                total.append("N "+difference5+"\n");
            }
            if(P!=8){
                int difference7=8-P;
                total.append("P "+difference7+"\n");
            }
        }
        else{
            if(k!=1){
                total.append("k 1\n");
            }
            if(q!=1){
                total.append("q 1\n");
            }
            if(r!=2){
                int difference2=2-r;
                total.append("r "+difference2+"\n");
            }
            if(b!=2){
                int difference4=2-b;
                total.append("b "+difference4+"\n");
            }
            if(n!=2){
                int difference6=2-n;
                total.append("n "+difference6+"\n");
            }
            if(p!=8){
                int difference=8-p;
                total.append("p "+difference+"\n");
            }
        }

        return total.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y){
        return this.chessComponents[x][y];
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer)
            return false;
        if(sourceX==targetX&&sourceY==targetY)
            return false;
        ChessboardPoint source=new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target=new ChessboardPoint(targetX,targetY);
        List<ChessboardPoint> cmp=getCanMovePoints(source);
        for(int i=0;i<cmp.size();i++){
            if(cmp.get(i).getX()==targetX&&cmp.get(i).getY()==targetY){
                char name=chessComponents[sourceX][sourceY].getName();
                chessComponents[targetX][targetY] = newChess(target, name);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(target, ChessColor.NONE, '_');
                if (currentPlayer==ChessColor.WHITE)
                    currentPlayer = ChessColor.BLACK;
                else
                    currentPlayer = ChessColor.WHITE;
                return true;
            }
        }
        return false;
    }

    public ChessComponent newChess(ChessboardPoint source, char name){
        if(name=='p'){
            chessComponents[source.getX()][source.getY()] =new PawnChessComponent(source, ChessColor.WHITE,'p',chessComponents);
        }
        else if(name=='P'){
            chessComponents[source.getX()][source.getY()] =new PawnChessComponent(source, ChessColor.BLACK,'P',chessComponents);
        }
        else if(name=='n'){
            chessComponents[source.getX()][source.getY()] =new KnightChessComponent(source, ChessColor.WHITE,'n',chessComponents);
        }
        else if(name=='N'){
            chessComponents[source.getX()][source.getY()]=new KnightChessComponent(source, ChessColor.BLACK,'N',chessComponents);
        }
        else if(name=='k'){
            chessComponents[source.getX()][source.getY()] =new KingChessComponent(source, ChessColor.WHITE,'k',chessComponents);
        }
        else if(name=='K'){
            chessComponents[source.getX()][source.getY()] =new KingChessComponent(source, ChessColor.BLACK,'K',chessComponents);
        }
        else if(name=='q'){
            chessComponents[source.getX()][source.getY()] =new QueenChessComponent(source, ChessColor.WHITE,'q',chessComponents);

        }
        else if(name=='Q'){
            chessComponents[source.getX()][source.getY()] =new  QueenChessComponent(source, ChessColor.BLACK,'Q',chessComponents);
        }
        else if(name=='r'){
            chessComponents[source.getX()][source.getY()] =new RookChessComponent(source, ChessColor.WHITE,'r',chessComponents);
        }
        else if(name=='R'){
            chessComponents[source.getX()][source.getY()] =new RookChessComponent(source, ChessColor.BLACK,'R',chessComponents);
        }
        else if(name=='b'){
            chessComponents[source.getX()][source.getY()] =new BishopChessComponent(source, ChessColor.WHITE,'b',chessComponents);
        }
        else if(name=='B'){
            chessComponents[source.getX()][source.getY()] =new BishopChessComponent(source, ChessColor.BLACK,'B',chessComponents);
        }
        else if(name=='_'){
            chessComponents[source.getX()][source.getY()] =new EmptySlotComponent(source, ChessColor.NONE,'_');
        }
        /*else if(name=='_'){
            ChessComponent origin =new EmptySlotComponent(source, ChessColor.NONE,'_');
        }*/
        return chessComponents[source.getX()][source.getY()];
    }


}
