/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.library.controlador;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jeide
 */
public class GestorLibrosTest {
    
    public GestorLibrosTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of AñadirLibro method, of class GestorLibros.
     */
    @Test
    public void testAñadirLibro() {
        System.out.println("A\u00f1adirLibro");
        GestorLibros instance = new GestorLibros();
        instance.AñadirLibro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EditarLibro method, of class GestorLibros.
     */
    @Test
    public void testEditarLibro() {
        System.out.println("EditarLibro");
        GestorLibros instance = new GestorLibros();
        instance.EditarLibro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EliminarLibro method, of class GestorLibros.
     */
    @Test
    public void testEliminarLibro() {
        System.out.println("EliminarLibro");
        GestorLibros instance = new GestorLibros();
        instance.EliminarLibro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConsultarDisponibilidad method, of class GestorLibros.
     */
    @Test
    public void testConsultarDisponibilidad() {
        System.out.println("ConsultarDisponibilidad");
        GestorLibros instance = new GestorLibros();
        instance.ConsultarDisponibilidad();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
