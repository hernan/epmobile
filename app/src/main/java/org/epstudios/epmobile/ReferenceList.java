package org.epstudios.epmobile;

import android.os.Bundle;

public class ReferenceList extends EpListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        // Warning: order is important, should be the same as array definition
        String klass[] = {
                getString(R.string.brugada_drugs_link),
                "CmsIcd",
                "Entrainment",
                getString(R.string.long_qt_drugs_link),
                "NormalEpValues",
                "ParaHisianPacing",
                "RvaVsRvbPacing"
        };

        loadList(R.array.reference_list, klass);

	}

}
