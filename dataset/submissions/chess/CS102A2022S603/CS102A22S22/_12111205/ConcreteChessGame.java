import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

    public void loadChessGame (List<String> chessboard) {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++) {
                if(chessboard.get(j).charAt(i)=='R') {
                    RookChessComponent a=new RookChessComponent();
                    chessComponents[j][i]=a;
                    chessComponents[j][i].name='R';
                    a.setChessComponents(chessComponents);
                    a.setSource( new ChessboardPoint(i,j) );
                    a.setChessColor(ChessColor.BLACK);
                }
                if(chessboard.get(j).charAt(i)=='r') {
                    RookChessComponent a=new RookChessComponent();
                    chessComponents[j][i]=a;
                    chessComponents[j][i].name='r';
                    a.setChessComponents(chessComponents);
                    a.setSource(new ChessboardPoint(i,j));
                    a.setChessColor(ChessColor.WHITE);
                }
                if(chessboard.get(j).charAt(i)=='B') {
                    BishopChessComponent a=new BishopChessComponent();
                    chessComponents[j][i]=a;
                    chessComponents[j][i].name='B';
                    a.setChessComponents(chessComponents);
                    a.setSource( new ChessboardPoint(i,j) );
                    a.setChessColor(ChessColor.BLACK);
                }
                if(chessboard.get(j).charAt(i)=='b') {
                    BishopChessComponent a=new BishopChessComponent();
                    chessComponents[j][i]=a;
                    chessComponents[j][i].name='b';
                    a.setChessComponents(chessComponents);
                    a.setSource( new ChessboardPoint(i,j) );
                    a.setChessColor(ChessColor.WHITE);
                }
                if(chessboard.get(j).charAt(i)=='Q') {
                    QueenChessComponent a=new QueenChessComponent();
                    chessComponents[j][i]=a;
                    chessComponents[j][i].name='Q';
                    a.setChessComponents(chessComponents);
                    a.setSource( new ChessboardPoint(i,j) );
                    a.setChessColor(ChessColor.BLACK);
                }
                if(chessboard.get(j).charAt(i)=='q') {
                    QueenChessComponent a=new QueenChessComponent();
                    chessComponents[j][i]=a;
                    chessComponents[j][i].name='q';
                    a.setChessComponents(chessComponents);
                    a.setSource( new ChessboardPoint(i,j) );
                    a.setChessColor(ChessColor.WHITE);
                }
                if(chessboard.get(j).charAt(i)=='K') {
                    KingChessComponent a=new KingChessComponent();
                    chessComponents[j][i]=a;
                    chessComponents[j][i].name='K';
                    a.setChessComponents(chessComponents);
                    a.setSource( new ChessboardPoint(i,j) );
                    a.setChessColor(ChessColor.BLACK);
                }
                if(chessboard.get(j).charAt(i)=='k') {
                    KingChessComponent a=new KingChessComponent();
                    chessComponents[j][i]=a;
                    chessComponents[j][i].name='k';
                    a.setChessComponents(chessComponents);
                    a.setSource( new ChessboardPoint(i,j) );
                    a.setChessColor(ChessColor.WHITE);
                }
                if(chessboard.get(j).charAt(i)=='P') {
                    PawnChessComponent a=new PawnChessComponent();
                    chessComponents[j][i]=a;
                    chessComponents[j][i].name='P';
                    a.setUsedTime();
                    a.setChessComponents(chessComponents);
                    a.setSource( new ChessboardPoint(i,j) );
                    a.setChessColor(ChessColor.BLACK);
                }
                if(chessboard.get(j).charAt(i)=='p') {
                    PawnChessComponent a=new PawnChessComponent();
                    chessComponents[j][i]=a;
                    chessComponents[j][i].name='p';
                    a.setUsedTime();
                    a.setChessComponents(chessComponents);
                    a.setSource( new ChessboardPoint(i,j) );
                    a.setChessColor(ChessColor.WHITE);
                }
                if(chessboard.get(j).charAt(i)=='N') {
                    KnightChessComponent a=new KnightChessComponent();
                    chessComponents[j][i]=a;
                    chessComponents[j][i].name='N';
                    a.setChessComponents(chessComponents);
                    a.setSource( new ChessboardPoint(i,j) );
                    a.setChessColor(ChessColor.BLACK);
                }
                if(chessboard.get(j).charAt(i)=='n') {
                    KnightChessComponent a=new KnightChessComponent();
                    chessComponents[j][i]=a;
                    chessComponents[j][i].name='n';
                    a.setChessComponents(chessComponents);
                    a.setSource( new ChessboardPoint(i,j) );
                    a.setChessColor(ChessColor.WHITE);
                }
                if(chessboard.get(j).charAt(i)=='_') {
                    chessComponents[j][i]= new EmptySlotComponent();
                    chessComponents[j][i].setChessColor(ChessColor.NONE);
                    chessComponents[j][i].name='_';
                    chessComponents[j][i].setSource( new ChessboardPoint(i,j) );
                }
            }
        }
        if(chessboard.get(8).charAt(0)=='w') {
            currentPlayer=ChessColor.WHITE;
        }
        if(chessboard.get(8).charAt(0)=='b') {
            currentPlayer=ChessColor.BLACK;
        }
    }


    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    public String[] getStringArr(){
        String[] strings=new String[65];
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    strings[i*8+j]="K";
                }
                if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    strings[i*8+j]="k";
                }
                if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    strings[i*8+j]="Q";
                }
                if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    strings[i*8+j]="q";
                }
                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    strings[i*8+j]="B";
                }
                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    strings[i*8+j]="b";
                }
                if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    strings[i*8+j]="N";
                }
                if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    strings[i*8+j]="n";
                }
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    strings[i*8+j]="R";
                }
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    strings[i*8+j]="r";
                }
                if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    strings[i*8+j]="P";
                }
                if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    strings[i*8+j]="p";
                }
                if(chessComponents[i][j] instanceof EmptySlotComponent){
                    strings[i*8+j]="_";
                }
            }
        }
        if(getCurrentPlayer()==ChessColor.WHITE){
            strings[64]="w";
        }
        if(getCurrentPlayer()==ChessColor.BLACK){
            strings[64]="b";
        }
        return strings;
    }


    public String getChessboardGraph() {
        String[] strings=getStringArr();
        StringBuilder row1=new StringBuilder();
        StringBuilder row2=new StringBuilder();
        StringBuilder row3=new StringBuilder();
        StringBuilder row4=new StringBuilder();
        StringBuilder row5=new StringBuilder();
        StringBuilder row6=new StringBuilder();
        StringBuilder row7=new StringBuilder();
        StringBuilder row8=new StringBuilder();
        for (int k=0;k<8;k++){
            row1.append(strings[k]);
        }
        for (int k=8;k<16;k++){
            row2.append(strings[k]);
        }
        for (int k=16;k<24;k++){
            row3.append(strings[k]);
        }
        for (int k=24;k<32;k++){
            row4.append(strings[k]);
        }
        for (int k=32;k<40;k++){
            row5.append(strings[k]);
        }
        for (int k=40;k<48;k++){
            row6.append(strings[k]);
        }
        for (int k=48;k<56;k++){
            row7.append(strings[k]);
        }
        for (int k=56;k<64;k++){
            row8.append(strings[k]);
        }
        return row1+"\n"+row2+"\n"+row3+"\n"+row4+"\n"+row5+"\n"+row6+"\n"+row7+"\n"+row8+"\n";
    }


    public String getCapturedChess(ChessColor player){
        int Q=1,q=1,K=1,k=1,N=2,n=2,B=2,b=2,R=2,r=2,P=8,p=8;
        for(int i=0;i<getChessboardGraph().length()-1;i++){
            if(getChessboardGraph().charAt(i)=='Q'){
                Q--;
            }
            if(getChessboardGraph().charAt(i)=='q'){
                q--;
            }
            if(getChessboardGraph().charAt(i)=='K'){
                K--;
            }
            if(getChessboardGraph().charAt(i)=='k'){
                k--;
            }
            if(getChessboardGraph().charAt(i)=='N'){
                N--;
            }
            if(getChessboardGraph().charAt(i)=='n'){
                n--;
            }
            if(getChessboardGraph().charAt(i)=='R'){
                R--;
            }
            if(getChessboardGraph().charAt(i)=='r'){
                r--;
            }
            if(getChessboardGraph().charAt(i)=='B'){
                B--;
            }
            if(getChessboardGraph().charAt(i)=='b'){
                b--;
            }
            if(getChessboardGraph().charAt(i)=='P'){
                P--;
            }
            if(getChessboardGraph().charAt(i)=='p'){
                p--;
            }
        }//k,q,b,r,n,p;
        StringBuilder str = new StringBuilder();
        if(player==ChessColor.WHITE){
            if(k>0){
                str.append("k ").append(k).append("\n");
            }
            if(q>0){
                str.append("q ").append(q).append("\n");
            }
            if(r>0){
                str.append("r ").append(r).append("\n");
            }
            if(b>0){
                str.append("b ").append(b).append("\n");
            }

            if(n>0){
                str.append("n ").append(n).append("\n");
            }
            if(p>0){
                str.append("p ").append(p).append("\n");
            }
        }
        if(player==ChessColor.BLACK){
            if(K>0){
                str.append("K ").append(K).append("\n");
            }
            if(Q>0){
                str.append("Q ").append(Q).append("\n");
            }
            if(R>0){
                str.append("R ").append(R).append("\n");
            }
            if(B>0){
                str.append("B ").append(B).append("\n");
            }
            if(N>0){
                str.append("N ").append(N).append("\n");
            }
            if(P>0){
                str.append("P ").append(P).append("\n");
            }
        }
        return str.toString();
    }


    public ChessComponent getChess(int x, int y){
        System.out.println(chessComponents[x][y]);
        return chessComponents[x][y];//y row , x col;
    }


    public List<ChessboardPoint> getCanMovePoints (ChessboardPoint source) {
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        if(chess.canMoveTo()==null){
            return new ArrayList<>();
        }
        else {
            int size = canMovePoints.size();
            ChessboardPoint[] a = new ChessboardPoint[size];
            for (int i = 0; i < size; i++) {
                a[i] = canMovePoints.get(i);
            }
            ChessboardPoint temp;
            for (int i = 1; i < size; i++) {
                for (int j = 0; j < size - i; j++) {
                    if (a[j].getX() > a[j + 1].getX()) {
                        temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    }
                    if (a[j].getX() == a[j + 1].getX() && a[j].getY() > a[j + 1].getY()) {
                        temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    }
                }
            }
            List<ChessboardPoint> canMovePoints1 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                canMovePoints1.add(a[i]);
            }
            return canMovePoints1;
        }
    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean result = false;
        //System.out.println(sourceX+"\n"+sourceY+"\n"+targetX+"\n"+targetY);
        if ((targetX > 7 || targetY > 7 || targetX < 0 || targetY < 0)  || ((targetX==sourceX)&&(targetY==sourceY))) {
            result = false;
        }
        else {
            if (chessComponents[sourceX][sourceY].getChessColor()==currentPlayer ) {
                ChessboardPoint FinalPoint = new ChessboardPoint(targetY,targetX);//FinalPoint : final location;
                //System.out.println(chessComponents[sourceX][sourceY]);
                //System.out.println(chessComponents[targetX][targetY]);
                //System.out.println("FinalPoint"+FinalPoint);
                ChessboardPoint InitialPoint = new ChessboardPoint(sourceY,sourceX);//InitialPoint : origin location;
                //ChessComponent median=chessComponents[targetX][targetY];//median :origin total information
                for ( ChessboardPoint a : chessComponents[sourceX][sourceY].canMoveTo() ) {
                    if ( a.getX() == targetX && a.getY()== targetY ) {
                        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                        chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                        chessComponents[sourceX][sourceY].name='_';
                        chessComponents[targetX][targetY].setSource(FinalPoint);//System.out.println("InitialPoint"+InitialPoint);
                        chessComponents[sourceX][sourceY].setSource(InitialPoint);//swap ;

                        if (currentPlayer == ChessColor.WHITE) {
                            currentPlayer = ChessColor.BLACK;
                        }
                        else if (currentPlayer == ChessColor.BLACK) {
                            currentPlayer = ChessColor.WHITE;
                        }
                        result = true;
                        break;
                    }
                    
                }
            }
            
        }
        return result;
    }
}

