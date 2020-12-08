package com.ashokit.ies.ar.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ApplicationGenerator implements IdentifierGenerator {
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = "AR";
		String suffix = null;
		try {
			Connection con = session.connection();
			Statement state = con.createStatement();
			String sql = "select AR_ID_SEQ.nextval from dual ";

			ResultSet rs = state.executeQuery(sql);
			if (rs.next()) {
				int seqval = rs.getInt(1);
				suffix = String.valueOf(seqval);
				
			}

		} catch (Exception e) {

		}
		return   prefix + suffix;
	}
}
