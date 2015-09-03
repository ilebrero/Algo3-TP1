/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.utils;

/**
 *
 * @author nachoo
 */
public class ContenedorCaminos{
        public int   longitud;
        public Integer[] caminos;
        
        public ContenedorCaminos(int longitud, Integer[] ciudades){
            this.longitud = longitud;
            this.caminos = ciudades;
        }
    }