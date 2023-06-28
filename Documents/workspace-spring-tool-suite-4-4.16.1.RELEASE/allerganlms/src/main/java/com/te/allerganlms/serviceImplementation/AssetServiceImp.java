package com.te.allerganlms.serviceImplementation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.te.allerganlms.entity.Asset;
import com.te.allerganlms.entity.GroupRoles;
import com.te.allerganlms.entity.Quiz;
import com.te.allerganlms.entity.Status;
import com.te.allerganlms.exceptionHandling.AssetException;
import com.te.allerganlms.exceptionHandling.GroupException;
import com.te.allerganlms.exceptionHandling.UserJourneyException;
import com.te.allerganlms.repository.AssetRepository;
import com.te.allerganlms.repository.GroupRepository;
import com.te.allerganlms.repository.QuizRepository;
import com.te.allerganlms.service.AssetService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Scope("singleton")
public class AssetServiceImp implements AssetService {
	@Autowired
	private AssetRepository assetRepository;

	@Autowired
	private QuizRepository quizRepository;
	@Autowired
	private GroupRepository groupRepository;

	public Integer createAsset(MultipartFile file) {

		try {

			File folder = new File(
					"C:\\Users\\yamin\\Documents\\workspace-spring-tool-suite-4-4.16.1.RELEASE\\allerganlms\\src");
			folder.mkdir();
			InputStream inputStream = file.getInputStream();
			String filename = file.getOriginalFilename();
			String type = file.getContentType();
			byte[] readAllBytes;

			readAllBytes = inputStream.readAllBytes();

//			ObjectMapper mapper=new ObjectMapper();
//			Asset readValue = mapper.readValue(readAllBytes, Asset.class);
			Asset asset = Asset.builder().courseName(filename).courseData(readAllBytes).type(type).build();
			Asset save = assetRepository.save(asset);
			assetRepository.save(save);
			Integer courseId = save.getCourseId();
			if (courseId != null) {
				return courseId;
			} else
				throw new AssetException("issue with ID generation");

		} catch (IOException e) {
			e.printStackTrace();
			throw new AssetException("Unable to create asset with the given multipart file");
		}

	}

	@Override
	public OutputStream getAsset(Integer courseId) {
		try {
			Asset asset = assetRepository.findById(courseId)
					.orElseThrow(() -> new GroupException("Unable to find the group with given ID"));
			File file = new File(asset.getCourseName());
			
			OutputStream outputStream = new FileOutputStream(file);
			outputStream.write(asset.getCourseData());
			outputStream.close();
			return outputStream;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssetException("Please check the course ID");
		}

	}

	@Override
	public Asset updateAssetQuiz(Integer courseId) {
		try {
			Asset assetrepo = assetRepository.findById(courseId)
					.orElseThrow(() -> new AssetException("Unable to find the Asset with given ID to add QUIZ"));

			List<Quiz> all = quizRepository.findAll().stream().filter(p -> p.getQuizId().equals(courseId)).toList();
			assetrepo.setQuiz(all);
			return assetRepository.save(assetrepo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssetException("Unable to update the Asset Quiz");
		}

	}

	@Override
	public Asset updateAssetStatus(Integer courseId, Status status) {
		try {
			Asset assetrepo = assetRepository.findById(courseId)
					.orElseThrow(() -> new AssetException("Unable to find the Asset with provided Id"));
			assetrepo.setStatus(Status.SUBMITTED);
			return assetRepository.save(assetrepo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssetException("Unable to set the Asset Status, Please check");
		}

	}

	@Override
	public File updateAssetData(Integer courseId, MultipartFile file) throws Exception {
		try {
			InputStream inputStream = file.getInputStream();
			Asset assetrepo = assetRepository.findById(courseId)
					.orElseThrow(() -> new AssetException("Unable to find the Asset with given ID"));

			assetrepo.setCourseData(inputStream.readAllBytes());
			Asset asset = assetRepository.save(assetrepo);
			File files = new File(asset.getCourseName());
			OutputStream outputStream = new FileOutputStream(files);
			outputStream.write(asset.getCourseData());
			outputStream.close();
			return files;

		} catch (Exception e) {
			e.printStackTrace();
			throw new AssetException("unable to update the Asset course Data");
		}

	}

	@Override
	public Asset updateAssetName(Integer courseId, String courseName) {
		try {
			Asset assetrepo = assetRepository.findById(courseId)
					.orElseThrow(() -> new AssetException("Unable to find the Asset with given ID"));
			assetrepo.setCourseName(courseName);
			return assetRepository.save(assetrepo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssetException("Unable to update the Asset name");
		}

	}

	@Override
	public void deleteAsset(Integer courseId) {
		try {
			Asset asset = assetRepository.findById(courseId)
					.orElseThrow(() -> new AssetException("unable to find the course ID given"));
			if (asset != null)
				assetRepository.delete(asset);
			else
				throw new AssetException("Unable to delete the asset ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public File setGroup(Integer groupId, Integer courseId) {
		try {
			Optional<Asset> asset = assetRepository.findById(courseId);
			if (!asset.isEmpty()) {
				Asset assetu = asset.get();
				Optional<GroupRoles> groupRoles = groupRepository.findById(groupId);
				if (!groupRoles.isEmpty()) {
					GroupRoles roles = groupRoles.get();
					assetu.setGroupRoles(roles);
					Asset assets = assetRepository.save(assetu);
					File file = new File(assets.getCourseName());
					OutputStream outputStream = new FileOutputStream(file);
					outputStream.write(assets.getCourseData());
					outputStream.close();
					return file;
				} else
					throw new UserJourneyException("Unable to find the specified group");
			} else
				throw new UserJourneyException("Unable to find the asset`");
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserJourneyException("unable to set the group to the Asset");
		}

	}
}
