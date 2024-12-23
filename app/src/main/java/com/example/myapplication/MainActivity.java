package com.example.myapplication;

import static com.example.myapplication.BubbleSort.bubbleSort;
import static com.example.myapplication.BubbleSort.generateRandomArray;
import static com.example.myapplication.CalculateCircleArea.calculateCircleArea;
import static com.example.myapplication.SieveOfEratosthenes.sieveOfEratosthenes;
import static com.example.myapplication.StringProcess.concatenateString;
import static com.example.myapplication.StringProcess.countCharacter;
import static com.example.myapplication.StringProcess.generateRandomString;
import static com.example.myapplication.StringProcess.reverseString;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //ket noi C++
    static {
        System.loadLibrary("myapplication");
    }
    public native long measureJniOverhead(long javaTimestamp);
    public native void sieveOfEratosthenesNDK(int limit);
    public native void calculateCircleAreaNDK(double radiusLimit);
    public native void bubbleSortNDK(int countLoop);
    public native void concatStringNDK(int countLoop);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        View tab1 = findViewById(R.id.tab1);
        View tab2 = findViewById(R.id.tab2);
        View tab3 = findViewById(R.id.tab3);
        View tab4 = findViewById(R.id.tab4);
        View tab5 = findViewById(R.id.tab5);

        tabLayout.addTab(tabLayout.newTab().setText("Số nguyên"));
        tabLayout.addTab(tabLayout.newTab().setText("Dấu phẩy động"));
        tabLayout.addTab(tabLayout.newTab().setText("Truy cập bộ nhớ"));
        tabLayout.addTab(tabLayout.newTab().setText("Trễ JNI"));
        tabLayout.addTab(tabLayout.newTab().setText("Xử lý chuỗi"));


        // Xử lý chuyển đổi tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                tab1.setVisibility(position == 0 ? View.VISIBLE : View.GONE);
                tab2.setVisibility(position == 1 ? View.VISIBLE : View.GONE);
                tab3.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
                tab4.setVisibility(position == 3 ? View.VISIBLE : View.GONE);
                tab5.setVisibility(position == 4 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        // Xử lý sự kiện cho tab 1
        setupTabFunctionality1(
                findViewById(R.id.editTextLimitTab1),
                findViewById(R.id.editTextLimitTab1_2),
                findViewById(R.id.calculatePrimesButtonTab1_1),
                findViewById(R.id.calculatePrimesButtonTab1_2),
                findViewById(R.id.primesTextViewTab1));

        // Xử lý sự kiện cho tab 2
        setupTabFunctionality2(
                findViewById(R.id.editTextLimitTab2),
                findViewById(R.id.editTextLimitTab2_2),
                findViewById(R.id.calculatePrimesButtonTab2_1),
                findViewById(R.id.calculatePrimesButtonTab2_2),
                findViewById(R.id.primesTextViewTab2));

        // Xử lý sự kiện cho tab 3
        setupTabFunctionality3(
                findViewById(R.id.editTextLimitTab3),
                findViewById(R.id.editTextLimitTab3_2),
                findViewById(R.id.calculatePrimesButtonTab3_1),
                findViewById(R.id.calculatePrimesButtonTab3_2),
                findViewById(R.id.primesTextViewTab3));

        // Xử lý sự kiện cho tab 4
        setupTabFunctionality4(
                findViewById(R.id.editTextLimitTab4),
                findViewById(R.id.editTextLimitTab4_2),
                findViewById(R.id.calculatePrimesButtonTab4_1),
                findViewById(R.id.calculatePrimesButtonTab4_2),
                findViewById(R.id.primesTextViewTab4));

        // Xử lý sự kiện cho tab 5
        setupTabFunctionality5(
                findViewById(R.id.editTextLimitTab5),
                findViewById(R.id.editTextLimitTab5_2),
                findViewById(R.id.calculatePrimesButtonTab5_1),
                findViewById(R.id.calculatePrimesButtonTab5_2),
                findViewById(R.id.primesTextViewTab5));

        // Lặp lại cho các tab còn lại
    }

    // ======= SO NGUYEN =======
    private void setupTabFunctionality1(EditText editText, EditText editText_2, Button buttonNDK, Button buttonJava, TextView textView) {
        buttonJava.setOnClickListener(v -> {
            String countLoop = editText.getText().toString();
            String limit = editText_2.getText().toString();
            if (!limit.isEmpty() && !countLoop.isEmpty()) {
                int n = Integer.parseInt(limit);
                int m = Integer.parseInt(countLoop);
                double result = sieveOfEratosthenes(m, n); // Thực hiện tính toán
                textView.setText("Result: " + result +" ns\n Total Time: " + m * result/ 1000000 + "ms");
            }
        });
        buttonNDK.setOnClickListener(v -> {
            int n = Integer.parseInt(editText.getText().toString());
            long startTime = System.nanoTime();
            sieveOfEratosthenesNDK(n);
            long endTime = System.nanoTime();
            long result = endTime - startTime;
            textView.setText(result + "ns");
        });
    }

    // ======= DAU PHAY DONG =======
    private void setupTabFunctionality2(EditText editText, EditText editText_2, Button buttonNDK, Button buttonJava, TextView textView) {
        buttonJava.setOnClickListener(v -> {
            String text = editText.getText().toString();
            String radius = editText_2.getText().toString();
                if (!text.isEmpty()) {
                    double countLoop = Integer.parseInt(text);
                    double radiusLimit = Double.parseDouble(radius);

                    // Bắt đầu đo thời gian
                    long startTime = System.nanoTime();

                    // Tính diện tích hình tròn với countLoop lần
                    double result = calculateCircleArea(countLoop, radiusLimit);

                    // Kết thúc đo thời gian
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;

                    // Hiển thị thời gian tính toán
                    textView.setText("Result: " + result +" ns\nTime taken: " + duration /1000000 + " ms");
                }
        });
        buttonNDK.setOnClickListener(v -> {
            double radiusLimit = Double.parseDouble(editText.getText().toString());
            // Bắt đầu đo thời gian
            long startTime = System.nanoTime();
            calculateCircleAreaNDK(radiusLimit);
            // Kết thúc đo thời gian
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            // Hiển thị thời gian tính toán
            textView.setText("Time taken: " + duration + " ns");
        });
    }

    // ======= TRUY CAP BO NHO =======
    private void setupTabFunctionality3(EditText editText, EditText editText_2, Button buttonNDK, Button buttonJava, TextView textView) {
        buttonJava.setOnClickListener(v -> {
            String countLoop = editText.getText().toString();
            String arraySize = editText_2.getText().toString();
                if (!arraySize.isEmpty() && !countLoop.isEmpty()) {
                    int n = Integer.parseInt(arraySize);
                    int m = Integer.parseInt(countLoop);
                    // Tạo mảng ngẫu nhiên
                    // Đo thời gian thực thi Bubble Sort
                    long startTime = System.nanoTime();
                    double result = bubbleSort(m, n);
                    long endTime = System.nanoTime();

                    // Tính thời gian thực thi
                    long duration = endTime - startTime;

                    // Hiển thị kết quả
                    textView.setText("Result: " + result + "ns\nTotal Time: " + duration / 1_000_000 + " ms");
                }
        });

        buttonNDK.setOnClickListener(v -> {
            int countLoop = Integer.parseInt(editText.getText().toString());
            // Bắt đầu đo thời gian
            long startTime = System.nanoTime();

            bubbleSortNDK(countLoop);

            // Kết thúc đo thời gian
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            // Hiển thị thời gian tính toán
            textView.setText("Time taken: " + duration + " ns");
        });
    }

    // ======= TRE JNI =======
    private void setupTabFunctionality4(EditText editText, EditText editText_2, Button buttonNDK, Button buttonJava, TextView textView) {
        buttonJava.setOnClickListener(v -> {
            String loopCount = editText.getText().toString();
            //String arraySize = editText_2.getText().toString();
            if (!loopCount.isEmpty()) {
                long m = Integer.parseInt(loopCount);
                // Ghi lại thời gian trước khi gọi JNI
                double sum = 0.0;
                for (int i = 0; i < m; i++){
                    long javaTimestamp = System.nanoTime();
                    // Gọi hàm native để đo độ trễ
                    long delay = measureJniOverhead(javaTimestamp);
                    System.out.println("Delay: " + delay + " ns");
                    sum += (double) 1 / delay;
                    System.out.println("Sum: " + sum);
                }
                //System.out.println("Sum: " + sum);
                double result = m/sum;

                // Hiển thị kết quả
                textView.setText("Result: " + result + " ns\nTotal Time: " + m * result/ 1000000 + "ms");
            }
        });
    }

    // ======= XU LY CHUOI =======
    private void setupTabFunctionality5(EditText editText, EditText editText_2, Button buttonNDK, Button buttonJava, TextView textView) {
        buttonJava.setOnClickListener(v -> {
            String lengthString = editText.getText().toString();
            //if (!lengthString.length() == 0 ) {
                int length = Integer.parseInt(lengthString);

                // Tạo chuỗi ngẫu nhiên
                String randomString = generateRandomString(length);

                // Đo thời gian nối chuỗi
                long startConcat = System.nanoTime();
                String concatenatedString = concatenateString(randomString, 10);
                long endConcat = System.nanoTime();

                // Đo thời gian đảo chuỗi
                long startReverse = System.nanoTime();
                String reversedString = reverseString(randomString);
                long endReverse = System.nanoTime();

                // Đo thời gian đếm ký tự
                long startCount = System.nanoTime();
                int charCount = countCharacter(randomString, 'a');
                long endCount = System.nanoTime();

                // Hiển thị kết quả
            textView.setText("String Length: " + length + "\n" +
                        "Concatenation Time: " + (endConcat - startConcat) / 1_000_000 + " ms\n" +
                        "Reverse Time: " + (endReverse - startReverse) / 1_000_000 + " ms\n" +
                        "Character Count Time: " + (endCount - startCount) / 1_000_000 + " ms\n" +
                        "Occurrences of 'a': " + charCount);
        });

        buttonNDK.setOnClickListener(v -> {
            int countLoop = Integer.parseInt(editText.getText().toString());
            // Bắt đầu đo thời gian
            long startTime = System.nanoTime();

            concatStringNDK(countLoop);

            // Kết thúc đo thời gian
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            // Hiển thị thời gian tính toán
            textView.setText("Time taken: " + duration + " ns");
        });
    }
}
