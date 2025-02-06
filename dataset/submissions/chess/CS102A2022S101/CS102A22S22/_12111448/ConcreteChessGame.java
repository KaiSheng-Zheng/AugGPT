import java.util.ArrayList;
import  java.util.List;
//RIGHT:chessColor chessBoardPoint chessComponent

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents ;
    private ChessColor currentPlayer ;


    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                if (i==0){
                    if (j==0 || j==7){
                        chessComponents[i][j]= new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                    }
                    else if (j==1 || j==6){
                        chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                    }
                    else if (j==2 || j==5){
                        chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                    }
                    else if(j==3){
                        chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                    }
                    else {
                        chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                    }
                }
                else if (i==1){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                }
                else if (i==7){
                    if (j==0 || j==7){
                        chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                    }
                    else if (j==1 || j==6){
                        chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                    }
                    else if (j==2 || j==5){
                        chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                    }
                    else if(j==3){
                        chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                    }
                    else {
                        chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                    }
                }
                else if (i==6){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                }
                else {
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }
            }
        }
        ChessComponent.chessComponents=this.chessComponents;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent.chessComponents[i][j]=this.chessComponents[i][j];
            }
        }
    }

    public ConcreteChessGame(ChessColor currentPlayer) {
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        this.currentPlayer = currentPlayer;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i==0){
                    if (j==0 || j==7){
                        this.chessComponents[i][j]= new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                    }
                    else if (j==1 || j==6){
                        this.chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                    }
                    else if (j==2 || j==5){
                        this.chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                    }
                    else if(j==3){
                        this.chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                    }
                    else {
                        this.chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                    }
                }
                else if (i==1){
                    this.chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                }
                else if (i==7){
                    if (j==0 || j==7){
                        this.chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                    }
                    else if (j==1 || j==6){
                        this.chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                    }
                    else if (j==2 || j==5){
                        this.chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                    }
                    else if(j==3){
                        this.chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                    }
                    else {
                        this.chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                    }
                }
                else if (i==6){
                    this.chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                }
                else {
                    this.chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }
            }
        }
        ChessComponent.chessComponents=this.chessComponents;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent.chessComponents[i][j]=this.chessComponents[i][j];
            }
        }
    }


    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char now = chessboard.get(i).charAt(j);
                if (now=='_'){
                    this.chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }
                else if (now == 'R') {
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                }
                else if (now == 'N'){
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                }
                else if (now == 'B') {
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                }
                else if (now == 'P') {
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                }
                else if (now == 'Q') {
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                }
                else if (now=='K'){
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                }
                else if (now == 'r') {
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                }
                else if (now == 'n') {
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                }
                else if (now == 'b') {
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                }
                else if (now == 'p') {
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                }
                else if (now == 'q') {
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                }
                else  {
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                }
            }
        }
        if (chessboard.get(8).equals("w")){
            this.currentPlayer = ChessColor.WHITE;
        }
        else {
            this.currentPlayer = ChessColor.BLACK;
        }
        ChessComponent.chessComponents=this.chessComponents;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent.chessComponents[i][j]=this.chessComponents[i][j];
            }
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].name);
            }
            if (i!=7){
                sb.append("\n");
            }
        }
        String ans=sb.toString();
        return ans;
    }

    public String getCapturedChess(ChessColor player){
        //pieces should be sort by the order of
        //"King>Queen>Rooks>Bishops>Knights>Pawns".
        //R/r=rooks, N/n=knights, B/b=bishops, Q/q=queen, K/k=king, P/p=pawns, _=nothing
        int k=0,q=0,r=0,b=0,n=0,p=0;
        if (player.equals(ChessColor.BLACK)){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name=='R'){++r;}
                    else if (chessComponents[i][j].name=='N'){++n;}
                    else if (chessComponents[i][j].name=='B'){++b;}
                    else if (chessComponents[i][j].name=='Q'){++q;}
                    else if (chessComponents[i][j].name=='K'){++k;}
                    else if (chessComponents[i][j].name=='P'){++p;}
                }
            }
        }
        else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name=='r'){++r;}
                    else if (chessComponents[i][j].name=='n'){++n;}
                    else if (chessComponents[i][j].name=='b'){++b;}
                    else if (chessComponents[i][j].name=='q'){++q;}
                    else if (chessComponents[i][j].name=='k'){++k;}
                    else if (chessComponents[i][j].name=='p'){++p;}
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        if (player.equals(ChessColor.BLACK)){
            //KQRBNP
            if (1-k>0){sb.append("K "+ String.valueOf(1 - k) +"\n");}
            if (1-q>0){sb.append("Q "+ String.valueOf(1 - q) +"\n");}
            if (2-r>0){sb.append("R "+ String.valueOf(2 - r) +"\n");}
            if (2-b>0){sb.append("B "+ String.valueOf(2 - b) +"\n");}
            if (2-n>0){sb.append("N "+ String.valueOf(2 - n) +"\n");}
            if (8-p>0){sb.append("P "+ String.valueOf(8 - p) +"\n");}
        }
        else {
            if (1-k>0){sb.append("k "+ String.valueOf(1 - k) +"\n");}
            if (1-q>0){sb.append("q "+ String.valueOf(1 - q) +"\n");}
            if (2-r>0){sb.append("r "+ String.valueOf(2 - r) +"\n");}
            if (2-b>0){sb.append("b "+ String.valueOf(2 - b) +"\n");}
            if (2-n>0){sb.append("n "+ String.valueOf(2 - n) +"\n");}
            if (8-p>0){sb.append("p "+ String.valueOf(8 - p) +"\n");}
        }

        return sb.toString();
        //???????????????

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x=source.getX();
        int y=source.getY();
        List<ChessboardPoint> input = new ArrayList<>();
        input=chessComponents[source.getX()][source.getY()].canMoveTo();
        List<ChessboardPoint> origin = new ArrayList<>();
        List<ChessboardPoint> ans = new ArrayList<>();
        for (int i = 0; i < chessComponents[x][y].canMoveTo().size(); i++) {
            origin.add(new ChessboardPoint(input.get(i).getX(),input.get(i).getY()));
        }

        int size=origin.size();
        for (int i = 0; i < size; i++) {
            int minX=8,minY=8;
            int minIndex=0;
            // these 2 sentences should be written IN THE CIRCLE
            for (int j = 0; j < origin.size(); j++) {
                if (origin.get(j).getX()<minX){
                    minX=origin.get(j).getX();
                }
            }
            for (int j = 0; j < origin.size(); j++) {
                if (origin.get(j).getX()==minX && origin.get(j).getY()<minY){
                    minY=origin.get(j).getY();
                    minIndex=j;
                }
            }
            ans.add(origin.get(minIndex));
            origin.remove(minIndex);
        }
        return ans;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        //??????????????????????
        //Of course, the current player is not moving another player's pieces.
        List<ChessboardPoint> canMove = chessComponents[sourceX][sourceY].canMoveTo();
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        boolean can=false;
        //if we use .contains we compared the address;
        //the difference between .equal and == only exists in some wapperClass
        if (chessComponents[sourceX][sourceY].getChessColor()!=getCurrentPlayer()){
            return false;
        }
         if (chessComponents[sourceX][sourceY].getChessColor()==ChessColor.NONE){
            return false;
        }
        for (int i = 0; i < canMove.size(); i++) {
            if (canMove.get(i).getX()==target.getX() && canMove.get(i).getY()==target.getY()){
                can=true;
                break;
            }
        }
        if (can){
            if (currentPlayer.equals(ChessColor.BLACK)){
                currentPlayer=ChessColor.WHITE;
            }
            else {
                currentPlayer=ChessColor.BLACK;
            }
            chessComponents[targetX][targetY]=getChess(sourceX,sourceY);
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            //?????????????????????
            chessComponents[sourceX][sourceY]=new EmptySlotComponent
                    (new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent.chessComponents[i][j]=this.chessComponents[i][j];
            }
        }
        return can;
    }

    public ChessComponent getChess(int x, int y){
        return this.chessComponents[x][y];
    }




}
