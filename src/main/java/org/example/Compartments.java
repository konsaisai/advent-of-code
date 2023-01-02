package org.example;

public class Compartments {
    int score;

    String[] atoZ = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String lineCd = "\n";
    public int getScore() {
        return score;
    }

    public void checkRucksack(String input) {
        String firstCompartment = "";
        String secondCompartment = "";
        String[] rucksacks = input.split(lineCd);
        for (String rucksack: rucksacks) {
            //２つに分ける
            firstCompartment = rucksack.substring(0, rucksack.length() / 2);
            secondCompartment = rucksack.substring((rucksack.length() / 2));;

            //一致する文字を探し加点する
            String[] targets = {firstCompartment, secondCompartment};
            checkMatchString(targets);
        }
    }

    public void checkRucksackGroup(String input) {
        String[] rucksacks = input.split(lineCd);
        for (int i = 0; i < rucksacks.length; i = i + 3) {
            String[] targets = {rucksacks[i], rucksacks[i + 1], rucksacks[i + 2]};
            checkMatchString(targets);

        }
    }

    private void checkMatchString(String[] targets) {
        int score = 1;
        for (String str: atoZ) {
            boolean found = true;
            for (String target: targets) {
                if (!target.matches(".*" + str + ".*")) {
                    found = false;
                    break;
                }
            }
            if (found) {
                this.score = this.score + score;
                return;
            }
            score++;
        }
    }
}
