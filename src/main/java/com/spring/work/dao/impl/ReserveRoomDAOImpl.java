package com.spring.work.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.work.dao.ReserveRoomDAO;
import com.spring.work.domain.ReserveRoomVO;

@Repository
public class ReserveRoomDAOImpl implements ReserveRoomDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static String namespace = "com.spring.mapper.ReserveRoomMapper";
	
	
	@Override
	public void create(ReserveRoomVO reserveRoomVO) throws Exception {
		sqlSession.insert(namespace + ".insertReserveRoom", reserveRoomVO);
	}

	@Override
	public List<ReserveRoomVO> selectAllReserveByDate(String r_reserve_date) throws Exception {
		return sqlSession.selectList(namespace + ".selectReserveRoomByDate", r_reserve_date);
	}

	@Override
	public ReserveRoomVO selectOne(int r_no) throws Exception {
		return sqlSession.selectOne(namespace + ".selectReserveRoomDetail", r_no);
	}

	@Override
	public void update(ReserveRoomVO reserveRoomVO) throws Exception {
		sqlSession.update(namespace + ".updateReserveRoom", reserveRoomVO);
	}

	@Override
	public void delete(int r_no) throws Exception {
		sqlSession.update(namespace + ".deleteReserveRoom", r_no);
	}

	@Override
	public List<ReserveRoomVO> selectReserveByRecurDateList(ReserveRoomVO reserveRoomVO,
			List<String> reserveDateRecurList) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("r_room_no", reserveRoomVO.getR_room_no());
		param.put("r_start_time", reserveRoomVO.getR_start_time());
		param.put("r_end_time", reserveRoomVO.getR_end_time());
		param.put("r_date_recur_list", reserveDateRecurList);
		
		return sqlSession.selectList(namespace + ".selectReserveByRecurDateList", param);
	}

	@Override
	public ReserveRoomVO passwordCheck(ReserveRoomVO reserveRoomVO) throws Exception {
		return sqlSession.selectOne(namespace + ".selectPasswordCheck", reserveRoomVO);
	}

}
