import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessColor chessColor) {
        super(chessColor);
        if (chessColor == ChessColor.BLACK){
            name = 'B';
        }else {
            name = 'b';
        }
}
    public BishopChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint) {
        super(chessColor,chessboardPoint);
        if (chessColor == ChessColor.BLACK){
            name = 'B';
        }else {
            name = 'b';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        if (chessColor == ChessColor.BLACK){
            int x = source.getX();
            int y = source.getY();
            if (x > y){
                for (int i = y - 1; i >= 0; i--) {
                    if (chessComponents[x + i - y][i].name == '_'){
                        chessboardPoints.add(new ChessboardPoint(x + i - y,i));
                    }else if (chessComponents[x + i - y][i].chessColor == ChessColor.WHITE){
                        chessboardPoints.add(new ChessboardPoint(x + i - y,i));
                        break;
                    }else{
                        break;
                    }
                }
                for (int i = x + 1; i < 8; i++) {
                    if (chessComponents[i][y + i - x].name == '_'){
                        chessboardPoints.add(new ChessboardPoint(i,y + i - x));
                    }else if (chessComponents[i][y + i - x].chessColor == ChessColor.WHITE){
                        chessboardPoints.add(new ChessboardPoint(i,y + i - x));
                        break;
                    }else {
                        break;
                    }
                }
                if (7 - x < y){
                    for (int i = x + 1; i < 8; i++) {
                        if (chessComponents[i][y - i + x].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                        }else if (chessComponents[i][y - i + x].chessColor == ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                            break;
                        }else{
                            break;
                        }
                    }
                    for (int i = y + 1; i < 8; i++) {
                        if (chessComponents[x - i + y][i].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(x - i + y,i));
                        }else if (chessComponents[x - i + y][i].chessColor == ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(x - i + y,i));
                            break;
                        }else{
                            break;
                        }
                    }
                }else {
                    for (int i = y - 1; i >= 0; i--) {
                        if (chessComponents[x + y - i][i].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(x + y - i,i));
                        }else if (chessComponents[x + y - i][i].chessColor == ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(x + y - i,i));
                            break;
                        }else{
                            break;
                        }
                    }
                    for (int i = x - 1; i >= 0; i--) {
                        if (chessComponents[i][y - i + x].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                        }else if (chessComponents[i][y - i + x].chessColor == ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                            break;
                        }else{
                            break;
                        }
                    }
                }
            }else {
                for (int i = x - 1; i >= 0; i--) {
                    if (chessComponents[i][y - x + i].name == '_'){
                        chessboardPoints.add(new ChessboardPoint(i,y - x + i));
                    }else if (chessComponents[i][y - x + i].chessColor == ChessColor.WHITE){
                        chessboardPoints.add(new ChessboardPoint(i,y - x + i));
                        break;
                    }else{
                        break;
                    }
                }
                for (int i = y + 1; i < 8; i++) {
                    if (chessComponents[x + i - y][i].name == '_'){
                        chessboardPoints.add(new ChessboardPoint(x + i - y,i));
                    }else if (chessComponents[x + i - y][i].chessColor == ChessColor.WHITE){
                        chessboardPoints.add(new ChessboardPoint(x + i - y,i));
                        break;
                    }else {
                        break;
                    }
                }
                if (7 - x < y){
                    for (int i = x + 1; i < 8; i++) {
                        if (chessComponents[i][y - i + x].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                        }else if (chessComponents[i][y - i + x].chessColor == ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                            break;
                        }else{
                            break;
                        }
                    }
                    for (int i = y + 1; i < 8; i++) {
                        if (chessComponents[x - i + y][i].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(x - i + y,i));
                        }else if (chessComponents[x - i + y][i].chessColor == ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(x - i + y,i));
                            break;
                        }else{
                            break;
                        }
                    }
                }else {
                    for (int i = y - 1; i >= 0; i--) {
                        if (chessComponents[x + y - i][i].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(x + y - i,i));
                        }else if (chessComponents[x + y - i][i].chessColor == ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(x + y - i,i));
                            break;
                        }else{
                            break;
                        }
                    }
                    for (int i = x - 1; i >= 0; i--) {
                        if (chessComponents[i][y - i + x].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                        }else if (chessComponents[i][y - i + x].chessColor == ChessColor.WHITE){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                            break;
                        }else{
                            break;
                        }
                    }
                }
            }
        }else if (chessColor == ChessColor.WHITE){
            int x = source.getX();
            int y = source.getY();
            if (x > y){
                for (int i = y - 1; i >= 0; i--) {
                    if (chessComponents[x + i - y][i].name == '_'){
                        chessboardPoints.add(new ChessboardPoint(x + i - y,i));
                    }else if (chessComponents[x + i - y][i].chessColor == ChessColor.BLACK){
                        chessboardPoints.add(new ChessboardPoint(x + i - y,i));
                        break;
                    }else{
                        break;
                    }
                }
                for (int i = x + 1; i < 8; i++) {
                    if (chessComponents[i][y + i - x].name == '_'){
                        chessboardPoints.add(new ChessboardPoint(i,y + i - x));
                    }else if (chessComponents[i][y + i - x].chessColor == ChessColor.BLACK){
                        chessboardPoints.add(new ChessboardPoint(i,y + i - x));
                        break;
                    }else {
                        break;
                    }
                }
                if (7 - x < y){
                    for (int i = x + 1; i < 8; i++) {
                        if (chessComponents[i][y - i + x].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                        }else if (chessComponents[i][y - i + x].chessColor == ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                            break;
                        }else{
                            break;
                        }
                    }
                    for (int i = y + 1; i < 8; i++) {
                        if (chessComponents[x - i + y][i].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(x - i + y,i));
                        }else if (chessComponents[x - i + y][i].chessColor == ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(x - i + y,i));
                            break;
                        }else{
                            break;
                        }
                    }
                }else {
                    for (int i = y - 1; i >= 0; i--) {
                        if (chessComponents[x + y - i][i].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(x + y - i,i));
                        }else if (chessComponents[x + y - i][i].chessColor == ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(x + y - i,i));
                            break;
                        }else{
                            break;
                        }
                    }
                    for (int i = x - 1; i >= 0; i--) {
                        if (chessComponents[i][y - i + x].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                        }else if (chessComponents[i][y - i + x].chessColor == ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                            break;
                        }else{
                            break;
                        }
                    }
                }
            }else {
                for (int i = x - 1; i >= 0; i--) {
                    if (chessComponents[i][y - x + i].name == '_'){
                        chessboardPoints.add(new ChessboardPoint(i,y - x + i));
                    }else if (chessComponents[i][y - x + i].chessColor == ChessColor.BLACK){
                        chessboardPoints.add(new ChessboardPoint(i,y - x + i));
                        break;
                    }else{
                        break;
                    }
                }
                for (int i = y + 1; i < 8; i++) {
                    if (chessComponents[x + i - y][i].name == '_'){
                        chessboardPoints.add(new ChessboardPoint(x + i - y,i));
                    }else if (chessComponents[x + i - y][i].chessColor == ChessColor.BLACK){
                        chessboardPoints.add(new ChessboardPoint(x + i - y,i));
                        break;
                    }else {
                        break;
                    }
                }
                if (7 - x < y){
                    for (int i = x + 1; i < 8; i++) {
                        if (chessComponents[i][y - i + x].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                        }else if (chessComponents[i][y - i + x].chessColor == ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                            break;
                        }else{
                            break;
                        }
                    }
                    for (int i = y + 1; i < 8; i++) {
                        if (chessComponents[x - i + y][i].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(x - i + y,i));
                        }else if (chessComponents[x - i + y][i].chessColor == ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(x - i + y,i));
                            break;
                        }else{
                            break;
                        }
                    }
                }else {
                    for (int i = y - 1; i >= 0; i--) {
                        if (chessComponents[x + y - i][i].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(x + y - i,i));
                        }else if (chessComponents[x + y - i][i].chessColor == ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(x + y - i,i));
                            break;
                        }else{
                            break;
                        }
                    }
                    for (int i = x - 1; i >= 0; i--) {
                        if (chessComponents[i][y - i + x].name == '_'){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                        }else if (chessComponents[i][y - i + x].chessColor == ChessColor.BLACK){
                            chessboardPoints.add(new ChessboardPoint(i,y - i + x));
                            break;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return chessboardPoints;
    }

}
