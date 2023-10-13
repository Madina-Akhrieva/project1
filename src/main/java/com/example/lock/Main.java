package com.example.lock;

public class Main {
    public static double findAngle(int hour, int minute) {
        // Проверка на корректность входных данных
        if (hour < 0 || hour > 12 || minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Некорректное время");
        }

        // Преобразование часов в углы
        double hourAngle = (hour % 12 + minute / 60.0) * 30;

        // Преобразование минут в углы
        double minuteAngle = minute * 6;

        // Вычисление разницы между углами
        double angle = Math.abs(hourAngle - minuteAngle);

        // Выбор наименьшего угла (не более 180 градусов)
        if (angle > 180) {
            angle = 360 - angle;
        }

        return angle;
    }

    public static void main(String[] args) {
        int hour = 5;
        int minute = 30;

        double angle = findAngle(hour, minute);
        System.out.println("Угол между стрелками: " + angle + " градусов");
    }
}
