## Bienvenidos a EcoEvent Proyecto Todos a la U.

La aplicación EcoEvent es una aplicación móvil diseñada para ayudar a los organizadores de eventos a registrar y realizar un seguimiento de sus esfuerzos para reducir el uso de plástico en diferentes categorías, como alimentos, bebidas y decoraciones. La aplicación emplea variables, operaciones y estructuras de datos para calcular y mostrar estadísticas, como el promedio de reducción, comparativas entre eventos y consejos personalizados para disminuir el uso de plástico. 

La aplicación ofrece una plataforma integral que abarca múltiples categorías de uso de plástico, como alimentos, bebidas y decoraciones, proporcionando una visión holística y datos precisos para evaluar y mejorar las prácticas sostenibles.

## Funcionalidades y Vistas

**1. Pantalla de Inicio de Sesión**

**Registro e Inicio de Sesión:** Permite a los usuarios iniciar sesión en la aplicación utilizando sus credenciales o registrarse como nuevos usuarios, asegurando el acceso seguro y personalizado a la aplicación.

**2. Pantalla Principal**

**Navegación Centralizada:** Muestra opciones de navegación para acceder a diferentes secciones de la aplicación, como la pantalla de categorías, la pantalla de estadísticas y la pantalla de consejos.

**3. Pantalla de Categorías**

**Selección de Categorías:** Permite al usuario seleccionar la categoría de uso de plástico que desea registrar y realizar un seguimiento, facilitando la organización y el registro detallado de datos.

**4. Pantalla de Registro**

**Ingreso de Datos Específicos:** Permite al usuario ingresar los datos de uso de plástico para una categoría específica, como la cantidad de vasos plásticos usados en un evento, el costo de los vasos y el mes en que fueron utilizados. También se puede registrar la cantidad de plástico utilizada en las decoraciones del evento, el costo de estas decoraciones y el mes correspondiente.

**5. Pantalla de Estadísticas**

**Análisis y Comparativas:** Muestra estadísticas detalladas sobre la reducción de uso de plástico, proporcionando datos como el promedio, el máximo y el mínimo para una categoría específica. Esto permite a los organizadores evaluar su desempeño y comparar los resultados entre diferentes eventos.

**6. Pantalla de Consejos**

**Recomendaciones Personalizadas:** Proporciona consejos y recomendaciones personalizadas para reducir el uso de plástico en función de los datos registrados por el usuario, ayudando a adoptar prácticas más sostenibles y efectivas.

## Tecnologías utilizadas
Para el desarrollo de esta aplicación se utilizarán las siguientes tecnologías:

**Java**: Se utilizará el lenguaje de programación Java como el principal para el desarrollo de la lógica de la aplicación EcoEvent. Se abordarán los siguientes temas de Java:

- Variables y tipos de datos: Utilización de variables para almacenar y manipular información relacionada con el uso de plástico en eventos.

- Operaciones y expresiones: Realización de cálculos y operaciones matemáticas para calcular estadísticas como promedios, máximos y mínimos de uso de plástico.

- Estructuras de control: Utilización de condicionales (if, when) y ciclos (for, while) para controlar el flujo de ejecución y realizar iteraciones sobre los datos registrados.

- Estructuras de datos: Implementación y manipulación de estructuras de datos como ArrayList y HashMap para almacenar y organizar la información de uso de plástico por categoría.

- Programación orientada a objetos: Creación de clases para modelar elementos clave como eventos, categorías y estadísticas de uso de plástico. Se emplea herencia y polimorfismo para estructurar y reutilizar código de manera eficiente.

- Manipulación de archivos: Lectura y escritura de archivos para guardar y cargar datos de uso de plástico, asegurando persistencia de la información en la aplicación.

**Android Studio:** Se emplea Android Studio como el entorno de desarrollo integrado (IDE) principal para la creación de la aplicación móvil EcoEvent para dispositivos Android. Se abordarán los siguientes temas específicos de Android Studio:

- Creación de layouts XML: Definición de la interfaz gráfica de las diferentes pantallas de EcoEvent utilizando XML y los componentes de la biblioteca de Android, asegurando una presentación visual coherente y atractiva.

- Manejo de eventos: Captura de eventos de interacción del usuario, como toques en la pantalla y clics de botones, para responder de manera adecuada y ejecutar acciones correspondientes como el registro de datos de uso de plástico.

- Integración de actividades y fragmentos: Organización de la aplicación en actividades y fragmentos para facilitar la navegación entre diferentes secciones de EcoEvent y mejorar la experiencia de usuario.

- Persistencia de datos: Utilización de la API de persistencia de Android para almacenar de manera persistente los datos de uso de plástico ingresados por los usuarios, garantizando que la información se mantenga disponible incluso después de cerrar la aplicación.

