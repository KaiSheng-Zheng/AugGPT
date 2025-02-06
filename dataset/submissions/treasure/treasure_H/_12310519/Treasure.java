public class Treasure {
        private final int score;
        private Position position;

        public Treasure(int score, Position position){
            this.score = score;
            this.position = position;
        }

        public int getScore() {
            return score;
        }

        public Position getPosition() {
            return position;
        }
    }


