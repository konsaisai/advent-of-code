package org.example;
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
