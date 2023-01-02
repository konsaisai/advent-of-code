package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        String input = "";
        try {
//            //Day1
//            //TODO 相対パスで指定したい
//            input = readFile("/Users/aya/IdeaProjects/AdventOfCode2022_Day1/src/main/java/org/example/Day1_input.txt");
//            Elf elf = new Elf();
//            elf.setSumCaloriesForElf(input);
//            System.out.println("最も多くカロリーを持っているエルフのカロリー：" + elf.getTopSumCalories(1));
//            System.out.println("上位３人の総カロリー：" + elf.getTopSumCalories(3));

//            //Day2
//            input = readFile("/Users/aya/IdeaProjects/AdventOfCode2022_Day1/src/main/java/org/example/Day2_input.txt");
//            RockPaperScissors rps = new RockPaperScissors();
//            rps.Judge(input);
//            System.out.println("私のスコア：" + rps.getMyselfScore());

            //Day3
            input = readFile("/Users/aya/IdeaProjects/AdventOfCode2022_Day1/src/main/java/org/example/Day3_input.txt");
            Compartments compartments = new Compartments();
//            compartments.checkRucksack(input);
            compartments.checkRucksackGroup(input);
            System.out.println("結果:" + compartments.getScore());


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }






    }


    public static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        String data = "";
        try {
            data = Files.readString(path);
        } catch(IOException ex) {
            ex.printStackTrace();
            throw new IOException("指定されたファイルが見つかりません");
        }
        return data;
    }

}