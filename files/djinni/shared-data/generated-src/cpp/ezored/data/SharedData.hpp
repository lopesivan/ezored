// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from proj.djinni

#pragma once

#include <cstdint>
#include <memory>
#include <string>

namespace ezored { namespace data {

class SharedDataPlatformService;

class SharedData {
public:
    virtual ~SharedData() {}

    static std::shared_ptr<SharedData> shared();

    virtual void setPlatformService(const std::shared_ptr<SharedDataPlatformService> & ps) = 0;

    virtual std::shared_ptr<SharedDataPlatformService> getPlatformService() = 0;

    virtual bool hasPlatformService() = 0;

    virtual void setString(const std::string & key, const std::string & value) = 0;

    virtual void setInteger(const std::string & key, int32_t value) = 0;

    virtual void setLong(const std::string & key, int64_t value) = 0;

    virtual void setBool(const std::string & key, bool value) = 0;

    virtual void setFloat(const std::string & key, float value) = 0;

    virtual void setDouble(const std::string & key, double value) = 0;

    virtual std::string getString(const std::string & key) = 0;

    virtual int32_t getInteger(const std::string & key) = 0;

    virtual int64_t getLong(const std::string & key) = 0;

    virtual bool getBool(const std::string & key) = 0;

    virtual float getFloat(const std::string & key) = 0;

    virtual double getDouble(const std::string & key) = 0;

    virtual std::string getStringWithDefaultValue(const std::string & key, const std::string & defaultValue) = 0;

    virtual int32_t getIntegerWithDefaultValue(const std::string & key, int32_t defaultValue) = 0;

    virtual int64_t getLongWithDefaultValue(const std::string & key, int64_t defaultValue) = 0;

    virtual bool getBoolWithDefaultValue(const std::string & key, bool defaultValue) = 0;

    virtual float getFloatWithDefaultValue(const std::string & key, float defaultValue) = 0;

    virtual double getDoubleWithDefaultValue(const std::string & key, double defaultValue) = 0;

    virtual bool has(const std::string & key) = 0;

    virtual void remove(const std::string & key) = 0;

    virtual void clear() = 0;

    virtual void save(bool async, bool autoFinish) = 0;

    virtual void saveAsync() = 0;

    virtual void saveSync() = 0;

    virtual void start(const std::string & groupName) = 0;

    virtual void finish() = 0;
};

} }  // namespace ezored::data
