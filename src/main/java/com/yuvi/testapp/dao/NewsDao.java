package com.yuvi.testapp.dao;
import java.util.List;
import javax.sql.DataSource;

import com.yuvi.testapp.model.News;

public interface NewsDao {
	
  public List<News> listNews(); 
  public void addNews(News news);
}
