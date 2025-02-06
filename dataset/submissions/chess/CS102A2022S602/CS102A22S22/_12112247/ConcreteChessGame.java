import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame(){

        this.chessComponents= new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }
    public void loadChessGame(List<String> chessboard){
        /*this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;*/
        char chess='R';


        for(int i=0 ; i<8 ; i++){
            for(int j=0 ; j<8 ; j++){
                chess=chessboard.get(i).charAt(j);
                if(chess=='R' || chess=='r'){
                    ChessboardPoint source = new ChessboardPoint(i,j);
                    ChessColor chessColor=BlackOrWriteOrNone(chess);
                    RookChessComponent  chessOnBoard = new RookChessComponent(source,chessColor,chess,chessComponents);
                    //chessOnBoard.setSource(i,j);
                    //chessOnBoard.setChessColor(BlackOrWriteOrNone(chess));
                    //chessOnBoard.setName(chess);
                    chessComponents[i][j]=chessOnBoard;
                }else if(chess=='N'||chess=='n'){
                    ChessboardPoint source = new ChessboardPoint(i,j);
                    ChessColor chessColor=BlackOrWriteOrNone(chess);
                    KnightChessComponent  chessOnBoard = new  KnightChessComponent(source,chessColor,chess,chessComponents);
                    //chessOnBoard.setSource(i,j);
                    //chessOnBoard.setChessColor(BlackOrWriteOrNone(chess));
                    //chessOnBoard.setName(chess);
                    chessComponents[i][j]=chessOnBoard;
                }else if(chess=='B'||chess=='b'){
                    ChessboardPoint source = new ChessboardPoint(i,j);
                    ChessColor chessColor=BlackOrWriteOrNone(chess);
                    BishopChessComponent  chessOnBoard = new BishopChessComponent(source,chessColor,chess,chessComponents);
                    //chessOnBoard.setSource(i,j);
                    //chessOnBoard.setChessColor(BlackOrWriteOrNone(chess));
                    //chessOnBoard.setName(chess);
                    chessComponents[i][j]=chessOnBoard;
                } else if (chess == 'Q' || chess == 'q') {
                    ChessboardPoint source = new ChessboardPoint(i,j);
                    ChessColor chessColor=BlackOrWriteOrNone(chess);
                    QueenChessComponent  chessOnBoard = new QueenChessComponent(source,chessColor,chess,chessComponents);
                    //chessOnBoard.setSource(i,j);
                    //chessOnBoard.setChessColor(BlackOrWriteOrNone(chess));
                    //chessOnBoard.setName(chess);
                    chessComponents[i][j]=chessOnBoard;
                } else if (chess== 'K'||chess=='k') {
                    ChessboardPoint source = new ChessboardPoint(i,j);
                    ChessColor chessColor=BlackOrWriteOrNone(chess);
                    KingChessComponent  chessOnBoard = new KingChessComponent(source,chessColor,chess,chessComponents);
                    //chessOnBoard.setSource(i,j);
                    //chessOnBoard.setChessColor(BlackOrWriteOrNone(chess));
                    //chessOnBoard.setName(chess);
                    chessComponents[i][j]=chessOnBoard;
                } else if(chess=='P'||chess=='p'){
                    ChessboardPoint source = new ChessboardPoint(i,j);
                    ChessColor chessColor=BlackOrWriteOrNone(chess);
                    PawnChessComponent  chessOnBoard = new PawnChessComponent(source,chessColor,chess,chessComponents);
                    //chessOnBoard.setSource(i,j);
                    //chessOnBoard.setChessColor(BlackOrWriteOrNone(chess));
                    //chessOnBoard.setName(chess);
                    chessComponents[i][j]=chessOnBoard;
                }else if(chess=='_'){
                    ChessboardPoint source = new ChessboardPoint(i,j);
                    ChessColor chessColor=BlackOrWriteOrNone(chess);
                    EmptySlotComponent  chessOnBoard = new EmptySlotComponent(source,chessColor,chess,chessComponents);
                    //chessOnBoard.setSource(i,j);
                    //chessOnBoard.setChessColor(BlackOrWriteOrNone(chess));
                    //chessOnBoard.setName(chess);
                    chessComponents[i][j]=chessOnBoard;
                }
                /*chessComponents[i][j].setSource(i,j);
                chessComponents[i][j].setChessColor(BlackOrWriteOrNone(chess));
                chessComponents[i][j].setName(chess);*/
            }
        }

        String currentChessPlayer;
        currentChessPlayer=chessboard.get(8);
        if(currentChessPlayer.equals("w")){
            currentPlayer = ChessColor.WHITE;
        }else{
            currentPlayer = ChessColor.BLACK;
        }


    }
    @Override
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph(){
       StringBuilder Graph=new StringBuilder();
        for(int i=0 ; i<8 ; i++){
           for(int j=0 ; j<8 ; j++){
                Graph.append(chessComponents[i][j].getName());
           }
           if(i<7){
               Graph.append("\n");
           }
       }
        return String.valueOf(Graph);
    }
    //save game,  analyze chessboard, turn chessboard to string and in pro
    //write it in the txt

    @Override
    public String getCapturedChess(ChessColor player){
        StringBuilder returnString = new StringBuilder();
        int[] chess=new int[6];
        ChessComponent chessboard = chessComponents[0][0];
        switch (player){
            case BLACK:
                for(int i=0; i<8 ;i++){
                    for(int j=0 ;j<8 ;j++){
                        chessboard = chessComponents[i][j];
                        if(chessboard.getName()=='K'){
                            chess[0]+=1;
                        } else if (chessboard.getName()=='Q') {
                            chess[1]+=1;
                        } else if (chessboard.getName()=='R'){
                            chess[2]+=1;
                        }else if(chessboard.getName()=='B'){
                            chess[3]+=1;
                        }else if(chessboard.getName()=='N'){
                            chess[4]+=1;
                        }else if(chessboard.getName()=='P'){
                            chess[5]+=1;
                        }
                    }
                }
                chess[0]=1-chess[0];
                chess[1]=1-chess[1];
                chess[2]=2-chess[2];
                chess[3]=2-chess[3];
                chess[4]=2-chess[4];
                chess[5]=8-chess[5];
                for(int k=0 ; k<6 ; k++){
                    if(chess[k]!=0){
                        if(k==0){
                            returnString.append("K "+chess[0]+"\n");
                        }else if(k==1){
                            returnString.append("Q "+chess[1]+"\n");
                        }else if(k==2){
                            returnString.append("R "+chess[2]+"\n");
                        }else if(k==3){
                            returnString.append("B "+chess[3]+"\n");
                        }else if (k==4){
                            returnString.append("N "+chess[4]+"\n");
                        }else if(k==5){
                            returnString.append("P "+chess[5]+"\n");
                        }
                    }
                }
                break;
            case WHITE:
                for(int i=0; i<8 ;i++){
                    for(int j=0 ;j<8 ;j++){
                        chessboard = chessComponents[i][j];
                        if(chessboard.getName()=='k'){
                            chess[0]+=1;
                        } else if (chessboard.getName()=='q') {
                            chess[1]+=1;
                        } else if (chessboard.getName()=='r'){
                            chess[2]+=1;
                        }else if(chessboard.getName()=='b'){
                            chess[3]+=1;
                        }else if(chessboard.getName()=='n'){
                            chess[4]+=1;
                        }else if(chessboard.getName()=='p'){
                            chess[5]+=1;
                        }
                    }
                }
                chess[0]=1-chess[0];
                chess[1]=1-chess[1];
                chess[2]=2-chess[2];
                chess[3]=2-chess[3];
                chess[4]=2-chess[4];
                chess[5]=8-chess[5];
                for(int k=0 ; k<6 ; k++){
                    if(chess[k]!=0){
                        if(k==0){
                            returnString.append("k "+chess[0]+"\n");
                        }else if(k==1){
                            returnString.append("q "+chess[1]+"\n");
                        }else if(k==2){
                            returnString.append("r "+chess[2]+"\n");
                        }else if(k==3){
                            returnString.append("b "+chess[3]+"\n");
                        }else if (k==4){
                            returnString.append("n "+chess[4]+"\n");
                        }else if(k==5){
                            returnString.append("p "+chess[5]+"\n");
                        }
                    }
                }
                break;

        }
        return String.valueOf(returnString);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> CanMovePoint = new ArrayList<ChessboardPoint>();
        ChessComponent sourceChess = chessComponents[source.getX()][source.getY()];
        CanMovePoint=sourceChess.canMoveTo();
        //need a sort
        if(CanMovePoint.size()!=0){
            ChessboardPoint[] array =new ChessboardPoint[CanMovePoint.size()];
        for(int a=0;a<CanMovePoint.size();a++){
            array[a]=CanMovePoint.get(a);
        }
        ChessboardPoint temp = new ChessboardPoint(0,0);
        for(int b=0 ; b<array.length-1;b++){//sort x
            for(int c=0;c<array.length-1-b;c++){
                if(array[c].getX()>array[c+1].getX()){
                    temp=array[c];
                    array[c]=array[c+1];
                    array[c+1]=temp;
                }
            }
        }
        for(int d=0; d<array.length-1;d++){
            for(int e=0;e<array.length-1-d;e++){
                if(array[e].getX()==array[e+1].getX() && array[e].getX()+array[e].getY() > array[e+1].getX()+array[e+1].getY()){
                    temp=array[e];
                    array[e]=array[e+1];
                    array[e+1]=temp;
                }
            }
        }
        List<ChessboardPoint> newArray = new ArrayList<>();
        for(int f=0;f<array.length;f++){
            newArray.add(array[f]);
        }
        return newArray;
        } else{
            return new ArrayList<>();
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessComponent sourceChessComponent = chessComponents[sourceX][sourceY];
        if(currentPlayer==sourceChessComponent.chessColor){

        List canMoveTo = sourceChessComponent.canMoveTo();// Polymorphic, return ChessboardPoint
        String targetChessComponent = "("+targetX+","+targetY+")";
        for(int i=0;i<canMoveTo.size();i++){
            if (canMoveTo.get(i).toString().equals(targetChessComponent)){
                //If the chess can be moved, then move it and switch the player.
                sourceChessComponent.setSource(targetX,targetY);
                ChessboardPoint sourceChessboardPoint = new ChessboardPoint(sourceX,sourceY);
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceChessboardPoint,ChessColor.NONE,'_',chessComponents);
                //source place become empty
                chessComponents[targetX][targetY]=sourceChessComponent;
                //change the chessboard first, the chess been move to target place
                //????????does it neccesary to change the chessComponent[][] of the two component above???????????
                if(sourceChessComponent.chessColor==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }else{
                    currentPlayer=ChessColor.WHITE;
                }
                return true;
            }
        }
        }
        return false;
    }

    public ChessColor BlackOrWriteOrNone(char chess){
        if(chess=='R' || chess=='N' || chess=='B' || chess=='Q' || chess=='K' || chess=='P'){
            return ChessColor.BLACK;
        }else if(chess=='_'){
            return ChessColor.NONE;
        }
        return ChessColor.WHITE;
    }
}
