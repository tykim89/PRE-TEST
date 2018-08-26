package com.spring.work.domain;

import java.util.List;

public class ReserveRoomVO {

	private int 	r_no;
	private String 	r_user_name;
	private String 	r_user_password;
	private String 	r_room_no;
	private String 	r_reserve_date;
	private String 	r_start_time;
	private String 	r_end_time;
	private String 	r_use_yn;
	private String 	r_regist_date;
	private List<String> r_date_recur_list;
	
	public ReserveRoomVO(){}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_user_name() {
		return r_user_name;
	}

	public void setR_user_name(String r_user_name) {
		this.r_user_name = r_user_name;
	}

	public String getR_user_password() {
		return r_user_password;
	}

	public void setR_user_password(String r_user_password) {
		this.r_user_password = r_user_password;
	}

	public String getR_room_no() {
		return r_room_no;
	}

	public void setR_room_no(String r_room_no) {
		this.r_room_no = r_room_no;
	}

	public String getR_reserve_date() {
		return r_reserve_date;
	}

	public void setR_reserve_date(String r_reserve_date) {
		this.r_reserve_date = r_reserve_date;
	}

	public String getR_start_time() {
		return r_start_time;
	}

	public void setR_start_time(String r_start_time) {
		this.r_start_time = r_start_time;
	}

	public String getR_end_time() {
		return r_end_time;
	}

	public void setR_end_time(String r_end_time) {
		this.r_end_time = r_end_time;
	}

	public String getR_use_yn() {
		return r_use_yn;
	}

	public void setR_use_yn(String r_use_yn) {
		this.r_use_yn = r_use_yn;
	}

	public String getR_regist_date() {
		return r_regist_date;
	}

	public void setR_regist_date(String r_regist_date) {
		this.r_regist_date = r_regist_date;
	}

	
	public List<String> getR_date_recur_list() {
		return r_date_recur_list;
	}

	public void setR_date_recur_list(List<String> r_date_recur_list) {
		this.r_date_recur_list = r_date_recur_list;
	}

	@Override
	public String toString() {
		return "ReserveRoomVO [r_no=" + r_no + ", r_user_name=" + r_user_name + ", r_user_password=" + r_user_password
				+ ", r_room_no=" + r_room_no + ", r_start_time=" + r_start_time
				+ ", r_end_time=" + r_end_time + ", r_use_yn=" + r_use_yn + ", r_regist_date=" + r_regist_date
				+ ", r_date_recur_list=" + r_date_recur_list + "]";
	}


	
}
