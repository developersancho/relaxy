package com.mg.buildsrc

object Modules {
    val app = ":app"
    val util = ":common:util"
    val widget = ":common:widget"
    val remote = ":core:remote"
    val local = ":core:local"
    val manager = ":core:manager"
}

object ApplicationId {
    val id = "com.mg.relaxy"
}

object Versions {
    val minSdk = 19
    val compileSdk = 29
    val targetSdk = 29
    val buildTools = "29.0.2"
    val kotlin = "1.3.61"
    val androidPlugin = "3.5.3"
    val navigation = "2.1.0"
    val appCompat = "1.1.0"
    val coreKtx = "1.1.0"
    val constraintLayout = "1.1.3"
    val material = "1.2.0-alpha02"
    val legacy = "1.0.0"
    val coroutines = "1.3.2"
    val gson = "2.8.6"
    val retrofit = "2.6.2"
    val okhttp = "4.2.2"
    val lifecycle = "2.1.0"
    val koin = "2.0.1"
    val room = "2.2.1"
    val glide = "4.10.0"
    val timber = "4.7.1"
    val junit = "4.12"
    val junitExt = "1.1.1"
    val espresso = "3.2.0"
    val mockWebServer = "2.7.5"
    val retrofitCoroutines = "0.9.2"
    val conscrypt = "2.2.1"
    val flashbar = "1.0.3"
    val lottie = "3.2.0"
    val multidex = "1.0.3"
}

object Libraries {
    // kotlin - coroutine
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val kotlinCoroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val kotlinReflection = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"

    // android
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val material = "com.google.android.material:material:${Versions.material}"
    val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"

    // databinding
    val databinding = "com.android.databinding:compiler:${Versions.androidPlugin}"

    // multidex
    val multidex = "com.android.support:multidex:${Versions.multidex}"

    // glide for image
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // room database for local
    val room = "androidx.room:room-runtime:${Versions.room}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    // koin for di
    val koinCore = "org.koin:koin-core:${Versions.koin}"
    val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    val koinScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    // lifecycle
    val lifeCycleLiveData = "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycle}"
    val lifeCycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}"
    val lifeCycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifeCycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifeCycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"

    // retrofit
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitConvertorGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val retrofitCoroutineAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    val conscrypt = "org.conscrypt:conscrypt-android:${Versions.conscrypt}"

    // okhttp
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    val okhttpUrlConnection = "com.squareup.okhttp3:okhttp-urlconnection:${Versions.okhttp}"
    val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    // navigation
    val navFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    val navUi = "androidx.navigation:navigation-ui:${Versions.navigation}"
    val navFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // flashbar
    val flashbar = "com.andrognito.flashbar:flashbar:${Versions.flashbar}"

    // lottie
    val lottie = "com.airbnb.android:lottie:${Versions.lottie}"

    // timber
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // test
    val koinTest = "org.koin:koin-test:${Versions.koin}"
    val lifeCycleTest = "androidx.arch.core:core-testing:${Versions.lifecycle}"
    val junit = "junit:junit:${Versions.junit}"
    val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val mockWebServer = "com.squareup.okhttp:mockwebserver:${Versions.mockWebServer}"
    val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}

object BuildPlugins {
    val jitpack = "https://jitpack.io"
    val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val safeArgsGradlePlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"

    val androidApplication = "com.android.application"
    val kotlinAndroid = "kotlin-android"
    val kotlinAndroidExtensions = "kotlin-android-extensions"
    val kotlinKapt = "kotlin-kapt"
    val kotlinSafeArgs = "androidx.navigation.safeargs.kotlin"

    val supportLibraryVectorDrawables = true
    val multidexEnable = true
    val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}
