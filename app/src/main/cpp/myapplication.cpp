#include <jni.h>
#include <chrono>

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

    return nativeTimestamp - javaTimestamp;
}

