package com.shalom.android.material.datepicker;

import androidx.fragment.app.FragmentManager;

import com.google.android.material.datepicker.MaterialDatePicker;

/**
 * Ethiopian Calendar Date Picker
 *
 * A wrapper around Material Components DatePicker that will be extended
 * to support Ethiopian calendar (13 months, different year calculations).
 *
 * Current implementation delegates to Material DatePicker.
 * Future versions will integrate with ThreeTen Extra's EthiopicDate.
 *
 * Usage:
 * <pre>
 * EthiopicDatePicker datePicker = EthiopicDatePicker.Builder.datePicker()
 *     .setTitleText("Select Ethiopian Date")
 *     .build();
 * datePicker.show(fragmentManager, "ETHIOPIC_DATE_PICKER");
 * </pre>
 */
public class EthiopicDatePicker {

    private final MaterialDatePicker<Long> materialDatePicker;

    private EthiopicDatePicker(MaterialDatePicker<Long> materialDatePicker) {
        this.materialDatePicker = materialDatePicker;
    }

    /**
     * Show the date picker dialog
     */
    public void show(FragmentManager fragmentManager, String tag) {
        materialDatePicker.show(fragmentManager, tag);
    }

    /**
     * Add a listener for positive button clicks
     */
    public void addOnPositiveButtonClickListener(MaterialDatePicker.OnSelectionChangedListener<Long> listener) {
        materialDatePicker.addOnPositiveButtonClickListener(listener);
    }

    /**
     * Get the selected date in milliseconds (UTC)
     */
    public Long getSelection() {
        return materialDatePicker.getSelection();
    }

    /**
     * Builder for EthiopicDatePicker
     */
    public static class Builder {
        private final MaterialDatePicker.Builder<Long> materialBuilder;

        private Builder() {
            materialBuilder = MaterialDatePicker.Builder.datePicker();
        }

        public static Builder datePicker() {
            return new Builder();
        }

        public Builder setTitleText(String title) {
            materialBuilder.setTitleText(title);
            return this;
        }

        public Builder setSelection(Long selection) {
            materialBuilder.setSelection(selection);
            return this;
        }

        public EthiopicDatePicker build() {
            return new EthiopicDatePicker(materialBuilder.build());
        }
    }
}
