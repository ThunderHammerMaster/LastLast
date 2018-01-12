package com.mzk.service;

import java.util.List;

import com.mzk.entity.Train;

public interface TrainService {
	public Train queryTrainByTrain(Train train);
	public void addTrain(Train train);
	public void delTrain(int trId);
	public void updateTrain(Train train);
	public List<Train> queryAllTrain();
	public List<Train> queryTrainByTrainId(int trainId);

}
