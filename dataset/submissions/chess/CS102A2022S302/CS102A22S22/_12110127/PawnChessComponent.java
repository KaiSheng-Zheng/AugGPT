import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private int x, y;
    private ChessColor chessColor;
    int maxSteps = 0;
    private ArrayList<ChessboardPoint> moveDirection = directions.All();
    private ArrayList<ChessboardPoint> B_eatDirection = directions.BEat();
    private ArrayList<ChessboardPoint> W_eatDirection = directions.WEat();
    boolean B_firstMove=true;
    boolean W_firstMove=true;

    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
        super(chessboardPoint, chessColor, name);
        x = chessboardPoint.getX();
        y = chessboardPoint.getY();
        this.chessColor = chessColor;
        super.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> goodPoints = new ArrayList<>();
        if (this.chessColor.equals(ChessColor.BLACK)) {
            moveDirection = directions.BPawn();
            if (B_firstMove) {
                maxSteps = 2;
                for (ChessboardPoint direct : moveDirection) {
                    for (int i = 1; i <= maxSteps; i++) {
                        ChessboardPoint currP = ChessboardPoint.sum(this.getSource(), ChessboardPoint.product(direct, i));
                        if (currP.offset()) {
                            break;
                        }
                        if (this.getFatherGame().getChess(currP).getChessColor().equals(ChessColor.NONE)) {
                            goodPoints.add(currP);
                        } else if (this.getFatherGame().getChess(currP).getChessColor().equals(this.getChessColor())) {
                            break;
                        } else {
                            break;
                        }
                        B_firstMove = false;
                    }
                    for (ChessboardPoint eat_direct : B_eatDirection) {
                        for (int j = 1; j <=1 ; j++) {
                            ChessboardPoint eat_currP = ChessboardPoint.sum(this.getSource(), ChessboardPoint.product(eat_direct, j));
                            if (!this.getFatherGame().getChess(eat_currP).getChessColor().equals(this.getChessColor())) { // incorrect, this will include empty slot.
                                goodPoints.add(eat_currP);
                                break;
                            }
                        }
                    }

                }
            }else {
                maxSteps = 1;
                for (ChessboardPoint direct : moveDirection) {
                    for (int i = 1; i <= maxSteps; i++) {
                        ChessboardPoint currP = ChessboardPoint.sum(this.getSource(), ChessboardPoint.product(direct, i));
                        if (currP.offset()) {
                            break;
                        }
                        if (this.getFatherGame().getChess(currP).getChessColor().equals(ChessColor.NONE)) {
                            goodPoints.add(currP);
                        } else if (this.getFatherGame().getChess(currP).getChessColor().equals(this.getChessColor())) {
                            break;
                        } else  {
                            break;
                        }

                        for (ChessboardPoint eat_direct : B_eatDirection) {
                            for (int j = 1; j <=maxSteps ; j++) {
                                ChessboardPoint eat_currP = ChessboardPoint.sum(this.getSource(), ChessboardPoint.product(eat_direct, j));
                                if (!this.getFatherGame().getChess(eat_currP).getChessColor().equals(this.getChessColor())) {
                                    goodPoints.add(eat_currP);
                                    break;
                                }
                            }
                        }break;
                    }
                }
            }
        }
        if (this.chessColor.equals(ChessColor.WHITE)){
            moveDirection=directions.WPawn();
            if (W_firstMove){
                maxSteps=2;
                for (ChessboardPoint direct : moveDirection) {
                    for (int i = 1; i <= maxSteps; i++) {
                        ChessboardPoint currP = ChessboardPoint.sum(this.getSource(), ChessboardPoint.product(direct, i));
                        if (currP.offset()) {
                            break;
                        }
                        if (this.getFatherGame().getChess(currP).getChessColor().equals(ChessColor.NONE)) {
                            goodPoints.add(currP);
                        } else if (this.getFatherGame().getChess(currP).getChessColor().equals(this.getChessColor())) {
                            break;
                        } else {
                            break;
                        }
                        for (ChessboardPoint eat_direct : W_eatDirection) {
                            for (int j = 1; j <=1 ; j++) {
                                ChessboardPoint eat_currP = ChessboardPoint.sum(this.getSource(), ChessboardPoint.product(eat_direct, j));
                                if (!this.getFatherGame().getChess(eat_currP).getChessColor().equals(this.getChessColor())) {
                                    goodPoints.add(eat_currP);
                                    break;
                                }
                            }
                        }
                    }

                    W_firstMove=false;
                }
            }else {
                maxSteps=1;
                for (ChessboardPoint direct : moveDirection) {
                    for (int i = 1; i <= maxSteps; i++) {
                        ChessboardPoint currP = ChessboardPoint.sum(this.getSource(), ChessboardPoint.product(direct, i));
                        if (currP.offset()) {
                            break;
                        }
                        if (this.getFatherGame().getChess(currP).getChessColor().equals(ChessColor.NONE)) {
                            goodPoints.add(currP);
                        } else if (this.getFatherGame().getChess(currP).getChessColor().equals(this.getChessColor())) {
                            break;
                        } else {
                            break;
                        }

                        for (ChessboardPoint eat_direct : W_eatDirection) {
                            for (int j = 1; j <=1 ; j++) {
                                ChessboardPoint eat_currP = ChessboardPoint.sum(this.getSource(), ChessboardPoint.product(eat_direct, j));
                                if (!this.getFatherGame().getChess(eat_currP).getChessColor().equals(this.getChessColor())) {
                                    goodPoints.add(eat_currP);
                                    break;
                                }
                            }
                        }break;
                    }
                }
            }
        }
        return goodPoints;
    }
}