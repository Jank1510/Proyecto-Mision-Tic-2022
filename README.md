# Proyecto-Mision-Tic-2022

## API REST para la institucion educativa los Chiquitines
### Lista de recursos que ofrece el api rest

Tener en cuenta que la base de datos tiene integridad referencial

# ***Recursos que no necesitan token***

**RECURSO # 1:** Login de usuarios</br>
**URL:** http://localhost:8080/usuarios/login</br>
**VERBO:** POST</br>
**CONSUME:**</br>
{
     "nickName": "admin",
     "contraseña": "admin"
}
</br>
**PRODUCE:** ***Importante, de aqui se obtiene el token***</br>
{
    "id": 1,
    "nickName": "admin",
    "contraseña": "",
    "nombres": "Administrador",
    "apellidos": "Chiquitines",
    "rol": {
        "id": 1,
        "descripcion": "Administrador"
    },
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYzODMxMzQ1NiwiZXhwIjoxNjM4MzE0MzU2LCJuaWNrTmFtZSI6ImFkbWluIiwicm9sIjp7ImlkIjoxLCJkZXNjcmlwY2lvbiI6IkFkbWluaXN0cmFkb3IifX0.VIgjO1nhbyWSNQ5NlAevAig6bMQYqzFa5wfcDEbpau4"
}
</br>
</br>

**RECURSO # 2:** Obtener todos los recursos que se han subido a la plataforma</br>
**URL:** http://localhost:8080/recursos/getAll</br>
**VERBO:** GET</br>
**CONSUME:**</br>
**PRODUCE:** 
[
    {
        "id": 1,
        "nombreRecurso": "dsadasasd",
        "nombreArchivo": "1Matriz DOFA.pdf",
        "tipoArchivo": "application/pdf",
        "tamaño": 741221,
        "ruta": "http://localhost:8080/recursos/descargar_recurso/1Matriz%20DOFA.pdf",
        "materia": {
            "id": 1,
            "nombre": "Matematicas"
        },
        "curso": {
            "id": 2,
            "descripcion": "Kinder"
        },
        "usuario": {
            "id": 2,
            "nickName": "profesor",
            "contraseña": "",
            "nombres": "Profesor",
            "apellidos": "Prueba",
            "rol": {
                "id": 2,
                "descripcion": "Docente"
            }
        }
    }
]
</br>
</br>

**RECURSO # 3:** Obtener solo un recurso con el id</br>
**URL:** http://localhost:8080/recursos/obtener/{id}</br>
**VERBO:** GET</br>
**CONSUME:**</br>
**PRODUCE:** 
{
    "id": 1,
    "nombreRecurso": "dsadasasd",
    "nombreArchivo": "1Matriz DOFA.pdf",
    "tipoArchivo": "application/pdf",
    "tamaño": 741221,
    "ruta": "http://localhost:8080/recursos/descargar_recurso/1Matriz%20DOFA.pdf",
    "materia": {
        "id": 1,
        "nombre": "Matematicas"
    },
    "curso": {
        "id": 2,
        "descripcion": "Kinder"
    },
    "usuario": {
        "id": 2,
        "nickName": "profesor",
        "contraseña": "123",
        "nombres": "Profesor",
        "apellidos": "Prueba",
        "rol": {
            "id": 2,
            "descripcion": "Docente"
        }
    }
}
</br>
</br>

