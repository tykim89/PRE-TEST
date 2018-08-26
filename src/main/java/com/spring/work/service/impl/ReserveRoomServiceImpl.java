package com.spring.work.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.work.dao.ReserveRoomDAO;
import com.spring.work.domain.ReserveRoomVO;
import com.spring.work.service.ReserveRoomService;

@Service
public class ReserveRoomServiceImpl implements ReserveRoomService{

	@Autowired
	private ReserveRoomDAO reserveRoomDAO;
	
	@Override
	public void create(ReserveRoomVO reserveRoomVO) throws Exception {
		reserveRoomDAO.create(reserveRoomVO);
	}

	@Override
	public List<ReserveRoomVO> selectAllReserveByDate(String r_reserve_date) throws Exception {
		return reserveRoomDAO.selectAllReserveByDate(r_reserve_date);
	}

	@Override
	public ReserveRoomVO selectOne(int r_no) throws Exception {
		return reserveRoomDAO.selectOne(r_no);
	}

	@Override
	public void update(ReserveRoomVO reserveRoomVO) throws Exception {
		reserveRoomDAO.update(reserveRoomVO);
	}

	@Override
	public void delete(int r_no) throws Exception {
		reserveRoomDAO.delete(r_no);
	}

	@Override
	public List<ReserveRoomVO> reserveConfirm(
			ReserveRoomVO reserveRoomVO, 
			List<String> reserveDateRecurList) throws Exception {
		return reserveRoomDAO.selectReserveByRecurDateList(reserveRoomVO, reserveDateRecurList);
	}

	@Override
	public ReserveRoomVO passwordCheck(ReserveRoomVO reserveRoomVO) throws Exception {
		return reserveRoomDAO.passwordCheck(reserveRoomVO);
	}

}
