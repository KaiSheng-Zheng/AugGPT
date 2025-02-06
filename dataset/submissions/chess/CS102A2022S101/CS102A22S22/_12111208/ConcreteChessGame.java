
import java.util.ArrayList;
import java.util.List;



public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer=ChessColor.WHITE;

    public ConcreteChessGame(){}
    @Override
    public void loadChessGame(List<String> chessboard) {

        for (int i=0;i<8;i++){
            char[] row=chessboard.get(i).toCharArray();
            for (int j=0;j<8;j++){
                char c=row[j];
                if (c=='_'){
                    chessComponents[i][j]=new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(i,j),chessComponents) ;
                }else if (c=='R'){
                    chessComponents[i][j]=new RookChessComponent('R',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                }else if (c=='r'){
                    chessComponents[i][j]=new RookChessComponent('r',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents) ;
                }else if (c=='N'){
                    chessComponents[i][j]=new KnightChessComponent('N',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents) ;
                }else if (c=='n'){
                    chessComponents[i][j]=new KnightChessComponent('n',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents) ;
                }else if (c=='B'){
                    chessComponents[i][j]=new BishopChessComponent('B',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents) ;
                }else if (c=='b'){
                    chessComponents[i][j]=new BishopChessComponent('b',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents) ;
                }else if (c=='Q'){
                    chessComponents[i][j]=new QueenChessComponent('Q',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents) ;
                }else if (c=='q'){
                    chessComponents[i][j]=new QueenChessComponent('q',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents) ;
                }else if (c=='K'){
                    chessComponents[i][j]=new KingChessComponent('K',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents) ;
                }else if (c=='k'){
                    chessComponents[i][j]=new KingChessComponent('k',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents) ;
                }else if (c=='P'){
                    chessComponents[i][j]=new PawnChessComponent('P',ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents) ;
                }else if (c=='p'){
                    chessComponents[i][j]=new PawnChessComponent('p',ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents) ;
                }
            }
        }
        if (chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }else {
            currentPlayer=ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                stringBuilder.append(chessComponents[i][j].getName());
            }
            stringBuilder.append("\n");
        }
        return String.valueOf(stringBuilder);
    }


    @Override
    public String getCapturedChess(ChessColor player) {
        ArrayList<ChessComponent> CapturedChess=new ArrayList<>();
        CompleteChess(CapturedChess,player);
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(chessComponents[i][j].getChessColor()==player){
                    CapturedChess.remove(chessComponents[i][j]);
                }
            }
        }
        CapturedChess.trimToSize();
        int[] times= {0,0,0,0,0,0};
        String[] namesWhite={"k","q","r","b","n","p"};
        String[] namesBlack={"K","Q","R","B","N","P"};
        for (int j=0;j<CapturedChess.size();j++){
            if (CapturedChess.get(j).getSerialNumber()==0){
                times[0]++;
            }else if (CapturedChess.get(j).getSerialNumber()==1){
                times[1]++;
            }else if (CapturedChess.get(j).getSerialNumber()==2){
                times[2]++;
            }else if (CapturedChess.get(j).getSerialNumber()==3){
                times[3]++;
            }else if (CapturedChess.get(j).getSerialNumber()==4){
                times[4]++;
            }else if (CapturedChess.get(j).getSerialNumber()==5){
                times[5]++;
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        if (player==ChessColor.WHITE){
            for (int i=0;i<6;i++){
                if (times[i]!=0){
                    stringBuilder.append(namesWhite[i]);
                    stringBuilder.append(" ");
                    stringBuilder.append(times[i]);
                    stringBuilder.append("\n");
                }
            }
        }else {
            for (int i=0;i<6;i++){
                if (times[i]!=0){
                    stringBuilder.append(namesBlack[i]);
                    stringBuilder.append(" ");
                    stringBuilder.append(times[i]);
                    stringBuilder.append("\n");
                }
            }
        }

        return  String.valueOf(stringBuilder);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> chessboardPointList;
        chessboardPointList=chessComponents[source.getX()][source.getY()].canMoveTo();
        ChessboardPoint chessboardPoint;
        for(int i=0;i<chessboardPointList.size()-1;i++){
            for(int j=0;j<chessboardPointList.size()-1-i;j++){
                if(chessboardPointList.get(j).getX()>chessboardPointList.get(j+1).getX()){
                    chessboardPoint =chessboardPointList.get(j);
                    chessboardPointList.set(j,chessboardPointList.get(j+1));
                    chessboardPointList.set(j+1,chessboardPoint);
                }
            }
        }
        for(int i=0;i<chessboardPointList.size()-1;i++){
            for(int j=0;j<chessboardPointList.size()-1-i;j++){
                if(chessboardPointList.get(j).getX()==chessboardPointList.get(j+1).getX()&&chessboardPointList.get(j).getY()>chessboardPointList.get(j+1).getY()){
                    chessboardPoint =chessboardPointList.get(j);
                    chessboardPointList.set(j,chessboardPointList.get(j+1));
                    chessboardPointList.set(j+1,chessboardPoint);
                }
            }
        }
        return chessboardPointList;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean result=false;
        List<ChessboardPoint> chessboardPointList=chessComponents[sourceX][sourceY].canMoveTo();
        if (chessboardPointList.size()==0){
            result=false;
        }else if (chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
            for (int i=0;i<chessboardPointList.size();i++){
                if (chessboardPointList.get(i).getX()==targetX&&chessboardPointList.get(i).getY()==targetY){
                    if (currentPlayer==ChessColor.WHITE){
                        currentPlayer=ChessColor.BLACK;
                    }else {
                        currentPlayer=ChessColor.WHITE;
                    }
                    chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(sourceX,sourceY));
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(sourceX,sourceY),chessComponents);
                    result=true;
                    break;
                }else {
                    result=false;
                }
            }
        }else {
            result=false;
        }
        return result;

    }

    public void CompleteChess(ArrayList<ChessComponent> EmptyChess,ChessColor chessColor){
        if (chessColor==ChessColor.WHITE){
            EmptyChess.add(new KingChessComponent('k',ChessColor.WHITE));
            EmptyChess.add(new QueenChessComponent('q',ChessColor.WHITE));
            for (int i=0;i<=1;i++){
                EmptyChess.add(new RookChessComponent('r',ChessColor.WHITE));
                EmptyChess.add(new BishopChessComponent('b',ChessColor.WHITE));
                EmptyChess.add(new KnightChessComponent('n',ChessColor.WHITE));
            }
            for (int i=0;i<8;i++){
                EmptyChess.add(new PawnChessComponent('p',ChessColor.WHITE));
            }
        }else {
            EmptyChess.add(new KingChessComponent('K',ChessColor.BLACK));
            EmptyChess.add(new QueenChessComponent('Q',ChessColor.BLACK));
            for (int i=0;i<=1;i++){
                EmptyChess.add(new RookChessComponent('R',ChessColor.BLACK));
                EmptyChess.add(new BishopChessComponent('B',ChessColor.BLACK));
                EmptyChess.add(new KnightChessComponent('N',ChessColor.BLACK));
            }
            for (int i=0;i<8;i++){
                EmptyChess.add(new PawnChessComponent('P',ChessColor.BLACK));
            }
        }
    }


}
