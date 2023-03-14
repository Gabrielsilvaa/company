import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'CNPJ'
})
export class CnpjMaskPipe implements PipeTransform {

  transform(cnpj: string): any {
    if(cnpj){
      if (!cnpj && cnpj.length < 10) {
        return cnpj;
      }
        return  `${cnpj.substring(0,2)}.${cnpj.substring(2, 5)}.${cnpj.substring(5, 8)}/${cnpj.substring(8, 12)}-${cnpj.substring(12)}`;
    }
    return null;
  }
}