- Interfaz de usuario intuitiva: Diseño de una interfaz gráfica intuitiva y funcional que permita a los usuarios registrar fácilmente datos de uso de plástico, visualizar estadísticas y recibir recomendaciones para reducir el consumo de plástico en eventos.
## Diagramas de Flujo de la aplicación 
- Flujo del ciclo de vida de la aplicación
![Diagramas de flujo](https://github.com/user-attachments/assets/6d8f5dd5-58d0-41f5-8931-4c2cfb004eec)

![Diagrama de Flujo 1](https://github.com/user-attachments/assets/f7b9168c-62b6-4053-8015-4da4638130ac)

## Interfaz

#### Pantalla de inicio de sesión y registro de usuarios:
- La aplicación **ECOEVENT** debe ofrecer la posibilidad de que los usuarios se registren y también inicien sesión para acceder a su cuenta personal.
- Para iniciar sesión, los usuarios deben ingresar un nombre de usuario y una contraseña válidos.
- Los usuarios que sean nuevos deben poder crear una cuenta nueva con un nombre de usuario único y una contraseña para el ingreso.

![](https://drive.google.com/file/d/1J8i4ZfjCjDJqv0cZFSzNZZwdvRg46qD1/view?usp=sharing)
> Inicio de Sesion.

![](https://drive.google.com/file/d/1f46YKg7PsdaX44w592hYC515aJKqK0vA/view?usp=sharing)
> Registro de Usuario.

![](https://drive.google.com/file/d/1nKh4Bh0KW25abQgv6esYbOlwbEjTp-9s/view?usp=sharing)
> Recuperacion de Contraseña.

#### Pantalla principal con información general del consumo de Plásticos:
- La aplicación ECOEVENT debe permitir el acceso rápido a las funciones principales en la pantalla principal después de iniciar sesión.
- Esta pantalla debe mostrar un menú de navegación hacia diferentes pantallas: categorías, estadísticas, consejos y registros.

![](https://drive.google.com/file/d/14Zk9kwrwHUr6WaO4FlieZLG-F9qeSc_K/view?usp=sharing)
> Pantalla de Inicio.

#### Pantalla de categorías para seleccionar el tipo de plástico a registrar:
- La aplicación debe incluir una pantalla en la que los usuarios puedan elegir la categoría específica de consumo de plástico que desean registrar
- Las categorías pueden incluir bebidas, decoraciones y alimentos.
- Una vez que los usuarios elijan la categoría de consumo, deberían poder ingresar los detalles específicos de su consumo en una pantalla especialmente diseñada para ello.
  
![](https://drive.google.com/file/d/1v4n1mmBUbDIN4uIqJ_JFC77cvw3SgCa7/view?usp=sharing)
> Pantalla de Categorias.

#### Pantalla de registro para ingresar los datos de consumo
- En la pantalla de registro, los usuarios deben poder introducir los valores de consumo.
- Permitir al usuario ingresar datos específicos sobre el uso de plástico en una categoría seleccionada. Los usuarios deben poder registrar los datos específicos de consumo en una pantalla dedicada.
- La pantalla de registro debe permitir a los usuarios ingresar los valores de Cantidad, costo del plástico y mes de registro.

![](https://drive.google.com/file/d/1osGrbJNUFH66uLQ3Z_4ID0EbVjJ7PoSw/view?usp=sharing)
> Pantalla de Registro de Consumo.
  
#### Pantalla de estadísticas con detalles sobre el consumo de plástico:
- La aplicación debe mostrar estadísticas detalladas sobre el consumo y reducción de plástico de los usuarios en una pantalla específica.
- Las estadísticas pueden abarcar el consumo promedio, el máximo y el mínimo durante un período específico.
- Debe permitir una comparativa entre eventos.

![](https://drive.google.com/file/d/1qe0WcBdD29ZHAPC-49oyqmrpeUPpr0K7/view?usp=sharing)
> Pantalla de Estadisticas.
  
#### Pantalla de consejos personalizados para reducir el consumo de plástico:
- La aplicación debería ofrecer recomendaciones personalizadas basadas en el registro de consumo realizado por el usuario.
- Estos consejos deben ayudar a los usuarios a reducir su consumo de plástico y fomentar prácticas más eficientes de reciclaje.

![](https://drive.google.com/file/d/1PdbUYNj1GQKrW6t9EFytij0NF0rXkmZc/view?usp=sharing)
> Pantalla de Consejos.

![](https://drive.google.com/file/d/1PdbUYNj1GQKrW6t9EFytij0NF0rXkmZc/view?usp=sharing)
> Pantalla de Lectura del Consejo.

### Final
