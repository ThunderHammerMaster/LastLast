package com.mzk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzk.dao.TrainDao;
import com.mzk.entity.Train;
import com.mzk.service.TrainService;
@Service("trainService")
public class TrainServiceImpl implements TrainService{
	@Autowired
	private TrainDao trainDao;

	@Override
	public Train queryTrainByTrain(Train train) {
		return trainDao.queryTrainByTrain(train);
	}

	@Override
	public void addTrain(Train train) {
		trainDao.addTrain(train);
		
	}

	@Override
	public void delTrain(int trId) {
		trainDao.delTrain(trId);
		
	}

	@Override
	public void updateTrain(Train train) {
		trainDao.updateTrain(train);
		
	}

	@Override
	public List<Train> queryAllTrain() {
		return trainDao.queryAllTrain();
	}

	@Override
	public List<Train> queryTrainByTrainId(int trainId) {
		return trainDao.queryTrainByTrainId(trainId);
	}
}
