package com.te.ecommerce.serviceimplementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ecommerce.dto.AddressDto;
import com.te.ecommerce.entity.ShippingAddress;
import com.te.ecommerce.exceptionhandling.GeneralException;
import com.te.ecommerce.repository.ShippingAddressRepository;
import com.te.ecommerce.serviceinterface.ShippingAddressInterface;

@Service
public class ShippingAddressServImp implements ShippingAddressInterface {
//	@Autowired
//	private Customer customer;
//	@Autowired
//	private SalesOrder salesOrder;
	@Autowired
	private ShippingAddress shippingAddress;
	@Autowired
	private ShippingAddressRepository shippingAddressRepository;
	
	@Override
	public boolean addShippingAddress(AddressDto addressDto) {
		BeanUtils.copyProperties(addressDto, shippingAddress);
		ShippingAddress save = shippingAddressRepository.save(shippingAddress);
		if (save != null)
			return true;
		else
			throw new GeneralException("unable to add Address Please check");
	}

	@Override
	public ShippingAddress getShippingAddress(AddressDto addressDto) {
		BeanUtils.copyProperties(addressDto, shippingAddress);
		ShippingAddress getAddress = shippingAddressRepository.findById(shippingAddress.getId())
				.orElseThrow(() -> new GeneralException("No data found please check the id"));
		return getAddress;
	}

	@Override
	public ShippingAddress updateShippingAddress(AddressDto addressDto) {
		BeanUtils.copyProperties(addressDto, shippingAddress);
		ShippingAddress founddata = shippingAddressRepository.findById(shippingAddress.getId())
				.orElseThrow(() -> new GeneralException("No data found please check the ID"));
		founddata.setAddress(addressDto.getAddress());
		founddata.setCity(addressDto.getCity());
		founddata.setCountry(addressDto.getCountry());
//		founddata.setCustomer(customer);
//		founddata.setSalesOrder(salesOrder);
		founddata.setState(addressDto.getState());
		founddata.setZipcode(addressDto.getZipcode());
		ShippingAddress save = shippingAddressRepository.save(founddata);
		return save;
	}

	@Override
	public void deleteShippingAddress(AddressDto addressDto) {
		BeanUtils.copyProperties(addressDto, shippingAddress);
		ShippingAddress founddata = shippingAddressRepository.findById(shippingAddress.getId()).orElseThrow(()-> new GeneralException("No data found please check the ID"));
		shippingAddressRepository.delete(founddata);
	}
}
