


<h1>PROYECTO INTEGRADOR</h1>
<h2>Troopers Stay - Sistema de Gestión de Alojamientos</h2>

<h2>link de Notion completo:  https://www.notion.so/Proyecto-INTEGRADOR-JAVA-4b34ee2ccc314d269b1127fd4832bbe3 </h2> 



<p>Troopers Stay es una aplicación Java que permite a los usuarios publicar y buscar alojamientos para estancias temporales. Los usuarios pueden registrarse, iniciar sesión y tener roles duales: publicar alojamientos o contratar servicios de alojamiento. La aplicación utiliza una base de datos MySQL para almacenar la información de los alojamientos y los usuarios.</p>

<h2>Tecnologías utilizadas</h2>
 <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img
  src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java"
  width="40" height="40" /> </a>
   <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img
    src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg"
    alt="mysql" width="40" height="40" /> </a>

<h2>Guía de Instalación</h2>

<h3>Requisitos Previos</h3>

<p>Asegúrate de tener los siguientes requisitos previos instalados en tu sistema:</p>

<ul>
    <li><a href="https://dev.mysql.com/downloads/mysql/">MySQL</a> y <a href="https://dev.mysql.com/downloads/workbench/">MySQL Workbench 8.0</a></li>
    <li><a href="https://www.oracle.com/java/technologies/javase-jdk18-downloads.html">Java JDK</a> versión 18</li>
</ul>

<h3>Pasos de Instalación</h3>

<ol>
    <li><strong>Clonar el Repositorio:</strong></li>
    <pre>
        <code>git clone https://github.com/tu-usuario/troopers-stay.git
        cd troopers-stay</code>
    </pre>
    <li><strong>Configurar la Base de Datos:</strong></li>
    <p>En la carpeta "BASE DE DATOS JTT", encontrarás un archivo llamado "database.properties-example". Edita este archivo para proporcionar la información de tu base de datos. Luego, renombra el archivo a "database.properties" y asegúrate de reemplazar las siguientes credenciales con las tuyas:</p>
    <pre>
        <code>DB_URL=jdbc:mysql://localhost:3306/trooper_stay
        DB_USERNAME=tu_usuario_mysql
        DB_PASSWORD=tu_contraseña</code>
    </pre>
    <li><strong>Inicializar la Base de Datos:</strong></li>
    <p>Abre MySQL Workbench y ejecuta el script "trooper_stay.sql" que se encuentra en la carpeta "BASE DE DATOS JTT". Esto creará la estructura de la base de datos necesaria para el funcionamiento de Troopers Stay.</p>
    <li><strong>Compilar y Ejecutar el Programa:</strong></li>
    <p>Compila el código fuente Java utilizando el siguiente comando desde la raíz del proyecto:</p>
    <pre>
        <code>javac -classpath .:./lib/* TroopersStayMain.java</code>
    </pre>
    <p>Ejecuta el programa con el siguiente comando:</p>
    <pre>
        <code>java -classpath .:./lib/* TroopersStayMain</code>
    </pre>
    <li><strong>Acceder al Sistema:</strong></li>
    <p>Abre tu navegador web y accede a "http://localhost:puerto-del-servidor" para utilizar Troopers Stay.</p>
</ol>

<h3>Problemas Comunes y Soluciones</h3>

<p><strong>Problema:</strong> No se puede conectar a la base de datos.</p>
<p><strong>Solución:</strong> Asegúrate de que las credenciales en "database.properties" sean correctas y de que MySQL esté en ejecución.</p>

<p><strong>Problema:</strong> Error durante la ejecución del script SQL.</p>
<p><strong>Solución:</strong> Verifica el script "trooper_stay.sql" para asegurarte de que no haya errores de sintaxis y de que esté apuntando a la base de datos correcta.</p>



