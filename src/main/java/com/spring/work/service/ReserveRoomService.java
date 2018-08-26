package com.spring.work.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.work.domain.ReserveRoomVO;

public interface ReserveRoomService {

	public void create(ReserveRoomVO reserveRoomVO) throws Exception;
	
	public List<ReserveRoomVO> selectAllReserveByDate(String r_reserve_date) throws Exception;
	
	public ReserveRoomVO selectOne(int r_no) throws Exception;
	
	public void update(ReserveRoomVO reserveRoomVO) throws Exception;
	
	public void delete(int r_no) throws Exception;
	
	public List<ReserveRoomVO> reserveConfirm(
			ReserveRoomVO reserveRoomVO, 
			List<String> reserveDateRecurList) throws Exception;
	
	public ReserveRoomVO passwordCheck(ReserveRoomVO reserveRoomVO) throws Exception;
	
}
