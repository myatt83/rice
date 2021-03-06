/**
 * Copyright 2005-2015 The Kuali Foundation
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
package org.kuali.rice.kim.lookup

import org.junit.Test
import groovy.mock.interceptor.MockFor
import org.kuali.rice.kns.lookup.LookupableHelperService
import static org.junit.Assert.assertEquals

/**
 * Tests the RoleLookupableImpl
 */
class RoleLookupableImplTest {
    private def lookupable = new RoleLookupableImpl()

    @Test
    void testGetCreateNewUrl() {
        lookupable.setLookupableHelperService([
            allowsNewOrCopyAction: { true },
            getReturnLocation: { "RETURN_LOCATION" }
        ] as LookupableHelperService)

        // test that the result is the same as the return value from the protected helper
        assertEquals(lookupable.getCreateNewUrl("lookup.do?businessObjectClassName=org.kuali.rice.kim.impl.type.KimTypeBo&returnLocation=RETURN_LOCATION&docFormKey=IMRD&command=initiate"), lookupable.getCreateNewUrl())
        //assertEquals("""<a title="Create a new record" href="lookup.do?businessObjectClassName=org.kuali.rice.kim.impl.type.KimTypeBo&returnLocation=RETURN_LOCATION&docFormKey=IMRD&command=initiate"><img src="images/tinybutton-createnew.gif" alt="create new" width="70" height="15"/></a>""", lookupable.getCreateNewUrl())
    }
}
