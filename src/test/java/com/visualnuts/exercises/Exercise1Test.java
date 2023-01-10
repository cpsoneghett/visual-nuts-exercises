package com.visualnuts.exercises;

import com.visualnuts.exercises.list.Exercise1;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class Exercise1Test {

    @Test
    public void testNumberValidation() {

        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOS);

        System.setOut(ps);

        String expected = "1\r\n2\r\nVisual\r\n4\r\nNuts\r\nVisual\r\n7\r\n8\r\nVisual\r\nNuts\r\n11\r\nVisual\r\n13\r\n14\r\nVisual Nuts\r\n";

        System.setOut(System.out);
        Exercise1.printNumber(15);
        String result = byteArrayOS.toString();

        assertEquals(expected, result);
    }
}
