import java.util.List;




public class ConcreteChessGame implements ChessGame{

// A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
private ChessComponent[][] chessComponents;
// What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
private ChessColor currentPlayer = ChessColor.WHITE;

public String thechessboard1;
public String thechessboard3;
public String thechessboard0;
public String thechessboard4;
public String thechessboard7;
public String thechessboard2;
public String thechessboard5;
public String thechessboard6;




public ChessComponent Getchesskind
    
(char input) {

    if(input == 'k'||input=='K'){return new KingChessComponent();}
    
    else if(input=='q'||input=='Q'){return new QueenChessComponent();}
    
    else if(input=='r'||input=='R'){return new RookChessComponent();}

    else if(input=='n'||input=='N'){return new KnightChessComponent();}

    else if(input=='b'||input=='B'){return new BishopChessComponent();}

    else if(input=='p'||input=='P'){return new PawnChessComponent();}

    else if(input=='_'){return new EmptySlotComponent();}

    else return null;

        }

public ChessComponent getcp( int i,int j) {
    return chessComponents[i][j];
}
public void setcp(int i,int j,ChessComponent cp) {
    chessComponents[i][j] = cp;
}

public void loadChessGame(List<String> chessboard){
    
    

this.thechessboard0 = chessboard.get(0);
this.thechessboard1 = chessboard.get(1);
this.thechessboard2 = chessboard.get(2);
this.thechessboard3 = chessboard.get(3);
this.thechessboard4 = chessboard.get(4);
this.thechessboard5 = chessboard.get(5);
this.thechessboard6 = chessboard.get(6);
this.thechessboard7 = chessboard.get(7);





    for(int i=0;i<8;i++){

         for(int j=0;j<8;j++){

         setcp(i,j,Getchesskind( chessboard.get(i).charAt(j) )) ;
         }

}

    if (chessboard.get(8).charAt(0)=='b')

currentPlayer = ChessColor.BLACK;

else currentPlayer = ChessColor.WHITE;


};




public  List<ChessboardPoint> getCanMovePoints(ChessboardPoint source)
{return null;



}


public ChessColor getCurrentPlayer() {

  return this.currentPlayer;

}


public String getChessboardGraph(){

return "0";

}
public int countercp(){

    return 1;

}

public String getCapturedChess(ChessColor player){
    
return "SDF";
}


public ChessComponent getChess(int x, int y){

return  getcp(x, y);

}


public boolean moveChess(int sourceX, int sourceY, int targetX, int
targetY)
{
    
    chessComponents [targetX] [targetY]=chessComponents[sourceX][sourceY];

 chessComponents[sourceX][sourceY]=new EmptySlotComponent();return true;

}







}

