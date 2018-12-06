package com.yuvi.testapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yuvi.testapp.dao.NewsDao;
import com.yuvi.testapp.dao.NewsDaoImpl;
import com.yuvi.testapp.model.News;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	private NewsDao newsService = new NewsDaoImpl();
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String listNews(Model model) {
		 
//		ModelAndView modelView = new ModelAndView("news/news_page");
		//List<News> newsList = newsService.listNews();
//		for(News news : newsList) {
//			System.out.println(news.getTitle());
//		}
		model.addAttribute("newsList", newsService.listNews());
		
		return "newsList";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addNews(Model model) {
		ModelAndView modelView = new ModelAndView("news/news_form");
		News news = new News();
		modelView.addObject("newsForm", news);
		return modelView;
	}
	
	
}
