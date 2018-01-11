package com.mzk.dao;

import com.mzk.entity.Resume;

public interface ResumeDao {
	public void addResume(Resume resume);
	public int queryResIdByName(String rName);
	public Resume queryResumeByTorId(int tId);
	public void updateResume(Resume resume);
	public Resume queryResumeById(int rId);
	public void updateResAdmit(Resume resume);
	public void updateResfail(int resId);
}
