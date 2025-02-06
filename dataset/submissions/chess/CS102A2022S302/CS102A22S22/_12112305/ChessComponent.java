import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private static ChessComponent[][] chessComponents;

    public static ChessComponent[][] chessComponents() {
        return chessComponents;
    }

    public static void setChessComponents(ChessComponent[][] chessComponents) {
        ChessComponent.chessComponents = chessComponents;
    }

    public ConcreteChessGame getChessGame() {
        return chessGame;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setChessGame(ConcreteChessGame chessGame) {
        this.chessGame = chessGame;
    }

    protected ConcreteChessGame chessGame;

    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint chessboardPoint) {
        this.source = chessboardPoint;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public boolean isInChessBroad(int a,int b){
        if (a >= 0 && a <= 7 && b >= 0 && b <= 7){
            return true;
        }
        else return false;
    }



}

class KingChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = chessGame.getChessComponents();

                    int x = getSource().getX();
                    int y = getSource().getY();
                    List<ChessboardPoint> OVO = new ArrayList<>();
                    for (int i = x - 1; i < x + 2; i++) {
                        for (int j = y - 1; j < y + 2 ; j++) {
                            if (isInChessBroad(i,j)){
                                if (chessComponents[x][y].name > 'A' && chessComponents[x][y].name < 'Z'){
                                    if ((chessComponents[i][j].name > 'a' && chessComponents[i][j].name < 'z') ||
                                            chessComponents[i][j].name == '_'){
                                        OVO.add(new ChessboardPoint(i,j));
                                    }

                                }
                                if (chessComponents[x][y].name > 'a' && chessComponents[x][y].name < 'z'){
                                    if ((chessComponents[i][j].name > 'A' && chessComponents[i][j].name < 'Z') ||
                                            chessComponents[i][j].name == '_'){
                                        OVO.add(new ChessboardPoint(i,j));
                                    }
                                }
                            }
                        }
                    }
                    return OVO;
                }

}
class QueenChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}

class RookChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = chessGame.getChessComponents();
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> OVO = new ArrayList<>();
        for (int i = x + 1 ; i < x + 8; i++) {
            if (isInChessBroad(i,y)){
                if (chessComponents[x][y].name > 'A' && chessComponents[x][y].name < 'Z'){
                    if (chessComponents()[i][y].name == '_'){
                        OVO.add(new ChessboardPoint(i,y));
                    }
                    if (chessComponents[i][y].name > 'a' && chessComponents[i][y].name < 'z'){
                        OVO.add(new ChessboardPoint(i,y));
                        break;
                    }
                    if (chessComponents[i][y].name > 'A' && chessComponents[i][y].name < 'Z'){
                        break;
                    }
               }
                if (chessComponents[x][y].name > 'a' && chessComponents[x][y].name < 'z'){
                    if (chessComponents()[i][y].name == '_'){
                        OVO.add(new ChessboardPoint(i,y));
                    }
                    if (chessComponents[i][y].name > 'A' && chessComponents[i][y].name < 'Z'){
                        OVO.add(new ChessboardPoint(i,y));
                        break;
                    }
                    if (chessComponents[i][y].name > 'a' && chessComponents[i][y].name < 'z'){
                        break;
                    }
                }

            }
        }
        for (int i = x - 1; i > x - 8; i--) {
            if (isInChessBroad(i,y)){
                if (chessComponents[x][y].name > 'A' && chessComponents[x][y].name < 'Z'){
                    if (chessComponents[i][y].name == '_'){
                        OVO.add(new ChessboardPoint(i,y));
                    }
                    if (chessComponents[i][y].name > 'a' && chessComponents[i][y].name < 'z'){
                        OVO.add(new ChessboardPoint(i,y));
                        break;
                    }
                    if (chessComponents[i][y].name > 'A' && chessComponents[i][y].name < 'Z'){
                        break;
                    }
               }
                if (chessComponents[x][y].name > 'a' && chessComponents[x][y].name < 'z'){
                    if (chessComponents[i][y].name == '_'){
                        OVO.add(new ChessboardPoint(i,y));
                    }
                    if (chessComponents[i][y].name > 'A' && chessComponents[i][y].name < 'Z'){
                        OVO.add(new ChessboardPoint(i,y));
                        break;
                    }
                    if (chessComponents[i][y].name > 'a' && chessComponents[i][y].name < 'z'){
                        break;
                    }
                }
            }
        }
        for (int i = y + 1; i < y + 8; i++) {
            if (isInChessBroad(x,i)){
                if (chessComponents[x][y].name > 'a' && chessComponents[x][y].name < 'z'){
                    if (chessComponents[x][i].name == '_'){
                        OVO.add(new ChessboardPoint(x,i));
                    }
                    if (chessComponents[x][i].name > 'A' && chessComponents[x][i].name < 'Z'){
                        OVO.add(new ChessboardPoint(x,i));
                        break;
                    }
                    if (chessComponents[x][i].name > 'a' && chessComponents[x][i].name < 'z'){
                        break;
                    }
               }
                if (chessComponents[x][y].name > 'A' && chessComponents[x][y].name < 'Z'){
                    if (chessComponents[x][i].name == '_'){
                        OVO.add(new ChessboardPoint(x,i));
                    }
                    if (chessComponents[x][i].name > 'a' && chessComponents[x][i].name < 'z'){
                        OVO.add(new ChessboardPoint(x,i));
                        break;
                    }
                    if (chessComponents[x][i].name > 'A' && chessComponents[x][i].name < 'Z'){
                        break;
                    }
                }
            }
        }
        for (int i = y - 1; i > y - 8; i--) {
            if (isInChessBroad(x,i)){
                if (chessComponents[x][y].name > 'a' && chessComponents[x][y].name < 'z'){
                    if (chessComponents[x][i].name == '_'){
                        OVO.add(new ChessboardPoint(x,i));
                    }
                    if (chessComponents[x][i].name > 'A' && chessComponents[x][i].name < 'Z'){
                        OVO.add(new ChessboardPoint(x,i));
                        break;
                    }
                    if (chessComponents[x][i].name > 'a' && chessComponents[x][i].name < 'z'){
                        break;
                    }
               }
                if (chessComponents[x][y].name > 'A' && chessComponents[x][y].name < 'Z'){
                    if (chessComponents[x][i].name == '_'){
                        OVO.add(new ChessboardPoint(x,i));
                    }
                    if (chessComponents[x][i].name > 'a' && chessComponents[x][i].name < 'z'){
                        OVO.add(new ChessboardPoint(x,i));
                        break;
                    }
                    if (chessComponents[x][i].name > 'A' && chessComponents[x][i].name < 'Z'){
                        break;
                    }
                }
            }
        }
    return OVO;
    }
}

class BishopChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = chessGame.getChessComponents();
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> OVO = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            if (isInChessBroad(x + i, y + i)) {
                if (chessComponents[x][y].name > 'A' && chessComponents[x][y].name < 'Z') {
                    if (chessComponents[x + i][y + i].name == '_') {
                        OVO.add(new ChessboardPoint(x + i, y + i));
                    }
                    if (chessComponents[x + i][y + i].name > 'a' && chessComponents[x + i][y + i].name < 'z') {
                        OVO.add(new ChessboardPoint(x + i, y + i));
                        break;
                    }
                    if (chessComponents[x + i][y + i].name > 'A' && chessComponents[x + i][y + i].name < 'Z') {
                        break;
                    }
                }
                if (chessComponents[x][y].name > 'a' && chessComponents[x][y].name < 'z') {
                    if (chessComponents[x + i][y + i].name == '_') {
                        OVO.add(new ChessboardPoint(x + i, y + i));
                    }
                    if (chessComponents[x + i][y + i].name > 'A' && chessComponents[x + i][y + i].name < 'Z') {
                        OVO.add(new ChessboardPoint(x + i, y + i));
                        break;
                    }
                    if (chessComponents[x + i][y + i].name > 'a' && chessComponents[x + i][y + i].name < 'z') {
                        break;
                    }
                }
            }
        }
        for (int i = 1; i < 9; i++) {
            if (isInChessBroad(x - i, y + i)) {
                if (chessComponents[x][y].name > 'A' && chessComponents[x][y].name < 'Z') {
                    if (chessComponents[x - i][y + i].name == '_') {
                        OVO.add(new ChessboardPoint(x - i, y + i));
                    }
                    if (chessComponents[x - i][y + i].name > 'a' && chessComponents[x - i][y + i].name < 'z') {
                        OVO.add(new ChessboardPoint(x - i, y + i));
                        break;
                    }
                    if (chessComponents[x - i][y + i].name > 'A' && chessComponents[x - i][y + i].name < 'Z') {
                        break;
                    }
                }
                if (chessComponents[x][y].name > 'a' && chessComponents[x][y].name < 'z') {
                    if (chessComponents[x - i][y + i].name == '_') {
                        OVO.add(new ChessboardPoint(x - i, y + i));
                    }
                    if (chessComponents[x - i][y + i].name > 'A' && chessComponents[x - i][y + i].name < 'Z') {
                        OVO.add(new ChessboardPoint(x - i, y + i));
                        break;
                    }
                    if (chessComponents[x - i][y + i].name > 'a' && chessComponents[x - i][y + i].name < 'z') {
                        break;
                    }
                }
            }
        }
        for (int i = 1; i < 9; i++) {
            if (isInChessBroad(x + i, y - i)) {
                if (chessComponents[x][y].name > 'A' && chessComponents[x][y].name < 'Z') {
                    if (chessComponents[x + i][y - i].name == '_') {
                        OVO.add(new ChessboardPoint(x + i, y - i));
                    }
                    if (chessComponents[x + i][y - i].name > 'a' && chessComponents[x + i][y - i].name < 'z') {
                        OVO.add(new ChessboardPoint(x + i, y - i));
                        break;
                    }
                    if (chessComponents[x + i][y - i].name > 'A' && chessComponents[x + i][y - i].name < 'Z') {
                        break;
                    }
                }
                if (chessComponents[x][y].name > 'a' && chessComponents[x][y].name < 'z') {
                    if (chessComponents[x + i][y - i].name == '_') {
                        OVO.add(new ChessboardPoint(x + i, y - i));
                    }
                    if (chessComponents[x + i][y - i].name > 'A' && chessComponents[x + i][y - i].name < 'Z') {
                        OVO.add(new ChessboardPoint(x + i, y - i));
                        break;
                    }
                    if (chessComponents[x + i][y - i].name > 'a' && chessComponents[x + i][y - i].name < 'z') {
                        break;
                    }
                }
            }
        }
            for (int i = 1; i < 9; i++) {
                if (isInChessBroad(x - i, y - i)) {
                    if (chessComponents[x][y].name > 'A' && chessComponents[x][y].name < 'Z') {
                        if (chessComponents[x - i][y - i].name == '_') {
                            OVO.add(new ChessboardPoint(x - i, y - i));
                        }
                        if (chessComponents[x - i][y - i].name > 'a' && chessComponents[x - i][y - i].name < 'z') {
                            OVO.add(new ChessboardPoint(x - i, y - i));
                            break;
                        }
                        if (chessComponents[x - i][y - i].name > 'A' && chessComponents[x - i][y - i].name < 'Z') {
                            break;
                        }
                    }
                    if (chessComponents[x][y].name > 'a' && chessComponents[x][y].name < 'z') {
                        if (chessComponents[x - i][y - i].name == '_') {
                            OVO.add(new ChessboardPoint(x - i, y - i));
                        }
                        if (chessComponents[x - i][y - i].name > 'A' && chessComponents[x - i][y - i].name < 'Z') {
                            OVO.add(new ChessboardPoint(x - i, y - i));
                            break;
                        }
                        if (chessComponents[x - i][y - i].name > 'a' && chessComponents[x - i][y - i].name < 'z') {
                            break;
                        }
                    }
                }
            }


        return OVO;
    }
}

class KnightChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = chessGame.getChessComponents();
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> OVO = new ArrayList<>();
        if (chessComponents[x][y].name > 'A' && chessComponents[x][y].name < 'Z') {
            if (isInChessBroad(x - 2, y - 1)) {
                if (chessComponents[x - 2][y - 1].name == '_' || (chessComponents[x - 2][y - 1].name > 'a' && chessComponents[x - 2][y - 1].name < 'z')) {
                    OVO.add(new ChessboardPoint(x - 2, y - 1));
                }
            }
            if (isInChessBroad(x - 2,y + 1)){
                if (chessComponents[x - 2][y + 1].name == '_' || (chessComponents[x - 2][y + 1].name > 'a' && chessComponents[x - 2][y + 1].name < 'z')) {
                    OVO.add(new ChessboardPoint(x - 2, y + 1));
                }
            }
            if (isInChessBroad(x - 1, y - 2)){
                if (chessComponents[x - 1][y - 2].name == '_' || (chessComponents[x - 1][y - 2].name > 'a' && chessComponents[x - 1][y - 2].name < 'z')) {
                    OVO.add(new ChessboardPoint(x - 1, y - 2));
                }
            }
            if (isInChessBroad(x - 1,y + 2)){
                if (chessComponents[x - 1][y + 2].name == '_' || (chessComponents[x - 1][y + 2].name > 'a' && chessComponents[x - 1][y + 2].name < 'z')) {
                    OVO.add(new ChessboardPoint(x - 1, y + 2));
                }
            }
            if (isInChessBroad(x + 1,y - 2)){
                if (chessComponents[x + 1][y - 2].name == '_' || (chessComponents[x + 1][y - 2].name > 'a' && chessComponents[x + 1][y - 2].name < 'z')) {
                    OVO.add(new ChessboardPoint(x + 1, y - 2));
                }
            }
            if (isInChessBroad(x + 1,y + 2)){
                if (chessComponents[x + 1][y + 2].name == '_' || (chessComponents[x + 1][y + 2].name > 'a' && chessComponents[x + 1][y + 2].name < 'z')) {
                    OVO.add(new ChessboardPoint(x + 1, y + 2));
                }
            }
            if (isInChessBroad(x + 2,y - 1)){
                if (chessComponents[x + 2][y - 1].name == '_' || (chessComponents[x + 2][y - 1].name > 'a' && chessComponents[x + 2][y - 1].name < 'z')) {
                    OVO.add(new ChessboardPoint(x + 2, y - 1));
                }
            }
            if (isInChessBroad(x + 2,y + 1)){
                if (chessComponents[x + 2][y + 1].name == '_' || (chessComponents[x + 2][y + 1].name > 'a' && chessComponents[x + 2][y + 1].name < 'z')) {
                    OVO.add(new ChessboardPoint(x + 2, y + 1));
                }
            }
        }
        if (chessComponents[x][y].name > 'a' && chessComponents[x][y].name < 'z') {
            if (isInChessBroad(x - 2, y - 1)) {
                if (chessComponents[x - 2][y - 1].name == '_' || (chessComponents[x - 2][y - 1].name > 'A' && chessComponents[x - 2][y - 1].name < 'Z')) {
                    OVO.add(new ChessboardPoint(x - 2, y - 1));
                }
            }
            if (isInChessBroad(x - 2,y + 1)){
                if (chessComponents[x - 2][y + 1].name == '_' || (chessComponents[x - 2][y + 1].name > 'A' && chessComponents[x - 2][y + 1].name < 'Z')) {
                    OVO.add(new ChessboardPoint(x - 2, y + 1));
                }
            }
            if (isInChessBroad(x - 1, y - 2)){
                if (chessComponents[x - 1][y - 2].name == '_' || (chessComponents[x - 1][y - 2].name > 'A' && chessComponents[x - 1][y - 2].name < 'Z')) {
                    OVO.add(new ChessboardPoint(x - 1, y - 2));
                }
            }
            if (isInChessBroad(x - 1,y + 2)){
                if (chessComponents[x - 1][y + 2].name == '_' || (chessComponents[x - 1][y + 2].name > 'A' && chessComponents[x - 1][y + 2].name < 'Z')) {
                    OVO.add(new ChessboardPoint(x - 1, y + 2));
                }
            }
            if (isInChessBroad(x + 1,y - 2)){
                if (chessComponents[x + 1][y - 2].name == '_' || (chessComponents[x + 1][y - 2].name > 'A' && chessComponents[x + 1][y - 2].name < 'Z')) {
                    OVO.add(new ChessboardPoint(x + 1, y - 2));
                }
            }
            if (isInChessBroad(x + 1,y + 2)){
                if (chessComponents[x + 1][y + 2].name == '_' || (chessComponents[x + 1][y + 2].name > 'A' && chessComponents[x + 1][y + 2].name < 'Z')) {
                    OVO.add(new ChessboardPoint(x + 1, y + 2));
                }
            }
            if (isInChessBroad(x + 2,y - 1)){
                if (chessComponents[x + 2][y - 1].name == '_' || (chessComponents[x + 2][y - 1].name > 'A' && chessComponents[x + 2][y - 1].name < 'Z')) {
                    OVO.add(new ChessboardPoint(x + 2, y - 1));
                }
            }
            if (isInChessBroad(x + 2,y + 1)){
                if (chessComponents[x + 2][y + 1].name == '_' || (chessComponents[x + 2][y + 1].name > 'A' && chessComponents[x + 2][y + 1].name < 'Z')) {
                    OVO.add(new ChessboardPoint(x + 2, y + 1));
                }
            }
        }
        return OVO;
    }
}

class PawnChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}

class EmptySlotComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}


