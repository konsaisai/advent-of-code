package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Objects;

public class SupplyStacks {
    ArrayList<Object> crates = new ArrayList<>();

    public void getDrawing(String input) {
        String[] inputs = input.split("\n");
        for (int i = (inputs.length - 1); i >= 0; i--) {
            int stackCnt = 1;
            int createCnt = 0;
            //[Z] [M] [P]
            if (inputs[i].contains("[")) {
                String[] wk_creates = inputs[i].split("");
                for (int j = 0; j <= wk_creates.length; j = j + 4) {
                    Deque<String> stackQue = (Deque<String>) this.crates.get(createCnt);
                    if (!Objects.equals(wk_creates[j + 1], " ")) {
                        stackQue.add(wk_creates[j + 1]);
                        this.crates.set(createCnt, stackQue);
                    }
                    createCnt++;
                }
            } else {
                String[] wk_creates = inputs[i].split("");
                for (int j = 0; j <= wk_creates.length; j = j + 4) {
                    crates.add(new ArrayDeque<>());
                }
            }
        }
    }

    public void moveStacks(String input) {
        String[] inputs = input.split("\n");
        for (String procedure: inputs) {
            procedure = procedure.replace("move ", "").replace("from ", "").replace("to ", "");
            String[] nums = procedure.split(" ");
            int moveCnt = Integer.parseInt(nums[0]);
            int fromCnt = Integer.parseInt(nums[1]);
            int toCnt = Integer.parseInt(nums[2]);
            Deque<String> wkQue = new ArrayDeque<>();
            Deque<String> fromQue = (Deque<String>) this.crates.get(fromCnt - 1);
            Deque<String> toQue = (Deque<String>) this.crates.get(toCnt - 1);

            for (int i = 0; i < moveCnt; i++) {
                wkQue.add(fromQue.getLast());
                //toQue.add(fromQue.getLast());
                fromQue.removeLast();
                this.crates.set(fromCnt - 1, fromQue);
                //this.crates.set(toCnt - 1, toQue);
            }

            int wkQueSize = wkQue.size();
            for (int i = 0; i < wkQueSize; i++) {
                toQue.add(wkQue.getLast());
                wkQue.removeLast();
            }
            this.crates.set(toCnt - 1, toQue);
        }
    }

    public String getEndsUpOnTop() {
        StringBuilder tops = new StringBuilder();
        for (Object crate : this.crates) {
            Deque<String> create = (Deque<String>) crate;
            tops.append(create.getLast());
        }

        return tops.toString();
    }
}
