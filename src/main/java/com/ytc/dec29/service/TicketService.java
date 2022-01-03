/** 
 * <pre>项目名称:java2021-12-28-x 
 * 文件名称:TicketService.java 
 * 包名:com.ytc.service 
 * 创建日期:2021年12月28日下午2:05:16 
 * Copyright (c) 2021,  All Rights Reserved.</pre> 
 */  
package com.ytc.dec29.service;


import com.ytc.dec29.model.*;
import com.ytc.dec29.dto.TicketDTO;

public interface TicketService {

	Page getAll(Page page, TicketDTO ticketDTO);
	void add(TicketDTO TicketDTO);
	void update(TicketDTO TicketDTO);
	Ticket getById(int id);
}
