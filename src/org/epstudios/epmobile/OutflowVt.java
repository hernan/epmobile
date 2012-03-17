/*  EP Mobile -- Mobile tools for electrophysiologists
    Copyright (C) 2012 EP Studios, Inc.
    www.epstudiossoftware.com

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.epstudios.epmobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class OutflowVt extends EpActivity implements OnClickListener {
	private Button yesButton;
	private Button noButton;
	protected Button backButton;
	private Button morphologyButton;
	protected TextView stepTextView;

	protected boolean mitralAnnularVt = false;
	protected int step = 1;
	private int priorStep = 1;
	private int priorStep1 = 1;
	private int priorStep2 = 1;
	private int priorStep3 = 1;
	private int priorStep4 = 1;
	private int priorStep5 = 1;
	private int priorStep6 = 1;
	private int priorStep7 = 1;

	private boolean isRvot = false;
	private boolean isLvot = false;
	private boolean isIndeterminate = false;
	private boolean isSupraValvular = false;
	private boolean isRvFreeWall = false;
	private boolean isAnterior = false;
	private boolean isCaudal = false;

	private final int lateTransitionStep = 1;
	private final int freeWallStep = 2;
	private final int anteriorLocationStep = 3;
	private final int caudalLocationStep = 4;
	private final int showResultStep = 5;
	private final int v3TransitionStep = 6;
	private final int indeterminateLocationStep = 7;
	private final int v2TransitionStep = 8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplealgorithm);

		yesButton = (Button) findViewById(R.id.yes_button);
		yesButton.setOnClickListener(this);
		noButton = (Button) findViewById(R.id.no_button);
		noButton.setOnClickListener(this);
		backButton = (Button) findViewById(R.id.back_button);
		backButton.setOnClickListener(this);
		morphologyButton = (Button) findViewById(R.id.morphology_button);
		morphologyButton.setVisibility(View.GONE);
		stepTextView = (TextView) findViewById(R.id.stepTextView);
		step1();

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.yes_button:
			getYesResult();
			break;
		case R.id.no_button:
			getNoResult();
			break;
		case R.id.back_button:
			getBackResult();
			break;
		}
	}

	private void getBackResult() {
		adjustStepsBackward();
		gotoStep();
	}

	private void getNoResult() {
		adjustStepsForward();
		switch (step) {
		case lateTransitionStep:
			step = v3TransitionStep;
			break;
		case freeWallStep:
			isRvFreeWall = false;
			step = anteriorLocationStep;
			break;
		case anteriorLocationStep:
			isAnterior = false;
			step = caudalLocationStep;
			break;
		case caudalLocationStep:
			isCaudal = false;
			step = showResultStep;
			break;
		case v3TransitionStep:
			step = v2TransitionStep;
			break;
		case indeterminateLocationStep:
			isLvot = true;
			isIndeterminate = true;
			break;
		}
		gotoStep();
	}

	protected void getYesResult() {
		adjustStepsForward();
		switch (step) {
		case lateTransitionStep:
			isRvot = true;
			isIndeterminate = false;
			step = freeWallStep;
			break;
		case freeWallStep:
			isRvFreeWall = true;
			step = anteriorLocationStep;
			break;
		case anteriorLocationStep:
			isAnterior = true;
			step = caudalLocationStep;
			break;
		case caudalLocationStep:
			isCaudal = true;
			step = showResultStep;
			break;
		case v3TransitionStep:
			step = indeterminateLocationStep;
			break;
		case indeterminateLocationStep:
			isRvot = true;
			isIndeterminate = true;
			isRvFreeWall = false;
			step = anteriorLocationStep;
			break;
		}
		gotoStep();
	}

	protected void adjustStepsForward() {
		priorStep7 = priorStep6;
		priorStep6 = priorStep5;
		priorStep5 = priorStep4;
		priorStep4 = priorStep3;
		priorStep3 = priorStep2;
		priorStep2 = priorStep1;
		priorStep1 = priorStep;
		priorStep = step;
	}

	protected void adjustStepsBackward() {
		step = priorStep;
		priorStep = priorStep1;
		priorStep1 = priorStep2;
		priorStep2 = priorStep3;
		priorStep3 = priorStep4;
		priorStep4 = priorStep5;
		priorStep5 = priorStep6;
		priorStep6 = priorStep7;
	}

	private void resetSteps() {
		priorStep7 = priorStep6 = priorStep5 = priorStep4 = 1;
		priorStep3 = priorStep2 = priorStep1 = priorStep = step = 1;
	}

	protected void step1() {
		// if (mitralAnnularVt)
		// stepTextView.setText(getString(R.string.mitral_annular_vt_step_1));
		// else
		stepTextView
				.setText(getString(R.string.outflow_vt_late_transition_step));
		backButton.setEnabled(false);
	}

	protected void gotoStep() {
		switch (step) {
		case lateTransitionStep:
			step1();
			break;
		case freeWallStep:
			stepTextView.setText(getString(R.string.outflow_vt_free_wall_step));
			break;
		case anteriorLocationStep:
			stepTextView
					.setText(getString(R.string.outflow_vt_anterior_location_step));
			break;
		case caudalLocationStep:
			stepTextView
					.setText(getString(R.string.outflow_vt_caudal_location_step));
			break;
		case showResultStep:
			showResult();
			break;
		case v3TransitionStep:
			stepTextView
					.setText(getString(R.string.outflow_vt_v3_transition_step));
			break;
		case indeterminateLocationStep:
			stepTextView
					.setText(getString(R.string.outflow_vt_indeterminate_location_step));
			break;
		case v2TransitionStep:
			stepTextView
					.setText(getString(R.string.outflow_vt_v2_transition_step));
			break;
		}
		if (step != lateTransitionStep)
			backButton.setEnabled(true);
	}

	protected void showResult() {
		AlertDialog dialog = new AlertDialog.Builder(this).create();
		String message = getMessage();
		dialog.setMessage(message);
		dialog.setCanceledOnTouchOutside(false);
		dialog.setTitle(getString(R.string.outflow_vt_location_label));
		dialog.setButton(DialogInterface.BUTTON_POSITIVE,
				getString(R.string.done_label),
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				});
		dialog.setButton(DialogInterface.BUTTON_NEGATIVE,
				getString(R.string.reset_label),
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						resetSteps();
						gotoStep();
					}
				});

		dialog.show();
	}

	protected String getMessage() {
		String message = new String();
		if (isIndeterminate)
			message += "Note: Location (RV vs LV) is indeterminate. "
					+ "Results reflect one possible localization.\n";
		if (isRvot) {
			message += "Right Ventricular Outflow Tract";
			message += isRvFreeWall ? "\nFree wall" : "\nSeptal";
			message += isAnterior ? "\nAnterior" : "\nPosterior";
			message += isCaudal ? "\nCaudal (> 2 cm from PV)"
					: "\nCranial (< 2 cm from PV)";
		} else
			message = "Not RVOT";
		return message;
	}
}
