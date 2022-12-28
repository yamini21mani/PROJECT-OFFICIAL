package com.te.ecommerce.serviceinterface;

import com.te.ecommerce.dto.RoleDto;

public interface AdminInterface {
	public boolean createRole(RoleDto roleDto);
	public boolean deleteRole(RoleDto roleDto);
}
