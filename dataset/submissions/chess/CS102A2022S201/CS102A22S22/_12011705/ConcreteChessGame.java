import com.sun.jdi.event.StepEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;

    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            String[] strings = chessboard.get(i).split("");
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j]=initialChess(strings[j],i,j,chessboard);
            }
        }
        if(Objects.equals(chessboard.get(8), "w")){
            currentPlayer = ChessColor.WHITE;
        }if(Objects.equals(chessboard.get(8), "b")){
            currentPlayer = ChessColor.BLACK;
        }
    }
    public ChessComponent initialChess(String name, int x, int y, List<String> chessboard){
        if(Objects.equals(name, "_")){
            ChessComponent a = new EmptySlotComponent();
            a.name=name.charAt(0);
            a.setChessColor(ChessColor.NONE);
            a.setChessboard(chessboard);
            a.setSource(new ChessboardPoint(x,y));
            a.setChessboard2(findchessboard(chessboard));
            return a;
        }if(Objects.equals(name, "R")){
            ChessComponent a = new RookChessComponent();
            a.name=name.charAt(0);
            a.setChessColor(ChessColor.BLACK);
            a.setChessboard(chessboard);
            a.setSource(new ChessboardPoint(x,y));
            a.setChessboard2(findchessboard(chessboard));
            return a;
        }if(Objects.equals(name, "N")){
            ChessComponent a = new KnightChessComponent();
            a.name=name.charAt(0);
            a.setChessColor(ChessColor.BLACK);
            a.setChessboard(chessboard);
            a.setSource(new ChessboardPoint(x,y));
            a.setChessboard2(findchessboard(chessboard));
            return a;
        }if(Objects.equals(name, "B")){
            ChessComponent a = new BishopChessComponent();
            a.name=name.charAt(0);
            a.setChessColor(ChessColor.BLACK);
            a.setChessboard(chessboard);
            a.setSource(new ChessboardPoint(x,y));
            a.setChessboard2(findchessboard(chessboard));
            return a;
        }if(Objects.equals(name, "Q")){
            ChessComponent a = new QueenChessComponent();
            a.name=name.charAt(0);
            a.setChessColor(ChessColor.BLACK);
            a.setChessboard(chessboard);
            a.setSource(new ChessboardPoint(x,y));
            a.setChessboard2(findchessboard(chessboard));
            return a;
        }if(Objects.equals(name, "K")){
            ChessComponent a = new KingChessComponent();
            a.name=name.charAt(0);
            a.setChessColor(ChessColor.BLACK);
            a.setChessboard(chessboard);
            a.setSource(new ChessboardPoint(x,y));
            a.setChessboard2(findchessboard(chessboard));
            return a;
        }if(Objects.equals(name, "P")){
            ChessComponent a = new PawnChessComponent();
            a.name=name.charAt(0);
            a.setChessColor(ChessColor.BLACK);
            a.setChessboard(chessboard);
            a.setSource(new ChessboardPoint(x,y));
            a.setChessboard2(findchessboard(chessboard));
            return a;
        }if(Objects.equals(name, "r")){
            ChessComponent a = new RookChessComponent();
            a.name=name.charAt(0);
            a.setChessColor(ChessColor.WHITE);
            a.setChessboard(chessboard);
            a.setSource(new ChessboardPoint(x,y));
            a.setChessboard2(findchessboard(chessboard));
            return a;
        }if(Objects.equals(name, "n")){
            ChessComponent a = new KnightChessComponent();
            a.name=name.charAt(0);
            a.setChessColor(ChessColor.WHITE);
            a.setChessboard(chessboard);
            a.setSource(new ChessboardPoint(x,y));
            a.setChessboard2(findchessboard(chessboard));
            return a;
        }if(Objects.equals(name, "b")){
            ChessComponent a = new BishopChessComponent();
            a.name=name.charAt(0);
            a.setChessColor(ChessColor.WHITE);
            a.setChessboard(chessboard);
            a.setSource(new ChessboardPoint(x,y));
            a.setChessboard2(findchessboard(chessboard));
            return a;
        }if(Objects.equals(name, "q")){
            ChessComponent a = new QueenChessComponent();
            a.name=name.charAt(0);
            a.setChessColor(ChessColor.WHITE);
            a.setChessboard(chessboard);
            a.setSource(new ChessboardPoint(x,y));
            a.setChessboard2(findchessboard(chessboard));
            return a;
        }if(Objects.equals(name, "k")){
            ChessComponent a = new KingChessComponent();
            a.name=name.charAt(0);
            a.setChessColor(ChessColor.WHITE);
            a.setChessboard(chessboard);
            a.setSource(new ChessboardPoint(x,y));
            a.setChessboard2(findchessboard(chessboard));
            return a;
        }if(Objects.equals(name, "p")){
            ChessComponent a = new PawnChessComponent();
            a.name=name.charAt(0);
            a.setChessColor(ChessColor.WHITE);
            a.setChessboard(chessboard);
            a.setSource(new ChessboardPoint(x,y));
            a.setChessboard2(findchessboard(chessboard));
            return a;
        }return null;
    }
    public String[][] findchessboard(List<String> chessboard){
        String[][] chessboarda = new String[8][8];
        for (int i = 0; i < 8; i++) {
            String[] a = chessboard.get(i).split("");
            System.arraycopy(a, 0, chessboarda[i], 0, 8);
        }
        return chessboarda;
    }
    public List<String> reverfindchessboard(String[][] strings){
        List<String> a = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                sb.append(strings[i][j]);
            }String string = sb.toString();
            a.add(string);
        }if(currentPlayer==ChessColor.BLACK){
            a.add("b");
        }if(currentPlayer==ChessColor.WHITE){
            a.add("w");
        }
        return a;
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
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].name);
            }String line = sb.toString();
            strings.add(line);
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",strings.get(0),strings.get(1),strings.get(2),strings.get(3),strings.get(4),strings.get(5),strings.get(6),strings.get(7));
    }
    @Override
    public String getCapturedChess(ChessColor player) {
        if(player == ChessColor.BLACK){
            int[] black = new int[6];
            black[0] = 1 - checkhowmany('K');
            black[1] = 1 - checkhowmany('Q');
            black[2] = 2 - checkhowmany('R');
            black[3] = 2 - checkhowmany('B');
            black[4] = 2 - checkhowmany('N');
            black[5] = 8 - checkhowmany('P');
            List<String> blacks = findcapturechess(ChessColor.BLACK, black);
            int n = 0;
            for (int i = 0; i < 6; i++) {
                if(Objects.equals(blacks.get(i), "")){
                    n++;
                }
            }
            for (int i = blacks.size()-1; i >=0; i--) {
                String item = blacks.get(i);
                if("".equals(item)){
                    blacks.remove(item);
                }
            }
            if(n==0){
                return String.format("%s\n%s\n%s\n%s\n%s\n%s",blacks.get(0),blacks.get(1),blacks.get(2),blacks.get(3),blacks.get(4),blacks.get(5));
            }else{
                if(n==1){
                    return String.format("%s\n%s\n%s\n%s\n%s",blacks.get(0),blacks.get(1),blacks.get(2),blacks.get(3),blacks.get(4));
                }if(n==2){
                    return String.format("%s\n%s\n%s\n%s",blacks.get(0),blacks.get(1),blacks.get(2),blacks.get(3));
                }if(n==3){
                    return String.format("%s\n%s\n%s",blacks.get(0),blacks.get(1),blacks.get(2));
                }if(n==4){
                    return String.format("%s\n%s",blacks.get(0),blacks.get(1));
                }if(n==5){
                    return String.format("%s",blacks.get(0));
                }if(n==6){
                    return "";
                }
            }
        }if(player == ChessColor.WHITE){
            int[] white = new int[6];
            white[0] = 1 - checkhowmany('k');
            white[1] = 1 - checkhowmany('q');
            white[2] = 2 - checkhowmany('r');
            white[3] = 2 - checkhowmany('b');
            white[4] = 2 - checkhowmany('n');
            white[5] = 8 - checkhowmany('p');
            List<String> whites = findcapturechess(ChessColor.WHITE, white);
            int n = 0;
            for (int i = 0; i < 6; i++) {
                if(Objects.equals(whites.get(i), "")){
                    n++;
                }
            }
            for (int i = whites.size()-1; i >=0; i--) {
                String item = whites.get(i);
                if("".equals(item)){
                    whites.remove(item);
                }
            }
            if(n==0){
                return String.format("%s\n%s\n%s\n%s\n%s\n%s",whites.get(0),whites.get(1),whites.get(2),whites.get(3),whites.get(4),whites.get(5));
            }else{
                if(n==1){
                    return String.format("%s\n%s\n%s\n%s\n%s",whites.get(0),whites.get(1),whites.get(2),whites.get(3),whites.get(4));
                }if(n==2){
                    return String.format("%s\n%s\n%s\n%s",whites.get(0),whites.get(1),whites.get(2),whites.get(3));
                }if(n==3){
                    return String.format("%s\n%s\n%s",whites.get(0),whites.get(1),whites.get(2));
                }if(n==4){
                    return String.format("%s\n%s",whites.get(0),whites.get(1));
                }if(n==5){
                    return String.format("%s",whites.get(0));
                }if(n==6){
                    return "";
                }
            }
        }
        return null;
    }
    public int checkhowmany(char name){
        int n = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j].name==name){
                    n++;
                }
            }
        }return n;
    }
    public List<String> findcapturechess(ChessColor chessColor, int[] ints){
        List<String> strings = new ArrayList<>();
        if(chessColor == ChessColor.BLACK){
            if(ints[0]!=0){
                strings.add(String.format("K %d", ints[0]));
            }if(ints[0]==0){
                strings.add("");
            }if(ints[1]!=0){
                strings.add(String.format("Q %d", ints[1]));
            }if(ints[1]==0){
                strings.add("");
            }if(ints[2]!=0){
                strings.add(String.format("R %d", ints[2]));
            }if(ints[2]==0){
                strings.add("");
            }if(ints[3]!=0){
                strings.add(String.format("B %d", ints[3]));
            }if(ints[3]==0){
                strings.add("");
            }if(ints[4]!=0){
                strings.add(String.format("N %d", ints[4]));
            }if(ints[4]==0){
                strings.add("");
            }if(ints[5]!=0){
                strings.add(String.format("P %d", ints[5]));
            }if(ints[5]==0){
                strings.add("");
            }
        }if(chessColor == ChessColor.WHITE){
            if(ints[0]!=0){
                strings.add(String.format("k %d", ints[0]));
            }if(ints[0]==0){
                strings.add("");
            }if(ints[1]!=0){
                strings.add(String.format("q %d", ints[1]));
            }if(ints[1]==0){
                strings.add("");
            }if(ints[2]!=0){
                strings.add(String.format("r %d", ints[2]));
            }if(ints[2]==0){
                strings.add("");
            }if(ints[3]!=0){
                strings.add(String.format("b %d", ints[3]));
            }if(ints[3]==0){
                strings.add("");
            }if(ints[4]!=0){
                strings.add(String.format("n %d", ints[4]));
            }if(ints[4]==0){
                strings.add("");
            }if(ints[5]!=0){
                strings.add(String.format("p %d", ints[5]));
            }if(ints[5]==0){
                strings.add("");
            }
        }return strings;
    }
    public void swapColor() {
        currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        String[][] strings = chessComponents[0][0].getChessboard2();
        if(currentPlayer==chessComponents[sourceX][sourceY].getChessColor()){
            List<ChessboardPoint> chessboardPoints = chessComponents[sourceX][sourceY].canMoveTo();
            for (int i = 0; i < chessboardPoints.size(); i++) {
                if(chessboardPoints.get(i).getX()==targetX&&chessboardPoints.get(i).getY()==targetY){
                    strings[targetX][targetY]=strings[sourceX][sourceY];
                    strings[sourceX][sourceY]="_";
                    swapColor();
                    List<String> chessboard = reverfindchessboard(strings);
                    loadChessGame(chessboard);
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean canMovetoKing(int a, int b, int c, int d) {
        if (a == 0 && b == 0) {
            if (c == 0 && d == 1) {
                return true;
            }if (c == 1 && d == 0) {
                return true;
            }if (c == 1 && d == 1) {
                return true;
            }
        } else if (a == 0 && b == 7) {
            if (c == 0 && d == 6) {
                return true;
            }if (c == 1 && d == 6) {
                return true;
            }if (c == 1 && d == 7) {
                return true;
            }
        } else if (a == 7 && b == 0) {
            if (c == 6 && d == 0) {
                return true;
            }if (c == 6 && d == 1) {
                return true;
            }if (c == 7 && d == 1) {
                return true;
            }
        } else if (a == 7 && b == 7) {
            if (c == 7 && d == 6) {
                return true;
            }if (c == 6 && d == 6) {
                return true;
            }if (c == 6 && d == 7) {
                return true;
            }
        } else if (a == 0) {
            if (c == 0 && d == b-1) {
                return true;
            }if (c == 0 && d == b+1) {
                return true;
            }if (c == 1 && d == b-1) {
                return true;
            }if (c == 1 && d == b) {
                return true;
            }if (c == 1 && d == b+1) {
                return true;
            }
        } else if (a == 7) {
            if (c == 6 && d == b-1) {
                return true;
            }if (c == 6 && d == b) {
                return true;
            }if (c == 6 && d == b+1) {
                return true;
            }if (c == 7 && d == b-1) {
                return true;
            }if (c == 7 && d == b+1) {
                return true;
            }
        } else if (b == 0) {
            if (c == a-1 && d == 0) {
                return true;
            }if (c == a+1 && d == 0) {
                return true;
            }if (c == a-1 && d == 1) {
                return true;
            }if (c == a && d == 1) {
                return true;
            }if (c == a+1 && d == 1) {
                return true;
            }
        } else if (b == 7) {
            if (c == a-1 && d == 7) {
                return true;
            }if (c == a+1 && d == 7) {
                return true;
            }if (c == a-1 && d == 6) {
                return true;
            }if (c == a && d == 6) {
                return true;
            }if (c == a+1 && d == 6) {
                return true;
            }
        } else {
            if (c == a-1 && d == b-1) {
                return true;
            }if (c == a-1 && d == b) {
                return true;
            }if (c == a-1 && d == b+1) {
                return true;
            }if (c == a && d == b-1) {
                return true;
            }if (c == a && d == b+1) {
                return true;
            }if (c == a+1 && d == b-1) {
                return true;
            }if (c == a+1 && d == b) {
                return true;
            }if (c == a+1 && d == b+1) {
                return true;
            }
        }
        return false;
    }
    public static boolean canMovetoKnight(int a, int b, int c, int d) {
        int dx = Math.abs(c-a);
        int dy = Math.abs(d-b);
        if(dx!=0&&dy!=0){
            if(dx+dy==3){
                return true;
            }
        }return false;
    }
    public static boolean canMovetoPawn(int a, int b, int c, int d, ChessComponent chessComponent) {
        if(chessComponent.getChessColor()==ChessColor.BLACK){
            if(a==1){
                if(b==d){
                    if(c==a+1){
                        if(chessComponent.whichcolor(new ChessboardPoint(c,d))==ChessColor.NONE){
                            return true;
                        }
                    }if(c==a+2){
                        if(chessComponent.whichcolor(new ChessboardPoint(c-1,d))==ChessColor.NONE){
                            if(chessComponent.whichcolor(new ChessboardPoint(c,d))==ChessColor.NONE){
                                return true;
                            }
                        }
                    }
                }if(b!=d){
                    if(Math.abs(b-d)==1){
                        if(c==a+1){
                            if(chessComponent.whichcolor(new ChessboardPoint(c,d))==ChessColor.WHITE){
                                return true;
                            }
                        }
                    }
                }
            }if(a!=1){
                if(b==d){
                    if(c==a+1){
                        if(chessComponent.whichcolor(new ChessboardPoint(c,d))==ChessColor.NONE){
                            return true;
                        }
                    }
                }if(b!=d){
                    if(Math.abs(b-d)==1){
                        if(c==a+1){
                            if(chessComponent.whichcolor(new ChessboardPoint(c,d))==ChessColor.WHITE){
                                return true;
                            }
                        }
                    }
                }
            }
        }if(chessComponent.getChessColor()==ChessColor.WHITE){
            if(a==6){
                if(b==d){
                    if(c==a-1){
                        if(chessComponent.whichcolor(new ChessboardPoint(c,d))==ChessColor.NONE){
                            return true;
                        }
                    }if(c==a-2){
                        if(chessComponent.whichcolor(new ChessboardPoint(c+1,d))==ChessColor.NONE){
                            if(chessComponent.whichcolor(new ChessboardPoint(c,d))==ChessColor.NONE){
                                return true;
                            }
                        }
                    }
                }if(b!=d){
                    if(Math.abs(b-d)==1){
                        if(c==a-1){
                            if(chessComponent.whichcolor(new ChessboardPoint(c,d))==ChessColor.BLACK){
                                return true;
                            }
                        }
                    }
                }
            }if(a!=6){
                if(b==d){
                    if(c==a-1){
                        if(chessComponent.whichcolor(new ChessboardPoint(c,d))==ChessColor.NONE){
                            return true;
                        }
                    }
                }if(b!=d){
                    if(Math.abs(b-d)==1){
                        if(c==a-1){
                            if(chessComponent.whichcolor(new ChessboardPoint(c,d))==ChessColor.BLACK){
                                return true;
                            }
                        }
                    }
                }
            }
        }return false;
    }
    public static boolean canMovetoQueen(int a, int b, int c, int d, ChessComponent chessComponent) {
        if (a == c) {
            int row = a;
            for (int col = Math.min(b, d) + 1;
                 col < Math.max(b, d); col++) {
                if (chessComponent.whichcolor(new ChessboardPoint(row,col))!=ChessColor.NONE) {
                    return false;
                }
            }
            return true;
        } else if (b == d) {
            int col = b;
            for (int row = Math.min(a, c) + 1;
                 row < Math.max(a, c); row++) {
                if (chessComponent.whichcolor(new ChessboardPoint(row,col))!=ChessColor.NONE) {
                    return false;
                }
            }
            return true;
        }if (a != c&&b != d&&Math.abs(c - a) == Math.abs(d - b)) {
            if (c > a) {
                if (d > b) {
                    for (int time = 1; time < Math.abs(c - a); time++) {
                        if (chessComponent.whichcolor(new ChessboardPoint(a+time,b+time))!=ChessColor.NONE) {
                            return false;
                        }
                    }
                }
                if (d < b) {
                    for (int time = 1; time < Math.abs(c - a); time++) {
                        if (chessComponent.whichcolor(new ChessboardPoint(a+time,b-time))!=ChessColor.NONE) {
                            return false;
                        }
                    }
                }
            }
            if (c < a) {
                if (d > b) {
                    for (int time = 1; time < Math.abs(c - a); time++) {
                        if (chessComponent.whichcolor(new ChessboardPoint(a-time,b+time))!=ChessColor.NONE) {
                            return false;
                        }
                    }
                }
                if (d < b) {
                    for (int time = 1; time < Math.abs(c - a); time++) {
                        if (chessComponent.whichcolor(new ChessboardPoint(a-time,b-time))!=ChessColor.NONE) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    public static boolean canMovetoRook(int a, int b, int c, int d, ChessComponent chessComponent) {
        if(a==c){
            int row = a;
            for (int col = Math.min(b, d) + 1;
                 col < Math.max(b, d); col++) {
                if (chessComponent.whichcolor(new ChessboardPoint(row,col))!=ChessColor.NONE) {
                    return false;
                }
            }
        }else if(b==d){
            int col = b;
            for (int row = Math.min(a, c) + 1;
                 row < Math.max(a, c); row++) {
                if (chessComponent.whichcolor(new ChessboardPoint(row,col))!=ChessColor.NONE) {
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }
    public static boolean canMovetoBishop(int a, int b, int c, int d, ChessComponent chessComponent) {
        if (Math.abs(c - a) == Math.abs(d - b)) {
            if (c > a) {
                if (d > b) {
                    for (int time = 1; time < Math.abs(c - a); time++) {
                        if (chessComponent.whichcolor(new ChessboardPoint(a+time,b+time))!=ChessColor.NONE) {
                            return false;
                        }
                    }
                }
                if (d < b) {
                    for (int time = 1; time < Math.abs(c - a); time++) {
                        if (chessComponent.whichcolor(new ChessboardPoint(a+time,b-time))!=ChessColor.NONE) {
                            return false;
                        }
                    }
                }
            }
            if (c < a) {
                if (d > b) {
                    for (int time = 1; time < Math.abs(c - a); time++) {
                        if (chessComponent.whichcolor(new ChessboardPoint(a-time,b+time))!=ChessColor.NONE) {
                            return false;
                        }
                    }
                }
                if (d < b) {
                    for (int time = 1; time < Math.abs(c - a); time++) {
                        if (chessComponent.whichcolor(new ChessboardPoint(a-time,b-time))!=ChessColor.NONE) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}
