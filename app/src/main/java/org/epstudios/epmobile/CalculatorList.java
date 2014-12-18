package org.epstudios.epmobile;

import android.os.Bundle;

public class CalculatorList extends EpListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Warning: order is important, should be the same as array definition
        String klass[] = {
                "IbwCalculator",
                "DayCalculator",
                "DrugDoseCalculatorList",
                "CycleLength",
                "Qtc"
        };

        loadList(R.array.calculator_list, klass);

	}

}
