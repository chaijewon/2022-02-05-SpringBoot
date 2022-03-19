package com.it.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.it.web.LocationDAO;

@Configuration
@ComponentScan(basePackages = {"com.it.*"})
public class LocationConfig {
  /*
   * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
      p:driverClassName="com.mysql.cj.jdbc.Driver"
      p:url="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC"
      p:username="root"
      p:password="1111"
    />
   */
	@Bean("ds")
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("1111");
		return ds;
	}
	/*
	 *  <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
	      p:dataSource-ref="ds"
	    />
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	/*
	 * <bean id="mapper" class="org.mybatis.spring.mapper.MapperFactoryBean"
	      p:sqlSessionFactory-ref="ssf"
	      p:mapperInterface="com.it.web.LocationMapper"
	    />
	 */
	@Bean("mapper")
	public MapperFactoryBean mapperFactoryBean() throws Exception
	{
		MapperFactoryBean mapper=new MapperFactoryBean();
		mapper.setSqlSessionFactory(sqlSessionFactory());
		mapper.setMapperInterface(com.it.web.LocationMapper.class);
		return mapper;
		
	}
	/*
	 * <bean id="dao" class="com.it.web.LocationDAO"
	      p:mapper-ref="mapper"
	    />
	 */
	/*
	 * @Bean("dao") public LocationDAO locationDAO() { LocationDAO dao=new
	 * LocationDAO(); dao.setMapper(mapperFactoryBean()); return dao; }
	 */
}
