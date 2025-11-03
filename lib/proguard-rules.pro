# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Keep public API
-keep public class com.shalom.android.material.datepicker.** {
    public *;
}

# Keep ThreeTen Extra classes
-keep class org.threeten.extra.** { *; }
-dontwarn org.threeten.extra.**
