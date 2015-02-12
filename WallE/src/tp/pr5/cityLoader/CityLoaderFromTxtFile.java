/**
 * Clase encargada de leer un mapa de un archivo .txt y crea una City por donde se moverá el robot.
 * El archivo será correcto siempre y cuando tenga los Items, los Place y las Street numeradas por orden,
 * no se intente meter un objeto en un Place que no existam y siga la estructura del archivo.
 * En caso de que la estructura no sea la correcta o se produzca algun error, lanzará una
 * WrongCityFormatException.
 * La estructura del archivo es una serie de BeginX (Siendo X primero la City, despues los Place,
 * las Street y los Item) uno dentro de otro y acabados por un EndX.
 */

package tp.pr5.cityLoader;

import java.util.ArrayList;
import java.util.Scanner;

import tp.pr5.City;
import tp.pr5.Direction;
import tp.pr5.Place;
import tp.pr5.Street;
import tp.pr5.cityLoader.cityLoaderExceptions.WrongCityFormatException;
import tp.pr5.items.CodeCard;
import tp.pr5.items.Fuel;
import tp.pr5.items.Garbage;

/**
 * @authors Jaime Delgado Linares y Juan Samper González
 *
 */

public class CityLoaderFromTxtFile {
	private ArrayList<Place> places = new ArrayList<Place>();
	private ArrayList<Street> streets = new ArrayList<Street>();
	private String linea="";
	private int i=0;
	
	/**
	 * Constructora vacía. Crea una ciudad vacia
	 */
	public CityLoaderFromTxtFile(){
	}
	
	/**
	 * Es el método principal que se encaga de parsear el archivo. Su ejecución se divide
	 * en método que van parseando cada X (Siendo X primero la City, despues los Place,
	 * las Street y los Item)
	 * @param file - InputStream donde se va a guardar el archivo
	 * @return una City con los datos del archivo
	 * @throws WrongCityFormatException si el archivo esta mal (Ver documentación de la clase)
	 * @throws java.io.IOException Si hay cualquier otro error en el archivo
	 */
	@SuppressWarnings("resource")
	public City loadCity(java.io.InputStream file) throws java.io.IOException{
		Scanner f = new Scanner(file);
		if(f.hasNext()){
			primerIf(f);			
		}else{
			throw new WrongCityFormatException();
		}
		return new City(streets);
	}
	
	/** Función principal que se encarga de ir llamando a los respectivos métodos
	 * que leen cada parte de la ciudad
	 * @param f - Scanner por donde va leyendo el archivo
	 * @throws WrongCityFormatException si hay algun error (Ver documentacion de la clase para los errores)
	 */
	private void primerIf(Scanner f) throws WrongCityFormatException{
		linea = f.nextLine();
		if(!linea.equals("BeginCity")){
			throw new WrongCityFormatException();
		}else{
			if(f.hasNext()){
				linea = f.nextLine();
			}else{
				throw new WrongCityFormatException();
			}
			if(!linea.equals("BeginPlaces")){
				throw new WrongCityFormatException();
			}
			
			if(f.hasNext()){
				linea = f.nextLine();
			}else{
				throw new WrongCityFormatException();
			}
			
			/////////////
			leer1(f);
			/////////////
			
			if(f.hasNext()){
				linea = f.nextLine();
			}else{
				throw new WrongCityFormatException();
			}
			if(!linea.equals("BeginStreets")){
				throw new WrongCityFormatException();
			}
			i=0;
			if(f.hasNext()){
				linea = f.nextLine();
			}else{
				throw new WrongCityFormatException();
			}
			
			//////////
			leer2(f);
			//////////
			
			i=0;
			
			if(f.hasNext()){
				linea = f.nextLine();
			}else{
				throw new WrongCityFormatException();
			}
			if(!linea.equals("BeginItems")){
				throw new WrongCityFormatException();
			}
			i=0;
			if(f.hasNext()){
				linea = f.nextLine();
			}else{
				throw new WrongCityFormatException();
			}
			
			/////////
			leer3(f);
			/////////
			
			if(f.hasNext()){
				linea = f.nextLine();
			}else{
				throw new WrongCityFormatException();
			}
			if(!linea.equals("EndCity")){
				throw new WrongCityFormatException();
			}else{
				if(f.hasNext()){
					throw new WrongCityFormatException();
				}else{
					
				}
			}
		}
	}
	

