### 
# <div align="center">Proyecto INTEGRADOR JAVA **>>JUNIOR TECH TROOPERS<<**</div>

# <div align="center">COHORTE 2023</div>

---

![PNG NOMBRES-LEGAJOS](https://github.com/CodeStrong2023/ProyectoJuniorTechTroopers/assets/135768183/22755ee9-17a4-474e-9137-907880db77c8)

---

 **IDEA:**

 ***Sistema de estadía (Troopers Stay)***

  <div align="center">En esta aplicación se podrán publicar alojamientos con sus respectivas características. Estos alojamientos se almacenaran en una base de datos, 
permitiendo así mostrar estos y que los usuarios puedan hacer uso del servicio.
El usuario podrá iniciar sesión y registrarse en caso de no tener credenciales. Tendrá ambos roles, es decir, podrá tanto publicar nuevos alojamientos como también contratar el servicio. 
Estos alojamientos tendrán un tipo, fecha de estadia, localización y capacidad. Los alojamientos se vincularan a los usuarios mediante la base de datos.

</div>


---

***Troopers Stay - Sistema de Gestión de Alojamientos:***

***Descripción del Proyecto***



 <div align="center">Troopers Stay es una aplicación Java que permite a los usuarios publicar y buscar alojamientos para estancias temporales. Los usuarios pueden registrarse, iniciar sesión y tener roles duales: publicar alojamientos o contratar servicios de alojamiento. 
La aplicación utiliza una base de datos MySQL para almacenar la información de los alojamientos y los usuarios
   
</div>


---

### REQUISITOS

Lenguaje: ***JAVA***

Aplicación: ***Desktop***

Base de datos: ***MySQL// SQlite no requiere de conexión a internet***

Software: ***Net Beans***

---

### TABLAS

  ***Filtro*** (De acuerdo a los valores que ingres el usuario se mostrará los alojamientos)

   ***Usuarios***

---

### Estructura

**El proyecto se basa en dos objetos:**

  ***Persona***
 ***Alojamientos***

 -    **LOGIN ⇒ PARTE DEL OBJETO PERSONA**

 **¿Qué puede hacer?**
    
  ***Ingresar***
    
***Registrarse***
    
  ***Verificación (Lo último)***

 - **ALOJAMIENTO CRUD => (CREAR LEER ACTUALIZAR Y ELIMINAR)**
  
   ***Carga de alojamientos***
  
   ***Filtros***
  
   ***Ver los alojamientos***
  
   ***Contratar***
  
   ***Carro***

  ![image](https://github.com/CodeStrong2023/ProyectoJuniorTechTroopers/assets/135768183/7b1ce4ca-20b3-430e-91c7-ceb4e57d1ea7)

  ---

 ### BASE DE DATOS
 
**Base de datos nombre: Trooper_Stay**

Primeramente deberemos identificar la estructura, los tipos de datos y determinar las llaves primarias y foraneas.

Creamos la base de datos

Lo realizamos con el asistente de workbench.

### En código se vería así: 

![image](https://github.com/CodeStrong2023/ProyectoJuniorTechTroopers/assets/135768183/30c512ef-fcae-4b39-b3ec-2d89f9c0df2a)

### Cantidad tablas: 2

- **Tabla 1: usuarios**

### Campos:

![image](https://github.com/CodeStrong2023/ProyectoJuniorTechTroopers/assets/135768183/5d9a88c0-bd92-4f86-a2e7-420a143f3ec4)

### Ingresando registros a nuestra tabla como prueba

![image](https://github.com/CodeStrong2023/ProyectoJuniorTechTroopers/assets/135768183/8fa1e52e-a2ea-4d5e-8746-099b211552c1)

- **Tabla 2: hospedaje**
    
    ### Campos:

  ![image](https://github.com/CodeStrong2023/ProyectoJuniorTechTroopers/assets/135768183/1c6ac981-2c98-4f37-a9a1-563bdf8ee31d)

### Creando las tablas (ingresamos llaves primarias y foraneas)

***¿Qué son las llaves primarias y foráneas?***

**Clave primaria:** Son valores que identifican de manera única a cada fila o registro de una tabla, esto
quiere decir que ***no se pueden repetir*** . Por ejemplo: DNI, código de producto, etc.

**Clave foránea:** Es un campo de un tabla “X” que sirve para enlazar o relacionar entre sí con otra tabla
“Y” en la cual el campo de esta tabla es una llave primaria. Para que sea una clave foránea un campo,
esta tiene que ser una ***llave primaria en otra tabla.***

En este paso es importante que tanto el ***id_usuario*** y el ***id_alojamiento*** sean llaves primarias (esto debido a
que deben ser UNICOS para poder filtrar la información más adelante).

Estos id seran **auto incrementales** para que sus valores se asignen solos a medida que se crean nuevos
registros.

![image](https://github.com/CodeStrong2023/ProyectoJuniorTechTroopers/assets/135768183/141f9bac-6d86-4a0c-b188-73435ce16d56)

**¿Por qué definir el id_usuario como llave foranea en la tabla hospedajes?**

Porque es el dato que nos va a permitir relacionar ambas tablas , con este id podremos identificar qué
persona ingresa datos.

---

### BACKEND

Como primer instancia debemos establecer la conexión con la base de datos. Para ello requerimos de JDBC, es
necesario para conectar una base de datos MySQL a un backend en Java. La misma es una la API de JDBC
(Java Database Connectivity). JDBC proporciona una forma estándar de interactuar con bases de datos desde
aplicaciones Java. 

Para que esta API funcione es necesaria insertar una librería con los drivers.

**Estableciento la conexión con la base de datos:**

![image](https://github.com/CodeStrong2023/ProyectoJuniorTechTroopers/assets/135768183/73d80441-f441-403f-a1ae-26b7d5773068)

---






