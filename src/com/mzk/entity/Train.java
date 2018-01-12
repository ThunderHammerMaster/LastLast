package com.mzk.entity;

import java.util.Date;

public class Train {
	private int trainId;
	private String trainTitle;
	private Date trainDate;
	private int trainLength;
	private String trainContent;
	private String trainStatus;
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public String getTrainTitle() {
		return trainTitle;
	}
	public void setTrainTitle(String trainTitle) {
		this.trainTitle = trainTitle;
	}
	public Date getTrainDate() {
		return trainDate;
	}
	public void setTrainDate(Date trainDate) {
		this.trainDate = trainDate;
	}
	public int getTrainLength() {
		return trainLength;
	}
	public void setTrainLength(int trainLength) {
		this.trainLength = trainLength;
	}
	public String getTrainContent() {
		return trainContent;
	}
	public void setTrainContent(String trainContent) {
		this.trainContent = trainContent;
	}
	public String getTrainStatus() {
		return trainStatus;
	}
	public void setTrainStatus(String trainStatus) {
		this.trainStatus = trainStatus;
	}
	public Train() {
		super();
	}
	public Train(int trainId, String trainTitle, Date trainDate, int trainLength, String trainContent,
			String trainStatus) {
		super();
		this.trainId = trainId;
		this.trainTitle = trainTitle;
		this.trainDate = trainDate;
		this.trainLength = trainLength;
		this.trainContent = trainContent;
		this.trainStatus = trainStatus;
	}
	@Override
	public String toString() {
		return "Train [trainId=" + trainId + ", trainTitle=" + trainTitle + ", trainDate=" + trainDate
				+ ", trainLength=" + trainLength + ", trainContent=" + trainContent + ", trainStatus=" + trainStatus
				+ "]";
	}
	
	
}
