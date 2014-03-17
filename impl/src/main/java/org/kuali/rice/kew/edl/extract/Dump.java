/*
 * Copyright 2005-2008 The Kuali Foundation
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

package org.kuali.rice.kew.edl.extract;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.kuali.rice.core.jpa.annotations.Sequence;
import org.kuali.rice.core.util.OrmUtils;
import org.kuali.rice.core.util.RiceConstants;
import org.kuali.rice.kew.util.KEWConstants;
import org.kuali.rice.kns.service.KNSServiceLocator;

/**
 *
 *
 *
 * @author Kuali Rice Team (rice.collab@kuali.org)
 *
 */
@Entity
@Table(name="KREW_EDL_DMP_T")
@Sequence(name="KREW_EDL_DMP_T", property="docId")
public class Dump {

	private static final long serialVersionUID = -6136544551121011531L;

    @Id
	@Column(name="DOC_HDR_ID")
	private Long docId;
	@Column(name="DOC_TYP_NM")
	private String docTypeName;
	@Column(name="DOC_HDR_STAT_CD")
	private String docRouteStatusCode;
	@Column(name="DOC_HDR_MDFN_DT")
	private Timestamp docModificationDate;
	@Column(name="DOC_HDR_CRTE_DT")
	private Timestamp docCreationDate;
	@Column(name="DOC_HDR_TTL")
	private String docDescription;
    @Column(name="DOC_HDR_INITR_PRNCPL_ID")
	private String docInitiatorId;
    @Column(name="CRNT_NODE_NM")
	private String docCurrentNodeName;
    @Version
	@Column(name="VER_NBR")
	private Integer lockVerNbr;

    @Transient
    private List<Fields> fields = new ArrayList<Fields>();

    @PrePersist
    public void beforeInsert(){
        OrmUtils.populateAutoIncValue(this, KNSServiceLocator.getEntityManagerFactory().createEntityManager());
    }


	public Timestamp getDocCreationDate() {
		return docCreationDate;
	}
	public void setDocCreationDate(final Timestamp docCreationDate) {
		this.docCreationDate = docCreationDate;
	}
	public String getDocCurrentNodeName() {
		return docCurrentNodeName;
	}
	public void setDocCurrentNodeName(final String docCurrentNodeName) {
		this.docCurrentNodeName = docCurrentNodeName;
	}
	public String getDocDescription() {
		return docDescription;
	}
	public void setDocDescription(final String docDescription) {
		this.docDescription = docDescription;
	}
	public Long getDocId() {
		return docId;
	}
	public String getDocInitiatorId() {
		return docInitiatorId;
	}
	public void setDocInitiatorId(final String docInitiatorId) {
		this.docInitiatorId = docInitiatorId;
	}
	public Timestamp getDocModificationDate() {
		return docModificationDate;
	}
	public void setDocModificationDate(final Timestamp docModificationDate) {
		this.docModificationDate = docModificationDate;
	}
	public String getDocRouteStatusCode() {
		return docRouteStatusCode;
	}
	public void setDocRouteStatusCode(final String docRouteStatusCode) {
		this.docRouteStatusCode = docRouteStatusCode;
	}
	public String getDocTypeName() {
		return docTypeName;
	}
	public void setDocTypeName(final String docTypeName) {
		this.docTypeName = docTypeName;
	}
	public Integer getLockVerNbr() {
		return lockVerNbr;
	}
	public void setLockVerNbr(final Integer lockVerNbr) {
		this.lockVerNbr = lockVerNbr;
	}
    public String getFormattedCreateDateTime() {
        long time = getDocCreationDate().getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        Date date = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat(KEWConstants.TIMESTAMP_DATE_FORMAT_PATTERN2);
        return dateFormat.format(date);
    }

    public String getFormattedCreateDate() {
        long time = getDocCreationDate().getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        Date date = calendar.getTime();
        DateFormat dateFormat = RiceConstants.getDefaultDateFormat();
        return dateFormat.format(date);
    }
	public void setDocId(final Long docId) {
		this.docId = docId;
	}


	public List<Fields> getFields() {
		return fields;
	}

	public void setFields(final List<Fields> fields) {
		this.fields = fields;
	}

}
