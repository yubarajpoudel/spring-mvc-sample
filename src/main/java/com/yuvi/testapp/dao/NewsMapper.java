package com.yuvi.testapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.yuvi.testapp.model.News;

public class NewsMapper implements RowMapper<News> {
	   public News mapRow(ResultSet rs, int rowNum) throws SQLException {
		      News news = new News();
		      news.setId(rs.getInt("id"));
		      news.setTitle(rs.getString(1));
		      news.setDescription(rs.getString(2));
		      return news;
		   }
		}