package com.squad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.squad.model.User;
import com.squad.service.UserService;
import com.squad.service.OfferService;

@Controller
public class MainController {

	@Autowired
	protected UserService userService;
	
	@Autowired
	protected OfferService offerService;

	public static final String ERROR_MESSAGE = "errorMessage";
	public static final String MESSAGE = "message";
	public static final String USER = "user";
	public static final String OFFERS = "offers";
	public static final String OFFER = "offer";
	public static final String OFFER_ID = "offerId";
	public static final String SELECT_NR_OF_RECORDS = "selectNrOfRecords";
	public static final String CURRENT_PAGE = "currentPage";
	public static final String PAGE = "page";
	public static final String NR_OF_PAGES = "nrOfPages";
	public static final String BEGIN = "begin";
	public static final String END = "end";
	public static final Integer DEFAULT_NR_OF_RECORDS = 20;
	public static final Integer FIRST_PAGE = 1;
	public static final String SEARCH = "sch";
	public static final String ORDER = "order";
	public static final String TYPE = "type";
	public static final String PROPERTY_TYPE = "ptype";

	/* PAGES */
	public static final String INDEX_JSP = "index";
	public static final String OFFERS_JSP = "offers";
	public static final String ADD_OFFER_JSP = "addOffer";

	public void createMenu(HttpServletRequest request, ModelAndView modelAndView) {
		if (request.getSession().getAttribute(USER) == null) {
			request.getSession().setAttribute(USER, new User());
		}
		modelAndView.addObject(USER, request.getSession().getAttribute(USER));
	}
	
	/**
	 * set the nr of the current page and values of pagination format Pagination
	 * format: show max 7 pages ex: (nrOfPages=9, currentPage=5) << Previous 2 3
	 * 4 5 6 7 8 Next >>
	 * 
	 * @param modelAndView
	 *            the model on which will be set the pagination
	 * @param page
	 *            the current page
	 * @param nrOfPages
	 *            the number of pages
	 * @return the current page
	 */
	public Integer setPagination(ModelAndView modelAndView, Integer page, Integer nrOfPages) {
		if ((page == null) || (page > nrOfPages) || (page < 1)) {
			page = FIRST_PAGE;
		}
		int begin = Math.max(1, page - 3);
		int end = Math.min(begin + 6, nrOfPages);
		modelAndView.addObject(BEGIN, begin);
		modelAndView.addObject(END, end);
		modelAndView.addObject(NR_OF_PAGES, nrOfPages);
		modelAndView.addObject(CURRENT_PAGE, page);
		return page;
	}

	public String getOrder(String order, HttpServletRequest request) {
		if (order == null) {
			if (request.getSession().getAttribute(ORDER) == null) {
				order = "0";
			} else {
				order = request.getSession().getAttribute(ORDER).toString();
			}
		}
		request.getSession().setAttribute(ORDER, order);
		return order;
	}

	public String getSearch(String search, HttpServletRequest request) {
		if (search == null) {
			if (request.getSession().getAttribute(SEARCH) != null) {
				search = request.getSession().getAttribute(SEARCH).toString();
			}

		}
		request.getSession().setAttribute(SEARCH, search);
		return search;
	}
}
