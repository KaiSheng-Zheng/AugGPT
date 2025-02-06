
import java.util.ArrayList;
import java.util.List;
import java .util.HashMap;
import static java.awt.Color.BLACK;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;

    }

    public ChessComponent getChessComponent(int i, int j) {
        return chessComponents[i][j];
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            String temp=chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                switch (temp.charAt(j)){
                    case 'R'->{
                        chessComponents[i][j] = new RookChessComponent('R', ChessColor.WHITE, new ChessboardPoint(i,j),chessComponents);
                    }
                    case 'N'->{
                        chessComponents[i][j] = new KnightChessComponent('N', ChessColor.WHITE, new ChessboardPoint(i,j),chessComponents);
                    }
                    case 'B'->{
                        chessComponents[i][j] = new BishopChessComponent('B', ChessColor.WHITE, new ChessboardPoint(i,j),chessComponents);
                    }
                    case 'K'->{
                        chessComponents[i][j] = new KingChessComponent('K', ChessColor.WHITE, new ChessboardPoint(i,j),chessComponents);
                    }
                    case 'Q'->{
                        chessComponents[i][j] = new QueenChessComponent('Q', ChessColor.WHITE, new ChessboardPoint(i,j),chessComponents);
                    }
                    case 'P'->{
                        chessComponents[i][j] = new PawnChessComponent('P', ChessColor.WHITE, new ChessboardPoint(i,j),chessComponents);
                    }
                    case '_'->{
                        chessComponents[i][j] = new EmptySlotComponent();
                    }
                    case 'r'->{
                        chessComponents[i][j] = new RookChessComponent('r', ChessColor.BLACK, new ChessboardPoint(i,j),chessComponents);
                    }
                case 'n'->{
                        chessComponents[i][j] = new KnightChessComponent('n', ChessColor.BLACK, new ChessboardPoint(i,j),chessComponents);
                    }
                case 'b'->{
                        chessComponents[i][j] = new BishopChessComponent('b', ChessColor.BLACK, new ChessboardPoint(i,j),chessComponents);
                    }
                case 'q'->{
                        chessComponents[i][j] = new QueenChessComponent('q', ChessColor.BLACK, new ChessboardPoint(i,j),chessComponents);
                    }
                case 'k'->{
                        chessComponents[i][j] = new KingChessComponent('k', ChessColor.BLACK, new ChessboardPoint(i,j),chessComponents);
                    }
                case 'p'->{
                        chessComponents[i][j] = new PawnChessComponent('p', ChessColor.BLACK, new ChessboardPoint(i,j),chessComponents);
                    }
                }
            }


        String colorches = chessboard.get(8);
        if (colorches.equals("w")) {
            currentPlayer = ChessColor.BLACK;
        } else {
            currentPlayer = ChessColor.WHITE;
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
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = new StringBuilder();
        StringBuilder sb8 = new StringBuilder();
        for (int i = 0; i < chessComponents[0].length; i++) {
            sb1.append(chessComponents[0][i].name);
            sb2.append(chessComponents[1][i].name);
            sb3.append(chessComponents[2][i].name);
            sb4.append(chessComponents[3][i].name);
            sb5.append(chessComponents[4][i].name);
            sb6.append(chessComponents[5][i].name);
            sb7.append(chessComponents[6][i].name);
            sb8.append(chessComponents[7][i].name);
        }
        return sb1 + "\n" + sb2 + "\n" + sb3 + "\n" + sb4 + "\n" + sb5 + "\n" + sb6 + "\n" + sb7 + "\n" + sb8;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        final int[]c2=new int[] {1,1,2,2,2,8,1,1,2,2,2,8};
        int[] c6=new int[12];
        for (int c7=0;c7<12;c7++){
            c6[c7]=0;
        }
       // HashMap <Character,Integer>hashMap=new HashMap();
        StringBuilder stringBuilder=new StringBuilder();
        char[] c=new char[]{'K','Q','R','B','N','P','k','q','r','b','n','p'};
//        for (char c1:c){
//            hashMap.put(c1,0);
//        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                    switch (chessComponents[i][j].getName()){
                        case 'K'->{c6[0]++;}
                        case 'Q'->{c6[1]++;}
                        case 'R'->{c6[2]++;}
                        case 'B'->{c6[3]++;}
                        case 'N'->{c6[4]++;}
                        case 'P'->{c6[5]++;}
                        case 'k'->{c6[6]++;}
                        case 'q'->{c6[7]++;}
                        case 'r'->{c6[8]++;}
                        case 'b'->{c6[9]++;}
                        case 'n'->{c6[10]++;}
                        case 'p'->{c6[11]++;}
                    }
//                    int temp=hashMap.get(chessComponents[i][j].getName());
//                    hashMap.replace(chessComponents[i][j].getName(),temp+1);

                }
            }
//        int[] i1=new int[12];
//        for (int j=0;j<12;j++) {
//            i1[j] = hashMap.get(c[j]);
//        }

        if (player==ChessColor.BLACK){
            for (int j=0;j<6;j++){
                int temp=c2[j]-c6[j];
                if(temp!=0){
                    stringBuilder.append(c[j]).append(" ").append(temp).append("\n");
                }
            }
        }
        if (player==ChessColor.WHITE){
            for (int j=6;j<12;j++){
                int temp=c2[j]-c6[j];
                if(temp!=0){
                    stringBuilder.append(c[j]).append(" ").append(temp).append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        return chess.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        //ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        List<ChessboardPoint> canMoveto = getCanMovePoints(source);
        boolean in = false;
        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) {
            for (int i = 0; i < canMoveto.size(); i++) {
                if (canMoveto.get(i).getX() == targetX && canMoveto.get(i).getY() == targetY) {
                    in = true;
                }
                if (in) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    if (currentPlayer.equals(ChessColor.BLACK)) {
                        currentPlayer = ChessColor.WHITE;
                    } else {
                        currentPlayer = ChessColor.BLACK;
                    }
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                    for (int j = 0; j < 8; j++) {
                        for (int h = 0; h < 8; h++) {
                            chessComponents[j][h].setChessboard(this.chessComponents);
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
            return true;
        }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    }