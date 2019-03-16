// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from proj.djinni

#pragma once

#include "djinni_support.hpp"
#include "ezored/helpers/SharedDataHelper.hpp"

namespace djinni_generated {

class EZRHelperSharedDataHelper final : ::djinni::JniInterface<::ezored::helpers::SharedDataHelper, EZRHelperSharedDataHelper> {
public:
    using CppType = std::shared_ptr<::ezored::helpers::SharedDataHelper>;
    using CppOptType = std::shared_ptr<::ezored::helpers::SharedDataHelper>;
    using JniType = jobject;

    using Boxed = EZRHelperSharedDataHelper;

    ~EZRHelperSharedDataHelper();

    static CppType toCpp(JNIEnv* jniEnv, JniType j) { return ::djinni::JniClass<EZRHelperSharedDataHelper>::get()._fromJava(jniEnv, j); }
    static ::djinni::LocalRef<JniType> fromCppOpt(JNIEnv* jniEnv, const CppOptType& c) { return {jniEnv, ::djinni::JniClass<EZRHelperSharedDataHelper>::get()._toJava(jniEnv, c)}; }
    static ::djinni::LocalRef<JniType> fromCpp(JNIEnv* jniEnv, const CppType& c) { return fromCppOpt(jniEnv, c); }

private:
    EZRHelperSharedDataHelper();
    friend ::djinni::JniClass<EZRHelperSharedDataHelper>;
    friend ::djinni::JniInterface<::ezored::helpers::SharedDataHelper, EZRHelperSharedDataHelper>;

};

}  // namespace djinni_generated