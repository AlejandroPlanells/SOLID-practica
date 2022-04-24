# Principios SOLID
## Ejercicio de práctica

### ERRORES

Buenas he restructurado todo el codigo, empezando por divir las interfaces en 3 las cuales serviran 
para luego implementarlas llamando a las interfaces:
- FileSystemItem: es usada cuando se necesita una función que contiene tanto File como Directory. 
- FileSystemFile: una interfaz solo para File.
- FileSystemDirectory: una interfaz solo para Directory.



Tambien he sacado las funciones *converterMp3ToWav* y converter *converterWavToMp3* de File a 
otra clase, para cumplir el principio de reponsabilidad unica.


Principios SOLID, *solucionados*:
- Principio de responsabilidad única.
- Principio de segregación de interfaces.
- Principio de Inversión de Dependencias.

### Problemas
Al cambiar las interfaces me he encontrado con que FileSystemBuilder llamaba a la interfaz princpal
que estaba al principio que contenido todos los metodos, de primera solución habia hecho un cast, para evitar los errores
de compilacion, pero no creo que sea la forma correcta, ya que me salto el principio de Inversión de Dependencias.
Aunque de la forma en lo que lo he realizado, me da la sensación de que es bastante mejorable ya que no
no implemento una abstracción. En este caso:

````java
public FileSystemBuilder addFile(String name, int size) {
        File file = new File(currentDirectory, name);
        file.open();
        file.write(new byte[size]);
        file.close();
        currentDirectory.addFile(file);
        return this;
    }
````
