package com.visualnuts.exercises.list;

public class Exercise1 {

    public static void printNumber(int n) {
        for (int i = 1; i <= n; i++)
            System.out.println(getOutput(i));
    }

    private static String getOutput(int i) {
        if (i % 15 == 0)
            return "Visual Nuts";
        else if (i % 3 == 0)
            return "Visual";
        else if (i % 5 == 0)
            return "Nuts";
        else
            return String.valueOf(i);
    }

}
