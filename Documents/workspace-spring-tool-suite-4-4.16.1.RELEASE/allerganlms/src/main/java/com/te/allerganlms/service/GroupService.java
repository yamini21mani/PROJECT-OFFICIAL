package com.te.allerganlms.service;

import com.te.allerganlms.dto.GroupRolesCreationDto;
import com.te.allerganlms.entity.GroupRoles;
import com.te.allerganlms.entity.GroupStatus;

public interface GroupService {
	//CREATE API
	public Integer createGroup(GroupRolesCreationDto groupRolesDto);
	//GET API
	public GroupRoles getGroup(Integer groupId);
	//update API
	public GroupRoles updateGroupName(Integer groupId, String groupName);
	public GroupRoles updateGroupStatus(Integer groupId,  GroupStatus groupStatus);
	public GroupRoles updateGroupRole(Integer groupId, String groupRole);
	//DELETE API
	public void deleteGroup(Integer groupId);
}
