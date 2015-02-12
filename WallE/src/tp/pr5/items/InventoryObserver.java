/**
 * Interfaz del observador que quiere recibir las notificaciones sobre los eventos ocurridos en el inventario de objetos (item container)
 * del robot. El contenedor de objetos notificará cualquier cambio que ocurra al observador correspondiente como por ejemplo, cuando el robot
 * coja o suelte obkjetos, y cuando objetos sean removidos del contenedor, porque este esté lleno. El contenedor tambien informara de cambios
 * cuando el usuario solicite scan sobre un item concreto o sobre todo el contenedor de objetos.
 */
package tp.pr5.items;

/**
 * @author Jaime Delgado Linares y Juan Samper González
 *
 */
public interface InventoryObserver {
	
	/**
	 * Notifica que el contenedor ha cambiado
	 * @param inventory - El nuevo inventario
	 */
	public void inventoryChange(java.util.List<Item> inventory);
	
	/**
	 * Notifica que el usuario solicita una instruccion 'SCAN' sobre el contenedor
	 * @param inventoryDescription - Proporciona información sobre el inventario (contenedor de objetos)
	 */
	public void inventoryScanned(java.lang.String inventoryDescription);
	
	/**
	 * Notifica que el usuario quiere realizar una accion 'SCAN' sobre un item
	 * almacenado en el contenedor
	 * @param description - Es la descripcion sobre el item que se busca o scannea
	 */
	public void itemScanned(java.lang.String description);
	
	/**
	 * Informa del cambio de que un item esta vacio (no le quedan mas usos posibles) y que
	 * será removido del contenedor. A esto le sigue una llamada al metodo InventoryChange.
	 * @param itemName - Nombre sobre el item que está vacio.
	 */
	public void itemEmpty(java.lang.String itemName);
}
