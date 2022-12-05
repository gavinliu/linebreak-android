#include <jni.h>

#include "libunibreak/LineBreaker.h"

extern "C" JNIEXPORT void JNICALL
Java_cn_gavinliu_android_lib_linebreak_LineBreaker_breaks(
        JNIEnv *env,
        jobject thiz, jstring data, jbyteArray breaks) {
    const jchar *dataArray = env->GetStringChars(data, JNI_FALSE);
    jbyte *breaksArray = env->GetByteArrayElements(breaks, JNI_FALSE);
    const size_t len = env->GetStringLength(data);

    set_linebreaks_utf16(dataArray, len, "zh", (char *) breaksArray);

    env->ReleaseByteArrayElements(breaks, breaksArray, 0);
    env->ReleaseStringChars(data, dataArray);
}