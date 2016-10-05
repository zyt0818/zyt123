package com.yc.ums.service.impl;

import java.util.List;

import com.yc.ums.entity.Profile;
import com.yc.ums.entity.ProfileBean;
import com.yc.ums.mapper.ProfileMapper;
import com.yc.ums.service.ProfileService;
import com.yc.ums.util.MyBatisUtil;

public class ProfileServiceImple implements ProfileService {
	private ProfileMapper profileMapper;
	public ProfileServiceImple() {
		this.profileMapper=MyBatisUtil.getSession().getMapper(ProfileMapper.class);
	}
	@Override
	public List<Profile> listProfile() {
		List<Profile> list=profileMapper.getAll();
		return list;
	}
	@Override
	public boolean modifyProfile(Profile profile) {
		
		return profileMapper.updateProfile(profile)>0;
	}
	@Override
	public ProfileBean listPaginationProfile(String currPage, String pageSize) {
		int currPage1=1;
		int pageSize1=10;
		if(pageSize!=null){
			pageSize1=Integer.parseInt(pageSize);
		}
		if(currPage!=null){
			currPage1=Integer.parseInt(currPage);
		}
		ProfileBean profileBean=new ProfileBean(pageSize1, currPage1);
		
		return profileMapper.getPartProfile(profileBean);
	}

}
