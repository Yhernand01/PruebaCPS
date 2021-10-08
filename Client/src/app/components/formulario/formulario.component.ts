import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { PaisService } from 'src/app/services/pais.service';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent{
  cc: any
  paises: any
  cliente: any
  nombre: string = 'Cliente/Valor descuento'
  paisOrigen: string = 'Origen'
  resultadoMensaje: string = 'Aún no se genera cotización'
  paisDestino: string = ''
  tarifa: number = 0
  valor_descuento: number  = 0
  resultado: number = 0
  peso: number = 0
  alto: number = 0
  largo: number = 0
  ancho: number = 0
  cargos: number = 0
  descuentos: number = 0
  total: number = 0

  constructor(public fb: FormBuilder,
              private paisService : PaisService, private clienteService: ClienteService){
    this.paisService.getPaises().subscribe(response =>{
      this.paises = response;
    })
  }

  registrationForm = this.fb.group({
    paisName: ['']
  })

  cotizar(paisDestino: any){
    try{
      this.paisService.getTarifa(paisDestino).subscribe( response =>{
        this.tarifa = response.tarifa
        this.cargos = ((this.peso * this.tarifa) + (1.66 * this.alto * this.largo * this.ancho));
        this.descuentos = (this.valor_descuento * 0.5 * this.peso);
        this.resultado = parseFloat((this.cargos - this.descuentos).toFixed(2));
        this.resultadoMensaje = `(${this.peso} * $${this.tarifa}) + (1.66 * ${this.alto} * ${this.largo} * ${this.ancho})
                              - (${this.valor_descuento} * 0.5 * ${this.peso})`;
      })
    }
    catch(error){
      console.log(error)
    }
  }

  buscarCliente(codigo: any){
    try{
      this.clienteService.getCliente(codigo).subscribe(response =>{
        if(response){
          this.cliente = response;
          this.paisOrigen = `País origen: ${this.cliente.paisOrigen}`;
          this.valor_descuento = this.cliente.valorDescuento;
          this.nombre = `Cliente: ${this.cliente.nombre}, Descuento: $${this.valor_descuento}`;
          this.tarifa = this.tarifa;
        }
      })
    }
    catch(err){
      console.log(err)
    }
  }
}
