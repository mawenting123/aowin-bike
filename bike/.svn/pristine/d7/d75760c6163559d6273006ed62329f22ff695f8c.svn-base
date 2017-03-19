package com.aowin.controller.vender;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aowin.model.vender.Vender;
import com.aowin.service.vender.VenderService;

@Controller
public class VenderController {
	@Autowired
	private VenderService venderService;
	
	//新增供应商
	@RequestMapping("/addVender.do")
	public String addVender(Vender vender,Model model){
		try {
			venderService.addVender(vender);
			model.addAttribute("message", "新增成功");
			return "protect/vender.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("message", "新增失败");
			return "protect/add_vender.jsp";
		}
	}
	
	//查询供应商信息
	@RequestMapping("/queryVender.do")
	public String selVender(Vender vender,Model model){
		List<Vender> venders = venderService.queryVender(vender);
		model.addAttribute("venders", venders);
		return "protect/vender_query.jsp";
	}

	public VenderService getVenderService() {
		return venderService;
	}

	public void setVenderService(VenderService venderService) {
		this.venderService = venderService;
	}
	
}
