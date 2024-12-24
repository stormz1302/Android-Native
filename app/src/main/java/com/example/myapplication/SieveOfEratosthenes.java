package com.example.myapplication;

import java.util.BitSet;

public class SieveOfEratosthenes {
    public static double sieveOfEratosthenes(int m, int n) {
        double sum = 0.0; // Biến lưu tổng nghịch đảo thời gian thực thi

        for (int iteration = 0; iteration < m; iteration++) {
            long startTime = System.nanoTime(); // Bắt đầu đo thời gian

            // Sử dụng BitSet để lưu trạng thái số nguyên tố
            BitSet isPrime = new BitSet(n + 1);
            isPrime.set(0, false); // 0 không phải số nguyên tố
            isPrime.set(1, false); // 1 không phải số nguyên tố
            isPrime.set(2, n + 1, true); // Đặt tất cả số từ 2 đến n là nguyên tố

            // Thuật toán Sàng Eratosthenes
            for (int p = 2; p * p <= n; p++) {
                if (isPrime.get(p)) {
                    for (int i = p * p; i <= n; i += p) {
                        isPrime.set(i, false); // Đánh dấu bội số không phải nguyên tố
                    }
                }
            }

            long endTime = System.nanoTime(); // Kết thúc đo thời gian
            long executionTime = endTime - startTime; // Thời gian thực thi tính bằng nano giây
            sum += 1.0 / executionTime; // Cộng thêm nghịch đảo thời gian thực thi vào tổng
        }

        return m / sum; // Tính m / sum và trả về
    }
}
