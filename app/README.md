# DatePicker Library Test App

This app demonstrates how to use the Material DatePicker library.

## Features Tested

1. **Single Date Picker** - Select a single date
2. **Date Range Picker** - Select a date range (start and end dates)

## How to Run

1. Open the project in Android Studio
2. Wait for Gradle sync to complete
3. Run the app on an emulator or physical device
4. Click the buttons to test different DatePicker modes

## Code Overview

### MainActivity.java
- Demonstrates two DatePicker modes:
  - `showSingleDatePicker()` - Shows a calendar to pick one date
  - `showDateRangePicker()` - Shows a calendar to pick a date range
- Displays selected dates in the result TextView

### Layout (activity_main.xml)
- Title text
- Two buttons to trigger different picker modes
- Result display area

## Library Usage Example

```java
// Single Date Picker
MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
    .setTitleText("Select a Date")
    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
    .build();

datePicker.addOnPositiveButtonClickListener(selection -> {
    // Handle selected date
    String selectedDate = dateFormat.format(new Date(selection));
});

datePicker.show(getSupportFragmentManager(), "DATE_PICKER");
```

```java
// Date Range Picker
MaterialDatePicker<Pair<Long, Long>> dateRangePicker =
    MaterialDatePicker.Builder.dateRangePicker()
    .setTitleText("Select Date Range")
    .build();

dateRangePicker.addOnPositiveButtonClickListener(selection -> {
    // Handle selected date range
    String startDate = dateFormat.format(new Date(selection.first));
    String endDate = dateFormat.format(new Date(selection.second));
});

dateRangePicker.show(getSupportFragmentManager(), "DATE_RANGE_PICKER");
```

## Dependencies

The app module depends on the `:lib` module:
```gradle
dependencies {
    implementation(project(":lib"))
    // ... other dependencies
}
```
