package org.epstudios.epmobile;

import android.os.Bundle;

public class RiskScoreList extends EpListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        String klass[] = {
                "Chads",
                "ChadsVasc",
                "HasBled",
                "Hcm",
                "Hemorrhages",
                "IcdRisk",
                "SyncopeRiskScoreList",
        };

        loadList(R.array.risk_score_list, klass);

	}
}
