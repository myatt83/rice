/*
 * Copyright 2007-2009 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl2.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.rice.kim.lookup;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.kim.bo.impl.ReviewResponsibility;
import org.kuali.rice.kim.util.KimConstants;
import org.kuali.rice.kns.lookup.KualiLookupableImpl;
import org.kuali.rice.kns.util.KNSConstants;
import org.kuali.rice.kns.util.UrlFactory;

/**
 * This is a description of what this class does - kellerj don't forget to fill this in. 
 * 
 * @author Kuali Rice Team (rice.collab@kuali.org)
 *
 */
public class ResponsibilityLookupableImpl extends KualiLookupableImpl {

	
	/**
	 * This overridden method ...
	 * 
	 * @see org.kuali.rice.kns.lookup.KualiLookupableImpl#getCreateNewUrl()
	 */
	@Override
	public String getCreateNewUrl() {
        String url = "";

        if (getLookupableHelperService().allowsNewOrCopyAction(KimConstants.KimUIConstants.KIM_REVIEW_RESPONSIBILITY_DOCUMENT_TYPE_NAME)) {
            Properties parameters = new Properties();
            parameters.put(KNSConstants.DISPATCH_REQUEST_PARAMETER, KNSConstants.MAINTENANCE_NEW_METHOD_TO_CALL);
            parameters.put(KNSConstants.BUSINESS_OBJECT_CLASS_ATTRIBUTE, ReviewResponsibility.class.getName());
	        if (StringUtils.isNotBlank(getReturnLocation())) {
	        	parameters.put(KNSConstants.RETURN_LOCATION_PARAMETER, getReturnLocation());
	        	}
            url = UrlFactory.parameterizeUrl(KNSConstants.MAINTENANCE_ACTION, parameters);
            url = "<a title=\"Create a new record\" href=\"" + url + "\"><img src=\"images/tinybutton-createnew.gif\" alt=\"create new\" width=\"70\" height=\"15\"/></a>";
        }

        return url;
	}
}
