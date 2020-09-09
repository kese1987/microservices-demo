package org.kese.listing_service.dao;

import org.kese.listing_service.dao.entities.Listing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingDAO extends CrudRepository<Listing, Long> {
}
