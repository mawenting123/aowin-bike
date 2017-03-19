package com.aowin.service.vender;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aowin.dao.vender.IVenderDao;
import com.aowin.model.vender.Vender;
@Service
public class VenderService {
	@Autowired
	private IVenderDao venderDao;
	
	
	//新增供应商
	public int addVender(Vender vender) throws Exception{
		return venderDao.addVender(vender);
		
	}
	
	//根据条件查询供应商信息
	public List<Vender> queryVender(Vender vender){
		List<Vender> venders = venderDao.queryVender(vender);
		return venders;
	}

	public IVenderDao getVenderDao() {
		return venderDao;
	}

	public void setVenderDao(IVenderDao venderDao) {
		this.venderDao = venderDao;
	}
	
	
}
