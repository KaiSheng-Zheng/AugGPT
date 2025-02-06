import java.util.List;
public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
    }

    public void judge1(int a,int b,char c){
        switch (c){
            case 'R':
                chessComponents[a][b]=new RookChessComponent();
                chessComponents[a][b].name=c;
                chessComponents[a][b].setSource(new ChessboardPoint(a,b));
                chessComponents[a][b].setChessColor(ChessColor.BLACK);
                break;
            case 'N':
                chessComponents[a][b]=new KnightChessComponent();
                chessComponents[a][b].name=c;
                chessComponents[a][b].setSource(new ChessboardPoint(a,b));
                chessComponents[a][b].setChessColor(ChessColor.BLACK);
                break;
            case 'B':
                chessComponents[a][b]=new BishopChessComponent();
                chessComponents[a][b].name=c;
                chessComponents[a][b].setSource(new ChessboardPoint(a,b));
                chessComponents[a][b].setChessColor(ChessColor.BLACK);
                break;
            case 'Q':
                chessComponents[a][b]=new QueenChessComponent();
                chessComponents[a][b].name=c;
                chessComponents[a][b].setSource(new ChessboardPoint(a,b));
                chessComponents[a][b].setChessColor(ChessColor.BLACK);
                break;
            case 'K':
                chessComponents[a][b]=new KingChessComponent();
                chessComponents[a][b].name=c;
                chessComponents[a][b].setSource(new ChessboardPoint(a,b));
                chessComponents[a][b].setChessColor(ChessColor.BLACK);
                break;
            case 'P':
                chessComponents[a][b]=new PawnChessComponent();
                chessComponents[a][b].name=c;
                chessComponents[a][b].setSource(new ChessboardPoint(a,b));
                chessComponents[a][b].setChessColor(ChessColor.BLACK);
                break;
            case 'r':
                chessComponents[a][b]=new RookChessComponent();
                chessComponents[a][b].name=c;
                chessComponents[a][b].setSource(new ChessboardPoint(a,b));
                chessComponents[a][b].setChessColor(ChessColor.WHITE);
                break;
            case 'n':
                chessComponents[a][b]=new KnightChessComponent();
                chessComponents[a][b].name=c;
                chessComponents[a][b].setSource(new ChessboardPoint(a,b));
                chessComponents[a][b].setChessColor(ChessColor.WHITE);
                break;
            case 'b':
                chessComponents[a][b]=new BishopChessComponent();
                chessComponents[a][b].name=c;
                chessComponents[a][b].setSource(new ChessboardPoint(a,b));
                chessComponents[a][b].setChessColor(ChessColor.WHITE);
                break;
            case 'q':
                chessComponents[a][b]=new QueenChessComponent();
                chessComponents[a][b].name=c;
                chessComponents[a][b].setSource(new ChessboardPoint(a,b));
                chessComponents[a][b].setChessColor(ChessColor.WHITE);
                break;
            case 'k':
                chessComponents[a][b]=new KingChessComponent();
                chessComponents[a][b].name=c;
                chessComponents[a][b].setSource(new ChessboardPoint(a,b));
                chessComponents[a][b].setChessColor(ChessColor.WHITE);
                break;
            case 'p':
                chessComponents[a][b]=new PawnChessComponent();
                chessComponents[a][b].name=c;
                chessComponents[a][b].setSource(new ChessboardPoint(a,b));
                chessComponents[a][b].setChessColor(ChessColor.WHITE);
                break;
            case '_':
                chessComponents[a][b]=new EmptySlotComponent();
                chessComponents[a][b].name=c;
                chessComponents[a][b].setSource(new ChessboardPoint(a,b));
                chessComponents[a][b].setChessColor(ChessColor.NONE);
                break;
        }
    }

    public void loadChessGame(List<String> chessboard){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                judge1(i,j,chessboard.get(i).charAt(j));
            }
        }
        if(chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }else if(chessboard.get(8).charAt(0)=='b'){
            currentPlayer=ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder[] sb=new StringBuilder[8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                sb[i].append(chessComponents[i][j].name);
            }
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", sb[0],sb[1],sb[2],sb[3],sb[4],sb[5],sb[6],sb[7]);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] count=new int[6];
        if(player.equals(ChessColor.BLACK)){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    switch (chessComponents[i][j].name){
                        case 'K':count[0]++;break;
                        case 'Q':count[1]++;break;
                        case 'R':count[2]++;break;
                        case 'B':count[3]++;break;
                        case 'N':count[4]++;break;
                        case 'P':count[5]++;break;
                    }
                }
            }
        }else{
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    switch (chessComponents[i][j].name){
                        case 'k':count[0]++;break;
                        case 'q':count[1]++;break;
                        case 'r':count[2]++;break;
                        case 'b':count[3]++;break;
                        case 'n':count[4]++;break;
                        case 'p':count[5]++;break;
                    }
                }
            }
        }
        String[] arrS=new String[6];
        if(count[0]==0){arrS[0]=String.format("K 1\n");}
        if(count[1]==0){arrS[1]=String.format("Q 1\n");}
        if(count[2]==0){arrS[2]=String.format("R 2\n");}else if(count[2]==1){arrS[2]=String.format("R 1\n");}
        if(count[3]==0){arrS[3]=String.format("B 2\n");}else if(count[3]==1){arrS[3]=String.format("B 1\n");}
        if(count[4]==0){arrS[4]=String.format("N 2\n");}else if(count[4]==1){arrS[4]=String.format("N 1\n");}
        if(count[5]!=8){arrS[5]=String.format("P %d",8-count[5]);}
        return arrS[0]+arrS[1]+arrS[2]+arrS[3]+arrS[4]+arrS[5];
    }

    @Override
    public ChessComponent getChess(int x,int y){
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint a){
        return chessComponents[a.getX()][a.getY()].canMoveTo();
    }

    public boolean moveChess(int sourceX,int sourceY,int targetX,int targetY){
        ChessboardPoint source=new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint destination=new ChessboardPoint(targetX,targetY);
        List a=getCanMovePoints(source);
        for(int i=0;i<a.size();i++){
            if(a.get(i).toString().equals(destination.toString())){
                return true;
            }
        }
        return false;
    }

}