

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height,
                         Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        super.overLapconflict=true;
    }
    public void fillGrids(Location location,char[][]c){
        double ratio;
        ratio=1.0*height/width;

        if(d.equals(Direction.LEFT_UP)){
            for(int j=0;j<width;j++){
                for(int i=0;i<height;i++){
                    if(1.0*j/(i+1)<1/ratio) {
                        if(location.getX()+height - 1 - i<c.length&&location.getY()+j<c[0].length&&c[location.getX()+height - 1 - i][location.getY()+j]==' '){
                            c[location.getX()+height - 1 - i][location.getY()+j] = pattern;
                            super.area+=1;
                        }else{
                            super.overLapconflict=false;
                        }
                    }
                }
            }
        }
        if(d.equals(Direction.LEFT_DOWN)){
            for(int j=0;j<width;j++){
                for(int i=0;i<height;i++){
                    if(1.0*j/(i+1)<1/ratio){
                        if(location.getX()+i<c.length&&location.getY()+j<c[0].length&&c[location.getX()+i][location.getY()+j]==' '){
                            c[location.getX()+i][location.getY()+j]=pattern;
                            super.area+=1;
                        }else{
                            super.overLapconflict=false;
                        }
                    }
                }
            }
        }
        if(d.equals(Direction.RIGHT_UP)){
            for(int j=0;j<width;j++){
                for(int i=0;i<height;i++){
                    if(1.0*j/(i+1)<1/ratio){
                        if(location.getX()+height-1-i<c.length&&location.getY()+width-1-j<c[0].length&&c[location.getX()+height-1-i][location.getY()+width-1-j]==' '){
                            c[location.getX()+height-1-i][location.getY()+width-1-j]=pattern;
                            super.area+=1;
                        }else{
                            super.overLapconflict=false;
                        }
                    }
                }
            }
        }
        if(d.equals(Direction.RIGHT_DOWN)){
            for(int j=0;j<width;j++){
                for(int i=0;i<height;i++){
                    if(1.0*j/(i+1)<1/ratio){
                        if(location.getX()+i<c.length&&location.getY()+width-1-j<c[0].length&&c[location.getX()+i][location.getY()+width-1-j]==' '){
                            c[location.getX()+i][location.getY()+width-1-j]=pattern;
                            super.area+=1;
                        }else{
                            super.overLapconflict=false;
                        }
                    }
                }
            }
        }

    }
    public boolean judgeFull(Location location,char[][]c){
        double ratio;
        ratio=1.0*height/width;

        if(d.equals(Direction.LEFT_UP)){
            for(int j=0;j<width;j++){
                for(int i=0;i<height;i++){
                    if(1.0*j/(i+1)<1/ratio) {
                        if(location.getX()+height - 1 - i<c.length&&location.getY()+j<c[0].length&&c[location.getX()+height - 1 - i][location.getY()+j]==' '){

                        }else{
                            super.overLapconflict=false;
                        }
                    }
                }
            }
        }
        if(d.equals(Direction.LEFT_DOWN)){
            for(int j=0;j<width;j++){
                for(int i=0;i<height;i++){
                    if(1.0*j/(i+1)<1/ratio){
                        if(location.getX()+i<c.length&&location.getY()+j<c[0].length&&c[location.getX()+i][location.getY()+j]==' '){

                        }else{
                            super.overLapconflict=false;
                        }
                    }
                }
            }
        }
        if(d.equals(Direction.RIGHT_UP)){
            for(int j=0;j<width;j++){
                for(int i=0;i<height;i++){
                    if(1.0*j/(i+1)<1/ratio){
                        if(location.getX()+height-1-i<c.length&&location.getY()+width-1-j<c[0].length&&c[location.getX()+height-1-i][location.getY()+width-1-j]==' '){
                        }else{
                            super.overLapconflict=false;
                        }
                    }
                }
            }
        }
        if(d.equals(Direction.RIGHT_DOWN)){
            for(int j=0;j<width;j++){
                for(int i=0;i<height;i++){
                    if(1.0*j/(i+1)<1/ratio){
                        if(location.getX()+i<c.length&&location.getY()+width-1-j<c[0].length&&c[location.getX()+i][location.getY()+width-1-j]==' '){

                        }else{
                            super.overLapconflict=false;
                        }
                    }
                }
            }
        }
        return overLapconflict;
    }
    public void fillOverlap(Location location,char[][]c){
        double ratio;
        ratio=1.0*height/width;

        if(d.equals(Direction.LEFT_UP)){
            for(int j=0;j<width;j++){
                for(int i=0;i<height;i++){
                    if(1.0*j/(i+1)<1/ratio) {
                        super.area+=1;
                        if(location.getX()+height - 1 - i<c.length&&location.getY()+j<c[0].length){
                            c[location.getX()+height - 1 - i][location.getY()+j] = pattern;
                            super.overLap=true;
                        }

                    }
                }
            }
        }
        if(d.equals(Direction.LEFT_DOWN)){
            for(int j=0;j<width;j++){
                for(int i=0;i<height;i++){
                    if(1.0*j/(i+1)<1/ratio){
                        super.area+=1;
                        if(location.getX()+i<c.length&&location.getY()+j<c[0].length){
                            c[location.getX()+i][location.getY()+j]=pattern;
                            super.overLap=true;
                        }
                    }
                }
            }
        }
        if(d.equals(Direction.RIGHT_UP)){
            for(int j=0;j<width;j++){
                for(int i=0;i<height;i++){
                    if(1.0*j/(i+1)<1/ratio){
                        super.area+=1;
                        if(location.getX()+height-1-i<c.length&&location.getY()+width-1-j<c[0].length){
                            c[location.getX()+height-1-i][location.getY()+width-1-j]=pattern;
                            super.overLap=true;
                        }
                    }
                }
            }
        }
        if(d.equals(Direction.RIGHT_DOWN)){
            for(int j=0;j<width;j++){
                for(int i=0;i<height;i++){
                    if(1.0*j/(i+1)<1/ratio){
                        super.area+=1;
                        if(location.getX()+i<c.length&&location.getY()+width-1-j<c[0].length){
                            c[location.getX()+i][location.getY()+width-1-j]=pattern;
                            super.overLap=true;
                        }
                    }
                }
            }
        }

    }
    //    @Override
//    public void enlarge() {
//        height+=1;
//        width+=1;
//        fillGrids();
//    }
//    @Override
//    public void shrink() {
//        height-=1;
//        width-=1;
//        fillGrids();
//    }


    public String toString(){
        return "RightTriangle: ("+this.location.getX()+","+this.location.getY()+") area="+super.getArea()+" pattern="+this.pattern;

    }
}