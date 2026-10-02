/*
 *
 *   Copyright 2023 Einstein Blanco
 *
 *   Licensed under the GNU General Public License v3.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.gnu.org/licenses/gpl-3.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package com.eblan.launcher.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eblan.launcher.domain.model.grid.GridItemSettings
import com.eblan.launcher.domain.model.grid.LayoutType

@Composable
internal fun GridItemLayoutType(
    modifier: Modifier = Modifier,
    gridItemSettings: GridItemSettings,
    horizontalAlignment: Alignment.Horizontal,
    horizontalArrangement: Arrangement.Horizontal,
    iconModifier: Modifier,
    verticalAlignment: Alignment.Vertical,
    verticalArrangement: Arrangement.Vertical,
    iconContent: @Composable (() -> Unit),
    labelContent: @Composable ((Modifier) -> Unit),
) {
    when (gridItemSettings.layoutType) {
        LayoutType.TopIconBottomLabel -> {
            Column(
                modifier = modifier,
                horizontalAlignment = horizontalAlignment,
                verticalArrangement = verticalArrangement,
            ) {
                iconContent()
                labelContent(Modifier)
            }
        }

        LayoutType.TopLabelBottomIcon -> {
            Column(
                modifier = modifier,
                horizontalAlignment = horizontalAlignment,
                verticalArrangement = verticalArrangement,
            ) {
                labelContent(Modifier)
                iconContent()
            }
        }

        LayoutType.StartIconEndLabel -> {
            Row(
                modifier = modifier,
                horizontalArrangement = horizontalArrangement,
                verticalAlignment = verticalAlignment,
            ) {
                iconContent()
                labelContent(Modifier)
            }
        }

        LayoutType.StartLabelEndIcon -> {
            Row(
                modifier = modifier,
                horizontalArrangement = horizontalArrangement,
                verticalAlignment = verticalAlignment,
            ) {
                labelContent(Modifier)
                iconContent()
            }
        }

        LayoutType.IconOnly -> {
            Column(
                modifier = modifier,
                horizontalAlignment = horizontalAlignment,
                verticalArrangement = verticalArrangement,
            ) {
                iconContent()
            }
        }

        LayoutType.LabelOnly -> {
            Box(modifier = modifier) {
                Box(
                    modifier = Modifier
                        .size(size = gridItemSettings.iconSize.dp)
                        .padding(all = gridItemSettings.iconPadding.dp),
                ) {
                    labelContent(
                        Modifier
                            .matchParentSize()
                            .then(other = iconModifier),
                    )
                }
            }
        }
    }
}
