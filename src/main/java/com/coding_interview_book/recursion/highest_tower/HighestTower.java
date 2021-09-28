package com.coding_interview_book.recursion.highest_tower;

import java.util.Arrays;

public class HighestTower {

    public static void main(String[] args) {

        Box[] boxes = new Box[]{new Box(10, 5, 2),
                                new Box(10, 7, 1),
                                new Box(10, 3, 1),
                                new Box(14, 10, 3),
                                new Box(5, 2, 1),
                                new Box(7, 5, 3),
                                new Box(2, 8, 1)};

        Arrays.sort(boxes, (o1, o2) -> (o1.getWidth() - o2.getWidth()) * -1);

        int[][] cache = new int[boxes.length][boxes.length];

        System.out.println(new HighestTower().highestTower(0, 0, boxes, cache));

    }

    private int highestTower(int start, int base, Box[] boxes, int[][] cache) {
        if (start >= boxes.length) {
            return 0;
        }

        if (cache[start][base] == 0) {
            int max = 0;

            for (int i = start; i < boxes.length; i++) {
                if (i != base && canUse(base, i, boxes)) {
                    max = Math.max(highestTower(start + 1, i, boxes, cache), max);
                }
            }
            cache[start][base] = max + boxes[base].getHeight() + 1;
        }
        return cache[start][base] - 1;
    }

    private boolean canUse(int thisIdx, int i, Box[] boxes) {
        return boxes[thisIdx].getColor() != boxes[i].getColor() &&  boxes[thisIdx].getWidth() > boxes[i].getWidth();
    }

    private static class Box {
        public Box(int width, int height, int color) {
            this.width = width;
            this.height = height;
            this.color = color;
        }

        private int width;
        private int height;
        private int color;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }
    }

}


