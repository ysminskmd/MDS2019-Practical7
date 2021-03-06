package com.example.shad.factorialcalculator;

import androidx.room.Room;
import android.content.Context;
import androidx.annotation.NonNull;

class CalculationResultDbHolder {

    private static final CalculationResultDbHolder ourInstance = new CalculationResultDbHolder();

    static CalculationResultDbHolder getInstance() {
        return ourInstance;
    }

    private static final String DATABASE_NAME = "factorial";

    private volatile CalculationResultDb mCalculationResultDb;

    private CalculationResultDbHolder() {
    }

    public CalculationResultDb getDb(@NonNull Context context) {
        if (mCalculationResultDb == null) {
            synchronized (this) {
                if (mCalculationResultDb == null) {
                    mCalculationResultDb =
                            Room.databaseBuilder(context, CalculationResultDb.class, DATABASE_NAME).build();
                }
            }
        }
        return mCalculationResultDb;
    }
}
