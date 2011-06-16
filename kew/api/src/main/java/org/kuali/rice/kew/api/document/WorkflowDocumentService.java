package org.kuali.rice.kew.api.document;

import java.util.List;

import javax.jws.WebParam;

import org.kuali.rice.kew.api.action.ActionRequest;
import org.kuali.rice.kew.api.action.ActionTaken;


public interface WorkflowDocumentService {
	
	// TODO implement the following methods on this service
	
	Document getDocument(String documentId);
	
	DocumentContent getDocumentContent(String documentId);
	
	List<ActionRequest> getActionRequests(@WebParam(name = "documentId") String documentId);

	List<ActionTaken> getActionsTaken(@WebParam(name = "documentId") String documentId);

	
//    public DocumentDetailDTO getDocumentDetailFromAppId(String documentTypeName, String appId) throws WorkflowException;
//
//	public RouteHeaderDTO getRouteHeaderWithPrincipal(
//			@WebParam(name = "principalId") String principalId,
//			@WebParam(name = "documentId") String documentId)
//			throws WorkflowException;
//
//	public RouteHeaderDTO getRouteHeader(
//			@WebParam(name = "documentId") String documentId)
//			throws WorkflowException;
//
//	public DocumentDetailDTO getDocumentDetail(
//			@WebParam(name = "documentId") String documentId)
//			throws WorkflowException;
//
//	public RouteNodeInstanceDTO getNodeInstance(
//			@WebParam(name = "nodeInstanceId") Long nodeInstanceId)
//			throws WorkflowException;
//
//	public Long getNewResponsibilityId() throws WorkflowException;
//	
//
//	public ActionRequestDTO[] getActionRequests(
//			@WebParam(name = "documentId") String documentId,
//			@WebParam(name = "nodeName") String nodeName,
//			@WebParam(name = "principalId") String principalId)
//			throws WorkflowException;
//
//	public String getAppDocId(
//			@WebParam(name = "documentId") String documentId);
//
//	
//	public DocumentSearchResultDTO performDocumentSearch(
//			@WebParam(name = "criteriaVO") DocumentSearchCriteriaDTO criteriaVO)
//			throws WorkflowException;
//
//	public DocumentSearchResultDTO performDocumentSearchWithPrincipal(
//			@WebParam(name = "principalId") String principalId,
//			@WebParam(name = "criteriaVO") DocumentSearchCriteriaDTO criteriaVO)
//			throws WorkflowException;
//	
//	public RouteNodeInstanceDTO[] getDocumentRouteNodeInstances(
//			@WebParam(name = "documentId") String documentId)
//			throws WorkflowException;
//
//	public RouteNodeInstanceDTO[] getActiveNodeInstances(
//			@WebParam(name = "documentId") String documentId)
//			throws WorkflowException;
//
//	public RouteNodeInstanceDTO[] getTerminalNodeInstances(
//			@WebParam(name = "documentId") String documentId)
//			throws WorkflowException;
//
//	public DocumentContentDTO getDocumentContent(
//			@WebParam(name = "documentId") String documentId)
//			throws WorkflowException;
//
//	// 2.2
//	public String[] getPreviousRouteNodeNames(
//			@WebParam(name = "documentId") String documentId)
//			throws WorkflowException;
//
//	
//	public String getDocumentStatus(
//			@WebParam(name = "documentId") String documentId)
//			throws WorkflowException;
//
//	public RouteNodeInstanceDTO[] getCurrentNodeInstances(
//			@WebParam(name = "documentId") String documentId)
//			throws WorkflowException;
//	
//	public String[] getPrincipalIdsWithPendingActionRequestByActionRequestedAndDocId(
//			@WebParam(name = "actionRequestedCd") String actionRequestedCd,
//			@WebParam(name = "documentId") String documentId)
//			throws WorkflowException;
//
//	
//	public String getDocumentInitiatorPrincipalId(
//			@WebParam(name = "documentId") String documentId)
//			throws WorkflowException;
//
//	/**
//	 * Returns the principal ID of the user who routed the given document.
//	 * <b>null</b> if the document can not be found.
//	 * 
//	 * @throws WorkflowException
//	 */
//	public String getDocumentRoutedByPrincipalId(
//			@WebParam(name = "documentId") String documentId)
//			throws WorkflowException;
//
//	@XmlJavaTypeAdapter(value = AttributeSetAdapter.class)
//	public AttributeSet getActionsRequested(
//			@WebParam(name = "principalId") String principalId,
//			@WebParam(name = "documentId") String documentId);
//
//	/**
//	 * 
//	 * This method does a direct search for the searchableAttribute without
//	 * going through the doc search.
//	 * 
//	 * @param documentId
//	 * @param key
//	 * @return
//	 */
//	public String[] getSearchableAttributeStringValuesByKey(
//			@WebParam(name = "documentId") String documentId,
//			@WebParam(name = "key") String key);
//
//	/**
//	 * 
//	 * This method does a direct search for the searchableAttribute without
//	 * going through the doc search.
//	 * 
//	 * @param documentId
//	 * @param key
//	 * @return
//	 */
//	@XmlJavaTypeAdapter(value = SqlTimestampAdapter.class)
//	public Timestamp[] getSearchableAttributeDateTimeValuesByKey(
//			@WebParam(name = "documentId") String documentId,
//			@WebParam(name = "key") String key);
//
//	/**
//	 * 
//	 * This method does a direct search for the searchableAttribute without
//	 * going through the doc search.
//	 * 
//	 * @param documentId
//	 * @param key
//	 * @return
//	 */
//	public BigDecimal[] getSearchableAttributeFloatValuesByKey(
//			@WebParam(name = "documentId") String documentId,
//			@WebParam(name = "key") String key);
//
//	/**
//	 * 
//	 * This method does a direct search for the searchableAttribute without
//	 * going through the doc search.
//	 * 
//	 * @param documentId
//	 * @param key
//	 * @return
//	 */
//	public Long[] getSearchableAttributeLongValuesByKey(
//			@WebParam(name = "documentId") String documentId,
//			@WebParam(name = "key") String key);
//
//	public String getFutureRequestsKey(
//			@WebParam(name = "principalId") String principalId);
//
//	public String getReceiveFutureRequestsValue();
//
//	public String getDoNotReceiveFutureRequestsValue();
//
//	public String getClearFutureRequestsValue();
//	
//	 public DocumentStatusTransitionDTO[] getDocumentStatusTransitionHistory(
//	    		@WebParam(name = "documentId") String documentId)
//	    		throws WorkflowException;
//	    
//	    //for docmentlink
//	    public void addDocumentLink(DocumentLinkDTO docLinkVO) throws WorkflowException;
//
//	    public void deleteDocumentLink(DocumentLinkDTO docLinkVO) throws WorkflowException;
//	    
//	    public void deleteDocumentLinksByDocId(String docId) throws WorkflowException;
//	    
//	    public List<DocumentLinkDTO> getLinkedDocumentsByDocId(String documentId) throws WorkflowException;
//	    
//	    public DocumentLinkDTO getLinkedDocument(DocumentLinkDTO docLinkVO) throws WorkflowException;
	
}
