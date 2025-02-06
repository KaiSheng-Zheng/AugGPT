
import java.util.*;


public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.NONE;

    private ChessComponent match(char c,int x,int y){
        switch (c){
            case 'R':{
                return new RookChessComponent(new ChessboardPoint(x, y),ChessColor.BLACK);
            }
            case 'r':{
                return new RookChessComponent(new ChessboardPoint(x, y),ChessColor.WHITE);
            }
            case 'N':{
                return new KnightChessComponent(new ChessboardPoint(x, y),ChessColor.BLACK);
            }
            case 'n':{
                return new KnightChessComponent(new ChessboardPoint(x, y),ChessColor.WHITE);
            }
            case 'B':{
                return new BishopChessComponent(new ChessboardPoint(x, y),ChessColor.BLACK);
            }
            case 'b':{
                return new BishopChessComponent(new ChessboardPoint(x, y),ChessColor.WHITE);
            }
            case 'Q':{
                return new QueenChessComponent(new ChessboardPoint(x, y),ChessColor.BLACK);
            }
            case 'q':{
                return new QueenChessComponent(new ChessboardPoint(x, y),ChessColor.WHITE);
            }
            case 'K':{
                return new KingChessComponent(new ChessboardPoint(x, y),ChessColor.BLACK);
            }
            case 'k':{
                return new KingChessComponent(new ChessboardPoint(x, y),ChessColor.WHITE);
            }
            case 'P':{
                return new PawnChessComponent(new ChessboardPoint(x, y),ChessColor.BLACK);
            }
            case 'p':{
                return new PawnChessComponent(new ChessboardPoint(x, y),ChessColor.WHITE);
            }
            case '_':{
                return new EmptySlotComponent(new ChessboardPoint(x, y),ChessColor.NONE);
            }
            default:{
                return null;
            }
        }
    }

    @Override
    public void loadChessGame(List<String> chessboard) {

//
//        String regex="[a-z|A-Z|.]";
//        Pattern p=Pattern.compile(regex);

        for (int i = 0; i < 8; i++) {

            String[] pieces=chessboard.get(i).split("");
//            Matcher m= p.matcher(chessboard.get(i));
//
//            while (m.find()){
//
//                chessComponents[i][m.start(1)]=match( m.group().charAt(0),i, m.start(1));
//
//            }
            for (int j = 0; j < pieces.length; j++) {
                chessComponents[i][j]=match(pieces[j].charAt(0),i,j);
            }
        }
        switch (chessboard.get(8)){
            case "w":{
                currentPlayer=ChessColor.WHITE;
                break;
            }
            case "b":{
                currentPlayer=ChessColor.BLACK;
                break;
            }
            default:{
                currentPlayer=ChessColor.NONE;
                break;
            }
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8 ; j++) {
                stringBuilder.append(chessComponents[i][j]);
            }

            if (i<7){
                stringBuilder.append("\n");
            }
        }



        return stringBuilder.toString();
    }




    @Override
    public String getCapturedChess(ChessColor player) {

        HashMap<Character,Integer> map=new HashMap<>();
        char name;
        {
            map.put('k', 0);
            map.put('K', 0);
            map.put('q', 0);
            map.put('Q', 0);
            map.put('r', 0);
            map.put('R', 0);
            map.put('b', 0);
            map.put('B', 0);
            map.put('n', 0);
            map.put('N', 0);
            map.put('p', 0);
            map.put('P', 0);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                name=chessComponents[i][j].name;
                if (map.containsKey(name)){
                    map.replace(name, map.get(name)+1);
                }
            }
        }

        StringBuilder stringBuilder=new StringBuilder();

        switch (player){
            case WHITE:{

                if (1-map.get('k')>0){
                    stringBuilder.append('k'+" "+(1-map.get('k'))+"\n");
                }

                if (1-map.get('q')>0){
                    stringBuilder.append('q'+" "+(1-map.get('q'))+"\n");
                }
                if (2-map.get('r')>0){
                    stringBuilder.append('r'+" "+(2-map.get('r'))+"\n");
                }
                if (2-map.get('b')>0){
                    stringBuilder.append('b'+" "+(2-map.get('b'))+"\n");
                }
                if (2-map.get('n')>0){
                    stringBuilder.append('n'+" "+(2-map.get('n'))+"\n");
                }
                if (8-map.get('p')>0){

                    stringBuilder.append('p'+" "+(8-map.get('p'))+"\n");
                }

                break;
            }
            case BLACK:{

                if (1-map.get('K')>0){
                    stringBuilder.append('K'+" "+(1-map.get('K'))+"\n");
                }
                if (1-map.get('Q')>0){
                    stringBuilder.append('Q'+" "+(1-map.get('Q'))+"\n");
                }
                if (2-map.get('R')>0){
                    stringBuilder.append('R'+" "+(2-map.get('R'))+"\n");
                }
                if (2-map.get('B')>0){
                    stringBuilder.append('B'+" "+(2-map.get('B'))+"\n");
                }
                if (2-map.get('N')>0){
                    stringBuilder.append('N'+" "+(2-map.get('N'))+"\n");
                }
                if (8-map.get('P')>0){
                    stringBuilder.append('P'+" "+(8-map.get('P'))+"\n");
                }

                break;
            }

        }

        return stringBuilder.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint chessboardPoint) {
        return chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
        chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);

        return true;
    }


}

