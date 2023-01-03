package org.example;
import java.util.Arrays;

class Elf {
    int[] elfCalories;

    //エルフごとのカロリーの総数を降順で取得
    public void setSumCaloriesForElf(String input){
        String lineCd = "\n";
        //エルフの数ごとにループ
        String[] elves = input.split(lineCd + lineCd);
        int[] elvesCalories = new int[elves.length];
        for (int i = 0; i < elves.length; i++) {
            int sumCalories = 0;
            //各エルフのカロリーの数ごとにループ
            String[] calorie = elves[i].split(lineCd);
            for (String s : calorie) {
                sumCalories = sumCalories + Integer.parseInt(s);
                elvesCalories[i] = sumCalories;
            }
        }
        this.elfCalories = sortDesc(elvesCalories);
    }

    public int getTopSumCalories(int number){
        int top3Calories = 0;
        for (int i = 0; i < number; i++) {
            top3Calories = top3Calories + this.elfCalories[i];
        }
        return top3Calories;
    }

    private static int[] sortDesc(int[] data) {
        Arrays.sort(data);
        for (int f = 0, l = data.length - 1; f < l; f++, l--){
            int temp = data[f];
            data[f]  = data[l];
            data[l] = temp;
        }
        return data;
    }
}
