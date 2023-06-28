package com.te.allerganlms.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.allerganlms.entity.Asset;
import com.te.allerganlms.entity.GroupRoles;
import com.te.allerganlms.entity.User;
import com.te.allerganlms.entity.UserJourney;
import com.te.allerganlms.exceptionHandling.UserJourneyException;
import com.te.allerganlms.repository.AssetRepository;
import com.te.allerganlms.repository.GroupRepository;
import com.te.allerganlms.repository.UserRepository;
import com.te.allerganlms.service.UserJourneyService;

@Service
public class UserJourneyServiceImp implements UserJourneyService {
	@Autowired
	private UserRepository userRepository;
//	@Autowired
//	private UserJourneyRepository userJourneyRepository;
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private AssetRepository assetRepository;

	@Override
	public UserJourney getUserJourney(Integer employeeId) {
		User user = userRepository.findById(employeeId)
				.orElseThrow(() -> new UserJourneyException("Unable to find the employee with the mentioned ID"));
	Integer groupId = user.getGroupRoles().getGroupId();
	GroupRoles groupRoles = groupRepository.findById(groupId).get();
		List<Asset> asset = assetRepository.findAll().stream().filter(p->p.getCourseId().equals(groupId)).toList();
		UserJourney journey=UserJourney.builder().employeeUserName(user.getEmployeeUserName()).assets(asset).user(user).groupRoles(groupRoles).build();
		return journey;
	}

//	@Override
//	public UserJourney updateUserJourney(Integer employeeId, String employeeUserName) {
//		user
//		return null;
//	}

}
