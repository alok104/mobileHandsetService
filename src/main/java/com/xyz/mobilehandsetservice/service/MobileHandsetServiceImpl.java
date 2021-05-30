package com.xyz.mobilehandsetservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.xyz.mobilehandsetservice.dto.HandsetDetailVO;
import com.xyz.mobilehandsetservice.entity.HandsetDetail;

@Repository
public class MobileHandsetServiceImpl implements MobileHandsetService {
	
	private  @Autowired MongoTemplate mongoTemplate; 

	@Override
	public List<HandsetDetailVO> getHandsetDetails(Double priceEur, String sim, Integer announceDate) {
		final List<HandsetDetailVO> detailVOs = new ArrayList<>();
		final Query query = new Query();
		final List<Criteria> criteria = new ArrayList<>();
		if (priceEur != null) {
			criteria.add(Criteria.where("release.priceEur").is(priceEur));
		}
		if (sim != null && !sim.isEmpty()) {
			criteria.add(Criteria.where("sim").is(sim));
		}
		if (announceDate != null) {
			criteria.add(Criteria.where("release.announceDate").regex(announceDate + ".*"));
		}
		if (!criteria.isEmpty()) {
			query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
			List<HandsetDetail> details = mongoTemplate.find(query, HandsetDetail.class);
			if(details != null && !details.isEmpty()) {
				details.forEach(detail -> {
					HandsetDetailVO detailVO = new HandsetDetailVO();
					BeanUtils.copyProperties(detail, detailVO);
					detailVOs.add(detailVO);
				});
			}
		}

		return !detailVOs.isEmpty() ? detailVOs : null;
	}

}
