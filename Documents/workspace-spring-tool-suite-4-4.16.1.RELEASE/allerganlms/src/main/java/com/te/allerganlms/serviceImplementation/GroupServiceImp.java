package com.te.allerganlms.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.allerganlms.dto.GroupRolesCreationDto;
import com.te.allerganlms.entity.GroupRoles;
import com.te.allerganlms.entity.GroupStatus;
import com.te.allerganlms.exceptionHandling.GroupException;
import com.te.allerganlms.repository.GroupRepository;
import com.te.allerganlms.service.GroupService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GroupServiceImp implements GroupService {
	@Autowired
	private GroupRepository groupRepository;

	@Override
	public Integer createGroup(GroupRolesCreationDto groupRolesDto) {
		GroupRoles groupRoles = GroupRoles.builder().groupName(groupRolesDto.getGroupName())
				.groupRole(groupRolesDto.getGroupRole()).groupStatus(GroupStatus.CREATED).build();
		GroupRoles save = groupRepository.save(groupRoles);
		return save.getGroupId();
	}

	@Override
	public GroupRoles getGroup(Integer groupId) {
		return groupRepository.findById(groupId)
				.orElseThrow(() -> new GroupException("Unable to find the group ID, please check"));

	}

	@Override
	public GroupRoles updateGroupName(Integer groupId, String groupName) {
		GroupRoles groupRoles = groupRepository.findById(groupId)
				.orElseThrow(() -> new GroupException("unable to find the group with the mentioned ID"));

		groupRoles.setGroupName(groupName);
		return groupRepository.save(groupRoles);

	}

	@Override
	public GroupRoles updateGroupStatus(Integer groupId, GroupStatus groupStatus) {
		GroupRoles groupRoles = groupRepository.findById(groupId)
				.orElseThrow(() -> new GroupException("unable to find the group with the mentioned ID"));
		groupRoles.setGroupStatus(GroupStatus.ACTIVATED);
		return groupRepository.save(groupRoles);

	}

	@Override
	public GroupRoles updateGroupRole(Integer groupId, String groupRole) {
		GroupRoles groupRoles = groupRepository.findById(groupId)
				.orElseThrow(() -> new GroupException("unable to find the group with the mentioned ID"));
		groupRoles.setGroupRole(groupRole);
		return groupRepository.save(groupRoles);

	}

	@Override
	public void deleteGroup(Integer groupId) {
		GroupRoles groupRoles = groupRepository.findById(groupId)
				.orElseThrow(() -> new GroupException("Unable to find the right Group with the mentioned ID"));
		groupRepository.delete(groupRoles);
	}

}
