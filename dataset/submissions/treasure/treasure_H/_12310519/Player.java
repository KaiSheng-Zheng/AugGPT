public class Player {
        private final int id;
        private int score = 0;
        private int steps = 0;
        private Position position;
        private Map map;
        private int maxStepAllowed = 100000;

        static int count = 0;

        public Player( Map map, Position initialPosition){
            this.map = map;
            this.position = initialPosition;
            id = ++count;
        }
        public Player(Map map, Position initialPosition, int maxStepAllowed){
            this.map = map;
            this.position = initialPosition;
            this.maxStepAllowed = maxStepAllowed;
            id = ++count;
        }



        public boolean move(Direction direction, int steps){
            boolean result = false;
            if(!this.getMap().isActive()){
                return result;
            }
            if(this.getMaxStepAllowed() == 0){
                return result;
            }
            if(this.getSteps() == this.getMaxStepAllowed()){
                result = false;
                return result;
            }
            if((this.getMaxStepAllowed()> 0) && (this.getSteps() + steps <= this.getMaxStepAllowed()) ) {
                for (int i = 1; i <= steps ; i++) {
                    if ((this.getPosition().getCol() + direction.getCol() >= 0) && (this.getPosition().getCol() + direction.getCol() <= (this.getMap().getColumns() - 1)) && (this.getPosition().getRow() + direction.getRow() >= 0) && (this.getPosition().getRow() + direction.getRow() <= (this.getMap().getRows() - 1))) {
                        this.getPosition().setCol(this.getPosition().getCol() + direction.getCol());
                        this.getPosition().setRow(this.getPosition().getRow() + direction.getRow());
                        this.setSteps(this.getSteps() + 1);
                    } else {
                        result = false;
                        return result;
                    }
                    if(this.getMap().hasTreasure(this.getPosition()) != 0){
                        this.setScore(this.getScore() + this.getMap().hasTreasure(this.getPosition()));
                        this.getMap().update(this.getPosition());
                    }
                    if(!this.getMap().isActive()){
                        result = false;
                        return result;
                    }
                }
                result = true;
                return result;
            }
            if((this.getMaxStepAllowed() > 0) && (steps +this.getSteps() > this.getMaxStepAllowed())) {
                int NowSteps = this.getSteps();
                for (int i = 1; i <= (this.getMaxStepAllowed() -NowSteps) ; i++) {
                    if ((this.getPosition().getCol() + direction.getCol() >= 0) && (this.getPosition().getCol() + direction.getCol() <= (this.getMap().getColumns() - 1)) && (this.getPosition().getRow() + direction.getRow() >= 0) && (this.getPosition().getRow() + direction.getRow() <= (this.getMap().getRows() - 1))) {
                        this.getPosition().setCol(this.getPosition().getCol() + direction.getCol());
                        this.getPosition().setRow(this.getPosition().getRow() + direction.getRow());
                        this.setSteps(this.getSteps() + 1);
                    } else {
                        result = false;
                        return result;
                    }
                    if(this.getMap().hasTreasure(this.getPosition()) != 0){
                        this.setScore(this.getScore() + this.getMap().hasTreasure(this.getPosition()));
                        this.getMap().update(this.getPosition());
                    }
                    if(!this.getMap().isActive()){
                        result = false;
                        return result;
                    }
                }
                result = false;
                return result;

            }
            result = true;
            return result;
        }
        public boolean equals(Object player){
            Player player1 = (Player) player;
            boolean result = false;
            if(this.id == player1.id){
                result = true;
                return  result;
            }else{
                return result;
            }
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public void setSteps(int steps) {
            this.steps = steps;
        }

        public void setPosition(Position position) {
            this.position = position;
        }

        public Map getMap() {
            return map;
        }

        public void setMap(Map map) {
            this.map = map;
        }

        public int getMaxStepAllowed() {
            return maxStepAllowed;
        }

        public void setMaxStepAllowed(int maxStepAllowed) {
            this.maxStepAllowed = maxStepAllowed;
        }

        public int getId() {
            return id;
        }

        public int getScore() {
            return score;
        }

        public int getSteps() {
            return steps;
        }

        public Position getPosition() {
            return position;
        }

    }


