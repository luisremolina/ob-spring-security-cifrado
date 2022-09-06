## Cifrado

Es el proceso de codificar la información de su representación original(texto plano)
a texto cifrado, de manera que solo pueda ser descifrada utilizando una clave.

## Historia del cifrado
1. Almacenar las contraseñas en texto plano
2. Almacenar las contraseñas cifradas con una funcion Hash
3. Almacenar contraseñas cifradas con una funcion hash + salt
4. Almacenar contraseñas cifradas con una funcion adaptativa + factor de trabajo

La seguridad se gana haciendo que la validacion de contraseñas sea costosa computacionalmente

## Algoritmos en Spring Security

* BCrypt
* PBKDF2
* scrypt
* argon2