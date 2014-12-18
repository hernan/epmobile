package org.epstudios.epmobile;

import android.os.Bundle;

public class VtList extends EpDiagnosisListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        // Warning: order is important, should be the same as array definition
        String klass[] = {
                "OutflowVt",
                "EpiVt",
                "MitralAnnularVt"
        };

        loadList(R.array.vt_list, klass);

	}

}
