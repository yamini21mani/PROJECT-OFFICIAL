package com.te.ecommerce.serviceimplementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ecommerce.dto.RoleDto;
import com.te.ecommerce.entity.Roles;
import com.te.ecommerce.exceptionhandling.GeneralException;
import com.te.ecommerce.repository.RolesRepository;
import com.te.ecommerce.serviceinterface.AdminInterface;

@Service
public class AdminServiceImp implements AdminInterface{
	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public boolean createRole(RoleDto roleDto) {
		Roles roles=new Roles();
		BeanUtils.copyProperties(roleDto, roles);
		Roles savedRole = rolesRepository.save(roles);
		if(savedRole!=null)
		return true;
		else 
		throw new GeneralException("unable to create Role");
	}
//	@Override
//	public boolean createRole(RoleDto roleDto) {
//		
//	}

	@Override
	public boolean deleteRole(RoleDto roleDto) {
		Roles roles=new Roles();
		BeanUtils.copyProperties(roleDto, roles);
		Roles data=rolesRepository.findById(roles.getRoleId()).orElseThrow(()-> new GeneralException("Unable to delete the role"));
		if(data!=null)
			rolesRepository.delete(data);
		return true;
				
		
	}
	
	
}
