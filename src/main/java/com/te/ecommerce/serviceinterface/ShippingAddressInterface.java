package com.te.ecommerce.serviceinterface;

import com.te.ecommerce.dto.AddressDto;
import com.te.ecommerce.entity.ShippingAddress;

public interface ShippingAddressInterface {
	public boolean addShippingAddress(AddressDto addressDto);
	public ShippingAddress getShippingAddress(AddressDto addressDto);
	public ShippingAddress updateShippingAddress(AddressDto addressDto);
	public void deleteShippingAddress(AddressDto addressDto);
}
