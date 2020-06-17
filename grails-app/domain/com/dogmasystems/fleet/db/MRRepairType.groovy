package com.dogmasystems.fleet.db

import java.util.Date;

class MRRepairType implements Serializable{

	String description
	static auditable = true
	Date dateCreated, lastUpdated

	Long tenantId

	def springSecurityService
	def beforeValidate() {
		def user = springSecurityService.currentUser
		if(user != null){
			tenantId = user.tenant?.tenantId
		}
	}

	static mapping = {
		cache true
		id generator:'sequence', params:[sequence:'mrRepairType_seq']
	}

	static constraints = {
		description unique:true
	}
}
