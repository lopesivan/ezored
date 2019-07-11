package com.ezored.sample.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings.Secure
import android.telephony.TelephonyManager
import android.text.TextUtils
import com.ezored.domain.DeviceData
import com.ezored.domain.InitializationData
import com.ezored.sample.BuildConfig
import com.ezored.sample.app.Application
import java.util.*

object EnvironmentUtil {

    val androidId: String
        @SuppressLint("HardwareIds")
        get() {
            val id = Secure.getString(Application.instance.contentResolver, Secure.ANDROID_ID)

            return if (TextUtils.isEmpty(id)) {
                ""
            } else id

        }

    val formattedSystemVersion: String
        get() = String.format("Android %s (API %s)", Build.VERSION.RELEASE, Build.VERSION.SDK_INT)

    private val packageInfo: PackageInfo
        @Throws(PackageManager.NameNotFoundException::class)
        get() {
            val context = Application.instance
            val manager = context.packageManager
            return manager.getPackageInfo(context.packageName, 0)
        }

    val appVersionName: String
        get() {
            try {
                return packageInfo.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

            return ""
        }

    val appVersionCode: Int
        get() {
            try {
                return packageInfo.versionCode
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

            return 0
        }

    val screenWidth: Int
        get() = Application.instance.resources.displayMetrics.widthPixels

    val screenHeight: Int
        get() = Application.instance.resources.displayMetrics.heightPixels

    val screenScale: Float
        get() = Application.instance.resources.displayMetrics.density

    val currentRegionCode: String
        get() {
            try {
                val tm = Application.instance.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                val code = tm.networkCountryIso

                if (!TextUtils.isEmpty(code)) {
                    return code
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return Locale.getDefault().country
        }

    val appName: String
        get() {
            val context = Application.instance
            return context.applicationInfo?.loadLabel(context.packageManager)?.toString() ?: ""

        }

    val deviceData: DeviceData
        get() {
            var deviceId = androidId
            val name = Build.MODEL
            val systemName = "Android"
            var systemVersion = formattedSystemVersion
            val model = Build.DEVICE
            val localizedModel = Build.DEVICE
            var appVersion = EnvironmentUtil.appVersionCode.toString()
            var appShortVersion = appVersionName
            var appName = appName
            val screenWidth = EnvironmentUtil.screenWidth.toFloat()
            val screenHeight = EnvironmentUtil.screenHeight.toFloat()
            val screenScale = screenScale
            val systemOSName = "android"
            var systemLanguage = Locale.getDefault().language
            var imei = ""
            var region = currentRegionCode

            if (TextUtils.isEmpty(deviceId)) {
                deviceId = ""
            }

            if (TextUtils.isEmpty(systemVersion)) {
                systemVersion = ""
            }

            if (TextUtils.isEmpty(appVersion)) {
                appVersion = ""
            }

            if (TextUtils.isEmpty(appShortVersion)) {
                appShortVersion = ""
            }

            if (TextUtils.isEmpty(appName)) {
                appName = ""
            }

            if (TextUtils.isEmpty(systemLanguage)) {
                systemLanguage = ""
            }

            if (TextUtils.isEmpty(imei)) {
                imei = ""
            }

            if (TextUtils.isEmpty(region)) {
                region = ""
            }

            return DeviceData(
                deviceId,
                name,
                systemName,
                systemVersion,
                model,
                localizedModel,
                appVersion,
                appShortVersion,
                appName,
                screenWidth,
                screenHeight,
                screenScale,
                systemOSName,
                systemLanguage,
                imei,
                region
            )
        }

    val initializationData: InitializationData
        get() {
            var basePath = Application.instance.filesDir.absolutePath

            if (TextUtils.isEmpty(basePath)) {
                basePath = ""
            }

            return InitializationData(
                Application.instance.packageName,
                BuildConfig.FLAVOR,
                basePath,
                0,
                BuildConfig.DEBUG
            )
        }

}
