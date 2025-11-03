# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Keep Material DatePicker classes
-keep class com.google.android.material.datepicker.** { *; }

# Keep internal classes that might be used via reflection
-keep class com.google.android.material.internal.** { *; }

# Keep Parcelable implementations
-keepclassmembers class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
