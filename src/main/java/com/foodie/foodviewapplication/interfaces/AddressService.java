/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.foodie.foodviewapplication.interfaces;

import com.foodie.foodviewapplication.modelo.Address;

/**
 *
 * @author juan ortega
 */
public interface AddressService {
    public boolean createAddress(Address address);
    public Address getAddressById(int idAddress);
    public boolean updateAddress(Address address);
    public boolean deleteAddress(int idAddress);
}
