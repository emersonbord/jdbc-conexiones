## jdbc-conexiones-crud-mysql馃П

**Descripci贸n:** En esta instancia, se muestra un ejemplo de CRUD con base de datos utilizando la API JDBC. Tambi茅n, hay 3 ejemplos para conectarse a una base de datos MySQL utilizando la API JDBC (Java Database Connectivity), que permite
la ejecuci贸n de operaciones y consultas sobre bases de datos desde Java. En el proyecto, existen 3 clases con el m茅todo main, dos de ellas `EjemploJdbc.java` y 
`EjemploJdbcAvanzado.java`, permiten connectarse desde la misma clase. 

Para que la conexi贸n a la base de datos no est茅 tan acomplada a una misma clase como las anteriores,
se pueden tener varias clases que utilicen **JDBC**, no es la idea conectarse una y otra vez con el **DriverManager**, **getConnection()** de forma literal, porque no estar铆amos
reutilizando c贸digo. Es por eso que el tercer m茅todo de conexi贸n centraliza la conexi贸n a una clase independiente que puede ser reutilizada. Para esta instancia se utilizar谩 el patr贸n
**Singleton**. Dentro de la carpeta `util` en la clase `ConexionBaseDatos.java` tendremos nuestra conexi贸n a la base de datos y corremos el programa con la clase con el
m茅todo main `EjemploJdbcReutilizable.java`.

Para este ejemplo se necesita crear una base de datos con 2 tablas, puede ser creada en MySQL Workbench o en el famoso PhpMyAdmin utilizando servidor XAMPP. Las tablas a crear es una de **productos** con los siguientes atributos del modelo Producto:

```Java
    private Long id;
    private String nombre;
    private Integer precio;
    private Date fechaRegistro;
    //Establecemos la relaci贸n entre Producto y Categor铆a, creando el atributo categoria del tipo Categoria ya que es parte del producto.
    private Categoria categoria;
```

Y otra tabla **categorias** con los siguientes atributos del modelo Categoria. 

```Java
    private Long id;
    private String nombre;
```

La relaci贸n entre tablas es de 1.....* (uno es muchos), en donde una categor铆a puede contener muchos productos, relaci贸n a tener en cuenta.
