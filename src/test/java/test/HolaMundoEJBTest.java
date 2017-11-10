/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import beans.HolaMundoEJB;

/**
 *
 * @author jpm1590
 */
public class HolaMundoEJBTest {
    
    private static EJBContainer contenedor;
    private static Context contexto;
    private static HolaMundoEJB ejb;
    
    @Before
    public void iniciarContenedor() throws Exception {
        System.out.println("INICIANDO EJB CONTAINER");
        contenedor = EJBContainer.createEJBContainer();
        contexto = contenedor.getContext();
        ejb = (HolaMundoEJB) contexto.lookup("java:global/classes/HolaMundoEJB!beans.HolaMundoEJB");
    }
    
    @Test
    public void testNumbers() throws Exception {
        int date1 = 3;
        int date2 = 4;
        int resSum = ejb.sumar(date1, date2);
        int resRest = ejb.restar(date1, date2);
        assertEquals(resSum, (date1 + date2));
        assertEquals(resRest, date1 -date2);
        System.out.println("El resultado de la suma es " + resSum);
        System.out.println("El resultado de la resta es " + resRest);
        
    }
    
}
