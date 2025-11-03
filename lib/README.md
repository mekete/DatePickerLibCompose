# Ethiopian Date Picker Library

A lightweight wrapper library around Material Components DatePicker that provides Ethiopian calendar support.

## Architecture

This library follows a **wrapper pattern** rather than copying code:

- ✅ **Small codebase**: Only wrapper/extension classes
- ✅ **Maintainable**: Leverages official Material Components library
- ✅ **Clean dependencies**: Uses published Maven artifacts
- ✅ **Future-ready**: Designed for Ethiopian calendar integration

## Package Structure

```
com.shalom.android.material.datepicker
├── EthiopicDatePicker          # Main date picker wrapper
├── EthiopicDateRangePicker     # Date range picker wrapper (TODO)
├── EthiopicDateValidator       # Ethiopian date validation (TODO)
└── EthiopicCalendarConstraints # Calendar constraints for Ethiopian dates (TODO)
```

## Dependencies

- **Material Components**: `com.google.android.material:material:1.13.0`
  - Provides the base DatePicker UI and functionality
- **ThreeTen Extra**: `org.threeten:threeten-extra:1.8.0`
  - Provides `EthiopicDate` for calendar calculations

## Current Status (Phase 1)

✅ Library module created
✅ Gradle configuration complete
✅ Basic wrapper class implemented
🔄 Ethiopian calendar conversion (Phase 2)
🔄 Custom date validators (Phase 2)
🔄 Calendar constraints (Phase 2)

## Usage Example

```java
// Simple usage - currently delegates to Material DatePicker
EthiopicDatePicker datePicker = EthiopicDatePicker.Builder.datePicker()
    .setTitleText("Select Date")
    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
    .build();

datePicker.addOnPositiveButtonClickListener(selection -> {
    // selection is in UTC milliseconds
    // Future versions will provide Ethiopian date conversion
    Log.d("Date", "Selected: " + selection);
});

datePicker.show(getSupportFragmentManager(), "ETHIOPIC_DATE_PICKER");
```

## Integration in App Module

```gradle
dependencies {
    implementation(project(":lib"))
}
```

## Future Enhancements (Phase 2)

1. **Ethiopian Calendar Integration**
   - Convert Gregorian ↔ Ethiopian dates using `EthiopicDate`
   - Display Ethiopian month names (Meskerem, Tikimt, etc.)
   - Handle 13th month (Pagumē)

2. **Custom Validators**
   - Validate dates within Ethiopian calendar range
   - Business day validation
   - Holiday validation

3. **Localization**
   - Amharic language support
   - Geez numerals
   - Cultural formatting preferences

## Why This Approach?

### ❌ Previous Approach (Copying Material Components)
- 6,000+ lines of code copied
- 200+ dependency files
- Constant missing resource errors
- Hard to maintain
- Large binary size

### ✅ Current Approach (Wrapper Pattern)
- ~100 lines of wrapper code
- Uses official Material Components
- No resource management issues
- Easy to maintain
- Small binary size
- Can focus on Ethiopian calendar logic

## Development Roadmap

**Phase 1: Foundation** (Current)
- [x] Clean library structure
- [x] Material Components integration
- [x] Basic wrapper classes
- [x] Build configuration

**Phase 2: Ethiopian Calendar**
- [ ] EthiopicDate conversion utilities
- [ ] Custom calendar view
- [ ] Month/year selectors with Ethiopian names
- [ ] Date formatting

**Phase 3: Advanced Features**
- [ ] Date range picker with Ethiopian calendar
- [ ] Custom themes
- [ ] Accessibility improvements
- [ ] Comprehensive testing

## License

[Add your license here]

## Contributing

[Add contributing guidelines]
