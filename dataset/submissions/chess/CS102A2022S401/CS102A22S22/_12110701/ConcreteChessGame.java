import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent();
                    chessComponents[i][j].setP(chessComponents);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setName('R');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if(chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent();
                    chessComponents[i][j].setP(chessComponents);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('r');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));}
                if(chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].setP(chessComponents);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setName('N');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    }
                if(chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].setP(chessComponents);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('n');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if(chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent();
                    chessComponents[i][j].setP(chessComponents);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setName('B');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if(chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent();
                    chessComponents[i][j].setP(chessComponents);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('b');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if(chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent();
                    chessComponents[i][j].setP(chessComponents);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setName('Q');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if(chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent();
                    chessComponents[i][j].setP(chessComponents);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('q');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if(chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent();
                    chessComponents[i][j].setP(chessComponents);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setName('K');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if(chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent();
                    chessComponents[i][j].setP(chessComponents);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('k');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if(chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent();
                    chessComponents[i][j].setP(chessComponents);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setName('P');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if(chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent();
                    chessComponents[i][j].setP(chessComponents);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('p');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent();
                    chessComponents[i][j].setP(chessComponents);
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                    chessComponents[i][j].setName('_');
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
            }
        }
        if(chessboard.get(8).charAt(0)=='b'){
            this.currentPlayer=ChessColor.BLACK;
        }
        if(chessboard.get(8).charAt(0)=='w'){
            this.currentPlayer=ChessColor.WHITE;
        }

    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer; }


    public String getChessboardGraph(){
        String output="";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                output=output.concat(String.valueOf(chessComponents[i][j].getName()));
            }
//            if (i<=6) {
               output = output.concat("\n");
//            }
        }
        return output;
    }

    public String getCapturedChess(ChessColor player){
        String str="";
        if(player==ChessColor.WHITE){
            int k=0; int q=0; int r=0; int b=0; int n=0; int p=0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j].getName()=='r'){
                       r=r+1;
                    }
                    if(chessComponents[i][j].getName()=='k'){
                        k=k+1;
                    }
                    if(chessComponents[i][j].getName()=='q'){
                        q=q+1;
                    }
                    if(chessComponents[i][j].getName()=='b'){
                        b=b+1;
                    }
                    if(chessComponents[i][j].getName()=='p'){
                        p=p+1;
                    }
                    if(chessComponents[i][j].getName()=='n'){
                        n=n+1;
                    }
                }
            }
            if (1-k!=0){str=str.concat("k "+(1-k)+"\n");}
            if (1-q!=0){str=str.concat("q "+(1-q)+"\n");}
            if (2-r!=0){str=str.concat("r "+(2-r)+"\n");}
            if (2-b!=0){str=str.concat("b "+(2-b)+"\n");}
            if (2-n!=0){str=str.concat("n "+(2-n)+"\n");}
            if (8-p!=0){str=str.concat("p "+(8-p)+"\n");}
        }
        if(player==ChessColor.BLACK) {
            int K = 0;
            int Q = 0;
            int R = 0;
            int B = 0;
            int N = 0;
            int P = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'R') {
                        R = R + 1;
                    }
                    if (chessComponents[i][j].getName() == 'K') {
                        K = K + 1;
                    }
                    if (chessComponents[i][j].getName() == 'Q') {
                        Q = Q + 1;
                    }
                    if (chessComponents[i][j].getName() == 'B') {
                        B = B + 1;
                    }
                    if (chessComponents[i][j].getName() == 'P') {
                        P = P + 1;
                    }
                    if (chessComponents[i][j].getName() == 'N') {
                        N = N + 1;
                    }
                }
            }
            if (1-K!=0){str=str.concat("K "+(1-K)+"\n");}
            if (1-Q!=0){str=str.concat("Q "+(1-Q)+"\n");}
            if (2-R!=0){str=str.concat("R "+(2-R)+"\n");}
            if (2-B!=0){str=str.concat("B "+(2-B)+"\n");}
            if (2-N!=0){str=str.concat("N "+(2-N)+"\n");}
            if (8-P!=0){str=str.concat("P "+(8-P)+"\n");}
        }
        return str;
    }
    public ChessComponent getChess(int x, int y){
        return this.chessComponents[x][y];
    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        List<ChessboardPoint>chessboardPointList= chessComponents[sourceX][sourceY].canMoveTo();
        if (chessboardPointList.size()==0){
            return false;
        }else {
        if (getCurrentPlayer()==ChessColor.BLACK){
            if (can(chessboardPointList,targetX,targetY)&&chessComponents[sourceX][sourceY].getChessColor()==ChessColor.BLACK){
                if (chessComponents[sourceX][sourceY].getName()=='K'){
                    chessComponents[targetX][targetY]=new KingChessComponent();
                    chessComponents[targetX][targetY].setName('K');
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
                    chessComponents[targetX][targetY].setP(chessComponents);
                }
                if (chessComponents[sourceX][sourceY].getName()=='Q'){
                    chessComponents[targetX][targetY]=new QueenChessComponent();
                    chessComponents[targetX][targetY].setName('Q');
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
                    chessComponents[targetX][targetY].setP(chessComponents);
                }
                if (chessComponents[sourceX][sourceY].getName()=='N'){
                    chessComponents[targetX][targetY]=new KnightChessComponent();
                    chessComponents[targetX][targetY].setName('N');
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
                    chessComponents[targetX][targetY].setP(chessComponents);
                }
                if (chessComponents[sourceX][sourceY].getName()=='P'){
                    chessComponents[targetX][targetY]=new PawnChessComponent();
                    chessComponents[targetX][targetY].setName('P');
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
                    chessComponents[targetX][targetY].setP(chessComponents);
                }
                if (chessComponents[sourceX][sourceY].getName()=='B'){
                    chessComponents[targetX][targetY]=new BishopChessComponent();
                    chessComponents[targetX][targetY].setName('B');
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
                    chessComponents[targetX][targetY].setP(chessComponents);
                }
                if (chessComponents[sourceX][sourceY].getName()=='R'){
                    chessComponents[targetX][targetY]=new RookChessComponent();
                    chessComponents[targetX][targetY].setName('R');
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
                    chessComponents[targetX][targetY].setP(chessComponents);
                }
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setName('_');
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                chessComponents[targetX][targetY].setP(chessComponents);
                SwitchPlayer();
                return true;
            }else return false;
        }
        if (getCurrentPlayer()==ChessColor.WHITE){
            if (can(chessboardPointList,targetX,targetY)&&chessComponents[sourceX][sourceY].getChessColor()==ChessColor.WHITE){
                if (chessComponents[sourceX][sourceY].getName()=='k'){
                    chessComponents[targetX][targetY]=new KingChessComponent();
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
                    chessComponents[targetX][targetY].setName('k');
                    chessComponents[targetX][targetY].setP(chessComponents);
                }
                if (chessComponents[sourceX][sourceY].getName()=='q'){
                    chessComponents[targetX][targetY]=new QueenChessComponent();
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
                    chessComponents[targetX][targetY].setName('q');
                    chessComponents[targetX][targetY].setP(chessComponents);
                }
                if (chessComponents[sourceX][sourceY].getName()=='n'){
                    chessComponents[targetX][targetY]=new KnightChessComponent();
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
                    chessComponents[targetX][targetY].setName('n');
                    chessComponents[targetX][targetY].setP(chessComponents);
                }
                if (chessComponents[sourceX][sourceY].getName()=='p'){
                    chessComponents[targetX][targetY]=new PawnChessComponent();
                    chessComponents[targetX][targetY].setName('p');
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
                    chessComponents[targetX][targetY].setP(chessComponents);
                }
                if (chessComponents[sourceX][sourceY].getName()=='b'){
                    chessComponents[targetX][targetY]=new BishopChessComponent();
                    chessComponents[targetX][targetY].setName('b');
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
                    chessComponents[targetX][targetY].setP(chessComponents);
                }
                if (chessComponents[sourceX][sourceY].getName()=='r'){
                    chessComponents[targetX][targetY]=new RookChessComponent();
                    chessComponents[targetX][targetY].setName('r');
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
                    chessComponents[targetX][targetY].setP(chessComponents);
                }
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                chessComponents[sourceX][sourceY].setName('_');
                chessComponents[targetX][targetY].setP(chessComponents);
                SwitchPlayer();
                return true;
            }else return false;
        }
        }
        return true;
    }
    public boolean can(List<ChessboardPoint> m,int x,int y){
        for (ChessboardPoint chessboardPoint : m) {
            if (chessboardPoint.getX() == x && chessboardPoint.getY() == y) {
                return true;
            }
        }
        return false;
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint>canMovePoints=chessComponents[source.getX()][source.getY()].canMoveTo();
        ChessboardPoint temp;
        for (int i = 0; i < canMovePoints.size()-1; i++) {
            for (int j = 0; j <canMovePoints.size()-i-1 ; j++) {
                if (canMovePoints.get(j).getX()>canMovePoints.get(j+1).getX()){
                    temp=canMovePoints.get(j);
                    canMovePoints.set(j,canMovePoints.get(j+1));
                    canMovePoints.set(j+1,temp);
                }
            }
        }
        for (int i = 0; i < canMovePoints.size()-1; i++) {
            for (int j = 0; j <canMovePoints.size()-i-1 ; j++) {
                if (canMovePoints.get(j).getX()==canMovePoints.get(j+1).getX()) {
                    if (canMovePoints.get(j).getY() > canMovePoints.get(j + 1).getY()) {
                        temp = canMovePoints.get(j);
                        canMovePoints.set(j, canMovePoints.get(j + 1));
                        canMovePoints.set(j + 1, temp);
                    }
                };
            }
        }
        return canMovePoints;
    }
    public void SwitchPlayer(){
        if (currentPlayer==ChessColor.BLACK){
            this.currentPlayer=ChessColor.WHITE;
        }
        else {
            this.currentPlayer=ChessColor.BLACK;
        }
    }
}