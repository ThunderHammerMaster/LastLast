package com.mzk.service;

import com.mzk.entity.Resume;

public interface ResumeService {
	public void addResume(Resume resume);
	public int queryResIdByName(String rName);
	public Resume queryResumeByTorId(int tId);
}
