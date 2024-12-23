package com.example.myapplication;

import java.util.Random;

public class StringProcess {
    static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + random.nextInt(26)); // Ký tự ngẫu nhiên từ 'a' đến 'z'
            builder.append(c);
        }
        return builder.toString();
    }

    // Hàm nối chuỗi
    static String concatenateString(String base, int times) {
        StringBuilder builder = new StringBuilder(base);
        for (int i = 0; i < times; i++) {
            builder.append(base);
        }
        return builder.toString();
    }

    // Hàm đảo chuỗi
    static String reverseString(String input) {
        // Chuyển chuỗi thành mảng ký tự
        char[] charArray = input.toCharArray();

        // Sử dụng hai con trỏ để đảo chuỗi
        int left = 0; // Con trỏ bắt đầu
        int right = charArray.length - 1; // Con trỏ kết thúc

        while (left < right) {
            // Hoán đổi ký tự tại vị trí left và right
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Di chuyển con trỏ
            left++;
            right--;
        }

        // Chuyển mảng ký tự thành chuỗi và trả về
        return new String(charArray);
    }

    // Hàm đếm ký tự
    static int countCharacter(String input, char character) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == character) {
                count++;
            }
        }
        return count;
    }
}
