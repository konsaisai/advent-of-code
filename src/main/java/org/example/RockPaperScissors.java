package org.example;

public class RockPaperScissors {
    int partnerScore;
    int myselfScore;
    //敵　 A:Rock +1 B:Paper +2 C:Scissors +3
    //自分 X:Rock +1 Y:Paper +2 Z:Scissors +3
    //負け:+0　引き分け:+3　勝ち:+6

    int loserPoint = 0;
    int drawPoint = 3;
    int winnerPoint = 6;
    int rockPoint = 1;
    int paperPoint = 2;
    int scissorsPoint = 3;

    public void Judge(String input) {
        String[] turns = input.split("\n");
        for (String turn : turns) {
            addJudgement(turn);
        }
    }

    public int getMyselfScore() {
        return this.myselfScore;
    }

    private void addJudgement(String input) {

        String[] shapes = input.split(" ");
        addShapePoint(shapes[0]);
        //addShapePoint(shapes[1]);

        switch (input) {
            //引き分け
//            case "A X", "B Y", "C Z" -> {
            case "A Y", "B Y", "C Y" -> {
                this.partnerScore = this.partnerScore + drawPoint;
                this.myselfScore = this.myselfScore + drawPoint;
                switch (shapes[0]) {
                    case "A" -> addShapePoint("X");
                    case "B" -> addShapePoint("Y");
                    case "C" -> addShapePoint("Z");
                }
            }
            //敵の勝ち
//            case "A Z", "B X", "C Y" -> {
            case "A X", "B X", "C X" -> {
                this.partnerScore = this.partnerScore + winnerPoint;
                this.myselfScore = this.myselfScore + loserPoint;
                switch (shapes[0]) {
                    case "A" -> addShapePoint("Z");
                    case "B" -> addShapePoint("X");
                    case "C" -> addShapePoint("Y");
                }
            }
            //自分の勝ち
//            case "A Y", "B Z", "C X" -> {
            case "A Z", "B Z", "C Z" -> {
                this.partnerScore = this.partnerScore + loserPoint;
                this.myselfScore = this.myselfScore + winnerPoint;
                switch (shapes[0]) {
                    case "A" -> addShapePoint("Y");
                    case "B" -> addShapePoint("Z");
                    case "C" -> addShapePoint("X");
                }
            }
        }

    }

    private void addShapePoint(String input) {
        switch (input) {
            case "A" -> this.partnerScore = this.partnerScore + rockPoint;
            case "B" -> this.partnerScore = this.partnerScore + paperPoint;
            case "C" -> this.partnerScore = this.partnerScore + scissorsPoint;
            case "X" -> this.myselfScore = this.myselfScore + rockPoint;
            case "Y" -> this.myselfScore = this.myselfScore + paperPoint;
            case "Z" -> this.myselfScore = this.myselfScore + scissorsPoint;
        }
    }


}
