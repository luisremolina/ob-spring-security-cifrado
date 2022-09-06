## JWT

Es un estandar abierto que permite transmitir informacion entre dos partes:

## Funcionamiento Session
1. Cliente envia una peticion aun servidor (/api/login)
2. Servidor valida username y password, si no son validos devolvera una respuesta 401 unauthorized
3. Servidor valida username y password, si son validos se almacena el usuario en session
4. Se genera una cookie en el cliente
5. En proximas peticiones se comprueba que el cliente esta en session

Desventajas:
 * La informacion de la session se almacena en el servidor, lo cual consume recursos.

## Funcionamiento

1. Cliente envia una peticion aun servidor (/api/login)
2. Servidor valida username y password, si no son validos devolvera una respuesta 401 unauthorized
3. Servidor valida username y password, si son validos generaun token JWT que 
utiliza una secret key
3. Servidor devuelve el token JWT generando al cliente
4. El cliente envia peticiones a los endpoints del servidor utilizando el token JWT en las cabeceras
5. Servidor valida el token en cada peticion y si es correcto permite le acceso a los datos

Ventajas: 
* El token se almacena en el Cliente, de maner aque consume menos recursos en el servidor, lo cual permite mejor escalabilidad

Desventajas:
* El token esta en el navegador, no podriamos invalidarlo antes dela fecha de 
expiracion asignada cuando se creo
  * Lo que se realiza es dar la opcion de logout, lo cual simplemente borra el token

## Estructura del token JWT

3 partes separadas por un punto (.) y codificadas en base 64 cada una:

1. Header

```json
{
  "alg": "HS512",
  "typ": "JWT"
}

```
2. Payload( informacion, datos del usuario, no sensibles)
```json
{
  "name": "luis remolina",
  "admin": true
}
```
3. Signatura
```
    HMACKSHA236(
    base64UrlEncode(header) + "." + 
    base64UrlEncode(payload), 
    secret
    )
```

Ejemplo de token generado:
```
    eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.ey
    JzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6Ikpva
    G4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKx
    wRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```

El User-Agent envia el token JWT en las cabeceras:
```
    Authotization: Bearer <token>
```

## Configuracion Spring
Crear proyecto Spring Boot con:
* Spring Security
* Spring Web
* Spring boot devtools
* Spring Data JPA
* PostgreSQL
* Dependencia JWT( se añade en el pom.xml)

```xml
<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.5</version>
    </dependency>

```
