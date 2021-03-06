package com.tpajay.medicus.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tpajay.medicus.model.PatientProvider;

/*
* Database opertaions for: Insurance Providers and Patient Provider(s)
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
*/
//@Component
@Repository
@Transactional
public class PatientProviderDaoImp implements PatientProviderDaoInterface {
	
	static final Logger logger = LoggerFactory.getLogger(PatientDaoHibernateImp.class);

	@Autowired
	SessionFactory sessionFactory;

	/* [TODO]
	 * Need to bring back the data from the providers table using patient_providers
	 */
	
	
	//return a single provider for a patient
	@Transactional(readOnly = true)
	public PatientProvider getPatientProviderById(int id) {
		Session session = sessionFactory.getCurrentSession();
		PatientProvider provider = (PatientProvider)session.get(PatientProvider.class, id);		
		return provider;
	}
	
	//return a list of all providers for a patient
	public List<PatientProvider> getPatientProviderList(int id) {
		@SuppressWarnings("unchecked")
        List<PatientProvider> resultList = (List<PatientProvider>) sessionFactory.getCurrentSession()
                .createCriteria(PatientProvider.class)
                .add( Restrictions.eq( "patientId", id) )
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		logger.info(">>>>>> getPatientProviderList list size: " + resultList.size());
		return resultList;
	 }	

	public void savePatientProvider(PatientProvider provider) {
		// TODO Auto-generated method stub
		
	}

	public void updatePatientProvider(PatientProvider provider) {
		// TODO Auto-generated method stub
		
	}

	public void deletePatientProvider(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
