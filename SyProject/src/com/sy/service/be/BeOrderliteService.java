package com.sy.service.be;

import org.springframework.stereotype.Service;

import com.sy.entity.BeOrderlite;

@Service
public class BeOrderliteService extends BeParent {

	// Monkey ÖÆÔì
	public Integer monkeyInsert(BeOrderlite orderlite, Integer flag) {
		if (flag > 0)
			return getBeOrderliteMapper().insertSelective(orderlite);
		else
			return null;
	}
}