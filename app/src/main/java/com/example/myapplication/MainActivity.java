package com.example.myapplication;

import static com.example.myapplication.BubbleSort.bubbleSort;
import static com.example.myapplication.BubbleSort.generateRandomArray;
import static com.example.myapplication.CalculateCircleArea.calculateCircleArea;
import static com.example.myapplication.SieveOfEratosthenes.sieveOfEratosthenes;
import static com.example.myapplication.StringProcess.concatenateString;
import static com.example.myapplication.StringProcess.countCharacter;
import static com.example.myapplication.StringProcess.generateRandomString;
import static com.example.myapplication.StringProcess.reverseString;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.BitSet;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("myapplication");
    }
    public native long measureJniOverhead(long javaTimestamp);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextLimit = findViewById(R.id.editTextLimit);
        Button calculatePrimesButton = findViewById(R.id.calculatePrimesButton);
        TextView primesTextView = findViewById(R.id.primesTextView);

        calculatePrimesButton.setOnClickListener(new View.OnClickListener() {
            //tim so nguyen to(so nguyen)
//            @Override
//            public void onClick(View view) {
//                String limitString = editTextLimit.getText().toString();
//                if (!limitString.isEmpty()) {
//                    int limit = Integer.parseInt(limitString);
//                    // Chuyển xử lý sang Background Thread
//                    new Thread(() -> {
//                        long startTime = System.nanoTime();
//                        sieveOfEratosthenes(limit); // Thực hiện tính toán
//                        long endTime = System.nanoTime();
//                        long duration = endTime - startTime;
//
//                        // Cập nhật giao diện trên UI Thread
//                        runOnUiThread(() -> {
//                            primesTextView.setText("Time taken: " + duration +" ns" + "\n" + duration/1000000 + "ms");
//                        });
//                    }).start();
//                }
//            }

            //tinh dien tich hinh tron(dau phay dong)
//            @Override
//            public void onClick(View view) {
//                String radiusString = editTextLimit.getText().toString();
//                if (!radiusString.isEmpty()) {
//                    double radius = Double.parseDouble(radiusString);
//
//                    // Bắt đầu đo thời gian
//                    long startTime = System.nanoTime();
//
//                    // Tính diện tích hình tròn
//                    calculateCircleArea(radius);
//
//                    // Kết thúc đo thời gian
//                    long endTime = System.nanoTime();
//                    long duration = endTime - startTime;
//
//                    // Hiển thị thời gian tính toán
//                    primesTextView.setText("Time taken: " + duration + " ns");
//                }
//            }

            //Bubble sort (truy cap bo nho
//            public void onClick(View view) {
//                String sizeString = editTextLimit.getText().toString();
//                if (!sizeString.isEmpty()) {
//                    int size = Integer.parseInt(sizeString);
//
//                    // Tạo mảng ngẫu nhiên
//                    int[] array = generateRandomArray(size);
//
//                    // Đo thời gian thực thi Bubble Sort
//                    long startTime = System.nanoTime();
//                    bubbleSort(array);
//                    long endTime = System.nanoTime();
//
//                    // Tính thời gian thực thi
//                    long duration = endTime - startTime;
//
//                    // Hiển thị kết quả
//                    primesTextView.setText("Array size: " + size + "\nTime taken: " + duration / 1_000_000 + " ms");
//                }
//            }

            //xu ly chuoi
//            @Override
//            public void onClick(View view) {
//                String lengthString = editTextLimit.getText().toString();
//            //if (!lengthString.length() == 0 ) {
//                int length = Integer.parseInt(lengthString);
//
//                // Tạo chuỗi ngẫu nhiên
//                String randomString = generateRandomString(length);
//
//                // Đo thời gian nối chuỗi
//                long startConcat = System.nanoTime();
//                String concatenatedString = concatenateString(randomString, 10);
//                long endConcat = System.nanoTime();
//
//                // Đo thời gian đảo chuỗi
//                long startReverse = System.nanoTime();
//                String reversedString = reverseString(randomString);
//                long endReverse = System.nanoTime();
//
//                // Đo thời gian đếm ký tự
//                long startCount = System.nanoTime();
//                int charCount = countCharacter(randomString, 'a');
//                long endCount = System.nanoTime();
//
//                // Hiển thị kết quả
//                primesTextView.setText("String Length: " + length + "\n" +
//                        "Concatenation Time: " + (endConcat - startConcat) / 1_000_000 + " ms\n" +
//                        "Reverse Time: " + (endReverse - startReverse) / 1_000_000 + " ms\n" +
//                        "Character Count Time: " + (endCount - startCount) / 1_000_000 + " ms\n" +
//                        "Occurrences of 'a': " + charCount);
//            }


            //tre JNI
            @Override
            public void onClick(View view) {
                String iterationsString = editTextLimit.getText().toString();
                if (!iterationsString.isEmpty()) {
                    int iterations = Integer.parseInt(iterationsString);

                    // Biến để lưu tổng thời gian
                    long totalDelay = 0;

                    for (int i = 0; i < iterations; i++) {
                        // Ghi lại thời gian trước khi gọi JNI
                        long javaTimestamp = System.nanoTime();

                        // Gọi hàm native để đo độ trễ
                        long delay = measureJniOverhead(javaTimestamp);

                        // Cộng dồn thời gian trễ
                        totalDelay += delay;
                    }

                    // Tính thời gian trung bình
                    double averageDelay = (double) totalDelay / iterations;

                    // Hiển thị kết quả
                    primesTextView.setText("Total JNI Overhead: " + totalDelay / 1_000_000 + " ms\n" +
                            "Average JNI Call Overhead: " + averageDelay + " ns");
                }
            }
        });
    }


}
