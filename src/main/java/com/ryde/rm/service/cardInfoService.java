package com.ryde.rm.service;

import java.util.List;
import javax.annotation.Resource;

import com.ryde.rm.domain.CardInfo;
import com.ryde.rm.repository.CardInfoRepository;


public class cardInfoService {
	
	@Resource
	private CardInfoRepository cardInfoRepository;
	
	public void createCardInfo(CardInfo cardInfo) {
		

	}

	public void updateCardInfo(CardInfo cardInfo) {

	}

	public void fetchCardInfo(CardInfo cardInfo) {

	}
	
	
	public List<CardInfo> getCardInfos(){
		return cardInfoRepository.findAll();
		
	}

}
