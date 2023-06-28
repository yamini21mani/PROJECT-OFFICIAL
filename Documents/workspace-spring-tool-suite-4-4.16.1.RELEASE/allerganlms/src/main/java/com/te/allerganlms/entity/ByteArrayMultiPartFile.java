package com.te.allerganlms.entity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class ByteArrayMultiPartFile implements MultipartFile{
	
	byte[] courseData;
	String courseName;
	
	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getOriginalFilename() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public long getSize() {
		return 0;
	}

	@Override
	public byte[] getBytes() throws IOException {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return null;
	}

	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	public ByteArrayMultiPartFile(byte[] courseData) {
		super();
		this.courseData = courseData;
	}

}
