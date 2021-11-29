package com.misiontic2022.apichiquitines.util;


import com.misiontic2022.apichiquitines.model.Curso;
import com.misiontic2022.apichiquitines.model.Materia;
import com.misiontic2022.apichiquitines.model.Usuario;

public class RecursoUtil {
	    private Materia materia;
	    private Curso curso;
	    private Usuario usuario;
	    
		public RecursoUtil(Materia materia, Curso curso, Usuario usuario) {
			super();
			this.materia = materia;
			this.curso = curso;
			this.usuario = usuario;
		}

		public RecursoUtil() {
			super();
		}

		public Materia getMateria() {
			return materia;
		}

		public void setMateria(Materia materia) {
			this.materia = materia;
		}

		public Curso getCurso() {
			return curso;
		}

		public void setCurso(Curso curso) {
			this.curso = curso;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		
	   
	    
	    
}
