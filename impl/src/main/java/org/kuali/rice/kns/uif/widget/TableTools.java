/*
 * Copyright 2007 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.rice.kns.uif.widget;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.kns.uif.UifConstants;
import org.kuali.rice.kns.uif.container.View;

/**
 * Decorates a HTML Table client side with various tools
 * 
 * <p>
 * Decorations implemented depend on widget implementation. Examples are
 * sorting, paging and skinning.
 * </p>
 * 
 * @author Kuali Rice Team (rice.collab@kuali.org)
 */
public class TableTools extends WidgetBase {
	private static final long serialVersionUID = 4671589690877390070L;

	/**
	 * A text to be displayed when the table is empty
	 */
	private String emptyTableMessage;
	private boolean disableTableSort;
	
	public TableTools() {
		super();
	}

	/**
	 * The following initialization is performed:
	 * 
	 * <ul>
	 * <li>Initializes component options for empty table message</li>
	 * </ul>
	 *
	 */
	@Override
	public void performInitialization(View view) {
		super.performInitialization(view);
		
		if (StringUtils.isNotBlank(getEmptyTableMessage())){
			getComponentOptions().put(UifConstants.TableToolsKeys.LANGUAGE, "{\"" + UifConstants.TableToolsKeys.EMPTY_TABLE + "\" : \"" + getEmptyTableMessage() + "\"}");
		}
		
		if (isDisableTableSort()){
			getComponentOptions().put(UifConstants.TableToolsKeys.TABLE_SORT,"false");
		}
	}
	
	/**
	 * Returns the text which is used to display text when the table is empty
	 * 
	 *  @return empty table message
	 */
	public String getEmptyTableMessage() {
		return emptyTableMessage;
	}

	/**
	 * Setter for a text to be displayed when the table is empty
	 * 
	 * @param emptyTableMessage
	 */
	public void setEmptyTableMessage(String emptyTableMessage) {
		this.emptyTableMessage = emptyTableMessage;
	}
	
	/**
	 * @return the disableTableSort
	 */
	public boolean isDisableTableSort() {
		return this.disableTableSort;
	}

	/**
	 * @param disableTableSort the disableTableSort to set
	 */
	public void setDisableTableSort(boolean disableTableSort) {
		this.disableTableSort = disableTableSort;
	}
}
