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

    return nativeTimestamp - javaTimestamp;
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
JNIEXPORT jlong JNICALL
Java_com_example_myapplication_MainActivity_calculateCircleAreaNDK(JNIEnv *env, jobject thiz,
                                                                   jdouble radiusLimit) {
    // TODO: implement calculateCircleAreaNDK()

}