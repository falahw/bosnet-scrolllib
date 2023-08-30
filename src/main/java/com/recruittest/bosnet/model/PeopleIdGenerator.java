package com.recruittest.bosnet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.boot.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class PeopleIdGenerator  implements IdentifierGenerator, org.hibernate.id.Configurable {

	/*
	public static final String GENERATOR_NAME = "peopleIdGenerator";
	public static final String PREFIX_PARAM = "prefix";
	
	private String prefix = "";
	
	@Override
	public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) throws MappingException {
		// TODO Auto-generated method stub
//		IdentifierGenerator.super.configure(type, parameters, serviceRegistry);
		this.prefix = parameters.getProperty(PREFIX_PARAM, "");
	}
	*/
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		/*
		String uuid = UUID.randomUUID().toString().substring(0, 8);
		
		return prefix + uuid;
		*/
		String prefix = "BDI";
		String query = "SELECT MAX(people_id) FROM bosnet_people";
		Connection conn = (Connection) session.getJdbcConnectionAccess();
		
		try(PreparedStatement stat = conn.prepareStatement(query)) {
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				String lastId = rs.getString(1);
				
				if (lastId != null) {
					int number = Integer.parseInt(lastId.substring(prefix.length())) + 1;
					
					return prefix + "-" + number;
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new HibernateException("Unable to generate ID", e);
		}
		
		return prefix + "-" + 100; //nilai awal sebelum ada record pada table
	}

}
