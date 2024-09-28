# Feedback1_Eventos

## Enlace al Repositorio
[Repositorio en GitHub](https://github.com/jmartter/Feedback1_Eventos.git)

## Descripción
Este proyecto es una aplicación de Android que permite a los usuarios gestionar y visualizar novelas. La aplicación está compuesta por varias pantallas, incluyendo `LoginActivity`, `MenuUsuarioActivity`, `AddNovelaScreen`, `ViewNovelasScreen`, y `ViewNovelaDetailScreen`.

## Credenciales de Usuario
- **Usuario:** 1
- **Contraseña:** 1

## Ubicación del Código
El código de este proyecto se encuentra en la siguiente ruta:

`/app/src/main/java/com/example/feedback1_eventos/`

## Componentes Principales

### `LoginActivity.kt`
#### Clase `LoginActivity`:
- Es una subclase de `ComponentActivity`.
- En el método `onCreate`, se configura la pantalla de inicio de sesión usando Jetpack Compose.
- Usa `UserManager` para verificar las credenciales del usuario.

#### Función `LoginScreen`:
- Es una función composable que define la UI de la pantalla de inicio de sesión.
- Usa `OutlinedTextField` para ingresar el nombre de usuario y la contraseña.
- Usa `Button` para iniciar sesión.

#### Función `LoginScreenPreview`:
- Es una función composable que proporciona una vista previa de la pantalla de inicio de sesión en el editor.

### `MenuUsuarioActivity.kt`
#### Clase `MenuUsuarioActivity`:
- Es una subclase de `ComponentActivity`.
- En el método `onCreate`, se configura la pantalla del menú de usuario usando Jetpack Compose.
- Pasa el nombre de usuario a la pantalla del menú de usuario.

#### Función `MenuUsuarioContent`:
- Es una función composable que define la UI del menú de usuario.
- Usa `Button` para navegar a las pantallas de añadir novela, ver novelas del usuario y ver novelas iniciales.

### `AddNovelaScreen.kt`
#### Función `AddNovelaScreen`:
- Es una función composable que define la UI para añadir una nueva novela.
- Usa `OutlinedTextField` para ingresar los detalles de la novela.
- Usa `Button` para añadir la novela.

### `ViewNovelasScreen.kt`
#### Función `ViewNovelasScreen`:
- Es una función composable que define la UI para ver la lista de novelas.
- Usa `LazyColumn` para mostrar la lista de novelas.
- Usa `NovelOptionsDialog` para mostrar opciones de novela.

### `ViewNovelaDetailScreen.kt`
#### Función `ViewNovelaDetailScreen`:
- Es una función composable que define la UI para ver los detalles de una novela.
- Muestra el título, autor, año de publicación, sinopsis y reseñas de la novela.

### `NovelOptionsDialog.kt`
#### Función `NovelOptionsDialog`:
- Es una función composable que define un diálogo con opciones para una novela.
- Permite borrar, añadir reseña, ver detalles y marcar como favorito una novela.

## Muestra de la Aplicación
<table>
  <tr>
    <th>LoginScreen</th>
    <th>MenuUsuarioScreen</th>
    <th>AddNovelaScreen</th>
    <th>ViewNovelasScreen</th>
    <th>ViewNovelaDetailScreen</th>
  </tr>
  <tr>
    <td><img src="app/src/main/res/drawable/c1.png" alt="LoginScreen" width="200"/></td>
    <td><img src="app/src/main/res/drawable/c2.png" alt="MenuUsuarioScreen" width="200"/></td>
    <td><img src="app/src/main/res/drawable/c3.png" alt="AddNovelaScreen" width="200"/></td>
    <td><img src="app/src/main/res/drawable/c4.png" alt="ViewNovelasScreen" width="200"/></td>
    <td><img src="app/src/main/res/drawable/c5.png" alt="ViewNovelaDetailScreen" width="200"/></td>
  </tr>
</table>

## Notas de Desarrollo
Inicialmente, intente implementar una lista de usuarios donde cada uno tuviera sus propias credenciales. Sin embargo, encontré problemas ya que los favoritos y las novelas se sincronizaban entre los usuarios. Debido a estos errores, decidí eliminar la opción de añadir usuarios y simplificar la funcionalidad en este aspecto.
