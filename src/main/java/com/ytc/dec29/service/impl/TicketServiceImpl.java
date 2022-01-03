/** 
 * <pre>项目名称:java2021-12-28-x 
 * 文件名称:TicketServiceImpl.java 
 * 包名:com.ytc.service.impl 
 * 创建日期:2021年12月28日下午2:05:46 
 * Copyright (c) 2021,  All Rights Reserved.</pre> 
 */  
package com.ytc.dec29.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytc.dec29.dto.CompanyDTO;
import com.ytc.dec29.dto.TicketDTO;
import com.ytc.dec29.mapper.CompanyMapper;
import com.ytc.dec29.mapper.TicketMapper;
import com.ytc.dec29.model.Page;
import com.ytc.dec29.model.Ticket;
import com.ytc.dec29.service.TicketService;

/** 
 * <pre>项目名称：java2021-12-28-x    
 * 类名称：TicketServiceImpl    
 * 类描述：    
 * 创建人：zyl   
 * 创建时间：2021年12月28日 下午2:05:46    
 * 修改人：zyl 
 * 修改时间：2021年12月28日 下午2:05:46    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketMapper ticketMapper;
	@Autowired
	private CompanyMapper companyMapper;
	
	/* (non-Javadoc)    
	 * @see com.ytc.service.TicketService#queryPageList()    
	 */
	@Override
	public Page getAll(Page page, TicketDTO ticketDTO) {
		//查询出数据库的总条数
		int totalRowNum = ticketMapper.getCount(ticketDTO);
		System.out.println(totalRowNum);
		//使用Page的有参的构造函数计算开始的位置
		page=new Page(page.getCurrentPage(), totalRowNum, page.getPageSize());
		//把计算出来的开始位置以及每页条数传递到sql中进行查询
		List<Ticket> list=ticketMapper.getAllTickets(page,ticketDTO);
		//把查询分页后的结果list放到page中
		page.setList(list);
		System.out.println("page:"+page.getStart());
		return page;
	}

	/* (non-Javadoc)    
	 * @see com.ytc.service.TicketService#add(com.ytc.model.Ticket)    
	 */
	@Override
	public void add(TicketDTO ticketDTO) {
		System.out.println(ticketDTO.getCompany().getId());
		if (ticketDTO.getCompany().getId().equals(-2)){
			companyMapper.add(ticketDTO.getCompany());
		}
	 	ticketMapper.add(ticketDTO);
	}

	/* (non-Javadoc)    
	 * @see com.ytc.service.TicketService#queryTicketById(java.lang.Integer)    
	 */
	@Override
	public Ticket getById(int Ticketid) {
		return TicketMapper.getById(Ticketid);
	}

	@Override
	public void update(TicketDTO TicketDTO) {
		// TODO Auto-generated method stub
		
	}

}
