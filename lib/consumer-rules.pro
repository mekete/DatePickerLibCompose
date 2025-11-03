# Consumer ProGuard rules for Material DatePicker Library

# Keep all public API classes
-keep public class com.google.android.material.datepicker.MaterialDatePicker { *; }
-keep public class com.google.android.material.datepicker.MaterialDatePicker$Builder { *; }
-keep public class com.google.android.material.datepicker.CalendarConstraints { *; }
-keep public class com.google.android.material.datepicker.CalendarConstraints$Builder { *; }
-keep public interface com.google.android.material.datepicker.DateSelector { *; }
-keep public class com.google.android.material.datepicker.SingleDateSelector { *; }
-keep public class com.google.android.material.datepicker.RangeDateSelector { *; }

# Keep Parcelable implementations
-keepclassmembers class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