	/** Lee la información referente a los lugares de la ciudad
	 * @param f - Scanner por el que va leyendo el archivo
	 * @throws WrongCityFormatException si hay algun error (Ver documentacion de la clase para los errores)
	 */
	private void leer1(Scanner f) throws WrongCityFormatException{
		do{
			
			String[] words=null;
			if(linea.contains(" ")){ // The line is empty and it's incorrect
				words = linea.split(" ");
			}else{
				throw new WrongCityFormatException();
			}
			if(words.length<5){
				throw new WrongCityFormatException();
			}else{
				boolean spaceship = false;
				String place = words[0];
				int numPlace=0;
				words[1].replaceAll(" ", "");
				
				numPlace = Integer.parseInt(words[1]);
				
				String namePlace = words[2];
				String description = "";
				for(int j=0; j<words.length-4; j++){
					description = description + words[j+3];
					if(j!=words.length-5){
						description = description + " ";
					}
				}
				String sp = words[words.length-1];
				if(!place.equals("place")||numPlace!=i||(!sp.equals("spaceShip")&&!sp.equals("noSpaceShip"))){
					throw new WrongCityFormatException();
				}
				if(sp.equals("spaceShip")){
					spaceship = true;
				}
				description = description.replace("_", " ");
				if(description.substring(0, 1).equals("\"")&&description.substring(description.length()-1, description.length()).equals("\"")){
					description = description.substring(1, description.length()-1);
				}
				places.add(numPlace , new Place(namePlace, spaceship, description));
			}
			if(f.hasNext()){
				linea = f.nextLine();
			}else{
				throw new WrongCityFormatException();
			}
			i++;
		}while(!linea.equals("EndPlaces"));
		
	}
	
	/** Lee la información referente a las calles de la ciudad
	 * @param f - Scanner por el que va leyendo el archivo
	 * @throws WrongCityFormatException si hay algun error (Ver documentacion de la clase para los errores)
	 */
	private void leer2(Scanner f) throws WrongCityFormatException{
		do{
			
			String[] words=null;
			if(linea.contains(" ")){ // The line is empty and it's incorrect
				words = linea.split(" ");
			}else{
				throw new WrongCityFormatException();
			}
			if(words.length<8||words.length>9){
				throw new WrongCityFormatException();
			}else{
				boolean open = true;
				String code = "";
				String street = words[0];
				String place1 = words[2];
				Direction dir= Direction.valorDe(words[4]);
				String place2 = words[5];
				int numStreet=0;
				int numPlace1=0;
				int numPlace2=0;
				words[1].replaceAll(" ", "");
				words[3].replaceAll(" ", "");
				words[6].replaceAll(" ", "");
				
				numStreet = Integer.parseInt(words[1]);
				numPlace1 = Integer.parseInt(words[3]);
				numPlace2 = Integer.parseInt(words[6]);
				
				if(numStreet!=i||!street.equals("street")||!place1.equals("place")
						||!place2.equals("place")||dir==Direction.UNKNOWN){
					throw new WrongCityFormatException();
				}
				if(words[7].equals("open")&&words.length==8){
					open=true;
				}else if(words[7].equals("closed")&&words.length==9){
					open=false; code=words[8];
				}else{
					throw new WrongCityFormatException();
				}
				
				if(words.length>=4 && numPlace1<=places.size()-1 && numPlace2<=places.size()-1 && numStreet==i){
					streets.add(numStreet , new Street(places.get(numPlace1),
						Direction.valorDe(words[4]), places.get(numPlace2),open, code));
				}else{
					throw new WrongCityFormatException();
				}
				
			}
			if(f.hasNext()){
				linea = f.nextLine();
			}else{
				throw new WrongCityFormatException();
			}
			i++;
		}while(!linea.equals("EndStreets"));
		
	}
	
	/** Lee los datos referentes a los objetos que hay en cada lugar
	 * @param f - Scanner por el que va leyendo el archivo
	 * @throws WrongCityFormatException si hay algun error (Ver documentacion de la clase para los errores)
	 */
	private void leer3(Scanner f) throws WrongCityFormatException {
		do{
			
			String[] words=null;
			if(linea.contains(" ")){ // The line is empty and it's incorrect
				words = linea.split(" ");
			}else{
				throw new WrongCityFormatException();
			}
			
			if(words.length>=7){
				int numIt = 0;
				String itName = words[2];
				String description = "";
				words[1].replaceAll(" ", "");
				
				numIt = Integer.parseInt(words[1]);
				
				if(words[0].equals("fuel")&&words[words.length-2].equals("place")&&numIt==i){
					
					fuel(words, itName, description);
					
				}else if(words[0].equals("garbage")&&words[words.length-2].equals("place")&&numIt==i){
					
					garbage(words, itName, description);
					
				}else if(words[0].equals("codecard")&&words[words.length-2].equals("place")&&numIt==i){
					
					codecard(words, itName, description);
					
				}else{
					throw new WrongCityFormatException();
				}
				
			}else{
				throw new WrongCityFormatException();
			}
			
			if(f.hasNext()){
				linea = f.nextLine();
			}else{
				throw new WrongCityFormatException();
			}
			i++;
			
		}while(!linea.equals("EndItems"));		
	}
	
