package com.mh.org5;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	/*
	 * mybatis 설정
	 * 
	 * pom.xml 6가지 jar 가져오는거
	 * maven 
	 * 1. mybatis , 2. mybatis-spring, 3.spring-jdbc, 4.dbcp, 5.mysql-conner, 6.cglib
	 * 
	 * 2.servlet-context.xml
	 * 3가지 bean 객체 설정
	 * 1. dbcp(mysql커넥션설정정보)
	 * 2.sqlsessionfactory(xml파일을 읽어서 sql 설정) 
	 * 3.sqlsseion (sql구문실행)
	 * 
	 * controller requestmappeing
	 * memberlist	-> resultType 반환되는거
	 * memberinsert -> parameterType 매개변수 설정하는 방식
	 * 
	 * MemberController -> MemberService -> MemberDao -> MemberDto -> member.xml 
	 */
	@Autowired
	SqlSession sqlsession;
	
	@RequestMapping(value="memberlist")
	public String memberlist() {
		List<MemberDto> list = sqlsession.selectList("member.select");
		for(MemberDto dto : list) {
			System.out.println("dto = "+ dto);
		}
		/*
		 * for i in range(4):
		 * 	print(i)
		 */
		return "member/list";
	}
	
	@RequestMapping(value="memberinsert")
	public String memberinsert() {
		sqlsession.insert("member.insert");
		return "member/insert";
	}
}
