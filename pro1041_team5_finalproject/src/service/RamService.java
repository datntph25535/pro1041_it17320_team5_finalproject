/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Ram;
import repository.RamRepository;
import service.impl.RamInterface;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class RamService implements RamInterface{
    
    RamRepository repo = new RamRepository();

    @Override
    public ArrayList<Ram> getAll() {
        return repo.getAll();
    }

    @Override
    public void insert(Ram ram) {
        repo.insert(ram);
    }

    @Override
    public void update(Ram ram, String ma) {
        repo.update(ram, ma);
    }

    @Override
    public void delete(String ma) {
        repo.delete(ma);
    }
    
    
    
}
