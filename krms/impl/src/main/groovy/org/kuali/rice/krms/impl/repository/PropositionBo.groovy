package org.kuali.rice.krms.impl.repository



import javax.persistence.CascadeType;
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table

import org.hibernate.annotations.Type
import org.kuali.rice.kns.bo.ExternalizableBusinessObject
import org.kuali.rice.kns.bo.Inactivateable
import org.kuali.rice.kns.bo.PersistableBusinessObjectBase
import javax.persistence.GeneratedValue

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter

import org.kuali.rice.krms.api.repository.Proposition
import org.kuali.rice.krms.api.repository.PropositionContract
import org.kuali.rice.krms.api.repository.PropositionParameter


@Entity
@Table(name="KRMS_PROP_T")
public class PropositionBo extends PersistableBusinessObjectBase implements PropositionContract {

	@Id
    @GeneratedValue(generator="KREW_PROP_S")
	@GenericGenerator(name="KREW_PROP_S",strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",parameters=[
			@Parameter(name="sequence_name",value="KREW_PROP_S"),
			@Parameter(name="value_column",value="id")
	])
	@Column(name="PROP_ID")
	def String propId;
	
	@Column(name="DESC_TXT")
	def String description;
	
	@Column(name="TYP_ID")
	def String typeId;
	
	@Column(name="DSCRM_TYP_CD")
	def String propositionTypeCode;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=[CascadeType.PERSIST, CascadeType.REMOVE])
	@JoinColumn(name="PROP_ID", referencedColumnName="PROP_ID")
	def List<PropositionParameterBo> parameters;
	
	/**
	* Converts a mutable bo to it's immutable counterpart
	* @param bo the mutable business object
	* @return the immutable object
	*/
   static Proposition to(PropositionBo bo) {
	   if (bo == null) { return null }
	   return org.kuali.rice.krms.api.repository.Proposition.Builder.create(bo).build();
   }

   /**
	* Converts a immutable object to it's mutable bo counterpart
	* @param im immutable object
	* @return the mutable bo
	*/
   static PropositionBo from(Proposition im) {
	   if (im == null) { return null }

	   PropositionBo bo = new PropositionBo()
	   bo.propId = im.propId
	   bo.description = im.description
	   bo.typeId = im.typeId
	   bo.propositionTypeCode = im.propositionTypeCode
	   bo.parameters = new ArrayList<PropositionParameterBo>()
	   for ( parm in im.parameters){
		   bo.parameters.add (PropositionParameterBo.from(parm))
	   }

	   return bo
   }
 
} 