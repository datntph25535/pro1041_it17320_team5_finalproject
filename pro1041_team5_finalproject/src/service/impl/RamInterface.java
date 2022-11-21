/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import model.Ram;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface RamInterface {
    
    ArrayList<Ram> getAll();
    
    void insert(Ram ram);
    
    void update(Ram ram, String ma);
    
    void delete(String ma);
    
}
