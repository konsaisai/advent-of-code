package org.example;

public class CampCleanup {
    int completeDuplicatePair;
    int notDuplicatePair;
    int duplicatePair;

    CampCleanup() {
        this.completeDuplicatePair = 0;
    }

    public int getDuplicatePair(){
        return this.duplicatePair;
    }

    public int getCompleteDuplicatePair(){
        return this.completeDuplicatePair;
    }
    public void checkSections(String input) {
        String[] sections = input.split("\n");
        for (String section : sections) {
            String[] list = section.split(",");
            String[] nums1 = list[0].split("-");
            String[] nums2 = list[1].split("-");

            int num1low = Integer.parseInt(nums1[0]);
            int num1high = Integer.parseInt(nums1[1]);
            int num2low = Integer.parseInt(nums2[0]);
            int num2high = Integer.parseInt(nums2[1]);

            //完全に含まれる
            if ((num1low <= num2low && num2high <= num1high)
                || (num2low <= num1low && num1high <= num2high)){
                this.completeDuplicatePair++;
            }
            //完全に含まれない
            if ((num1high < num2low) || (num2high < num1low)){
                this.notDuplicatePair++;
            }
        }
        this.duplicatePair = sections.length - this.notDuplicatePair;
    }

}
