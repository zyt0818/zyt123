package com.yc.ums.mapper;

import java.util.List;

import com.yc.ums.entity.Profile;
import com.yc.ums.entity.ProfileBean;


public interface ProfileMapper {
	public List<Profile> getAll(); 
	public Profile get(int id) ;       
	public int update(Profile profile);
	public int updateProfile(Profile profile);
	public ProfileBean getPartProfile(ProfileBean profileBean);


}
