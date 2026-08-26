# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.

# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep rules here:

# Navigation Component / Kotlin Serialization
-keepattributes *Annotation*
-keepclassmembers class * {
    @kotlinx.serialization.Serializable *;
}

# Hilt
-keep class dagger.hilt.android.internal.managers.** { *; }
-keep class * extends dagger.hilt.android.internal.managers.ViewComponentManager { *; }
-keep @dagger.hilt.android.internal.lifecycle.HiltViewModelMap * class *

# Room
-keep class * extends androidx.room.RoomDatabase
-dontwarn androidx.room.paging.**

# Compose
-keepclassmembers class androidx.compose.ui.platform.AndroidComposeView { *; }
-keep class androidx.compose.ui.platform.AndroidComposeView { *; }
