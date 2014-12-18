package org.epstudios.epmobile;

import android.os.Bundle;

public class DiagnosisList extends EpListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


        // Warning: order is important, should be the same as array definition
        String klass[] = {
                "ArvcList",
                "AtrialTachLocalization",
                "BrugadaEcg",
                "LvhList",
                "LongQtList",
                "ShortQt",
                "VtList",
                "WctAlgorithmList",
                "WpwAlgorithmList"
        };

        loadList(R.array.diagnosis_list, klass);

	}

}
