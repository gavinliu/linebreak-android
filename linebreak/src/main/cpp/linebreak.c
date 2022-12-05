#include <jni.h>
#include <string>

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <iconv.h>
#include "libunibreak/linebreak.h"
#include "libunibreak/linebreakdef.h"

extern "C" JNIEXPORT jstring JNICALL
Java_cn_gavinliu_android_lib_linebreak_NativeLib_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";

    return env->NewStringUTF(hello.c_str());
}