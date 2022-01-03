package com.ytc.dec29.mapper;

import java.util.List;

import com.ytc.dec29.model.*;
import com.ytc.dec29.dto.*;
import com.ytc.dec29.model.Page;

import org.apache.ibatis.annotations.*;


public interface TicketMapper {

	public static final String whereClause = "<where> 1=1 "+
	"<if test='ticketDTO.id != \"\" and ticketDTO.id != null' > and t_id = #{id}</if>"+
	"<if test='ticketDTO.companyId != -1 and ticketDTO.companyId != \"\" and ticketDTO.companyId != null' > and company_id = #{ticketDTO.companyId}</if>"+
	"<if test='ticketDTO.startCity != \"\" and ticketDTO.startCity!= null' > and t_start_city like \'%${ticketDTO.startCity}%\'</if>"+
	"<if test='ticketDTO.endCity != \"\" and ticketDTO.endCity!= null' > and t_end_city = #{endCity}</if>"+
	"<if test='ticketDTO.berth != \"\" and ticketDTO.berth!= null' > and t_berth = #{berth}</if>"+
	"<if test='ticketDTO.startDateLeft != \"\" and ticketDTO.startDateLeft!= null and ticketDTO.startDateRight != \"\" and ticketDTO.startDateRight!= null' > and t_start_date between \'${startDateLeft}\' and ticketDTO.\'${startDateRight}\'</if>"+
	"</where>";

	@Select("<script>" +
	"select count(*) from ytc_ticket_info" +
	whereClause +
	"</script>")
	int getCount(@Param("ticketDTO") TicketDTO ticketDTO);

    @Select(
	"<script>"+
	"select * from ytc_ticket_info"+ 
	whereClause + 
	"order by t_start_date desc "+
	"limit #{page.start}, #{page.pageSize}"+
	"</script>"
	)
	@Results(id = "ticketResultMap", value = {
		@Result(property = "id",  column = "t_id"),
		@Result(property = "startCity",  column = "t_start_city"),
		@Result(property = "endCity",  column = "t_end_city"),
		@Result(property = "berth",  column = "t_berth"),
		@Result(property = "startDate",  column = "t_start_date"),
		@Result(property = "company",  column = "company_id", one=@One(select = "getCompanyForTicket")),
	})
	List<Ticket> getAllTickets(Page page,TicketDTO ticketDTO);

	@Select("select * from ytc_company_info where c_id = #{company_id}")
	@Results(id = "companyResultMap", value = {
		@Result(property = "id",  column = "c_id"),
		@Result(property = "name",  column = "c_name"),
		@Result(property = "password",  column = "c_password")
	})
	Company getCompanyForTicket(@Param("company_id") Integer company_id);

	@Update("<script>"+
	"update table t_stuinfo set"+
	"<if test='ticketDTO.startCity != \"\" and ticketDTO.startCity!= null' > and t_start_city = #{ticketDTO.startCity}</if>"+
	"<if test='ticketDTO.endCity != \"\" and ticketDTO.endCity!= null' > and t_end_city = #{endCity}</if>"+
	"<if test='ticketDTO.berth != \"\" and ticketDTO.berth!= null' > and t_berth = #{berth}</if>"+
	"<if test='ticketDTO.startDate != \"\" and ticketDTO.startDate!= null' > and t_start_date = #{startDateLeft}</if>"+
	"</script>"
	)
	void update(TicketDTO ticketDTO);

	@Insert(
		"insert into ytc_ticket_info "+
		"(t_start_city,t_end_city,t_berth,t_start_date,company_id) values (#{startCity},#{endCity},#{berth},\'${startDate}\',#{company.id});"
	)
	void add(TicketDTO ticketDTO);

    static Ticket getById(Integer ticketid) {
        return null;
    }
}