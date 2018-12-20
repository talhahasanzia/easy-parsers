package com.talhahasanzia.csv.models;

import android.support.annotation.Nullable;

public class Row {

    private String[] entries;

    public Row() {

    }

    public Row(String[] entries) {
        this.entries = entries;
    }

    public void setEntries(String[] words) {
        this.entries = words;
    }

    public String[] getEntries() {
        return entries;
    }

    @Nullable
    public String getEntryAtColumn(int columnIndex) {
        return entries != null && entries.length > 0 ? entries[columnIndex] : null;
    }
}
