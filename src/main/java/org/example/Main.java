package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

class Elf {
    int[] elfCalories;

    //エルフごとのカロリーの総数を降順で取得
    public void setSumCaloriesForElf(String input){
        String lineCd = "\n";
        //エルフの数ごとにループ
        String[] elfs = input.split(lineCd + lineCd);
        int[] elfsCalories = new int[elfs.length];
        for (int i = 0; i < elfs.length; i++) {
            int sumCalories = 0;
            //各エルフのカロリーの数ごとにループ
            String[] calorie = elfs[i].split(lineCd);
            for (String s : calorie) {
                sumCalories = sumCalories + Integer.parseInt(s);
                elfsCalories[i] = sumCalories;
            }
        }
        this.elfCalories = sortDesc(elfsCalories);
    }

    public int getTopSumCalories(int number){
        int top3Calories = 0;
        for (int i = 0; i < number; i++) {
            top3Calories = top3Calories + this.elfCalories[i];
        }
        return top3Calories;
    }

    public static int[] sortDesc(int[] data) {
        Arrays.sort(data);
        for (int f = 0, l = data.length - 1; f < l; f++, l--){
            int temp = data[f];
            data[f]  = data[l];
            data[l] = temp;
        }
        return data;
    }
}

public class Main {
    public static void main(String[] args) {
        String input = "";
        try {
            //TODO 相対パスで指定したい
            input = readFile("/Users/aya/IdeaProjects/AdventOfCode2022_Day1/src/main/java/org/example/input.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Elf elf = new Elf();
        elf.setSumCaloriesForElf(input);
        System.out.println("最も多くカロリーを持っているエルフのカロリー：" + elf.getTopSumCalories(1));
        System.out.println("上位３人の総カロリー：" + elf.getTopSumCalories(3));
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