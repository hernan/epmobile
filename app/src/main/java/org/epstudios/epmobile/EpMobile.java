/*  EP Mobile -- Mobile tools for electrophysiologists
    Copyright (C) 2011 EP Studios, Inc.
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

import android.os.Bundle;

public class EpMobile extends EpListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.selectionlist);
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        // Warning: order is important, should be the same as array definition
        Class klass[] = {
                CalculatorList.class,
                DiagnosisList.class,
                ReferenceList.class,
                RiskScoreList.class
        };

        loadList(R.array.main_index, klass);
    }
}