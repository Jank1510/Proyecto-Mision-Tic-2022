# Proyecto-Mision-Tic-2022

## API REST para la institucion educativa los Chiquitines
### Lista de recursos que ofrece el api rest

Tener en cuenta que la base de datos tiene integridad referencial

***Recursos que no necesitan token***

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
**PRODUCE:** 

</br>
</br>


***Recursos necesitan token de Administrador***



***Recursos necesitan token de Docente***
