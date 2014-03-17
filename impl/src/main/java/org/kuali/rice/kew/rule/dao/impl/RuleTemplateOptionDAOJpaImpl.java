/*
 * Copyright 2005-2008 The Kuali Foundation
 * 
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
package org.kuali.rice.kew.rule.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.kuali.rice.core.util.OrmUtils;
import org.kuali.rice.kew.rule.RuleTemplateOption;
import org.kuali.rice.kew.rule.dao.RuleTemplateOptionDAO;


public class RuleTemplateOptionDAOJpaImpl implements RuleTemplateOptionDAO {

	@PersistenceContext(unitName="kew-unit")
	private EntityManager entityManager;
	
  /*
   * (non-Javadoc)
   * @see org.kuali.rice.kew.rule.dao.RuleTemplateOptionDAO#delete(java.lang.Long)
   */
  public void delete(Long ruleTemplateOptionId) {
	  entityManager.remove(findByRuleTemplateOptionId(ruleTemplateOptionId));
  }

  /*
   * (non-Javadoc)
   * @see org.kuali.rice.kew.rule.dao.RuleTemplateOptionDAO#findByRuleTemplateOptionId(java.lang.Long)
   */
  public RuleTemplateOption findByRuleTemplateOptionId(Long ruleTemplateOptionId) {
	  return entityManager.find(RuleTemplateOption.class, ruleTemplateOptionId);
  }
  
  public void save (RuleTemplateOption ruleTemplateOption){
	  if(ruleTemplateOption.getRuleTemplateOptionId()==null){
		  entityManager.persist(ruleTemplateOption);
	  }else{
		  OrmUtils.merge(entityManager, ruleTemplateOption);
	  }
  }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}