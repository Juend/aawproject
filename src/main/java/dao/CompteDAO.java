/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Justine ENOND
 */
public interface CompteDAO  {
    public void save(CompteEntity c);
    public void update(CompteEntity c);
    public void delete(CompteEntity c);
    public CompteEntity  find(long id);
    public List<CompteEntity> findAll();
}
