import java.util.*;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private static ChessComponent[][] chessBoardPtr;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ChessComponent[][] GetChessBoard(){
        return chessBoardPtr;
    }




    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
    }

@Override
    public void loadChessGame(List<String> chessboard){
        if (chessboard.get(8).contains("b"))
          currentPlayer = ChessColor.BLACK;
        else if (chessboard.get(8).contains("w"))
            currentPlayer = ChessColor.WHITE;
        for (int i = 0; i < 8;i++){
            for (int j = 0; j < 8;j++){
                ChessboardPoint p = new ChessboardPoint(i,j);
                switch (chessboard.get(i).charAt(j)){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(p,ChessColor.BLACK,'R');
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(p,ChessColor.WHITE,'r');
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(p,ChessColor.BLACK,'N');
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(p,ChessColor.WHITE,'n');
                        break;
                    case 'B':
                            chessComponents[i][j] = new BishopChessComponent(p,ChessColor.BLACK,'B');
                            break;
                    case 'b':
                            chessComponents[i][j] = new BishopChessComponent(p,ChessColor.WHITE,'b');
                            break;
                    case 'Q':
                            chessComponents[i][j] = new QueenChessComponent(p,ChessColor.BLACK,'Q');
                            break;
                    case 'q':
                            chessComponents[i][j] = new QueenChessComponent(p,ChessColor.WHITE,'q');
                            break;
                    case 'K':
                            chessComponents[i][j] = new KingChessComponent(p,ChessColor.BLACK,'K');
                            break;
                    case 'k':
                            chessComponents[i][j] = new KingChessComponent(p,ChessColor.WHITE,'k');
                            break;
                    case 'P':
                            chessComponents[i][j] = new PawnChessComponent(p,ChessColor.BLACK,'P');
                            break;
                    case 'p':
                            chessComponents[i][j] = new PawnChessComponent(p,ChessColor.WHITE,'p');
                            break;
                    case '_':
                            chessComponents[i][j] = new EmptySlotComponent(p,ChessColor.NONE,'_');
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
        StringBuilder[] list = new StringBuilder[8];
        StringBuilder graph = new StringBuilder();
        //StringBuilder list = new StringBuilder("");
        for (int i = 0; i < 8;i++){
            list[i] = new StringBuilder("");
            for (int j = 0; j < 8;j++){
                list[i].append(chessComponents[i][j].getName());
            }
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                list[0],list[1],list[2],list[3],list[4],list[5],list[6],list[7]);
    }

    public ChessComponent getChessComponent(int x, int y) {
        return chessComponents[x][y];
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
@Override
    public String getCapturedChess(ChessColor player){
        int index = 0;
        int count = 0;
        StringBuilder[] lost = new StringBuilder[6];
        for (int i = 0;i < 6;i++){
            lost[i] = new StringBuilder("");
        }
        StringBuilder result = new StringBuilder();
        String cKing,cQueen,cRook,cBishop,cKnight,cPawn;
        if (player == ChessColor.BLACK){
            lost[0].append(lostKingOrQueen('K'));
            lost[1].append(lostKingOrQueen('Q'));
            lost[2].append(lostPBK('R'));
            lost[3].append(lostPBK('B'));
            lost[4].append(lostPBK('N'));
            lost[5].append(lostPawn('P'));
        }
        else{
            lost[0].append(lostKingOrQueen('k'));
            lost[1].append(lostKingOrQueen('q'));
            lost[2].append(lostPBK('r'));
            lost[3].append(lostPBK('b'));
            lost[4].append(lostPBK('n'));
            lost[5].append(lostPawn('p'));
        }
        for (int i = 0;i < 6;i++){
            if (String.valueOf(lost[i]).equals("")){
                result.append(lost[i]);
            }
            else{
                result.append(lost[i] + "\n");
            }
        }
    return String.valueOf(result);
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
@Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX < 0 || sourceX > 7 || sourceY < 0 || sourceY > 7 || targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7)
            return false;

        chessBoardPtr = chessComponents;
        ChessColor color = chessComponents[sourceX][sourceY].getChessColor();
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
//        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
//        ChessColor scolor = chessComponents[sourceX][sourceY].getChessColor();
//        char sname = chessComponents[sourceX][sourceY].name;
//    List<ChessboardPoint> canNotGo = new ArrayList<>();

        if (color == ChessColor.NONE) {
            ArrayList<ChessboardPoint> list = new ArrayList<>();//?????????????????????????????????
            return false;
        }
        else {
//            List<ChessboardPoint> ptlist = chessComponents[sourceX][sourceY].canMoveTo();
            String str1 = String.valueOf(chessComponents[sourceX][sourceY].canMoveTo());
            String str2 = target.toString();
            boolean ifContain = str1.contains(str2);

            if (currentPlayer == color && ifContain){
                ChessComponent chess1 = chessComponents[sourceX][sourceY];
                chess1.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY] = chess1;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(target,ChessColor.NONE,'_');
//                chessComponents[sourceX][sourceY].setSource(target);
//                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
//                chessComponents[sourceX][sourceY].setName('_');
//                chessComponents[targetX][targetY].setSource(source);
//                chessComponents[targetX][targetY].setChessColor(scolor);
//                chessComponents[targetX][targetY].setName(sname);
                if (currentPlayer == ChessColor.BLACK) {
                    currentPlayer = ChessColor.WHITE;
                } else {
                    currentPlayer = ChessColor.BLACK;
                }
                return true;
            }
            else {
                return false;
            }
        }
    }



@Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        chessBoardPtr = chessComponents;
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();




        ChessboardPoint[] array = new ChessboardPoint[canMovePoints.size()];

        for (int i = 0;i < canMovePoints.size();i++){
            int count = 0;
            for (int j = 0;j < canMovePoints.size();j++){
                if (canMovePoints.get(j).getX() < canMovePoints.get(i).getX()){
                    count ++;
                }
                else if (canMovePoints.get(j).getX() == canMovePoints.get(i).getX()
                        && canMovePoints.get(j).getY() < canMovePoints.get(i).getY()){
                    count ++;
                }
            }
            array[count] = canMovePoints.get(i);
            //finalCanMovePoints.set(count,canMovePoints.get(i));
        }
        List<ChessboardPoint> finalCanMovePoints = new ArrayList<>(Arrays.asList(array));
        return finalCanMovePoints;
    }





    public StringBuilder lostKingOrQueen(char name){
        StringBuilder result = new StringBuilder();
        String count;
        if (getChessboardGraph().indexOf(name,0) == -1){
            count = "1";
            result.append(name+" "+count);
        }
        else{ result.append("");}
        return result;
    }

    public StringBuilder lostPBK(char name){
        StringBuilder result = new StringBuilder();
        String count;
        int index = 0;
        if (getChessboardGraph().indexOf(name,index) == -1){
            count = "2";
            result.append(name+" "+count);
        }
        else {
            index = getChessboardGraph().indexOf(name,index);
            if (getChessboardGraph().indexOf(name,index+1) == -1){
                count = "1";
                result.append(name+" "+count);
            }
            else {
                count = "";
                result.append("");
            }
        }
        return  result;
    }

    public StringBuilder lostPawn(char name){
        StringBuilder result = new StringBuilder();
        String count = "";
        int index = 0;
        for (int i = 0;i < 8;i++){
            if (getChessboardGraph().indexOf(name,index) == -1){
                count = String.valueOf(8-i);
                break;
            }
            else {
                index = getChessboardGraph().indexOf(name,index) + 1;
            }

        }
        if (count.equals("")){
            result.append("");
        }
        else{
            result.append(name+" "+count);
        }
        return result;
    }
}
