package org.epstudios.epmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DiagnosisList extends EpActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.selectionlist);
		super.onCreate(savedInstanceState);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.diagnosis_list,
				android.R.layout.simple_list_item_1);

        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
        lv.setTextFilterEnabled(true);


		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String selection = ((TextView) view).getText().toString();

				if (selection.equals(getString(R.string.wct_algorithm_list_title))) {
                    withActivity(WctAlgorithmList.class);

                }else if (selection.equals(getString(R.string.arvc_list_title))) {
                    withActivity(ArvcList.class);

                }else if (selection.equals(getString(R.string.short_qt_title))) {
                    withActivity(ShortQt.class);

                }else if (selection.equals(getString(R.string.wpw_algorithm_list_title))) {
                    withActivity(WpwAlgorithmList.class);

                }else if (selection.equals(getString(R.string.lqt_syndrome_title))) {
                    withActivity(LongQtList.class);

                }else if (selection.equals(getString(R.string.lvh_list_title))) {
                    withActivity(LvhList.class);

                }else if (selection.equals(getString(R.string.brugada_ecg_title))) {
                    withActivity(BrugadaEcg.class);

                }else if (selection.equals(getString(R.string.vt_list_title))) {
                    withActivity(VtList.class);

                }else if (selection.equals(getString(R.string.atrial_tachycardia_localization_title))) {
                    withActivity(AtrialTachLocalization.class);
                }
			}
		});
	}

    private void withActivity(Class klass) {
        startActivity( new Intent(this, klass) );
    }

}
