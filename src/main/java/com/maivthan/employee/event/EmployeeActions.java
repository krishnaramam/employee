package com.maivthan.employee.event;

import org.springframework.stereotype.Component;

@Component
public class EmployeeActions {
	
	public String createInboundAction="PLATFORM_INBOUND_EMPLOYEE_CREATE";
	public String updateInboundAction="PLATFORM_INBOUND_EMPLOYEE_UPDATE";
	public String deleteInboundAction="PLATFORM_INBOUND_EMPLOYEE_DELETE";
	
	public String createOutboundAction="PLATFORM_OUTBOUND_EMPLOYEE_CREATE";
	public String updateOutboundAction="PLATFORM_OUTBOUND_EMPLOYEE_UPDATE";
	public String deleteOutboundAction="PLATFORM_OUTBOUND_EMPLOYEE_DELETE";
	


}
