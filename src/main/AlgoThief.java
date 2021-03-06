/**
 * AlgoThief.java
 * 
 * Copyright 2014 
 * 	Gabriela Azcona <azconita@gmail.com>
 * 	Matias Fernando Vazquez <mfvazquezfiuba@gmail.com>
 *      Federico Torlaschi <fedetorlaschi@gmail.com>
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses>
 * 
 */

package main;

import modelo.AlgothiefModelo;
import modelo.ErrorAlCrearElJuego;
import vista.AlgothiefVista;
import control.AlgothiefControl;

public class AlgoThief {
	public static void main(String[] args) throws ErrorAlCrearElJuego{
		AlgothiefModelo modelo = new AlgothiefModelo();
		AlgothiefVista vista = new AlgothiefVista(modelo);
		new AlgothiefControl(vista, modelo);
		vista.mostrar();
	}
}
