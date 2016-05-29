package com.squad.controller;

import com.squad.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

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

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ModelAndView getDetails(@PathVariable Integer id, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(DETAIL_JSP);
        createMenu(request, modelAndView);
        Offer offer = offerService.getOfferById(id);
        modelAndView.addObject(OFFER, offer);
        return modelAndView;
    }


    @RequestMapping(value = "/add-offer", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request) {
        System.out.print("aaaa");
        ModelAndView modelAndView = new ModelAndView(ADD_OFFER_JSP);
        createMenu(request, modelAndView);
        MyObject myObject = new MyObject();
        modelAndView.addObject("myObject", myObject);
        return modelAndView;

    }

    @RequestMapping(value = "/add-offer", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("myObject") MyObject myObject, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(ADD_OFFER_JSP);
        createMenu(request, modelAndView);
        Blob blob = null;
        try {
            blob = new SerialBlob(myObject.getImage().getBytes());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address address = new Address();
        address.setArea(myObject.getArea());
        address.setCity(myObject.getCity());
        address.setCountry(myObject.getCountry());
        address.setDistrict(myObject.getDistrict());
        address.setStreet(myObject.getStreet());
        address.setStreetNo(myObject.getStreetNo());

        addressService.add(address);

        Feature feature = new Feature();
        feature.setBalconyNo(myObject.getBalconyNo());
        feature.setComfort(myObject.getConfort());
        feature.setDivision(myObject.getDivision());
        feature.setFloor(myObject.getFloor());
        feature.setKitchenNo(myObject.getKitchenNo());
        feature.setParkingPlaces(myObject.getParkingPlaces());
        feature.setPropertyType(myObject.getPropertyType());
        feature.setRoomNo(myObject.getRoomNo());
        feature.setUsableSurface(myObject.getUsableSurface());

        featureService.add(feature);

        Offer offer = new Offer();
        offer.setType(myObject.getType());
        offer.setPrice(myObject.getPrice());
        offer.setAddress(address);
        offer.setFeature(feature);
        offer.setDetails(myObject.getDetail());

        offerService.add(offer);

        Image image = new Image();
        image.setImage(blob);
        image.setOffer(offer);

        imageService.add(image);

        modelAndView.addObject(OFFER, myObject);
        return modelAndView;
    }

//	@RequestMapping(value = "/add-offer", method = RequestMethod.POST)
//	public ModelAndView doAdd(@ModelAttribute Offer offer,
//			@RequestParam(value = "offerImage", required = false) MultipartFile image, HttpServletRequest request) {
//		if (!image.isEmpty()) {
//			try {
//				validateImage(image);
//			} catch (RuntimeException re) {
//				return add(offer, request);
//			}
//		}
//		if (!image.isEmpty()) {
//			// new image
//		}
//		offerService.add(offer);
//		return list(1, null, null, null, null, null, null, request);
//	}

    public void validateImage(MultipartFile image) {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new RuntimeException("Only JPG images are accepted!");
        }
    }
}
