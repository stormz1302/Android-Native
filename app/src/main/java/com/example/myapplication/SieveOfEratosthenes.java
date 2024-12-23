package com.example.myapplication;

import java.util.BitSet;

public class SieveOfEratosthenes {
    static void sieveOfEratosthenes(int limit) {
        // Sử dụng BitSet để lưu trạng thái số nguyên tố
        BitSet isPrime = new BitSet(limit + 1);
        isPrime.set(0, false); // 0 không phải số nguyên tố
        isPrime.set(1, false); // 1 không phải số nguyên tố
        isPrime.set(2, limit + 1, true); // Đặt tất cả số từ 2 trở lên là nguyên tố

        // Thuật toán Sàng Eratosthenes
        for (int p = 2; p * p <= limit; p++) {
            if (isPrime.get(p)) {
                for (int i = p * p; i <= limit; i += p) {
                    isPrime.set(i, false); // Đánh dấu bội số không phải nguyên tố
                }
            }
        }
    }
}
