package com.yc.ums.service;

import java.util.List;

import com.yc.ums.entity.Profile;
import com.yc.ums.entity.ProfileBean;

public interface ProfileService {

	

	public List<Profile> listProfile();

	public boolean modifyProfile(Profile profile);

	public ProfileBean listPaginationProfile(String currPage, String pageSize);

}
