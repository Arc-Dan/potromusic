/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.potroMusic.ui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mx.itson.potroMusic.entidades.Album;
import mx.itson.potroMusic.entidades.Artista;
import mx.itson.potroMusic.entidades.Cancion;
import mx.itson.potroMusic.enums.Genero;
import java.util.Scanner;

/**
 *
 * @author dag13
 */
public class Main
{
    
    public static void main(String[] args)
    {
        try
        {
            //Se crea nueva instancia de la clase Scanner
            Scanner scanner = new Scanner(System.in);

            //Se crean instancias de la clases "Artista" y "Album"
            Artista artista = new Artista();
            Album a = new Album();
            
            //Se imprimen instrucciones a usuario y se asignan valores a los atributos de la clase "Artista"
            System.out.print("\n------- // Artista // -------\n\nIngrese el nombre de un cantante.\nNombre de cantante: ");
            String nombreArtista = scanner.nextLine();
            artista.setNombre(nombreArtista);
            
            System.out.print("-------------------------------\n\n------- // Descripcion y Direccion // -------\n\nIngrese una pequeña descripción del artista: " + artista.getNombre() + "\nDescripción: ");
            String descripcionArtista = scanner.nextLine();
            artista.setDescripcion(descripcionArtista);
            
            System.out.print("\nIngrese la dirección a la página web de " + artista.getNombre() + "\nPágina web: ");
            String sitioWebArtista = scanner.nextLine();
            artista.setSitioWeb(sitioWebArtista);
            
            //Se imprimen instrucciones a usuario y se asignan valores a los atributos de la clase "Album"
            System.out.print("----------------------------------\n\n------- // Album // -------\nIngrese el nombre de un álbum de " + artista.getNombre() + "\nNombre del álbum: ");
            String nombreAlbum = scanner.nextLine();
            a.setNombre(nombreAlbum);
            a.setArtista(artista);
            
            System.out.print("-------------------------------\n\n------- // Genero // -------\nElija el género musical del álbum \"" + a.getNombre() + "\".\n1.- Pop\n2.- Rock\n3.- Dance\n4.- Salsa\n5.- Otro\nOpción: ");
            String generoAlbum = scanner.nextLine();
            switch(generoAlbum)
            {
                case "1": a.setGenero(Genero.POP);
                case "2": a.setGenero(Genero.ROCK);
                case "3": a.setGenero(Genero.DANCE);
                case "4": a.setGenero(Genero.SALSA);
                default: a.setGenero(Genero.OTRO);
            }
            
            System.out.print("-------------------------------\n\n------- // Lanzamiento // -------\nIngrese el año de lanzamiento del álbum \"" + a.getNombre() + "\".\nAño de lanzamiento: ");
            int lanzamientoAlbum = scanner.nextInt();
            a.setLanzamiento(lanzamientoAlbum);
            
            List<Cancion> canciones = new ArrayList<>();
            a.setCancion(canciones);
            int contador = 1;
            
            
            while(true)
            {
                System.out.print("\nDeseas agregar la canción " + contador + "?\n1.- Sí\n2.- No\nOpción: ");
                int opcion = scanner.nextInt();
                
                if(opcion == 1)
                {
                    System.out.print("\nIngrese el nombre de la canción " + contador + ".\nCanción " + contador + ": ");
                    String cancionInput = scanner.nextLine();
                    scanner.nextLine();
                    
                    Cancion cancion = new Cancion();
                    canciones.add(cancion);
                    cancion.setNombre(cancionInput);
                    contador += 1;
                }
                else{ break; }
            }
            
            if(canciones.isEmpty())
            {
                System.out.println("\nArtista: " + a.getArtista().getNombre() + "\nÁlbum: " + a.getNombre() + "\nAño: " + a.getLanzamiento() + "Género: " + a.getGenero());
            }
            else
            {
                System.out.println("\nArtista: " + a.getArtista().getNombre() + "\nÁlbum: " + a.getNombre() + "\nAño: " + a.getLanzamiento() + "\nGénero: " + a.getGenero()
                + "\nCanciones:");
                int i = 1;
                for(Cancion c : canciones)
                {
                    //Sólo imprime la dirección de la memoria en la clase, no como un String
                    System.out.println(i + ".- " + String.valueOf(c));
                    i += 1;
                }
            }
            
        } catch(Exception e){ System.err.println("Tipo de dato inválido. Por favor, ingrese el tipo de dato correcto!"); }
    }
}