	/** Parsea la información referente a un item que es del tipo fuel
	 * @param words - Array de String con las palabras de la linea a parsear
	 * @param itName - String con el nombre del item
	 * @param description - String con la descripcion del item
	 * @throws WrongCityFormatException si hay algun error (Ver documentacion de la clase para los errores)
	 */
	private void fuel(String[] words, String itName, String description) throws WrongCityFormatException{
		if(words.length>=8){
			for(int j=0; j<words.length-7; j++){
				description = description + words[j+3];
				if(j!=words.length-8){
					description = description + " ";
				}
			}
			int times = 0, energy=0, p=0;
			
			words[words.length-4].replaceAll(" ", "");
			words[words.length-3].replaceAll(" ", "");
			words[words.length-1].replaceAll(" ", "");
			
			times = Integer.parseInt(words[words.length-4]);
			energy = Integer.parseInt(words[words.length-3]);
			p = Integer.parseInt(words[words.length-1]);
			
			description = description.replace("_", " ");
			if(description.substring(0, 1).equals("\"")&&description.substring(description.length()-1, description.length()).equals("\"")){
				description = description.substring(1, description.length()-1);
			}
			if(p<=places.size()-1){
				places.get(p).addItem(new Fuel(itName,description,times,energy));
			}else{
				throw new WrongCityFormatException();
			}
		}else{
			throw new WrongCityFormatException();
		}
	}
	
	
	/** Parsea la información referente a un item que es del tipo garbage
	 * @param words - Array de String con las palabras de la linea a parsear
	 * @param itName - String con el nombre del item
	 * @param description - String con la descripcion del item
	 * @throws WrongCityFormatException si hay algun error (Ver documentacion de la clase para los errores)
	 */
	private void garbage(String[] words, String itName, String description) throws WrongCityFormatException{
		if(words.length>=7){
			for(int j=0; j<words.length-6; j++){
				description = description + words[j+3];
				if(j!=words.length-7){
					description = description + " ";
				}
			}
			int p=0, material=0;
			
			words[words.length-1].replaceAll(" ", "");
			words[words.length-3].replaceAll(" ", "");
			
			p = Integer.parseInt(words[words.length-1]);
			material = Integer.parseInt(words[words.length-3]);
			
			description = description.replace("_", " ");
			if(description.substring(0, 1).equals("\"")&&description.substring(description.length()-1, description.length()).equals("\"")){
				description = description.substring(1, description.length()-1);
			}
			if(p<=places.size()-1){
				places.get(p).addItem(new Garbage(itName,description,material));
			}else{
				throw new WrongCityFormatException();
			}
		}else{
			throw new WrongCityFormatException();
		}
	}

	/** Parsea la información referente a un item que es del tipo codecard
	 * @param words - Array de String con las palabras de la linea a parsear
	 * @param itName - String con el nombre del item
	 * @param description - String con la descripcion del item
	 * @throws WrongCityFormatException si hay algun error (Ver documentacion de la clase para los errores)
	 */
	private void codecard(String[] words, String itName, String description) throws WrongCityFormatException{
		if(words.length>=7){
			for(int j=0; j<words.length-6; j++){
				description = description + words[j+3];
				if(j!=words.length-7){
					description = description + " ";
				}
			}
			int p=0;
			words[words.length-1].replaceAll(" ", "");
			
			p = Integer.parseInt(words[words.length-1]);
			
			String code = words[words.length-3];
			description = description.replace("_", " ");
			if(description.substring(0, 1).equals("\"")&&description.substring(description.length()-1, description.length()).equals("\"")){
				description = description.substring(1, description.length()-1);
			}
			if(p<=places.size()-1){
				places.get(p).addItem(new CodeCard(itName,description,code));
			}else{
				throw new WrongCityFormatException();
			}
		}else{
			throw new WrongCityFormatException();
		}
	}
	/**
	 * Devuelve el lugar donde el robot va a comenzar la simulacion
	 * @return: The initial place
	 */
	public Place getInitialPlace (){
		return this.places.get(0);
	}
}
