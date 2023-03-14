import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'CEP'
})
export class CepMaskPipe implements PipeTransform {

  transform(cep: string): any {
    if(cep){
      if (!cep && cep.length < 7) {
        return cep;
      }
      return  `${cep.substring(0,5)}-${cep.substring(5)}`;
    }
    return null;
  }

}
