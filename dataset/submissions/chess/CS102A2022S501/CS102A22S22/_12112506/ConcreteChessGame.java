import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard){
        int listLength=chessboard.size();
        for(int i=0;i<listLength;i++){
            String str=chessboard.get(i);
            int len=str.length();
            if(len>5){
                for(int j=0;j<len;j++){
                    if(str.charAt(j)=='_'){
                        chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),
                                ChessColor.NONE,chessComponents);
                    }
                    else if(str.charAt(j)=='P'){
                        chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),
                                ChessColor.BLACK,chessComponents);
                    }
                    else if(str.charAt(j)=='p'){
                        chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),
                                ChessColor.WHITE,chessComponents);
                    }
                    else if(str.charAt(j)=='Q'){
                        chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),
                                ChessColor.BLACK,chessComponents);
                    }
                    else if(str.charAt(j)=='q'){
                        chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),
                                ChessColor.WHITE,chessComponents);
                    }
                    else if(str.charAt(j)=='K'){
                        chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),
                                ChessColor.BLACK,chessComponents);
                    }
                    else if(str.charAt(j)=='k'){
                        chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),
                                ChessColor.WHITE,chessComponents);
                    }
                    else if(str.charAt(j)=='B'){
                        chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),
                                ChessColor.BLACK,chessComponents);
                    }
                    else if(str.charAt(j)=='b'){
                        chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),
                                ChessColor.WHITE,chessComponents);
                    }
                    else if(str.charAt(j)=='N'){
                        chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),
                                ChessColor.BLACK,chessComponents);
                    }
                    else if(str.charAt(j)=='n'){
                        chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),
                                ChessColor.WHITE,chessComponents);
                    }
                    else if(str.charAt(j)=='R'){
                        chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),
                                ChessColor.BLACK,chessComponents);
                    }
                    else if(str.charAt(j)=='r'){
                        chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),
                                ChessColor.WHITE,chessComponents);
                    }
                }
            }
            else if(len<5){//here's any problems?
                char ch=str.charAt(0);
                if(ch=='w')currentPlayer=ChessColor.WHITE;
                else if(ch=='b')currentPlayer=ChessColor.BLACK;
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph(){
        StringBuilder str= new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                str.append(chessComponents[i][j].toString());
            }
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player){
        StringBuilder stringBuilder= new StringBuilder();
        int BlackKing=1;int WhiteKing=1;
        int BlackQueen=1;int WhiteQueen=1;
        int BlackRook=2;int WhiteRook=2;
        int BlackBishop=2;int WhiteBishop=2;
        int BlackKnight=2;int WhiteKnight=2;
        int BlackPawn=8;int WhitePawn=8;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                String str=chessComponents[i][j].toString();
                if(str.equals("K")){
                    --BlackKing;
                }
                else if(str.equals("k")){
                    --WhiteKing;
                }
                else if(str.equals("Q")){
                    --BlackQueen;
                }
                else if(str.equals("q")){
                    --WhiteQueen;
                }
                else if(str.equals("R")){
                    --BlackRook;
                }
                else if(str.equals("r")){
                    --WhiteRook;
                }
                else if(str.equals("B")){
                    --BlackBishop;
                }
                else if(str.equals("b")){
                    --WhiteBishop;
                }
                else if(str.equals("N")){
                    --BlackKnight;
                }
                else if(str.equals("n")){
                    --WhiteKnight;
                }
                else if(str.equals("P")){
                    --BlackPawn;
                }
                else if(str.equals("p")){
                    --WhitePawn;
                }
            }
        }
        if(player==ChessColor.BLACK){
            if(BlackKing==1){
                stringBuilder.append("K 1\n");
            }
            if(BlackQueen==1){
                stringBuilder.append("Q 1\n");
            }
            if(BlackRook>0){
                stringBuilder.append("R ");
                stringBuilder.append(BlackRook);
                stringBuilder.append("\n");
            }
            if(BlackBishop>0){
                stringBuilder.append("B ");
                stringBuilder.append(BlackBishop);
                stringBuilder.append("\n");
            }
            if(BlackKnight>0){
                stringBuilder.append("N ");
                stringBuilder.append(BlackKnight);
                stringBuilder.append("\n");
            }
            if(BlackPawn>0){
                stringBuilder.append("P ");
                stringBuilder.append(BlackPawn);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
        else {
            if(WhiteKing==1){
                stringBuilder.append("k 1\n");
            }
            if(WhiteQueen==1){
                stringBuilder.append("q 1\n");
            }
            if(WhiteRook>0){
                stringBuilder.append("r ");
                stringBuilder.append(WhiteRook);
                stringBuilder.append("\n");
            }
            if(WhiteBishop>0){
                stringBuilder.append("b ");
                stringBuilder.append( WhiteBishop);
                stringBuilder.append("\n");
            }
            if(WhiteKnight>0){
                stringBuilder.append("n ");
                stringBuilder.append(WhiteKnight);
                stringBuilder.append("\n");
            }
            if(WhitePawn>0){
                stringBuilder.append("p ");
                stringBuilder.append(WhitePawn);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
    }

    @Override
    public ChessComponent getChess(int x,int y){
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent component=chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint>pointList=component.canMoveTo();
        int len=pointList.size();
        if(len==0)return pointList;
        List<ChessboardPoint>ans=new ArrayList<>();
        int []answerList=new int[len+1];
        for(int i=0;i<len;i++){
            answerList[i]=i;
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<=i;j++){
                if(j==i)continue;
                if(pointList.get(answerList[i]).getX()<pointList.get(answerList[j]).getX()){
                    int cnt=answerList[i];
                    answerList[i]=answerList[j];
                    answerList[j]=cnt;
                }
            }
        }
        List<ChessboardPoint>deal=new ArrayList<>();
        for(int i=0;i<len;i++){
            int x=pointList.get(answerList[i]).getX();
            int y=pointList.get(answerList[i]).getY();
            deal.add(new ChessboardPoint(x,y));
        }
        for(int i=0;i<len;i++){
            answerList[i]=i;
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<=i;j++){
                if(j==i)continue;
                if(deal.get(answerList[i]).getX()==deal.get(answerList[j]).getX()
                        &&deal.get(answerList[i]).getY()<deal.get(answerList[j]).getY()){
                    int cnt=answerList[i];
                    answerList[i]=answerList[j];
                    answerList[j]=cnt;
                }
            }
        }
        for(int i=0;i<len;i++){
            int x=deal.get(answerList[i]).getX();
            int y=deal.get(answerList[i]).getY();
            ans.add(new ChessboardPoint(x,y));
        }
        return ans;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessComponent source=chessComponents[sourceX][sourceY];
        if (!source.getChessColor().equals(currentPlayer)){
            return false;
        }
        List<ChessboardPoint>pointList=source.canMoveTo();
        int len=pointList.size();
        if(len>0) {
            for (int i = 0; i < len; i++) {
                int toX = pointList.get(i).getX();
                int toY = pointList.get(i).getY();
                if (targetX == toX && targetY == toY) {
                    ChessColor sourceColor;
//                    if(chessComponents[toX][toY].getChessColor().equals(chessComponents[targetX][targetY].getChessColor()))continue;
                    if(chessComponents[sourceX][sourceY].getChessColor().equals(ChessColor.BLACK)){
                        sourceColor=ChessColor.BLACK;
                    }
                    else {
                        sourceColor=ChessColor.WHITE;
                    }
                    if(chessComponents[sourceX][sourceY] instanceof BishopChessComponent){
                        chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX,targetY),
                                sourceColor,chessComponents);
                    }
                    else if(chessComponents[sourceX][sourceY] instanceof KingChessComponent){
                        chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX,targetY),
                                sourceColor,chessComponents);
                    }
                    else if(chessComponents[sourceX][sourceY] instanceof KnightChessComponent){
                        chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX,targetY),
                                sourceColor,chessComponents);
                    }
                    else if(chessComponents[sourceX][sourceY] instanceof PawnChessComponent){
                        chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX,targetY),
                                sourceColor,chessComponents);
                    }
                    else if(chessComponents[sourceX][sourceY] instanceof QueenChessComponent){
                        chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX,targetY),
                                sourceColor,chessComponents);
                    }
                    else if(chessComponents[sourceX][sourceY] instanceof RookChessComponent){
                        chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX,targetY),
                                sourceColor,chessComponents);
                    }
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY),
                            ChessColor.NONE, chessComponents);
                    if(source.getChessColor()==ChessColor.BLACK){
                        currentPlayer=ChessColor.WHITE;
                    }
                    else if(source.getChessColor()==ChessColor.WHITE){
                        currentPlayer=ChessColor.BLACK;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
