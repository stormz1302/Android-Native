#include <jni.h>
#include <chrono>
#include <string>

extern "C"
JNIEXPORT jlong JNICALL
Java_com_example_myapplication_MainActivity_measureJniOverhead(
        JNIEnv* env,
        jobject /* this */,
        jlong javaTimestamp) {
    // Ghi lại thời gian ngay khi hàm native được gọi
    auto nativeStartTime = std::chrono::high_resolution_clock::now();

    // Tính thời gian từ Java đến Native
    auto nativeTimestamp = std::chrono::duration_cast<std::chrono::nanoseconds>(
            nativeStartTime.time_since_epoch()).count();

    // Ghi lại thời gian sau khi xử lý
    auto nativeEndTime = std::chrono::high_resolution_clock::now();
    auto duration = std::chrono::duration_cast<std::chrono::nanoseconds>(
            nativeEndTime - nativeStartTime).count();

    // Trả về thời gian của một vòng (tính bằng nanoseconds)
    return duration;
}


extern "C"
JNIEXPORT void JNICALL
Java_com_example_myapplication_MainActivity_sieveOfEratosthenesNDK(
        JNIEnv* env,
        jobject /* this */,
        jint n) {

    // Sàng Eratosthenes
    std::vector<bool> sieve(n + 1, true);
    sieve[0] = sieve[1] = false;

    for (int i = 2; i * i <= n; i++) {
        if (sieve[i]) {
            for (int j = i * i; j <= n; j += i) {
                sieve[j] = false;
            }
        }
    }
}


extern "C"
JNIEXPORT void JNICALL
Java_com_example_myapplication_MainActivity_calculateCircleAreaNDK(JNIEnv *env, jobject thiz,
                                                                   jdouble radiusLimit) {
    /// Thực hiện vòng lặp tính diện tích
    for (double radius = 1; radius <= radiusLimit; radius++) {
        double area = M_PI * radius * radius; // Tính diện tích hình tròn
    }

}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_myapplication_MainActivity_bubbleSortNDK(JNIEnv *env, jobject thiz,
                                                                   jint countLoop) {
    const int arraySize = 1000; // Kích thước mảng cố định là 10000 phần tử
    srand(static_cast<unsigned>(time(nullptr))); // Khởi tạo seed cho random

    for (int loop = 0; loop < countLoop; loop++) {
        // Tạo mảng ngẫu nhiên
        std::vector<int> array(arraySize);
        for (int i = 0; i < arraySize; i++) {
            array[i] = rand() % 1000; // Giá trị ngẫu nhiên từ 0 đến 999
        }

        // Bubble Sort
        for (int i = 0; i < arraySize - 1; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Hoán đổi hai phần tử
                    std::swap(array[j], array[j + 1]);
                }
            }
        }
    }

}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_myapplication_MainActivity_concatStringNDK(JNIEnv *env, jobject thiz,
                                                          jint countLoop) {
    const int stringLength = 10000; // Độ dài cố định của chuỗi ngẫu nhiên
    srand(static_cast<unsigned>(time(nullptr))); // Khởi tạo seed cho số ngẫu nhiên

    // Hàm tạo chuỗi ngẫu nhiên với độ dài cố định
    auto generateRandomString = [](int length) -> std::string {
        const char charset[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        const int charsetSize = sizeof(charset) - 1;
        std::string randomString;
        randomString.reserve(length);
        for (int i = 0; i < length; i++) {
            randomString += charset[rand() % charsetSize];
        }
        return randomString;
    };

    for (int loop = 0; loop < countLoop; loop++) {
        // Sinh chuỗi ngẫu nhiên
        std::string baseString = generateRandomString(stringLength);

        // Nối chuỗi
        std::string concatenatedString = baseString;
        for (int i = 0; i < 10; i++) { // Ví dụ nối chuỗi 10 lần
            concatenatedString += baseString;
        }

        // Kết quả chuỗi đã nối được lưu trữ trong concatenatedString
        // Có thể xử lý thêm nếu cần (hiện tại chỉ chạy vòng lặp)
    }

}