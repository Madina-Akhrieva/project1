package com.example.linkedlistnode;


import java.util.Scanner;

/*
* In this updated implementation, the main function reads the input from stdin.
* It first reads the integer n, which represents the size of the linked list.
* Then, it reads n integers representing the binary digits.

The getNumber function remains the same and converts the binary number represented
*  by the linked list to a decimal number.

After calculating the decimal number using the getNumber function, the result is
* printed to the console.

Please make sure to provide the input values according to the specified format when
* running the program.
* */

public class Main {
    public static int getNumber(LinkedListNode binary) {
        int decimal = 0;
        int power = 0;

        while (binary != null) {
            decimal += binary.data * Math.pow(2, power);
            binary = binary.next;
            power++;
        }

        return decimal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        LinkedListNode head = null;
        LinkedListNode current = null;

        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            LinkedListNode node = new LinkedListNode(data);

            if (head == null) {
                head = node;
                current = node;
            } else {
                current.next = node;
                current = node;
            }
        }

        int decimalNumber = getNumber(head);
        System.out.println("Decimal number: " + decimalNumber);

        scanner.close();
    }
}
