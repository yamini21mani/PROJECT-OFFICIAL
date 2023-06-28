package com.te.allerganlms.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.allerganlms.dto.RolesDto;
import com.te.allerganlms.dto.UserCreationDto;
import com.te.allerganlms.entity.CustomUserDetails;
import com.te.allerganlms.entity.GroupRoles;
import com.te.allerganlms.entity.Roles;
import com.te.allerganlms.entity.User;
import com.te.allerganlms.entity.UserStatus;
import com.te.allerganlms.exceptionHandling.UserJourneyException;
import com.te.allerganlms.repository.GroupRepository;
import com.te.allerganlms.repository.RolesRepository;
import com.te.allerganlms.repository.UserRepository;
import com.te.allerganlms.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService, UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GroupRepository groupRepository;
//	@Autowired
//	private UserJourneyRepository userJourneyRepository;
//	@Autowired
//	private BCryptPasswordEncoder encoder;
	@Autowired
	private RolesRepository rolesRepository;

//	private JwtUtils jwtUtils;

	@Override
	public String createAdminUser(Integer groupId, UserCreationDto userCreationDto) {
		Optional<GroupRoles> groupRoles = groupRepository.findById(groupId);
		if (!groupRoles.isEmpty()) {
			GroupRoles roles = groupRoles.get();
			String substring = userCreationDto.getEmployeeName().substring(0, 3).toUpperCase();
			User user = User.builder().employeeName(userCreationDto.getEmployeeName().toUpperCase())
					.employeePassword(userCreationDto.getEmployeePassword()).role(userCreationDto.getRole())
					.status(UserStatus.ONBOARDING).build();
			User save = userRepository.save(user);
			user.setGroupRoles(roles);
			user.setEmployeeUserName("TYC" + substring + save.getEmployeeId());
			userRepository.save(user);
//			String generateToken = jwtUtils.generateToken();
//			System.err.println(generateToken);
			return user.getEmployeeUserName();

		}
		throw new UserJourneyException("No Group data available in Database");
	}

	@Override
	public Integer createCommonUser(Integer groupId, UserCreationDto userCreationDto) {
		Optional<GroupRoles> groupRoles = groupRepository.findById(groupId);
//		String roleName = rolesRepository.getById(2).getRoleName();
//		if (userCreationDto.getRole().equals(roleName)) {
		if (!groupRoles.isEmpty()) {
			GroupRoles roles = groupRoles.get();
			String substring = userCreationDto.getEmployeeName().substring(0, 3).toUpperCase();
			User user = User.builder().employeeName(userCreationDto.getEmployeeName().toUpperCase())
					.employeePassword(userCreationDto.getEmployeePassword()).role(userCreationDto.getRole())
					.status(UserStatus.ONBOARDING).build();
			User save = userRepository.save(user);
			user.setGroupRoles(roles);
			user.setEmployeeUserName("TYC" + substring + save.getEmployeeId());
			userRepository.save(user);
			return save.getEmployeeId();
//		}
//		throw new UserJourneyException("no role with the specified one");
		}
		throw new UserJourneyException("No Group data available in Database");
	}

	@Override
	public User getUser(Integer employeeId) {
		try {
//			Claims claims = jwtUtils.getClaim();
//			Date date = claims.getExpiration();
//			String issuer = claims.getIssuer();
//			String id = claims.getId();
//			String subject = claims.getSubject();
			return userRepository.findById(employeeId)
					.orElseThrow(() -> new UserJourneyException("Unable to find the mentioned User"));
		} catch (UserJourneyException e) {
			e.printStackTrace();
			throw new UserJourneyException("unable to fetch the user ");
		}
	}

	@Override
	public void deleteUser(Integer employeeId) {
		User user = userRepository.findById(employeeId)
				.orElseThrow(() -> new UserJourneyException("Unable to find the EMPLOYEE with given Id"));
//		String username = user.getEmployeeUserName();
//		Optional<UserJourney> findById = userJourneyRepository.findById(username);
//		if (findById.isPresent()) {
//			UserJourney userJourney = findById.get();
//			userJourneyRepository.delete(userJourney);
		userRepository.delete(user);
//		}
	}

	public User updateEmployeeName(Integer employeeId, String employeeName) {
		User user = userRepository.findById(employeeId)
				.orElseThrow(() -> new UserJourneyException("Unable to find the user with given userId"));
		user.setEmployeeName(employeeName.toUpperCase());
		userRepository.save(user);
		String substring = user.getEmployeeName().substring(0, 3);
		user.setEmployeeUserName("TYC" + substring + user.getEmployeeId());
		return userRepository.save(user);
	}

	public User updateEmployeePassword(Integer employeeId, String employeePassword) {
		User user = userRepository.findById(employeeId)
				.orElseThrow(() -> new UserJourneyException("Unable to find the user with given Id"));
		user.setEmployeePassword(employeePassword);
		return userRepository.save(user);
	}

	public User updateUserStatus(Integer employeeId, UserStatus status) {
		User user = userRepository.findById(employeeId)
				.orElseThrow(() -> new UserJourneyException("Unable to find the user with given Id"));
		if (status == UserStatus.ACTIVE)
			user.setStatus(UserStatus.ACTIVE);
		else
			user.setStatus(UserStatus.DEACTIVATED);

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String employeeUserName) throws UsernameNotFoundException {
		User user = userRepository.findUserByemployeeUserName(employeeUserName);

		if (user == null) {
			throw new UsernameNotFoundException("Please check the user name");
		} else {
			return new CustomUserDetails(user);
		}
	}

	public Roles createRole(RolesDto rolesDto) {
		Roles roles = Roles.builder().roleId(rolesDto.getRoleId()).roleName(rolesDto.getRoleName()).build();
		rolesRepository.save(roles);
		return roles;
	}

	public Roles deleteRole(Integer roleId) {
		Optional<Roles> findById = rolesRepository.findById(roleId);
		if (findById.isPresent()) {
			Roles roles = findById.get();
			rolesRepository.delete(roles);
		}
		throw new UserJourneyException("Unable to find the mentioned Role with the ID");
	}

}
