package org.kese.listing_service;

import javax.inject.Inject;

import org.kese.listing_service.dao.ListingDAO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListingController {

	private ListingDAO listingRepo;

	@Inject
	public ListingController(ListingDAO listingRepo) {
		this.listingRepo = listingRepo;
	}

	@PostMapping(name = "add")
	public void addListing() {

	}
}
