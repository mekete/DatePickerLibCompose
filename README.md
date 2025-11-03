# Ethiopian Date Picker Library

A clean, lightweight wrapper library around Material Components DatePicker for Ethiopian calendar support.

## 🎯 Project Goals

1. **Minimal codebase**: Wrapper pattern instead of copying Material Components
2. **Clean dependencies**: Use published Maven artifacts
3. **Ethiopian calendar**: Full support for 13-month Ethiopian calendar
4. **Modern APIs**: Java Time API (`java.time`) and ThreeTen Extra (`EthiopicDate`)

## 📁 Project Structure

```
EthiopicDatePicker/
├── app/                          # Test application
│   └── src/main/java/           # Demo app showing library usage
├── lib/                          # Ethiopian Date Picker Library
│   ├── src/main/java/
│   │   └── com/shalom/android/material/datepicker/
│   │       ├── EthiopicDatePicker.java          # Main wrapper class
│   │       ├── EthiopicDateRangePicker.java     # (TODO)
│   │       ├── EthiopicDateValidator.java       # (TODO)
│   │       └── EthiopicCalendarConstraints.java # (TODO)
│   └── build.gradle.kts         # Library dependencies
└── README.md                     # This file
```

## 🏗️ Architecture

### Why Wrapper Pattern?

| Previous Approach (❌) | Current Approach (✅) |
|---|---|
| Copy 6,000+ lines from Material Components | Write ~100 lines of wrapper code |
| Copy 200+ dependency files | Use Material Components as dependency |
| Manage XML resources manually | Let Material Components handle resources |
| Constant build errors | Clean, reliable builds |
| Hard to maintain | Easy to maintain |
| Large binary size | Small binary size |

### Dependencies

```gradle
// lib/build.gradle.kts
dependencies {
    // Material Components (includes DatePicker UI)
    api("com.google.android.material:material:1.13.0")

    // ThreeTen Extra (includes EthiopicDate for calendar calculations)
    api("org.threeten:threeten-extra:1.8.0")

    implementation("androidx.appcompat:appcompat:1.7.1")
}
```

## 🚀 Usage

### In your app's build.gradle.kts

```gradle
dependencies {
    implementation(project(":lib"))
}
```

### In your Activity

```java
import com.shalom.android.material.datepicker.EthiopicDatePicker;
import com.google.android.material.datepicker.MaterialDatePicker;

// Show date picker
EthiopicDatePicker datePicker = EthiopicDatePicker.Builder.datePicker()
    .setTitleText("Select Ethiopian Date")
    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
    .build();

datePicker.addOnPositiveButtonClickListener(selection -> {
    // selection is UTC milliseconds
    // Future: Will provide Ethiopian date conversion
    Log.d("Date", "Selected: " + selection);
});

datePicker.show(getSupportFragmentManager(), "DATE_PICKER");
```

## 📅 Ethiopian Calendar Background

The Ethiopian calendar:
- **13 months**: 12 months of 30 days + 1 month (Pagumē) of 5-6 days
- **Different year**: ~7-8 years behind Gregorian calendar
- **Month names**: Meskerem, Tikimt, Hidar, Tahsas, Tir, Yekatit, Megabit, Miazia, Ginbot, Sene, Hamle, Nehase, Pagumē
- **New Year**: Starts on September 11 (or September 12 in leap years)

## 🗺️ Development Roadmap

### Phase 1: Foundation ✅ (Current)
- [x] Clean library structure with `com.shalom.android.material.datepicker` package
- [x] Gradle configuration with Material Components & ThreeTen Extra
- [x] Basic `EthiopicDatePicker` wrapper class
- [x] Test app demonstrating library usage
- [x] Clean architecture documentation

### Phase 2: Ethiopian Calendar Integration 🔄 (Next)
- [ ] Conversion utilities (Gregorian ↔ Ethiopian)
  - Use `EthiopicDate` from ThreeTen Extra
  - Handle leap years correctly
  - Support date range validation
- [ ] Custom calendar adapter
  - Display Ethiopian month names
  - Show 13-month layout
  - Handle Pagumē month (5-6 days)
- [ ] Date formatting
  - Ethiopian date format patterns
  - Localized month/day names
  - Support for Geez numerals

### Phase 3: Advanced Features 🔮 (Future)
- [ ] `EthiopicDateRangePicker` - Date range selection
- [ ] `EthiopicDateValidator` - Custom validation rules
- [ ] `EthiopicCalendarConstraints` - Min/max dates, selectable dates
- [ ] Localization
  - Amharic language support
  - Geez numeral system
  - RTL support
- [ ] Custom themes and styling
- [ ] Comprehensive unit & instrumentation tests
- [ ] Sample apps demonstrating various use cases

## 🔧 Building the Project

```bash
# Clone the repository
git clone <repository-url>
cd EthiopicDatePicker

# Build the library
./gradlew :lib:assembleRelease

# Run the test app
./gradlew :app:installDebug
```

## 📚 Resources

- [Material Design DatePicker](https://material.io/components/date-pickers)
- [ThreeTen Extra - EthiopicDate](https://github.com/ThreeTen/threeten-extra)
- [Ethiopian Calendar on Wikipedia](https://en.wikipedia.org/wiki/Ethiopian_calendar)

## 🤝 Contributing

Contributions are welcome! Please read the contributing guidelines before getting started.

## 📄 License

[Add your license here]

## ✨ Acknowledgments

- Google's Material Components for Android
- ThreeTen project for comprehensive date/time APIs
- Ethiopian calendar scholars and maintainers

---

**Note**: This is Phase 1 - the foundation. Ethiopian calendar functionality will be added in Phase 2. The current implementation demonstrates the clean architecture and proper dependency management.
