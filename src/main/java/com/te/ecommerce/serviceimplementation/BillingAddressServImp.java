package com.te.ecommerce.serviceimplementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ecommerce.dto.AddressDto;
import com.te.ecommerce.entity.BillingAddress;
import com.te.ecommerce.exceptionhandling.GeneralException;
import com.te.ecommerce.repository.BillingAddressRepository;
import com.te.ecommerce.serviceinterface.BillingAddressInterface;
@Service
public class BillingAddressServImp implements BillingAddressInterface {
	@Autowired
	private BillingAddressRepository billingAddressRepository;
	@Autowired
	private BillingAddress billingAddress;
//	@Autowired
//	private Customer customer;
//	@Autowired
//	private SalesOrder salesOrder;
	@Override
	public boolean addBillingAddress(AddressDto addressDto) {
		BeanUtils.copyProperties(addressDto, billingAddress);
		BillingAddress save = billingAddressRepository.save(billingAddress);
		if (save != null)
			return true;
		else
			throw new GeneralException("unable to add Address Please check");
	}

	@Override
	public BillingAddress getBillingAddress(AddressDto addressDto) {
		BeanUtils.copyProperties(addressDto, billingAddress);
		BillingAddress getAddress = billingAddressRepository.findById(billingAddress.getId())
				.orElseThrow(() -> new GeneralException("No data found please check the id"));
		return getAddress;
	}

	@Override
	public BillingAddress updateBillingAddress(AddressDto addressDto) {
		BeanUtils.copyProperties(addressDto, billingAddress);
		BillingAddress founddata = billingAddressRepository.findById(billingAddress.getId())
				.orElseThrow(() -> new GeneralException("No data found please check the ID"));
		founddata.setAddress(addressDto.getAddress());
		founddata.setCity(addressDto.getCity());
		founddata.setCountry(addressDto.getCountry());
//		founddata.setCustomer(customer);
//		founddata.setSalesOrder(salesOrder);
		founddata.setState(addressDto.getState());
		founddata.setZipcode(addressDto.getZipcode());
		BillingAddress save = billingAddressRepository.save(founddata);
		return save;

	}

	public void deleteBillingAddress(AddressDto addressDto) {
		BeanUtils.copyProperties(addressDto, billingAddress);
		BillingAddress founddata = billingAddressRepository.findById(billingAddress.getId()).orElseThrow(()-> new GeneralException("No data found please check the ID"));
		billingAddressRepository.delete(founddata);
	}

}
