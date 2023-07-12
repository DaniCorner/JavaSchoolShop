package com.javaschoolshop.service;

import com.javaschoolshop.dao.AddressRepository;
import com.javaschoolshop.dto.AddressCountDTO;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressCountDTO> getCountriesWithMostOccurrences() {
        List<Object[]> result = addressRepository.findCountriesWithMostOccurrences();
        return convertToObjectList(result);
    }

    private List<AddressCountDTO> convertToObjectList(List<Object[]> result) {
        List<AddressCountDTO> addressCountDTOs = new ArrayList<>();
        for (Object[] row : result) {
            String country = (String) row[0];
            Long countryCount = (Long) row[1];
            AddressCountDTO addressCountDTO = new AddressCountDTO(country, countryCount);
            addressCountDTOs.add(addressCountDTO);
        }
        return addressCountDTOs;
    }
}