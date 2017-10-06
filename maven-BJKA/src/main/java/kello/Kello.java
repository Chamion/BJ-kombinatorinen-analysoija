package kello;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chamion
 */
public class Kello implements KelloRajapinta{
    @Override
    public long nanoTime(){
        return System.nanoTime();
    }
}
