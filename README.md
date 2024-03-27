
# Proyecto de Cálculo de Musculación
## Descripción:
* Este proyecto se basa en una API REST construida con Spring Boot que ofrece funcionalidades para calcular diversos parámetros relacionados con la musculación, tales como el índice de masa corporal (IMC), cantidad de proteínas recomendadas y las calorías necesarias.

## Endpoints:
* Saludo Personalizado -> 
GET /musculacion/{nombre}
  * Saluda al usuario y le proporciona una breve guía sobre cómo usar la API.

* Cálculo de IMC -> 
    POST /musculacion/imc
  * Parámetros:`peso, altura`
  * Retorna el IMC y una descripción asociada (ej. bajo de peso, peso ideal, sobrepeso, etc.).
* Cálculo de Proteínas -> 
  * POST /musculacion/proteinas
  * Parámetros: `peso, actividad (sedentario, ligera, moderada, intensa, muy intensa)`

  * Retorna la cantidad de proteínas recomendadas según el peso y nivel de actividad del usuario.
* Cálculo de Calorías ->
  * POST /musculacion/calorias

  * Parámetros:` peso, altura, edad, sexo (hombre, mujer), actividad (sedentario, ligera, moderada, intensa, muy intensa)`
  * Retorna la cantidad de calorías recomendadas según los datos proporcionados. 
* Registro ->
  * POST /musculacion/apuntarse
  * Parámetros: `nombre, apellidos, email, telefono, direccion, edad, sexo, actividad`
  * Valida la información ingresada y retorna un mensaje de confirmación de registro.
    Uso

## Clone el repositorio.
* Importe el proyecto en su IDE preferido con soporte para Spring Boot.
Asegúrese de tener todas las dependencias requeridas y ejecute la aplicación.
Acceda a los endpoints mediante cualquier cliente HTTP (Postman, navegador, etc.).
##*  Requisitos
  *     Java 8 o superior.
    *       Maven (si desea compilar y empaquetar el proyecto manualmente).
      *     Cualquier IDE con soporte para Spring Boot (opcional).
## Contribución
  * Las contribuciones son bienvenidas. Siéntase libre de hacer fork y enviar Pull Requests con características adicionales o correcciones.

## Licencia
*   Este proyecto está bajo una licencia MIT.
