package com.spring.work.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.util.UtilDate;
import com.spring.work.domain.ReserveRoomVO;
import com.spring.work.service.ReserveRoomService;

@Controller
@RequestMapping("/reserve/")
public class ReserveRoomController {
	
	@Autowired
	private ReserveRoomService reserveRoomService;
	
	@RequestMapping(value="/status", method=RequestMethod.GET)
	public String reserveStatusInit(Model model) throws Exception {
		return "/reserve/reserveRoomList";
	}

	@ResponseBody
	@RequestMapping(value="/status/date", method=RequestMethod.GET)
	public ModelAndView reserveStatusByDate(@RequestParam("date") String r_reserve_date, 
			ModelAndView mav) throws Exception {
		
		mav.addObject("reserveList", reserveRoomService.selectAllReserveByDate(r_reserve_date));
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String reserveCreatePage(Model model) throws Exception {
		return "/reserve/reserveRoomCreate";
	}
	
/*	@RequestMapping(value="/create/new", method=RequestMethod.POST)
	public String reserveCreate(@RequestBody ReserveRoomVO vo) throws Exception {
		System.out.println(vo.toString());
		return "/reserve/reserveRoomList";
	}
*/	
	
	@RequestMapping(value="/create/new", method=RequestMethod.POST)
	public String reserveCreate(ReserveRoomVO reserveRoomVO,
			@RequestParam("r_reserve_date") String r_reserve_date,
			@RequestParam("r_repeat_cnt") String r_repeat_cnt,
			Model model, RedirectAttributes rttr) throws Exception {
		
		ArrayList<String> reserveDateRecurList = (ArrayList<String>) UtilDate.RecurrDateCalc(r_reserve_date, r_repeat_cnt);
		
		List<ReserveRoomVO> vo = reserveRoomService.reserveConfirm(reserveRoomVO, reserveDateRecurList);
		
		if(vo.size() > 0){
			rttr.addFlashAttribute("msg", "예약불가");
			return "redirect:/reserve/create";
		}else{
			reserveRoomVO.setR_date_recur_list(reserveDateRecurList);
			reserveRoomService.create(reserveRoomVO);
			rttr.addFlashAttribute("msg", "예약완료");
			return "redirect:/reserve/status";
		}
		
	}

	
	@RequestMapping(value="/detailView", method=RequestMethod.POST)
	public String reserveDetailViewPage(@RequestParam("r_no") int r_no, Model model) throws Exception {
		model.addAttribute("reserveRoomVO", reserveRoomService.selectOne(r_no));
		return "/reserve/reserveRoomDetail";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView reserveCancel(ReserveRoomVO reserveRoomVO, 
			ModelAndView mav,
			RedirectAttributes rttr) throws Exception {
		
		ReserveRoomVO vo = reserveRoomService.passwordCheck(reserveRoomVO);

		if(vo == null){
			mav.addObject("msg", "비밀번호불일치");
			mav.addObject("result", 0);
		}else{
			reserveRoomService.delete(reserveRoomVO.getR_no());
			mav.addObject("msg", "삭제완료");
			mav.addObject("result", 1);
		}
		
		mav.setViewName("jsonView");
		return mav;
	}
	
}
