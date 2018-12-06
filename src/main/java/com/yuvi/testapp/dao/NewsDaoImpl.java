package com.yuvi.testapp.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yuvi.testapp.model.News;

import utils.DB;

@Repository
public class NewsDaoImpl implements NewsDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
//	@Autowired
//	private DataSource dataSource;
//	
	Connection con = null;
	
	public NewsDaoImpl() {
		 
		con = DB.getDbcon();
	}
	
	
	@Override
	public List<News> listNews() {
		
		//System.out.println("======="+dataSource);
		List<News>  newsList = new ArrayList<News>();
		
		String SQL = "select * from news";
//		JdbcTemplate template = new JdbcTemplate(dataSource);
//		List<News> newsList = template.query(SQL, new RowMapper())
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(SQL);
			
			while(rs.next()) {
				
				News n = new News();
				n.setId(rs.getInt("id"));
				n.setTitle(rs.getString("title"));
				//n.setDescription(rs.getString("image"));
				
				newsList.add(n);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//List<News> newsList = template.query(SQL,  new NewsMapper());
		return newsList;
	}
	
	@Override
	public void addNews(News news) {
		String SQL = "INSERT INTO news(title, description) VALUES(:title, :description)";
	}
}
