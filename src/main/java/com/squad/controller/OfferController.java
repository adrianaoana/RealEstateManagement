package com.squad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.squad.model.Offer;

@Controller
public class OfferController extends MainController {

	@RequestMapping(value = "/offers", method = RequestMethod.GET)
	public ModelAndView defaultList(@RequestParam(value = ORDER, required = false) String order,
			@RequestParam(value = SEARCH, required = false) String search,
			@RequestParam(value = TYPE, required = false) String type,
			@RequestParam(value = PROPERTY_TYPE, required = false) String propertyType,
			@RequestParam(value = BEGIN_PRICE, required = false) String beginPrice,
			@RequestParam(value = LIMIT_PRICE, required = false) String limitPrice, HttpServletRequest request) {
		return list(1, order, search, type, propertyType, beginPrice, limitPrice, request);
	}

	@RequestMapping(value = "/offers/{page}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable Integer page, @RequestParam(value = ORDER, required = false) String order,
			@RequestParam(value = SEARCH, required = false) String search,
			@RequestParam(value = TYPE, required = false) String type,
			@RequestParam(value = PROPERTY_TYPE, required = false) String propertyType,
			@RequestParam(value = BEGIN_PRICE, required = false) String beginPrice,
			@RequestParam(value = LIMIT_PRICE, required = false) String limitPrice, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(OFFERS_JSP);
		createMenu(request, modelAndView);
		order = getOrder(order, request);
		search = getSearch(search, request);
		if (type == null && propertyType == null && beginPrice == null && limitPrice == null) {
			request.getSession().setAttribute(TYPE, type);
			request.getSession().setAttribute(PROPERTY_TYPE, propertyType);
			request.getSession().setAttribute(BEGIN_PRICE, beginPrice);
			request.getSession().setAttribute(LIMIT_PRICE, limitPrice);
		} else {
			if (type == null) {
				if (request.getSession().getAttribute(TYPE) != null) {
					type = request.getSession().getAttribute(TYPE).toString();
				}
			}
			request.getSession().setAttribute(TYPE, type);
			if (propertyType == null) {
				if (request.getSession().getAttribute(PROPERTY_TYPE) != null) {
					propertyType = request.getSession().getAttribute(PROPERTY_TYPE).toString();
				}
			}
			request.getSession().setAttribute(PROPERTY_TYPE, propertyType);
			if (beginPrice == null) {
				if (request.getSession().getAttribute(BEGIN_PRICE) != null) {
					beginPrice = request.getSession().getAttribute(BEGIN_PRICE).toString();
				}
			}
			request.getSession().setAttribute(BEGIN_PRICE, beginPrice);
			if (limitPrice == null) {
				if (request.getSession().getAttribute(LIMIT_PRICE) != null) {
					limitPrice = request.getSession().getAttribute(LIMIT_PRICE).toString();
				}
			}
			request.getSession().setAttribute(LIMIT_PRICE, limitPrice);
		}
		Integer recordsPerPage = DEFAULT_NR_OF_RECORDS;
		Long nrOfRecords = offerService.getByPageFilterBySearchSize(type, propertyType, beginPrice, limitPrice, search);
		Integer nrOfPages = (int) Math.ceil(nrOfRecords * 1.0 / recordsPerPage);
		page = setPagination(modelAndView, page, nrOfPages);
		request.getSession(false).setAttribute(SELECT_NR_OF_RECORDS, recordsPerPage);
		modelAndView.addObject(ORDER, order);
		modelAndView.addObject(SEARCH, search);
		modelAndView.addObject(TYPE, type);
		modelAndView.addObject(PROPERTY_TYPE, propertyType);
		modelAndView.addObject(BEGIN_PRICE, beginPrice);
		modelAndView.addObject(LIMIT_PRICE, limitPrice);
		modelAndView.addObject(OFFERS, offerService.getByPageFilterBySearch(type, propertyType, beginPrice, limitPrice,
				search, order, (page - 1) * recordsPerPage, recordsPerPage));
		return modelAndView;
	}

	@RequestMapping(value = "/add-offer", method = RequestMethod.GET)
	public ModelAndView add(@ModelAttribute Offer offer, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView(ADD_OFFER_JSP);
		createMenu(request, modelAndView);
		if (offer == null) {
			Offer newOffer = new Offer();
			/*
			 * TODO User user =
			 * userService.getByEmail(request.getUserPrincipal().getName());
			 * newOffer.setOwnerCountry(user.getCountry());
			 * newOffer.setOwnerDistrict(user.getDistrict());
			 * newOffer.setOwnerCity(user.getCity());
			 * newOffer.setOwnerNumber(user.getPhone());
			 */
			newOffer.setEmailUser(request.getUserPrincipal().getName());
			modelAndView.addObject(OFFER, newOffer);
		} else {
			modelAndView.addObject(OFFER, offer);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/add-offer", method = RequestMethod.POST)
	public ModelAndView doAdd(@ModelAttribute Offer offer,
			@RequestParam(value = "offerImage", required = false) MultipartFile image, HttpServletRequest request) {
		if (!image.isEmpty()) {
			try {
				validateImage(image);
			} catch (RuntimeException re) {
				return add(offer, request);
			}
		}
		if (!image.isEmpty()) {
			// new image
		}
		offerService.add(offer);
		return list(1, null, null, null, null, null, null, request);
	}

	public void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
			throw new RuntimeException("Only JPG images are accepted!");
		}
	}
}
