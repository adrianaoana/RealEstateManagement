package com.squad.dao;

import java.util.List;

import com.squad.model.Image;

public interface ImageDAO {

	void add(Image image);

	void update(Image image);

	void delete(Image image);

	List<Image> getAllByOfferId(int offerId);
}
