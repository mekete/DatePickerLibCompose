# Material DatePicker Library

This library is an extracted version of the Material Design 3 DatePicker component from the [material-components-android](https://github.com/material-components/material-components-android) project.

## Structure

The library maintains the same package structure as the original Material Components library:

```
lib/
├── src/
│   ├── main/
│   │   ├── java/com/google/android/material/
│   │   │   ├── datepicker/          (28 Java files - Core DatePicker component)
│   │   │   ├── button/              (MaterialButton - required dependency)
│   │   │   ├── dialog/              (Dialog utilities - required dependency)
│   │   │   ├── shape/               (Shape drawing - required dependency)
│   │   │   ├── textfield/           (TextInputLayout - required dependency)
│   │   │   ├── color/               (Color utilities - required dependency)
│   │   │   ├── resources/           (Resource utilities - required dependency)
│   │   │   ├── internal/            (Internal utilities - required dependency)
│   │   │   ├── animation/           (Animation utilities)
│   │   │   ├── drawable/            (Drawable utilities)
│   │   │   ├── ripple/              (Ripple effects)
│   │   │   ├── theme/               (Theme utilities)
│   │   │   ├── elevation/           (Elevation utilities)
│   │   │   ├── shadow/              (Shadow utilities)
│   │   │   ├── math/                (Math utilities)
│   │   │   └── ... (other support packages)
│   │   └── AndroidManifest.xml
│   └── test/
│       └── java/com/google/android/material/datepicker/ (15 test files)
├── build.gradle.kts
├── proguard-rules.pro
└── consumer-rules.pro
```

## Components Included

### Core DatePicker (28 files)
- **MaterialDatePicker.java** - Main public API (DialogFragment)
- **MaterialCalendar.java** - Calendar view fragment
- **SingleDateSelector.java** - Single date selection
- **RangeDateSelector.java** - Date range selection
- **Month.java** - Month representation
- **CalendarConstraints.java** - Date validation and constraints
- And 22 more supporting files...

### Dependencies (210+ files total)
All necessary Material Components dependencies have been included:
- Button component (MaterialButton)
- Dialog utilities
- Shape drawing system
- Text field component
- Color utilities
- Resource management
- Internal utilities
- Animation framework
- And more...

## Usage

Add the library to your project:

```gradle
dependencies {
    implementation(project(":lib"))
}
```

## API Compatibility

This library maintains full API compatibility with the original Material Components DatePicker.

Example usage:

```java
MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
    .setTitleText("Select date")
    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
    .build();

datePicker.show(getSupportFragmentManager(), "DATE_PICKER");
```

## Dependencies

The library requires the following AndroidX dependencies (configured in build.gradle.kts):

- androidx.activity
- androidx.annotation
- androidx.appcompat
- androidx.core
- androidx.fragment
- androidx.recyclerview
- androidx.transition
- androidx.vectordrawable
- androidx.coordinatorlayout
- androidx.customview
- androidx.lifecycle.runtime

## Build Requirements

- Android SDK 26 (API level 26) or higher
- Gradle 8.13
- Android Gradle Plugin 8.3.0
- Java 11

## License

This code is extracted from the Material Components for Android project and maintains the same license as the original project (Apache License 2.0).

## Original Source

Original repository: https://github.com/material-components/material-components-android
Package: lib/java/com/google/android/material/datepicker

## Notes

- All 28 DatePicker source files have been preserved with their original package structure
- All internal Material Components dependencies have been included
- The library uses programmatic UI creation (no XML layouts)
- Test files are included in src/test/java