**RECURSO # 4:** Descargar archivo asociado a un recurso usando la ruta guardada en el</br>
**URL:** http://localhost:8080/recursos/descargar_recurso/2Horario%202021-3.pdf</br>
**VERBO:** GET</br>
**CONSUME:**</br>
**PRODUCE:** ***importante: ya debe existir algun recurso en la BD*** </br>
![This is an image](https://github.com/Jank1510/Proyecto-Mision-Tic-2022/blob/backend/Imagenes/Descarga%20de%20archivo.png)
</br>
</br>

**RECURSO # 5:** Obtiene todas las noticias que estan en la base de datos</br>
**URL:** http://localhost:8080/noticias/getAll</br>
**VERBO:** GET</br>
**CONSUME:**</br>
**PRODUCE:**
[
    {
        "id": 3,
        "tituloNoticia": "asfsdvsdfv",
        "nombreImagen": "12018-03-12 14.43.06.jpg",
        "fecha": "2021-11-30",
        "ruta": "http://localhost:8080/noticias/getImg/12018-03-12%2014.43.06.jpg",
        "descripcion": "asdsadsad"
    }
]</br>

**Nota:** la ruta se puede utilizar para utilizar la imagen de la noticia en una etiqueta HTML

</br>
</br>

**RECURSO # 6:** Obtiene los roles que existen</br>
**URL:** http://localhost:8080/roles</br>
**VERBO:** GET</br>
**CONSUME:**</br>
**PRODUCE:**
[
    {
        "id": 1,
        "descripcion": "Administrador"
    },
    {
        "id": 2,
        "descripcion": "Docente"
    }
]

</br>
</br>

**RECURSO # 7:** Agrega una sugerencia, es el servicio que se tiene para el canal PQRS</br>
**URL:** http://localhost:8080/sugerencias/add</br>
**VERBO:** POST</br>
**CONSUME:**{
    "nombresApellidos":"Alvaro Zarabanda",
	"correo":"alvaroalejo25@gmail.com",
	"mensaje":"Esto es una sugerencia para el colegio"
}
</br>
**PRODUCE:**
{
    "id": 4,
    "nombresApellidos": "Alvaro Zarabanda",
    "correo": "alvaroalejo25@gmail.com",
    "mensaje": "Esto es una sugerencia para el colegio"
}
</br>
</br>

**RECURSO # 8:** Obtiene todas las materias que existen en la BD</br>
**URL:** http://localhost:8080/materias</br>
**VERBO:** GET</br>
**CONSUME:**
</br>
**PRODUCE:**
[
    {
        "id": 1,
        "nombre": "Matematicas"
    },
    {
        "id": 2,
        "nombre": "Español"
    },
    {
        "id": 3,
        "nombre": "Sociales"
    },
    {
        "id": 4,
        "nombre": "Musica"
    },
    {
        "id": 5,
        "nombre": "Ingles"
    }
]
</br>
</br>

**RECURSO # 9:** Obtiene todos los cursos que estan en la BD</br>
**URL:** http://localhost:8080/cursos</br>
**VERBO:** GET</br>
**CONSUME:**{
</br>
**PRODUCE:**
[
    {
        "id": 1,
        "descripcion": "Pre Kinder"
    },
    {
        "id": 2,
        "descripcion": "Kinder"
    },
    {
        "id": 3,
        "descripcion": "Transicion"
    },
    {
        "id": 4,
        "descripcion": "Primero"
    },
    {
        "id": 5,
        "descripcion": "Segundo"
    },
    {
        "id": 6,
        "descripcion": "Tercero"
    },
    {
        "id": 7,
        "descripcion": "Cuarto"
    },
    {
        "id": 8,
        "descripcion": "Quinto"
    }
]
</br>
</br>

**RECURSO # 10:** Obtener una noticia con un id</br>
**URL:** http://localhost:8080/noticias/obtener/{id}</br>
**VERBO:** GET</br>
**CONSUME:**
</br>
**PRODUCE:**
{
    "id": 3,
    "tituloNoticia": "asfsdvsdfv",
    "nombreImagen": "12018-03-12 14.43.06.jpg",
    "fecha": "2021-11-30",
    "ruta": "http://localhost:8080/noticias/getImg/12018-03-12%2014.43.06.jpg",
    "descripcion": "asdsadsad"
}</br>
**Nota:** la ruta se puede utilizar para utilizar la imagen de la noticia en una etiqueta HTML
</br>
</br>


# ***Recursos que necesitan token de Administrador***

> Tener en cuenta enviar el token en el header Authorization, Ejemplo: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcm9mZXNvciIsImlhdCI6MTYzODMwMzAyOCwiZXhwIjoxNjM4MzAzOTI4LCJuaWNrTmFtZSI6InByb2Zlc29yIiwicm9sIjp7ImlkIjoyLCJkZXNjcmlwY2lvbiI6IkRvY2VudGUifX0.Js0hw5YNhaGSIVUOrIp12hNg7bsSDUpGddshQqTBu5o

**RECURSO # 11:** Eliminar usuario por id</br>
**URL:** http://localhost:8080/noticias/obtener/{id}</br>
**VERBO:** DELETE</br>
**CONSUME:**
</br>
**PRODUCE:**
"Usuario eliminado"</br>
</br>
</br>

**RECURSO # 12:** Agregar usuario</br>
**URL:** http://localhost:8080/usuarios/agregar</br>
**VERBO:** POST</br>
**CONSUME:**
{
    "nickName": "profesor4",
    "contraseña": "contraseña",
    "nombres": "Juan",
    "apellidos": "Perez",
    "rol": {
        "id": 2
    }
}
</br>
**PRODUCE:**
{"id":6,"nickName":"profesor4","contraseña":"","nombres":"Juan","apellidos":"Perez","rol":{"id":2}}</br>
</br>
</br>

**RECURSO # 13:** Obtiene una sugerencia"canal PQRS" de la base de datos con un id</br>
**URL:** http://localhost:8080/sugerencias/get/{id}</br>
**VERBO:** GET</br>
**CONSUME:**
</br>
**PRODUCE:**
{
    "id": 2,
    "nombresApellidos": "Alvaro Zarabanda",
    "correo": "alvaroalejo25@gmail.com",
    "mensaje": "Esto es una sugerencia para el colegio"
}
</br>
</br>

**RECURSO # 14:** Obtiene todas las sugerencias"canal PQRS" de la base de datos</br>
**URL:** http://localhost:8080/sugerencias</br>
**VERBO:** GET</br>
**CONSUME:**
</br>
**PRODUCE:**
[
    {
        "id": 1,
        "nombresApellidos": "Alvaro Zarabanda",
        "correo": "alvaroalejo25@gmail.com",
        "mensaje": "Esto es una sugerencia para el colegio"
    },
    {
        "id": 2,
        "nombresApellidos": "Alvaro Zarabanda",
        "correo": "alvaroalejo25@gmail.com",
        "mensaje": "Esto es una sugerencia para el colegio"
    },
    {
        "id": 3,
        "nombresApellidos": "Alvaro Zarabanda",
        "correo": "alvaroalejo25@gmail.com",
        "mensaje": "Esto es una sugerencia para el colegio"
    },
    {
        "id": 4,
        "nombresApellidos": "Alvaro Zarabanda",
        "correo": "alvaroalejo25@gmail.com",
        "mensaje": "Esto es una sugerencia para el colegio"
    }
]
</br>
</br>



**RECURSO # 15:** Obtiene todos los usuarios que estan en la base de datos</br>
**URL:** http://localhost:8080/usuarios/getAll</br>
**VERBO:** GET</br>
**CONSUME:**
</br>
**PRODUCE:**
[
    {
        "id": 1,
        "nickName": "admin",
        "contraseña": "",
        "nombres": "Administrador",
        "apellidos": "Chiquitines",
        "rol": {
            "id": 1,
            "descripcion": "Administrador"
        }
    },
    {
        "id": 2,
        "nickName": "profesor",
        "contraseña": "",
        "nombres": "Profesor",
        "apellidos": "Prueba",
        "rol": {
            "id": 2,
            "descripcion": "Docente"
        }
    },
    {
        "id": 5,
        "nickName": "profesor3",
        "contraseña": "",
        "nombres": "Juan",
        "apellidos": "Perez",
        "rol": {
            "id": 2,
            "descripcion": "Docente"
        }
    },
    {
        "id": 6,
        "nickName": "profesor4",
        "contraseña": "",
        "nombres": "Juan",
        "apellidos": "Perez",
        "rol": {
            "id": 2,
            "descripcion": "Docente"
        }
    }
]
</br>
</br>

**RECURSO # 16:** Sube una noticia a la base de datos</br>
**URL:** http://localhost:8080/noticias/subir_noticia</br>
**VERBO:** POST</br>
**CONSUME:** Se requieren los siguientes parametros:</br>
![This is an image](https://github.com/Jank1510/Proyecto-Mision-Tic-2022/blob/backend/Imagenes/Subir%20noticia.png)
</br>
donde en imagen, se debe adjuntar una imagen en formato .jpg </br>
en noticia se debe subir un json: {
    "tituloNoticia": "asfsdvsdfv",  
  "descripcion": "asdsadsad"
}
</br>
**PRODUCE:**
{
    "id": 4,
    "tituloNoticia": "asfsdvsdfv",
    "nombreImagen": "42018-03-12 14.43.06.jpg",
    "fecha": "2021-11-30",
    "ruta": "http://localhost:8080/noticias/getImg/42018-03-12%2014.43.06.jpg",
    "descripcion": "asdsadsad"
}
</br>
</br>

**RECURSO # 17:** Elimina una noticia en el id</br>
**URL:** http://localhost:8080/noticias/delete/{id}</br>
**VERBO:** DELETE</br>
**CONSUME:**
</br>
**PRODUCE:**
"Noticia eliminada"
</br>
</br>

**RECURSO # 18:** Agrega una materia a la base de datos</br>
**URL:** http://localhost:8080/materias/add</br>
**VERBO:** POST</br>
**CONSUME:**
{
    "nombre":"Artes"
}
</br>
**PRODUCE:**
{
    "id": 7,
    "nombre": "Artes"
}
</br>
</br>

**RECURSO # 19:** Elimina una materia de la base de datos</br>
**URL:** http://localhost:8080/materias/delete/{id}</br>
**VERBO:** DELETE</br>
**CONSUME:**
</br>
**PRODUCE:**
"Materia eliminada"
</br>
</br>

**RECURSO # 20:** Agrega un nuevo curso a la bd</br>
**URL:** http://localhost:8080/cursos/add</br>
**VERBO:** POST</br>
**CONSUME:**
</br>
**PRODUCE:**
{
    "id": 10,
    "descripcion": "Dibujo"
}
</br>
</br>

**RECURSO # 21:** Agrega un nuevo curso a la bd</br>
**URL:** http://localhost:8080/cursos/add</br>
**VERBO:** POST</br>
**CONSUME:**
</br>
**PRODUCE:**
{
    "id": 10,
    "descripcion": "Dibujo"
}
</br>
</br>

**RECURSO # 22:** Borra un curso de la bd</br>
**URL:** http://localhost:8080/cursos/delete/9</br>
**VERBO:** DELETE</br>
**CONSUME:**
</br>
**PRODUCE:**
"Curso eliminado"
</br>
</br>


# ***Recursos que necesitan token de Docente***

> Tener en cuenta enviar el token en el header Authorization, Ejemplo: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcm9mZXNvciIsImlhdCI6MTYzODMwMzAyOCwiZXhwIjoxNjM4MzAzOTI4LCJuaWNrTmFtZSI6InByb2Zlc29yIiwicm9sIjp7ImlkIjoyLCJkZXNjcmlwY2lvbiI6IkRvY2VudGUifX0.Js0hw5YNhaGSIVUOrIp12hNg7bsSDUpGddshQqTBu5o

**RECURSO # 23:** Sube un recurso a la base de datos</br>
**URL:** http://localhost:8080/recursos/subir_recurso</br>
**VERBO:** POST</br>
**CONSUME:**
</br>
**PRODUCE:**
"Curso eliminado"
</br>
</br>
