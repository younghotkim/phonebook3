package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PhoneVo;

@Controller
public class PhoneController {
	
	@Autowired
	private PhoneDao phoneDao;

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {

		System.out.println("[PhoneController.LIST]");

		List<PhoneVo> personList = phoneDao.getPersonList();

		System.out.println(personList);

		model.addAttribute("personList", personList);

		return "/WEB-INF/views/list.jsp";

	}

	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {

		System.out.println("[PhoneController.WRITEFORM]");

		return "/WEB-INF/views/writeForm.jsp";

	}

	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })

	public String write(@ModelAttribute PhoneVo phoneVo) {

		System.out.println("[PhoneController.WRITE]");

		System.out.println(phoneVo);

		phoneDao.personInsert(phoneVo);

		return "redirect:/list"; // 리턴에 쓰는것은 무적권 forward이다.

	}

	@RequestMapping(value = "/delete/", method = { RequestMethod.GET, RequestMethod.POST })

	public String delete(@RequestParam("personId") int personId) {

		System.out.println("[PhoneController.DELETE]");

		phoneDao.personDelete(personId);

		return "redirect:/list";

	}

	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })

	public String modifyForm(Model model, @RequestParam("personId") int personId) {

		System.out.println("[PhoneController.MODIFYFORM]");

		PhoneVo phoneVo = phoneDao.getPerson(personId);
		
		model.addAttribute(phoneVo);

		return "/WEB-INF/views/modifyForm.jsp";

	}

	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })

	public String modify(@ModelAttribute PhoneVo phoneVo) {

		System.out.println("[PhoneController.MODIFY]");

		phoneDao.personUpdate(phoneVo);

		return "redirect:/list";

	}

}
