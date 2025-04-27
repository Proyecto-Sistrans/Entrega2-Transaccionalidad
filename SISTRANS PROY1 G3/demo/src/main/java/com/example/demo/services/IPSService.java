package com.example.demo.services;

import java.util.List;

import com.example.demo.modelo.IPS;

public interface IPSService {
    List<IPS> findAll();
    IPS findById(String nit);
    IPS save(IPS ips);
    void deleteById(String nit);
    List<IPS> listAll();
    IPS update(IPS i);
    IPS create(IPS i);
}