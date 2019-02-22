package com.biz.ajax01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ajax01.model.DeptVO;
import com.biz.ajax01.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DeptController {

	@Autowired
	DeptService dService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeCon() {
		return "home";
	}

	@RequestMapping(value = "dept", method = RequestMethod.GET)
	public String getDeptList(Model model) {

		List<DeptVO> dList = dService.getDeptList();

		model.addAttribute("DEPTLIST", dList);

//		int intSize = dList.size();
//
//		for (DeptVO vo : dList) {
//			log.debug(vo.toString());
//		}

		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "dept", method = RequestMethod.POST, produces="text/plan;charset=utf8")
	public String get_dept(@RequestParam String d_code) {

		DeptVO deptVO = dService.getDept(d_code);

		return deptVO.toString();
	}

	/*
	 * Ajax로 호출된 결과를 return 할 때 문자열로 return을 하려면 @ResponseBody를 설정 해 주면 된다.
	 * 
	 * 그런데
	 * Ajax로 호출된 결과를 다른 용도로 사용하려면 JSON형태로 return을 해 주는 것이 좋다.
	 * 
	 * 하지만 JAVA(spring)에서는 기본적으로 JSON 데이터 형태를 지원하지 않는다.
	 *
	 * spring에는 JSON을 쉽게 사용할 수 있는 통로가 마련되어 있고, 한가지의 3rd party library만 설정 해 주면 된다. 
	 */
	@ResponseBody
	@RequestMapping(value = "dept.JSON", method = RequestMethod.POST, produces="application/json;charset=utf8")
	public DeptVO get_dept_json(@RequestParam String d_code) {

		DeptVO deptVO = dService.getDept(d_code);

		return deptVO;
	}

}
