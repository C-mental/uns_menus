📱 MenuWebView - App Android basada en la UNS
MenuWebView es una aplicación Android desarrollada en Kotlin con Android Studio, que permite navegar por el contenido oficial de la Universidad Nacional del Santa (UNS) usando diferentes tipos de menús, interfaz de login y vistas web (WebView). Está diseñada para ser funcional, educativa y visualmente institucional.

📝 ¿Qué hace esta app?
Esta app simula el acceso de un estudiante a la plataforma web de la UNS. Al iniciar sesión, puede visualizar secciones reales del sitio web directamente desde la app, como “Contáctanos” y “Noticias”, sin necesidad de abrir un navegador externo.

También incluye navegación por menús, uso de múltiples actividades y diseño con colores representativos de la universidad.

🔐 Pantalla de Login
El usuario debe ingresar un nombre y una contraseña para acceder.

Se muestra el logo oficial de la UNS.

No valida contra una base de datos, pero requiere que ambos campos estén llenos.

Al ingresar, el nombre del usuario se muestra en la parte superior de la siguiente pantalla como bienvenida personalizada.

🖥️ WebView Principal
Al iniciar sesión, se carga la página principal de la UNS en un WebView:
https://www.uns.edu.pe

El contenido web se carga dentro de la app, gracias al uso de WebViewClient, sin necesidad de abrir el navegador del sistema.

🧭 Menú de Opciones (Options Menu)
Este menú aparece en la barra superior (AppBar).

Contiene:

Información: Muestra un mensaje con el nombre completo de la universidad.

Salir: Cierra la aplicación.

Se implementa con onCreateOptionsMenu() y onOptionsItemSelected().

🧨 Menú Contextual (Context Menu)
Aparece cuando el usuario hace una presión larga (long click) sobre el WebView.

Muestra estas opciones:

Recargar página: Vuelve a cargar el contenido del WebView.

Atrás: Retrocede a la página anterior dentro del WebView.

Se implementa con registerForContextMenu(), onCreateContextMenu() y onContextItemSelected().

📤 Menú Emergente (Popup Menu)
Se activa al presionar un botón en la parte inferior de la pantalla principal.

Muestra opciones como:

Contáctanos: Abre una nueva pantalla que carga la sección de contacto de la UNS.

Eventos: Abre otra pantalla con las noticias y eventos institucionales.

Se implementa con PopupMenu y setOnMenuItemClickListener().

🧾 Pantallas adicionales
Cada opción del menú emergente lleva al usuario a una nueva Activity, cada una con su propio WebView:

ContactoActivity
Carga la página oficial de contacto:
https://www.uns.edu.pe/index.php/contacto

EventosActivity
Muestra las noticias y eventos actuales de la UNS:
https://www.uns.edu.pe/index.php/noticias

Ambas actividades tienen su propio layout XML y están registradas en el AndroidManifest.xml.

🎨 Diseño visual
Se utilizaron los colores institucionales de la UNS, especialmente:

Rojo institucional: #D20037 (PANTONE DS 98-1 C)

Estilo visual limpio y académico.

Tema utilizado: Theme.AppCompat.Light.DarkActionBar para mostrar la barra superior.

📁 Archivos y estructura general
pgsql
Copiar
Editar
├── LoginActivity.kt
├── MainActivity.kt
├── ContactoActivity.kt
├── EventosActivity.kt
├── res/
│   ├── layout/
│   │   ├── activity_login.xml
│   │   ├── activity_main.xml
│   │   ├── activity_contacto.xml
│   │   ├── activity_eventos.xml
│   ├── menu/
│   │   ├── menu_opciones.xml
│   │   ├── menu_contextual.xml
│   │   ├── menu_popup.xml
│   ├── values/
│   │   ├── colors.xml
│   │   ├── strings.xml
│   │   ├── themes.xml
├── AndroidManifest.xml
