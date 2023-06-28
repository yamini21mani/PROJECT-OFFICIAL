package com.te.allerganlms.service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.te.allerganlms.entity.Asset;
import com.te.allerganlms.entity.Status;

public interface AssetService {
	// Create API
	public Integer createAsset(MultipartFile file) throws IOException;

	// Fetch API
	public OutputStream getAsset(Integer courseId);

	// Update API
	public File updateAssetData(Integer courseId, MultipartFile file) throws Exception;

	public Asset updateAssetName(Integer courseId, String courseName);

	public Asset updateAssetStatus(Integer courseId, Status status);

	public Asset updateAssetQuiz(Integer courseId);

	// Delete API
	public void deleteAsset(Integer courseId);

	public File setGroup(Integer groupId, Integer courseId);
}
