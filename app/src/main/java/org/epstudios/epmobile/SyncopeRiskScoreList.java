package org.epstudios.epmobile;

import android.os.Bundle;

public class SyncopeRiskScoreList extends EpListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        // Warning: order is important, should be the same as array definition
        String klass[] = {
                "SyncopeSfRule",
                "MartinAlgorithm",
                "OesilScore",
                "EgsysScore"
        };

        loadList(R.array.syncope_risk_scores, klass);

	}

}
