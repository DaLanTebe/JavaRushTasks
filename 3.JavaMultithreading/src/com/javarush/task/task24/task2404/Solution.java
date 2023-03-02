package com.javarush.task.task24.task2404;

/* 
Рефакторинг Rectangle
*/

public class Solution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
        ///////////////////expected//////////////////
        System.out.println(getHeight(rectangle.castToHasHeight()));
        System.out.println(getWidth(rectangle.castToHasWidth()));
    }

    public static double getHeight(HasHeight rectangle) {
        return rectangle.castToHasHeight();
    }

    public static double getWidth(HasWidth rectangle) {
        return rectangle.castToHasWidth();
    }


    public static class Rectangle {
        private Point point1;
        private Point point2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            point1 = new Point(x1, y1);
            point2 = new Point(x2, y2);
        }

        public HasHeight castToHasHeight() {

            class HasHeight implements com.javarush.task.task24.task2404.HasHeight {
                int x1;
                int y1;

                public HasHeight(int x, int y) {
                    this.x1 = x;
                    this.y1 = y;
                }

                @Override
                public double castToHasHeight() {
                    return Math.abs(x1 - y1);
                }
            }
            return castToHasHeight();
        }

        public HasWidth castToHasWidth() {
            class HasWidth implements com.javarush.task.task24.task2404.HasWidth {
                int x2;
                int y2;

                public HasWidth(int x2, int y2) {
                    this.x2 = x2;
                    this.y2 = y2;
                }

                @Override
                public double castToHasWidth() {
                    return Math.abs(x2 - y2);
                }
            }
            return castToHasWidth();
        }
    }
}
