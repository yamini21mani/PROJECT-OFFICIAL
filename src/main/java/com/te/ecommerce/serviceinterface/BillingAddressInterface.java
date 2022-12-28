package com.te.ecommerce.serviceinterface;

import com.te.ecommerce.dto.AddressDto;
import com.te.ecommerce.entity.BillingAddress;

public interface BillingAddressInterface {
	public boolean addBillingAddress(AddressDto addressDto);
	public BillingAddress getBillingAddress(AddressDto addressDto);
	public BillingAddress updateBillingAddress(AddressDto addressDto);
	public void deleteBillingAddress(AddressDto addressDto);
}
